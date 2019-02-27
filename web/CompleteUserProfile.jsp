<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<%
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
    if (session.getAttribute("email") != null) {
        String email = (String) session.getAttribute("email");
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
            String firstname = null;
            String lastname = null;
            String interests = null;
            String higher_edu = null;
            String best_achievement = null;
            String ImagePath = null;
            String bio = null;
            int userId = 0;
            int TotalQuestionCount = 0;
            int TotalAnswerCount = 0;
            try {
                String v = "SELECT * FROM newuser WHERE email = '" + email + "'";
                preparedStatement = connection.prepareStatement(v);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    userId = resultSet.getInt("ID");
                    firstname = resultSet.getString("firstname");
                    lastname = resultSet.getString("lastname");
                    interests = resultSet.getString("interests");
                    higher_edu = resultSet.getString("higher_edu");
                    best_achievement = resultSet.getString("best_achievement");
                    bio = resultSet.getString("bio");
                    ImagePath = resultSet.getString("imagepath");
                }
                //out.println("<br>");
                if (higher_edu == null) {
                    out.println("<br><a href=UpdateUserProfile.jsp?sl=" + sl + ">Insert your higher_edu</a>");
                }
              
                if (best_achievement == null) {
                    out.println("<br><a href=UpdateUserProfile.jsp?sl=" + sl + ">Insert your best_achievement</a>");
                }
                if (bio == null) {
                    out.println("<br><a href=UpdateUserProfile.jsp?sl=" + sl + ">Insert your bio</a>");
                }
                 if (ImagePath == null) {
                    out.println("<br><a href=UpdateUserProfile.jsp?sl=" + sl + ">Update your image profile</a>");
                }
               

            } catch (Exception e) {
                out.println("Error" + e);
            }
            try {// If user not posted any question
                String sql = "SELECT COUNT(*) FROM question WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, userId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    TotalQuestionCount = resultSet.getInt("COUNT(*)");
                }
                if (TotalQuestionCount == 0) {
                    out.println("<br><a href=>Post at least one question</a>");
                }
            } catch (Exception error) {
                out.println(error);
            }
             try {// If user not given any answer
                String sql = "SELECT COUNT(*) FROM answer WHERE answer_by_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, userId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    TotalAnswerCount = resultSet.getInt("COUNT(*)");
                }
                if (TotalAnswerCount == 0) {
                    out.println("<br><a href=>Give at least one answer of any question</a>");
                }
            } catch (Exception error) {
                out.println(error);
            }
             
              if ( higher_edu != null && best_achievement != null && bio != null && ImagePath != null && TotalAnswerCount != 0 && TotalQuestionCount != 0 ) {
                    out.println("<br><a href=UpdateUserProfile.jsp?sl=" + sl + ">Your profile is up to date</a>");
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
    } else {
        response.sendRedirect("Login.jsp");
    }
%>
