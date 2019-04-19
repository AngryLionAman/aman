<%-- 
    Document   : SubmitQuestionComment
    Created on : 16 Apr, 2019, 11:12:43 AM
    Author     : AngryLion
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="site.jsp" %>
<%
    if (session.getAttribute("Session_id_of_user") != null) {
        if (request.getParameter("question_id") != null
                && request.getParameter("comments") != null
                && request.getParameter("sub") != null) {
            int user_id = (Integer) session.getAttribute("Session_id_of_user");
            int question_id = Integer.parseInt(request.getParameter("question_id"));
            String questionComment = request.getParameter("comments");
            String question = request.getParameter("question");
            Connection connection = null;
            //ResultSet resultSet = null;
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
%>

<%
    try {
        String sql = "INSERT INTO comments (user_id,q_id,comments)VALUES(?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setInt(2, question_id);
        preparedStatement.setString(3, questionComment);
        boolean status = preparedStatement.execute();
        if (status) {
            out.println("found some error");
        } else {
            //out.println("Successfully comment has been inserted");
            response.sendRedirect("Answer.jsp?q="+question.replaceAll(" ", "-")+"&Id="+question_id);
        }
    } catch (Exception msg) {
        out.println(msg);
    }

%>

<%            } catch (Exception e) {
                out.println("Error in main try block:-" + e);
            } finally {

                if (connection != null || !connection.isClosed()) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        out.println("Exception in closing connection " + e);
                    }
                }
//                if (resultSet != null || !resultSet.isClosed()) {
//                    try {
//                        resultSet.close();
//                    } catch (Exception e) {
//                        out.println("Exception in closing resulatset " + e);
//                    }
//                }
                if (preparedStatement != null || !preparedStatement.isClosed()) {
                    try {
                        preparedStatement.close();
                    } catch (Exception e) {
                        out.println("Exception in closing preparedStatement " + e);
                    }
                }
            }

        } else {
            out.println("It seem like you are logged in but trying to acces this page directly<br>Please follow the procedure");
        }
    } else {
        out.println("You are not loggedin ,please login first");
    }


%>