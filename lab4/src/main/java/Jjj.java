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

        int h=(new Date()).getHours();
        RequestDispatcher rd = rq.getRequestDispatcher("/");
        if (h > 3 && h < 7) rq.getRequestDispatcher("/night.jsp");
        if (h > 6 && h < 12) rq.getRequestDispatcher("/morning.jsp");
        if (h > 11 && h < 17) rq.getRequestDispatcher("/afternoon.jsp");
        if (h > 16 && h < 24) rq.getRequestDispatcher("/evening.jsp");
        if (h > 23 || h < 4 ) rq.getRequestDispatcher("/night.jsp");
        rd.forward(rq, rs);
    }

}