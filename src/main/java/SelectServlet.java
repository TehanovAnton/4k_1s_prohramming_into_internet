import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            System.out.println("Starting!!!!!");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your MSSQL JDBC Driver? "
                    + "Include in your library path!");

            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int param1 = Integer.parseInt(req.getParameter("param1"));
        int param2 = Integer.parseInt(req.getParameter("param2"));

        String url = "jdbc:sqlserver://LAPTOP-SN6OS1NR\\MSSQLSERVER01:1433;encrypt=false;database=java_lab10;integratedSecurity=false;";
        Properties props = new Properties();
        props.setProperty("user", "Anton");
        props.setProperty("password", "ewqqwe");
        props.setProperty("ssl", "false");    

        try {
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection(url, props);
            System.out.println("Connection Established Successfull");

            PreparedStatement pstmt = connection.prepareStatement("use java_lab10; select * from A where b > ? and b < ?;");
            pstmt.setInt(1, param1 );
            pstmt.setInt(2, param2);
            ResultSet rs = pstmt.executeQuery();

            PrintWriter out = resp.getWriter();
            while (rs.next()) {
                out.println(
                "record:" + rs.getString("b")
                );
            }
            
        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }
}
