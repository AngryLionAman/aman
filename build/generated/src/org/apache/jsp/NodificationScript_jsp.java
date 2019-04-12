package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class NodificationScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
 //Got the id from Here only
    if (session.getAttribute("email") != null && session.getAttribute("Session_id_of_user") != null) {
        int SessionUserId = (Integer) session.getAttribute("Session_id_of_user");
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

            /*Display the stored notification to the user*/
 /*Limited the user notification to five(5)*/
            try {
                int CurrentUserId = (Integer) session.getAttribute("Session_id_of_user");
                String sql = "SELECT unique_id,user_id,user_email,notification_type,followers_id,"
                        + "(SELECT firstname FROM newuser WHERE id = notification.followers_id)AS firstname,"
                        + "(SELECT lastname FROM newuser WHERE id = notification.followers_id)AS lastname,question_id,"
                        + "(SELECT question FROM question WHERE q_id = notification.question_id)AS QUESTION,ans_id,"
                        + "(SELECT answer FROM answer WHERE a_id = notification.ans_id)AS answer,time FROM notification "
                        + "WHERE user_id = ? OR user_id IS NULL ORDER BY unique_id DESC";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, CurrentUserId);
                resultSet = preparedStatement.executeQuery();

      out.write('\r');
      out.write('\n');
 boolean status = true;
    while (resultSet.next()) {
        status = false;
        int question_id = resultSet.getInt("question_id");
        String question = resultSet.getString("question");
        String answer = resultSet.getString("answer");
        int userId = resultSet.getInt("followers_id");//who created the notification
        String userFirstName = resultSet.getString("firstname");
        String userLastName = resultSet.getString("lastname");
        String notification_type = resultSet.getString("notification_type");
        if (notification_type.equalsIgnoreCase("got_answer_of_a_question")) {


      out.write("\r\n");
      out.write("<a href=\"Answer.jsp?q=");
      out.print(question.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(question_id);
      out.write("\"><b>");
      out.print(userFirstName);
      out.write(' ');
      out.print(userLastName);
      out.write("</b> give you an answer of <b>");
      out.print(question);
      out.write("</b></a>\r\n");
      out.write("<br>---------------------------------------------<br>\r\n");

} else if (notification_type.equalsIgnoreCase("followed_by")) {


      out.write("\r\n");
      out.write("<a href=\"profile.jsp?user=");
      out.print(userFirstName);
      out.write("&ID=");
      out.print(userId);
      out.write("\"> <b>");
      out.print(userFirstName);
      out.write(' ');
      out.print(userLastName);
      out.write("</b> started following you</a>\r\n");
      out.write("<br>---------------------------------------------<br>\r\n");

            } else if (notification_type.equalsIgnoreCase("submit_question")) {
                //Notification for submit a question
                try {
                    String sql_for_q_notify = "SELECT EXISTS(SELECT user_id FROM ak_follower_detail "
                            + "WHERE followers_id =? AND user_id = ?) AS value";
                    preparedStatement = connection.prepareStatement(sql_for_q_notify);
                    preparedStatement.setInt(1, SessionUserId);
                    preparedStatement.setInt(2, userId);
                    resultSet = preparedStatement.executeQuery();
                    boolean foundValue = false;
                    while (resultSet.next()) {
                        int value = resultSet.getInt("value");
                        if (value == 1) {
                            foundValue = true;
                        } else {
                            foundValue = false;
                        }

                    }
                    if (foundValue) {
                        out.println("Name posted a new question");
                        foundValue = false;
                    }

                } catch (Exception msg) {
                    out.println("got some error in featchig the uploaded question notification" + msg);
                }

            }
        }

        if (status) {
            out.println("You don't have any notification");
        }
    } catch (Exception msg) {
        out.println(msg);
    }

      out.write('\r');
      out.write('\n');


            /*End of the script of displaying the notification to user*/
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
    } else {
        out.println("You are not loggedin, Plese login then access this site...");
    }

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
