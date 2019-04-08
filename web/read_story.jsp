<html lang="en">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%!
            String SUBJECT = "";
            String POSTED_BY = "";
            String DESCRIPTION = "";
            String COMPLETE_YOUR_PROFILE = "";
            String TRENDING_QUUESTION = "";
        %>
        <%
            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                SUBJECT = "विषय";
                POSTED_BY = "द्वारा प्रकाशित";
                DESCRIPTION = "विवरण";
                COMPLETE_YOUR_PROFILE = "अपनी प्रोफाइल पूरी कीजिए";
                TRENDING_QUUESTION = "ट्रेंडिंग सवाल";

            } else {
                SUBJECT = "Subject";
                POSTED_BY = "Posted by";
                DESCRIPTION = "Description";
                COMPLETE_YOUR_PROFILE = "Complete your profile";
                TRENDING_QUUESTION = "Trending question";
            }
        %>
        <%
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String str = request.getParameter("s_id");
            //String str = request.getParameter("id");
            if (str == null || str.length() <= 0) {
                response.sendRedirect("index.jsp?sl=" + sl);
            }
            String story_id = "";

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > 47 && str.charAt(i) < 58) {
                    story_id += str.charAt(i);
                }
            }

        %>

        <script src="ckeditor/ckeditor.js"></script>
        <meta charset="UTF-8">
        <!-- For IE -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- For Resposive Device -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- responsive style sheet -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-128307055-1"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());
            gtag('config', 'UA-128307055-1');
        </script> 
        <%@page language="java" %>
        <%@page import="java.sql.*" %> 
        <%@include file="site.jsp" %>
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
            String StoryTitle = "";
            String StoryDescription = "";
//            String FirstName = "";
//            String LastName = "";
//            int UserID = 0;
            if(story_id != null){
            try {
                //String p = "SELECT b.blog_subject, substring(b.blog,1,500),user.firstname,user.lastname,user.id FROM blog b right join newuser user on b.blog_posted_by = user.Id  WHERE blog_id = '" + Question + "'";
                String p = "select story_title,substring(story,1,500) from story where story_id = '" + story_id + "'";
                preparedStatement = connection.prepareStatement(p);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    StoryTitle = resultSet.getString("story_title");
                    StoryDescription = resultSet.getString("substring(story,1,500)");
//                    FirstName = resultSet.getString("firstname");
//                    LastName = resultSet.getString("lastname");
//                    UserID = resultSet.getInt("ID");
                }
            } catch (Exception e) {
                out.println("Unable to retrieve!!" + e);
            }
           }
        %>
        <title><%=StoryTitle%></title>
        <meta property="og:title" content="<%=StoryTitle%>" />
        <meta property="og:description" content="<%=StoryDescription%>"/>
        <meta property="og:url" content="https://www.inquiryhere.com/">
        <meta property="og:site_name" content="https://www.inquiryhere.com/" />
        <meta property="og:image" content="https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG" />
        <meta property="og:type" content="website">
        <meta property="og:locale" content="en_US">


    </head>

    <body>
        <div class="main-page-wrapper">


            <!-- Header _________________________________ -->
           <jsp:include page="header.jsp">
                <jsp:param name="sl" value="<%=sl%>"/>
            </jsp:include>
            <div class="clear-fix"></div>
            <div class="bodydata">
                <div class="container clear-fix">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

                            <div class="clear-fix"></div>

                            <div class="clear-fix"></div>

                            <div class="clear-fix"></div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

                            <div class="row">

                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                                    <div class="themeBox" style="height:auto;">

                                        <div class="boxHeading marginbot10">

<!--                                            <%=SUBJECT%> : -->
                                            <%=StoryTitle%> 
                                        </div>
                                    </div>
<!--                                    <div class="boxHeading marginbot10"><%=DESCRIPTION%></div>-->

                                    <%
                                        
                                        try {
                                            String p = "SELECT * FROM story WHERE story_id = '" + story_id + "'";
                                            preparedStatement = connection.prepareStatement(p);
                                            resultSet = preparedStatement.executeQuery();
                                            while (resultSet.next()) {
                                                String FullStoryDescription = resultSet.getString("story");
                                    %>
                                    <div class="themeBox" style="height:auto;">
                                        <div class="boxHeading marginbot10" style="font-size: 15px;font-family: Arial, Helvetica, sans-serif;">
                                            <%=FullStoryDescription%> 
                                        </div>

                                    </div>
                                   
                                    <div class="clear-fix"></div>

                                </div>
                            </div>

                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                           
                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                   Also Read
                                </div>
                                <div>
                                     <ul>
                                        <%
                                            String sql = "SELECT story_id as id,story_title as title FROM story LIMIT " + story_id + ",5";
                                            preparedStatement = connection.prepareStatement(sql);
                                            resultSet = preparedStatement.executeQuery();
                                            while (resultSet.next()) {
                                        %>
                                        <li>  <a href="read_story.jsp?story=<%=resultSet.getString("title").replaceAll(" ", "-")%>&s_id=<%=resultSet.getInt("id")%>"><%=resultSet.getString("title")%></a></li>
                                        <% }
                                        %>
                                    </ul>
                                </div>

                            </div>
                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    Fun Zone
                                </div>
                                <div>
                                    <jsp:include page="funZoneList.jsp"></jsp:include>
                                </div>

                            </div>
                            <div class="clear-fix"></div>
                            
                            <div class="themeBox" style="height:auto;">
                                <div class="boxHeading">
                                    Education Zone
                                </div>
                                <div>
                                    <jsp:include page="eduZoneList.jsp"></jsp:include>
                                </div>
                            </div>
                           
                        </div>
                        <div class="clear-fix"></div>
                    </div>
                    <div class="clear-fix"></div>
                </div>
                <div class="clear-fix"></div>
            </div>
                                 <%
                                            }

                                        } catch (Exception e) {
                                            out.println("Unable to retrieve!!" + e);
                                        } 
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
            <div class="clear-fix"></div>

            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                </div>
            </div>
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

    </body></html>