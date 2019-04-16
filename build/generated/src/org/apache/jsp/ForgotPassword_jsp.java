package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.mail.Session;
import javax.mail.BodyPart;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.sql.*;

public final class ForgotPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";

            String SEARCH = "";
            String SIGN_UP = "";
            String LOGIN = "";
            String EMAIL = "";
            String RESET_PASSWORD = "";
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/site.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">  \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                SEARCH = "खोजे";
                SIGN_UP = "नया अकाउंट बनाये";
                LOGIN = "लॉग इन करें";
                EMAIL = "यहां अपना मेल डालें";
                RESET_PASSWORD = "पासवर्ड रीसेट";
            } else {
                SEARCH = "Search";
                SIGN_UP = "SignUp";
                LOGIN = "Login";
                EMAIL = "Enter your mail here";
                RESET_PASSWORD = "Reset password";
            }
        
      out.write("\r\n");
      out.write("        ");

            if (session.getAttribute("email") != null) {
                response.sendRedirect("index.jsp?sl=" + sl);
            }
        
      out.write("\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Forger Password | InquiryHere.com</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <style>\r\n");
      out.write("            input[type=text] {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                padding: 4px 8px;\r\n");
      out.write("                margin: 4px 0;\r\n");
      out.write("                box-sizing: border-box;\r\n");
      out.write("                border: 1px solid red;\r\n");
      out.write("                border-radius: 2px;\r\n");
      out.write("            }\r\n");
      out.write("            .button {\r\n");
      out.write("                background-color: #4CAF50; /* Green */\r\n");
      out.write("                border: none;\r\n");
      out.write("                color: white;\r\n");
      out.write("                padding: 15px 32px;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                margin: 4px 2px;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("            }\r\n");
      out.write("            .button1 {width: 250px;}\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-page-wrapper\">\r\n");
      out.write("            <header class=\"home-page\">\r\n");
      out.write("                <div class=\"container clear-fix\">\r\n");
      out.write("                    <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\" style=\"padding-left:0px;\">\r\n");
      out.write("                        <div class=\"logo float-left\">\r\n");
      out.write("                            <a href=\"#\" style=\"vertical-align:middle;\">\r\n");
      out.write("                                <h4>\r\n");
      out.write("                                    <div class=\"logotext\">\r\n");
      out.write("                                        Inquiryhere.com\r\n");
      out.write("                                        <div>\r\n");
      out.write("\r\n");
      out.write("                                            </h4>\r\n");
      out.write("                                            </a></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12 serachhere\" style=\"display:inline-block;\">\r\n");
      out.write("\r\n");
      out.write("                                        <div style=\"overflow: hidden; padding-right: .5em;\">\r\n");
      out.write("                                            <form action=\"SearchBars.jsp\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("                                                <input type=\"text\" style=\"width: 100%;\" name=\"search\" >\r\n");
      out.write("                                                <button type=\"submit\" style=\"float: right;width: 50px;\" />");
      out.print(SEARCH);
      out.write("</button>\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-2 col-md-2 col-sm-12 col-xs-12 float-right textalign-right\">\r\n");
      out.write("                                        <a  href=\"Login.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white; width: 50px;\">");
      out.print(LOGIN);
      out.write("</a>\r\n");
      out.write("                                        <a  href=\"signup.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white; width: 50px;\">");
      out.print(SIGN_UP);
      out.write("</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    </header>\r\n");
      out.write("                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                                    <div class=\"bodydata\">\r\n");
      out.write("                                        <div class=\"container clear-fix\">\r\n");
      out.write("                                            <div class=\"row\">\r\n");
      out.write("                                                <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                                                    <div class=\"row\"><center>\r\n");
      out.write("                                                            ");

                                                                String ErrorMsg = request.getParameter("Error");
                                                                if (ErrorMsg != null) {
                                                                    out.println("<center><b style=color:red;>" + ErrorMsg + "</b></center>");
                                                                }
                                                            
      out.write("\r\n");
      out.write("                                                            <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                                                <div class=\"themeBox\" style=\"height:270px;\">\r\n");
      out.write("                                                                    <form action=\"ForgotPassword.jsp\" method=\"post\" name=\"\">\r\n");
      out.write("                                                                        <label for=\"fname\">");
      out.print(EMAIL);
      out.write("</label>\r\n");
      out.write("                                                                        <div class=\"boxHeading\">\r\n");
      out.write("                                                                            <input type=\"text\" id=\"fname\" name=\"email\" required=\"\">\r\n");
      out.write("                                                                        </div>  \r\n");
      out.write("                                                                        <button class=\"button button1\">");
      out.print(RESET_PASSWORD);
      out.write("</button>\r\n");
      out.write("                                                                    </form>                                                                    \r\n");
      out.write("                                                                </div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                                        </center> \r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    ");

                                                        String UserEmail = request.getParameter("email");
                                                        if (UserEmail != null) {
                                                            int i = 0;
                                                            String StoredEmail = null, FirstName = null;
                                                            String UserPassword = null;
                                                            Connection connection = null;
                                                            ResultSet resultSet = null;
                                                            PreparedStatement preparedStatement = null;
                                                            try {
                                                                if (connection == null || connection.isClosed()) {
                                                                    try {
                                                                        Class.forName("com.mysql.jdbc.Driver");
                                                                    } catch (ClassNotFoundException ex) {
                                                                        out.println("Exception in loading the class forname Driver" + ex);
                                                                    }
                                                                    connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
                                                                }
                                                                try {

                                                                    String sql = "select email,firstname,password from newuser where email = '" + UserEmail + "'";
                                                                    preparedStatement = connection.prepareStatement(sql);
                                                                    resultSet = preparedStatement.executeQuery();
                                                                    while (resultSet.next()) {
                                                                        StoredEmail = resultSet.getString("email");
                                                                        FirstName = resultSet.getString("firstname");
                                                                        UserPassword = resultSet.getString("password");
                                                                        if (StoredEmail.equals(UserEmail)) {
                                                                            i = 1;
                                                                        }
                                                                    }
                                                                } catch (Exception ex) {
                                                                    out.println("Error :" + ex);
                                                                }

                                                            } catch (Exception e) {
                                                                out.println("Error in main try block:-" + e);
                                                            } finally {

                                                                if (connection != null || !connection.isClosed()) {
                                                                    try {
                                                                        connection.close();
                                                                    } catch (Exception e) {
                                                                        out.println("Exception in closing connection " + e);
                                                                    }
                                                                }
                                                                if (resultSet != null || !resultSet.isClosed()) {
                                                                    try {
                                                                        resultSet.close();
                                                                    } catch (Exception e) {
                                                                        out.println("Exception in closing resulatset " + e);
                                                                    }
                                                                }
                                                                if (preparedStatement != null || !preparedStatement.isClosed()) {
                                                                    try {
                                                                        preparedStatement.close();
                                                                    } catch (Exception e) {
                                                                        out.println("Exception in closing preparedStatement " + e);
                                                                    }
                                                                }
                                                            }

                                                            if (i == 1) {
                                                                String mailid;
                                                                String subject;
                                                                String feedback;
                                                                String froma;
                                                                String password;
                                                                String to;

                                                                mailid = UserEmail;
                                                                subject = "Reset Password of inquiryhere.com";
                                                                feedback = "Your InquryHere password is : " + UserPassword + "<br>Thanks for using our service";
                                                                froma = "cse13302.sbit@gmail.com";
                                                                password = "password@GMA1L";

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
                                                                    // out.println("Port: " + sess.getProperty("mail.smtp.port"));
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
                                                                        //out.println("Mail has been sent");
      out.write("\r\n");
      out.write("                                                    <script>window.alert(\"Password has been sent to your Mail\");\r\n");
      out.write("                                                        window.location = \"");
      out.print(DB_AJAX_PATH);
      out.write("/Login.jsp\";</script>\r\n");
      out.write("                                                        ");
 
                                                                            out.println("<b><a href=Login.html?sl=" + sl + ">Click here to visit Login page</a></b>");
                                                                            //response.sendRedirect("Login.html");
                                                                        } catch (Exception e) {
                                                                            //out.println("<br>Error:" + e);
                                                                            out.println("<br>May be: -> Your registred Mail Id is not valid or some netword problem");
                                                                        }
                                                                    }
                                                                } else {
                                                                    response.sendRedirect("ForgotPassword.jsp?sl=" + sl + "&Error=Email not found please insert the registered email or valid email");
                                                                }
                                                            }
                                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                </div>\r\n");
      out.write("\r\n");
      out.write("                                                <div class=\"clear-fix\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                                     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("                                    <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("                                    <!-- Bootstrap JS -->\r\n");
      out.write("                                    <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("                                    <!-- Bootstrap Select JS -->\r\n");
      out.write("                                    <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("\r\n");
      out.write("                                    </div> \r\n");
      out.write("                                    </body></html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
