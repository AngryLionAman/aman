package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class uploadEverything_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/site.jsp");
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

      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    ");
      out.write("\n");
      out.write("    \n");
      out.write("     \n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("\n");
      out.write("        <!-- For IE -->\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\n");
      out.write("        <!-- For Resposive Device -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <title>Update Profile | InquiryHere.com</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <!-- responsive style sheet -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\n");
      out.write("        <style>\n");
      out.write("            input[type=text] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 4px 8px;\n");
      out.write("                margin: 4px 0;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                border: 1px solid red;\n");
      out.write("                border-radius: 2px;\n");
      out.write("            }\n");
      out.write("            textarea[type=text]{\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 4px 8px;\n");
      out.write("                margin: 4px 0;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                border: 1px solid red;\n");
      out.write("                border-radius: 2px;\n");
      out.write("            }\n");
      out.write("            .button {\n");
      out.write("                background-color: #4CAF50; /* Green */\n");
      out.write("                border: 1px solid red;\n");
      out.write("                color: white;\n");
      out.write("                padding: 15px 32px;\n");
      out.write("                text-align: center;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: inline-block;\n");
      out.write("                font-size: 16px;\n");
      out.write("                margin: 4px 2px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .button1 {width: 250px;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"main-page-wrapper\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("eng", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("            <div class=\"clear-fix\"></div>\n");
      out.write("            <div class=\"bodydata\">\n");
      out.write("                <div class=\"container clear-fix\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        ");

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
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">                                                   \n");
      out.write("                            <div class=\"row\"><center>                                                           \n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\n");
      out.write("\n");
      out.write("                                            <form action=\"saveUploadEverything.jsp\" method=\"post\" >\n");
      out.write("\n");
      out.write("                                                <label for=\"fname\">What you want to upload</label>\n");
      out.write("                                                <div class=\"boxHeading\">\n");
      out.write("                                                    <input type=\"text\" id=\"fname\" list=\"page\" name=\"page\" required=\"\">\n");
      out.write("                                                    <datalist id=\"page\">\n");
      out.write("                                                        ");

                                                            try {
                                                                String sql_page = "SELECT DISTINCT page FROM everything";
                                                                preparedStatement = connection.prepareStatement(sql_page);
                                                                resultSet = preparedStatement.executeQuery();
                                                                while (resultSet.next()) {
                                                                    String page_list = resultSet.getString("page").toUpperCase();
                                                        
      out.write("<option value=\"");
      out.print(page_list);
      out.write('"');
      out.write('>');

                                                                }
                                                            } catch (Exception msg) {
                                                                out.println(msg);
                                                            }

                                                            
      out.write("\n");
      out.write("\n");
      out.write("                                                    </datalist>\n");
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                                <label for=\"fname\">what is the Category</label>\n");
      out.write("                                                <div class=\"boxHeading\">\n");
      out.write("                                                    <input type=\"text\" id=\"fname\" list=\"category\" name=\"category\" required=\"\">\n");
      out.write("                                                    <datalist id=\"category\">\n");
      out.write("                                                        ");
                                                            try {
                                                                String sql_page = "SELECT DISTINCT category FROM everything WHERE category IS NOT NULL";
                                                                preparedStatement = connection.prepareStatement(sql_page);
                                                                resultSet = preparedStatement.executeQuery();
                                                                while (resultSet.next()) {
                                                                    String category = resultSet.getString("category").toUpperCase();
                                                        
      out.write("<option value=\"");
      out.print(category);
      out.write('"');
      out.write('>');

                                                                }
                                                            } catch (Exception msg) {
                                                                out.println(msg);
                                                            }

                                                            
      out.write("\n");
      out.write("\n");
      out.write("                                                    </datalist>\n");
      out.write("                                                </div>\n");
      out.write("                                                <label for=\"fname\">This is Based on</label>\n");
      out.write("                                                <div class=\"boxHeading\">\n");
      out.write("                                                    <input type=\"text\" id=\"fname\" list=\"based_on\" name=\"based_on\" value=\"\" >\n");
      out.write("                                                    <datalist id=\"based_on\">\n");
      out.write("                                                        ");
                                                            try {
                                                                String sql_page = "SELECT DISTINCT based_on FROM everything WHERE based_on IS NOT NULL";
                                                                preparedStatement = connection.prepareStatement(sql_page);
                                                                resultSet = preparedStatement.executeQuery();
                                                                while (resultSet.next()) {
                                                                    String based_on = resultSet.getString("based_on").toUpperCase();
                                                        
      out.write("<option value=\"");
      out.print(based_on);
      out.write('"');
      out.write('>');

                                                                }
                                                            } catch (Exception msg) {
                                                                out.println(msg);
                                                            }

                                                            
      out.write("\n");
      out.write("\n");
      out.write("                                                    </datalist>\n");
      out.write("                                                </div>\n");
      out.write("                                                <label for=\"fname\">subject for this input</label>\n");
      out.write("                                                <div class=\"boxHeading\">\n");
      out.write("                                                    <input type=\"text\" id=\"fname\" name=\"subject\" value=\"\" >\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <label for=\"fname\">Full detail of this input</label>\n");
      out.write("                                                <div class=\"boxHeading\">\n");
      out.write("                                                    <textarea type=\"text\" class=\"anstext\" name=\"description\"  ></textarea>\n");
      out.write("                                                </div>\n");
      out.write("                                                <label for=\"fname\">Author</label>\n");
      out.write("                                                <div class=\"boxHeading\">\n");
      out.write("                                                    <input type=\"text\" id=\"fname\" name=\"author\" list=\"author\" value=\"\" >\n");
      out.write("                                                    <datalist id=\"author\">\n");
      out.write("                                                        ");
                                                            try {
                                                                String sql_page = "SSELECT DISTINCT author FROM everything WHERE author IS NOT NULL";
                                                                preparedStatement = connection.prepareStatement(sql_page);
                                                                resultSet = preparedStatement.executeQuery();
                                                                while (resultSet.next()) {
                                                                    String author = resultSet.getString("author").toUpperCase();
                                                        
      out.write("<option value=\"");
      out.print(author);
      out.write('"');
      out.write('>');

                                                                }
                                                            } catch (Exception msg) {
                                                                out.println(msg);
                                                            }

                                                            
      out.write("\n");
      out.write("\n");
      out.write("                                                    </datalist>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"float-right margintop20\" style=\"vertical-align:bottom\">\n");
      out.write("                                                    <button type=\"submit\" class=\"btn\" data-toggle=\"modal\" >Save</button>\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                            </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </center> </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        ");
                            } catch (Exception e) {
                                out.println("Error in main try block:-" + e);
                            } finally {

                                try {
                                    if (connection != null || !connection.isClosed()) {
                                        try {
                                            connection.close();
                                        } catch (Exception e) {
                                            out.println("Exception in closing connection " + e);
                                        }
                                    }
                                } catch (Exception msg) {
                                    out.println("Error in connection" + msg);
                                }
                                try {
                                    if (resultSet != null || !resultSet.isClosed()) {
                                        try {
                                            resultSet.close();
                                        } catch (Exception e) {
                                            out.println("Exception in closing resulatset " + e);
                                        }
                                    }
                                } catch (Exception msg) {
                                    out.println("Error in connection" + msg);
                                }
                                try {
                                    if (preparedStatement != null || !preparedStatement.isClosed()) {
                                        try {
                                            preparedStatement.close();
                                        } catch (Exception e) {
                                            out.println("Exception in closing preparedStatement " + e);
                                        }
                                    }
                                } catch (Exception msg) {
                                    out.println("Error in connection" + msg);
                                }
                            }
                        
      out.write("\n");
      out.write("                        <div class=\"clear-fix\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clear-fix\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clear-fix\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"clear-fix\"></div>\n");
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
      out.write("            <div class=\"modal-footer\">                                                    \n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">close</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("eng", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\n");
      out.write("            <!-- Bootstrap JS -->\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("            <!-- Bootstrap Select JS -->\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\n");
      out.write("\n");
      out.write("        </div> \n");
      out.write("    </body>\n");
      out.write("\n");
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
