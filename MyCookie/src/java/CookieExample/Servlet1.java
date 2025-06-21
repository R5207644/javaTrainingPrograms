
package CookieExample;

/**
 *
 * @author Sarvesh Kumar
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String email = req.getParameter("email");
        out.print("<h2> email: " + email + "</h2>");
        
        Cookie ck = new Cookie("email", email);
        res.addCookie(ck);
        out.print("<form action='next' method='POST'>");
        out.print("<p><input type='submit' value='next'></p></form>");
    }
}
