package com.jobfinder.model;

/**
 * Extension of the Job model to include match score
 * This adds the match score field needed for job recommendations
 */
public class Job {
    private int id;
    private String title;
    private String company;
    private String location;
    private String description;
    private String requirements;
    private String salaryRange;
    private String jobType;
    private String sourcePlatform;
    private String sourceUrl;
    private java.util.Date postedDate;
    private java.util.Date createdAt;
    private float matchScore; // Added for job matching
    
    // Constructors
    public Job() {
    }
    
    public Job(int id, String title, String company, String location, String description,
              String requirements, String salaryRange, String jobType, 
              String sourcePlatform, String sourceUrl, java.util.Date postedDate) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.requirements = requirements;
        this.salaryRange = salaryRange;
        this.jobType = jobType;
        this.sourcePlatform = sourcePlatform;
        this.sourceUrl = sourceUrl;
        this.postedDate = postedDate;
        this.createdAt = new java.util.Date();
        this.matchScore = 0.0f;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getRequirements() {
        return requirements;
    }
    
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    
    public String getSalaryRange() {
        return salaryRange;
    }
    
    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
    
    public String getJobType() {
        return jobType;
    }
    
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    
    public String getSourcePlatform() {
        return sourcePlatform;
    }
    
    public void setSourcePlatform(String sourcePlatform) {
        this.sourcePlatform = sourcePlatform;
    }
    
    public String getSourceUrl() {
        return sourceUrl;
    }
    
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    
    public java.util.Date getPostedDate() {
        return postedDate;
    }
    
    public void setPostedDate(java.util.Date postedDate) {
        this.postedDate = postedDate;
    }
    
    public java.util.Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public float getMatchScore() {
        return matchScore;
    }
    
    public void setMatchScore(float matchScore) {
        this.matchScore = matchScore;
    }
    
    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", jobType='" + jobType + '\'' +
                ", sourcePlatform='" + sourcePlatform + '\'' +
                ", matchScore=" + matchScore +
                '}';
    }
}
