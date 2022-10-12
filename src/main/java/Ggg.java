import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Ggg extends HttpServlet {
    public Ggg() {
        super();
        System.out.println("Ggg:constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Ggg:init");
    }    

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.getWriter().println("Querry string: " + rq.getQueryString());
        rs.getWriter().println("GET Ggg:" + rq.getMethod());
        rs.getWriter().println("forwraded part for task 6 4-5");

        rs.sendRedirect("/lab3/forwarded.html");
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Ggg:POST");

        rs.getWriter().println("POST");
        rs.getWriter().println("a: " + rq.getParameter("a"));
        rs.getWriter().println("b: " + rq.getParameter("b"));
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Sss:destroy");
    }
}