<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %>
<%@ page %>

<html>
    <head>
        <title>Evening</title>
    </head>
    <body>
        <%
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/webapp/localLog"));
            writer.write("Evening");
            writer.append("\n");
            writer.close();
        %>
        <h1>Evening</h1>
    </body>
</html>