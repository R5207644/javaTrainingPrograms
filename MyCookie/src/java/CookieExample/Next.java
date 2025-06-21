package CookieExample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Next extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie ck[] = req.getCookies();
        out.print("Welcome, " + ck[0].getValue());
    }
}
