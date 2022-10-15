import java.io.IOException;

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

    rs.sendRedirect("/AS_TAV_4_5_2_11_3/Ggg");
  }

  @Override
  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    System.out.println("Sss:POST");
    rq.setAttribute("a",rq.getParameter("a"));
    rq.setAttribute("b",rq.getParameter("b"));

    rs.sendRedirect("/AS_TAV_4_5_2_11_3/Ggg");
  }

  @Override
  public void destroy() {
    super.destroy();
    System.out.println("Sss:destroy");
  }
}