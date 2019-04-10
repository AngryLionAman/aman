<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String URL = request.getParameter("URL");
    String answer = request.getParameter("answer");
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
    if (session.getAttribute("email") != null) {
        //String firstname, lastname, password, email;
        String v = request.getParameter("q_id");
        String v2 = request.getParameter("_id_of_user");
        
        if (answer != null && v != null && v2 != null) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                if (connection == null || connection.isClosed()) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        out.println("Exception in loading the class forname Driver" + ex);
                    }
                    connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
                }
                int Q_id = Integer.valueOf(v);
                int id_of_user = Integer.valueOf(v2);
                int user_id_of_who_asked_the_question = 0;
                try {
                    String sql = "insert into answer(q_id,answer,Answer_by_id,vote) values(?,?,?,?)";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, Q_id);
                    preparedStatement.setString(2, answer);
                    preparedStatement.setInt(3, id_of_user);
                    preparedStatement.setInt(4, 0);
                    preparedStatement.executeUpdate();
                    out.println("Data has been inserted");
                    // Get the userId of a asked question id
                    try{
                        String sql_user_id = "SELECT id FROM question WHERE q_id = ?";
                        preparedStatement = connection.prepareStatement(sql_user_id);
                        preparedStatement.setInt(1, Q_id);
                        resultSet = preparedStatement.executeQuery();
                        while(resultSet.next()){
                           user_id_of_who_asked_the_question = resultSet.getInt("id");
                        }
                    }catch(Exception msg){
                        out.println("Error in getting the user of of the question id"+msg);
                    }
                    
                    //Save some information for the notification to user
                    //For, send the notification to user to you got an answer
                    try{
                      String sql_notification = "INSERT INTO notification (user_id,notification_type,followers_id,question_id)VALUES(?,?,?,?)";
                      preparedStatement = connection.prepareStatement(sql_notification);
                      preparedStatement.setInt(1, user_id_of_who_asked_the_question);
                      preparedStatement.setString(2, "got_answer_of_a_question");
                      preparedStatement.setInt(3, id_of_user);
                      preparedStatement.setInt(4, Q_id);
                      preparedStatement.execute();
                    }catch(Exception msg){
                        out.println("Error in Saving the notifiation"+msg);
                    }
                    //End of the script to saving the notification to display of got the answer of a question
                    response.sendRedirect("Answer.jsp?Id=" + Q_id);
                } catch (Exception e1) {
                    out.print("Error:-" + e1);
                    String email = (String)session.getAttribute("email");
                    int user_id = (Integer)session.getAttribute("Session_id_of_user");
        %><jsp:include page="ExceptionCollector.jsp">
            <jsp:param name="userName" value="<%=email%>"></jsp:param>
            <jsp:param name="userID" value="<%=user_id%>"></jsp:param>
            <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
            <jsp:param name="ExceptionMessage" value="<%=e1%>"></jsp:param>
        </jsp:include><%
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
                if (preparedStatement != null || !preparedStatement.isClosed()) {
                    try {
                        preparedStatement.close();
                    } catch (Exception e) {
                        out.println("Exception in closing preparedStatement " + e);
                    }
                }
            }
        } else {
            out.println("It seem Like you are logedin but tryin to access this page directly");
        }
    } else {
        response.sendRedirect("Login.jsp?sl=" + sl + "&msg=submitAns&URL=" + URL+"&ans="+answer);
        //out.println("please login first" + URL);
    }

%>
