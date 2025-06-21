package com.jobfinder.ai;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

/**
 * AI-powered resume analyzer
 * Extracts and analyzes information from resumes
 */
public class ResumeAnalyzer {
    
    // Common technical skills to look for
    private static final Set<String> TECHNICAL_SKILLS = new HashSet<>(Arrays.asList(
        "java", "jsp", "servlet", "jdbc", "mysql", "sql", "html", "css", "javascript", 
        "angularjs", "bootstrap", "jquery", "react", "node.js", "python", "c++", "c#", 
        "php", "ruby", "swift", "kotlin", "android", "ios", "spring", "hibernate", 
        "docker", "kubernetes", "aws", "azure", "git", "jenkins", "jira", "agile", 
        "scrum", "rest", "soap", "api", "microservices", "nosql", "mongodb", "redis",
        "elasticsearch", "hadoop", "spark", "machine learning", "ai", "data science",
        "blockchain", "devops", "ci/cd", "testing", "junit", "selenium", "cypress"
    ));
    
    // Common soft skills to look for
    private static final Set<String> SOFT_SKILLS = new HashSet<>(Arrays.asList(
        "communication", "teamwork", "leadership", "problem solving", "critical thinking",
        "time management", "adaptability", "flexibility", "creativity", "work ethic",
        "interpersonal", "collaboration", "presentation", "negotiation", "conflict resolution",
        "decision making", "stress management", "emotional intelligence", "customer service",
        "attention to detail", "organization", "planning", "multitasking", "mentoring"
    ));
    
    /**
     * Analyze a resume PDF file
     * @param pdfFile PDF file to analyze
     * @return Analysis results as JSON string
     */
    public String analyzeResume(File pdfFile) {
        try {
            // Extract text from PDF
            String resumeText = extractTextFromPDF(pdfFile);
            
            // Analyze the resume text
            JsonObject analysis = new JsonObject();
            
            // Extract skills
            List<String> skills = extractSkills(resumeText);
            JsonArray skillsArray = new JsonArray();
            for (String skill : skills) {
                skillsArray.add(skill);
            }
            analysis.add("skills", skillsArray);
            
            // Extract experience
            String experienceSummary = extractExperienceSummary(resumeText);
            analysis.addProperty("experienceSummary", experienceSummary);
            
            // Extract education
            String educationSummary = extractEducationSummary(resumeText);
            analysis.addProperty("educationSummary", educationSummary);
            
            // Generate improvement suggestions
            JsonObject suggestions = generateSuggestions(resumeText, skills);
            analysis.add("suggestions", suggestions);
            
            return analysis.toString();
        } catch (IOException e) {
            e.printStackTrace();
            JsonObject error = new JsonObject();
            error.addProperty("error", "Failed to analyze resume: " + e.getMessage());
            return error.toString();
        }
    }
    
    /**
     * Extract text from a PDF file
     * @param pdfFile PDF file to extract text from
     * @return Extracted text
     * @throws IOException if an error occurs during extraction
     */
    private String extractTextFromPDF(File pdfFile) throws IOException {
        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
    
    /**
     * Extract skills from resume text
     * @param resumeText Text content of the resume
     * @return List of skills
     */
    private List<String> extractSkills(String resumeText) {
        Set<String> foundSkills = new HashSet<>();
        String lowerCaseText = resumeText.toLowerCase();
        
        // Check for technical skills
        for (String skill : TECHNICAL_SKILLS) {
            if (lowerCaseText.contains(skill.toLowerCase())) {
                foundSkills.add(skill);
            }
        }
        
        // Check for soft skills
        for (String skill : SOFT_SKILLS) {
            if (lowerCaseText.contains(skill.toLowerCase())) {
                foundSkills.add(skill);
            }
        }
        
        // Look for skills sections
        Pattern skillsSectionPattern = Pattern.compile(
            "(?i)(skills|technical skills|core competencies|technologies)\\s*:?\\s*([\\s\\S]*?)(?=\\n\\s*\\n|\\n\\s*[A-Z]|$)"
        );
        Matcher skillsSectionMatcher = skillsSectionPattern.matcher(resumeText);
        
        if (skillsSectionMatcher.find()) {
            String skillsSection = skillsSectionMatcher.group(2);
            String[] skillItems = skillsSection.split("[,•\\n]");
            
            for (String item : skillItems) {
                String trimmedItem = item.trim();
                if (!trimmedItem.isEmpty() && trimmedItem.length() < 30) {
                    foundSkills.add(trimmedItem);
                }
            }
        }
        
        return new ArrayList<>(foundSkills);
    }
    
    /**
     * Extract experience summary from resume text
     * @param resumeText Text content of the resume
     * @return Experience summary
     */
    private String extractExperienceSummary(String resumeText) {
        // Look for experience sections
        Pattern experienceSectionPattern = Pattern.compile(
            "(?i)(experience|work experience|professional experience|employment)\\s*:?\\s*([\\s\\S]*?)(?=\\n\\s*\\n|\\n\\s*[A-Z]|$)"
        );
        Matcher experienceSectionMatcher = experienceSectionPattern.matcher(resumeText);
        
        if (experienceSectionMatcher.find()) {
            String experienceSection = experienceSectionMatcher.group(2);
            
            // Extract years of experience
            Pattern yearsPattern = Pattern.compile("(\\d+)\\+?\\s+years?");
            Matcher yearsMatcher = yearsPattern.matcher(resumeText);
            
            int years = 0;
            if (yearsMatcher.find()) {
                years = Integer.parseInt(yearsMatcher.group(1));
            } else {
                // Count job entries
                Pattern jobPattern = Pattern.compile("(?i)(\\d{4}\\s*-\\s*(\\d{4}|present))");
                Matcher jobMatcher = jobPattern.matcher(experienceSection);
                
                while (jobMatcher.find()) {
                    years++;
                }
            }
            
            // Extract job titles
            Pattern titlePattern = Pattern.compile("(?i)(senior|lead|principal|staff|junior|associate)?\\s*(developer|engineer|architect|manager|consultant|analyst)");
            Matcher titleMatcher = titlePattern.matcher(experienceSection);
            
            List<String> titles = new ArrayList<>();
            while (titleMatcher.find() && titles.size() < 3) {
                titles.add(titleMatcher.group().trim());
            }
            
            StringBuilder summary = new StringBuilder();
            if (years > 0) {
                summary.append(years).append("+ years of experience");
                
                if (!titles.isEmpty()) {
                    summary.append(" as ");
                    for (int i = 0; i < titles.size(); i++) {
                        if (i > 0) {
                            summary.append(i == titles.size() - 1 ? " and " : ", ");
                        }
                        summary.append(titles.get(i));
                    }
                }
            } else {
                summary.append("Experience includes ");
                if (!titles.isEmpty()) {
                    for (int i = 0; i < titles.size(); i++) {
                        if (i > 0) {
                            summary.append(i == titles.size() - 1 ? " and " : ", ");
                        }
                        summary.append(titles.get(i));
                    }
                } else {
                    summary.append("various roles in software development");
                }
            }
            
            return summary.toString();
        }
        
        return "No detailed experience information found";
    }
    
    /**
     * Extract education summary from resume text
     * @param resumeText Text content of the resume
     * @return Education summary
     */
    private String extractEducationSummary(String resumeText) {
        // Look for education sections
        Pattern educationSectionPattern = Pattern.compile(
            "(?i)(education|academic background|qualifications)\\s*:?\\s*([\\s\\S]*?)(?=\\n\\s*\\n|\\n\\s*[A-Z]|$)"
        );
        Matcher educationSectionMatcher = educationSectionPattern.matcher(resumeText);
        
        if (educationSectionMatcher.find()) {
            String educationSection = educationSectionMatcher.group(2);
            
            // Extract degrees
            Pattern degreePattern = Pattern.compile(
                "(?i)(bachelor|master|phd|doctorate|bs|ba|ms|ma|mba|b\\.s\\.|m\\.s\\.|b\\.a\\.|m\\.a\\.|ph\\.d\\.)\\s*(of|in)?\\s*(science|arts|engineering|computer science|information technology|business administration|mathematics|physics)?"
            );
            Matcher degreeMatcher = degreePattern.matcher(educationSection);
            
            List<String> degrees = new ArrayList<>();
            while (degreeMatcher.find() && degrees.size() < 2) {
                String degree = degreeMatcher.group().trim();
                degrees.add(degree);
            }
            
            // Extract universities
            Pattern universityPattern = Pattern.compile(
                "(?i)(university|college|institute|school)\\s+of\\s+[A-Za-z\\s]+|[A-Za-z]+\\s+(university|college|institute|school)"
            );
            Matcher universityMatcher = universityPattern.matcher(educationSection);
            
            List<String> universities = new ArrayList<>();
            while (universityMatcher.find() && universities.size() < 2) {
                String university = universityMatcher.group().trim();
                universities.add(university);
            }
            
            StringBuilder summary = new StringBuilder();
            if (!degrees.isEmpty()) {
                summary.append("Holds ");
                for (int i = 0; i < degrees.size(); i++) {
                    if (i > 0) {
                        summary.append(i == degrees.size() - 1 ? " and " : ", ");
                    }
                    summary.append(degrees.get(i));
                }
                
                if (!universities.isEmpty()) {
                    summary.append(" from ");
                    for (int i = 0; i < universities.size(); i++) {
                        if (i > 0) {
                            summary.append(i == universities.size() - 1 ? " and " : ", ");
                        }
                        summary.append(universities.get(i));
                    }
                }
            } else if (!universities.isEmpty()) {
                summary.append("Educated at ");
                for (int i = 0; i < universities.size(); i++) {
                    if (i > 0) {
                        summary.append(i == universities.size() - 1 ? " and " : ", ");
                    }
                    summary.append(universities.get(i));
                }
            } else {
                summary.append("Education details not clearly specified");
            }
            
            return summary.toString();
        }
        
        return "No detailed education information found";
    }
    
    /**
     * Generate improvement suggestions for the resume
     * @param resumeText Text content of the resume
     * @param skills List of skills found in the resume
     * @return Suggestions as JsonObject
     */
    private JsonObject generateSuggestions(String resumeText, List<String> skills) {
        JsonObject suggestions = new JsonObject();
        
        // Check for quantifiable achievements
        if (!resumeText.matches("(?i).*\\b(increased|decreased|improved|reduced|achieved|delivered|managed|led)\\b.*\\b\\d+%?\\b.*")) {
            suggestions.addProperty("addMetrics", "Add quantifiable achievements with specific metrics (e.g., 'Increased performance by 30%')");
        }
        
        // Check for action verbs
        if (!resumeText.matches("(?i).*\\b(developed|implemented|designed|created|managed|led|coordinated|analyzed|resolved|improved)\\b.*")) {
            suggestions.addProperty("useActionVerbs", "Use strong action verbs to describe your accomplishments");
        }
        
        // Check for skills relevance
        if (skills.size() < 10) {
            suggestions.addProperty("addMoreSkills", "Add more relevant technical and soft skills to highlight your capabilities");
        }
        
        // Check for resume length
        int wordCount = resumeText.split("\\s+").length;
        if (wordCount < 300) {
            suggestions.addProperty("expandContent", "Your resume seems too short. Add more details about your experience and projects");
        } else if (wordCount > 1000) {
            suggestions.addProperty("condenseContent", "Your resume is quite long. Consider condensing it to 1-2 pages for better readability");
        }
        
        // Check for contact information
        if (!resumeText.matches("(?i).*\\b(email|e-mail|phone|linkedin|github)\\b.*")) {
            suggestions.addProperty("addContactInfo", "Ensure your resume includes complete contact information and professional profiles");
        }
        
        // Check for education details
        if (!resumeText.matches("(?i).*\\b(university|college|bachelor|master|degree|gpa)\\b.*")) {
            suggestions.addProperty("addEducation", "Include your educational background with degrees, institutions, and graduation dates");
        }
        
        // Always suggest ATS optimization
        suggestions.addProperty("optimizeForATS", "Optimize your resume for Applicant Tracking Systems by including relevant keywords from job descriptions");
        
        return suggestions;
    }
    
    /**
     * Calculate a score for the resume based on various factors
     * @param resumeText Text content of the resume
     * @param skills List of skills found in the resume
     * @return Score between 0 and 100
     */
    public float calculateResumeScore(String resumeText, List<String> skills) {
        float score = 60.0f; // Base score
        
        // Skills score (up to 20 points)
        score += Math.min(20, skills.size() * 2);
        
        // Quantifiable achievements (up to 10 points)
        Pattern metricsPattern = Pattern.compile("(?i)\\b(increased|decreased|improved|reduced|achieved|delivered)\\b.*\\b\\d+%?\\b");
        Matcher metricsMatcher = metricsPattern.matcher(resumeText);
        int metricsCount = 0;
        while (metricsMatcher.find()) {
            metricsCount++;
        }
        score += Math.min(10, metricsCount * 2);
        
        // Action verbs (up to 5 points)
        Pattern actionVerbsPattern = Pattern.compile("(?i)\\b(developed|implemented|designed|created|managed|led|coordinated|analyzed|resolved|improved)\\b");
        Matcher actionVerbsMatcher = actionVerbsPattern.matcher(resumeText);
        int actionVerbsCount = 0;
        while (actionVerbsMatcher.find()) {
            actionVerbsCount++;
        }
        score += Math.min(5, actionVerbsCount *
(Content truncated due to size limit. Use line ranges to read in chunks)