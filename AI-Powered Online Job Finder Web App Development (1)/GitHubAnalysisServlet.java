package com.jobfinder.controller.github;

import com.jobfinder.dao.GitHubRepositoryDAO;
import com.jobfinder.model.GitHubRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Servlet for handling GitHub repository analysis
 */
@WebServlet("/api/github/analyze")
public class GitHubAnalysisServlet extends HttpServlet {
    
    private GitHubRepositoryDAO gitHubRepositoryDAO;
    private Gson gson;
    
    @Override
    public void init() throws ServletException {
        super.init();
        gitHubRepositoryDAO = new GitHubRepositoryDAO();
        gson = new Gson();
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
            
            // Parse request body
            StringBuilder buffer = new StringBuilder();
            String line;
            while ((line = request.getReader().readLine()) != null) {
                buffer.append(line);
            }
            
            JsonObject requestBody = gson.fromJson(buffer.toString(), JsonObject.class);
            String repoUrl = requestBody.get("repository_url").getAsString();
            
            // Validate GitHub URL
            if (!isValidGitHubUrl(repoUrl)) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Invalid GitHub repository URL");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(jsonResponse.toString());
                return;
            }
            
            // Extract repository information
            String[] repoInfo = extractRepositoryInfo(repoUrl);
            String username = repoInfo[0];
            String repoName = repoInfo[1];
            
            // Analyze repository (mock implementation for now)
            JsonObject analysis = analyzeGitHubRepository(username, repoName);
            
            // Save repository to database
            GitHubRepository repository = new GitHubRepository();
            repository.setUserId(userId);
            repository.setRepoUrl(repoUrl);
            repository.setRepoName(repoName);
            repository.setDescription(analysis.get("description").getAsString());
            repository.setAnalysis(analysis.toString());
            repository.setLanguages(analysis.get("languages").toString());
            repository.setCodeQualityScore(analysis.get("codeQualityScore").getAsFloat());
            
            int repoId = gitHubRepositoryDAO.createGitHubRepository(repository);
            
            if (repoId > 0) {
                // Return success response
                jsonResponse.addProperty("success", true);
                jsonResponse.addProperty("message", "Repository analyzed successfully");
                jsonResponse.addProperty("repositoryId", repoId);
                jsonResponse.add("analysis", analysis);
                
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Failed to save repository analysis to database");
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
    
    /**
     * Validate if a URL is a valid GitHub repository URL
     * @param url URL to validate
     * @return true if valid, false otherwise
     */
    private boolean isValidGitHubUrl(String url) {
        String regex = "^https?://github\\.com/[\\w-]+/[\\w.-]+/?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
    
    /**
     * Extract username and repository name from GitHub URL
     * @param url GitHub repository URL
     * @return Array containing [username, repositoryName]
     */
    private String[] extractRepositoryInfo(String url) {
        // Remove trailing slash if present
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        
        // Split URL by '/'
        String[] parts = url.split("/");
        
        // Extract username and repository name
        String username = parts[parts.length - 2];
        String repoName = parts[parts.length - 1];
        
        return new String[] {username, repoName};
    }
    
    /**
     * Analyze GitHub repository (mock implementation)
     * @param username GitHub username
     * @param repoName Repository name
     * @return Analysis results as JsonObject
     */
    private JsonObject analyzeGitHubRepository(String username, String repoName) {
        // This is a mock implementation
        // In a real application, this would use GitHub API and code analysis libraries
        
        JsonObject analysis = new JsonObject();
        
        // Mock repository information
        analysis.addProperty("owner", username);
        analysis.addProperty("name", repoName);
        analysis.addProperty("description", "A sample repository for demonstration");
        analysis.addProperty("stars", 25);
        analysis.addProperty("forks", 10);
        
        // Mock code quality metrics
        analysis.addProperty("codeQualityScore", 85);
        analysis.addProperty("maintainabilityIndex", 78);
        analysis.addProperty("complexityScore", 65);
        analysis.addProperty("documentationScore", 70);
        
        // Mock languages
        JsonObject languages = new JsonObject();
        languages.addProperty("Java", 60);
        languages.addProperty("JavaScript", 25);
        languages.addProperty("HTML", 10);
        languages.addProperty("CSS", 5);
        analysis.add("languages", languages);
        
        // Mock strengths
        JsonObject strengths = new JsonObject();
        strengths.addProperty("codeStructure", "Well-structured codebase");
        strengths.addProperty("modernFeatures", "Good use of modern Java features");
        strengths.addProperty("responsiveDesign", "Responsive design implementation");
        strengths.addProperty("errorHandling", "Proper error handling");
        analysis.add("strengths", strengths);
        
        // Mock improvement areas
        JsonObject improvements = new JsonObject();
        improvements.addProperty("testCoverage", "Increase test coverage");
        improvements.addProperty("documentation", "Add more inline documentation");
        improvements.addProperty("databaseQueries", "Optimize database queries");
        improvements.addProperty("inputValidation", "Implement more robust input validation");
        analysis.add("improvements", improvements);
        
        return analysis;
    }
}
