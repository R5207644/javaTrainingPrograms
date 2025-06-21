package com.jobfinder.ai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jobfinder.model.Job;

/**
 * AI-powered job matching and recommendation engine
 * Scrapes job listings and matches them to user skills
 */
public class JobMatchingEngine {
    
    // Job platforms to search
    private static final List<String> JOB_PLATFORMS = Arrays.asList(
        "LinkedIn", "Naukri", "Indeed", "Glassdoor", "Monster"
    );
    
    /**
     * Find job matches based on user skills and preferences
     * @param skills List of user skills
     * @param jobTitle Preferred job title
     * @param location Preferred location
     * @return List of matching jobs
     */
    public List<Job> findJobMatches(List<String> skills, String jobTitle, String location) {
        List<Job> allJobs = new ArrayList<>();
        
        // Search jobs across multiple platforms
        for (String platform : JOB_PLATFORMS) {
            try {
                List<Job> platformJobs = scrapeJobListings(jobTitle, location, platform);
                allJobs.addAll(platformJobs);
            } catch (Exception e) {
                System.err.println("Error scraping jobs from " + platform + ": " + e.getMessage());
            }
        }
        
        // Calculate match scores for each job
        for (Job job : allJobs) {
            float matchScore = calculateMatchScore(skills, job);
            // Store match score in the job object (we'll add this field to the Job class)
            job.setMatchScore(matchScore);
        }
        
        // Sort jobs by match score (descending)
        allJobs.sort((a, b) -> Float.compare(b.getMatchScore(), a.getMatchScore()));
        
        return allJobs;
    }
    
    /**
     * Scrape job listings from various platforms
     * @param query Search query
     * @param location Job location
     * @param platform Platform to scrape
     * @return List of Job objects
     */
    private List<Job> scrapeJobListings(String query, String location, String platform) {
        // In a real implementation, this would use JSoup to scrape job listings
        // For this demo, we'll use a mock implementation
        
        List<Job> jobs = new ArrayList<>();
        
        try {
            if (platform.equalsIgnoreCase("LinkedIn")) {
                jobs = mockLinkedInJobs(query, location);
            } else if (platform.equalsIgnoreCase("Naukri")) {
                jobs = mockNaukriJobs(query, location);
            } else if (platform.equalsIgnoreCase("Indeed")) {
                jobs = mockIndeedJobs(query, location);
            } else {
                jobs = mockOtherPlatformJobs(query, location, platform);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jobs;
    }
    
    /**
     * Calculate match score between user skills and job requirements
     * @param userSkills List of user skills
     * @param job Job to match against
     * @return Match score (0-100)
     */
    private float calculateMatchScore(List<String> userSkills, Job job) {
        // Extract skills from job requirements
        String requirements = job.getRequirements().toLowerCase();
        int matchCount = 0;
        int totalSkills = userSkills.size();
        
        for (String skill : userSkills) {
            if (requirements.contains(skill.toLowerCase())) {
                matchCount++;
            }
        }
        
        // Calculate score based on matches
        float matchPercentage = (totalSkills > 0) ? ((float) matchCount / totalSkills) * 100 : 0;
        
        // Apply weighting factors
        float baseScore = 50.0f;
        float weightedScore = baseScore + (matchPercentage * 0.5f);
        
        // Ensure score is within bounds
        return Math.min(100.0f, Math.max(0.0f, weightedScore));
    }
    
    /**
     * Mock LinkedIn job listings
     */
    private List<Job> mockLinkedInJobs(String query, String location) {
        List<Job> jobs = new ArrayList<>();
        
        // Mock job 1
        Job job1 = new Job();
        job1.setTitle("Senior Java Developer");
        job1.setCompany("TechCorp Solutions");
        job1.setLocation(location);
        job1.setDescription("We are looking for an experienced Java Developer proficient in JSP, Servlets, JDBC, and database technologies.");
        job1.setRequirements("Java, JSP, Servlets, JDBC, MySQL, 5+ years experience");
        job1.setSalaryRange("$100,000 - $130,000");
        job1.setJobType("Full-time");
        job1.setSourcePlatform("LinkedIn");
        job1.setSourceUrl("https://linkedin.com/jobs/view/senior-java-developer");
        job1.setPostedDate(new Date());
        jobs.add(job1);
        
        // Mock job 2
        Job job2 = new Job();
        job2.setTitle("Frontend Developer");
        job2.setCompany("WebDesign Pro");
        job2.setLocation(location);
        job2.setDescription("Join our team to create beautiful and responsive web interfaces using modern frontend technologies.");
        job2.setRequirements("HTML, CSS, JavaScript, AngularJS, Bootstrap, 3+ years experience");
        job2.setSalaryRange("$80,000 - $100,000");
        job2.setJobType("Full-time");
        job2.setSourcePlatform("LinkedIn");
        job2.setSourceUrl("https://linkedin.com/jobs/view/frontend-developer");
        job2.setPostedDate(new Date());
        jobs.add(job2);
        
        return jobs;
    }
    
    /**
     * Mock Naukri job listings
     */
    private List<Job> mockNaukriJobs(String query, String location) {
        List<Job> jobs = new ArrayList<>();
        
        // Mock job 1
        Job job1 = new Job();
        job1.setTitle("Java Developer");
        job1.setCompany("Enterprise Systems Ltd");
        job1.setLocation(location);
        job1.setDescription("Looking for Java developers with experience in JSP, Servlets, and JDBC.");
        job1.setRequirements("Java, JSP, Servlets, JDBC, SQL, 4+ years experience");
        job1.setSalaryRange("15-20 LPA");
        job1.setJobType("Full-time");
        job1.setSourcePlatform("Naukri");
        job1.setSourceUrl("https://naukri.com/jobs/java-developer");
        job1.setPostedDate(new Date());
        jobs.add(job1);
        
        // Mock job 2
        Job job2 = new Job();
        job2.setTitle("Full Stack Developer");
        job2.setCompany("TechSolutions India");
        job2.setLocation(location);
        job2.setDescription("Join our team to build and maintain web applications using Java and JavaScript frameworks.");
        job2.setRequirements("Java, JSP, Servlets, JavaScript, AngularJS, MySQL, 3+ years experience");
        job2.setSalaryRange("18-25 LPA");
        job2.setJobType("Full-time");
        job2.setSourcePlatform("Naukri");
        job2.setSourceUrl("https://naukri.com/jobs/full-stack-developer");
        job2.setPostedDate(new Date());
        jobs.add(job2);
        
        return jobs;
    }
    
    /**
     * Mock Indeed job listings
     */
    private List<Job> mockIndeedJobs(String query, String location) {
        List<Job> jobs = new ArrayList<>();
        
        // Mock job 1
        Job job1 = new Job();
        job1.setTitle("Java Web Developer");
        job1.setCompany("Software Innovations");
        job1.setLocation(location);
        job1.setDescription("We are seeking a Java Web Developer to build and maintain our enterprise applications.");
        job1.setRequirements("Java, JSP, Servlets, JDBC, Tomcat, MySQL, 2+ years experience");
        job1.setSalaryRange("$90,000 - $110,000");
        job1.setJobType("Full-time");
        job1.setSourcePlatform("Indeed");
        job1.setSourceUrl("https://indeed.com/jobs/java-web-developer");
        job1.setPostedDate(new Date());
        jobs.add(job1);
        
        // Mock job 2
        Job job2 = new Job();
        job2.setTitle("UI/UX Developer");
        job2.setCompany("Creative Designs Inc");
        job2.setLocation(location);
        job2.setDescription("Looking for a talented UI/UX developer to create intuitive and engaging user experiences.");
        job2.setRequirements("HTML, CSS, JavaScript, AngularJS, Bootstrap, UI/UX Design, 3+ years experience");
        job2.setSalaryRange("$85,000 - $105,000");
        job2.setJobType("Full-time");
        job2.setSourcePlatform("Indeed");
        job2.setSourceUrl("https://indeed.com/jobs/ui-ux-developer");
        job2.setPostedDate(new Date());
        jobs.add(job2);
        
        return jobs;
    }
    
    /**
     * Mock job listings from other platforms
     */
    private List<Job> mockOtherPlatformJobs(String query, String location, String platform) {
        List<Job> jobs = new ArrayList<>();
        
        // Mock job 1
        Job job1 = new Job();
        job1.setTitle("Java Backend Developer");
        job1.setCompany("Tech Innovators");
        job1.setLocation(location);
        job1.setDescription("Join our backend team to develop robust and scalable Java applications.");
        job1.setRequirements("Java, JSP, Servlets, JDBC, RESTful APIs, 3+ years experience");
        job1.setSalaryRange("$95,000 - $120,000");
        job1.setJobType("Full-time");
        job1.setSourcePlatform(platform);
        job1.setSourceUrl("https://" + platform.toLowerCase() + ".com/jobs/java-backend-developer");
        job1.setPostedDate(new Date());
        jobs.add(job1);
        
        return jobs;
    }
    
    /**
     * Real implementation of web scraping (commented out for mock version)
     * This would be used in a production environment
     */
    /*
    private List<Job> scrapeLinkedInJobs(String query, String location) {
        List<Job> jobs = new ArrayList<>();
        
        try {
            // Construct URL
            String url = "https://www.linkedin.com/jobs/search/?keywords=" + 
                         query.replace(" ", "%20") + 
                         "&location=" + location.replace(" ", "%20");
            
            // Connect to the page
            Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                .get();
            
            // Extract job listings
            Elements jobElements = doc.select(".job-search-card");
            
            for (Element jobElement : jobElements) {
                Job job = new Job();
                
                job.setTitle(jobElement.select(".job-search-card__title").text());
                job.setCompany(jobElement.select(".job-search-card__subtitle").text());
                job.setLocation(jobElement.select(".job-search-card__location").text());
                
                String jobUrl = jobElement.select("a").attr("href");
                job.setSourceUrl(jobUrl);
                
                // Get detailed job info
                Document jobDoc = Jsoup.connect(jobUrl).get();
                job.setDescription(jobDoc.select(".description__text").text());
                job.setRequirements(jobDoc.select(".description__job-criteria-text").text());
                
                job.setSourcePlatform("LinkedIn");
                job.setPostedDate(new Date());
                
                jobs.add(job);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return jobs;
    }
    */
    
    /**
     * Get recommended job platforms based on job title and location
     * @param jobTitle Job title
     * @param location Job location
     * @return Map of platform names to recommendation scores
     */
    public Map<String, Integer> getRecommendedPlatforms(String jobTitle, String location) {
        Map<String, Integer> recommendations = new HashMap<>();
        
        // This is a simplified implementation
        // In a real application, this would use historical data and machine learning
        
        if (jobTitle.toLowerCase().contains("java") || 
            jobTitle.toLowerCase().contains("developer") || 
            jobTitle.toLowerCase().contains("engineer")) {
            
            recommendations.put("LinkedIn", 95);
            recommendations.put("Naukri", 90);
            recommendations.put("Indeed", 85);
            recommendations.put("Glassdoor", 80);
            recommendations.put("Monster", 75);
        } else if (jobTitle.toLowerCase().contains("design") || 
                   jobTitle.toLowerCase().contains("ui") || 
                   jobTitle.toLowerCase().contains("ux")) {
            
            recommendations.put("Behance", 95);
            recommendations.put("Dribbble", 90);
            recommendations.put("LinkedIn", 85);
            recommendations.put("Indeed", 80);
            recommendations.put("Glassdoor", 75);
        } else {
            recommendations.put("LinkedIn", 90);
            recommendations.put("Indeed", 85);
            recommendations.put("Glassdoor", 80);
            recommendations.put("Monster", 75);
            recommendations.put("Naukri", 70);
        }
        
        // Adjust based on location
        if (location.toLowerCase().contains("india")) {
            recommendations.put("Naukri", Math.min(100, recommendations.getOrDefault("Naukri", 0) + 15));
            recommendations.put("LinkedIn", Math.min(100, recommendations.getOrDefault("LinkedIn", 0) + 5));
        } else if (location.toLowerCase().contains("remote")) {
            recommendations.put("We Work Remotely", 95);
            recommendations.put("Remote.co", 90);
            recommendations.put("FlexJobs", 85);
        }
        
        return recommendations;
    }
}
