package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class SubmitAnswer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";

            public boolean validateUser(String username, String password, int userId) {
        boolean found = false;
        try {
            String cookiesMail = username;
            String cookiesPassword = password;

            Connection connection = null;
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);

            // password1;
            //int Session_id_of_user = 0;
            // boolean found = false;
            try {

                String v = "SELECT ID,email,password FROM newuser WHERE email = ?";

                preparedStatement = connection.prepareStatement(v);
                preparedStatement.setString(1, cookiesMail);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String password1 = resultSet.getString("password");
                    int id_of_user = resultSet.getInt("ID");
                    //Session_id_of_user = resultSet.getInt("ID");
                    if (cookiesPassword.equals(password1) && userId == id_of_user) {
                        found = true;
                    }
                }
            } catch (Exception e) {
                //  out.println("Error in main try block:-" + e);
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (Exception msg) {

        }
        return found;
    }

    public void submitAnswer(int Q_id, String answer, int id_of_user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (connection == null || connection.isClosed()) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    //out.println("Exception in loading the class forname Driver" + ex);
                }
                connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
            }
//                int Q_id = Integer.valueOf(v);
//                int id_of_user = Integer.valueOf(v2);
            int user_id_of_who_asked_the_question = 0;
            try {
                String sql = "insert into answer(q_id,answer,Answer_by_id,vote) values(?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Q_id);
                preparedStatement.setString(2, answer);
                preparedStatement.setInt(3, id_of_user);
                preparedStatement.setInt(4, 0);
                preparedStatement.executeUpdate();
                //out.println("Data has been inserted");
                // Get the userId of a asked question id
                try {
                    String sql_user_id = "SELECT id FROM question WHERE q_id = ?";
                    preparedStatement = connection.prepareStatement(sql_user_id);
                    preparedStatement.setInt(1, Q_id);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        user_id_of_who_asked_the_question = resultSet.getInt("id");
                    }
                } catch (Exception msg) {
                    // out.println("Error in getting the user of of the question id" + msg);
                }

                //Save some information for the notification to user
                //For, send the notification to user to you got an answer
                try {
                    String sql_notification = "INSERT INTO notification (user_id,notification_type,followers_id,question_id)VALUES(?,?,?,?)";
                    preparedStatement = connection.prepareStatement(sql_notification);
                    preparedStatement.setInt(1, user_id_of_who_asked_the_question);
                    preparedStatement.setString(2, "got_answer_of_a_question");
                    preparedStatement.setInt(3, id_of_user);
                    preparedStatement.setInt(4, Q_id);
                    preparedStatement.execute();
                } catch (Exception msg) {
                    //out.println("Error in Saving the notifiation" + msg);
                }
                //End of the script to saving the notification to display of got the answer of a question
                //response.sendRedirect("Answer.jsp?q=" + question.replaceAll(" ", "-") + "&Id=" + Q_id);
            } catch (Exception e1) {
                //out.print("Error:-" + e1);
            }
        } catch (Exception e) {
            //out.println("Error in main try block:-" + e);
        } finally {

            if (connection != null || !connection.isClosed()) {
                try {
                    connection.close();
                } catch (Exception e) {
                    //out.println("Exception in closing connection " + e);
                }
            }
            if (preparedStatement != null || !preparedStatement.isClosed()) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    //out.println("Exception in closing preparedStatement " + e);
                }
            }
        }
    }

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
      out.write("\r\n");
      out.write("\r\n");

    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

    if (request.getParameter("answer") != null
            && request.getParameter("answer").trim().length() > 0
            && request.getParameter("q_id") != null
            && request.getParameter("_id_of_user") != null
            && request.getParameter("question") != null) {

        String answer = request.getParameter("answer");
        String v = request.getParameter("q_id");
        String v2 = request.getParameter("_id_of_user");
        String question = request.getParameter("question");

        int Q_id = Integer.valueOf(v);
        int id_of_user = Integer.valueOf(v2);
        if (session.getAttribute("email") != null) {
            submitAnswer(Q_id, answer, id_of_user);
            response.sendRedirect("Answer.jsp?q=" + question.replaceAll(" ", "-") + "&Id=" + Q_id);
        }
        if (session.getAttribute("email") == null) {
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
            } else {
                response.sendRedirect("Login.jsp");
            }
            if (username != "" && password != "") {
                boolean found = validateUser(username, password, id_of_user);
                //out.println(found);
                if (found) {
                    submitAnswer(Q_id, answer, id_of_user);
                    response.sendRedirect("Answer.jsp?q=" + question.replaceAll(" ", "-") + "&Id=" + Q_id);
                } else {
                    response.sendRedirect("Login.jsp");
                }
            } else {
                response.sendRedirect("Login.jsp");
            }
        }

    } else {
        out.println("Something went wrong!!!!<br>Or may be bad argument");
    }


      out.write('\r');
      out.write('\n');
//    String URL = request.getParameter("URL");
//
//    String sl = request.getParameter("sl");
//    if (sl == null) {
//        sl = "en";
//    }
//    if (session.getAttribute("email") != null) {
//        //String firstname, lastname, password, email;
//
//        if (answer != null && v != null && v2 != null) {
//
//        } else {
//            out.println("It seem Like you are loggedIn but trying to access this page directly");
//        }
//    } else {
//        response.sendRedirect("Login.jsp?sl=" + sl + "&msg=submitAns&URL=" + URL + "&ans=" + answer);
//        //out.println("please login first" + URL);
//    }


      out.write('\r');
      out.write('\n');
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
