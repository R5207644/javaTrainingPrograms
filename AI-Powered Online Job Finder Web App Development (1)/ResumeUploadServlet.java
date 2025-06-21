package com.jobfinder.controller.resume;

import com.jobfinder.ai.ResumeAnalyzer;
import com.jobfinder.dao.ResumeDAO;
import com.jobfinder.dao.UserDAO;
import com.jobfinder.model.Resume;
import com.jobfinder.model.User;
import com.jobfinder.util.PDFUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet for handling resume uploads and analysis
 */
@WebServlet("/api/resume/upload")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1 MB
    maxFileSize = 10 * 1024 * 1024,  // 10 MB
    maxRequestSize = 15 * 1024 * 1024 // 15 MB
)
public class ResumeUploadServlet extends HttpServlet {
    
    private ResumeDAO resumeDAO;
    private UserDAO userDAO;
    private ResumeAnalyzer resumeAnalyzer;
    private String uploadDir;
    
    @Override
    public void init() throws ServletException {
        super.init();
        resumeDAO = new ResumeDAO();
        userDAO = new UserDAO();
        resumeAnalyzer = new ResumeAnalyzer();
        
        // Set upload directory
        uploadDir = getServletContext().getRealPath("/WEB-INF/uploads/resumes");
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JsonObject jsonResponse = new JsonObject();
        
        try {
            // Check if user is logged in
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("userId") == null) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "User not authenticated");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.print(jsonResponse.toString());
                return;
            }
            
            int userId = (int) session.getAttribute("userId");
            User user = userDAO.getUserById(userId);
            
            if (user == null) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "User not found");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(jsonResponse.toString());
                return;
            }
            
            // Get the uploaded file
            Part filePart = request.getPart("resume");
            
            if (filePart == null) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "No file uploaded");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(jsonResponse.toString());
                return;
            }
            
            // Check if the file is a PDF
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (!fileName.toLowerCase().endsWith(".pdf")) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Only PDF files are supported");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(jsonResponse.toString());
                return;
            }
            
            // Generate a unique file name
            String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
            String filePath = uploadDir + File.separator + uniqueFileName;
            
            // Save the file
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            }
            
            // Extract text from PDF
            String resumeText = PDFUtil.extractTextFromPDF(filePath);
            
            // Analyze the resume
            File pdfFile = new File(filePath);
            String analysisJson = resumeAnalyzer.analyzeResume(pdfFile);
            
            // Calculate resume score
            JsonObject analysis = JsonParser.parseString(analysisJson).getAsJsonObject();
            float resumeScore = resumeAnalyzer.calculateResumeScore(resumeText, PDFUtil.extractSkillsFromText(resumeText));
            
            // Create a new Resume object
            Resume resume = new Resume();
            resume.setUserId(userId);
            resume.setFileName(uniqueFileName);
            resume.setFilePath(filePath);
            resume.setContent(resumeText);
            resume.setAnalysis(analysisJson);
            resume.setScore(resumeScore);
            resume.setUploadDate(new Date());
            
            // Save the resume to the database
            int resumeId = resumeDAO.addResume(resume);
            
            if (resumeId > 0) {
                // Add resume score to the analysis JSON
                analysis.addProperty("score", resumeScore);
                
                // Return success response
                jsonResponse.addProperty("success", true);
                jsonResponse.addProperty("message", "Resume uploaded and analyzed successfully");
                jsonResponse.addProperty("resumeId", resumeId);
                jsonResponse.add("analysis", analysis);
                
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Failed to save resume to database");
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            jsonResponse.addProperty("success", false);
            jsonResponse.addProperty("message", "An error occurred: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        
        out.print(jsonResponse.toString());
    }
}
