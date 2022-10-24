<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<!%@ page import="org.apache.commons.lang3.time.DateUtils" %>
<%@ page import="java.text.SimpleDateFormat" %>

<Context allowLinking="true">
<!DOCTYPE html>

<html>        
    <head>
        <meta charset="UTF-8" />
        <title>First JSP App</title>
        <style type="text/css">
            TABLE {
                border-collapse: collapse;
                border: 4px solid black;
            }
            TD, TH {
                padding: 5px;
                border: 2px solid green;
            }
        </style>
    </head>

    <body>
        <p>Today <%= new Date() %></p>

        <% 
            int h=(new Date()).getHours();
            if (h > 3 && h < 7)
                out.println("<h2>Good night</h2>");
            if (h > 6 && h < 12)
                out.println("<h2>Good morning</h2>");
            if (h > 11 && h < 17)
                out.println("<h2>Good afternoon</h2>");
            if (h > 16 && h < 24)
                out.println("<h2>Good evening</h2>");
            if (h > 23 || h < 4 )
                out.println("<h2>Good night</h2>");
        %>        
    </body>
</html>