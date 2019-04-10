<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<% //Got the id from Here only
    if (session.getAttribute("email") != null && session.getAttribute("Session_id_of_user") != null) {
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
                        + "WHERE user_id = ? ORDER BY unique_id DESC";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, CurrentUserId);
                resultSet = preparedStatement.executeQuery();
%>
<% boolean status = true;
    while (resultSet.next()) {
        status = false;
        int question_id = resultSet.getInt("question_id");
        String question = resultSet.getString("question");
        String answer = resultSet.getString("answer");
        int userId = resultSet.getInt("followers_id");
        String userFirstName = resultSet.getString("firstname");
        String userLastName = resultSet.getString("lastname");
        String notification_type = resultSet.getString("notification_type");
        if (notification_type.equalsIgnoreCase("got_answer_of_a_question")) {

%>
<a href="Answer.jsp?q=<%=question.replaceAll(" ", "-")%>&Id=<%=question_id%>"><b><%=userFirstName%> <%=userLastName%></b> give you an answer of <b><%=question%></b></a>
<br>---------------------------------------------<br>
<%
} else if (notification_type.equalsIgnoreCase("followed_by")) {

%>
<a href="profile.jsp?user=<%=userFirstName%>&ID=<%=userId%>"> <b><%=userFirstName%> <%=userLastName%></b> started following you</a>
<br>---------------------------------------------<br>
<%
            }
        }

        if (status) {
            out.println("You don't have any notification");
        }
    } catch (Exception msg) {
        out.println(msg);
    }
%>
<%

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
%>