package com.jobfinder.controller.job;

import com.jobfinder.ai.JobMatchingEngine;
import com.jobfinder.dao.JobDAO;
import com.jobfinder.dao.ResumeDAO;
import com.jobfinder.model.Job;
import com.jobfinder.model.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet for handling job matches and recommendations
 */
@WebServlet("/api/jobs/matches")
public class JobMatchesServlet extends HttpServlet {
    
    private JobDAO jobDAO;
    private ResumeDAO resumeDAO;
    private JobMatchingEngine jobMatchingEngine;
    private Gson gson;
    
    @Override
    public void init() throws ServletException {
        super.init();
        jobDAO = new JobDAO();
        resumeDAO = new ResumeDAO();
        jobMatchingEngine = new JobMatchingEngine();
        gson = new Gson();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
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
            
            // Get user's current resume
            Resume resume = resumeDAO.getCurrentResumeByUserId(userId);
            
            if (resume == null) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "No resume found. Please upload a resume first.");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(jsonResponse.toString());
                return;
            }
            
            // Extract skills from resume analysis
            List<String> userSkills = extractSkillsFromAnalysis(resume.getAnalysis());
            
            // Get job title and location from request parameters or use defaults
            String jobTitle = request.getParameter("jobTitle");
            if (jobTitle == null || jobTitle.trim().isEmpty()) {
                jobTitle = "Java Developer"; // Default job title
            }
            
            String location = request.getParameter("location");
            if (location == null || location.trim().isEmpty()) {
                location = "Remote"; // Default location
            }
            
            // Get job matches
            List<Job> jobMatches = jobMatchingEngine.findJobMatches(userSkills, jobTitle, location);
            
            // Get platform recommendations
            Map<String, Integer> platformRecommendations = jobMatchingEngine.getRecommendedPlatforms(jobTitle, location);
            
            // Convert job matches to JSON
            JsonArray matchesArray = new JsonArray();
            for (Job job : jobMatches) {
                JsonObject jobObject = new JsonObject();
                jobObject.addProperty("id", job.getId());
                jobObject.addProperty("title", job.getTitle());
                jobObject.addProperty("company", job.getCompany());
                jobObject.addProperty("location", job.getLocation());
                jobObject.addProperty("description", job.getDescription());
                jobObject.addProperty("requirements", job.getRequirements());
                jobObject.addProperty("salaryRange", job.getSalaryRange());
                jobObject.addProperty("jobType", job.getJobType());
                jobObject.addProperty("sourcePlatform", job.getSourcePlatform());
                jobObject.addProperty("sourceUrl", job.getSourceUrl());
                jobObject.addProperty("postedDate", job.getPostedDate().toString());
                jobObject.addProperty("matchScore", job.getMatchScore());
                
                matchesArray.add(jobObject);
            }
            
            // Convert platform recommendations to JSON
            JsonObject platformsObject = new JsonObject();
            for (Map.Entry<String, Integer> entry : platformRecommendations.entrySet()) {
                platformsObject.addProperty(entry.getKey(), entry.getValue());
            }
            
            // Return success response
            jsonResponse.addProperty("success", true);
            jsonResponse.add("matches", matchesArray);
            jsonResponse.add("recommendedPlatforms", platformsObject);
            jsonResponse.addProperty("jobTitle", jobTitle);
            jsonResponse.addProperty("location", location);
            
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            jsonResponse.addProperty("success", false);
            jsonResponse.addProperty("message", "An error occurred: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        
        out.print(jsonResponse.toString());
    }
    
    /**
     * Extract skills from resume analysis JSON
     * @param analysisJson Resume analysis JSON string
     * @return List of skills
     */
    private List<String> extractSkillsFromAnalysis(String analysisJson) {
        List<String> skills = new ArrayList<>();
        
        try {
            JsonObject analysis = gson.fromJson(analysisJson, JsonObject.class);
            JsonArray skillsArray = analysis.getAsJsonArray("skills");
            
            for (int i = 0; i < skillsArray.size(); i++) {
                skills.add(skillsArray.get(i).getAsString());
            }
        } catch (Exception e) {
            // If there's an error parsing the JSON, return some default skills
            skills = Arrays.asList("Java", "JSP", "Servlet", "JDBC", "SQL", "HTML", "CSS", "JavaScript");
        }
        
        return skills;
    }
}
