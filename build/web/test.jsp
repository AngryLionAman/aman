<%@page language="java" %>
<%@page import="java.sql.*" %>  
<%@include file="site.jsp" %>
<%@include file="validator.jsp" %>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String Question_asked_by_user;
        String SearchValue = convertStringUpperToLower("Mobile Network is");
        out.println(SearchValue);
        out.println("<br>");
        SearchValue = SearchValue.toLowerCase();
        //out.println(SearchValue_Case_Converted);
        Connection connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);

        //Pattern matcher is start working from here
        boolean oneTimeexecuation = false;
        boolean elseOneTIme = true;

        while (true) {
            Pattern pattern = Pattern.compile("\\s");
            Matcher matcher = pattern.matcher(SearchValue);
            boolean found = matcher.find();
            if (found || oneTimeexecuation) {
                out.println("<br>Inside the loop quary for ->"+SearchValue + "<br>");
                //All the searching logic

                String Q = "SELECT * FROM question WHERE lower(question) LIKE '%" + SearchValue + "%'";
                PreparedStatement preparedStatement = connection.prepareStatement(Q);
                ResultSet resultSet = preparedStatement.executeQuery();
                boolean value = false;
                while (resultSet.next()) {
                    value = true;
                    Question_asked_by_user = resultSet.getString("question");
                    int question_id = resultSet.getInt("q_id");
                    out.println("<br>" + question_id + " " + Question_asked_by_user);
                }
                if (!value) {
                    out.println("<br>No content found<br>");
                }
                //End of the main login

                if (oneTimeexecuation) {
                    oneTimeexecuation = false;
                } else {
                    String sentence = SearchValue.substring(0, SearchValue.lastIndexOf(" "));
                    SearchValue = sentence;
                }
            } else {
                if (elseOneTIme) {
                    oneTimeexecuation = true;
                    elseOneTIme = false;
                    continue;

                } else {
                    break;
                }
            }
        }

    } catch (Exception e1) {
        out.println(e1);

    }

%>
