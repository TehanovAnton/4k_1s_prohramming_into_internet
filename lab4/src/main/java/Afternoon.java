import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Afternoon extends HttpServlet {

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        System.out.println("Servlet:Afternoon");
        rs.getWriter().println("Servlet:Afternoon");
    }

}