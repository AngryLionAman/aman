package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class blog_jsp extends org.apache.jasper.runtime.HttpJspBase
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

            
            String WELCOME_NOTES = "";
        
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

      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <!-- For IE -->\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\n");
      out.write("        <!-- For Resposive Device -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <title>Blog By User | InquiryHere.com</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <!-- responsive style sheet -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\n");
      out.write("        <meta property=\"og:description\" content=\"india first knowledge based social media where experts give \n");
      out.write("              you advise and suggestion related to your query .you can ask and share the \n");
      out.write("              information which you want to explore.our motive is to be specific according to your demand\" />\n");
      out.write("        <meta property=\"og:image\" content=\"https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG\" />\n");
      out.write("        <meta property=\"og:type\" content=\"website\">\n");
      out.write("        <meta property=\"og:locale\" content=\"en_US\">\n");
      out.write("        <meta property=\"og:title\" content=\"india first knowledge based social media platform where experts give\n");
      out.write("              you advise and suggestion related to your query\" />\n");
      out.write("        <meta property=\"og:url\" content=\"https://www.inquiryhere.com/\">\n");
      out.write("        <meta property=\"og:site_name\" content=\"https://www.inquiryhere.com/\" />\n");
      out.write("        \n");
      out.write("         \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            //String page_name = request.getParameter("page");
            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                WELCOME_NOTES = "inquiryhere.com में आपकी रुचि के लिए धन्यवाद";
            } else {
                WELCOME_NOTES = "Thanks for your interest in Inquiryhere.com";
            }
        
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"main-page-wrapper\">\n");
      out.write("            <!-- Header _________________________________ -->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\n");
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
            
      out.write("\n");
      out.write("            <div class=\"clear-fix\"></div>\n");
      out.write("            <div class=\"bodydata\">\n");
      out.write("                <div class=\"container clear-fix\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                ");

                                    ResultSet rs1 = null;
                                    ResultSet rs2 = null;
                                    ResultSet rs3 = null;
                                    PreparedStatement ps1 = null;
                                    PreparedStatement ps2 = null;
                                    PreparedStatement ps3 = null;
                                    // Connection connection2 = null;

                                    int showRows = 10;
                                    int totalRecords = 5;
                                    int totalRows = nullIntconvert(request.getParameter("totalRows"));
                                    int totalPages = nullIntconvert(request.getParameter("totalPages"));
                                    int iPageNo = nullIntconvert(request.getParameter("iPageNo"));
                                    int cPageNo = nullIntconvert(request.getParameter("cPageNo"));

                                    int startResult = 0;
                                    int endResult = 0;
                                    if (iPageNo == 0) {
                                        iPageNo = 0;
                                    } else {
                                        iPageNo = Math.abs((iPageNo - 1) * showRows);
                                    }
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);

                                        String query1 = "SELECT SQL_CALC_FOUND_ROWS * FROM blog LEFT JOIN newuser ON newuser.id = blog.blog_posted_by LIMIT " + iPageNo + "," + showRows + "";
                                        ps1 = connection.prepareStatement(query1);
                                        rs1 = ps1.executeQuery();

                                        String query2 = "SELECT FOUND_ROWS() as cnt";
                                        ps2 = connection.prepareStatement(query2);
                                        rs2 = ps2.executeQuery();
                                    } catch (Exception error) {
                                        out.println("Error occer in :" + error);
                                    }
                                    try {
                                        if (rs2.next()) {
                                            totalRows = rs2.getInt("cnt");
                                        }

                                
      out.write("\n");
      out.write("                                <form>\n");
      out.write("\n");
      out.write("                                    <input type=\"hidden\" name=\"iPageNo\" value=\"");
      out.print(iPageNo);
      out.write("\">\n");
      out.write("                                    <input type=\"hidden\" name=\"cPageNo\" value=\"");
      out.print(cPageNo);
      out.write("\">\n");
      out.write("                                    <input type=\"hidden\" name=\"showRows\" value=\"");
      out.print(showRows);
      out.write("\">\n");
      out.write("                                    ");

                                        while (rs1.next()) {
                                    
      out.write("\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\n");
      out.write("\n");
      out.write("                                        <div class=\"boxHeading\">\n");
      out.write("                                            <a href=\"D_Blog.jsp?blog_sub=");
      out.print(rs1.getString("blog_subject").replaceAll(" ", "-"));
      out.write("&Blog_Id=");
      out.print(rs1.getString("blog_id"));
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(rs1.getString("blog_subject"));
      out.write("</a>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"questionArea\">\n");
      out.write("\n");
      out.write("                                            <div class=\"postedBy\">Published BY :<a href=\"profile.jsp?user=");
      out.print(convertStringUpperToLower(rs1.getString("firstname")).replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(rs1.getString("blog_posted_by"));
      out.write("&sl=");
      out.print(sl);
      out.write("\"> ");
      out.print(convertStringUpperToLower(rs1.getString("firstname")));
      out.write("</a></div>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    ");

                                            }
                                        } catch (Exception e) {
                                            out.println(e);
                                        }

                                    
      out.write("\n");
      out.write("\n");
      out.write("                                    ");
                                            try {
                                            if (totalRows < (iPageNo + showRows)) {
                                                endResult = totalRows;
                                            } else {
                                                endResult = (iPageNo + showRows);
                                            }
                                            startResult = (iPageNo + 1);
                                            totalPages = ((int) (Math.ceil((double) totalRows / showRows)));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    
      out.write("\n");
      out.write("                                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" >\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"3\">\n");
      out.write("                                                <div>\n");
      out.write("                                                    ");

                                                        int i = 0;
                                                        int cPage = 0;
                                                        if (totalRows != 0) {
                                                            cPage = ((int) (Math.ceil((double) endResult / (totalRecords * showRows))));

                                                            int prePageNo = (cPage * totalRecords) - ((totalRecords - 1) + totalRecords);
                                                            if ((cPage * totalRecords) - (totalRecords) > 0) {
                                                    
      out.write("\n");
      out.write("                                                    <a href=\"quotes.jsp?iPageNo=");
      out.print(prePageNo);
      out.write("&cPageNo=");
      out.print(prePageNo);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> << Previous</a>\n");
      out.write("                                                    ");

                                                        }
                                                        for (i = ((cPage * totalRecords) - (totalRecords - 1)); i <= (cPage * totalRecords); i++) {
                                                            if (i == ((iPageNo / showRows) + 1)) {
      out.write("\n");
      out.write("                                                    <a href=\"quotes.jsp?iPageNo=");
      out.print(i);
      out.write("&sl=");
      out.print(sl);
      out.write("\" style=\"cursor:pointer;color:red\"><b>");
      out.print(i);
      out.write("</b></a>\n");
      out.write("                                                            ");

                                                            } else if (i <= totalPages) {
                                                            
      out.write("\n");
      out.write("                                                    <a href=\"quotes.jsp?iPageNo=");
      out.print(i);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\n");
      out.write("                                                    ");

                                                            }
                                                        }
                                                        if (totalPages > totalRecords && i < totalPages) {
                                                    
      out.write("\n");
      out.write("                                                    <a href=\"quotes.jsp?iPageNo=");
      out.print(i);
      out.write("&cPageNo=");
      out.print(i);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> >> Next</a>\n");
      out.write("                                                    ");

                                                            }
                                                        }
                                                    
      out.write("\n");
      out.write("                                                    <b>Rows ");
      out.print(startResult);
      out.write(" - ");
      out.print(endResult);
      out.write(", Total Rows ");
      out.print(totalRows);
      out.write(" </b>\n");
      out.write("                                                </div>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </form>\n");
      out.write("                                ");

                                    try {
                                        if (ps1 != null) {
                                            ps1.close();
                                        }
                                        if (rs1 != null) {
                                            rs1.close();
                                        }

                                        if (ps2 != null) {
                                            ps2.close();
                                        }
                                        if (rs2 != null) {
                                            rs2.close();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\n");
      out.write("                                <div class=\"boxHeading\">\n");
      out.write("                                    Fun Zone\n");
      out.write("                                </div>\n");
      out.write("                                <div>\n");
      out.write("                                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "funZoneList.jsp", out, false);
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\n");
      out.write("                                <div class=\"boxHeading\">\n");
      out.write("                                    Education Zone\n");
      out.write("                                </div>\n");
      out.write("                                <div>\n");
      out.write("                                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "eduZoneList.jsp", out, false);
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clear-fix\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clear-fix\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clear-fix\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"clear-fix\"></div>\n");
      out.write("            ");

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
                    /*if (resultSet != null || !resultSet.isClosed()) {
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
                    }*/
                }
            
      out.write("\n");
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
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\n");
      out.write("            <!-- Bootstrap JS -->\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("            <!-- Bootstrap Select JS -->\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\n");
      out.write("        </div> \n");
      out.write("    </body>\n");
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
