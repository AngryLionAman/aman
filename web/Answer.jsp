<%@page import="java.util.ArrayList"%>
<html lang="en">
    <head>
        <%@page language="java" %>
        <%@page import="java.sql.*" %> 
        <%@include file="site.jsp" %>
        <%@include file="validator.jsp" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta http-equiv="content-type" content="text/html" charset="utf-8">
        <style type="text/css">
            div.hidden{
                display: none;
            }
            div.visible{
                display: block;
            }
            .comment_box{
                border-style:solid;
                border-width:1px;
                float:left;
                background-color:#d4d4cb;
                width:280px;
                padding-left:20px;
                padding-top:25px;
                padding-bottom:10px;
            }
        </style>
        <script type="text/javascript">

            function showCommentBox() {
            <% if (session.getAttribute("Session_id_of_user") != null) { %>
                var div = document.getElementById('comment');
                div.className = 'visible';
            <% } else { %>alert("Please login first to comment");
            <%  }  %>
                }
        </script>

        <%!            String FOLLOWED_TOPIC = "";
            String QUESTION = "";
            String POSTED_BY = "";
            String ANSWER = "";
            String BE_THE_FIRST_PERSON = "";
            String SUBMIT = "";
            String RELATED_QUESTION = "";
            String COMPLETE_YOUR_PROFILE = "";
            String TRENDING_QUESTION = "";
            String TOPIC_YOU_MAY_LIKE = "";
            String ANSWERED_BY = "";
            String NO_RELATED_QUESTION_FOUND = "";
            String CLICK_HERE_TO_MORE_TOPIC = "";
        %>
        <%
            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                TOPIC_YOU_MAY_LIKE = "विषय आपको पसंद आ सकता है";
                POSTED_BY = "द्वारा प्रकाशित";
                TRENDING_QUESTION = "सक्रिय प्रश्न";
                FOLLOWED_TOPIC = "विषय जो आपको पसंद है";
                RELATED_QUESTION = "संबंधित सवाल";
                QUESTION = "प्रशन";
                ANSWER = "उत्तर";
                BE_THE_FIRST_PERSON = "इस प्रश्न का उत्तर देने वाले पहले व्यक्ति बनें";
                SUBMIT = "जमा करें";
                COMPLETE_YOUR_PROFILE = "अपनी प्रोफाइल पूरी कीजिए";
                ANSWERED_BY = "द्वारा उत्तर दिया गया";
                NO_RELATED_QUESTION_FOUND = "कोई संबंधित प्रश्न नहीं मिला";
                CLICK_HERE_TO_MORE_TOPIC = "अधिक विषय के लिए यहां क्लिक करें";
            } else {

                TOPIC_YOU_MAY_LIKE = "Topic You May Like";
                POSTED_BY = "Posted By";
                TRENDING_QUESTION = "Tranding Question";
                FOLLOWED_TOPIC = "Followed Topic";
                RELATED_QUESTION = "Related Question";
                QUESTION = "Ques";
                ANSWER = "Answer";
                BE_THE_FIRST_PERSON = "Be the first person to answer this question";
                SUBMIT = "Submit";
                COMPLETE_YOUR_PROFILE = "Complete your profile";
                ANSWERED_BY = "Answer By";
                NO_RELATED_QUESTION_FOUND = "No Related Question Found ";
                CLICK_HERE_TO_MORE_TOPIC = "Click here to more topic";
            }
        %>
        <%
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            int Question = 0;
            if (request.getParameter("Id") != null) {
                Question = Integer.valueOf(request.getParameter("Id"));
                //out.println(Question);
            } else {
                response.sendRedirect("index.jsp");
            }


        %>
        <%            Connection connection = null;
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
        %>
        <script src="ckeditor/ckeditor.js"></script>
        <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
        <script>
                (adsbygoogle = window.adsbygoogle || []).push({
                    google_ad_client: "ca-pub-8778688755733551",
                    enable_page_level_ads: true
                });
        </script>
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-128307055-1"></script>
        <script>
                window.dataLayer = window.dataLayer || [];
                function gtag() {
                    dataLayer.push(arguments);
                }
                gtag('js', new Date());
                gtag('config', 'UA-128307055-1');
        </script> 


        <meta charset="UTF-8">
        <!-- For IE -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- For Resposive Device -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- responsive style sheet -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <script type="text/javascript">
            function take_value(el, question_answer_id, action, section) {
            <% if (session.getAttribute("email") == null) { %>
                alert("Please login first");<%
                } else {%>
                el.onclick = function (event) {
                    event.preventDefault();
                };
                if (action === "upvote" && section === "answer") {
                    var http = new XMLHttpRequest();
                    http.open("POST", "<%=DB_AJAX_PATH%>/submit_answer_vote.jsp?question_answer_id=" + question_answer_id + "&action=upvote&section=answer", true);
                    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    http.send();
                }
                if (action === "downvote" && section === "answer") {
                    var http = new XMLHttpRequest();
                    http.open("POST", "<%=DB_AJAX_PATH%>/submit_answer_vote.jsp?question_answer_id=" + question_answer_id + "&action=downvote&section=answer", true);
                    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    http.send();
                }
                if (action === "upvote" && section === "question") {
                    var http = new XMLHttpRequest();
                    http.open("POST", "<%=DB_AJAX_PATH%>/submit_answer_vote.jsp?question_answer_id=" + question_answer_id + "&action=upvote&section=question", true);
                    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    http.send();
                }
                if (action === "downvote" && section === "question") {
                    var http = new XMLHttpRequest();
                    http.open("POST", "<%=DB_AJAX_PATH%>/submit_answer_vote.jsp?question_answer_id=" + question_answer_id + "&action=downvote&section=question", true);
                    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    http.send();
                }
            <% }%>
            }
        </script>

        <%
            String email = null;
            int CurrentuserId = 0;
            String StoredQuestion = "";
            String StoredAnswer = "";
            int StoredQuestionId = 0;
            try {
                //This statement not using because ,if a question having no result then it will not fetch the question also.
                //It is only applicable on that which having the at least one answer;

                //Now usnig the left join for,if any question had no answer the it will show null value 
                //but extra all function will work
                String sql = " SELECT q.q_id AS q_id,q.question AS question,SUBSTRING(a.answer,1,500) AS answer"
                        + " FROM question q LEFT JOIN answer a on q.q_id = a.q_id WHERE q.q_id = (?)";
                /*String sql = "SELECT q.q_id AS q_id,q.question AS question FROM question q WHERE q.q_id = (?)";*/
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Question);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    StoredQuestion = resultSet.getString("question");
                    StoredQuestionId = resultSet.getInt("q_id");
                    try {
                        PreparedStatement ps4 = null;
                        String countView = "UPDATE question SET total_view = total_view + 1 WHERE q_id =? ";
                        ps4 = connection.prepareStatement(countView);
                        ps4.setInt(1, StoredQuestionId);
                        ps4.executeUpdate();
                        ps4.close();

                    } catch (Exception msg) {
                        out.println("Error in cound the view" + msg);
                    }
                    StoredAnswer = resultSet.getString("answer");
                }

            } catch (Exception e) {
                out.println("Unable to retrieve!!" + e);
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
        %>
        <title><%=StoredQuestion%>- inquiryhere.com</title>
        <link rel="icon" href="https://www.inquiryhere.com/images/inquiryhere_Logo.PNG" type="image/png">
        <meta property="og:title" content="<%=StoredQuestion%>" />
        <%
            if (StoredAnswer != null) {
        %><meta property="og:description" content="<%=StoredAnswer%>"/>
        <meta property="description" content="<%=StoredAnswer%>"/><%
        } else {
        %><meta property="og:description" content="<%=StoredQuestion%>"/>
        <meta property="description" content="<%=StoredQuestion%>"/> <%
            }%>

        <meta property="og:url" content="https://www.inquiryhere.com/Answer.jsp">
        <meta property="og:site_name" content="inquiryhere.com" />
        <meta property="og:image" content="https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG" />
        <meta property="og:type" content="website">
        <meta property="og:locale" content="en_US">
        <%
            try {
                String p_fetch_topic_sql = "select tag_id as unique_id,"
                        + "(select topic_name from topic where unique_id = question_topic_tag.tag_id)"
                        + " topic_name from question_topic_tag  where question_id ='" + StoredQuestionId + "'";
                preparedStatement = connection.prepareStatement(p_fetch_topic_sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String topic_name_for_seo = resultSet.getString("topic_name").toLowerCase();
        %>
        <meta property="article:tag" content="<%=topic_name_for_seo%>" />              
        <%
                }
            } catch (Exception e) {
                out.println("Unable to retrieve!!" + e);
            }
        %>


    </head>

    <body>

        <div class="main-page-wrapper">
            <!-- Header _________________________________ -->
            <%--@include file="header.jsp" --%>
            <jsp:include page="header.jsp">
                <jsp:param name="sl" value="<%=sl%>"/>
            </jsp:include>
            <%
                //String name = null; // initilazing
                int id_of_user = 0;// initilazing
                int topic_id = 0;// initilazing
                int q_id = 0;// initilazing
                int q_asked_by_user = 0;// initilazing

                if (session.getAttribute("Session_id_of_user") != null) {
                    id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                }
            %>
            <div class="clear-fix"></div>
            <div class="bodydata">
                <div class="container clear-fix">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    Topic, Related to this question
                                    <%--  if (session.getAttribute("email") != null) {%>
                                    <%=FOLLOWED_TOPIC%>
                                    <% } else {%>
                                    <%=TOPIC_YOU_MAY_LIKE%>
                                    <% } --%>
                                </div>
                                <div>
                                    <ul>

                                        <%
                                            String topic_name;
                                            try {
                                                String p_fetch_topic;

                                                p_fetch_topic = "select tag_id as unique_id,"
                                                        + "(select topic_name from topic where unique_id = question_topic_tag.tag_id)"
                                                        + " topic_name from question_topic_tag  where question_id ='" + StoredQuestionId + "'";
                                                preparedStatement = connection.prepareStatement(p_fetch_topic);
                                                resultSet = preparedStatement.executeQuery();
                                                while (resultSet.next()) {
                                                    topic_name = resultSet.getString("topic_name").substring(0, 1).toUpperCase() + resultSet.getString("topic_name").substring(1).toLowerCase();
                                                    topic_id = resultSet.getInt("unique_id");
                                                    if (topic_id != 0) {%>
                                        <li><a href="topic.jsp?t=<%=topic_name.replaceAll(" ", "+")%>&id=<%=topic_id%>&sl=<%=sl%>"><%=topic_name%></a></li>
                                            <% }
                                                    }
                                                } catch (Exception e) {
                                                    out.println("Unable to retrieve!!" + e);
                                                }
                                            %>
                                        <a href="FollowMoreTopic.jsp?sl=<%=sl%>"><%=CLICK_HERE_TO_MORE_TOPIC%></a>
                                    </ul>
                                </div>
                            </div> 
                            <div class="clear-fix"></div>
                            <div class="clear-fix"></div>
                        </div>
                        <%
                            ArrayList<Integer> userId = new ArrayList<>();
                        %>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

                            <div class="row">
  <%
                                            String fullName_of_user_who_asked_the_question = null;
                                            int TotalView = 0;
                                            String date = " ";
                                            String higher_edu = " ";
                                            try {
                                                String sql_p = "SELECT user.id,user.higher_edu,user.firstname,q.q_id,q.id,q.total_view,date(q.posted_time) as date FROM newuser user RIGHT JOIN question q on user.id=q.id where q_id= (?)";
                                                preparedStatement = connection.prepareStatement(sql_p);
                                                preparedStatement.setInt(1, Question);
                                                resultSet = preparedStatement.executeQuery();
                                                while (resultSet.next()) {
                                                    int user_Id = resultSet.getInt("user.id");
                                                    date = resultSet.getString("date");
                                                    higher_edu = resultSet.getString("user.higher_edu");
                                                    TotalView = resultSet.getInt("q.total_view");
                                                    if (!userId.contains(user_Id)) {
                                                        userId.add(user_Id);
                                                    }
                                                    q_id = resultSet.getInt("q_id");
                                                    q_asked_by_user = resultSet.getInt("id");
                                                    fullName_of_user_who_asked_the_question = convertStringUpperToLower(resultSet.getString("firstname"));
                                                }
                                            } catch (Exception e) {
                                                out.println("Unable to retrieve!!" + e);
                                                   }
                                        %>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                                    <div class="themeBox" style="height:auto;">
                                        <div align="left" style="font-size: 20px;font-family: serif;">
                                            <a href="profile.jsp?user=<%=fullName_of_user_who_asked_the_question.replaceAll(" ", "+")%>&ID=<%=q_asked_by_user%>&sl=<%=sl%>"><%=firstName(fullName_of_user_who_asked_the_question)%></a>
                                            <%
                                                if(higher_edu != null && !higher_edu.isEmpty()){
                                                    out.println("("+higher_edu+")");
                                                }
                                            %>,
                                            <%=date%>
                                        </div>
                                        <div class="boxHeading marginbot10" style="border-radius: 5px;padding-top: 10px;padding-bottom: 10px;padding-left: 10px; background: #d5d5fd;">

                                             <h1 style="font-size: 20px; "><%=QUESTION%> :<%=StoredQuestion%> ?</h1> 
                                        </div>

                                      
                                        <!--div class="questionArea">

                                            <div class="postedBy"><!%=POSTED_BY%> :<a href="profile.jsp?user=<!%=fullName_of_user_who_asked_the_question.replaceAll(" ", "+")%>&ID=<!%=q_asked_by_user%>&sl=<!%=sl%>"><!%=firstName(fullName_of_user_who_asked_the_question)%></a> </div>

                                        </div-->
                                        <a href="javascript:void(0)" onclick="this.style.color = 'red';return take_value(this, '<%=q_id%>', 'upvote', 'question');" >Upvote</a> &nbsp;&nbsp; 
                                        <a href="javascript:void(0)" onclick="this.style.color = 'red';return take_value(this, '<%=q_id%>', 'downvote', 'question');" >Downvote</a> &nbsp;&nbsp;
                                        <a href="javascript:void(0)" value="Comment" onclick="showCommentBox()">Comment</a>&nbsp;&nbsp;
<!--                                        <a href="javascript:void(0)"></a>-->
                                        View(<%=TotalView%>)
                                        <form action="SubmitQuestionComment.jsp" method="get">
                                            <div class="hidden" id="comment">
                                                <input type="hidden" name="question_id" value="<%=q_id%>">
                                                <input type="hidden" name="question" value="<%=StoredQuestion%>">
                                                <textarea name="comments" rows="3" cols="30" required=""></textarea>
                                                <input type="submit" name="sub" value="Send Comment">
                                            </div>
                                        </form>
                                    </div>
                                    <!-- Comment on question -->
                                    <div align="right">

                                        <%
                                            try {
                                                String sql_question_comment = "SELECT unique_id,user_id,"
                                                        + "(SELECT firstname FROM newuser WHERE id = comments.user_id )AS fullname,"
                                                        + "q_id,comments,time FROM comments WHERE q_id = ? AND user_id IS NOT NULL AND q_id IS NOT NULL";
                                                preparedStatement = connection.prepareStatement(sql_question_comment);
                                                preparedStatement.setInt(1, q_id);
                                                resultSet = preparedStatement.executeQuery();
                                                while (resultSet.next()) {
                                                    String question_comments = resultSet.getString("comments");
                                                    String userName = resultSet.getString("fullname");
                                                    String time = resultSet.getString("time");
                                                    int user_id = resultSet.getInt("user_id");
                                                    if (!userId.contains(user_id)) {
                                                        userId.add(user_id);
                                                    }
                                                    out.println("(" + time + ") " + question_comments + ":- ");
                                        %>
                                        <a href="profile.jsp?user=<%=userName.replaceAll(" ", "+")%>&ID=<%=user_id%>&sl=<%=sl%>"><%=convertStringUpperToLower(userName)%></a><br>
                                        <%
                                                }

                                            } catch (Exception msg) {
                                                out.println("Error in loading question comment: -" + msg);
                                            }
                                        %>

                                    </div>


                                    <div class="boxHeading marginbot10"><%=ANSWER%>:</div>

                                    <%
                                        try {
                                            String sql_p = "SELECT user.firstname,ans.answer,ans.a_id,ans.Answer_by_id,ans.total_view FROM newuser user "
                                                    + "RIGHT JOIN answer ans on user.id = ans.Answer_by_id where q_id = '" + q_id + "' and a_id is not null order by vote desc";
                                            preparedStatement = connection.prepareStatement(sql_p);
                                            resultSet = preparedStatement.executeQuery();
                                            int count = 0;

                                            while (resultSet.next()) {
                                                count++;
                                                String answer = resultSet.getString("answer");
                                                int who_gave_answer = resultSet.getInt("Answer_by_id");
                                                int total_view = (resultSet.getInt("ans.total_view") + 1);
                                                if (!userId.contains(who_gave_answer)) {
                                                    userId.add(who_gave_answer);
                                                }
                                                String firstname = convertStringUpperToLower(resultSet.getString("firstname"));
                                                int answer_id = resultSet.getInt("ans.a_id");

                                                try {
                                                    PreparedStatement ps1 = null;
                                                    String countView = "UPDATE answer SET total_view = total_view + 1 WHERE a_id =? ";
                                                    ps1 = connection.prepareStatement(countView);
                                                    ps1.setInt(1, answer_id);
                                                    ps1.executeUpdate();
                                                    ps1.close();

                                                } catch (Exception msg) {
                                                    out.println("Error in cound the view" + msg);
                                                }
                                    %>
                                    <div class="themeBox" style="height:auto;">
                                        <div class="boxHeading marginbot10" style="font-size: 15px;font-family: Arial, Helvetica, sans-serif;">
                                            <%=answer%> 
                                        </div>
                                        <div class="questionArea">
                                            <div class="postedBy"><%=ANSWERED_BY%> :<a href="profile.jsp?user=<%=firstname.replaceAll(" ", "+")%>&ID=<%=who_gave_answer%>&sl=<%=sl%>"><%=firstName(firstname)%></a> 
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <%  if (session.getAttribute("Session_id_of_user") != null) {
                                                        int Session_id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                                                        if (who_gave_answer == Session_id_of_user) {%>

                                                <a href="edit_a.jsp?q_id=<%=Question%>&ans_id=<%=answer_id%>&ans_by_id=<%=who_gave_answer%>">Edit</a>
                                                <% }
                                                }%> </div>
                                        </div>
                                        <a href="javascript:void(0)" onclick="this.style.color = 'red'; return take_value(this, '<%=answer_id%>', 'upvote', 'answer');" >Upvote</a>&nbsp;&nbsp; 
                                        <a href="javascript:void(0)" onclick="this.style.color = 'red';return take_value(this, '<%=answer_id%>', 'downvote', 'answer');" >Downvote</a>&nbsp;&nbsp;
                                        <a href="javascript:void(0)" value="Comment" onclick="showAns<%=answer_id%>CommentBox()">Comment</a>&nbsp;&nbsp;
                                        <a href="javascript:void(0)">View(<%=total_view%>)</a>
                                        <form action="SubmitAnswerComment.jsp" method="get">
                                            <div class="hidden" id="Anscomment<%=answer_id%>">
                                                <input type="hidden" name="answer_id" value="<%=answer_id%>">
                                                <input type="hidden" name="question_id" value="<%=q_id%>">
                                                <input type="hidden" name="question" value="<%=StoredQuestion%>">
                                                <textarea name="comments" rows="3" cols="30" required=""></textarea>
                                                <input type="submit" name="sub" value="Send Comment">
                                            </div>
                                        </form>

                                        <script type="text/javascript">
                                        function showAns<%=answer_id%>CommentBox() {
                                            <% if (session.getAttribute("Session_id_of_user") != null) {%>
                                            var div = document.getElementById('Anscomment<%=answer_id%>');
                                            div.className = 'visible';
                                            <% } else { %>
                                            alert("Please Login First to comment!!!");
                                            <% } %>
                                        }
                                        </script>
                                    </div>
                                    <!-- Comment on Answer -->
                                    <div align="right">

                                        <%
                                            try {
                                                String sql_question_comment = "SELECT unique_id,user_id,"
                                                        + "(SELECT firstname FROM newuser WHERE id = comments.user_id )AS fullname,"
                                                        + "ans_id,comments,time FROM comments WHERE ans_id = ? AND user_id IS NOT NULL AND ans_id IS NOT NULL";
                                                preparedStatement = connection.prepareStatement(sql_question_comment);
                                                preparedStatement.setInt(1, answer_id);
                                                ResultSet result = preparedStatement.executeQuery();
                                                while (result.next()) {
                                                    String question_comments = result.getString("comments");
                                                    String userName = result.getString("fullname");
                                                    String time = result.getString("time");
                                                    int user_id = result.getInt("user_id");
                                                    if (!userId.contains(user_id)) {
                                                        userId.add(user_id);
                                                    }
                                                    out.println("(" + time + ") " + question_comments + ":- ");
                                        %>
                                        <a href="profile.jsp?user=<%=userName.replaceAll(" ", "+")%>&ID=<%=user_id%>&sl=<%=sl%>"><%=convertStringUpperToLower(userName)%></a><br>
                                        <%
                                                }
                                                result.close();

                                            } catch (Exception msg) {
                                                out.println("Error in loading question comment: -" + msg);
                                            }
                                        %>

                                    </div>
                                    <%
                                        }

                                        if (count == 0) {
                                    %>
                                    <div class="themeBox" style="height:auto;">
                                        <div class="boxHeading marginbot10">
                                            <%=BE_THE_FIRST_PERSON%>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    } catch (Exception e) {
                                        out.println("Unable to retrieve!!" + e);
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
                                    %>
                                    <form name="submitAnswer" method="post" action="SubmitAnswer.jsp?_id_of_user=<%=id_of_user%>&q_id=<%=q_id%>&URL=<%=request.getRequestURL()%>?Id=<%=q_id%>&sl=<%=sl%>">
                                        <input type="hidden" name="question" value="<%=StoredQuestion%>">
                                        <textarea class="ckeditor" name="answer" required="">
                                            <%
                                                if (request.getParameter("ans") != null) {
                                                    out.println(request.getParameter("ans"));
                                                }
                                            %>
                                        </textarea>
                                        <input type="submit" name="Post" value="<%=SUBMIT%>"> 
                                    </form>


                                    <div class="clear-fix"></div>

                                </div>
                            </div>

                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    <%=RELATED_QUESTION%>
                                </div>
                                <div>
                                    <%
                                        Statement stmt_detail = null;
                                        ResultSet rs_detail = null;
                                        String question_detail;
                                        try {
                                            stmt_detail = connection.createStatement();
                                            int count = 0;
                                            String q_detail = "SELECT DISTINCT q.id,q.question,q.q_id FROM question q "
                                                    + "RIGHT JOIN question_topic_tag qtt ON qtt.question_id=q.q_id WHERE tag_id "
                                                    + "IN (SELECT DISTINCT(tag_id) AS tag_id FROM question_topic_tag WHERE question_id = '" + q_id + "') "
                                                    + "AND q_id IS NOT NULL LIMIT 5";
                                            rs_detail = stmt_detail.executeQuery(q_detail);
                                            try {
                                                while (rs_detail.next()) {
                                                    question_detail = rs_detail.getString("question");
                                                    int questionID = rs_detail.getInt("q_id");
                                                    try {
                                                        PreparedStatement ps4 = null;
                                                        String countView = "UPDATE question SET total_view = total_view + 1 WHERE q_id =? ";
                                                        ps4 = connection.prepareStatement(countView);
                                                        ps4.setInt(1, questionID);
                                                        ps4.executeUpdate();
                                                        ps4.close();

                                                    } catch (Exception msg) {
                                                        out.println("Error in cound the view" + msg);
                                                    }
                                                    if (questionID != q_id) {
                                                        if (question_detail != null) {
                                                            count++;
                                    %>
                                    <a href="Answer.jsp?q=<%=question_detail.replaceAll(" ", "-")%>&Id=<%=questionID%>&sl=<%=sl%>" ><%=question_detail%></a><br><br>
                                    <%
                                                }

                                            }
                                        }
                                    } catch (Exception error) {
                                        out.println("Error in inside blok" + error);
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
                                        <jsp:param name="ExceptionMessage" value="<%=error%>"></jsp:param>
                                    </jsp:include><%
                                        }
                                        if (count == 0) {
                                            if (request.getParameter("lang") != "hindi") {
                                                out.println(NO_RELATED_QUESTION_FOUND + " !!!");
                                            } else {
                                                out.println(NO_RELATED_QUESTION_FOUND + "!!!");
                                            }
                                        }
                                        rs_detail.close();
                                        stmt_detail.close();
                                    } catch (Exception e) {
                                        out.println("Exception in Related question :" + e);
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
                                    %>
                                </div>

                            </div>
                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    Question you may like
                                </div>
                                <div>
                                    <%
                                        try {
                                            ResultSet rs = null;
                                            PreparedStatement ps = null;
                                            String sql = "select q_id,question from question order by rand() limit 5";
                                            ps = connection.prepareStatement(sql);
                                            rs = ps.executeQuery();
                                            while (rs.next()) {
                                                int question_id = rs.getInt("q_id");
                                                try {
                                                    PreparedStatement ps4 = null;
                                                    String countView = "UPDATE question SET total_view = total_view + 1 WHERE q_id =? ";
                                                    ps4 = connection.prepareStatement(countView);
                                                    ps4.setInt(1, question_id);
                                                    ps4.executeUpdate();
                                                    ps4.close();

                                                } catch (Exception msg) {
                                                    out.println("Error in cound the view" + msg);
                                                }
                                                String question = rs.getString("question");
                                    %>
                                    <a href="Answer.jsp?q=<%=question.replaceAll(" ", "-")%>&Id=<%=question_id%>&sl=<%=sl%>" ><%=question%></a><br><br>
                                    <%
                                            }
                                        } catch (Exception msg) {
                                            out.println("Error in 'you may like question' " + msg);
                                        }
                                    %>
                                </div>

                            </div>
                            <%
                                    session.setAttribute("AllUserIdList", userId);
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
                            %>
                            <%
                                if (session.getAttribute("email") != null) {
                            %>
                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    <%=COMPLETE_YOUR_PROFILE%>
                                </div>
                                <div>
                                    <jsp:include page="CompleteUserProfile.jsp" >
                                        <jsp:param name="sl" value="<%=sl%>"></jsp:param>
                                    </jsp:include>
                                </div>

                            </div><% }%>
                            <div class="clear-fix"></div>
                            <%--
                                if (session.getAttribute("email") != null) {
                            %>
                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    <%=TRENDING_QUESTION%>
                                </div>
                                <div>
                                    <jsp:include page="TrendingQuestion.jsp" />
                                </div>
                            </div><% }--%>
                            <div class="clear-fix"></div>

                            <div class="clear-fix"></div>
                        </div>
                        <div class="clear-fix"></div>
                    </div>
                    <div class="clear-fix"></div>
                </div>
                <div class="clear-fix"></div>
            </div>
            <div class="clear-fix"></div>

            <!--            <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">
                            </div>
                        </div>-->
            <%@include file="notificationhtml.jsp" %>
            <jsp:include page="footer.jsp">
                <jsp:param name="sl" value="<%=sl%>"/>
            </jsp:include>
            <script type="text/javascript" src="vendor/jquery-2.1.4.js"></script>
            <!-- Bootstrap JS -->
            <script type="text/javascript" src="vendor/bootstrap/bootstrap.min.js"></script>
            <!-- Bootstrap Select JS -->
            <script type="text/javascript" src="vendor/bootstrap-select/dist/js/bootstrap-select.js"></script>
        </div> <!-- /.main-page-wrapper -->

    </body>
</html>