import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class Task2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter printWriter = resp.getWriter();
        String urlnParam = req.getParameter("urln");

        ServletContext sc = getServletContext();
        String uri = sc.getInitParameter("URL" + urlnParam);

        if (uri != null) {
            HttpGet httpGet = new HttpGet(uri);

            CloseableHttpClient httpclient = HttpClients.createDefault();
            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                System.out.println(response1.getCode() + " " + response1.getReasonPhrase());
                HttpEntity entity1 = response1.getEntity();

                resp.setStatus(response1.getCode());

                String responseString = EntityUtils.toString(entity1, "UTF-8");
                resp.getWriter().write(responseString);

                EntityUtils.consume(entity1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            printWriter.println("Parameter URLn not found");
        }
    }
}
