import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SssRemote extends HttpServlet {

    //7
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("SssRemote:GET");

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:3000/lab3/Ggg?a=1&b=2")).build();;
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        rs.setStatus(response.statusCode());
        rs.getWriter().write(response.body());
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("SssRemote:POST");

        String aParam = rq.getParameter("a");
        String bParam = rq.getParameter("b");
        if(aParam == null){
            aParam = "";
        }
        if(bParam == null){
            bParam = "";
        }

        String finalAParam = aParam;
        String finalBParam = bParam;
        var values = new HashMap<String, String>() {{
            put("a", finalAParam);
            put ("b", finalBParam);
        }};

        HttpRequest.BodyPublisher requestBody  = getParamsUrlEncoded(values);
        HttpRequest request = HttpRequest.newBuilder().POST(requestBody).uri(URI.create("http://172.20.10.3:8080/lab3/Ggg")).headers("Content-Type", "application/x-www-form-urlencoded").build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        rs.setStatus(response.statusCode());
        rs.getWriter().write(response.body());
    }

    private HttpRequest.BodyPublisher getParamsUrlEncoded(Map<String, String> parameters) {
        String urlEncoded = parameters.entrySet()
                                      .stream()
                                      .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                                      .collect(Collectors.joining("&"));
                                      
        return HttpRequest.BodyPublishers.ofString(urlEncoded);
    }
}