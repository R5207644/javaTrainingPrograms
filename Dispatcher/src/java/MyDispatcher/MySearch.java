/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyDispatcher;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class MySearch extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String q = req.getParameter("q");
        res.sendRedirect("https://www.google.com/search?q=" + q);
    }
}
