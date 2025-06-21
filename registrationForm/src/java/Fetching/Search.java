/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Fetching;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class Search extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        int roll = Integer.parseInt(req.getParameter("roll"));
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "");
            
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM result WHERE roll_no = ?");
            stmt.setInt(1, roll);
            
            out.print("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">");
            out.print("<table width=50% border='1' class='table table-bordered table-hover'>");
            out.print("<caption><h2 class='text-center'>Result</h2></caption>");
            
            ResultSet rs = stmt.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int total = rsmd.getColumnCount();
            out.print("<tr>");
            
            for(int i = 1; i <= total; i++) {
                out.print("<th>" + rsmd.getColumnName(i) + "</th>");
            }
            
            out.print("</tr>");
            
            while (rs.next()) {
                out.print("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td></tr>");
            }
            
            out.print("</table>");
        }catch(Exception ex) {
            out.print("<h2>" + ex + "</h2>");
        }
    } 
}
