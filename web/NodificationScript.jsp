<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<% //Got the id from Here only
    if (session.getAttribute("email") != null) {
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
            String email = (String) session.getAttribute("email");
            String UserId = "";
            try {
                String sql = "SELECT ID,firstname FROM newuser WHERE email = '" + email + "'";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    UserId = resultSet.getString("ID");
                }
            } catch (Exception e) {
                out.println(e.getMessage());
            }
            try { //counted the total numner of answer of a question
                Statement stmt, stmt1, stmt2, stmt3;
                Connection con;
                ResultSet rs, rs1, rs2, rs3;
                String CurrentTotalNumberOfAnswer = "";
                String StoredTotalNumberOfAnswer = "";
                int totalcount = 0;
                String v = "select question,q_id from question where id='" + UserId + "'";
                preparedStatement = connection.prepareStatement(v);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String QuestionId = resultSet.getString("q_id");
                    String StoredQuestion = resultSet.getString("question");
                    stmt1 = connection.createStatement();
                    String v1 = "select count(*) q_id from answer where q_id='" + QuestionId + "'";
                    rs1 = stmt1.executeQuery(v1);
                    while (rs1.next()) {
                        CurrentTotalNumberOfAnswer = rs1.getString("q_id");
                    }
                    stmt1.close();
                    rs1.close();
                    stmt2 = connection.createStatement();
                    String v2 = "select total_number_of_answer from nodification_count where question_id='" + QuestionId + "'";
                    rs2 = stmt2.executeQuery(v2);
                    while (rs2.next()) {
                        StoredTotalNumberOfAnswer = rs2.getString("total_number_of_answer");
                    }
                    stmt2.close();
                    rs2.close();
                    int int_CurrentTotalNumberOfAnswer = Integer.valueOf(CurrentTotalNumberOfAnswer);
                    int int_StoredTotalNumberOfAnswer = Integer.valueOf(StoredTotalNumberOfAnswer);
                    int Differance = int_CurrentTotalNumberOfAnswer - int_StoredTotalNumberOfAnswer;
                    if (Differance != 0) {
                        for (int i = 0; i < 1; i++) {
                            stmt3 = connection.createStatement();
                            String v3 = "SELECT * FROM answer where q_id='" + QuestionId + "' ORDER BY a_id DESC LIMIT " + Differance + " ";
                            rs3 = stmt3.executeQuery(v3);
                            while (rs3.next()) {
                                totalcount++;
                                String Answer = rs3.getString("answer");
%>
<a href="Answer.jsp?Id=<%=QuestionId%>"><%=StoredQuestion%></a>
<%
                                out.println("<br>A." + Answer);
                            }
                            stmt3.close();
                            rs3.close();
                        }
                    }
                }
                out.println("Total Nodification :" + totalcount);
            } catch (Exception e) {
                out.println("<br>Error" + e.getMessage());
            }
            try { //counted the total numner of answer of a question
                //Updating the nodification list

                Statement stmt, stmt1;
                ResultSet rs, rs1;
                String sql = "select q_id from question where id='" + UserId + "'";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                //rs = stmt.executeQuery(v);
                while (resultSet.next()) {
                    String QuestionId = resultSet.getString("q_id");
                    stmt1 = connection.createStatement();
                    String v1 = "select count(*) q_id from answer where q_id='" + QuestionId + "'";
                    rs1 = stmt1.executeQuery(v1);
                    while (rs1.next()) {
                        String TotalNumberOfAnswer = rs1.getString("q_id");
                        try {
                            PreparedStatement ps = null;
                            String UpdateQuiry = "update nodification_count set total_number_of_answer = '" + TotalNumberOfAnswer + "' where question_id = '" + QuestionId + "'";
                            ps = connection.prepareStatement(UpdateQuiry);
                            ps.executeUpdate();
                            ps.close();
                        } catch (Exception e) {
                            out.println("Error in nodification " + e);
                        }
                    }
                    stmt1.close();
                    rs1.close();
                }
            } catch (Exception e) {
                out.println(e.getMessage());
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
        out.println("You are not loggedin, Plese login then access this site...");
    }
%>