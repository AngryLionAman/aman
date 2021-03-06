<html lang="en">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%@include file="site.jsp" %>
        <%!
            String LOGIN = "";
            String SEARCH = "";
            String HOME = "";
            String FIRST_NAME = "";
            String LAST_NAME = "";
            String EMAIL = "";
            String PASSWORD = "";
            String CREATE_ACCOUNT = "";
            String FORGET_PASSWORD = "";

        %>
        <%
            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                LOGIN = "लॉग इन करें";
                SEARCH = "खोजे";
                HOME = "होम";
                FIRST_NAME = "पूरा नाम";
                LAST_NAME = "उपनाम";
                EMAIL = "ईमेल/Phone";
                PASSWORD = "नया पासवर्ड";
                CREATE_ACCOUNT = "खाता बनाएं";
                FORGET_PASSWORD = "पासवर्ड भूल गए";

            } else {
                LOGIN = "Login";
                SEARCH = "Search";
                HOME = "Home";
                FIRST_NAME = "Full Name";
                LAST_NAME = "Last Name";
                EMAIL = "Email/Phone";
                PASSWORD = "New Password";
                CREATE_ACCOUNT = "Create Account";
                FORGET_PASSWORD = "Forgot Password";
            }
        %>
        <%
            if (session.getAttribute("email") != null) {
                response.sendRedirect("index.jsp?sl=" + sl);
            }
        %>
        <meta charset="UTF-8">
        <!-- For IE -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- For Resposive Device -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>SignUp | InquiryHere.com</title>

        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- responsive style sheet -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <style>
            input[type=text] {
                width: 100%;
                padding: 4px 8px;
                margin: 4px 0;
                box-sizing: border-box;
                border: 1px solid red;
                border-radius: 2px;
            }
            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }
            .button1 {width: 250px;}
        </style>
        <script language="Javascript" type="text/javascript">

            function onlyAlphabets(e, t) {
                try {
                    if (window.event) {
                        var charCode = window.event.keyCode;
                    } else if (e) {
                        var charCode = e.which;
                    } else {
                        return true;
                    }
                    if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) || (charCode === 32))
                        return true;
                    else
                        return false;
                } catch (err) {
                    alert(err.Description);
                }
            }
            function userNameValidation(e, t) {
                try {
                    if (window.event) {
                        var charCode = window.event.keyCode;
                    } else if (e) {
                        var charCode = e.which;
                    } else {
                        return true;
                    }
                    if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) || (charCode > 47 && charCode < 58))
                        return true;
                    else
                        return false;
                } catch (err) {
                    alert(err.Description);
                }
            }

        </script>
            <script type="text/javascript">
            function take_value(email) {
                //alert(email.value);
                var http = new XMLHttpRequest();
                http.open("post", "<%=DB_AJAX_PATH%>/validateUserName.jsp?userName=" + email.value, true);
                http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                http.send();
                http.onload = function () {
                    http.responseText;
                    document.getElementById("demo").innerHTML = http.responseText;
                };
            }
        </script>
    </head>
    <body>
        <div class="main-page-wrapper">
            <header class="home-page">
                <div class="container clear-fix">
                    <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="padding-left:0px;">
                        <div class="logo float-left">
                            <a href="#" style="vertical-align:middle;">
                                <h4>
                                    <div class="logotext">
                                        Inquiryhere.com
                                        <div>

                                            </h4>
                                            </a></div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 serachhere" style="display:inline-block;">

                                        <div style="overflow: hidden; padding-right: .5em;">
                                            <form action="SearchBar.jsp">
                                                <input type="hidden" name="sl" value="<%=sl%>">
                                                <input type="text" style="width: 100%;" name="search" required="" >
<!--                                                <button type="submit" style="float: right;width: 50px;" /><%=SEARCH%></button>-->
                                            </form>
                                        </div>


                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12 float-right textalign-right">
                                        <a  href="index.jsp?sl=<%=sl%>" class="helpicon" style="color: white; width: 50px;"><%=HOME%></a>
                                        <a  href="Login.jsp?sl=<%=sl%>" class="helpicon" style="color: white; width: 50px;"><%=LOGIN%></a>

                                    </div>



                                    </div>

                                    </header>
                                    <div class="clear-fix"></div>
                                    <div class="bodydata">
                                        <div class="container clear-fix">
                                            <div class="row">
                                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

                                                </div>

                                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" align="center">                                                   
                                                    <div class="row">                                                     
                                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                            <div class="themeBox" style="height:470px;">
                                                                <%
                                                                    String ErrorMsg = request.getParameter("Error");
                                                                    if (ErrorMsg != null) {
                                                                        out.println("<center><b style=color:red;>" + ErrorMsg + "</b></center>");
                                                                    }
                                                                %>
                                                                <form action="NewUser.jsp" method="post" name="newUser">
                                                                    <input type="hidden" name="sl" value="<%=sl%>">

                                                                    <label for="fname"><%=FIRST_NAME%></label>
                                                                    <div class="boxHeading">
                                                                        <input type="text" id="fname" name="firstname" onkeypress="return onlyAlphabets(event, this);" required="">
                                                                        
                                                                    <!--/div><p id="demo"></p>
                                                                    <label for="userName">UserName</label>
                                                                    <div class="boxHeading">
                                                                        <input type="text" id="fname" name="userName" onkeypress="return userNameValidation(event, this);" onkeyup="return take_value(this);" required="">
                                                                    </div-->
                                                                    <label for="fname"><%=EMAIL%></label>
                                                                    <div class="boxHeading">
                                                                        <input type="text"  name="email" required="">
                                                                    </div>
                                                                    <label for="lname"><%=PASSWORD%></label>
                                                                    <div class="boxHeading">
                                                                        <input type="password"  name="password" pattern=".{6,}" title="Six or more characters" required="">
                                                                    </div> 
                                                                    <br>
                                                                    <button type="submit" class="button button1" data-toggle="modal"  ><%=CREATE_ACCOUNT%></button>
                                                                </form>
                                                                <form action="ForgotPassword.jsp?sl=<%=sl%>" method="post" name="forgetPassword">
                                                                    <button class="button button1" style="background-color: red;"><%=FORGET_PASSWORD%></button>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="clear-fix"></div>
                                                </div>
                                                <div class="clear-fix"></div>
                                            </div>
                                            <div class="clear-fix"></div>
                                        </div>
                                        <div class="clear-fix"></div>

                                        <jsp:include page="footer.jsp">
                                            <jsp:param name="sl" value="<%=sl%>"/>
                                        </jsp:include>
                                        <script type="text/javascript" src="vendor/jquery-2.1.4.js"></script>
                                        <!-- Bootstrap JS -->
                                        <script type="text/javascript" src="vendor/bootstrap/bootstrap.min.js"></script>
                                        <!-- Bootstrap Select JS -->
                                        <script type="text/javascript" src="vendor/bootstrap-select/dist/js/bootstrap-select.js"></script>

                                    </div> 
                                    </body></html>