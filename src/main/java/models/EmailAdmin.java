package models;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailAdmin {
    public static String showMessages(final String userEmail, final String password) throws MessagingException, IOException {

        String host = "imap.yandex.ru";
        Properties properties = new Properties();
        properties.put("mail.imaps.ssl.trust", "*");

        Store store = Session.getDefaultInstance(properties).getStore("imaps");
        store.connect(host, userEmail, password);

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        System.out.println("Length: "+folder.getMessages().length);

        StringBuilder result = new StringBuilder();
        for (Message message: folder.getMessages()) {
            result.append("<div  style='cursor: pointer;'>");
            //.append(new String(Base64.getDecoder().decode(InternetAddress.toString(message.getFrom()))))
            result.append("<p>Sender:   ").append(InternetAddress.toString(message.getFrom())).append("<br/>");
            result.append("Theme:   ").append(new String(message.getSubject().getBytes("UTF-8"), "UTF-8")).append("<br/>");
            String messageContent = new String();
            String contentType = message.getContentType();


            /*if (contentType.contains("multipart")) {
                Multipart multiPart = (Multipart) message.getContent();
                int numberOfParts = multiPart.getCount();
                for (int partCount = 0; partCount < numberOfParts; partCount++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                    messageContent = part.getContent().toString();
                }
            }
            else */
            if (contentType.contains("text/plain")
                || contentType.contains("text/html")) {

                try {
                    messageContent = (String) message.getContent();
                } catch (UnsupportedEncodingException uex) {
                    InputStream is = message.getInputStream();
                    /*
                        * Read the input stream into a byte array.
                        * Choose a charset in some heuristic manner, use
                        * that charset in the java.lang.String constructor
                        * to convert the byte array into a String.
                        */
                    messageContent = is.toString();
                } catch (Exception ex) {
                    // Handle other exceptions appropriately
                }
            }
            //result.append("<div class='hidden' style='display:none;'>Message:   ").append(messageContent).append("</div>");
            result.append("Message: ").append(messageContent).append("<br/>");

            result.append("Date:    ").append(message.getSentDate()).append("</p>");
            result.append("</div>");
            result.append("19-----------------------------------------------");
            result.append("</br>");
        }

        folder.close(true);
        store.close();
        return result.toString();
    }
}
