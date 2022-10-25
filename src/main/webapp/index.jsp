<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<html>
    <head>
        <title>lab6</title>
    </head>

    <body>
        <p>
            <%=pageContext.getServletContext().getInitParameter("URL1")%><br/>
            <%=pageContext.getServletContext().getInitParameter("URL2")%>
        </p>
        <form method="get" action="/lab6/Task2">
            <input type="number" name="urln" placeholder="n"/><br>
            <button>Get this url</button>
        </form>
    </body>
</html>
