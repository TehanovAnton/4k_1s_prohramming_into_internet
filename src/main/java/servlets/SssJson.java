package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class SssJson extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("SssJson:init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Random random = new Random();
            Integer n = Integer.parseInt(req.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder();
            Integer count = random.nextInt(6) + 5;

            textResult.append("[");
            for (Integer i = 0; i < count; i++) {
                Integer number = random.nextInt(n*2) - n;
                textResult.append(number).append(i < count -1 ? "," : "");
            }
            textResult.append("]");

            Thread.sleep(1000);

            resp.setContentType("application/json");
            resp.getWriter().println(textResult);

        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
