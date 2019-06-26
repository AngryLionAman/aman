package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public String firstName(String str) {
        try {
            if (str != null && str.length() > 0 && !(str.trim()).equals("null") && !str.equals("") && !str.equals(" ")) {

                String[] final_word = str.split("\\s");
                return final_word[0].substring(0, 1).toUpperCase() + final_word[0].substring(1).toLowerCase();
            } else {
                return null;
            }

        } catch (Exception msg) {
            return msg.toString();
        }
    }


    public String convertStringUpperToLower(String sentence) {
        String finalSentenct = "";
        try {
            //To remove white space before word start, if having
            while (true) {
                if (sentence.charAt(0) == 32) {
                    sentence = sentence.substring(1);
                } else {
                    break;
                }
            }
            //To remove white space at the end of the sentence, if having
            while (true) {
                if (sentence.charAt(sentence.length() - 1) == 32) {
                    sentence = sentence.substring(0, sentence.length() - 1);
                } else {
                    break;
                }
            }
            //If sentence having the multiple space
            //To remive the middle sentence white space if having
            //This can also remove the pre word and post word white spaces but
            // removies the last char of the sentence
            char[] c = sentence.toCharArray();
            String str1 = "";
            //If you don't use the '=' (equals) then will missed the last char
            for (int i = 0; i < sentence.length(); i++) {
                if ((c[i] == ' ' && c[i + 1] != ' ') || (c[i] != ' ')) {
                    str1 += c[i];
                }
            }
            //Splitin the sentence into words
            String[] word = str1.split(" ");
            //Captlizing the every word
            for (int i = 0; i < word.length; i++) {
                word[i] = word[i].substring(0, 1).toUpperCase() + word[i].substring(1).toLowerCase();
                finalSentenct += word[i] + " ";
            }

//Remove the last white space if having
//in my case , last char is defenetaly has a white space,just look at the two line up
            while (true) {
                if (finalSentenct.charAt(finalSentenct.length() - 1) == 32) {
                    finalSentenct = finalSentenct.substring(0, finalSentenct.length() - 1);
                } else {
                    break;
                }
            }
//end of the script
        } catch (Exception msg) {
            finalSentenct = msg.toString();
        }
        return finalSentenct;
    }

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

    public String nullStringconvert(String category) {
        String cat = "All";

        if (category == null) {
            category = "All";
        } else if ((category.trim()).equals("null")) {
            category = "All";
        } else if (category.equals("")) {
            category = "All";
        }
        cat = category;
        return cat;
    }


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/validator.jsp");
    _jspx_dependants.add("/site.jsp");
    _jspx_dependants.add("/notificationhtml.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head> \r\n");
      out.write("        \r\n");
      out.write("        <link rel=\"icon\" href=\"https://www.inquiryhere.com/images/inquiryhere_Logo.PNG\" type=\"image/png\">\r\n");
      out.write("       \r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        \r\n");
      out.write("         \r\n");
      out.write("        ");
      out.write('\n');
      out.write('\n');
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

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
            String PROFILE_DETAILS = "";
            String UPDATE_YOUR_PROFILE_IMAGE = "";
            String NAME = "";
            String MAIL_ID = "";
            String HIGHER_QUALIFICATION = "";
            String BEST_ACHIEVEMENT = "";
            String BIO = "";
            String COMPLETE_YOUR_PROFILE = "";
            String YOUR_ACTIVITY = "";
            String QUESTION = "";
            String ANSWER = "";
            String TOPIC_FOLLOWED = "";
            String FOLLOWING = "";
            String FOLLOWERS = "";
            String BLOG = "";
            String QUOTES = "";
            String ADD_MORE_QUESTION = "";
            String FOLLOW_MORE_TOPIC = "";
            String NOT_FOLLOWING_ANY_USER = "";
            String FOLLOW_MORE_USER = "";
            String NO_BLOG_POSTED_YET = "";
            String BLOG_ABOUT_SOMETHING = "";
            String NO_QUESTES_POSTED_YET = "";
            String ADD_MORE_QUOTES = "";
            String NOT_FOLLOWED_BY_ANY_USER = "";
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
            String POST = "";
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");

            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            } else {

            }
            if (sl.equalsIgnoreCase("hi")) {
                EMAIL = "ईमेल";
                PASSWORD = "पासवर्ड";
                HOME = "होम";
                LOGIN = "लॉग इन करें";
                SIGNUP = "नया खाता बनाएँ";
                SEARCH = "खोजे";
                PROFILE = "प्रोफ़ाइल";
                CONTACT_US = "हमसे संपर्क करें";
                ABOUT_US = "हमारे बारे में";
                LOGOUT = "बाहर जाये";
                SELECT = "चयन करें";
                PROFILE_DETAILS = "प्रोफ़ाइल का विवरण";
                UPDATE_YOUR_PROFILE_IMAGE = "अपनी प्रोफ़ाइल छवि को अपडेट करें";
                NAME = "नाम";
                MAIL_ID = "ईमेल आईडी";
                HIGHER_QUALIFICATION = "उच्च योग्यता";
                BEST_ACHIEVEMENT = "सबसे अच्छी उपलब्धि";
                BIO = "आपके बारे में";
                COMPLETE_YOUR_PROFILE = "अपनी प्रोफाइल पूरी कीजिए";
                YOUR_ACTIVITY = "आपकी गतिविधि";
                QUESTION = "प्रशन";
                ANSWER = "उत्तर";
                TOPIC_FOLLOWED = "विषय का पालन किया";
                FOLLOWING = "आपने जिसको अनुशरण किया";
                FOLLOWERS = "अनुसरण करने वाले शिष्य";
                BLOG = "ब्लॉग";
                QUOTES = "उल्लेख";
                ADD_MORE_QUESTION = "एक और सवाल जोड़ें";
                FOLLOW_MORE_TOPIC = "अधिक विषय का पालन करें";
                NOT_FOLLOWING_ANY_USER = "किसी भी उपयोगकर्ता का अनुसरण नहीं कर रहे है";
                FOLLOW_MORE_USER = "अधिक उपयोगकर्ता का पालन करें";
                NO_BLOG_POSTED_YET = "अभी तक कोई ब्लॉग पोस्ट नहीं किया गया";
                BLOG_ABOUT_SOMETHING = "किसी चीज के बारे में ब्लॉग";
                NO_QUESTES_POSTED_YET = "अभी तक कोई उद्धरण पोस्ट नहीं किया गया है";
                ADD_MORE_QUOTES = "अधिक उद्धरण जोड़ें";
                NOT_FOLLOWED_BY_ANY_USER = "किसी भी उपयोगकर्ता द्वारा पीछा नहीं किया गया";
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
                POST = "post";

            } else {
                EMAIL = "Email";
                PASSWORD = "Password";
                HOME = "Home";
                LOGIN = "Login";
                SIGNUP = "SignUp";
                SEARCH = "Search";
                PROFILE = "Profile";
                CONTACT_US = "contact Us";
                ABOUT_US = "About Us";
                LOGOUT = "Logout";
                SELECT = "Select";
                PROFILE_DETAILS = "Profile Details ";
                UPDATE_YOUR_PROFILE_IMAGE = "Update your profile image";
                NAME = "Name ";
                MAIL_ID = "Mail Id ";
                HIGHER_QUALIFICATION = "Higher Qualification ";
                BEST_ACHIEVEMENT = "Best Achievement";
                BIO = "Bio ";
                COMPLETE_YOUR_PROFILE = "Complete your profile";
                YOUR_ACTIVITY = "User Activity ";
                QUESTION = "Question";
                ANSWER = "Answer";
                TOPIC_FOLLOWED = "Topic Followed";
                FOLLOWING = "Following";
                FOLLOWERS = "Followers";
                BLOG = "Blog";
                QUOTES = "Quotes";
                ADD_MORE_QUESTION = "Add more question";
                FOLLOW_MORE_TOPIC = "Follow more topic";
                NOT_FOLLOWING_ANY_USER = "Not following any user";
                FOLLOW_MORE_USER = "Follow More User";
                NO_BLOG_POSTED_YET = "No blog posted yet";
                BLOG_ABOUT_SOMETHING = "Blog about something";
                NO_QUESTES_POSTED_YET = "No quotes posted yet";
                ADD_MORE_QUOTES = "Add more quotes";
                NOT_FOLLOWED_BY_ANY_USER = "Not followed by any user";
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
                POST = "post";
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            function showCommentBox() {\r\n");
      out.write("            ");
 if (session.getAttribute("Session_id_of_user") != null) { 
      out.write("\r\n");
      out.write("                var div = document.getElementById('comment');\r\n");
      out.write("                div.className = 'visible';\r\n");
      out.write("            ");
 } else { 
      out.write("alert(\"Please login first to comment\");\r\n");
      out.write("            ");
  }  
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <title>Profile | InquiryHere.com</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <meta property=\"og:url\" content=\"https://www.inquiryhere.com/\" />\r\n");
      out.write("        <meta property=\"og:title\" content=\"Explore the world with your knowladge\" />\r\n");
      out.write("        <meta property=\"og:description\" content=\"Explore the world with your knowladge. inquiryhere.com\" />\r\n");
      out.write("        <meta property=\"og:type\" content=\"website\">\r\n");
      out.write("        <meta property=\"og:locale\" content=\"en_US\">\r\n");
      out.write("        <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-128307055-1\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("                window.dataLayer = window.dataLayer || [];\r\n");
      out.write("                function gtag() {\r\n");
      out.write("                    dataLayer.push(arguments);\r\n");
      out.write("                }\r\n");
      out.write("                gtag('js', new Date());\r\n");
      out.write("\r\n");
      out.write("                gtag('config', 'UA-128307055-1');\r\n");
      out.write("        </script> \r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            function take_value(el, user_id, id_of_user) {\r\n");
      out.write("            ");
 if (session.getAttribute("email") == null) { 
      out.write("\r\n");
      out.write("                alert(\"Please login first\");");

                } else {
      out.write("\r\n");
      out.write("                if (el.value === \"follow\") {\r\n");
      out.write("                    el.value = \"followed\";\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_follower_detail.jsp?val_topic=\" + user_id + \"&val2_topic=\" + id_of_user + \"&action=follow\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                } else {\r\n");
      out.write("                    el.value = \"follow\";\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_follower_detail.jsp?val_topic=\" + user_id + \"&val2_topic=\" + id_of_user + \"&action=delete\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                }\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            function hide_mail(el, session_id_of_user, action) {\r\n");
      out.write("            ");
 if (session.getAttribute("email") == null) { 
      out.write("\r\n");
      out.write("                alert(\"Please login first\");");

                } else {
      out.write("\r\n");
      out.write("\r\n");
      out.write("                var http = new XMLHttpRequest();\r\n");
      out.write("                http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/mail_serurity.jsp?session_id_of_user=\" + session_id_of_user + \"&action=\" + action, true);\r\n");
      out.write("                http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                http.send();\r\n");
      out.write("\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Header _________________________________ -->\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            <div class=\"bodydata\">\r\n");
      out.write("                <div class=\"container clear-fix\">\r\n");
      out.write("                    ");


                        String email = null;
                        int session_id_of_user = 0;
                        if (session.getAttribute("email") != null) {
                            email = (String) session.getAttribute("email");
                        }

                        if (session.getAttribute("Session_id_of_user") != null) {
                            session_id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                        }
                    
      out.write("\r\n");
      out.write("                    ");

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
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");

                        //String ID = request.getParameter("ID");
                        String str = request.getParameter("ID");
                        String userName = null;

                        String ID = "";
                        if (str == null) {
                            if (request.getParameter("user") != null) {
                                userName = request.getParameter("user");;
                            } else if (session.getAttribute("Session_id_of_user") != null) {//if user trying to access this page directly without login
                                ID = String.valueOf(session.getAttribute("Session_id_of_user"));//We can directly convert object to string 
                                //or you cast the object into integer and then cast to String
                            } else {
                                response.sendRedirect("UserProfile.jsp?sl=" + sl);
                            }
                        } else {
                            for (int i = 0; i < str.length(); i++) {
                                if (str.charAt(i) > 47 && str.charAt(i) < 58) {
                                    ID += str.charAt(i);
                                }
                            }
                        }
                    
      out.write("\r\n");
      out.write("                    ");

                        String fullName = null;
                        String higher_colification = null;
                        String bio = null;
                        String mail = null;
                        String BestAchievement = null;
                        String ImagePath = null;
                        int id_of_user = 0;
                        int topic_id = 0;
                        int email_status = 0;
                        int TotalView = 0;
                        boolean userNotFound = true;
                        String p = null;
                        try {

                            if (ID != null && ID.length() > 0) {
                                p = "SELECT * FROM newuser WHERE ID = '" + ID + "'";
                            } else {
                                p = "SELECT * FROM newuser WHERE username = '" + userName + "'";
                            }
                            preparedStatement = connection.prepareStatement(p);
                            resultSet = preparedStatement.executeQuery();
                            while (resultSet.next()) {
                                userNotFound = false;
                                id_of_user = resultSet.getInt("id");
                                try {
                                    PreparedStatement ps1 = null;
                                    String countView = "UPDATE newuser SET total_view = total_view + 1 WHERE ID =? ";
                                    ps1 = connection.prepareStatement(countView);
                                    ps1.setInt(1, id_of_user);
                                    ps1.executeUpdate();
                                    ps1.close();

                                } catch (Exception msg) {
                                    out.println("Error in cound the view" + msg);
                                }
                                ID = resultSet.getString("id");
                                fullName = resultSet.getString("firstname");
                                userName = resultSet.getString("username");
                                mail = resultSet.getString("email");
                                higher_colification = resultSet.getString("higher_edu");
                                bio = resultSet.getString("bio");
                                BestAchievement = resultSet.getString("best_achievement");
                                ImagePath = resultSet.getString("imagepath");
                                email_status = resultSet.getInt("email_s");
                                TotalView = (resultSet.getInt("total_view") + 1) ;
                            }
                        } catch (Exception e) {
                            out.println("Unable to retrieve!!" + e);
                        }
                        if (userNotFound) {
                            response.sendRedirect("UserProfile.jsp");
                        }
                    
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-lg-9 col-md-9 col-sm-12 col-xs-12\">\r\n");
      out.write("                            <div class=\"themeBox\" style=\"min-height:1px;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    ");
      out.print(PROFILE_DETAILS);
      out.write("[ View(");
      out.print(TotalView);
      out.write(") ]\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\r\n");
      out.write("                                    <img src=\"images/");
      out.print(ImagePath);
      out.write("\" alt=\"Image\" style=\"width:90%; margin:10px 0px 0px; border:1px solid #ddd;\">\r\n");
      out.write("                                    ");

                                        try {
                                            if (session.getAttribute("email") != null) {
                                                if (mail.equals(session.getAttribute("email"))) {
                                                    out.println("<a href=UpdateUserProfile.jsp?sl=" + sl + ">" + UPDATE_YOUR_PROFILE_IMAGE + "</a>");
                                                }
                                            }
                                        } catch (Exception msg) {
                                            out.println("Error in Mail session:" + msg);
                                        }
                                        if (session.getAttribute("email") != null) {
                                            if (session_id_of_user != id_of_user) { //If user watching there own profile they will not get the follow button
                                                int StoredUserId;
                                                //int user_id = 0;
                                                String Status = null;
                                                try {
                                                    String v_follow = "SELECT * FROM ak_follower_detail where followers_id ='" + session_id_of_user + "'";
                                                    preparedStatement = connection.prepareStatement(v_follow);
                                                    resultSet = preparedStatement.executeQuery();
                                                    while (resultSet.next()) {
                                                        StoredUserId = resultSet.getInt("user_id");
                                                        if (StoredUserId == id_of_user) {
                                                            Status = "present";
                                                        }
                                                    }
                                                    if (Status == "present") {
                                    
      out.write("<input type=\"button\" class=\"float-right\" value=\"UnFollow\" id=\"myButton1\" onclick=\"return take_value(this, '");
      out.print(id_of_user);
      out.write("', '");
      out.print(session_id_of_user);
      out.write("');\" />");

                                    } else {
      out.write("\r\n");
      out.write("                                    <input type=\"button\" class=\"float-right\" value=\"follow\" id=\"myButton1\" onclick=\"return take_value(this, '");
      out.print(id_of_user);
      out.write("', '");
      out.print(session_id_of_user);
      out.write("');\" />\r\n");
      out.write("                                    ");

                                                    }
                                                    Status = null;
                                                } catch (Exception e) {
                                                    out.println(e.getMessage());
                                                }
                                            }
                                        } else {
                                            out.println("<a href=Login.jsp?sl=" + sl + "><button>Please Login to Follow</button></a>");//if session is not Active
                                        }
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-lg-8 col-md-8 col-sm-12 col-xs-12\">\r\n");
      out.write("                                    <table class=\"profiledetails\">\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>");
      out.print(NAME);
      out.write(" </td>\r\n");
      out.write("                                            <td>: ");
      out.print(convertStringUpperToLower(fullName));
      out.write("</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>");
      out.print(MAIL_ID);
      out.write(" </td>\r\n");
      out.write("                                            <td>: \r\n");
      out.write("                                                ");

                                                    if (email_status == 1) {
                                                        if (mail.equals(session.getAttribute("email"))) {
                                                            out.println(mail);
                                                        } else {
                                                            out.println("Hidden by user");
                                                        }
                                                    } else {
                                                        out.println(mail);
                                                    }
                                                
      out.write("&nbsp;&nbsp;\r\n");
      out.write("                                                ");

                                                    if (session.getAttribute("email") != null) {
                                                        if (mail.equals(session.getAttribute("email"))) {
                                                            if (email_status == 0) {
                                                
      out.write("\r\n");
      out.write("                                                <a href=\"\" onclick=\"return hide_mail(this, '");
      out.print(session_id_of_user);
      out.write("', '");
      out.print("hide");
      out.write("');\">Hide your mail</a>\r\n");
      out.write("                                                ");

                                                    }
                                                    if (email_status == 1) {
                                                
      out.write("\r\n");
      out.write("                                                <a href=\"\" onclick=\"return hide_mail(this, '");
      out.print(session_id_of_user);
      out.write("', '");
      out.print("show");
      out.write("');\">Display your mail</a>\r\n");
      out.write("                                                ");

                                                            }
                                                        }
                                                    }
                                                
      out.write("</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>");
      out.print(HIGHER_QUALIFICATION);
      out.write(" </td>\r\n");
      out.write("                                            <td>: ");

                                                //higher_colification
                                                if (higher_colification == null || higher_colification.isEmpty()) {
                                                    out.println("Not provided yet");
                                                } else {
                                                    out.println(higher_colification);
                                                }
                                                
      out.write("</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>");
      out.print(BEST_ACHIEVEMENT);
      out.write("</td>\r\n");
      out.write("                                            <td>: ");

                                                if (BestAchievement == null || BestAchievement.isEmpty()) {
                                                    out.println("Not provided yet");
                                                } else {
                                                    out.println(BestAchievement);
                                                }
                                                
      out.write("</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>");
      out.print(BIO);
      out.write(" </td>\r\n");
      out.write("                                            <td>: ");

                                                if (bio == null || bio.isEmpty()) {
                                                    out.println("Not provided yet");
                                                } else {
                                                    out.println(bio);
                                                }
                                                
      out.write("</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        ");
 try {
                                                if (session.getAttribute("email") != null) {
                                                    if (mail.equals(session.getAttribute("email"))) {
      out.write("                                                               \r\n");
      out.write("                                        <tr>                                                   \r\n");
      out.write("                                            <td><a href=\"UpdateUserProfile.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(COMPLETE_YOUR_PROFILE);
      out.write("</a></td>  \r\n");
      out.write("\r\n");
      out.write("                                        </tr>\r\n");
      out.write("\r\n");
      out.write("                                        ");
 }
                                                }
                                            } catch (Exception ex) {
                                                out.println("What the hell is going on" + ex);
                                            }
      out.write("\r\n");
      out.write("                                        <tr>                                                   \r\n");
      out.write("                                            <td>Appreciation ..</td>  \r\n");
      out.write("\r\n");
      out.write("                                        </tr>\r\n");
      out.write("\r\n");
      out.write("                                    </table>\r\n");
      out.write("\r\n");
      out.write("                                    <div align=\"right\">\r\n");
      out.write("\r\n");
      out.write("                                        ");
 //Fetching the userProfile comment
                                            try {
                                                String sql_question_comment = "SELECT unique_id,user_id,"
                                                        + "(SELECT firstname FROM newuser WHERE id = comments.user_id )AS fullname,"
                                                        + "q_id,comments,time FROM comments WHERE userprofileid = ? ";
                                                preparedStatement = connection.prepareStatement(sql_question_comment);
                                                preparedStatement.setInt(1, id_of_user);
                                                resultSet = preparedStatement.executeQuery();
                                                while (resultSet.next()) {
                                                    String Blog_comments = resultSet.getString("comments");
                                                    int user_id = resultSet.getInt("user_id");//userId of who commented
                                                    String userNameWhoCommented = resultSet.getString("fullname");//UserName who commentd
                                                    String time = resultSet.getString("time");

                                                    out.println(Blog_comments + ":- ");
                                                    if (userName.equalsIgnoreCase("GuestUser")) {
                                                        out.println("<b style=color:red;>" + userName + "</b>");
                                                    } else {
                                        
      out.write("\r\n");
      out.write("                                        <a href=\"profile.jsp?user=");
      out.print(userNameWhoCommented.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(user_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(convertStringUpperToLower(userNameWhoCommented));
      out.write("</a>\r\n");
      out.write("                                        ");
  }
                                                    out.println(" <br>_____________________________<br> ");
                                                }

                                            } catch (Exception msg) {
                                                out.println("Error in loading question comment: -" + msg);
                                            }
                                        
      out.write("\r\n");
      out.write("                                        ");
 try {
                                                if (session.getAttribute("email") != null) {
                                                    if (!mail.equals(session.getAttribute("email"))) {
      out.write("     \r\n");
      out.write("                                        <a href=\"javascript:void(0)\" value=\"Comment\" onclick=\"showCommentBox()\">Write Good Thing About Him</a>\r\n");
      out.write("                                        ");
 }
                                        } else {
                                        
      out.write("     \r\n");
      out.write("                                        <a href=\"javascript:void(0)\" value=\"Comment\" onclick=\"alert('Please Login To Comment');\">Write Good Thing About Him</a>\r\n");
      out.write("                                        ");

                                                }
                                            } catch (Exception msg) {
                                                out.println(msg);
                                            }
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <form action=\"SubmitUserProfileComment.jsp\" method=\"get\">\r\n");
      out.write("                                        <div class=\"hidden\" id=\"comment\">\r\n");
      out.write("                                            <input type=\"hidden\" name=\"OnCommentUserId\" value=\"");
      out.print(id_of_user);
      out.write("\">\r\n");
      out.write("                                            <textarea name=\"comments\" rows=\"3\" cols=\"30\" required=\"\" placeholder=\"Write about him and let the world know how good he is..\"></textarea>\r\n");
      out.write("                                            <input type=\"submit\" name=\"sub\" value=\"Send Comment\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </form>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!--                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("                                                    <div class=\"themeBox\" style=\"min-height:430px;\">\r\n");
      out.write("                                                        <div class=\"boxHeading\">\r\n");
      out.write("                                                            User having same interest\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                        <div>\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>-->\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("                            ");

                                //This script is for cound the rows in a table
                                //For question
                                int TotalQuestion = 0;
                                String sql_question = "select count(*) as cnt from question where id =?";
                                preparedStatement = connection.prepareStatement(sql_question);
                                preparedStatement.setInt(1, id_of_user);
                                resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    TotalQuestion = resultSet.getInt("cnt");
                                }
                            
      out.write("\r\n");
      out.write("                            ");

                                //This script is for cound the rows in a table
                                //For Answer
                                int TotalAnswer = 0;
                                String sql_answer = "select count(*) as cnt from answer where  Answer_by_id = ?";
                                preparedStatement = connection.prepareStatement(sql_answer);
                                preparedStatement.setInt(1, id_of_user);
                                resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    TotalAnswer = resultSet.getInt("cnt");
                                }
                            
      out.write("\r\n");
      out.write("                            ");

                                //This script is for cound the rows in a table
                                //For Topic
                                int TotalTopic = 0;
                                String sql_topic = " select count(*) as cnt from topic_followers_detail where user_or_followers_id = ?";
                                preparedStatement = connection.prepareStatement(sql_topic);
                                preparedStatement.setInt(1, id_of_user);
                                resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    TotalTopic = resultSet.getInt("cnt");
                                }
                            
      out.write("\r\n");
      out.write("                            ");

                                //This script is for cound the rows in a table
                                //For TotoalFollowing
                                int TotalFollowing = 0;
                                String sql_following = "select count(*) as cnt from ak_follower_detail where followers_id = ?";
                                preparedStatement = connection.prepareStatement(sql_following);
                                preparedStatement.setInt(1, id_of_user);
                                resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    TotalFollowing = resultSet.getInt("cnt");
                                }
                            
      out.write("\r\n");
      out.write("                            ");

                                //This script is for cound the rows in a table
                                //For TotoalFollowers
                                int TotalFollowers = 0;
                                String sql_followers = "select count(*) as cnt from ak_follower_detail where user_id = ?";
                                preparedStatement = connection.prepareStatement(sql_followers);
                                preparedStatement.setInt(1, id_of_user);
                                resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    TotalFollowers = resultSet.getInt("cnt");
                                }
                            
      out.write("\r\n");
      out.write("                            ");

                                //This script is for cound the rows in a table
                                //For Totoalblog
                                int Totalblog = 0;
                                String sql_blogs = "select count(*)as cnt from blog where blog_posted_by = ?";
                                preparedStatement = connection.prepareStatement(sql_blogs);
                                preparedStatement.setInt(1, id_of_user);
                                resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    Totalblog = resultSet.getInt("cnt");
                                }
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"themeBox\" style=\"min-height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    ");
      out.print(YOUR_ACTIVITY);
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <a href=\"profile.jsp?user=");
      out.print(userName);
      out.write("&value=Question&ID=");
      out.print(ID);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(QUESTION);
      out.write('(');
      out.print(TotalQuestion);
      out.write(")</a><br>\r\n");
      out.write("                                    <a href=\"profile.jsp?user=");
      out.print(userName);
      out.write("&value=Answer&ID=");
      out.print(ID);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(ANSWER);
      out.write('(');
      out.print(TotalAnswer);
      out.write(")</a><br>\r\n");
      out.write("                                    <a href=\"profile.jsp?user=");
      out.print(userName);
      out.write("&value=Topic&ID=");
      out.print(ID);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(TOPIC_FOLLOWED);
      out.write('(');
      out.print(TotalTopic);
      out.write(")</a><br>\r\n");
      out.write("                                    <a href=\"profile.jsp?user=");
      out.print(userName);
      out.write("&value=Following&ID=");
      out.print(ID);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(FOLLOWING);
      out.write('(');
      out.print(TotalFollowing);
      out.write(")</a><br>\r\n");
      out.write("                                    <a href=\"profile.jsp?user=");
      out.print(userName);
      out.write("&value=Followers&ID=");
      out.print(ID);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(FOLLOWERS);
      out.write('(');
      out.print(TotalFollowers);
      out.write(")</a><br>\r\n");
      out.write("                                    <a href=\"profile.jsp?user=");
      out.print(userName);
      out.write("&value=Blog&ID=");
      out.print(ID);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(BLOG);
      out.write('(');
      out.print(Totalblog);
      out.write(")</a><br>\r\n");
      out.write("                                    <a href=\"profile.jsp?user=");
      out.print(userName);
      out.write("&value=Quotes&ID=");
      out.print(ID);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(QUOTES);
      out.write("</a><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;margin-bottom:0px;\">\r\n");
      out.write("                                        ");


                                            String ParametrVariable = request.getParameter("value");
                                            if (ParametrVariable == null) {
                                                ParametrVariable = "Question";
                                            }
                                            if (ParametrVariable != null) {
                                                try {
                                                    if (ParametrVariable.equals("Question")) {
                                                        out.println("<center><div class=boxHeading>" + QUESTION + "</div></center>");
                                                        String Question_asked_by_user;
                                                        int question_id;
                                                        String Q = "SELECT * FROM question WHERE id = '" + id_of_user + "'";
                                                        preparedStatement = connection.prepareStatement(Q);
                                                        resultSet = preparedStatement.executeQuery();
                                                        int count = 0;
                                                        while (resultSet.next()) {
                                                            count++;
                                                            Question_asked_by_user = resultSet.getString("question");
                                                            question_id = resultSet.getInt("q_id");
                                                            int userId_of_this_question = resultSet.getInt("id");

                                        
      out.write(" <br>Q. <a href=\"Answer.jsp?q=");
      out.print(Question_asked_by_user.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(question_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(Question_asked_by_user);
      out.write(" ?</a>\r\n");
      out.write("                                        &nbsp;&nbsp;&nbsp;&nbsp; \r\n");
      out.write("                                        ");
  if (session.getAttribute("Session_id_of_user") != null) {
                                                if (userId_of_this_question == session_id_of_user) {
      out.write("\r\n");
      out.write("                                        <a href=\"edit_q.jsp?Id=");
      out.print(question_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\">edit</a>\r\n");
      out.write("                                        ");
 }
                                            }
      out.write("\r\n");
      out.write("                                        ");

                                            }
                                            if (count == 0) {
                                                out.println("<b style=color:red;>No question posted yet !!</b>");
                                            }
                                            try {
                                                if (session.getAttribute("email") != null) {
                                                    if (mail.equals(session.getAttribute("email"))) {
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                                <button type=\"button\" class=\"btn\" data-toggle=\"modal\" data-target=\"#myModal\">");
      out.print(ADD_MORE_QUESTION);
      out.write("</button>\r\n");
      out.write("                                                <!-- btn-info btn-lg -->\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        ");

                                                        }
                                                    }
                                                } catch (Exception ex) {
                                                    out.println("What the hell is going on" + ex);
                                                }

                                            }

                                            //Staring answer programming....................................................
                                            if (ParametrVariable.equals("Answer")) {
                                                out.println("<center><div class=boxHeading>" + ANSWER + "</div></center>");
                                                String Answer_given_by_user;
                                                int Question_id;
                                                String Q_a = "SELECT q.question,q.q_id,SUBSTRING(ans.answer,1,200),ans.a_id,ans.Answer_by_id from answer ans right join question q on q.q_id = ans.q_id where Answer_by_id = '" + id_of_user + "'";
                                                preparedStatement = connection.prepareStatement(Q_a);
                                                resultSet = preparedStatement.executeQuery();
                                                int count = 0;
                                                while (resultSet.next()) {
                                                    count++;
                                                    Answer_given_by_user = resultSet.getString("SUBSTRING(ans.answer,1,200)");
                                                    String Question_by_user = resultSet.getString("question");
                                                    Question_id = resultSet.getInt("q.q_id");
                                                    int ans_id = resultSet.getInt("ans.a_id");
                                                    int ans_by_id = resultSet.getInt("ans.Answer_by_id");
                                        
      out.write("<br> Q. <a href=\"Answer.jsp?q=");
      out.print(Question_by_user.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(Question_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(Question_by_user);
      out.write(" ?</a>\r\n");
      out.write("                                        &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                                        ");
  if (session.getAttribute("Session_id_of_user") != null) {
                                                if (ans_by_id == session_id_of_user) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <a href=\"edit_a.jsp?q_id=");
      out.print(Question_id);
      out.write("&ans_id=");
      out.print(ans_id);
      out.write("&ans_by_id=");
      out.print(ans_by_id);
      out.write("\">Edit your answer</a>\r\n");
      out.write("                                        ");
 }
                                            }
      out.write("\r\n");
      out.write("                                        ");

                                                    out.println("<br>Ans.</b>&nbsp;&nbsp;&nbsp;&nbsp;" + Answer_given_by_user + " <a href=Answer.jsp?Id=" + Question_id + "> Continue Reading</a>");
                                                }
                                                if (count == 0) {
                                                    out.println("<b style=color:red;>No answer posted yet !!</b>");
                                                }
                                            }
                                            if (ParametrVariable.equals("Topic")) {
                                                out.println("<center><div class=boxHeading>" + TOPIC_FOLLOWED + "</div></center>");
                                                String topic_name;
                                                try {
                                                    String p_fetch_topic = "select t.unique_id,t.topic_name from topic t "
                                                            + "right join topic_followers_detail de "
                                                            + "on t.unique_id = de.topic_id "
                                                            + "where user_or_followers_id= '" + ID + "' and t.unique_id is not null and t.topic_name is not null";
                                                    preparedStatement = connection.prepareStatement(p_fetch_topic);
                                                    resultSet = preparedStatement.executeQuery();
                                                    int count = 0;

                                                    while (resultSet.next()) {
                                                        count++;
                                                        topic_name = convertStringUpperToLower(resultSet.getString("topic_name"));
                                                        topic_id = resultSet.getInt("unique_id");
                                                        if (topic_name != null) {
                                        
      out.write("<br> <a href=\"topic.jsp?t=");
      out.print(topic_name.replaceAll(" ", "+"));
      out.write("&id=");
      out.print(topic_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >&nbsp;&nbsp;&nbsp;&nbsp;");
      out.print(topic_name);
      out.write(" </a>");

                                                        }
                                                    }
                                                    if (count == 0) {
                                                        out.println("<b style=color:red;>No Topic followed yet !!</b>");
                                                    }
                                                    try {
                                                        if (session.getAttribute("email") != null) {
                                                            if (mail.equals(session.getAttribute("email"))) {
                                                                out.println("<br><a href=FollowMoreTopic.jsp> Follow more topic</a>");
                                                            }
                                                        }
                                                    } catch (Exception ex) {
                                                        out.println("What the hell is going on" + ex);
                                                    }
                                                } catch (Exception e) {
                                                    out.println("Unable to retrieve!!" + e);
                                                }
                                            }
                                            if (ParametrVariable.equals("Following")) {
                                                out.println("<center><div class=boxHeading>" + FOLLOWING + "</div></center>");
                                                //String topic_name;
                                                try {
                                                    String p_fetch_topic = "select user.ID,user.firstname,user.imagepath from newuser user right join ak_follower_detail ak on ak.user_id=user.ID where followers_id = '" + id_of_user + "'";
                                                    preparedStatement = connection.prepareStatement(p_fetch_topic);
                                                    resultSet = preparedStatement.executeQuery();
                                                    boolean count = true;
                                                    while (resultSet.next()) {
                                                        count = false;
                                                        int userid = resultSet.getInt("ID");
                                                        String UserFullName = resultSet.getString("firstname");
                                                        String Image_Path = resultSet.getString("imagepath");
                                        
      out.write("\r\n");
      out.write("                                        <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                            <img src=\"images/");
      out.print(Image_Path);
      out.write("\" alt=\"\" style=\"width:100%; border:1px solid #ddd;margin-top:20px;\">\r\n");
      out.write("                                            <a href=\"profile.jsp?user=");
      out.print(convertStringUpperToLower(UserFullName).replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(userid);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> ");
      out.print(convertStringUpperToLower(UserFullName));
      out.write("</a>\r\n");
      out.write("                                        </div>                \r\n");
      out.write("                                        ");

                                                    }
                                                    if (count) {
                                                        out.println("<b style=color:red;>" + NOT_FOLLOWING_ANY_USER + "!!</b>");
                                                    }
                                                    try {
                                                        if (session.getAttribute("email") != null) {
                                                            if (mail.equals(session.getAttribute("email"))) {
                                                                out.println("<br><a href=UserProfile.jsp?sl=" + sl + ">" + FOLLOW_MORE_USER + "</a>");
                                                            }
                                                        }
                                                    } catch (Exception ex) {
                                                        out.println("What the hell is going on" + ex);
                                                    }
                                                } catch (Exception e) {
                                                    out.println("Unable to retrieve!!" + e);
                                                }
                                            }
                                            if (ParametrVariable.equals("Followers")) {
                                                out.println("<center><div class=boxHeading>" + FOLLOWERS + "</div></center>");
                                                //String topic_name;
                                                try {
                                                    String p_fetch_topic = "select user.ID,user.firstname,user.imagepath from newuser user right join ak_follower_detail ak on ak.followers_id=user.ID where user_id = '" + id_of_user + "'";
                                                    preparedStatement = connection.prepareStatement(p_fetch_topic);
                                                    resultSet = preparedStatement.executeQuery();
                                                    int count = 0;
                                                    while (resultSet.next()) {
                                                        count++;
                                                        int userid = resultSet.getInt("ID");
                                                        fullName = resultSet.getString("firstname");
                                                        String Image_Path = resultSet.getString("imagepath");
                                        
      out.write("\r\n");
      out.write("                                        <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                            <img src=\"images/");
      out.print(Image_Path);
      out.write("\" alt=\"\" style=\"width:100%; border:1px solid #ddd;margin-top:20px;\">\r\n");
      out.write("                                            <a href=\"profile.jsp?user=");
      out.print(convertStringUpperToLower(fullName).replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(userid);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> ");
      out.print(convertStringUpperToLower(fullName));
      out.write("</a>\r\n");
      out.write("                                        </div>                \r\n");
      out.write("                                        ");

                                                    }
                                                    if (count == 0) {
                                                        out.println("<b style=color:red;>" + NOT_FOLLOWED_BY_ANY_USER + "!!</b>");
                                                    }
                                                } catch (Exception e) {
                                                    out.println("Unable to retrieve!!" + e);
                                                }
                                            }

                                            if (ParametrVariable.equals("Quotes")) {
                                                out.println("<center><div class=boxHeading>" + QUOTES + "</div></center>");
                                                String quotes;
                                                String Q = "SELECT * FROM quotes WHERE user_id = '" + id_of_user + "'";
                                                preparedStatement = connection.prepareStatement(Q);
                                                resultSet = preparedStatement.executeQuery();
                                                int count = 0;
                                                while (resultSet.next()) {
                                                    count++;
                                                    quotes = resultSet.getString("quotes");
                                        
      out.write(" <br>");
      out.print(quotes);
      out.write(" ?</a>");

                                                }
                                                if (count == 0) {
                                                    out.println("<b style=color:red;>" + NO_QUESTES_POSTED_YET + "!!</b>");
                                                }
                                                try {
                                                    if (session.getAttribute("email") != null) {
                                                        if (mail.equals(session.getAttribute("email"))) {
                                                            out.println("<br><a href=popup.jsp?sl=" + sl + ">" + ADD_MORE_QUOTES + "</a>");
                                                        }
                                                    }
                                                } catch (Exception ex) {
                                                    out.println("What the hell is going on" + ex);
                                                }
                                            }

                                            if (ParametrVariable.equals("Blog")) {
                                                out.println("<center><div class=boxHeading>" + BLOG + "</div></center>");
                                                String blog_posted_by_user;
                                                String sql = "SELECT * FROM blog WHERE blog_posted_by = '" + id_of_user + "'";
                                                preparedStatement = connection.prepareStatement(sql);
                                                resultSet = preparedStatement.executeQuery();
                                                int count = 0;
                                                while (resultSet.next()) {
                                                    count++;
                                                    blog_posted_by_user = resultSet.getString("blog_subject");
                                                    int Blog_id = resultSet.getInt("blog_id");
                                        
      out.write(" <br><a href=\"D_Blog.jsp?sub=");
      out.print(blog_posted_by_user.replaceAll(" ", "+"));
      out.write("&Blog_Id=");
      out.print(Blog_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(blog_posted_by_user);
      out.write("</a>");

                                                        }
                                                        if (count == 0) {
                                                            out.println("<b style=color:red;>" + NO_BLOG_POSTED_YET + "!!</b>");
                                                        }
                                                        try {
                                                            if (session.getAttribute("email") != null) {
                                                                if (mail.equals(session.getAttribute("email"))) {
                                                                    out.println("<br><a href=WriteBlogHere.jsp?sl=" + sl + ">" + BLOG_ABOUT_SOMETHING + "</a>");
                                                                }
                                                            }
                                                        } catch (Exception ex) {
                                                            out.println("What the hell is going on" + ex);
                                                        }
                                                    }

                                                } catch (Exception e) {
                                                    out.println("Error:" + e);
                                                }
                                            }//IF statement closed here
                                        
      out.write("\r\n");
      out.write("                                        ");

                                            } catch (Exception e) {
                                                out.println("Error in main try block:-" + e);
                                            } finally {
                                                try {

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
                                                } catch (Exception msg) {
                                                    out.println(msg);
                                                }
                                            }
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row margintop10\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Modal content-->\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                            <h4 class=\"modal-title\">");
      out.print(POST_YOUR_QUESTION_HERE);
      out.write("</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
if (session.getAttribute("email") != null) {
      out.write("\r\n");
      out.write("                        <form name=\"submitquestion\" method=\"post\" action=\"SubmitQuestion.jsp\">\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <div>");
      out.print(PUT_YOUR_QUESTION_HERE);
      out.write("</div>                                                        \r\n");
      out.write("                                    <textarea type=\"text\" class=\"anstext\" name=\"question\" placeholder=\"");
      out.print(EX);
      out.write("\" required=\"\"></textarea></div>\r\n");
      out.write("                                <div class=\"margintop20\">\r\n");
      out.write("                                    <div>");
      out.print(TAG_SUGGESTION_DESCRIPTION);
      out.write(" </div>\r\n");
      out.write("                                    <textarea type=\"text\" class=\"anstext\" name=\"tag_of_question\" placeholder=\"");
      out.print(TAG_EXMAPLE);
      out.write("\" required=\"\"></textarea></div>\r\n");
      out.write("                                <!-- <p>Some text in the modal.</p> -->\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-footer\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn\">");
      out.print(POST);
      out.write("</button>\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">");
      out.print(CLOSE);
      out.write("</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        ");
} else {
      out.write("\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <div><h4 style=\"color: red;\">");
      out.print(PLEASE_LOGIN_FIRST);
      out.write("!!!</h4></div>\r\n");
      out.write("                                <div><a href=\"Login.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(CLICK_HERE_TO_LOGIN);
      out.write("</a></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-footer\">                                                    \r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">");
      out.print(CLOSE);
      out.write("</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      out.write("<div class=\"modal fade\" id=\"myModalN\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <!-- Modal content-->\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title\">Your current notification</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div>\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "NodificationScript.jsp", out, false);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">                                                    \n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">close</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("        </div> <!-- /.main-page-wrapper -->\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
