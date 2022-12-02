<%@ page import="javax.mail.MessagingException" %>
<%@ page import="models.EmailAdmin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Messages</title>
  <script src = "scripts/jquery-3.2.1.min.js"></script>
</head>
<body>
<%
  try {
    out.println(
            EmailAdmin.showMessages(application.getInitParameter("UserEmail"),
                    application.getInitParameter("UserPassword")));
  } catch (MessagingException e) {
    e.printStackTrace();
  }
%>
<a href="message-form.html">Message</a>
</body>
</html>
