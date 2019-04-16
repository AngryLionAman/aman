package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String LOGIN = "";
            String SEARCH = "";
            String HOME = "";
            String FIRST_NAME = "";
            String LAST_NAME = "";
            String EMAIL = "";
            String PASSWORD = "";
            String CREATE_ACCOUNT = "";
            String FORGET_PASSWORD = "";

        
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
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                LOGIN = "लॉग इन करें";
                SEARCH = "खोजे";
                HOME = "होम";
                FIRST_NAME = "पहला नाम";
                LAST_NAME = "उपनाम";
                EMAIL = "ईमेल";
                PASSWORD = "नया पासवर्ड";
                CREATE_ACCOUNT = "खाता बनाएं";
                FORGET_PASSWORD = "पासवर्ड भूल गए";

            } else {
                LOGIN = "Login";
                SEARCH = "Search";
                HOME = "Home";
                FIRST_NAME = "First Name";
                LAST_NAME = "Last Name";
                EMAIL = "Email";
                PASSWORD = "New Password";
                CREATE_ACCOUNT = "Create Account";
                FORGET_PASSWORD = "Forgot Password";
            }
        
      out.write("\r\n");
      out.write("        ");

            if (session.getAttribute("email") != null) {
                response.sendRedirect("index.jsp?sl=" + sl);
            }
        
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <title>SignUp | InquiryHere.com</title>\r\n");
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
      out.write("        <script language=\"Javascript\" type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            function onlyAlphabets(e, t) {\r\n");
      out.write("                try {\r\n");
      out.write("                    if (window.event) {\r\n");
      out.write("                        var charCode = window.event.keyCode;\r\n");
      out.write("                    } else if (e) {\r\n");
      out.write("                        var charCode = e.which;\r\n");
      out.write("                    } else {\r\n");
      out.write("                        return true;\r\n");
      out.write("                    }\r\n");
      out.write("                    if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))\r\n");
      out.write("                        return true;\r\n");
      out.write("                    else\r\n");
      out.write("                        return false;\r\n");
      out.write("                } catch (err) {\r\n");
      out.write("                    alert(err.Description);\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
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
      out.write("                                            <form action=\"SearchBar.jsp\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("                                                <input type=\"text\" style=\"width: 100%;\" name=\"search\" required=\"\" >\r\n");
      out.write("<!--                                                <button type=\"submit\" style=\"float: right;width: 50px;\" />");
      out.print(SEARCH);
      out.write("</button>-->\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-lg-2 col-md-2 col-sm-12 col-xs-12 float-right textalign-right\">\r\n");
      out.write("                                        <a  href=\"index.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white; width: 50px;\">");
      out.print(HOME);
      out.write("</a>\r\n");
      out.write("                                        <a  href=\"Login.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white; width: 50px;\">");
      out.print(LOGIN);
      out.write("</a>\r\n");
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
      out.write("                                                <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\" align=\"center\">                                                   \r\n");
      out.write("                                                    <div class=\"row\">                                                     \r\n");
      out.write("                                                        <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                                            <div class=\"themeBox\" style=\"height:470px;\">\r\n");
      out.write("                                                                ");

                                                                    String ErrorMsg = request.getParameter("Error");
                                                                    if (ErrorMsg != null) {
                                                                        out.println("<center><b style=color:red;>" + ErrorMsg + "</b></center>");
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                                <form action=\"NewUser.jsp\" method=\"post\" name=\"newUser\">\r\n");
      out.write("                                                                    <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("                                                                    <label for=\"fname\">");
      out.print(FIRST_NAME);
      out.write("</label>\r\n");
      out.write("                                                                    <div class=\"boxHeading\">\r\n");
      out.write("                                                                        <input type=\"text\" id=\"fname\" name=\"firstname\" onkeypress=\"return onlyAlphabets(event, this);\" required=\"\">\r\n");
      out.write("                                                                    </div>\r\n");
      out.write("                                                                    <label for=\"lname\">");
      out.print(LAST_NAME);
      out.write("</label>\r\n");
      out.write("                                                                    <div class=\"boxHeading\">\r\n");
      out.write("                                                                        <input type=\"text\" id=\"lname\" name=\"lastname\" onkeypress=\"return onlyAlphabets(event, this);\" required=\"\">\r\n");
      out.write("                                                                    </div>\r\n");
      out.write("                                                                    <label for=\"fname\">");
      out.print(EMAIL);
      out.write("</label>\r\n");
      out.write("                                                                    <div class=\"boxHeading\">\r\n");
      out.write("                                                                        <input type=\"email\"  name=\"email\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$\" required=\"\">\r\n");
      out.write("                                                                    </div>\r\n");
      out.write("                                                                    <label for=\"lname\">");
      out.print(PASSWORD);
      out.write("</label>\r\n");
      out.write("                                                                    <div class=\"boxHeading\">\r\n");
      out.write("                                                                        <input type=\"password\"  name=\"password\" pattern=\".{6,}\" title=\"Six or more characters\" required=\"\">\r\n");
      out.write("                                                                    </div> \r\n");
      out.write("                                                                    <br>\r\n");
      out.write("                                                                    <button type=\"submit\" class=\"button button1\" data-toggle=\"modal\"  >");
      out.print(CREATE_ACCOUNT);
      out.write("</button>\r\n");
      out.write("                                                                </form>\r\n");
      out.write("                                                                    <form action=\"ForgotPassword.jsp?sl=");
      out.print(sl);
      out.write("\" method=\"post\" name=\"forgetPassword\">\r\n");
      out.write("                                                                    <button class=\"button button1\" style=\"background-color: red;\">");
      out.print(FORGET_PASSWORD);
      out.write("</button>\r\n");
      out.write("                                                                </form>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"clear-fix\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("                                        <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("                                        <!-- Bootstrap JS -->\r\n");
      out.write("                                        <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("                                        <!-- Bootstrap Select JS -->\r\n");
      out.write("                                        <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
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
