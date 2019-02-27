<%@page import="javax.mail.Session"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.mail.BodyPart"%>
<%@page import="java.util.Properties"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.Multipart"%>
<%@page import="javax.mail.Session" %>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.AddressException"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeBodyPart"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.internet.MimeMultipart"%>
<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<%
    String Name_h, Email_h, query;
    Name_h = request.getParameter("Name_h");
    Email_h = request.getParameter("Email_h");
    query = request.getParameter("Q_h");

    String Name_s, Email_s, S_s;
    Name_s = request.getParameter("Name_s");
    Email_s = request.getParameter("Email_s");
    S_s = request.getParameter("S_s");
    if (Name_h != null && Email_h != null && query != null) {
        Statement stmt;
        Connection cn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
            stmt = cn.createStatement();
            String p = "insert into asked_help_query(name,Email,Query) values('" + Name_h + "','" + Email_h + "','" + query + "') ";
            stmt.execute(p);
            stmt.close();
            cn.close();
            //out.println("Data inserted in help Table");
            String mailid;
            String subject;
            String feedback;
            String froma;
            String password;
            String to;

            mailid = "cse13302.sbit@gmail.com";
            subject = Name_h + " need help!!";
            feedback = "Mail id: " + Email_h + "<br> " + query;
            froma = "cse13302.sbit@gmail.com";
            password = "alok@ankit";

            to = mailid;

            if (mailid == null || password == null || feedback == null) {
                out.println("ENTER THE ALL FIELDS");
            } else {
                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", true);
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.user", froma);
                props.put("mail.smtp.password", password);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", true);
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                Session sess = Session.getInstance(props, null);
                MimeMessage message = new MimeMessage(sess);
                try {
                    InternetAddress from = new InternetAddress(froma);
                    message.setSubject(subject);
                    message.setFrom(from);
                    message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    Multipart multipart = new MimeMultipart("alternative");
                    BodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setText("some text to send");
                    multipart.addBodyPart(messageBodyPart);
                    messageBodyPart = new MimeBodyPart();
                    String htmlMessage = feedback;
                    messageBodyPart.setContent(htmlMessage, "text/html");
                    multipart.addBodyPart(messageBodyPart);
                    message.setContent(multipart);
                    Transport transport = sess.getTransport("smtp");
                    transport.connect("smtp.gmail.com", froma, password);
                    transport.sendMessage(message, message.getAllRecipients());
                } catch (Exception e) {
                    out.println("<br>Error:" + e);
                }
            }
        } catch (Exception e1) {
            out.print("Error:-" + e1);
        }
    } else if (Name_s != null && Email_s != null && S_s != null) {
        Statement stmt;
        Connection cn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
            stmt = cn.createStatement();
            String p = "insert into suggested_query(name,Email,suggestion) values('" + Name_s + "','" + Email_s + "','" + S_s + "') ";
            stmt.execute(p);
            stmt.close();
            cn.close();
            //out.println("Data inserted in suggestion Table");
            String mailid;
            String subject;
            String feedback;
            String froma;
            String password;
            String to;

            mailid = "cse13302.sbit@gmail.com";
            subject = Name_s + " Gave suggestion to you!!";
            feedback = "Mail id: " + Email_s + "<br> " + S_s;
            froma = "cse13302.sbit@gmail.com";
            password = "alok@ankit";

            to = mailid;

            if (mailid == null || password == null || feedback == null) {
                out.println("ENTER THE ALL FIELDS");
            } else {
                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", true);
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.user", froma);
                props.put("mail.smtp.password", password);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", true);
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                Session sess = Session.getInstance(props, null);
                MimeMessage message = new MimeMessage(sess);
                try {
                    InternetAddress from = new InternetAddress(froma);
                    message.setSubject(subject);
                    message.setFrom(from);
                    message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    Multipart multipart = new MimeMultipart("alternative");
                    BodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setText("some text to send");
                    multipart.addBodyPart(messageBodyPart);
                    messageBodyPart = new MimeBodyPart();
                    String htmlMessage = feedback;
                    messageBodyPart.setContent(htmlMessage, "text/html");
                    multipart.addBodyPart(messageBodyPart);
                    message.setContent(multipart);
                    Transport transport = sess.getTransport("smtp");
                    transport.connect("smtp.gmail.com", froma, password);
                    transport.sendMessage(message, message.getAllRecipients());
                } catch (Exception e) {
                    out.println("<br>Error:" + e);
                }
            }
        } catch (Exception e1) {
            out.print("Error:-" + e1);
        }
    } else {
%>
<script>window.alert("you can't access this page directly!!!");
    window.location = "http://localhost:8081/InquiryHere/ContactUs.jsp";</script><%
        }
    %>
<script>window.alert("Thanks for your precious time you always be important for us.\nWe have started working on it ");
    window.location = "http://localhost:8081/InquiryHere/index.jsp";</script>