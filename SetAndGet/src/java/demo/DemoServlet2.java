/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 *
 * @author Sarvesh Kumar
 */
public class DemoServlet2 extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String key = req.getParameter("key");
        ServletContext context = getServletContext();
        String result = (String) context.getAttribute(key);
        
        out.print("<h1>University = " + result + "</h1>");
    }

}
