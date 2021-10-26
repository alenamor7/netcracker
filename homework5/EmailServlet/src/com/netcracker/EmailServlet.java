package com.netcracker;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String resultString = "";
        final String username = "testingmyservlet@gmail.com";
        final String password = "qwertyQWERTY1";

        EmailParameters params = new EmailParameters(req);

        if(params.validation()) {
            Properties props = new Properties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try{
                MimeMessage message = new MimeMessage(session); // email message
                message.setFrom(new InternetAddress(username)); // setting header
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(params.getToEmail()));
                if(!("".equals(params.getCopy()))) {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(params.getCopy()));
                }
                message.setSubject(params.getSubject()); // subject line
                message.setText(params.getText());
                Transport.send(message);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            resultString = "\t\t<h2> Your email was sent to " + params.getToEmail() + "</h2>";
        }
        else{
            resultString = "\t\t<h2> Please enter correct information in all fields </h2>";
        }

        pw.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>Servlet which send emails</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                resultString +
                "\t</body>\n" +
                "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
