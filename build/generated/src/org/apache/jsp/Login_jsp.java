package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";

    public boolean validateUser(String username, String password) {
        boolean found = false;
        try {
            String cookiesMail = username;
            String cookiesPassword = password;

            Connection connection = null;
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);

            String password1;
            //int Session_id_of_user = 0;
           // boolean found = false;
            try {

                String v = "SELECT ID,email,password FROM newuser WHERE email = ?";

                preparedStatement = connection.prepareStatement(v);
                preparedStatement.setString(1, cookiesMail);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    password1 = resultSet.getString("password");
                    //Session_id_of_user = resultSet.getInt("ID");
                    if (cookiesPassword.equals(password1)) {
                        found = true;
                    }
                }
            } catch (Exception e) {
                //  out.println("Error in main try block:-" + e);
            }
        } catch (Exception msg) {

        }
        return found;
    }

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

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/validateUser.jsp");
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

      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      out.write('\n');
      out.write('\n');
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <!--            <script>\r\n");
      out.write("                    // This is called with the results from from FB.getLoginStatus().\r\n");
      out.write("                    function statusChangeCallback(response) {\r\n");
      out.write("                        console.log('statusChangeCallback');\r\n");
      out.write("                        console.log(response);\r\n");
      out.write("                        // The response object is returned with a status field that lets the\r\n");
      out.write("                        // app know the current login status of the person.\r\n");
      out.write("                        // Full docs on the response object can be found in the documentation\r\n");
      out.write("                        // for FB.getLoginStatus().\r\n");
      out.write("                        if (response.status === 'connected') {\r\n");
      out.write("                            // Logged into your app and Facebook.\r\n");
      out.write("                            testAPI();\r\n");
      out.write("                        } else {\r\n");
      out.write("                            // The person is not logged into your app or we are unable to tell.\r\n");
      out.write("                           // document.getElementById('status').innerHTML = 'Please log ' +  'into this app.';\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("        \r\n");
      out.write("                    // This function is called when someone finishes with the Login\r\n");
      out.write("                    // Button.  See the onlogin handler attached to it in the sample\r\n");
      out.write("                    // code below.\r\n");
      out.write("                    function checkLoginState() {\r\n");
      out.write("                        FB.getLoginStatus(function (response) {\r\n");
      out.write("                            statusChangeCallback(response);\r\n");
      out.write("                            \r\n");
      out.write("                        });\r\n");
      out.write("                    }\r\n");
      out.write("                    \r\n");
      out.write("        \r\n");
      out.write("                    window.fbAsyncInit = function () {\r\n");
      out.write("                        FB.init({\r\n");
      out.write("                            appId: '355720661657906',\r\n");
      out.write("                            cookie: true, // enable cookies to allow the server to access \r\n");
      out.write("                            // the session\r\n");
      out.write("                            xfbml: true, // parse social plugins on this page\r\n");
      out.write("                            version: 'v3.2' // The Graph API version to use for the call\r\n");
      out.write("                        });\r\n");
      out.write("        \r\n");
      out.write("                        // Now that we've initialized the JavaScript SDK, we call \r\n");
      out.write("                        // FB.getLoginStatus().  This function gets the state of the\r\n");
      out.write("                        // person visiting this page and can return one of three states to\r\n");
      out.write("                        // the callback you provide.  They can be:\r\n");
      out.write("                        //\r\n");
      out.write("                        // 1. Logged into your app ('connected')\r\n");
      out.write("                        // 2. Logged into Facebook, but not your app ('not_authorized')\r\n");
      out.write("                        // 3. Not logged into Facebook and can't tell if they are logged into\r\n");
      out.write("                        //    your app or not.\r\n");
      out.write("                        //\r\n");
      out.write("                        // These three cases are handled in the callback function.\r\n");
      out.write("        \r\n");
      out.write("                        FB.getLoginStatus(function (response) {\r\n");
      out.write("                            statusChangeCallback(response);\r\n");
      out.write("                            //window.top.location = \"w.foo.com\";\r\n");
      out.write("                        });\r\n");
      out.write("        \r\n");
      out.write("                    };\r\n");
      out.write("        \r\n");
      out.write("                    // Load the SDK asynchronously\r\n");
      out.write("                    (function (d, s, id) {\r\n");
      out.write("                        var js, fjs = d.getElementsByTagName(s)[0];\r\n");
      out.write("                        if (d.getElementById(id))\r\n");
      out.write("                            return;\r\n");
      out.write("                        js = d.createElement(s);\r\n");
      out.write("                        js.id = id;\r\n");
      out.write("                        js.src = \"https://connect.facebook.net/en_US/sdk.js\";\r\n");
      out.write("                        fjs.parentNode.insertBefore(js, fjs);\r\n");
      out.write("                    }(document, 'script', 'facebook-jssdk'));\r\n");
      out.write("        \r\n");
      out.write("                    // Here we run a very simple test of the Graph API after login is\r\n");
      out.write("                    // successful.  See statusChangeCallback() for when this call is made.\r\n");
      out.write("                    function testAPI() {\r\n");
      out.write("                        console.log('Welcome!  Fetching your information.... ');\r\n");
      out.write("                        FB.api('/me?fields=name,email', function (response) {\r\n");
      out.write("                            console.log('Successful login for: ' + response.name);\r\n");
      out.write("                            window.location.replace('FBvalidation.jsp?fullname='+response.name.replace(\" \", \"_\")+'&email='+response.email);\r\n");
      out.write("                            //window.location.replace('FBvalidation.jsp?fullname=' + response.name.replace(\" \", \"_\") + '&email=' + response.email');\r\n");
      out.write("                            //document.getElementById('status').innerHTML = '<a href=FBvalidation.jsp?fullname=' + response.name.replace(\" \", \"_\") + '&email=' + response.email + '>Continue as ' + response.name + ' </a>';\r\n");
      out.write("                        });\r\n");
      out.write("                    }\r\n");
      out.write("                </script>-->\r\n");
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
      out.write("        ");

            Cookie[] cookies = request.getCookies();
            String username = "";
            String password = "";
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if (cookie.getName().equals("username-cookie")) {
                        username = cookie.getValue();
                    } else if (cookie.getName().equals("password-cookie")) {
                        password = cookie.getValue();
                    }
                }
            }
            if (username != "" && password != "") {
                boolean found = validateUser(username, password);
                if (found) {
        
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("email", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(username), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("password", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(password), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("        ");

                }
            }
        
      out.write("\r\n");
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
      out.write("                                                <!--                                                <div class=\"col-md-3\">\r\n");
      out.write("                                                                                                    <button type=\"submit\"  />");
      out.print(SEARCH);
      out.write("</button>\r\n");
      out.write("                                                                                                </div>-->\r\n");
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
      out.write("\r\n");
      out.write("                                                            <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                                                <!--div id=\"fb-root\"></div>\r\n");
      out.write("                                                            <script async defer crossorigin=\"anonymous\" src=\"https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v3.3&appId=355720661657906&autoLogAppEvents=1\"></script>\r\n");
      out.write("\r\n");
      out.write("                                                            <div class=\"fb-login-button\" data-width=\"\" data-size=\"large\" data-button-type=\"continue_with\" data-auto-logout-link=\"false\" data-use-continue-as=\"false\"></div>\r\n");
      out.write("\r\n");
      out.write("                                                            <div id=\"status\"-->\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"themeBox\" style=\"height:300px;\">\r\n");
      out.write("                                                                <form action=\"validate.jsp\" method=\"post\" name=\"\">\r\n");
      out.write("                                                                    ");
 if (request.getParameter("URL") != null) {
      out.write("\r\n");
      out.write("                                                                    <input type=\"hidden\" name=\"URL\" value=\"");
      out.print(request.getParameter("URL"));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                                                                    <input type=\"hidden\" name=\"ans\" value=\"");
      out.print(request.getParameter("ans"));
      out.write("\">\r\n");
      out.write("                                                                    ");
 }
      out.write(" \r\n");
      out.write("                                                                    <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                                                                    <label for=\"fname\">");
      out.print(EMAIL);
      out.write("</label>\r\n");
      out.write("                                                                    <div class=\"boxHeading\">\r\n");
      out.write("                                                                        <input type=\"email\"  name=\"email\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$\" required=\"\" value=\"");
      out.print(username);
      out.write("\">\r\n");
      out.write("                                                                    </div>\r\n");
      out.write("                                                                    <label for=\"lname\">");
      out.print(PASSWORD);
      out.write("</label>\r\n");
      out.write("                                                                    <div class=\"boxHeading\">\r\n");
      out.write("                                                                        <input type=\"password\"  name=\"password\" required=\"\" value=\"");
      out.print(password);
      out.write("\">\r\n");
      out.write("                                                                    </div> \r\n");
      out.write("                                                                    <br>\r\n");
      out.write("                                                                    <button type=\"submit\" class=\"button button1\" data-toggle=\"modal\"   >");
      out.print(LOGIN);
      out.write("</button>\r\n");
      out.write("                                                                </form>\r\n");
      out.write("\r\n");
      out.write("                                                                <form action=\"ForgotPassword.jsp\">\r\n");
      out.write("                                                                    <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("                                                                    <button class=\"button button1\" style=\"background-color: red;\">");
      out.print(FORGET_PASSWORD);
      out.write("</button>\r\n");
      out.write("                                                                </form>\r\n");
      out.write("\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("\r\n");
      out.write("                                                <div class=\"clear-fix\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("                                    <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("                                    <!-- Bootstrap JS -->\r\n");
      out.write("                                    <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("                                    <!-- Bootstrap Select JS -->\r\n");
      out.write("                                    <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
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
