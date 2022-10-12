import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sss extends HttpServlet {
  public Sss() {
    super();
    System.out.println("Sss:constructor");
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("Sss:init");
  }

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    System.out.println("Sss:GET");

    RequestDispatcher rd = rq.getRequestDispatcher("/Ggg");
    rd.forward(rq, rs);
  }

  @Override
  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    System.out.println("Sss:POST");
    rq.setAttribute("a",rq.getParameter("a"));
    rq.setAttribute("b",rq.getParameter("b"));

    RequestDispatcher rd = rq.getRequestDispatcher("/Ggg");
    rd.forward(rq, rs);
  }

  @Override
  public void destroy() {
    super.destroy();
    System.out.println("Sss:destroy");
  }
}