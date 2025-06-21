package com.jobfinder.dao;

import com.jobfinder.model.Job;
import com.jobfinder.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Job entity
 * Handles database operations related to jobs
 */
public class JobDAO {
    
    /**
     * Create a new job in the database
     * @param job Job object to create
     * @return ID of the created job, or -1 if creation failed
     */
    public int createJob(Job job) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int jobId = -1;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "INSERT INTO jobs (title, company, location, description, requirements, " +
                         "salary_range, job_type, source_platform, source_url, posted_date) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, job.getTitle());
            stmt.setString(2, job.getCompany());
            stmt.setString(3, job.getLocation());
            stmt.setString(4, job.getDescription());
            stmt.setString(5, job.getRequirements());
            stmt.setString(6, job.getSalaryRange());
            stmt.setString(7, job.getJobType());
            stmt.setString(8, job.getSourcePlatform());
            stmt.setString(9, job.getSourceUrl());
            stmt.setDate(10, new java.sql.Date(job.getPostedDate().getTime()));
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    jobId = rs.getInt(1);
                    job.setId(jobId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return jobId;
    }
    
    /**
     * Get a job by ID
     * @param jobId ID of the job to retrieve
     * @return Job object if found, null otherwise
     */
    public Job getJobById(int jobId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Job job = null;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM jobs WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, jobId);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                job = mapResultSetToJob(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return job;
    }
    
    /**
     * Search for jobs based on criteria
     * @param title Job title to search for (optional)
     * @param location Job location to search for (optional)
     * @param platform Source platform to filter by (optional)
     * @return List of matching Job objects
     */
    public List<Job> searchJobs(String title, String location, String platform) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Job> jobs = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.getConnection();
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM jobs WHERE 1=1");
            List<Object> params = new ArrayList<>();
            
            if (title != null && !title.trim().isEmpty()) {
                sqlBuilder.append(" AND title LIKE ?");
                params.add("%" + title + "%");
            }
            
            if (location != null && !location.trim().isEmpty()) {
                sqlBuilder.append(" AND location LIKE ?");
                params.add("%" + location + "%");
            }
            
            if (platform != null && !platform.trim().isEmpty()) {
                sqlBuilder.append(" AND source_platform = ?");
                params.add(platform);
            }
            
            sqlBuilder.append(" ORDER BY posted_date DESC");
            
            stmt = conn.prepareStatement(sqlBuilder.toString());
            
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Job job = mapResultSetToJob(rs);
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return jobs;
    }
    
    /**
     * Get recent jobs
     * @param limit Maximum number of jobs to retrieve
     * @return List of recent Job objects
     */
    public List<Job> getRecentJobs(int limit) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Job> jobs = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM jobs ORDER BY posted_date DESC LIMIT ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Job job = mapResultSetToJob(rs);
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return jobs;
    }
    
    /**
     * Delete a job from the database
     * @param jobId ID of the job to delete
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteJob(int jobId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "DELETE FROM jobs WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, jobId);
            
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
     * Map a ResultSet to a Job object
     * @param rs ResultSet containing job data
     * @return Job object
     * @throws SQLException if a database access error occurs
     */
    private Job mapResultSetToJob(ResultSet rs) throws SQLException {
        Job job = new Job();
        job.setId(rs.getInt("id"));
        job.setTitle(rs.getString("title"));
        job.setCompany(rs.getString("company"));
        job.setLocation(rs.getString("location"));
        job.setDescription(rs.getString("description"));
        job.setRequirements(rs.getString("requirements"));
        job.setSalaryRange(rs.getString("salary_range"));
        job.setJobType(rs.getString("job_type"));
        job.setSourcePlatform(rs.getString("source_platform"));
        job.setSourceUrl(rs.getString("source_url"));
        job.setPostedDate(rs.getDate("posted_date"));
        job.setCreatedAt(rs.getTimestamp("created_at"));
        return job;
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
