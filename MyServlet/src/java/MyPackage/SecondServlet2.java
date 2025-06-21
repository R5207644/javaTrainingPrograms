/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MyPackage;
import java.io.*;
import javax.servlet.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class SecondServlet2 extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("This is my Second2 Servlet");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<marquee><h1>This is Second Servlet Using Generic Servlet<h1></marquee>");
    }

}
