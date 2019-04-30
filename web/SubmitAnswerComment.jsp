<%-- 
    Document   : SubmitAnswerComment
    Created on : 17 Apr, 2019, 7:43:49 PM
    Author     : AngryLion
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@include file="site.jsp" %>
<%
    if (session.getAttribute("Session_id_of_user") != null) {
        if (request.getParameter("answer_id") != null
                && request.getParameter("comments") != null
                && request.getParameter("sub") != null
                && request.getParameter("question_id") != null) {
            int user_id = (Integer) session.getAttribute("Session_id_of_user");
            int answer_id = Integer.parseInt(request.getParameter("answer_id"));
            String question = request.getParameter("question");
            String AnswerComment = request.getParameter("comments");
            int question_id = Integer.parseInt(request.getParameter("question_id"));
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
        String sql = "INSERT INTO comments (user_id,ans_id,comments)VALUES(?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user_id);//Here user_id = followers_id for the database
        preparedStatement.setInt(2, answer_id);
        preparedStatement.setString(3, AnswerComment);
        boolean status = preparedStatement.execute();
        if (status) {
            out.println("found some error");
        } else {
            try {
                ArrayList<Integer> obj = (ArrayList<Integer>) session.getAttribute("AllUserIdList");
                Iterator itr = obj.iterator();
                while (itr.hasNext()) {
                    try {
                        String store_commment_notification = "INSERT INTO notification (user_id,notification_type,followers_id,question_id,ans_id ) VALUES (?,?,?,?,?)";
                        preparedStatement = connection.prepareStatement(store_commment_notification);
                        preparedStatement.setInt(1, (Integer) itr.next());//Who will got the notification
                        preparedStatement.setString(2, "comment_on_Answer");
                        preparedStatement.setInt(3, user_id); //Here user_id belong to user give the commnet meand followers id
                        preparedStatement.setInt(4, question_id);
                        preparedStatement.setInt(5, answer_id);
                        preparedStatement.execute();
                    } catch (Exception msg) {
                        out.println("Error in storing the comment notification :- " + msg);
                    }
                }
            } catch (Exception msg) {

                out.println(msg);
            }
            out.println("Successfully Answer comment has been inserted");
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