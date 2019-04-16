<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%@page language="java" %>
<%@page import="java.sql.*" %> 
<%@include file="validator.jsp"%>
<%@include file="site.jsp"%>
<%!
    String EMAIL = "";
    String PASSWORD = "";
    String HOME = "";
    String LOGIN = "";
    String SIGNUP = "";
    String SEARCH = "";
    String PROFILE = "";
    String CONTACT_US = "";
    String ABOUT_US = "";
    String LOGOUT = "";
    String SELECT = "";
%>
<%
    //String page_name = request.getParameter("page");
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
    if (sl.equalsIgnoreCase("hi")) {
        EMAIL = "ईमेल";
        PASSWORD = "पासवर्ड";
        HOME = "होम";
        LOGIN = "Login";
        SIGNUP = "नया खाता बनाएँ";
        SEARCH = "खोजे";
        PROFILE = "प्रोफ़ाइल";
        CONTACT_US = "हमसे संपर्क करें";
        ABOUT_US = "हमारे बारे में";
        LOGOUT = "बाहर जाये";
        SELECT = "चयन करें";

    } else {
        EMAIL = "Email";
        PASSWORD = "Password";
        HOME = "Home";
        LOGIN = "Login";
        SIGNUP = "SignUp";
        SEARCH = "Search";
        PROFILE = "Profile";
        CONTACT_US = "Contact Us";
        ABOUT_US = "About Us";
        LOGOUT = "Logout";
        SELECT = "Select";
    }
%>
<header class="home-page">
    <div class="container clear-fix">
        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="padding-left:0px;">
            <div class="logo float-left">
                <a href="index.jsp?sl=<%=sl%>" style="vertical-align:middle;">
                    <h4>
                        <div class="logotext">
                            Inquiryhere
                        </div>
                        <!-- <img src="images/logo/logo.png" style="width:150px;"> -->
                    </h4>
                </a></div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 serachhere" style="display:inline-block;">

            <div style="overflow: hidden; padding-right: .5em;">
                <form action="SearchBar.jsp">
                    <input type="hidden" name="sl" value="<%=sl%>">
                    <input type="text" style="width: 100%;" name="search" required="">
<!--                    <button type="submit" style="float: right;width: 50px;" /><%=SEARCH%></button>-->
                </form>
            </div>


        </div>


        <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12 float-right textalign-right">
            <%  if (sl.equalsIgnoreCase("hi")) {    %>
            <a href="index.jsp?sl=en" class="helpicon"  style="color: white;padding-left: 10px;padding-right: 40px;">English</a>
            <% } else { %>
            <a href="index.jsp?sl=hi" class="helpicon"  style="color: white;padding-left: 10px;padding-right: 30px;">हिन्दी</a>
            <% } %>
             <% if (session.getAttribute("email") != null) {%> 
            <a href="#" data-toggle="modal" class="helpicon" data-target="#myModalN" style="color: white;padding-left: 10px;padding-right: 10px;">
<!--                <span></span>--> Inbox
<!--                <span class="badge">0</span>-->
            </a> 
            <% }%>
            
            <a href="help.jsp?sl=<%=sl%>" class="helpicon"  style="color: white;padding-left: 10px;padding-right: 10px;">Help</a>
            <a href="index.jsp?sl=<%=sl%>" class="helpicon" style="color: white;padding-left: 10px;padding-right: 30px;"><%=HOME%></a>
            
            <%if (session.getAttribute("email") == null) {%>
            <a href="Login.jsp?sl=<%=sl%>" class="helpicon" style="color: white;padding-left: 10px;padding-right: 30px;"><%=LOGIN%></a>
            <a href="signup.jsp?sl=<%=sl%>" class="helpicon"  style="color: white;padding-left: 10px;padding-right: 30px;">SIgnUp</a>
            <% } else {
               // String DB_URL = "jdbc:mysql://localhost/bharat";
               // String DB_USERNAME = "root";
               // String DB_PASSWORD = null;

                Statement stmt;
                Connection con;
                ResultSet rs;
                String fullName = null;
                String email = (String) session.getAttribute("email");
                int id_of_user = 0;

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
                    stmt = con.createStatement();
                    String p = "SELECT * FROM newuser WHERE email = '" + email + "'";
                    rs = stmt.executeQuery(p);
                    while (rs.next()) {
                        id_of_user = rs.getInt("id");
                        fullName = rs.getString("firstname");
                    } 
                    stmt.close();
                    con.close();
                    rs.close();
                } catch (Exception e) {
                    out.println("Unable to retrieve!!" + e);
                }
            %>
            <a href="Logout.jsp?sl=<%=sl%>" class="helpicon" style="color: white;padding-left: 10px;padding-right: 30px;">Logout</a>
            <a href="profile.jsp?user=<%=fullName.replaceAll(" ", "+")%>&ID=<%=id_of_user%>&sl=<%=sl%>" class="helpicon" style="color: white;padding-left: 10px;padding-right: 30px;"><b><%=firstName(fullName)%></b></a>
            <%
                }%>            
            
    </div>

    </div>
</header>