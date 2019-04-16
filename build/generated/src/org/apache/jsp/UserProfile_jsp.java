package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class UserProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";


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

              String USER_PROFILE = "";
            String FOLLOW = "";
            String FOLLOWED = "";
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/site.jsp");
    _jspx_dependants.add("/validator.jsp");
    _jspx_dependants.add("/notificationhtml.jsp");
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
      out.write('\r');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                USER_PROFILE = "प्रोफ़ाइल";
                FOLLOW = "फॉलो करे";
                FOLLOWED = "फॉलो कर चुके हैं";

            } else {
                USER_PROFILE = "User Profile";
                FOLLOW = "Follow";
                FOLLOWED = "Followed";
            }
        
      out.write("\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <title>User Profie</title>\r\n");
      out.write("        <meta property=\"og:description\" content=\"india first knowledge based social media where experts give you advise and suggestion related to your query .you can ask and share the information which you want to explore.our motive is to be specific according to your demand\" />\r\n");
      out.write("        <meta property=\"og:image\" content=\"https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG\" />\r\n");
      out.write("        <meta property=\"og:type\" content=\"website\">\r\n");
      out.write("        <meta property=\"og:locale\" content=\"en_US\">\r\n");
      out.write("        <meta property=\"og:title\" content=\"india first knowledge based social media platform where experts give you advise and suggestion related to your query\" />\r\n");
      out.write("        <meta property=\"og:url\" content=\"https://www.inquiryhere.com/\">\r\n");
      out.write("        <meta property=\"og:site_name\" content=\"https://www.inquiryhere.com/\" />\r\n");
      out.write("\r\n");
      out.write("        <!-- Main style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            function take_value(el,user_id, id_of_user) {\r\n");
      out.write("            ");
 if (session.getAttribute("email") == null) { 
      out.write("\r\n");
      out.write("                alert(\"Please login first\");");

                } else { 
      out.write("\r\n");
      out.write("                if (el.value === \"follow\") {\r\n");
      out.write("                    el.value = \"followed\";\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_follower_detail.jsp?val_topic=\" + user_id + \"&val2_topic=\" + id_of_user + \"&action=follow\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                } else {\r\n");
      out.write("                    el.value = \"follow\";\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_follower_detail.jsp?val_topic=\" + user_id + \"&val2_topic=\" + id_of_user + \"&action=delete\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                }\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-page-wrapper\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            ");

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
            
      out.write("\r\n");
      out.write("            <div class=\"bodydata\">\r\n");
      out.write("                <div class=\"container clear-fix\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;margin-bottom:0px;\">\r\n");
      out.write("                                        <div class=\"boxHeading\">\r\n");
      out.write("                                            ");
      out.print(USER_PROFILE);
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <!-- <div style=\"\">Post something here</div> -->\r\n");
      out.write("                                        <div class=\"userProfiles\">\r\n");
      out.write("                                            ");

                                                int id_of_user = 0;
                                                if(session.getAttribute("Session_id_of_user") != null){
                                                    id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                                                }
//                                                if (session.getAttribute("email") != null) {
//                                                    String email = (String) session.getAttribute("email");
//                                                    try {
//                                                        String sql = "SELECT * FROM newuser WHERE email = '" + email + "'";
//                                                        preparedStatement = connection.prepareStatement(sql);
//                                                        resultSet = preparedStatement.executeQuery();
//                                                        while (resultSet.next()) {
//                                                            id_of_user = resultSet.getInt("id");
//                                                        }
//                                                    } catch (Exception e) {
//                                                        out.println("Unable to retrieve!!" + e);
//                                                    }
//                                                }
                                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            ");

                                                String firstname, imagepath;
                                                int user_id = 0;
                                                String Status = null;
                                                try {
                                                    String sql = "SELECT ID,firstname,imagepath FROM newuser";
                                                    preparedStatement = connection.prepareStatement(sql);
                                                    resultSet = preparedStatement.executeQuery();
                                                    while (resultSet.next()) {
                                                        user_id = resultSet.getInt("ID");
                                                        firstname = resultSet.getString("firstname");
                                                        imagepath = resultSet.getString("imagepath");
                                                        Statement stmt_topic_followers;

                                                        ResultSet rs_topic_followers;
                                                        stmt_topic_followers = connection.createStatement();
                                                        String topic_followers = "SELECT * FROM ak_follower_detail";
                                                        rs_topic_followers = stmt_topic_followers.executeQuery(topic_followers);

                                                        while (rs_topic_followers.next()) {
                                                            int db_user_id = rs_topic_followers.getInt("user_id");
                                                            int f_followers_id = rs_topic_followers.getInt("followers_id");

                                                            if ((db_user_id == user_id) && (f_followers_id == id_of_user)) {
                                                                Status = "present";
                                                            }
                                                        }
                                                        stmt_topic_followers.close();
                                                        rs_topic_followers.close();
                                            
      out.write("\r\n");
      out.write("                                            <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                                <img src=\"images/");
      out.print(imagepath);
      out.write("\" alt=\"\" style=\"width:100%; border:1px solid #ddd;margin-top:20px;\">\r\n");
      out.write("                                                <a href=\"profile.jsp?user=");
      out.print(convertStringUpperToLower(firstname).replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(user_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(convertStringUpperToLower(firstname));
      out.write("</a>\r\n");
      out.write("                                                ");

                                                    if (Status == "present") {
                                                        
      out.write("<input type=\"button\" class=\"float-right\" value=\"unfollow\" id=\"myButton1\" onclick=\"return take_value(this,'");
      out.print(user_id);
      out.write("', '");
      out.print(id_of_user);
      out.write("');\" />");

                                                    } else {
      out.write("\r\n");
      out.write("                                                <input type=\"button\" class=\"float-right\" value=\"follow\" id=\"myButton1\" onclick=\"return take_value(this,'");
      out.print(user_id);
      out.write("', '");
      out.print(id_of_user);
      out.write("');\" />\r\n");
      out.write("                                                ");
 }
                                                    Status = null;
                                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");

                                                    }

                                                } catch (Exception e) {
                                                    out.println(e.getMessage());
                                                }
                                            
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        ");

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
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row margintop10\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("<!--                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"themeBox\" style=\"min-height:320px;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    Module\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    Need to write something   \r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                            <div class=\"themeBox\" style=\"min-height:240px;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    Module\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    Second module   \r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>-->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      out.write("<div class=\"modal fade\" id=\"myModalN\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <!-- Modal content-->\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title\">Your current notification</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div>\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "NodificationScript.jsp", out, false);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <!-- Bootstrap JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <!-- Bootstrap Select JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("        </div> <!-- /.main-page-wrapper -->\r\n");
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
