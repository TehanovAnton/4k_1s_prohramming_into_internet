package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class SssXml extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("SssXml:init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Random random = new Random();
            Integer n = Integer.parseInt(req.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder("<?xml version=\"1.0\"  encoding = \"utf-8\" ?>");
            Integer count = random.nextInt(6) + 5;

            textResult.append("<rand>");
            for (Integer i = 0; i < count; i++) {
                Integer number = random.nextInt(n*2) - n;
                textResult.append("<num>").append(number).append("</num>");
            }
            textResult.append("</rand>");

            Thread.sleep(1000);

            resp.setContentType("text/xml");
            resp.getWriter().println(textResult);

        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}