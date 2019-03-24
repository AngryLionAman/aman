<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("email") != null) {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            int question_id = 0;
            String email = (String) session.getAttribute("email");
            int UserId = (Integer) session.getAttribute("Session_id_of_user");
            String Question = (String) request.getParameter("question");
            if (email != null && Question != null) {
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
                    try {
                        int id = 0;
                        String p_question_store = "SELECT * FROM newuser WHERE email = '" + email + "'";
                        preparedStatement = connection.prepareStatement(p_question_store);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            id = resultSet.getInt("id");
                        }

                        String q_question_store = "insert into question(id,question,vote) values(?,?,?)";
                        preparedStatement = connection.prepareStatement(q_question_store);
                        preparedStatement.setInt(1, id);
                        preparedStatement.setString(2, Question);
                        preparedStatement.setInt(3, 0);
                        preparedStatement.executeUpdate();
                    } catch (Exception e1) {
                        out.print("Error:-" + e1);
                        String URL = request.getRequestURL() + "?" + request.getQueryString();
                        
%><jsp:include page="ExceptionCollector.jsp">
    <jsp:param name="userName" value="<%=email%>"></jsp:param>
    <jsp:param name="userID" value="<%=UserId%>"></jsp:param>
    <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
    <jsp:param name="ExceptionMessage" value="<%=e1%>"></jsp:param>
</jsp:include><%
    }
    try {

        String fetch_question = "select * from question where question= ?";
        preparedStatement = connection.prepareStatement(fetch_question);
        preparedStatement.setString(1, Question);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String Stored_question = resultSet.getString("question");
            question_id = resultSet.getInt("q_id");
            if (Stored_question.equalsIgnoreCase(Question)) {
                out.println("<br>" + question_id + " " + Question);
            }

        }
        String total_number_of_answer = "0";
        String insert_into_nodification = "insert into nodification_count(question_id,total_number_of_answer) values('" + question_id + "','" + total_number_of_answer + "')";
        preparedStatement = connection.prepareStatement(insert_into_nodification);
        preparedStatement.executeUpdate();
    } catch (Exception e3) {
        out.println("Error" + e3);
        String URL = request.getRequestURL() + "?" + request.getQueryString();
%><jsp:include page="ExceptionCollector.jsp">
    <jsp:param name="userName" value="<%=email%>"></jsp:param>
    <jsp:param name="userID" value="<%=UserId%>"></jsp:param>
    <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
    <jsp:param name="ExceptionMessage" value="<%=e3%>"></jsp:param>
</jsp:include><%
    }

    String question_tag = (String) request.getParameter("tag_of_question");
    String[] arrSplit = question_tag.split(",");
    String status = null;
    boolean firstStep = false;
    boolean secondStep = true;

    for (int i = 0; i < arrSplit.length; i++) {

        if (arrSplit[i].length() >= 1) {//If topic name having the extra space
            firstStep = true;
            for (; true;) {
                try {
                    if (arrSplit[i].charAt(0) == 32) {
                        arrSplit[i] = arrSplit[i].substring(1);
                        out.println(" |  word is:" + arrSplit[i].toLowerCase() + ", langth is:" + arrSplit[i].length());
                        if (arrSplit[i].length() == 0) {
                            secondStep = false;
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception msg) {
                    out.println(msg);
                    String URL = request.getRequestURL() + "?" + request.getQueryString();
%><jsp:include page="ExceptionCollector.jsp">
    <jsp:param name="userName" value="<%=email%>"></jsp:param>
    <jsp:param name="userID" value="<%=UserId%>"></jsp:param>
    <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
    <jsp:param name="ExceptionMessage" value="<%=msg%>"></jsp:param>
</jsp:include><%
                }
            }
        }
        if (firstStep && secondStep) {

            String v = "select lower(topic_name) from topic";
            preparedStatement = connection.prepareStatement(v);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String Stored_topic = resultSet.getString("lower(topic_name)");
                if (Stored_topic.equals(arrSplit[i].toLowerCase())) {
                    status = "present";
                }
            }
            if (status != "present") {
                try {
                    String inserting_the_topic = "insert into topic(topic_name) values(?)";
                    preparedStatement = connection.prepareStatement(inserting_the_topic);
                    preparedStatement.setString(1, arrSplit[i]);
                    preparedStatement.executeUpdate();
                    out.println("<br><b>Successfully inserted</b>");
                } catch (Exception e2) {
                    out.println("Status Error:" + e2);
                }
                status = null;
            } else {
                out.println("<br><b>Topic already present</b>");
            }
            status = null;
        }
        firstStep = false;
        secondStep = true;

    }

    for (int i = 0; i < arrSplit.length; i++) {
        try {
            String fetch_topic = "select * from topic";
            preparedStatement = connection.prepareStatement(fetch_topic);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String Stored_topic = resultSet.getString("topic_name");
                int topic_id = resultSet.getInt("unique_id");
                if (Stored_topic.equalsIgnoreCase(arrSplit[i])) {
                    out.println("<br>" + topic_id + " " + Stored_topic);
                    String p = "insert into question_topic_tag(question_id,tag_id) values('" + question_id + "',lower('" + topic_id + "')) ";
                    preparedStatement = connection.prepareStatement(p);
                    preparedStatement.executeUpdate();
                }

            }
        } catch (Exception e4) {
            out.println("Error = " + e4);
            String URL = request.getRequestURL() + "?" + request.getQueryString();
%><jsp:include page="ExceptionCollector.jsp">
    <jsp:param name="userName" value="<%=email%>"></jsp:param>
    <jsp:param name="userID" value="<%=UserId%>"></jsp:param>
    <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
    <jsp:param name="ExceptionMessage" value="<%=e4%>"></jsp:param>
</jsp:include><%
                        }
                    }

                    response.sendRedirect("index.jsp");
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
                out.println("It seem like you are loged in but trying to access this page direscly<br>Please follow the procedure");
            }
        } catch (Exception e1) {
            out.print("Error:-" + e1);
        }
    } else {
        out.println("You can't access this page directly, Please <a href=index.jsp>Click here</a> to login");
    }
%>
