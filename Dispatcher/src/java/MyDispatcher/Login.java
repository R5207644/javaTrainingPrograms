
package MyDispatcher;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 *
 * @author Sarvesh Kumar
 */
public class Login extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String passwd = req.getParameter("passwd");
        if (passwd.equals("qwerty")) {
            RequestDispatcher rd = req.getRequestDispatcher("servlet2");
            rd.forward(req, res);
        } else {
            out.print("<h1>Wrong password</h1>");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req, res);
        }
    }
}
