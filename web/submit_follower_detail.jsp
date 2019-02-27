<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<% if (session.getAttribute("email") == null) {
        response.sendRedirect("Login.jsp");
    }
%>
<%
    String user_id = request.getParameter("val_topic");
    String followers_id = request.getParameter("val2_topic");
    String Action = request.getParameter("action");
    String sql = "";
    if (user_id != null && followers_id != null && Action != null) {
        try {
            Connection connection = null;
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
                if (Action.endsWith("delete")) {
                    sql = "DELETE FROM ak_follower_detail WHERE  user_id=? AND followers_id=?";
                }
                if (Action.endsWith("follow")) {
                    sql = "insert into ak_follower_detail(user_id,followers_id) values(?,?)";
                }
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user_id);
                preparedStatement.setString(2, followers_id);
                preparedStatement.executeUpdate();
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
                if (preparedStatement != null || !preparedStatement.isClosed()) {
                    try {
                        preparedStatement.close();
                    } catch (Exception e) {
                        out.println("Exception in closing preparedStatement " + e);
                    }
                }
            }
        } catch (Exception e1) {
            out.println("Error:-" + e1);
        }
    } else {
        out.println("It seem like you are loogedin but trying to access this page directly");
        out.println("<br>Please follow the procedure..Thanks");
    }
%>
