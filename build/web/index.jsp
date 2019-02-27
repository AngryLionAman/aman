<html lang="en">
    <head>
        <%@page language="java" %>
        <%@page import="java.sql.*" %> 
        <%@include file="site.jsp" %>
        <meta charset="UTF-8">
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%!            String name = null;
            int id_of_user = 0;
            int topic_id = 0;

            String TOPIC_YOU_MAY_LIKE = "";
            String POST_SOMETHING = "";
            String POST_SOME_THING_HERE = "";
            String POST = "";
            String QUESTION_YOU_MAY_LIKE = "";
            String POSTED_BY = "";
            String TRENDING_QUESTION = "";
            String POST_YOUR_QUESTION_HERE = "";
            String PLEASE_LOGIN_FIRST = "";
            String CLOSE = "";
            String CLICK_HERE_TO_LOGIN = "";
            String FOLLOWED_TOPIC = "";
            String CLICK_HERE_TO_MORE_TOPIC = "";
            String PUT_YOUR_QUESTION_HERE = "";
            String EX = "";
            String TAG_SUGGESTION_DESCRIPTION = "";
            String TAG_EXMAPLE = "";
            String RECENT_POSTED_QUESTION = "";
            String RELATED_QUESTION = "";
            String YOUR_CURRENT_NODIFICATION = "";
        %>
        <%
            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "eng";
            }

            if (sl.equalsIgnoreCase("hi")) {

                TOPIC_YOU_MAY_LIKE = "विषय आपको पसंद आ सकता है";
                POST_SOMETHING = "कुछ पोस्ट करें";
                POST_SOME_THING_HERE = "यहाँ कुछ पोस्ट करें";
                POST = "post";
                QUESTION_YOU_MAY_LIKE = "सवाल आपको पसंद आ सकता है";
                POSTED_BY = "द्वारा प्रकाशित";
                TRENDING_QUESTION = "सक्रिय प्रश्न";
                POST_YOUR_QUESTION_HERE = "यहाँ अपना प्रश्न डाले";
                PLEASE_LOGIN_FIRST = "पहले प्रवेश करें";
                CLOSE = "बंद करे";
                CLICK_HERE_TO_LOGIN = "लॉग इन करने के लिए यहां क्लिक करें";
                FOLLOWED_TOPIC = "विषय जो आपको पसंद है";
                CLICK_HERE_TO_MORE_TOPIC = "अधिक विषय के लिए यहां क्लिक करें";
                PUT_YOUR_QUESTION_HERE = "अपना प्रश्न यहाँ रखें";
                EX = "उदाहरण :कैसे है ,क्या है ";
                TAG_SUGGESTION_DESCRIPTION = "अपने प्रश्न से संबंधित कम से कम दो टैग प्रदान करें। कोमा (,) का उपयोग करके अलग करे";
                TAG_EXMAPLE = "उदाहरण :विज्ञान,भौतिक , रसायन विज्ञान  ";
                RECENT_POSTED_QUESTION = "हाल ही में पोस्ट किया गया सवाल";
                RELATED_QUESTION = "संबंधित सवाल";
                YOUR_CURRENT_NODIFICATION = "आपकी वर्तमान अधिसूचना";

            } else {

                TOPIC_YOU_MAY_LIKE = "Topic You May Like";
                POST_SOMETHING = "Post Something";
                POST_SOME_THING_HERE = "Post Something here";
                POST = "POST";
                QUESTION_YOU_MAY_LIKE = "Question You May Like";
                POSTED_BY = "Posted By";
                TRENDING_QUESTION = "Tranding Question";
                POST_YOUR_QUESTION_HERE = "Post Your Question Here";
                PLEASE_LOGIN_FIRST = "Please Lgin First";
                CLOSE = "Close";
                CLICK_HERE_TO_LOGIN = "Click here to login";
                FOLLOWED_TOPIC = "Followed Topic";
                CLICK_HERE_TO_MORE_TOPIC = "Click here to more topic";
                PUT_YOUR_QUESTION_HERE = "Put Your Question Here";
                EX = "Ex: What is,How to..";
                TAG_SUGGESTION_DESCRIPTION = "Provide at least two tag related to your question. separate tag using Coma(,)";
                TAG_EXMAPLE = "Ex:Java,Database,c language";
                RECENT_POSTED_QUESTION = "Recent posted Question";
                RELATED_QUESTION = "Related Question";
                YOUR_CURRENT_NODIFICATION = "Your current nodification";
            }
        %>
        <!-- For IE -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- For Resposive Device -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="content-type" content="text/html" charset="utf-8">
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-128307055-1"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());
            gtag('config', 'UA-128307055-1');
        </script> 
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- responsive style sheet -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <meta property="og:description" content="india first knowledge based social media where experts give you advise and suggestion related to your query .you can ask and share the information which you want to explore.our motive is to be specific according to your demand" />
        <meta property="og:image" content="https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG" />
        <meta property="og:type" content="website">
        <meta property="og:locale" content="en_US">
        <meta property="og:title" content="india first knowledge based social media platform where experts give you advise and suggestion related to your query" />
        <meta property="og:url" content="https://www.inquiryhere.com/">
        <meta property="og:site_name" content="https://www.inquiryhere.com/" />

        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- responsive style sheet -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>

        <script type="text/javascript">
            google.load("elements", "1", {packages: "transliteration"});
        </script> 

        <script>
            function OnLoad() {
                var currValue = document.getElementById("text1");

                var options = {
                    sourceLanguage: google.elements.transliteration.LanguageCode.ENGLISH,
                    destinationLanguage: [google.elements.transliteration.LanguageCode.HINDI],
                    shortcutKey: 'ctrl+g',
                    transliterationEnabled: true
                };


                var control = new
                        google.elements.transliteration.TransliterationControl(options);
                control.makeTransliteratable(["text1"]);
                var postValue = document.getElementById("text1");

            }

            google.setOnLoadCallback(OnLoad);

        </script> 
        <script type="text/javascript">
            function take_value(el, question_id, action) {
            <% if (session.getAttribute("email") == null) { %>
                alert("Please login first");<%
                } else {%>
                el.onclick = function (event) {
                    event.preventDefault();
                };
                if (action === "upvote") {
                    var http = new XMLHttpRequest();
                    http.open("POST", "<%=DB_AJAX_PATH%>/submit_question_vote.jsp?question_id=" + question_id + "&action=upvote", true);
                    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    http.send();
                }
                if (action === "downvote") {
                    var http = new XMLHttpRequest();
                    http.open("POST", "<%=DB_AJAX_PATH%>/submit_question_vote.jsp?question_id=" + question_id + "&action=downvote", true);
                    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    http.send();
                }
            <% }%>
            }
        </script>

    </head>

    <body>
        <div class="main-page-wrapper">


            <%--@include file="header.jsp" --%>
            <jsp:include page="header.jsp">
                <jsp:param name="sl" value="<%=sl%>"/>
            </jsp:include>
            <%
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
            %>

            <%
                if (session.getAttribute("email") != null) {
                    String email = (String) session.getAttribute("email");
                    try {
                        String sql1 = "SELECT * FROM newuser WHERE email = '" + email + "'";
                        preparedStatement = connection.prepareStatement(sql1);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            id_of_user = resultSet.getInt("id");
                            name = resultSet.getString("firstname");
                        }
                    } catch (Exception e) {
                        out.println("Unable to retrieve!!" + e);
                    }
                }
            %>
            <div class="clear-fix"></div>
            <div class="bodydata">
                <div class="container clear-fix">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                            <% // if (session.getAttribute("email") == null) {%>
                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    <% 
                                        if (session.getAttribute("email") != null) {%>
                                    <%=FOLLOWED_TOPIC%>
                                    <%  } else {%>
                                    <%=TOPIC_YOU_MAY_LIKE%>
                                    <% }  %>
                                </div>
                                <div>
                                    <ul>
                                        <%
                                            String sql = "";
                                            String topic_name;
                                            try {
                                                if (session.getAttribute("email") != null) {
                                                    sql = "select t.unique_id,t.topic_name from topic t "
                                                            + "right join topic_followers_detail de "
                                                            + "on t.unique_id = de.topic_id "
                                                            + "where user_or_followers_id= '" + id_of_user + "'";
                                                } else {
                                                    sql = "select * from topic LIMIT 30,20";
                                                }
                                                preparedStatement = connection.prepareStatement(sql);
                                                resultSet = preparedStatement.executeQuery();
                                                while (resultSet.next()) {
                                                    topic_name = resultSet.getString("topic_name").substring(0, 1).toUpperCase()+resultSet.getString("topic_name").substring(1);
                                                    topic_id = resultSet.getInt("unique_id");
                                                    if (topic_id != 0) {%>
                                        <li><a href="topic.jsp?id=<%=topic_id%>&sl=<%=sl%>"><%=topic_name%></a></li>
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
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="themeBox" style="height:200px;">
                                        <div class="boxHeading">
                                            <%=POST_SOMETHING%>
                                        </div>
                                        <div><textarea type="text" class="anstext" placeholder="<%=POST_YOUR_QUESTION_HERE%>" data-toggle="modal" data-target="#myModal"></textarea></div>

                                        <div class="float-right margintop20" style="vertical-align:bottom">
                                            <button type="button" class="btn" data-toggle="modal" data-target="#myModal"><%=POST%></button>
                                            <!-- btn-info btn-lg -->
                                        </div>
                                        <div class="clear-fix"></div>
                                    </div>
                                </div>

                            </div>


                            <div class="row">

                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">


                                    <h4><%=RECENT_POSTED_QUESTION%></h4>
                                    <%
                                        String sql3 = "select q.q_id,q.question,user.firstname,user.ID from question q right join newuser user on user.id = q.id order by q_id desc limit 5";
                                        String UserName_for_trending_question_T = null;
                                        try {
                                            preparedStatement = connection.prepareStatement(sql3);
                                            resultSet = preparedStatement.executeQuery();
                                            while (resultSet.next()) {
                                                String TrendingQuestion_T = resultSet.getString("question");
                                                int question_id = resultSet.getInt("q.q_id");
                                                int userID = resultSet.getInt("user.ID");
                                                UserName_for_trending_question_T = resultSet.getString("firstname");
                                    %>
                                    <div class="themeBox" style="height:auto;">

                                        <div class="boxHeading marginbot10">
                                            <a href="Answer.jsp?Id=<%=question_id%>&sl=<%=sl%>" ><%=TrendingQuestion_T%> ?</a>

                                        </div>
                                        <div class="questionArea">

                                            <div class="postedBy"><%=POSTED_BY%> :<a href="profile.jsp?ID=<%=userID%>&sl=<%=sl%>"> <%=UserName_for_trending_question_T%></a>
                                                &nbsp;&nbsp;&nbsp;&nbsp; 
                                                <%  if (session.getAttribute("Session_id_of_user") != null) {
                                                        int Session_id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                                                        if (userID == Session_id_of_user) {%>
                                                <a href="edit_q.jsp?Id=<%=question_id%>&sl=<%=sl%>">edit</a>
                                                <% }
                                                    }%>
                                            </div>
                                            <a href="javascript:void(0)" onclick="this.style.color = 'red';return take_value(this, '<%=question_id%>', '<%="upvote"%>');" >Upvote</a>&nbsp;&nbsp; 
                                            <a href="javascript:void(0)" onclick="this.style.color = 'red';return take_value(this, '<%=question_id%>', '<%="downvote"%>');" >Downvote</a>&nbsp;&nbsp; 
                                            <a href="Answer.jsp?Id=<%=question_id%>&sl=<%=sl%>" >Answer</a>
                                        </div>

                                    </div><%
                                            }
                                        } catch (Exception e) {
                                            out.println("Error " + e);
                                        }
                                    %> 
                                    <%
                                        if (session.getAttribute("email") != null) {
                                    %>

                                    <h4><%=RELATED_QUESTION%></h4>  
                                    <%
                                        Statement stmt2 = null;
                                        ResultSet rs2 = null;
                                        String name1 = null;
                                        String question, fname = null;
                                        int ide = 0;
                                        try {
                                            String sql4 = "select DISTINCT q.id,q.q_id,q.question from question q "
                                                    + "right join question_topic_tag qtt on q.q_id = qtt.question_id "
                                                    + "where tag_id IN (select t.unique_id from topic t "
                                                    + "right join topic_followers_detail de on t.unique_id = de.topic_id "
                                                    + "where user_or_followers_id= '" + id_of_user + "')";
                                            preparedStatement = connection.prepareStatement(sql4);
                                            resultSet = preparedStatement.executeQuery();
                                            while (resultSet.next()) {
                                                question = resultSet.getString("question");
                                                if (question != null) {
                                                    ide = resultSet.getInt("id");
                                                    stmt2 = connection.createStatement();
                                                    String T = "SELECT firstname FROM newuser WHERE id='" + ide + "' ";
                                                    rs2 = stmt2.executeQuery(T);
                                                    while (rs2.next()) {
                                                        fname = rs2.getString("firstname");
                                                    }

                                    %>
                                    <div class="themeBox" style="height:auto;">

                                        <div class="boxHeading marginbot10">
                                            <a href="Answer.jsp?Id=<%=resultSet.getInt("q.q_id")%>&sl=<%=sl%>" ><%=question%> ?</a>
                                        </div>
                                        <div class="questionArea">
                                            <div class="postedBy"><%=POSTED_BY%> : <a href="profile.jsp?ID=<%=ide%>&sl=<%=sl%>"><%=fname%></a></div>
                                        </div>
                                        <a href="javascript:void(0)" onclick="this.style.color = 'red';return take_value(this, '<%=resultSet.getInt("q.q_id")%>', '<%="upvote"%>');" >Upvote</a>&nbsp;&nbsp; 
                                        <a href="javascript:void(0)" onclick="this.style.color = 'red';return take_value(this, '<%=resultSet.getInt("q.q_id")%>', '<%="downvote"%>');" >Downvote</a>&nbsp;&nbsp; 
                                        <a href="Answer.jsp?Id=<%=resultSet.getInt("q.q_id")%>&sl=<%=sl%>" >Answer</a>

                                    </div>


                                    <%             }
                                            }
                                            stmt2.close();
                                            rs2.close();
                                        } catch (Exception e) {
                                            out.println("<b style=color:red;>No question found related to your selected topic</b>");
                                        }
                                    } else {
                                    %>

                                    <h4><%=QUESTION_YOU_MAY_LIKE%></h4>

                                    <%!
                                        public int nullIntconvert(String str) {
                                            int num = 0;
                                            if (str == null) {
                                                str = "0";
                                            } else if ((str.trim()).equals("null")) {
                                                str = "0";
                                            } else if (str.equals("")) {
                                                str = "0";
                                            }
                                            try {
                                                num = Integer.parseInt(str);
                                            } catch (Exception e) {
                                            }
                                            return num;
                                        }
                                    %>
                                    <%
                                        ResultSet rs1 = null;
                                        ResultSet rs2 = null;
                                        ResultSet rs3 = null;
                                        PreparedStatement ps1 = null;
                                        PreparedStatement ps2 = null;
                                        PreparedStatement ps3 = null;
                                        // Connection connection2 = null;

                                        int showRows = 10;
                                        int totalRecords = 5;
                                        int totalRows = nullIntconvert(request.getParameter("totalRows"));
                                        int totalPages = nullIntconvert(request.getParameter("totalPages"));
                                        int iPageNo = nullIntconvert(request.getParameter("iPageNo"));
                                        int cPageNo = nullIntconvert(request.getParameter("cPageNo"));

                                        int startResult = 0;
                                        int endResult = 0;
                                        if (iPageNo == 0) {
                                            iPageNo = 0;
                                        } else {
                                            iPageNo = Math.abs((iPageNo - 1) * showRows);
                                        }
                                        try {
                                            Class.forName("com.mysql.jdbc.Driver");
                                            connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);

                                            String query1 = "SELECT SQL_CALC_FOUND_ROWS * FROM question limit " + iPageNo + "," + showRows + "";
                                            ps1 = connection.prepareStatement(query1);
                                            rs1 = ps1.executeQuery();

                                            String query2 = "SELECT FOUND_ROWS() as cnt";
                                            ps2 = connection.prepareStatement(query2);
                                            rs2 = ps2.executeQuery();
                                        } catch (Exception error) {
                                            out.println("Error occer in :" + error);
                                        }
                                        try {
                                            if (rs2.next()) {
                                                totalRows = rs2.getInt("cnt");
                                            }
                                            String Username = null;
                                            int userId = 0;
                                    %>
                                    <form>

                                        <input type="hidden" name="iPageNo" value="<%=iPageNo%>">
                                        <input type="hidden" name="cPageNo" value="<%=cPageNo%>">
                                        <input type="hidden" name="showRows" value="<%=showRows%>">
                                        <%
                                            while (rs1.next()) {
                                        %>
                                        <div class="themeBox" style="height:auto;">

                                            <div class="boxHeading marginbot10">
                                                <a href="Answer.jsp?Id=<%=rs1.getInt("q_id")%>&sl=<%=sl%>" ><%=rs1.getString("question")%> ?</a>
                                            </div>
                                            <%
                                                String query3 = "SELECT ID,firstname FROM newuser WHERE id='" + rs1.getString("id") + "' ";
                                                ps3 = connection.prepareStatement(query3);
                                                rs3 = ps3.executeQuery();

                                                while (rs3.next()) {
                                                    Username = rs3.getString("firstname");
                                                    userId = rs3.getInt("ID");
                                                    //out.println(fname);
                                                }
                                                rs3.close();
                                                ps3.close();%>
                                            <div class="questionArea">

                                                <div class="postedBy"><%=POSTED_BY%> :<a href="profile.jsp?ID=<%=userId%>&sl=<%=sl%>"> <%=Username%></a></div>

                                            </div>
                                                <a href="javascript:void(0)" onclick="return take_value(this, '<%=rs1.getInt("q_id")%>', 'upvote');">Upvote</a>&nbsp;&nbsp;
                                                <a href="javascript:void(0)" onclick="return take_value(this, '<%=rs1.getInt("q_id")%>', 'upvote');">Downvote</a>&nbsp;&nbsp;
                                                <a href="Answer.jsp?Id=<%=rs1.getInt("q_id")%>&sl=<%=sl%>">Answer</a>

                                        </div>

                                        <%
                                                }
                                            } catch (Exception e) {
                                                out.println(e);

                                            }
                                        %>

                                        <%
                                            try {
                                                if (totalRows < (iPageNo + showRows)) {
                                                    endResult = totalRows;
                                                } else {
                                                    endResult = (iPageNo + showRows);
                                                }
                                                startResult = (iPageNo + 1);
                                                totalPages = ((int) (Math.ceil((double) totalRows / showRows)));
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        %>
                                        <table width="100%" cellpadding="0" cellspacing="0" border="1" >
                                            <tr>
                                                <td colspan="3">
                                                    <div>
                                                        <%
                                                            int i = 0;
                                                            int cPage = 0;
                                                            if (totalRows != 0) {
                                                                cPage = ((int) (Math.ceil((double) endResult / (totalRecords * showRows))));

                                                                int prePageNo = (cPage * totalRecords) - ((totalRecords - 1) + totalRecords);
                                                                if ((cPage * totalRecords) - (totalRecords) > 0) {
                                                        %>
                                                        <a href="index.jsp?iPageNo=<%=prePageNo%>&cPageNo=<%=prePageNo%>&sl=<%=sl%>"> << Previous</a>
                                                        <%
                                                            }
                                                            for (i = ((cPage * totalRecords) - (totalRecords - 1)); i <= (cPage * totalRecords); i++) {
                                                                if (i == ((iPageNo / showRows) + 1)) {%>
                                                        <a href="index.jsp?iPageNo=<%=i%>&sl=<%=sl%>" style="cursor:pointer;color:red"><b><%=i%></b></a>
                                                                <%
                                                                } else if (i <= totalPages) {
                                                                %>
                                                        <a href="index.jsp?iPageNo=<%=i%>&sl=<%=sl%>"><%=i%></a>
                                                        <%
                                                                }
                                                            }
                                                            if (totalPages > totalRecords && i < totalPages) {
                                                        %>
                                                        <a href="index.jsp?iPageNo=<%=i%>&cPageNo=<%=i%>&sl=<%=sl%>"> >> Next</a>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                        <b>Rows <%=startResult%> - <%=endResult%>, Total Rows <%=totalRows%> </b>
                                                    </div>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                                    <%
                                            try {
                                                if (ps1 != null) {
                                                    ps1.close();
                                                }
                                                if (rs1 != null) {
                                                    rs1.close();
                                                }

                                                if (ps2 != null) {
                                                    ps2.close();
                                                }
                                                if (rs2 != null) {
                                                    rs2.close();
                                                }

                                                //if (connection2 != null) {
                                                //  connection2.close();
                                                //}
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }%>
                                    <div class="clear-fix"></div>


                                </div>
                            </div>

                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    <%=TRENDING_QUESTION%>
                                </div>
                                <div>
                                    <%
                                        String UserName_for_trending_question = null;
                                        try {
                                            String v_count = "SELECT * FROM question ORDER BY TotalLiked DESC limit 10";
                                            preparedStatement = connection.prepareStatement(v_count);
                                            resultSet = preparedStatement.executeQuery();
                                            while (resultSet.next()) {
                                                String TrendingQuestion = resultSet.getString("question");
                                                int questionID = resultSet.getInt("q_id");
                                    %>
                                    <a href="Answer.jsp?Id=<%=questionID%>&sl=<%=sl%>" ><%=TrendingQuestion%></a><br><br>
                                    <%
                                            }
                                        } catch (Exception e) {
                                            out.println("Error " + e);
                                        }
                                    %>
                                </div>
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
                            </div>
                            <div class="clear-fix"></div>
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


            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"><%=POST_YOUR_QUESTION_HERE%></h4>
                        </div>
                        <%if (session.getAttribute("email") != null) {%>
                        <form name="submitquestion" method="post" action="SubmitQuestion.jsp">
                            <div class="modal-body">
                                <div>
                                    <div><%=PUT_YOUR_QUESTION_HERE%></div>
                                    <%if (sl.equalsIgnoreCase("hi")) {%>
                                    <textarea type="text" class="anstext" id="text1" name="question" placeholder="<%=EX%>" required=""></textarea>
                                    <% } else {%>
                                    <textarea type="text" class="anstext" name="question" placeholder="<%=EX%>" required=""></textarea>
                                    <% }%>
                                </div>
                                <div class="margintop20">
                                    <div><%=TAG_SUGGESTION_DESCRIPTION%> </div>
                                    <textarea type="text" class="anstext" name="tag_of_question" placeholder="<%=TAG_EXMAPLE%>" required=""></textarea></div>
                                <!-- <p>Some text in the modal.</p> -->
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn"><%=POST%></button>
                                <button type="button" class="btn btn-default" data-dismiss="modal"><%=CLOSE%></button>
                            </div>
                        </form>
                        <%} else {%>
                        <div class="modal-body">
                            <div>
                                <div><h4 style="color: red;"><%=PLEASE_LOGIN_FIRST%>!!!</h4></div>
                                <div><a href="Login.jsp?sl=<%=sl%>"><%=CLICK_HERE_TO_LOGIN%></a></div>
                            </div>
                        </div>
                        <div class="modal-footer">                                                    
                            <button type="button" class="btn btn-default" data-dismiss="modal"><%=CLOSE%></button>
                        </div>

                        <% }%>

                    </div>

                </div>
            </div>


            <div class="modal fade" id="myModalN" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"><%=YOUR_CURRENT_NODIFICATION%></h4>
                        </div>
                        <div class="modal-body">
                            <div>
                                <jsp:include page="NodificationScript.jsp" />
                            </div>
                        </div>
                    </div>

                </div>
            </div>


            <script type="text/javascript" src="vendor/jquery-2.1.4.js"></script>
            <!-- Bootstrap JS -->
            <script type="text/javascript" src="vendor/bootstrap/bootstrap.min.js"></script>
            <!-- Bootstrap Select JS -->
            <script type="text/javascript" src="vendor/bootstrap-select/dist/js/bootstrap-select.js"></script>
        </div> <!-- /.main-page-wrapper -->

    </body>
</html>