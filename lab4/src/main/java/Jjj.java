import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class Jjj extends HttpServlet {

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        System.out.println("Servlet:Jjj");

        HttpGet httpGet = new HttpGet("http://localhost:8080/lab4/Afternoon");
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
            System.out.println(response1.getCode() + " " + response1.getReasonPhrase());
            HttpEntity entity1 = response1.getEntity();

            rs.setStatus(response1.getCode());
            String responseString = EntityUtils.toString(entity1, "UTF-8");
            rs.getWriter().write(responseString);

            EntityUtils.consume(entity1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}