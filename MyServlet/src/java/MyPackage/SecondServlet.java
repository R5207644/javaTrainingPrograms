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
public class SecondServlet implements Servlet{
    
    ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("Object Created.............................");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servicing second servlet..........");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
            out.println("*&nbsp;");
            }
            out.print("<br>");
        }
        
        for(int i = 0; i < 10; i++) {
            
            for(int j = 9-i; j > 0; j--) {
                out.println("&nbsp;");
            }
            
            for(int j = i; j > 0; j--) {
                out.println("*");
            }
            
            out.print("<br>");
        }
    }

    @Override
    public String getServletInfo() {
        return "This is Second Servlet";
    }

    @Override
    public void destroy() {
        System.out.println("Object destroyed");
    }

}
