<html lang="en">
    <head>

        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%@page import="java.sql.*"%>
        <%@include file="site.jsp" %>
        <!--            <script>
                    // This is called with the results from from FB.getLoginStatus().
                    function statusChangeCallback(response) {
                        console.log('statusChangeCallback');
                        console.log(response);
                        // The response object is returned with a status field that lets the
                        // app know the current login status of the person.
                        // Full docs on the response object can be found in the documentation
                        // for FB.getLoginStatus().
                        if (response.status === 'connected') {
                            // Logged into your app and Facebook.
                            testAPI();
                        } else {
                            // The person is not logged into your app or we are unable to tell.
                           // document.getElementById('status').innerHTML = 'Please log ' +  'into this app.';
                        }
                    }
        
                    // This function is called when someone finishes with the Login
                    // Button.  See the onlogin handler attached to it in the sample
                    // code below.
                    function checkLoginState() {
                        FB.getLoginStatus(function (response) {
                            statusChangeCallback(response);
                            
                        });
                    }
                    
        
                    window.fbAsyncInit = function () {
                        FB.init({
                            appId: '355720661657906',
                            cookie: true, // enable cookies to allow the server to access 
                            // the session
                            xfbml: true, // parse social plugins on this page
                            version: 'v3.2' // The Graph API version to use for the call
                        });
        
                        // Now that we've initialized the JavaScript SDK, we call 
                        // FB.getLoginStatus().  This function gets the state of the
                        // person visiting this page and can return one of three states to
                        // the callback you provide.  They can be:
                        //
                        // 1. Logged into your app ('connected')
                        // 2. Logged into Facebook, but not your app ('not_authorized')
                        // 3. Not logged into Facebook and can't tell if they are logged into
                        //    your app or not.
                        //
                        // These three cases are handled in the callback function.
        
                        FB.getLoginStatus(function (response) {
                            statusChangeCallback(response);
                            //window.top.location = "w.foo.com";
                        });
        
                    };
        
                    // Load the SDK asynchronously
                    (function (d, s, id) {
                        var js, fjs = d.getElementsByTagName(s)[0];
                        if (d.getElementById(id))
                            return;
                        js = d.createElement(s);
                        js.id = id;
                        js.src = "https://connect.facebook.net/en_US/sdk.js";
                        fjs.parentNode.insertBefore(js, fjs);
                    }(document, 'script', 'facebook-jssdk'));
        
                    // Here we run a very simple test of the Graph API after login is
                    // successful.  See statusChangeCallback() for when this call is made.
                    function testAPI() {
                        console.log('Welcome!  Fetching your information.... ');
                        FB.api('/me?fields=name,email', function (response) {
                            console.log('Successful login for: ' + response.name);
                            window.location.replace('FBvalidation.jsp?fullname='+response.name.replace(" ", "_")+'&email='+response.email);
                            //window.location.replace('FBvalidation.jsp?fullname=' + response.name.replace(" ", "_") + '&email=' + response.email');
                            //document.getElementById('status').innerHTML = '<a href=FBvalidation.jsp?fullname=' + response.name.replace(" ", "_") + '&email=' + response.email + '>Continue as ' + response.name + ' </a>';
                        });
                    }
                </script>-->
        <meta charset="UTF-8">
        <%
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        %>
        <%!            String EMAIL = "";
            String PASSWORD = "";
            String HOME = "";
            String LOGIN = "";
            String SIGNUP = "";
            String SEARCH = "";
            String FORGET_PASSWORD = "";

            String MEG_FROM_VALIDATION_PAGE = "";
            String MEG_FROM_LOGOUT_PAGE = "";
            String MEG_FROM_SUBMITANS_PAGE = "";
        %>
        <%
            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                EMAIL = "ईमेल";
                PASSWORD = "पासवर्ड";
                HOME = "होम";
                LOGIN = "लॉग इन करें";
                SIGNUP = "नया खाता बनाएँ";
                SEARCH = "खोजे";
                FORGET_PASSWORD = "पासवर्ड भूल गए";

                MEG_FROM_VALIDATION_PAGE = "यूजरनाम और पासवर्ड गलत है";
                MEG_FROM_LOGOUT_PAGE = "हमारी सेवा का उपयोग करने के लिए धन्यवाद।  कृपया फिर आइएगा";
                MEG_FROM_SUBMITANS_PAGE = "कृप्या पहले login करे";
            } else {
                EMAIL = "Email";
                PASSWORD = "Password";
                HOME = "Home";
                LOGIN = "Login";
                SIGNUP = "SignUp";
                SEARCH = "Search";
                FORGET_PASSWORD = "Forget Password";

                MEG_FROM_VALIDATION_PAGE = "Invalid UserName or PassWord";
                MEG_FROM_LOGOUT_PAGE = "Thanks for using our service. Please visit again";
                MEG_FROM_SUBMITANS_PAGE = "Please Login First";
            }
        %>
        <%!    public boolean validateUser(String username, String password) {
                boolean found = false;
                try {
                    String cookiesMail = username;
                    String cookiesPassword = password;

                    Connection connection = null;
                    ResultSet resultSet = null;
                    PreparedStatement preparedStatement = null;

                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);

                    String password1;
                    try {

                        String v = "SELECT ID,email,password FROM newuser WHERE email = ?";

                        preparedStatement = connection.prepareStatement(v);
                        preparedStatement.setString(1, cookiesMail);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            password1 = resultSet.getString("password");
                            if (cookiesPassword.equals(password1)) {
                                found = true;
                            }
                        }
                    } catch (Exception e) {
                        //  out.println("Error in main try block:-" + e);
                    }
                } catch (Exception msg) {

                }
                return found;
            }
        %>
        <%
            String username = "";
            String password = "";
            if (session.getAttribute("email") != null) {
                response.sendRedirect("index.jsp?sl=" + sl);
            } else {
                Cookie[] cookies = request.getCookies();

                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        Cookie cookie = cookies[i];
                        if (cookie.getName().equals("username-cookie")) {
                            username = cookie.getValue();
                        } else if (cookie.getName().equals("password-cookie")) {
                            password = cookie.getValue();
                        }
                    }
                }
                if (username != "" && password != "") {
                    boolean found = validateUser(username, password);
                    if (found) {
        %>
        <jsp:forward page="validate.jsp">
            <jsp:param name="email" value="<%=username%>"/>
            <jsp:param name="password" value="<%=password%>"/>
        </jsp:forward>
        <%
                    }
                }
            }
        %>
        <!-- For IE -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- For Resposive Device -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Login | InquiryHere.com</title>

        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- responsive style sheet -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <style>
            input[type=text] {
                width: 100%;
                padding: 4px 8px;
                margin: 4px 0;
                box-sizing: border-box;
                border: 1px solid #b3b3b3;
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
    </head>
    <body>
        <%
//out.println(username+password);
%>
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
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 serachhere" style="display:inline-block;">

                                        <div style="overflow: hidden; padding-right: .5em;">
                                            <form action="SearchBar.jsp">
                                                <div class="col-md-9">
                                                    <input type="text" style="width: 100%;"  name="search" required="" >
                                                    <input type="hidden" name="sl" value="<%=sl%>">
                                                </div>
                                                <!--                                                <div class="col-md-3">
                                                                                                    <button type="submit"  /><%=SEARCH%></button>
                                                                                                </div>-->
                                            </form>
                                        </div>


                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12 float-right textalign-right">
                                        <a href="index.jsp?sl=<%=sl%>" class="helpicon" style="color: white;padding-left: 10px;padding-right: 30px;"><%=HOME%></a>
                                        <a  href="signup.jsp?sl=<%=sl%>" class="helpicon" style="color: white;padding-left: 10px;padding-right: 30px;"><%=SIGNUP%></a>
                                        <%  if (sl.equalsIgnoreCase("hi")) {%>
                                        <a  href="Login.jsp" class="helpicon" style="color: white;padding-left: 10px;padding-right: 30px;">English</a>
                                        <%  } else {
                                        %>
                                        <a  href="Login.jsp?sl=hi" class="helpicon" style="color: white;padding-left: 10px;padding-right: 30px;">हिन्दी</a>
                                        <%}%>

                                    </div>



                                    </div>

                                    </header>
                                    <div class="clear-fix"></div>
                                    <div class="bodydata">
                                        <div class="container clear-fix">
                                            <div class="row">
                                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

                                                </div>

                                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                                    <div class="row"><center>
                                                            <%
                                                                String ErrorMsg = request.getParameter("msg");
                                                                if (ErrorMsg != null) {
                                                                    if (ErrorMsg.equalsIgnoreCase("valid")) {
                                                                        out.println("<center><b style=color:red;>" + MEG_FROM_VALIDATION_PAGE + "</b></center>");
                                                                    }
                                                                    if (ErrorMsg.equalsIgnoreCase("logout")) {
                                                                        out.println("<center><b style=color:red;>" + MEG_FROM_LOGOUT_PAGE + "</b></center>");
                                                                    }
                                                                    if (ErrorMsg.equalsIgnoreCase("submitAns")) {
                                                                        out.println("<center><b style=color:red;>" + MEG_FROM_SUBMITANS_PAGE + "</b></center>");
                                                                    }
                                                                    // out.println("<center><b style=color:red;>" + ErrorMsg + "</b></center>");
                                                                }
                                                            %>

                                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                                <!--div id="fb-root"></div>
                                                            <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v3.3&appId=355720661657906&autoLogAppEvents=1"></script>

                                                            <div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-auto-logout-link="false" data-use-continue-as="false"></div>

                                                            <div id="status"-->
                                                            </div>
                                                            <div class="themeBox" style="height:300px;">
                                                                <form action="validate.jsp" method="post" name="">
                                                                    <% if (request.getParameter("URL") != null) {%>
                                                                    <input type="hidden" name="URL" value="<%=request.getParameter("URL")%>">

                                                                    <input type="hidden" name="ans" value="<%=request.getParameter("ans")%>">

                                                                    <input type="hidden" name="Id" value="<%=request.getParameter("Id")%>">
                                                                    
                                                                    <input type="hidden" name="ID" value="<%=request.getParameter("ID")%>">
                                                                    <% }%> 
                                                                    <input type="hidden" name="sl" value="<%=sl%>">

                                                                    <label for="fname"><%=EMAIL%></label>
                                                                    <div class="boxHeading">
                                                                        <input type="text"  name="email" required="" value="<%=username%>">
                                                                    </div>
                                                                    <label for="lname"><%=PASSWORD%></label>
                                                                    <div class="boxHeading">
                                                                        <input type="password"  name="password" required="" value="<%=password%>">
                                                                    </div> 
                                                                    <br>
                                                                    <button type="submit" class="button button1" data-toggle="modal"   ><%=LOGIN%></button>
                                                                </form>

                                                                <form action="ForgotPassword.jsp">
                                                                    <input type="hidden" name="sl" value="<%=sl%>">
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