<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
%>
<%
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
                if (request.getParameter("URL") != null) {
                    String URL = request.getParameter("URL");
                    String ans = request.getParameter("ans");
                    response.sendRedirect(URL + "&sl=" + sl + "&ans=" + ans);
                } else {
                    response.sendRedirect("index.jsp?sl=" + sl);
                }
            } else {
                response.sendRedirect("Login.jsp?sl=" + sl + "&msg=valid");
            }
            //response.sendRedirect("unvalid.html"); 
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }
%>