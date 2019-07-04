package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public final class ProgressReport_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";

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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Progress Report</title>\n");
      out.write("        <!--meta http-equiv=\"refresh\" content=\"3\"-->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h2{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            p{\n");
      out.write("                text-align: center;\n");
      out.write("                color: #ff0099;\n");
      out.write("            }\n");
      out.write("            /* Create three equal columns that floats next to each other */\n");
      out.write("            .column {\n");
      out.write("                float: left;\n");
      out.write("                width: 24.33%;\n");
      out.write("                padding: 10px;\n");
      out.write("                height: 200px; /* Should be removed. Only for demonstration */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Clear floats after the columns */\n");
      out.write("            .row:after {\n");
      out.write("                content: \"\";\n");
      out.write("                display: table;\n");
      out.write("                clear: both;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Responsive layout - makes the three columns stack on top of each other instead of next to each other */\n");
      out.write("            @media screen and (max-width: 600px) {\n");
      out.write("                .column {\n");
      out.write("                    width: 100%;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <h2>Progress Report of inquiryhere.com</h2>\n");
      out.write("        ");

            Connection connection = null;
            ResultSet resultSet = null;
            ResultSet resultSet1 = null;
            ResultSet resultSet2 = null;
            ResultSet resultSet3 = null;
            ResultSet resultSet4 = null;
            ResultSet resultSet5 = null;
            ResultSet resultSet6 = null;
            ResultSet resultSet7 = null;
            ResultSet resultSet8 = null;
            PreparedStatement preparedStatement = null;
            PreparedStatement preparedStatement1 = null;
            PreparedStatement preparedStatement2 = null;
            PreparedStatement preparedStatement3 = null;
            PreparedStatement preparedStatement4 = null;
            PreparedStatement preparedStatement5 = null;
            PreparedStatement preparedStatement6 = null;
            PreparedStatement preparedStatement7 = null;
            PreparedStatement preparedStatement8 = null;
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
      out.write("        ");

            int TotalQuestion = 0;
            int TotalAnswer = 0;
            int TotalUser = 0;
            String Last_posted_question = "";
            String Last_user_created = "";
            String Most_viewed_question = "";
            String Most_viewed_profile = "";
            int total_view = 0;
            int total_view_profile = 0;
            int Last_posted_question_Total_View = 0;
            String sql_quesion = "select count(*) totalquestion from question";//For the the question
            String sql_answer = "select count(*) totalanswer from answer";//For the the answer
            String sql_user = "select count(*) totaluser from newuser";//For the the user
            String sql_last_posted_question = "select * from question order by q_id desc limit 1";
            String sql_last_user_created = "select * from newuser order by id desc limit 1";
            String sql_most_viewed_question = "select q_id,question,total_view from question order by total_view desc limit 1";
            String sql_most_viewed_Profile = "select firstname,total_view from newuser order by total_view desc limit 1";
            String sql_recent_searched_queary = "select * from searched_queary order by primary_key desc limit 20";
            String unanswred_question = "select q_id,question,(select count(a_id) from answer where q_id = question.q_id)t_ans from question";
            try {
                preparedStatement = connection.prepareStatement(sql_quesion);
                preparedStatement1 = connection.prepareStatement(sql_answer);
                preparedStatement2 = connection.prepareStatement(sql_user);
                preparedStatement3 = connection.prepareStatement(sql_last_posted_question);
                preparedStatement4 = connection.prepareStatement(sql_last_user_created);
                preparedStatement5 = connection.prepareStatement(sql_most_viewed_question);
                preparedStatement6 = connection.prepareStatement(sql_most_viewed_Profile);
                preparedStatement7 = connection.prepareStatement(sql_recent_searched_queary);
                preparedStatement8 = connection.prepareStatement(sql_recent_searched_queary);
                resultSet = preparedStatement.executeQuery();
                resultSet1 = preparedStatement1.executeQuery();
                resultSet2 = preparedStatement2.executeQuery();
                resultSet3 = preparedStatement3.executeQuery();
                resultSet4 = preparedStatement4.executeQuery();
                resultSet5 = preparedStatement5.executeQuery();
                resultSet6 = preparedStatement6.executeQuery();
                resultSet7 = preparedStatement7.executeQuery();
                resultSet8 = preparedStatement8.executeQuery();
                while (resultSet.next()) {
                    TotalQuestion = resultSet.getInt("totalquestion");
                }
                while (resultSet1.next()) {
                    TotalAnswer = resultSet1.getInt("totalanswer");
                }
                while (resultSet2.next()) {
                    TotalUser = resultSet2.getInt("totaluser");
                }
                while (resultSet3.next()) {
                    Last_posted_question = resultSet3.getString("question");
                    Last_posted_question_Total_View = resultSet3.getInt("total_view");
                }
                while (resultSet4.next()) {
                    Last_user_created = resultSet4.getString("firstname");
                }
                while (resultSet5.next()) {
                    Most_viewed_question = resultSet5.getString("question");
                    total_view = resultSet5.getInt("total_view");
                }
                while (resultSet6.next()) {
                    Most_viewed_profile = resultSet6.getString("firstname");
                    total_view_profile = resultSet6.getInt("total_view");
                }
            } catch (Exception msg) {
                out.println(msg);
            }
        
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"column\" style=\"background-color:#aaa;\">\n");
      out.write("                <h2>Total Question</h2>\n");
      out.write("                <p style=\"font-size: 60px;\">");
      out.print(TotalQuestion);
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"column\" style=\"background-color:#bbb;\">\n");
      out.write("                <h2>Total Answer</h2>\n");
      out.write("                <p style=\"font-size: 60px;\">");
      out.print(TotalAnswer);
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"column\" style=\"background-color:#ccc;\">\n");
      out.write("                <h2>Total User</h2>\n");
      out.write("                <p style=\"font-size: 60px;\">");
      out.print(TotalUser);
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"column\" style=\"background-color:#ddd;\">\n");
      out.write("                <h2>Panding</h2>\n");
      out.write("                <p style=\"font-size: 30px;\">");
      out.print("panding");
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"column\" style=\"background-color:#aaa;\">\n");
      out.write("                <h2>Last Question posted</h2>\n");
      out.write("                <p style=\"font-size: 25px;\">");
      out.print(Last_posted_question);
      out.write(' ');
      out.write('(');
      out.print(Last_posted_question_Total_View);
      out.write(")</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"column\" style=\"background-color:#bbb;\">\n");
      out.write("                <h2>Last user created</h2>\n");
      out.write("                <p style=\"font-size: 30px;\">");
      out.print(Last_user_created);
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"column\" style=\"background-color:#ccc;\">\n");
      out.write("                <h2>Most view question</h2>\n");
      out.write("                <p style=\"font-size: 25px;\">");
      out.print(Most_viewed_question);
      out.write(' ');
      out.write('(');
      out.print(total_view);
      out.write(")</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"column\" style=\"background-color:#ddd;\">\n");
      out.write("                <h2>Most view Profile</h2>\n");
      out.write("                <p style=\"font-size: 25px;\">");
      out.print(Most_viewed_profile);
      out.write(' ');
      out.write('(');
      out.print(total_view_profile);
      out.write(")</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"column\" style=\"background-color:#ddd;\">\n");
      out.write("                <h2>Searched query</h2>\n");
      out.write("                ");

                 while (resultSet7.next()) {
                    String searched_queary = resultSet7.getString("searched_queary");
                    out.println(searched_queary+",");
                    
      out.write("\n");
      out.write("               \n");
      out.write("                ");

                }
                
      out.write("\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                <div>\n");
      out.write("                    ");

                    while (resultSet8.next()) {
                    
                        int unswred_question_id = resultSet8.getInt("q_id");
                        int total_answer = resultSet8.getInt("t_ans");
                        String unswred_question = resultSet8.getString("question");
                        out.println(unswred_question_id+" ->"+unswred_question+" ->"+total_answer+"<br>");
                }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
