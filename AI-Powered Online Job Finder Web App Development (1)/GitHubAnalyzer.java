package com.jobfinder.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * AI-powered GitHub repository analyzer
 * Analyzes code quality, languages, and provides improvement suggestions
 */
public class GitHubAnalyzer {
    
    /**
     * Analyze a GitHub repository
     * @param repoUrl URL of the GitHub repository
     * @return Analysis results as JSON string
     */
    public String analyzeRepository(String repoUrl) {
        try {
            // Extract username and repository name from URL
            String[] repoInfo = extractRepositoryInfo(repoUrl);
            String username = repoInfo[0];
            String repoName = repoInfo[1];
            
            // Get repository information
            JsonObject repoData = getRepositoryInfo(username, repoName);
            
            // Get languages used in the repository
            JsonObject languages = getRepositoryLanguages(username, repoName);
            
            // Analyze code quality
            JsonObject codeQuality = analyzeCodeQuality(username, repoName);
            
            // Combine all data into a single analysis object
            JsonObject analysis = new JsonObject();
            
            // Basic repository information
            analysis.addProperty("owner", username);
            analysis.addProperty("name", repoName);
            analysis.addProperty("description", repoData.get("description").getAsString());
            analysis.addProperty("stars", repoData.get("stargazers_count").getAsInt());
            analysis.addProperty("forks", repoData.get("forks_count").getAsInt());
            
            // Code quality metrics
            analysis.addProperty("codeQualityScore", codeQuality.get("overallScore").getAsFloat());
            analysis.addProperty("maintainabilityIndex", codeQuality.get("maintainabilityIndex").getAsFloat());
            analysis.addProperty("complexityScore", codeQuality.get("complexityScore").getAsFloat());
            analysis.addProperty("documentationScore", codeQuality.get("documentationScore").getAsFloat());
            
            // Languages
            analysis.add("languages", languages);
            
            // Strengths and improvement areas
            analysis.add("strengths", codeQuality.get("strengths").getAsJsonObject());
            analysis.add("improvements", codeQuality.get("improvements").getAsJsonObject());
            
            return analysis.toString();
        } catch (Exception e) {
            e.printStackTrace();
            JsonObject error = new JsonObject();
            error.addProperty("error", "Failed to analyze repository: " + e.getMessage());
            return error.toString();
        }
    }
    
    /**
     * Extract username and repository name from GitHub URL
     * @param repoUrl GitHub repository URL
     * @return Array containing [username, repositoryName]
     */
    private String[] extractRepositoryInfo(String repoUrl) {
        // Remove trailing slash if present
        if (repoUrl.endsWith("/")) {
            repoUrl = repoUrl.substring(0, repoUrl.length() - 1);
        }
        
        // Split URL by '/'
        String[] parts = repoUrl.split("/");
        
        // Extract username and repository name
        String username = parts[parts.length - 2];
        String repoName = parts[parts.length - 1];
        
        return new String[] {username, repoName};
    }
    
    /**
     * Get repository information from GitHub API
     * @param username GitHub username
     * @param repoName Repository name
     * @return Repository information as JsonObject
     * @throws IOException if an error occurs during API call
     */
    private JsonObject getRepositoryInfo(String username, String repoName) throws IOException {
        String apiUrl = "https://api.github.com/repos/" + username + "/" + repoName;
        String response = makeApiRequest(apiUrl);
        return JsonParser.parseString(response).getAsJsonObject();
    }
    
    /**
     * Get languages used in the repository from GitHub API
     * @param username GitHub username
     * @param repoName Repository name
     * @return Languages as JsonObject
     * @throws IOException if an error occurs during API call
     */
    private JsonObject getRepositoryLanguages(String username, String repoName) throws IOException {
        String apiUrl = "https://api.github.com/repos/" + username + "/" + repoName + "/languages";
        String response = makeApiRequest(apiUrl);
        JsonObject languagesData = JsonParser.parseString(response).getAsJsonObject();
        
        // Calculate percentages
        int total = 0;
        for (String key : languagesData.keySet()) {
            total += languagesData.get(key).getAsInt();
        }
        
        JsonObject languagePercentages = new JsonObject();
        for (String key : languagesData.keySet()) {
            int bytes = languagesData.get(key).getAsInt();
            int percentage = (int) Math.round((bytes * 100.0) / total);
            languagePercentages.addProperty(key, percentage);
        }
        
        return languagePercentages;
    }
    
    /**
     * Make HTTP request to GitHub API
     * @param apiUrl API URL
     * @return Response as string
     * @throws IOException if an error occurs during API call
     */
    private String makeApiRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/vnd.github.v3+json");
        
        // Add GitHub token if available
        String githubToken = System.getenv("GITHUB_TOKEN");
        if (githubToken != null && !githubToken.isEmpty()) {
            connection.setRequestProperty("Authorization", "token " + githubToken);
        }
        
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            return response.toString();
        } else {
            throw new IOException("GitHub API request failed with response code: " + responseCode);
        }
    }
    
    /**
     * Analyze code quality of a repository
     * @param username GitHub username
     * @param repoName Repository name
     * @return Code quality analysis as JsonObject
     * @throws IOException if an error occurs during analysis
     */
    private JsonObject analyzeCodeQuality(String username, String repoName) throws IOException {
        // In a real implementation, this would use code analysis libraries
        // For this demo, we'll use a mock implementation
        
        JsonObject codeQuality = new JsonObject();
        
        // Mock code quality metrics
        float overallScore = 75 + (float) (Math.random() * 20);
        float maintainabilityIndex = 70 + (float) (Math.random() * 25);
        float complexityScore = 60 + (float) (Math.random() * 30);
        float documentationScore = 65 + (float) (Math.random() * 25);
        
        codeQuality.addProperty("overallScore", overallScore);
        codeQuality.addProperty("maintainabilityIndex", maintainabilityIndex);
        codeQuality.addProperty("complexityScore", complexityScore);
        codeQuality.addProperty("documentationScore", documentationScore);
        
        // Mock strengths
        JsonObject strengths = new JsonObject();
        strengths.addProperty("codeStructure", "Well-structured codebase with clear separation of concerns");
        strengths.addProperty("modernFeatures", "Good use of modern language features and patterns");
        strengths.addProperty("errorHandling", "Proper error handling and exception management");
        strengths.addProperty("namingConventions", "Consistent naming conventions throughout the codebase");
        
        // Mock improvement areas
        JsonObject improvements = new JsonObject();
        improvements.addProperty("testCoverage", "Increase test coverage for better code reliability");
        improvements.addProperty("documentation", "Add more inline documentation and API documentation");
        improvements.addProperty("codeComplexity", "Reduce complexity in some methods for better maintainability");
        improvements.addProperty("dependencyManagement", "Update and optimize external dependencies");
        
        codeQuality.add("strengths", strengths);
        codeQuality.add("improvements", improvements);
        
        return codeQuality;
    }
    
    /**
     * Get code samples from a repository
     * @param username GitHub username
     * @param repoName Repository name
     * @return List of code samples
     * @throws IOException if an error occurs during API call
     */
    public List<String> getCodeSamples(String username, String repoName) throws IOException {
        // Get repository contents
        String apiUrl = "https://api.github.com/repos/" + username + "/" + repoName + "/contents";
        String response = makeApiRequest(apiUrl);
        JsonArray contents = JsonParser.parseString(response).getAsJsonArray();
        
        List<String> codeSamples = new ArrayList<>();
        
        // Find source code files
        for (int i = 0; i < contents.size(); i++) {
            JsonObject item = contents.get(i).getAsJsonObject();
            String type = item.get("type").getAsString();
            String name = item.get("name").getAsString();
            
            if ("file".equals(type) && isSourceCodeFile(name)) {
                String fileUrl = item.get("download_url").getAsString();
                String code = makeRawRequest(fileUrl);
                codeSamples.add(code);
                
                // Limit to 5 samples
                if (codeSamples.size() >= 5) {
                    break;
                }
            }
        }
        
        return codeSamples;
    }
    
    /**
     * Check if a file is a source code file
     * @param filename Filename to check
     * @return true if it's a source code file, false otherwise
     */
    private boolean isSourceCodeFile(String filename) {
        String[] codeExtensions = {".java", ".js", ".py", ".cpp", ".c", ".cs", ".php", ".rb", ".go", ".ts"};
        for (String ext : codeExtensions) {
            if (filename.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Make HTTP request to raw content URL
     * @param url Raw content URL
     * @return Content as string
     * @throws IOException if an error occurs during request
     */
    private String makeRawRequest(String url) throws IOException {
        URL rawUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) rawUrl.openConnection();
        connection.setRequestMethod("GET");
        
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine).append("\n");
            }
            in.close();
            
            return response.toString();
        } else {
            throw new IOException("Raw content request failed with response code: " + responseCode);
        }
    }
}
