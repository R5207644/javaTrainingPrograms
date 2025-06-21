package com.jobfinder.model;

import java.util.Date;

/**
 * GitHubRepository model class
 * Represents a user's GitHub repository in the system
 */
public class GitHubRepository {
    private int id;
    private int userId;
    private String repoUrl;
    private String repoName;
    private String description;
    private String analysis;
    private String languages;
    private float codeQualityScore;
    private Date createdAt;
    private Date updatedAt;
    
    // Constructors
    public GitHubRepository() {
    }
    
    public GitHubRepository(int id, int userId, String repoUrl, String repoName, 
                           String description, String analysis, String languages, 
                           float codeQualityScore) {
        this.id = id;
        this.userId = userId;
        this.repoUrl = repoUrl;
        this.repoName = repoName;
        this.description = description;
        this.analysis = analysis;
        this.languages = languages;
        this.codeQualityScore = codeQualityScore;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getRepoUrl() {
        return repoUrl;
    }
    
    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }
    
    public String getRepoName() {
        return repoName;
    }
    
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getAnalysis() {
        return analysis;
    }
    
    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
    
    public String getLanguages() {
        return languages;
    }
    
    public void setLanguages(String languages) {
        this.languages = languages;
    }
    
    public float getCodeQualityScore() {
        return codeQualityScore;
    }
    
    public void setCodeQualityScore(float codeQualityScore) {
        this.codeQualityScore = codeQualityScore;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @Override
    public String toString() {
        return "GitHubRepository{" +
                "id=" + id +
                ", userId=" + userId +
                ", repoUrl='" + repoUrl + '\'' +
                ", repoName='" + repoName + '\'' +
                ", codeQualityScore=" + codeQualityScore +
                '}';
    }
}
