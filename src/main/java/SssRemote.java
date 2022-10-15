import java.io.IOException;

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

public class SssRemote extends HttpServlet {
    //7
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("SssRemote:GET; http://172.16.193.69:8080/AS_TAV_4_5_2_11_3/Ggg?a=1&b=2");

        HttpGet httpGet = new HttpGet("http://172.16.193.69:8080/AS_TAV_4_5_2_11_3/Ggg?a=1&b=2");
        
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