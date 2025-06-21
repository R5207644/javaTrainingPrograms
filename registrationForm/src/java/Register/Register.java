/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Register;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class Register extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String uname = req.getParameter("uname");
        String passwd = req.getParameter("passwd");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        
        // connection creation
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO registeruser values(?, ?, ?, ?)");
            
            stmt.setString(1, uname);
            stmt.setString(2, passwd);
            stmt.setString(3, email);
            stmt.setString(4, country);
            
            int i = stmt.executeUpdate();
            
            if (i > 0) {
                out.print("<h2 class='text-success'>Successfully inserted record ..........</h2>");
            } else {
                out.print("<h2 class='text-danger'>Something wrong happened</h2>");
            }
            
        } catch(Exception e2) {
            out.print("<h2 class='text-danger'>"+e2+"</h2");
        }
    }
}
