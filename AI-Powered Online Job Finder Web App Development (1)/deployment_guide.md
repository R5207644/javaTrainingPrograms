# AI Job Finder Web App - Deployment Guide

## Overview
This document provides instructions for deploying the AI Job Finder Web Application, a Java-based system that helps job seekers optimize their job search process using artificial intelligence.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 9.0 or higher
- MySQL 5.7 or higher
- Maven 3.6 or higher

## Database Setup
1. Create a new MySQL database:
   ```sql
   CREATE DATABASE jobfinder;
   CREATE USER 'jobfinder_user'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON jobfinder.* TO 'jobfinder_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

2. Run the database schema script:
   ```sql
   USE jobfinder;
   
   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL UNIQUE,
       password VARCHAR(255) NOT NULL,
       email VARCHAR(100) NOT NULL UNIQUE,
       full_name VARCHAR(100),
       phone VARCHAR(20),
       location VARCHAR(100),
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   
   CREATE TABLE resumes (
       id INT AUTO_INCREMENT PRIMARY KEY,
       user_id INT NOT NULL,
       file_name VARCHAR(255) NOT NULL,
       file_path VARCHAR(255) NOT NULL,
       content TEXT,
       analysis TEXT,
       score FLOAT,
       upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (user_id) REFERENCES users(id)
   );
   
   CREATE TABLE github_repositories (
       id INT AUTO_INCREMENT PRIMARY KEY,
       user_id INT NOT NULL,
       repo_url VARCHAR(255) NOT NULL,
       repo_name VARCHAR(100),
       owner VARCHAR(100),
       analysis TEXT,
       score FLOAT,
       analyzed_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (user_id) REFERENCES users(id)
   );
   
   CREATE TABLE jobs (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       company VARCHAR(255) NOT NULL,
       location VARCHAR(255),
       description TEXT,
       requirements TEXT,
       salary_range VARCHAR(100),
       job_type VARCHAR(50),
       source_platform VARCHAR(100),
       source_url VARCHAR(255),
       posted_date TIMESTAMP,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   
   CREATE TABLE saved_jobs (
       id INT AUTO_INCREMENT PRIMARY KEY,
       user_id INT NOT NULL,
       job_id INT NOT NULL,
       saved_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (user_id) REFERENCES users(id),
       FOREIGN KEY (job_id) REFERENCES jobs(id)
   );
   ```

## Application Configuration
1. Update the database connection settings in `src/main/java/com/jobfinder/util/DatabaseUtil.java`:
   ```java
   private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jobfinder";
   private static final String JDBC_USER = "jobfinder_user";
   private static final String JDBC_PASSWORD = "your_password";
   ```

2. Configure the upload directory in `src/main/java/com/jobfinder/controller/resume/ResumeUploadServlet.java`:
   ```java
   uploadDir = "/path/to/your/upload/directory";
   ```

## Building the Application
1. Navigate to the project root directory:
   ```bash
   cd /path/to/java_job_finder_app
   ```

2. Build the application using Maven:
   ```bash
   mvn clean package
   ```

3. The build process will create a WAR file in the `target` directory.

## Deployment
1. Copy the WAR file to Tomcat's webapps directory:
   ```bash
   cp target/jobfinder.war /path/to/tomcat/webapps/
   ```

2. Start or restart Tomcat:
   ```bash
   /path/to/tomcat/bin/shutdown.sh
   /path/to/tomcat/bin/startup.sh
   ```

3. The application will be available at:
   ```
   http://your-server:8080/jobfinder/
   ```

## Docker Deployment (Alternative)
1. Build the Docker image:
   ```bash
   docker build -t jobfinder:latest .
   ```

2. Run the container:
   ```bash
   docker run -d -p 8080:8080 --name jobfinder-app jobfinder:latest
   ```

3. The application will be available at:
   ```
   http://your-server:8080/jobfinder/
   ```

## Troubleshooting
- Check Tomcat logs at `/path/to/tomcat/logs/catalina.out`
- Verify database connectivity
- Ensure file permissions are set correctly for the upload directory

## Additional Resources
- [Apache Tomcat Documentation](https://tomcat.apache.org/tomcat-9.0-doc/index.html)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Java Servlet Specification](https://javaee.github.io/servlet-spec/)
