package com.jobfinder.controller.auth;

import com.jobfinder.dao.UserDAO;
import com.jobfinder.model.User;
import com.jobfinder.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet for handling user login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    private UserDAO userDAO;
    private Gson gson;
    
    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
        gson = new Gson();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JsonObject jsonResponse = new JsonObject();
        
        try {
            // Parse request parameters
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            // Validate input
            if (username == null || username.trim().isEmpty() || 
                password == null || password.trim().isEmpty()) {
                
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Username and password are required");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(jsonResponse.toString());
                return;
            }
            
            // Authenticate user
            User user = userDAO.getUserByUsername(username);
            
            if (user == null) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Invalid username or password");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.print(jsonResponse.toString());
                return;
            }
            
            // Verify password (in a real app, use a proper password hashing library)
            boolean passwordMatch = PasswordUtil.verifyPassword(password, user.getPasswordHash());
            
            if (!passwordMatch) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Invalid username or password");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.print(jsonResponse.toString());
                return;
            }
            
            // Create session
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            
            // Return success response
            jsonResponse.addProperty("success", true);
            jsonResponse.addProperty("message", "Login successful");
            jsonResponse.addProperty("userId", user.getId());
            jsonResponse.addProperty("username", user.getUsername());
            
            response.setStatus(HttpServletResponse.SC_OK);
            out.print(jsonResponse.toString());
            
        } catch (Exception e) {
            jsonResponse.addProperty("success", false);
            jsonResponse.addProperty("message", "An error occurred: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(jsonResponse.toString());
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JsonObject jsonResponse = new JsonObject();
        
        // Check if user is logged in
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
            String username = (String) session.getAttribute("username");
            
            jsonResponse.addProperty("success", true);
            jsonResponse.addProperty("loggedIn", true);
            jsonResponse.addProperty("userId", userId);
            jsonResponse.addProperty("username", username);
        } else {
            jsonResponse.addProperty("success", true);
            jsonResponse.addProperty("loggedIn", false);
        }
        
        response.setStatus(HttpServletResponse.SC_OK);
        out.print(jsonResponse.toString());
    }
}
