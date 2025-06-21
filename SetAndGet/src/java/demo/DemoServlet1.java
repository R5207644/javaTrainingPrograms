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
public class DemoServlet1 extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        ServletContext context = getServletContext();
        context.setAttribute(key, value);
        out.print("<h2>Welcome to servlet1</h2>");
        out.print("<a href='servlet2?key="+key+"'>Go to servlet 2</a>");
    }
}
