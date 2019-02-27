<%@page language="java" %>
<%@page import="java.sql.*" %>  
<%@include file="site.jsp" %>
<%
    Statement stmt1, stmt6, stmt5 = null;
    Connection con1 = null;
    ResultSet rs1, rs6, rs5 = null;
    int q_id = 0;
    int q_asked_by_user = 0;
    String StoredQuestion = "";
    String StoredAnswer = "";
    int StoredQuestionId = 0;
    String firstname_of_user_who_asked_the_question = null;
    String Question = "What are the Interesting Facts About Eva Green";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        con1 = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
        stmt1 = con1.createStatement();
        String p = "SELECT * FROM question WHERE question = '" + Question + "'";
        rs1 = stmt1.executeQuery(p);
        while (rs1.next()) {
            StoredQuestion = rs1.getString("question");
            StoredQuestionId = rs1.getInt("q_id");
        }
        stmt1.close();
        //con1.close();
        rs1.close();
    } catch (Exception e) {
        out.println("Unable to retrieve!!" + e);
    }
    out.println("id -> " + StoredQuestionId);
    try{
    stmt6 = con1.createStatement();
    String p6 = "SELECT SUBSTRING(answer,1,200) FROM answer WHERE q_id = '" + StoredQuestionId + "'";
    rs6 = stmt6.executeQuery(p6);
    while (rs6.next()) {
        StoredAnswer = rs6.getString("SUBSTRING(answer,1,200)");
    }
    stmt6.close();
    rs6.close();
    con1.close();
    }catch(Exception ex){
        out.println("Error: "+ex);
    }

    out.println("<br>Title : " + StoredQuestion);
    out.println("<br>Dscription :" + StoredAnswer);
%>
