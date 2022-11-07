<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<html>
    <head>
        <title>lab9</title>
    </head>

    <body>
        <p>
            <%=pageContext.getServletContext().getInitParameter("URL1")%><br/>
            <%=pageContext.getServletContext().getInitParameter("URL2")%>
        </p>
        <form method="get" action="/lab9/Task2">
            <input type="number" name="urln" placeholder="n"/><br>
            <button>Get this url</button>
        </form>

        <form method="post" action="/lab9/Ccc?value1=1&value2=2&value3=3">
            <input type="text" name="value1" placeholder="value1"/><br>
            <input type="text" name="value2" placeholder="value2"/><br>
            <input type="text" name="value3" placeholder="value3"/><br>
            <input type="text" name="cbean" placeholder="cbean"/><br>
            <button>Post on the Ccc</button>
        </form>
        
        <form method="get" action="/lab9/Ccc">
            <button>Get on the Ccc</button>
        </form>
        
    </body>
</html>
