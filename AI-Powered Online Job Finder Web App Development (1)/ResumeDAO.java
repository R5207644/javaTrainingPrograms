package com.jobfinder.dao;

import com.jobfinder.model.Resume;
import com.jobfinder.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Resume entity
 * Handles database operations related to resumes
 */
public class ResumeDAO {
    
    /**
     * Create a new resume in the database
     * @param resume Resume object to create
     * @return ID of the created resume, or -1 if creation failed
     */
    public int createResume(Resume resume) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int resumeId = -1;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "INSERT INTO resumes (user_id, filename, content, analysis, score, is_current) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, resume.getUserId());
            stmt.setString(2, resume.getFilename());
            stmt.setString(3, resume.getContent());
            stmt.setString(4, resume.getAnalysis());
            stmt.setFloat(5, resume.getScore());
            stmt.setBoolean(6, resume.isCurrent());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    resumeId = rs.getInt(1);
                    resume.setId(resumeId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return resumeId;
    }
    
    /**
     * Get a resume by ID
     * @param resumeId ID of the resume to retrieve
     * @return Resume object if found, null otherwise
     */
    public Resume getResumeById(int resumeId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Resume resume = null;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM resumes WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, resumeId);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                resume = mapResultSetToResume(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return resume;
    }
    
    /**
     * Get all resumes for a user
     * @param userId ID of the user
     * @return List of Resume objects
     */
    public List<Resume> getResumesByUserId(int userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Resume> resumes = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM resumes WHERE user_id = ? ORDER BY created_at DESC";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Resume resume = mapResultSetToResume(rs);
                resumes.add(resume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return resumes;
    }
    
    /**
     * Get the current resume for a user
     * @param userId ID of the user
     * @return Current Resume object if found, null otherwise
     */
    public Resume getCurrentResumeByUserId(int userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Resume resume = null;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM resumes WHERE user_id = ? AND is_current = true";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                resume = mapResultSetToResume(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return resume;
    }
    
    /**
     * Update an existing resume in the database
     * @param resume Resume object to update
     * @return true if update was successful, false otherwise
     */
    public boolean updateResume(Resume resume) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "UPDATE resumes SET filename = ?, content = ?, analysis = ?, " +
                         "score = ?, is_current = ?, updated_at = NOW() " +
                         "WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, resume.getFilename());
            stmt.setString(2, resume.getContent());
            stmt.setString(3, resume.getAnalysis());
            stmt.setFloat(4, resume.getScore());
            stmt.setBoolean(5, resume.isCurrent());
            stmt.setInt(6, resume.getId());
            
            int affectedRows = stmt.executeUpdate();
            success = (affectedRows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
        
        return success;
    }
    
    /**
     * Set a resume as the current resume for a user
     * @param resumeId ID of the resume to set as current
     * @param userId ID of the user
     * @return true if update was successful, false otherwise
     */
    public boolean setCurrentResume(int resumeId, int userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DatabaseUtil.getConnection();
            conn.setAutoCommit(false);
            
            // First, set all resumes for this user as not current
            String sql1 = "UPDATE resumes SET is_current = false WHERE user_id = ?";
            stmt = conn.prepareStatement(sql1);
            stmt.setInt(1, userId);
            stmt.executeUpdate();
            
            // Then, set the specified resume as current
            String sql2 = "UPDATE resumes SET is_current = true WHERE id = ? AND user_id = ?";
            stmt = conn.prepareStatement(sql2);
            stmt.setInt(1, resumeId);
            stmt.setInt(2, userId);
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                conn.commit();
                success = true;
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            closeResources(conn, stmt, null);
        }
        
        return success;
    }
    
    /**
     * Delete a resume from the database
     * @param resumeId ID of the resume to delete
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteResume(int resumeId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "DELETE FROM resumes WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, resumeId);
            
            int affectedRows = stmt.executeUpdate();
            success = (affectedRows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
        
        return success;
    }
    
    /**
     * Map a ResultSet to a Resume object
     * @param rs ResultSet containing resume data
     * @return Resume object
     * @throws SQLException if a database access error occurs
     */
    private Resume mapResultSetToResume(ResultSet rs) throws SQLException {
        Resume resume = new Resume();
        resume.setId(rs.getInt("id"));
        resume.setUserId(rs.getInt("user_id"));
        resume.setFilename(rs.getString("filename"));
        resume.setContent(rs.getString("content"));
        resume.setAnalysis(rs.getString("analysis"));
        resume.setScore(rs.getFloat("score"));
        resume.setCurrent(rs.getBoolean("is_current"));
        resume.setCreatedAt(rs.getTimestamp("created_at"));
        resume.setUpdatedAt(rs.getTimestamp("updated_at"));
        return resume;
    }
    
    /**
     * Close database resources
     * @param conn Connection to close
     * @param stmt Statement to close
     * @param rs ResultSet to close
     */
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
