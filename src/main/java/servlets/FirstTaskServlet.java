package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.EmailAdmin;

public class FirstTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServletContext context = req.getServletContext();
            PrintWriter writer = resp.getWriter();

            String mails = EmailAdmin.showMessages(context.getInitParameter("UserEmail"),
                                                   context.getInitParameter("UserPassword"));
            writer.println(mails);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        final String userEmail = context.getInitParameter("UserEmail");
        final String userPassword = context.getInitParameter("UserPassword");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userEmail, userPassword);
            }
        };
        try
        {
            Session a = Session.getInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    userEmail, userPassword);
                        }
                    });
            MimeMessage msg = new MimeMessage(a);


            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(userEmail+"@yandex.by");
            msg.setSubject(context.getInitParameter("Subject"), "UTF-8");
            msg.setText(request.getParameter("message"), "UTF-8");
            msg.setSentDate(new Date());

            System.out.println(request.getParameter("email"));
            System.out.println(request.getParameter("message"));
            msg.setRecipients(Message.RecipientType.TO, request.getParameter("email"));
            Transport.send(msg);
            response.sendRedirect("./message-form.html");
            System.out.println("Sended");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
