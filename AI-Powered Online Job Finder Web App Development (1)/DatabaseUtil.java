package com.jobfinder.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Database connection utility class
 * Manages database connections using connection pooling
 */
public class DatabaseUtil {
    
    private static BasicDataSource dataSource = null;
    
    static {
        // Initialize the data source
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jobfinder?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        
        // Connection pool configuration
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(20);
        dataSource.setMaxIdle(10);
        dataSource.setMinIdle(5);
        dataSource.setMaxWaitMillis(10000);
    }
    
    /**
     * Get a database connection from the pool
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
    /**
     * Close a database connection
     * @param connection Connection to close
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Log the exception
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
    
    /**
     * Close the data source
     */
    public static void closeDataSource() {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (SQLException e) {
                // Log the exception
                System.err.println("Error closing data source: " + e.getMessage());
            }
        }
    }
}
