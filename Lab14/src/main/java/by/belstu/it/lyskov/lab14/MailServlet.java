package by.belstu.it.lyskov.lab14;

import java.io.*;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        try {
            Properties properties = new Properties();
            properties.put("mail.imaps.ssl.trust", "*");
            properties.put("mail.mime.charset", "utf-8");
            ServletContext context = getServletContext();
            String username = context.getInitParameter("username");
            String password = context.getInitParameter("password");
            Store store = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            }).getStore("imaps");
            store.connect("imap.googlemail.com", username, password);
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            StringBuilder result = new StringBuilder();
            Message[] messages = folder.getMessages();
            for (int i = 0; i < 3; i++) {
                Message message = messages[messages.length - i - 1];
                result.append("<div>");
                result.append("<h1>").append(InternetAddress.toString(message.getFrom())).append("</h1>");
                result.append("<h2>").append(message.getSubject()).append("</h2>");
                StringBuilder messageContent = new StringBuilder();
                String contentType = message.getContentType();
                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    for (int partCount = 0; partCount < multiPart.getCount(); partCount++) {
                        messageContent.append(multiPart.getBodyPart(partCount).getContent().toString());
                    }
                } else {
                    Object content = message.getContent();
                    if (content != null)
                        messageContent = new StringBuilder(content.toString());
                }

                result.append("<div>").append(messageContent).append("</div>");
                result.append("<h3>").append(message.getSentDate()).append("</h3>");
                result.append("</div>");
            }
            folder.close(true);
            store.close();
            writer.println(result);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.smtp.starttls.enable", "true");
        ServletContext context = getServletContext();
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(req.getParameter("mail")));
            message.setText(req.getParameter("message"));
            Transport.send(message);
            writer.println("Mail was sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}