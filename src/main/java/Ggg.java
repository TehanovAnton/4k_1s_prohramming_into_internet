import java.io.IOException;

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
        rs.getWriter().println("Params: a:" + rq.getParameter("a") + "; b:" + rq.getParameter("b"));

        System.out.println("Ggg:doGet:" + rq.getMethod());
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