package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class validate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta charset=\"UTF-8\">\r\n");

    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

      out.write('\r');
      out.write('\n');

    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }

      out.write('\r');
      out.write('\n');

    String email, password;
    email = request.getParameter("email");
    password = request.getParameter("password");
    if (email == null || password == null) {
        out.println("You can't this page directly");
        response.sendRedirect("Login.jsp");
    } else {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            if (connection == null || connection.isClosed()) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    out.println("Exception in loading the class forname Driver" + ex);
                }
                connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
            }
            String password1;
            int Session_id_of_user = 0;
            try {

                String v = "SELECT ID,email,password FROM newuser WHERE email = ?";

                preparedStatement = connection.prepareStatement(v);
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    password1 = resultSet.getString("password");
                    Session_id_of_user = resultSet.getInt("ID");
                    if (password.equals(password1)) {
                        i = 1;
                    }
                }
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
            if (i == 1) {
                session.setAttribute("email", email);
                session.setAttribute("Session_id_of_user", Session_id_of_user);
                try {
                    Cookie usernameCookie = new Cookie("username-cookie", email);
                    Cookie passwordCookie = new Cookie("password-cookie", password);
                    usernameCookie.setMaxAge(24 * 60 * 60 * 100);
                    passwordCookie.setMaxAge(24 * 60 * 60 * 100);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                } catch (Exception msg) {
                    out.println("Please Store password without any space" + msg);
                }

                if (request.getParameter("URL") != null) {
                    String URL = request.getParameter("URL");
                   String Id = request.getParameter("Id");
                    String ans = "";
                    if (request.getParameter("ans") != null && !request.getParameter("ans").equalsIgnoreCase("null")) {
                        ans = request.getParameter("ans");
                        response.sendRedirect(URL + "&Id=" + Id + "&sl=" + sl + "&ans=" + ans);
                    }
                   else if(request.getParameter("ID") != null){
                      response.sendRedirect(URL + "&ID=" + request.getParameter("ID"));  
                    }
                    response.sendRedirect(URL);
                } else {
                     response.sendRedirect("index.jsp?sl=" + sl);
                }
            } else {
                response.sendRedirect("Login.jsp?sl=" + sl + "&msg=valid");
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
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
