package com.jobfinder.model;

import java.util.Date;

/**
 * Resume model class
 * Represents a user's resume in the system
 */
public class Resume {
    private int id;
    private int userId;
    private String filename;
    private String content;
    private String analysis;
    private float score;
    private boolean isCurrent;
    private Date createdAt;
    private Date updatedAt;
    
    // Constructors
    public Resume() {
    }
    
    public Resume(int id, int userId, String filename, String content, 
                 String analysis, float score, boolean isCurrent) {
        this.id = id;
        this.userId = userId;
        this.filename = filename;
        this.content = content;
        this.analysis = analysis;
        this.score = score;
        this.isCurrent = isCurrent;
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
    
    public String getFilename() {
        return filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getAnalysis() {
        return analysis;
    }
    
    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
    
    public float getScore() {
        return score;
    }
    
    public void setScore(float score) {
        this.score = score;
    }
    
    public boolean isCurrent() {
        return isCurrent;
    }
    
    public void setCurrent(boolean current) {
        isCurrent = current;
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
        return "Resume{" +
                "id=" + id +
                ", userId=" + userId +
                ", filename='" + filename + '\'' +
                ", score=" + score +
                ", isCurrent=" + isCurrent +
                '}';
    }
}
