package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SssHeader extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Sss_Header:init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("Sss_Header:post");
            Integer x = Integer.parseInt(req.getHeader("Value-x"));
            Integer y = Integer.parseInt(req.getHeader("Value-y"));
            Integer z = x + y;

            Thread.sleep(1000);

            resp.setHeader("Value-z", z.toString());
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}