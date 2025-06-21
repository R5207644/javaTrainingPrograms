package MyPackage;
import java.io.*;
import javax.servlet.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class FirstServlet implements Servlet{
    
    ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("Creating object..............");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servicing..........");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is my servlet page</h1>");
        out.println("Created by Sarvesh Kumar");
    }

    @Override
    public String getServletInfo() {
        return "This is my first servlet..";
    }

    @Override
    public void destroy() {
        System.out.println("Object Destroyed................");
    }

}
