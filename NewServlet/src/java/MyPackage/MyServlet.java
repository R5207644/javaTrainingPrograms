package MyPackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class MyServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<h1>Http Servlet working</h1>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<h1>Welcome to register servlet</h1>");

        String name = req.getParameter("uname");
        String passwd = req.getParameter("passwd");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        String condition = req.getParameter("condition");

        if (condition != null) {
            if (condition.equals("checked")) {
                out.print("<h2> Name: " + name + "</h2>");
                out.print("<h2> Password: " + passwd + "</h2>");
                out.print("<h2> Gender: " + gender + "</h2>");
                out.print("<h2> Course: " + course + "</h2>");
            }
        } else {
            out.println("<h2>You Haven't accepted terms</h2>");
        }
    }
}
