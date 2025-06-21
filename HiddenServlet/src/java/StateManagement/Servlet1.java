/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package StateManagement;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class Servlet1 extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String uname = req.getParameter("uname");
        out.print("Welcome," + uname);
//        out.print("<form action='servlet2'>");
//        out.print("<input type='hidden' name='uname' value='"+uname+"'>");
//        out.print("<input type='submit' value='go'></form>");

        out.print("<br><a href='servlet2?uname="+uname+"'>Go</a>");
    }
}
