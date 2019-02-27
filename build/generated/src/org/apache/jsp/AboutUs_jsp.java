package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class AboutUs_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    String EMAIL = "";
    String PASSWORD = "";
    String HOME = "";
    String LOGIN = "";
    String SIGNUP = "";
    String SEARCH = "";
    String PROFILE = "";
    String CONTACT_US = "";
    String ABOUT_US = "";
    String LOGOUT = "";
    String SELECT = "";

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
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

      out.write("<html lang=\"en\"><head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <title>About Us | InquiryHere.com</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-page-wrapper\">\r\n");
      out.write("            <!-- Header _________________________________ -->\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write('\r');
      out.write('\n');

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
        PROFILE = "प्रोफ़ाइल";
        CONTACT_US = "हमसे संपर्क करें";
        ABOUT_US = "हमारे बारे में";
        LOGOUT = "बाहर जाये";
        SELECT = "चयन करें";

    } else {
        EMAIL = "Email";
        PASSWORD = "Password";
        HOME = "Home";
        LOGIN = "Login";
        SIGNUP = "SignUp";
        SEARCH = "Search";
        PROFILE = "Profile";
        CONTACT_US = "contact Us";
        ABOUT_US = "About Us";
        LOGOUT = "Logout";
        SELECT = "Select";
    }

      out.write("\r\n");
      out.write("<header class=\"home-page\">\r\n");
      out.write("    <div class=\"container clear-fix\">\r\n");
      out.write("        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\" style=\"padding-left:0px;\">\r\n");
      out.write("            <div class=\"logo float-left\">\r\n");
      out.write("                <a href=\"index.jsp?sl=");
      out.print(sl);
      out.write("\" style=\"vertical-align:middle;\">\r\n");
      out.write("                    <h4>\r\n");
      out.write("                        <div class=\"logotext\">\r\n");
      out.write("                            Inquiryhere\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- <img src=\"images/logo/logo.png\" style=\"width:150px;\"> -->\r\n");
      out.write("                    </h4>\r\n");
      out.write("                </a></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12 serachhere\" style=\"display:inline-block;\">\r\n");
      out.write("\r\n");
      out.write("            <div style=\"overflow: hidden; padding-right: .5em;\">\r\n");
      out.write("                <form action=\"SearchBar.jsp\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("                    <input type=\"text\" style=\"width: 100%;\" name=\"search\" required=\"\" >\r\n");
      out.write("                    <button type=\"submit\" style=\"float: right;width: 50px;\" />");
      out.print(SEARCH);
      out.write("</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-lg-2 col-md-2 col-sm-12 col-xs-12 float-right textalign-right\">\r\n");
      out.write("            ");
if (session.getAttribute("email") == null) {
      out.write("<a href=\"Login.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white;padding-right: 50px; \">");
      out.print(LOGIN);
      out.write("</a>");
 }
      out.write("\r\n");
      out.write("            <a href=\"index.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white;padding-right: 50px; \">");
      out.print(HOME);
      out.write("</a>\r\n");
      out.write("            <a href=\"help.jsp?sl=");
      out.print(sl);
      out.write("\"><img src=\"images/home/HelpIcon.png\" class=\"helpicon\"/></a>\r\n");
      out.write("            ");
 if (session.getAttribute("email") != null) {
      out.write(" \r\n");
      out.write("            <a href=\"#\" class=\"notification\" data-toggle=\"modal\" data-target=\"#myModalN\">\r\n");
      out.write("                <span>Inbox</span>\r\n");
      out.write("                <span class=\"badge\">0</span>\r\n");
      out.write("            </a> ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-1 col-md-1 col-sm-12 col-xs-12 float-right textalign-right\">\r\n");
      out.write("            \r\n");
      out.write("             \r\n");
      out.write("            ");
 // Database connection details 
                String DB_URL = "jdbc:mysql://localhost/bharat";
                String DB_USERNAME = "root";
                String DB_PASSWORD = null;
            
      out.write("\r\n");
      out.write("            ");

                if (session.getAttribute("URL") != null) {
                    session.setAttribute("URL", null);
                }
            
      out.write("\r\n");
      out.write("            ");

                 int id_of_user = 0;
                String email = (String) session.getAttribute("email");
                if (email == null) {
            
      out.write("<select class=\"helpicon w100 username\" onchange=\"location = this.value;\">\r\n");
      out.write("                <option value=\"Login.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(SELECT);
      out.write("</option>\r\n");
      out.write("                <option value=\"Login.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(LOGIN);
      out.write("</option>\r\n");
      out.write("                <option value=\"AboutUs.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(ABOUT_US);
      out.write("</option>\r\n");
      out.write("                <option value=\"ContactUs.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(CONTACT_US);
      out.write("</option>\r\n");
      out.write("                ");
  if(sl.equalsIgnoreCase("hi")){    
      out.write("\r\n");
      out.write("                <option value=\"index.jsp?sl=en\">English</option>\r\n");
      out.write("                ");
 }else{ 
      out.write("\r\n");
      out.write("                <option value=\"index.jsp?sl=hi\">हिन्दी</option> \r\n");
      out.write("                       ");
 } 
      out.write("\r\n");
      out.write("            </select>");

            } else {

                Statement stmt;
                Connection con;
                ResultSet rs;
                String name = null;
               
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                    stmt = con.createStatement();
                    String p = "SELECT * FROM newuser WHERE email = '" + email + "'";
                    rs = stmt.executeQuery(p);
                    while (rs.next()) {
                        id_of_user = rs.getInt("id");
                        name = rs.getString("firstname");
                    }
                    stmt.close();
                    con.close();
                    rs.close();
                } catch (Exception e) {
                    out.println("Unable to retrieve!!" + e);
                }
            
      out.write("\r\n");
      out.write("            <select class=\"helpicon w100 username\" onchange=\"location = this.value;\">\r\n");
      out.write("                <option value=\"index.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(name);
      out.write("</option>\r\n");
      out.write("                <option value=\"profile.jsp?ID=");
      out.print(id_of_user);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(PROFILE);
      out.write("</option>\r\n");
      out.write("                <option value=\"AboutUs.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(ABOUT_US);
      out.write("</option>\r\n");
      out.write("                <option value=\"ContactUs.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(CONTACT_US);
      out.write("</option>\r\n");
      out.write("                 ");
  if(sl.equalsIgnoreCase("hi")){    
      out.write("\r\n");
      out.write("                <option value=\"index.jsp?sl=en\">English</option>\r\n");
      out.write("                ");
 }else{ 
      out.write("\r\n");
      out.write("                <option value=\"index.jsp?sl=hi\">हिन्दी</option> \r\n");
      out.write("                       ");
 } 
      out.write("\r\n");
      out.write("                <option value=\"Logout.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(LOGOUT);
      out.write("</option>\r\n");
      out.write("            </select>");

                }
            
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("            <div class=\"bodydata\">\r\n");
      out.write("                <div class=\"container clear-fix\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                            <div class=\"row\"><center>\r\n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                Thanks for your interest in Inquiryhere.com\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                Why InquiryHere Exists ?\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                InquiryHere's mission is to share and grow the world?s knowledge. A vast amount of the knowledge that would be valuable to many people is currently only available to a few ? either locked in people?s heads, or only accessible to select groups. We want to connect the people who have knowledge to the people who need it, to bring together people with different perspectives so they can understand each other better, and to empower everyone to share their knowledge for the benefit of the rest of the world.\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </center> \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clear-fix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("            <!-- Bootstrap JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("            <!-- Bootstrap Select JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("        </div> \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
