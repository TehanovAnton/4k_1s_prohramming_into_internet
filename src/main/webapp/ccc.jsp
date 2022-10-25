<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<%@ page import="models.CBean" %>
<html>
    <head>
        <title>lab6</title>
    </head>
    <body>
        <% CBean ob = (CBean) pageContext.getServletContext().getAttribute("atrCBean"); %>
        <%=ob.getValue1()%>
        <%=ob.getValue2()%>
        <%=ob.getValue3()%>
    </body>
</html>