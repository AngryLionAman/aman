package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String EMAIL = "";
            String PASSWORD = "";
            String HOME = "";
            String LOGIN = "";
            String SIGNUP = "";
            String SEARCH = "";
            String FORGET_PASSWORD = "";

            String MEG_FROM_VALIDATION_PAGE = "";
            String MEG_FROM_LOGOUT_PAGE = "";
            String MEG_FROM_SUBMITANS_PAGE = "";
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        \r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        ");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                EMAIL = "ईमेल";
                PASSWORD = "पासवर्ड";
                HOME = "होम";
                LOGIN = "लॉग इन करें";
                SIGNUP = "नया खाता बनाएँ";
                SEARCH = "खोजे";
                FORGET_PASSWORD = "पासवर्ड भूल गए";

                MEG_FROM_VALIDATION_PAGE = "यूजरनाम और पासवर्ड गलत है";
                MEG_FROM_LOGOUT_PAGE = "हमारी सेवा का उपयोग करने के लिए धन्यवाद।  कृपया फिर आइएगा";
                MEG_FROM_SUBMITANS_PAGE = "कृप्या पहले login करे";
            } else {
                EMAIL = "Email";
                PASSWORD = "Password";
                HOME = "Home";
                LOGIN = "Login";
                SIGNUP = "SignUp";
                SEARCH = "Search";
                FORGET_PASSWORD = "Forget Password";

                MEG_FROM_VALIDATION_PAGE = "Invalid UserName or PassWord";
                MEG_FROM_LOGOUT_PAGE = "Thanks for using our service. Please visit again";
                MEG_FROM_SUBMITANS_PAGE = "Please Login First";
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");

            if (session.getAttribute("email") != null) {
                response.sendRedirect("index.jsp?sl=" + sl);
            }
        
      out.write("\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <title>Login | InquiryHere.com</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <style>\r\n");
      out.write("            input[type=text] {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                padding: 4px 8px;\r\n");
      out.write("                margin: 4px 0;\r\n");
      out.write("                box-sizing: border-box;\r\n");
      out.write("                border: 1px solid #b3b3b3;\r\n");
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
      out.write("                                            </h4>\r\n");
      out.write("                                            </a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12 serachhere\" style=\"display:inline-block;\">\r\n");
      out.write("\r\n");
      out.write("                                        <div style=\"overflow: hidden; padding-right: .5em;\">\r\n");
      out.write("                                            <form action=\"SearchBar.jsp\">\r\n");
      out.write("                                                <div class=\"col-md-9\">\r\n");
      out.write("                                                    <input type=\"text\" style=\"width: 100%;\"  name=\"search\" required=\"\" >\r\n");
      out.write("                                                    <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("<!--                                                <div class=\"col-md-3\">\r\n");
      out.write("                                                    <button type=\"submit\"  />");
      out.print(SEARCH);
      out.write("</button>\r\n");
      out.write("                                                </div>-->\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-lg-2 col-md-2 col-sm-12 col-xs-12 float-right textalign-right\">\r\n");
      out.write("                                        <a href=\"index.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white;padding-left: 10px;padding-right: 30px;\">");
      out.print(HOME);
      out.write("</a>\r\n");
      out.write("                                        <a  href=\"signup.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white;padding-left: 10px;padding-right: 30px;\">");
      out.print(SIGNUP);
      out.write("</a>\r\n");
      out.write("                                        ");
  if (sl.equalsIgnoreCase("hi")) {
      out.write("\r\n");
      out.write("                                        <a  href=\"Login.jsp\" class=\"helpicon\" style=\"color: white;padding-left: 10px;padding-right: 30px;\">English</a>\r\n");
      out.write("                                        ");
  } else {
                                        
      out.write("\r\n");
      out.write("                                        <a  href=\"Login.jsp?sl=hi\" class=\"helpicon\" style=\"color: white;padding-left: 10px;padding-right: 30px;\">हिन्दी</a>\r\n");
      out.write("                                        ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    </header>\r\n");
      out.write("                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                                    <div class=\"bodydata\">\r\n");
      out.write("                                        <div class=\"container clear-fix\">\r\n");
      out.write("                                            <div class=\"row\">\r\n");
      out.write("                                                <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                                </div>\r\n");
      out.write("\r\n");
      out.write("                                                <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                                                    <div class=\"row\"><center>\r\n");
      out.write("                                                            ");

                                                                String ErrorMsg = request.getParameter("msg");
                                                                if (ErrorMsg != null) {
                                                                    if (ErrorMsg.equalsIgnoreCase("valid")) {
                                                                        out.println("<center><b style=color:red;>" + MEG_FROM_VALIDATION_PAGE + "</b></center>");
                                                                    }
                                                                    if (ErrorMsg.equalsIgnoreCase("logout")) {
                                                                        out.println("<center><b style=color:red;>" + MEG_FROM_LOGOUT_PAGE + "</b></center>");
                                                                    }
                                                                    if (ErrorMsg.equalsIgnoreCase("submitAns")) {
                                                                        out.println("<center><b style=color:red;>" + MEG_FROM_SUBMITANS_PAGE + "</b></center>");
                                                                    }
                                                                    // out.println("<center><b style=color:red;>" + ErrorMsg + "</b></center>");
                                                                }
                                                            
      out.write("\r\n");
      out.write("                                                            <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                                                <div class=\"themeBox\" style=\"height:300px;\">\r\n");
      out.write("                                                                    <form action=\"validate.jsp\" method=\"post\" name=\"\">\r\n");
      out.write("                                                                        ");
 if (request.getParameter("URL") != null) {
      out.write("\r\n");
      out.write("                                                                        <input type=\"hidden\" name=\"URL\" value=\"");
      out.print(request.getParameter("URL"));
      out.write("\">\r\n");
      out.write("                                                                    \r\n");
      out.write("                                                                        <input type=\"hidden\" name=\"ans\" value=\"");
      out.print(request.getParameter("ans"));
      out.write("\">\r\n");
      out.write("                                                                        ");
 }
      out.write(" \r\n");
      out.write("                                                                        <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                                                                        <label for=\"fname\">");
      out.print(EMAIL);
      out.write("</label>\r\n");
      out.write("                                                                        <div class=\"boxHeading\">\r\n");
      out.write("                                                                            <input type=\"email\"  name=\"email\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$\" required=\"\">\r\n");
      out.write("                                                                        </div>\r\n");
      out.write("                                                                        <label for=\"lname\">");
      out.print(PASSWORD);
      out.write("</label>\r\n");
      out.write("                                                                        <div class=\"boxHeading\">\r\n");
      out.write("                                                                            <input type=\"password\"  name=\"password\" required=\"\">\r\n");
      out.write("                                                                        </div> \r\n");
      out.write("                                                                        <br>\r\n");
      out.write("                                                                        <button type=\"submit\" class=\"button button1\" data-toggle=\"modal\"   >");
      out.print(LOGIN);
      out.write("</button>\r\n");
      out.write("                                                                    </form>\r\n");
      out.write("\r\n");
      out.write("                                                                    <form action=\"ForgotPassword.jsp\">\r\n");
      out.write("                                                                        <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("                                                                        <button class=\"button button1\" style=\"background-color: red;\">");
      out.print(FORGET_PASSWORD);
      out.write("</button>\r\n");
      out.write("                                                                    </form>\r\n");
      out.write("\r\n");
      out.write("                                                                </div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"clear-fix\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("                                        <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("                                        <!-- Bootstrap JS -->\r\n");
      out.write("                                        <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("                                        <!-- Bootstrap Select JS -->\r\n");
      out.write("                                        <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
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
