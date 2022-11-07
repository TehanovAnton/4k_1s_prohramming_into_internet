<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.CBean" %>
<%@ page session="true" %>

<html>
    <head>
        <title>lab7</title>
    </head>

    <body>
        <%
            CBean reqObj = (CBean) request.getAttribute("atrCBean");
            CBean sessObj = (CBean) session.getAttribute(session.getId());
        %>

        <% if (reqObj != null) { %>
            <p>
                From request attribute
                <%=reqObj.getValue1()%>
                <%=reqObj.getValue2()%>
                <%=reqObj.getValue3()%>
            </p>
        <%} else {%>
            EMPTY REQUEST
        <% } %>        
        <hr/>
        <br/>

        <%=session.getId()%>
        <hr/>
        <br/>

        <% if (sessObj != null) { %>
            <p>
                From seession attribute:
                <%=sessObj.getValue1()%>
                <%=sessObj.getValue2()%>
                <%=sessObj.getValue3()%>
            </p>
        <%} else {%>
            EMPTY REQUEST
        <% } %>                
    </body>
</html>