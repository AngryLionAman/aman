<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <%@page language="java" %>
        <%@page import="java.sql.*" %> 
        <%@include file="site.jsp" %>
        <%@include file="validator.jsp" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%!             String YOUR_ACTIVITY = "";
            String QUESTION = "";
            String ANSWER = "";
            String TOPIC = "";
            String USER_PROFILE = "";
            String ANS = "";
        %>
        <%
            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                YOUR_ACTIVITY = "आपकी गतिविधि";
                QUESTION = "प्रश्न";
                ANSWER = "उत्तर";
                TOPIC = "विषय";
                USER_PROFILE = "उपयोगकर्ता प्रोफ़ाइल";
                ANS = "उत्तर";

            } else {
                YOUR_ACTIVITY = "Your Activity";
                QUESTION = "Question";
                ANSWER = "Answer";
                TOPIC = "Topic";
                USER_PROFILE = "User Profile";
                ANS = "Ans";
            }
        %>
        <!-- For IE -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- For Resposive Device -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Search | InquiryHere.com</title>

        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- responsive style sheet -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css">

    </head>

    <body>
        <script type="text/javascript">

            function take_value(str) {
                //document.getElementById("demo").innerHTML = "Welcome" + firstname+lastname;

                var http = new XMLHttpRequest();
                http.open("POST", "<%=DB_AJAX_PATH%>/SearchHint.jsp?str=" + str, true);
                http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                http.send();

                http.onload = function () {
                    http.responseText;
                    document.getElementById("demo").innerHTML = http.responseText;
                    //alert(http.responseText);
                };

            }


        </script>
        <div class="main-page-wrapper">


            <!-- Header _________________________________ -->
            <jsp:include page="header.jsp">
                <jsp:param name="sl" value="<%=sl%>"/>
            </jsp:include>
            <div class="bodydata">
                <div class="container clear-fix">

                    <div class="row">
                        <div class="row">
                            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

                                <div class="themeBox" style="min-height:auto;">
                                    <div class="boxHeading">
                                        <%=YOUR_ACTIVITY%>
                                    </div>
                                    <div>
                                        <a href="SearchBar.jsp?value=Question&search=<%=request.getParameter("search")%>"><%=QUESTION%></a><br>
                                        <a href="SearchBar.jsp?value=Answer&search=<%=request.getParameter("search")%>"><%=ANSWER%></a><br>
                                        <a href="SearchBar.jsp?value=Topic&search=<%=request.getParameter("search")%>"><%=TOPIC%></a><br>
                                        <a href="SearchBar.jsp?value=UserProfile&search=<%=request.getParameter("search")%>"><%=USER_PROFILE%></a><br>
                                    </div>

                                </div>

                            </div>
                            <%
                                String email = null;
                                int CurrentuserId = 0;
                                Connection connection = null;
                                ResultSet resultSet = null;
                                PreparedStatement preparedStatement = null;
                                try {
                                    if (connection == null || connection.isClosed()) {
                                        try {
                                            Class.forName("com.mysql.jdbc.Driver");
                                        } catch (ClassNotFoundException ex) {
                                            out.println("Exception in loading the class forname Driver" + ex);
                                            if (session.getAttribute("email") == null) {
                                                email = "Anonuous";
                                            } else {
                                                email = (String) session.getAttribute("email");
                                            }
                                            if (session.getAttribute("Session_id_of_user") == null) {
                                                CurrentuserId = 0;
                                            } else {
                                                CurrentuserId = (Integer) session.getAttribute("Session_id_of_user");
                                            }
                                            String URL = request.getRequestURL() + "?" + request.getQueryString();
                            %><jsp:include page="ExceptionCollector.jsp">
                                <jsp:param name="userName" value="<%=email%>"></jsp:param>
                                <jsp:param name="userID" value="<%=CurrentuserId%>"></jsp:param>
                                <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
                                <jsp:param name="ExceptionMessage" value="<%=ex%>"></jsp:param>
                            </jsp:include><%
                                    }
                                    connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
                                }
                            %>

                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="themeBox" style="height:auto;margin-bottom:0px;">
                                            <p id="demo"></p>
                                            <%
                                                String SearchValue = convertStringUpperToLower(request.getParameter("search"));
                                                String ParametrVariable = request.getParameter("value");
                                                if (ParametrVariable == null) {
                                                    ParametrVariable = "Question";
                                                }
                                                if (ParametrVariable != null && SearchValue != null) {
                                                    if (ParametrVariable.equals("Question")) {
                                                        out.println("<center><div class=boxHeading>" + QUESTION + "</div></center>");
                                                        try {
                                                            String Question_asked_by_user;
                                                            String SearchValue_Case_Converted = SearchValue.toLowerCase();
                                                            String Q = "SELECT * FROM question WHERE lower(question) LIKE '%" + SearchValue_Case_Converted + "%'";
                                                            preparedStatement = connection.prepareStatement(Q);
                                                            resultSet = preparedStatement.executeQuery();
                                                            boolean count = true;
                                                            while (resultSet.next()) {
                                                                count = false;
                                                                Question_asked_by_user = resultSet.getString("question");
                                                                int question_id = resultSet.getInt("q_id");
                                            %> <br>Q. <a href="Answer.jsp?Id=<%=question_id%>" ><h6><%=Question_asked_by_user%> ?</h6></a><%
                                                }
                                                if (count) {
                                                    out.println("No related question found");
                                                }
                                            } catch (Exception e1) {
                                                out.println("Error in Question search : " + e1);
                                                if (session.getAttribute("email") == null) {
                                                    email = "Anonuous";
                                                } else {
                                                    email = (String) session.getAttribute("email");
                                                }
                                                if (session.getAttribute("Session_id_of_user") == null) {
                                                    CurrentuserId = 0;
                                                } else {
                                                    CurrentuserId = (Integer) session.getAttribute("Session_id_of_user");
                                                }
                                                String URL = request.getRequestURL() + "?" + request.getQueryString();
                                            %><jsp:include page="ExceptionCollector.jsp">
                                                <jsp:param name="userName" value="<%=email%>"></jsp:param>
                                                <jsp:param name="userID" value="<%=CurrentuserId%>"></jsp:param>
                                                <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
                                                <jsp:param name="ExceptionMessage" value="<%=e1%>"></jsp:param>
                                            </jsp:include><%
                                                    }
                                                }
                                                //Staring answer programming....................................................
                                                if (ParametrVariable.equals("Answer")) {
                                                    out.println("<center><div class=boxHeading>" + ANSWER + "</div></center>");
                                                    try {
                                                        String Answer_given_by_user;
                                                        //int Question_id = 0;
                                                        String SearchValue_Case_Converted = SearchValue.toLowerCase();
                                                        String Q_a = "Select q.question,q.q_id, substring(ans.answer,1,500) from question q right join answer ans on ans.q_id = q.q_id where lower(answer) LIKE '%" + SearchValue_Case_Converted + "%'";
                                                        preparedStatement = connection.prepareCall(Q_a);
                                                        resultSet = preparedStatement.executeQuery();

                                                        boolean count = true;
                                                        while (resultSet.next()) {
                                                            count = false;
                                                            Answer_given_by_user = resultSet.getString("substring(ans.answer,1,500)");
                                                            String Question_by_user = resultSet.getString("question");
                                                            int question_id = resultSet.getInt("q.q_id");
                                            %><br> Q. <a href="Answer.jsp?q=<%=Question_by_user.replaceAll(" ", "-") %>&Id=<%=question_id%>" ><%=Question_by_user%> ?</a><%
                                                    out.println("<br>Ans.</b>&nbsp;&nbsp;&nbsp;&nbsp;" + Answer_given_by_user);

                                                }
                                                if (count) {
                                                    out.println("No related answer found");
                                                }
                                            } catch (Exception e2) {
                                                out.println("Error in Answer search : " + e2);
                                                if (session.getAttribute("email") == null) {
                                                    email = "Anonuous";
                                                } else {
                                                    email = (String) session.getAttribute("email");
                                                }
                                                if (session.getAttribute("Session_id_of_user") == null) {
                                                    CurrentuserId = 0;
                                                } else {
                                                    CurrentuserId = (Integer) session.getAttribute("Session_id_of_user");
                                                }
                                                String URL = request.getRequestURL() + "?" + request.getQueryString();
                                            %><jsp:include page="ExceptionCollector.jsp">
                                                <jsp:param name="userName" value="<%=email%>"></jsp:param>
                                                <jsp:param name="userID" value="<%=CurrentuserId%>"></jsp:param>
                                                <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
                                                <jsp:param name="ExceptionMessage" value="<%=e2%>"></jsp:param>
                                            </jsp:include><%
                                                    }
                                                }
                                                //Starting the topic search program

                                                if (ParametrVariable.equals("Topic")) {
                                                    out.println("<center><div class=boxHeading>" + TOPIC + "</div></center>");
                                                    try {
                                                        String SearchValue_Case_Converted = SearchValue.toLowerCase();
                                                        String T = "SELECT * FROM topic WHERE lower(topic_name) LIKE '%" + SearchValue_Case_Converted + "%'";
                                                        preparedStatement = connection.prepareStatement(T);
                                                        resultSet = preparedStatement.executeQuery();
                                                        int count_ = 1;
                                                        boolean count = true;
                                                        while (resultSet.next()) {
                                                            count = false;
                                                            String Topic_assgned_by_user = convertStringUpperToLower(resultSet.getString("topic_name"));
                                                            int selected_topic_id = resultSet.getInt("unique_id");
                                                            out.print("<br><br>" + count_++ + "<b>&nbsp;&nbsp;<a href=topic.jsp?t="+Topic_assgned_by_user.replaceAll(" ", "+")+"&id=" + selected_topic_id + ">" + Topic_assgned_by_user + "</a></b>");

                                                        }
                                                        if (count) {
                                                            out.println("No related topic found");
                                                        }
                                                    } catch (Exception e) {
                                                        out.println("Error in Topic Search:" + e);
                                                        if (session.getAttribute("email") == null) {
                                                            email = "Anonuous";
                                                        } else {
                                                            email = (String) session.getAttribute("email");
                                                        }
                                                        if (session.getAttribute("Session_id_of_user") == null) {
                                                            CurrentuserId = 0;
                                                        } else {
                                                            CurrentuserId = (Integer) session.getAttribute("Session_id_of_user");
                                                        }
                                                        String URL = request.getRequestURL() + "?" + request.getQueryString();
                                            %><jsp:include page="ExceptionCollector.jsp">
                                                <jsp:param name="userName" value="<%=email%>"></jsp:param>
                                                <jsp:param name="userID" value="<%=CurrentuserId%>"></jsp:param>
                                                <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
                                                <jsp:param name="ExceptionMessage" value="<%=e%>"></jsp:param>
                                            </jsp:include><%
                                                    }
                                                }
                                                //Satring the userprofile search option

                                                if (ParametrVariable.equals("UserProfile")) {
                                                    out.println("<center><div class=boxHeading> " + USER_PROFILE + " </div></center>");
                                                    try {
                                                        String StoredUserFirstName;
                                                        int StoredUserID;
                                                        String SearchValue_Case_Converted = SearchValue.toLowerCase();
                                                        String SQL_T = "SELECT * FROM newuser WHERE lower(firstname) LIKE '%" + SearchValue_Case_Converted + "%' ";
                                                        preparedStatement = connection.prepareStatement(SQL_T);
                                                        resultSet = preparedStatement.executeQuery();
                                                        int count_ = 1;
                                                        boolean count = true;
                                                        while (resultSet.next()) {
                                                            count = false;
                                                            StoredUserID = resultSet.getInt("ID");
                                                            StoredUserFirstName =  convertStringUpperToLower(resultSet.getString("firstname"));
                                                           out.print("<br><br>" + count_++ + "<b>&nbsp;&nbsp;<a href=profile.jsp?user="+StoredUserFirstName.replaceAll(" ", "+") +"&ID=" + StoredUserID + ">" + StoredUserFirstName + " </a></b>");

                                                        }
                                                        if (count) {
                                                            out.println("No related user profile found");
                                                        }
                                                    } catch (Exception e) {
                                                        out.println("Error in User profile search:" + e);
                                                        if (session.getAttribute("email") == null) {
                                                            email = "Anonuous";
                                                        } else {
                                                            email = (String) session.getAttribute("email");
                                                        }
                                                        if (session.getAttribute("Session_id_of_user") == null) {
                                                            CurrentuserId = 0;
                                                        } else {
                                                            CurrentuserId = (Integer) session.getAttribute("Session_id_of_user");
                                                        }
                                                        String URL = request.getRequestURL() + "?" + request.getQueryString();
                                            %><jsp:include page="ExceptionCollector.jsp">
                                                <jsp:param name="userName" value="<%=email%>"></jsp:param>
                                                <jsp:param name="userID" value="<%=CurrentuserId%>"></jsp:param>
                                                <jsp:param name="URLParameter" value="<%=URL%>"></jsp:param>
                                                <jsp:param name="ExceptionMessage" value="<%=e%>"></jsp:param>
                                            </jsp:include><%
                                                        }
                                                    }

                                                }//IF statement closed here
                                            %>

                                            <%
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
                                                    try {
                                                        if (resultSet != null || !resultSet.isClosed()) {
                                                            try {
                                                                resultSet.close();
                                                            } catch (Exception e) {
                                                                out.println("Exception in closing resulatset " + e);
                                                            }
                                                        }
                                                    } catch (Exception error) {
                                                        out.println(error);
                                                    }
                                                    try {
                                                        if (preparedStatement != null || !preparedStatement.isClosed()) {
                                                            try {
                                                                preparedStatement.close();
                                                            } catch (Exception e) {
                                                                out.println("Exception in closing preparedStatement " + e);
                                                            }
                                                        }
                                                    } catch (Exception error) {
                                                        out.println(error);
                                                    }
                                                }
                                            %>

                                            <div class="clear-fix"></div>
                                        </div>
                                    </div>

                                </div>


                                <div class="row margintop10">


                                </div>

                            </div>

                        </div>
                    </div>
                </div>

                <!-- j Query -->
                <%@include file="notificationhtml.jsp" %>
                <jsp:include page="footer.jsp">
                    <jsp:param name="sl" value="<%=sl%>"/>
                </jsp:include>
                <script type="text/javascript" src="vendor/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="vendor/bootstrap/bootstrap.min.js"></script
                <script type="text/javascript" src="vendor/bootstrap-select/dist/js/bootstrap-select.js"></script>
            </div> <!-- /.main-page-wrapper -->
    </body>
 </html>