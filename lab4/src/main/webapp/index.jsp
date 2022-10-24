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
            int h = (new Date()).getHours();
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

        <%SimpleDateFormat yy = new SimpleDateFormat("dd/MM/yyyy"); %>
        <%SimpleDateFormat u = new SimpleDateFormat("u' ('E') '"); %>

        <table>
            <% for (int i=0; i < 7; i++) { %>
                <% Date dateNext = new Date(new Date().getTime() + 60*60*24*1000*i); %>
                <tr>
                    <td><% out.print(yy.format(dateNext)); %></td>
                    <td><% out.print(u.format(dateNext)); %></td>
                </tr>
            <% } %>
        </table>

        <% if (h > 3 && h < 7) { %>
            <%@ include file="night.jsp" %>
            <jsp:include page="night.jsp"></jsp:include>
        <% } %>

        <% if (h > 6 && h < 12) { %>
            <%@ include file="morning.jsp" %>
            <jsp:include page="morning.jsp"></jsp:include>
        <% } %>

        <% if (h > 11 && h < 17) { %>
            <%@ include file="afternoon.jsp" %>
            <jsp:include page="afternoon.jsp"></jsp:include>
        <% } %>

        <% if (h > 16 && h < 24) { %>
            <%@ include file="evening.jsp" %>
            <jsp:include page="evening.jsp"></jsp:include>
        <% } %>
        <hr>
        
        <a>Afternoon servlet is here: </a>
        <jsp:include page="/Afternoon"></jsp:include>
    </body>
</html>