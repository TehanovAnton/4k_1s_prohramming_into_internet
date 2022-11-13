import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoredProcedureServlet extends HttpServlet {
    private static String db_con_str = "jdbc:sqlserver://LAPTOP-SN6OS1NR\\MSSQLSERVER01:1433;encrypt=false;database=java_lab10;integratedSecurity=false;";

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

        Properties props = new Properties();
        props.setProperty("user", "Anton");
        props.setProperty("password", "ewqqwe");
        props.setProperty("ssl", "false");    

        try {
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection(db_con_str, props);
            System.out.println("Connection Established Successfull");

            CallableStatement cstmt = connection.prepareCall("{call procedureExample(?, ?)}");
            cstmt.setInt(1, param1);
            cstmt.registerOutParameter(2, Types.INTEGER);
            cstmt.execute();

            PrintWriter out = resp.getWriter();
            out.println("Count of data: " + cstmt.getInt(2));
            
        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }
}
