package com.jobfinder.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for PDF operations
 * Handles PDF parsing and text extraction
 */
public class PDFUtil {
    
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
    
    /**
     * Extract text from a PDF file
     * @param filePath Path to the PDF file
     * @return Extracted text
     * @throws IOException if an error occurs during extraction
     */
    public static String extractTextFromPDF(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
    
    /**
     * Extract skills from text
     * @param text Text to extract skills from
     * @return List of skills
     */
    public static List<String> extractSkillsFromText(String text) {
        Set<String> foundSkills = new HashSet<>();
        String lowerCaseText = text.toLowerCase();
        
        // Check for technical skills
        for (String skill : TECHNICAL_SKILLS) {
            if (lowerCaseText.contains(skill.toLowerCase())) {
                foundSkills.add(skill);
            }
        }
        
        // Look for skills sections
        Pattern skillsSectionPattern = Pattern.compile(
            "(?i)(skills|technical skills|core competencies|technologies)\\s*:?\\s*([\\s\\S]*?)(?=\\n\\s*\\n|\\n\\s*[A-Z]|$)"
        );
        Matcher skillsSectionMatcher = skillsSectionPattern.matcher(text);
        
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
     * Count words in text
     * @param text Text to count words in
     * @return Word count
     */
    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        String[] words = text.split("\\s+");
        return words.length;
    }
}
