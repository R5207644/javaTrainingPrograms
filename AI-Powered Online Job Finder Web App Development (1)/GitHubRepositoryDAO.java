package com.jobfinder.dao;

import com.jobfinder.model.GitHubRepository;
import com.jobfinder.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for GitHubRepository entity
 * Handles database operations related to GitHub repositories
 */
public class GitHubRepositoryDAO {
    
    /**
     * Create a new GitHub repository in the database
     * @param repository GitHubRepository object to create
     * @return ID of the created repository, or -1 if creation failed
     */
    public int createGitHubRepository(GitHubRepository repository) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int repoId = -1;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "INSERT INTO github_repositories (user_id, repo_url, repo_name, description, analysis, languages, code_quality_score) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, repository.getUserId());
            stmt.setString(2, repository.getRepoUrl());
            stmt.setString(3, repository.getRepoName());
            stmt.setString(4, repository.getDescription());
            stmt.setString(5, repository.getAnalysis());
            stmt.setString(6, repository.getLanguages());
            stmt.setFloat(7, repository.getCodeQualityScore());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    repoId = rs.getInt(1);
                    repository.setId(repoId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return repoId;
    }
    
    /**
     * Get a GitHub repository by ID
     * @param repoId ID of the repository to retrieve
     * @return GitHubRepository object if found, null otherwise
     */
    public GitHubRepository getGitHubRepositoryById(int repoId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        GitHubRepository repository = null;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM github_repositories WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, repoId);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                repository = mapResultSetToGitHubRepository(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return repository;
    }
    
    /**
     * Get all GitHub repositories for a user
     * @param userId ID of the user
     * @return List of GitHubRepository objects
     */
    public List<GitHubRepository> getGitHubRepositoriesByUserId(int userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<GitHubRepository> repositories = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM github_repositories WHERE user_id = ? ORDER BY created_at DESC";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                GitHubRepository repository = mapResultSetToGitHubRepository(rs);
                repositories.add(repository);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return repositories;
    }
    
    /**
     * Update an existing GitHub repository in the database
     * @param repository GitHubRepository object to update
     * @return true if update was successful, false otherwise
     */
    public boolean updateGitHubRepository(GitHubRepository repository) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "UPDATE github_repositories SET repo_url = ?, repo_name = ?, description = ?, " +
                         "analysis = ?, languages = ?, code_quality_score = ?, updated_at = NOW() " +
                         "WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, repository.getRepoUrl());
            stmt.setString(2, repository.getRepoName());
            stmt.setString(3, repository.getDescription());
            stmt.setString(4, repository.getAnalysis());
            stmt.setString(5, repository.getLanguages());
            stmt.setFloat(6, repository.getCodeQualityScore());
            stmt.setInt(7, repository.getId());
            
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
     * Delete a GitHub repository from the database
     * @param repoId ID of the repository to delete
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteGitHubRepository(int repoId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "DELETE FROM github_repositories WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, repoId);
            
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
     * Map a ResultSet to a GitHubRepository object
     * @param rs ResultSet containing repository data
     * @return GitHubRepository object
     * @throws SQLException if a database access error occurs
     */
    private GitHubRepository mapResultSetToGitHubRepository(ResultSet rs) throws SQLException {
        GitHubRepository repository = new GitHubRepository();
        repository.setId(rs.getInt("id"));
        repository.setUserId(rs.getInt("user_id"));
        repository.setRepoUrl(rs.getString("repo_url"));
        repository.setRepoName(rs.getString("repo_name"));
        repository.setDescription(rs.getString("description"));
        repository.setAnalysis(rs.getString("analysis"));
        repository.setLanguages(rs.getString("languages"));
        repository.setCodeQualityScore(rs.getFloat("code_quality_score"));
        repository.setCreatedAt(rs.getTimestamp("created_at"));
        repository.setUpdatedAt(rs.getTimestamp("updated_at"));
        return repository;
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
