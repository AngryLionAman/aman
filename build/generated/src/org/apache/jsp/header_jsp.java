package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public String firstName(String str) {
        try {
            if (str != null && str.length() > 0 && !(str.trim()).equals("null") && !str.equals("") && !str.equals(" ")) {

                String[] final_word = str.split("\\s");
                return final_word[0].substring(0, 1).toUpperCase() + final_word[0].substring(1).toLowerCase();
            } else {
                return null;
            }

        } catch (Exception msg) {
            return msg.toString();
        }
    }


    public String convertStringUpperToLower(String sentence) {
        String finalSentenct = "";
        try {
            //To remove white space before word start, if having
            while (true) {
                if (sentence.charAt(0) == 32) {
                    sentence = sentence.substring(1);
                } else {
                    break;
                }
            }
            //To remove white space at the end of the sentence, if having
            while (true) {
                if (sentence.charAt(sentence.length() - 1) == 32) {
                    sentence = sentence.substring(0, sentence.length() - 1);
                } else {
                    break;
                }
            }
            //If sentence having the multiple space
            //To remive the middle sentence white space if having
            //This can also remove the pre word and post word white spaces but
            // removies the last char of the sentence
            char[] c = sentence.toCharArray();
            String str1 = "";
            //If you don't use the '=' (equals) then will missed the last char
            for (int i = 0; i < sentence.length(); i++) {
                if ((c[i] == ' ' && c[i + 1] != ' ') || (c[i] != ' ')) {
                    str1 += c[i];
                }
            }
            //Splitin the sentence into words
            String[] word = str1.split(" ");
            //Captlizing the every word
            for (int i = 0; i < word.length; i++) {
                word[i] = word[i].substring(0, 1).toUpperCase() + word[i].substring(1).toLowerCase();
                finalSentenct += word[i] + " ";
            }

//Remove the last white space if having
//in my case , last char is defenetaly has a white space,just look at the two line up
            while (true) {
                if (finalSentenct.charAt(finalSentenct.length() - 1) == 32) {
                    finalSentenct = finalSentenct.substring(0, finalSentenct.length() - 1);
                } else {
                    break;
                }
            }
//end of the script
        } catch (Exception msg) {
            finalSentenct = msg.toString();
        }
        return finalSentenct;
    }

    public int nullIntconvert(String str) {
        int num = 0;
        if (str == null) {
            str = "0";
        } else if ((str.trim()).equals("null")) {
            str = "0";
        } else if (str.equals("")) {
            str = "0";
        }
        try {
            num = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return num;
    }

    public String nullStringconvert(String category) {
        String cat = "All";

        if (category == null) {
            category = "All";
        } else if ((category.trim()).equals("null")) {
            category = "All";
        } else if (category.equals("")) {
            category = "All";
        }
        cat = category;
        return cat;
    }


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";


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
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/validator.jsp");
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write('\n');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

    //String page_name = request.getParameter("page");
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
    if (sl.equalsIgnoreCase("hi")) {
        EMAIL = "ईमेल";
        PASSWORD = "पासवर्ड";
        HOME = "होम";
        LOGIN = "Login";
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
        CONTACT_US = "Contact Us";
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
      out.write("                    <input type=\"text\" style=\"width: 100%;\" name=\"search\" required=\"\">\r\n");
      out.write("<!--                    <button type=\"submit\" style=\"float: right;width: 50px;\" />");
      out.print(SEARCH);
      out.write("</button>-->\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-lg-2 col-md-2 col-sm-12 col-xs-12 float-right textalign-right\">\r\n");
      out.write("            ");
  if (sl.equalsIgnoreCase("hi")) {    
      out.write("\r\n");
      out.write("            <a href=\"index.jsp?sl=en\" class=\"helpicon\"  style=\"color: white;padding-left: 10px;padding-right: 40px;\">English</a>\r\n");
      out.write("            ");
 } else { 
      out.write("\r\n");
      out.write("            <a href=\"index.jsp?sl=hi\" class=\"helpicon\"  style=\"color: white;padding-left: 10px;padding-right: 30px;\">हिन्दी</a>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("             ");
 if (session.getAttribute("email") != null) {
      out.write(" \r\n");
      out.write("            <a href=\"#\" data-toggle=\"modal\" class=\"helpicon\" data-target=\"#myModalN\" style=\"color: white;padding-left: 10px;padding-right: 10px;\">\r\n");
      out.write("<!--                <span></span>--> Inbox\r\n");
      out.write("<!--                <span class=\"badge\">0</span>-->\r\n");
      out.write("            </a> \r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <a href=\"help.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\"  style=\"color: white;padding-left: 10px;padding-right: 10px;\">Help</a>\r\n");
      out.write("            <a href=\"index.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white;padding-left: 10px;padding-right: 30px;\">");
      out.print(HOME);
      out.write("</a>\r\n");
      out.write("            \r\n");
      out.write("            ");
if (session.getAttribute("email") == null) {
      out.write("\r\n");
      out.write("            <a href=\"Login.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white;padding-left: 10px;padding-right: 30px;\">");
      out.print(LOGIN);
      out.write("</a>\r\n");
      out.write("            <a href=\"signup.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\"  style=\"color: white;padding-left: 10px;padding-right: 30px;\">SIgnUp</a>\r\n");
      out.write("            ");
 } else {
               // String DB_URL = "jdbc:mysql://localhost/bharat";
               // String DB_USERNAME = "root";
               // String DB_PASSWORD = null;

                Statement stmt;
                Connection con;
                ResultSet rs;
                String fullName = null;
                String email = (String) session.getAttribute("email");
                int id_of_user = 0;

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
                    stmt = con.createStatement();
                    String p = "SELECT * FROM newuser WHERE email = '" + email + "'";
                    rs = stmt.executeQuery(p);
                    while (rs.next()) {
                        id_of_user = rs.getInt("id");
                        fullName = rs.getString("firstname");
                    } 
                    stmt.close();
                    con.close();
                    rs.close();
                } catch (Exception e) {
                    out.println("Unable to retrieve!!" + e);
                }
            
      out.write("\r\n");
      out.write("            <a href=\"Logout.jsp?sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white;padding-left: 10px;padding-right: 30px;\">Logout</a>\r\n");
      out.write("            <a href=\"profile.jsp?user=");
      out.print(fullName.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(id_of_user);
      out.write("&sl=");
      out.print(sl);
      out.write("\" class=\"helpicon\" style=\"color: white;padding-left: 10px;padding-right: 30px;\"><b>");
      out.print(firstName(fullName));
      out.write("</b></a>\r\n");
      out.write("            ");

                }
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</header>");
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
