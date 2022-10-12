import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlForward extends HttpServlet {
    //3 task
    public HtmlForward() {
        super();
        System.out.println("HtmlForward:constructor");
    }
    
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("HtmlForward:GET");

        rs.sendRedirect("/lab3/forwarded.html");
    }
}
