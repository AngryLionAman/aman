package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class D_005fBlog_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String SUBJECT = "";
            String POSTED_BY = "";
            String DESCRIPTION = "";
            String COMPLETE_YOUR_PROFILE = "";
            String TRENDING_QUUESTION = "";
        

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
                SUBJECT = "विषय";
                POSTED_BY = "द्वारा प्रकाशित";
                DESCRIPTION = "विवरण";
                COMPLETE_YOUR_PROFILE = "अपनी प्रोफाइल पूरी कीजिए";
                TRENDING_QUUESTION = "ट्रेंडिंग सवाल";

            } else {
                SUBJECT = "Subject";
                POSTED_BY = "Posted by";
                DESCRIPTION = "Description";
                COMPLETE_YOUR_PROFILE = "Complete your profile";
                TRENDING_QUUESTION = "Trending question";
            }
        
      out.write("\r\n");
      out.write("        ");

            request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
            String str = request.getParameter("Blog_Id");
            //String str = request.getParameter("id");
            if (str == null || str.length() <= 0) {
                response.sendRedirect("index.jsp?sl=" + sl);
            }
            String Question = "";

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > 47 && str.charAt(i) < 58) {
                    Question += str.charAt(i);
                }
            }

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script src=\"ckeditor/ckeditor.js\"></script>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-128307055-1\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            window.dataLayer = window.dataLayer || [];\r\n");
      out.write("            function gtag() {\r\n");
      out.write("                dataLayer.push(arguments);\r\n");
      out.write("            }\r\n");
      out.write("            gtag('js', new Date());\r\n");
      out.write("            gtag('config', 'UA-128307055-1');\r\n");
      out.write("        </script> \r\n");
      out.write("        \r\n");
      out.write("         \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
            
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
      out.write("        ");

            String StoredQuestion = "";
            String StoredAnswer = "";
            String FirstName = "";
            int UserID = 0;
            if(Question != null){
            try {
                String p = "SELECT b.blog_subject, substring(b.blog,1,500),user.firstname,user.id FROM blog b right join newuser user on b.blog_posted_by = user.Id  WHERE blog_id = '" + Question + "'";
                preparedStatement = connection.prepareStatement(p);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    StoredQuestion = resultSet.getString("blog_subject");
                    StoredAnswer = resultSet.getString("substring(b.blog,1,500)");
                    FirstName = resultSet.getString("firstname");
                    UserID = resultSet.getInt("ID");
                }
            } catch (Exception e) {
                out.println("Unable to retrieve!!" + e);
            }
           }
        
      out.write("\r\n");
      out.write("        <title>");
      out.print(StoredQuestion);
      out.write("</title>\r\n");
      out.write("        <meta property=\"og:title\" content=\"");
      out.print(StoredQuestion);
      out.write("\" />\r\n");
      out.write("        <meta property=\"og:description\" content=\"");
      out.print(StoredAnswer);
      out.write("\"/>\r\n");
      out.write("        <meta property=\"og:url\" content=\"https://www.inquiryhere.com/\">\r\n");
      out.write("        <meta property=\"og:site_name\" content=\"https://www.inquiryhere.com/\" />\r\n");
      out.write("        <meta property=\"og:image\" content=\"https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG\" />\r\n");
      out.write("        <meta property=\"og:type\" content=\"website\">\r\n");
      out.write("        <meta property=\"og:locale\" content=\"en_US\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Header _________________________________ -->\r\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("            <div class=\"bodydata\">\r\n");
      out.write("                <div class=\"container clear-fix\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\">\r\n");
      out.write("\r\n");
      out.write("                                            ");
      out.print(SUBJECT);
      out.write(" :  ");
      out.print(StoredQuestion);
      out.write(" \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"questionArea\">\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"postedBy\">");
      out.print(POSTED_BY);
      out.write(" :<a href=\"profile.jsp?user=");
      out.print(FirstName.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(UserID);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(FirstName);
      out.write("</a></div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"boxHeading marginbot10\">");
      out.print(DESCRIPTION);
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("                                    ");

                                        
                                        try {
                                            String p = "SELECT * FROM blog WHERE  blog_id = '" + Question + "'";
                                            preparedStatement = connection.prepareStatement(p);
                                            resultSet = preparedStatement.executeQuery();
                                            while (resultSet.next()) {
                                                String answer = resultSet.getString("blog");
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\" style=\"font-size: 15px;font-family: Arial, Helvetica, sans-serif;\">\r\n");
      out.write("                                            ");
      out.print(answer);
      out.write(" \r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");

                                            }

                                        } catch (Exception e) {
                                            out.println("Unable to retrieve!!" + e);
                                        } 
                                    
      out.write("\r\n");
      out.write("                                    ");

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
      out.write("                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("                            ");

                                if (session.getAttribute("email") != null) {
                            
      out.write("\r\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    ");
      out.print(COMPLETE_YOUR_PROFILE);
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CompleteUserProfile.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("                            </div>");
 }
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clear-fix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\">\r\n");
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
      out.write("            <div class=\"modal-footer\">                                                    \n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">close</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("              ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("            <!-- Bootstrap JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("            <!-- Bootstrap Select JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("        </div> <!-- /.main-page-wrapper -->\r\n");
      out.write("\r\n");
      out.write("    </body></html>");
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
