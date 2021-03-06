package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;

public final class Answer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String DB_URL_ = "jdbc:mysql://localhost/bharat?useUnicode=true&characterEncoding=utf-8";
String DB_USERNAME_ = "root";
String DB_PASSWORD_ = null;
String DB_AJAX_PATH = "http://localhost:8084/inquiryhere";


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

            public boolean validateUser(String username, String password) {
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
                    //int Session_id_of_user = 0;
                    // boolean found = false;
                    try {

                        String v = "SELECT ID,email,password FROM newuser WHERE email = ?";

                        preparedStatement = connection.prepareStatement(v);
                        preparedStatement.setString(1, cookiesMail);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            password1 = resultSet.getString("password");
                            //Session_id_of_user = resultSet.getInt("ID");
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
        
            String FOLLOWED_TOPIC = "";
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
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/site.jsp");
    _jspx_dependants.add("/validator.jsp");
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

      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        \r\n");
      out.write("         \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
      out.write('\n');
      out.write('\n');
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html\" charset=\"utf-8\">\r\n");
      out.write("      \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
              if (session.getAttribute("email") == null) {
                Cookie[] cookies = request.getCookies();
                String username = "";
                String password = "";
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
                    //out.println(found);
                    if (found) {
                        String URL = request.getRequestURL() + "?" + request.getQueryString();
        
      out.write("\r\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("validate.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("email", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(username), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("password", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(password), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URL", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()));
        return;
      }
      out.write(">\r\n");
      out.write("        ");

                    }
                }
            }
        
      out.write("\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("            div.hidden{\r\n");
      out.write("                display: none;\r\n");
      out.write("            }\r\n");
      out.write("            div.visible{\r\n");
      out.write("                display: block;\r\n");
      out.write("            }\r\n");
      out.write("            .comment_box{\r\n");
      out.write("                border-style:solid;\r\n");
      out.write("                border-width:1px;\r\n");
      out.write("                float:left;\r\n");
      out.write("                background-color:#d4d4cb;\r\n");
      out.write("                width:280px;\r\n");
      out.write("                padding-left:20px;\r\n");
      out.write("                padding-top:25px;\r\n");
      out.write("                padding-bottom:10px;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
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
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

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
        
      out.write("\r\n");
      out.write("        ");

            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            int Question = 0;
            if (request.getParameter("Id") != null) {
                Question = Integer.valueOf(request.getParameter("Id"));
                //out.println(Question);
            } else {
                response.sendRedirect("index.jsp?ref=idnotfound");
            }


        
      out.write("\r\n");
      out.write("        ");
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
      out.write("        <script src=\"ckeditor/ckeditor.js\"></script>\r\n");
      out.write("        <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-128307055-1\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("                window.dataLayer = window.dataLayer || [];\r\n");
      out.write("                function gtag() {\r\n");
      out.write("                    dataLayer.push(arguments);\r\n");
      out.write("                }\r\n");
      out.write("                gtag('js', new Date());\r\n");
      out.write("                gtag('config', 'UA-128307055-1');\r\n");
      out.write("        </script> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            function take_value(el, question_answer_id, action, section) {\r\n");
      out.write("            ");
 if (session.getAttribute("email") == null) { 
      out.write("\r\n");
      out.write("                alert(\"Please login first\");");

                } else {
      out.write("\r\n");
      out.write("                el.onclick = function (event) {\r\n");
      out.write("                    event.preventDefault();\r\n");
      out.write("                };\r\n");
      out.write("                if (action === \"upvote\" && section === \"answer\") {\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_answer_vote.jsp?question_answer_id=\" + question_answer_id + \"&action=upvote&section=answer\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                }\r\n");
      out.write("                if (action === \"downvote\" && section === \"answer\") {\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_answer_vote.jsp?question_answer_id=\" + question_answer_id + \"&action=downvote&section=answer\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                }\r\n");
      out.write("                if (action === \"upvote\" && section === \"question\") {\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_answer_vote.jsp?question_answer_id=\" + question_answer_id + \"&action=upvote&section=question\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                }\r\n");
      out.write("                if (action === \"downvote\" && section === \"question\") {\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_answer_vote.jsp?question_answer_id=\" + question_answer_id + \"&action=downvote&section=question\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                }\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        ");

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
            }
        
      out.write("\r\n");
      out.write("        <title>");
      out.print(StoredQuestion);
      out.write("- inquiryhere.com</title>\r\n");
      out.write("        <link rel=\"icon\" href=\"https://www.inquiryhere.com/images/inquiryhere_Logo.PNG\" type=\"image/png\">\r\n");
      out.write("        <meta property=\"og:title\" content=\"");
      out.print(StoredQuestion);
      out.write("\" />\r\n");
      out.write("        ");

            if (StoredAnswer != null) {
        
      out.write("<meta property=\"og:description\" content=\"");
      out.print(StoredAnswer);
      out.write("\"/>\r\n");
      out.write("        <meta property=\"description\" content=\"");
      out.print(StoredAnswer);
      out.write("\"/>");

        } else {
        
      out.write("<meta property=\"og:description\" content=\"");
      out.print(StoredQuestion);
      out.write("\"/>\r\n");
      out.write("        <meta property=\"description\" content=\"");
      out.print(StoredQuestion);
      out.write("\"/> ");

            }
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <meta property=\"og:url\" content=\"https://www.inquiryhere.com/Answer.jsp\">\r\n");
      out.write("        <meta property=\"og:site_name\" content=\"inquiryhere.com\" />\r\n");
      out.write("        <meta property=\"og:image\" content=\"https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG\" />\r\n");
      out.write("        <meta property=\"og:type\" content=\"website\">\r\n");
      out.write("        <meta property=\"og:locale\" content=\"en_US\">\r\n");
      out.write("        ");

            try {
                String p_fetch_topic_sql = "select tag_id as unique_id,"
                        + "(select topic_name from topic where unique_id = question_topic_tag.tag_id)"
                        + " topic_name from question_topic_tag  where question_id ='" + StoredQuestionId + "'";
                preparedStatement = connection.prepareStatement(p_fetch_topic_sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String topic_name_for_seo = resultSet.getString("topic_name").toLowerCase();
        
      out.write("\r\n");
      out.write("        <meta property=\"article:tag\" content=\"");
      out.print(topic_name_for_seo);
      out.write("\" />              \r\n");
      out.write("        ");

                }
            } catch (Exception e) {
                out.println("Unable to retrieve!!" + e);
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"main-page-wrapper\">\r\n");
      out.write("            <!-- Header _________________________________ -->\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            ");

                //String name = null; // initilazing
                int id_of_user = 0;// initilazing
                int topic_id = 0;// initilazing
                int q_id = 0;// initilazing
                int q_asked_by_user = 0;// initilazing

                if (session.getAttribute("Session_id_of_user") != null) {
                    id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                }
            
      out.write("\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("            <div class=\"bodydata\">\r\n");
      out.write("                <div class=\"container clear-fix\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    Topic, Related to this question\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <ul>\r\n");
      out.write("\r\n");
      out.write("                                        ");

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
                                                    if (topic_id != 0) {
      out.write("\r\n");
      out.write("                                        <li><a href=\"topic.jsp?t=");
      out.print(topic_name.replaceAll(" ", "+"));
      out.write("&id=");
      out.print(topic_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(topic_name);
      out.write("</a></li>\r\n");
      out.write("                                            ");
 }
                                                    }
                                                } catch (Exception e) {
                                                    out.println("Unable to retrieve!!" + e);
                                                }
                                            
      out.write("\r\n");
      out.write("                                        <a href=\"FollowMoreTopic.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(CLICK_HERE_TO_MORE_TOPIC);
      out.write("</a>\r\n");
      out.write("                                        <a href=\"http://deloplen.com/afu.php?zoneid=2701297\">For advatise</a>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div> \r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");

                            ArrayList<Integer> userId = new ArrayList<>();
                        
      out.write("\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                ");

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
                                
      out.write("\r\n");
      out.write("                                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                        <div align=\"left\" style=\"font-size: 20px;font-family: serif;\">\r\n");
      out.write("                                            <a href=\"profile.jsp?user=");
      out.print(fullName_of_user_who_asked_the_question.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(q_asked_by_user);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(firstName(fullName_of_user_who_asked_the_question));
      out.write("</a>\r\n");
      out.write("                                            ");

                                                if (higher_edu != null && !higher_edu.isEmpty()) {
                                                    out.println("(" + higher_edu + ")");
                                                }
                                            
      out.write(",\r\n");
      out.write("                                            ");
      out.print(date);
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\" style=\"border-radius: 5px;padding-top: 10px;padding-bottom: 10px;padding-left: 10px; background: #7aab87;\">\r\n");
      out.write("\r\n");
      out.write("                                            <h1 style=\"font-size: 20px; \">");
      out.print(QUESTION);
      out.write(' ');
      out.write(':');
      out.print(StoredQuestion);
      out.write(" ?</h1> \r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <!--div class=\"questionArea\">\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"postedBy\"><!%=POSTED_BY%> :<a href=\"profile.jsp?user=<!%=fullName_of_user_who_asked_the_question.replaceAll(\" \", \"+\")%>&ID=<!%=q_asked_by_user%>&sl=<!%=sl%>\"><!%=firstName(fullName_of_user_who_asked_the_question)%></a> </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div-->\r\n");
      out.write("                                        <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(q_id);
      out.write("', 'upvote', 'question');\" >Upvote</a> &nbsp;&nbsp; \r\n");
      out.write("                                        <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(q_id);
      out.write("', 'downvote', 'question');\" >Downvote</a> &nbsp;&nbsp;\r\n");
      out.write("                                        <a href=\"javascript:void(0)\" value=\"Comment\" onclick=\"showCommentBox()\">Comment</a>&nbsp;&nbsp;\r\n");
      out.write("                                        <!--                                        <a href=\"javascript:void(0)\"></a>-->\r\n");
      out.write("                                        View(");
      out.print(TotalView);
      out.write(")\r\n");
      out.write("                                        <form action=\"SubmitQuestionComment.jsp\" method=\"get\">\r\n");
      out.write("                                            <div class=\"hidden\" id=\"comment\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"question_id\" value=\"");
      out.print(q_id);
      out.write("\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"question\" value=\"");
      out.print(StoredQuestion);
      out.write("\">\r\n");
      out.write("                                                <textarea name=\"comments\" rows=\"3\" cols=\"30\" required=\"\"></textarea>\r\n");
      out.write("                                                <input type=\"submit\" name=\"sub\" value=\"Send Comment\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <!-- Comment on question -->\r\n");
      out.write("                                    <div align=\"right\">\r\n");
      out.write("\r\n");
      out.write("                                        ");

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
                                        
      out.write("\r\n");
      out.write("                                        <a href=\"profile.jsp?user=");
      out.print(userName.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(user_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(convertStringUpperToLower(userName));
      out.write("</a><br>\r\n");
      out.write("                                        ");

                                                }

                                            } catch (Exception msg) {
                                                out.println("Error in loading question comment: -" + msg);
                                            }
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"boxHeading marginbot10\">");
      out.print(ANSWER);
      out.write(":</div>\r\n");
      out.write("\r\n");
      out.write("                                    ");

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
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\" style=\"font-size: 15px;font-family: Arial, Helvetica, sans-serif;\">\r\n");
      out.write("                                            ");
      out.print(answer);
      out.write(" \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"questionArea\">\r\n");
      out.write("                                            <div class=\"postedBy\">");
      out.print(ANSWERED_BY);
      out.write(" :<a href=\"profile.jsp?user=");
      out.print(firstname.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(who_gave_answer);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(firstName(firstname));
      out.write("</a> \r\n");
      out.write("                                                &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                                                ");
  if (session.getAttribute("Session_id_of_user") != null) {
                                                        int Session_id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                                                        if (who_gave_answer == Session_id_of_user) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                        <a href=\"edit_a.jsp?question=");
      out.print(StoredQuestion);
      out.write("&q_id=");
      out.print(Question);
      out.write("&ans_id=");
      out.print(answer_id);
      out.write("&ans_by_id=");
      out.print(who_gave_answer);
      out.write("\">Edit</a>\r\n");
      out.write("                                                ");
 }
                                                    }
      out.write(" </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red'; return take_value(this, '");
      out.print(answer_id);
      out.write("', 'upvote', 'answer');\" >Upvote</a>&nbsp;&nbsp; \r\n");
      out.write("                                        <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(answer_id);
      out.write("', 'downvote', 'answer');\" >Downvote</a>&nbsp;&nbsp;\r\n");
      out.write("                                        <a href=\"javascript:void(0)\" value=\"Comment\" onclick=\"showAns");
      out.print(answer_id);
      out.write("CommentBox()\">Comment</a>&nbsp;&nbsp;\r\n");
      out.write("                                        <a href=\"javascript:void(0)\">View(");
      out.print(total_view);
      out.write(")</a>\r\n");
      out.write("                                        <form action=\"SubmitAnswerComment.jsp\" method=\"get\">\r\n");
      out.write("                                            <div class=\"hidden\" id=\"Anscomment");
      out.print(answer_id);
      out.write("\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"answer_id\" value=\"");
      out.print(answer_id);
      out.write("\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"question_id\" value=\"");
      out.print(q_id);
      out.write("\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"question\" value=\"");
      out.print(StoredQuestion);
      out.write("\">\r\n");
      out.write("                                                <textarea name=\"comments\" rows=\"3\" cols=\"30\" required=\"\"></textarea>\r\n");
      out.write("                                                <input type=\"submit\" name=\"sub\" value=\"Send Comment\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>\r\n");
      out.write("\r\n");
      out.write("                                        <script type=\"text/javascript\">\r\n");
      out.write("                                            function showAns");
      out.print(answer_id);
      out.write("CommentBox() {\r\n");
      out.write("                                            ");
 if (session.getAttribute("Session_id_of_user") != null) {
      out.write("\r\n");
      out.write("                                                var div = document.getElementById('Anscomment");
      out.print(answer_id);
      out.write("');\r\n");
      out.write("                                                div.className = 'visible';\r\n");
      out.write("                                            ");
 } else { 
      out.write("\r\n");
      out.write("                                                alert(\"Please Login First to comment!!!\");\r\n");
      out.write("                                            ");
 } 
      out.write("\r\n");
      out.write("                                            }\r\n");
      out.write("                                        </script>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <!-- Comment on Answer -->\r\n");
      out.write("                                    <div align=\"right\">\r\n");
      out.write("\r\n");
      out.write("                                        ");

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
                                        
      out.write("\r\n");
      out.write("                                        <a href=\"profile.jsp?user=");
      out.print(userName.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(user_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(convertStringUpperToLower(userName));
      out.write("</a><br>\r\n");
      out.write("                                        ");

                                                }
                                                result.close();

                                            } catch (Exception msg) {
                                                out.println("Error in loading question comment: -" + msg);
                                            }
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");

                                        }

                                        if (count == 0) {
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\">\r\n");
      out.write("                                            ");
      out.print(BE_THE_FIRST_PERSON);
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");

                                            }
                                        } catch (Exception e) {
                                            out.println("Unable to retrieve!!" + e);
                                        }
                                    
      out.write("\r\n");
      out.write("                                    <form name=\"submitAnswer\" method=\"post\" action=\"SubmitAnswer.jsp\">\r\n");
      out.write("                                       ");

                                           String URL = request.getRequestURL() + "?" + request.getQueryString();
                                       
      out.write(" \r\n");
      out.write("                                        <input type=\"hidden\" name=\"question\" value=\"");
      out.print(StoredQuestion);
      out.write("\">\r\n");
      out.write("                                        <input type=\"hidden\" name=\"_id_of_user\" value=\"");
      out.print(id_of_user);
      out.write("\">\r\n");
      out.write("                                        <input type=\"hidden\" name=\"q_id\" value=\"");
      out.print(q_id);
      out.write("\">                                        \r\n");
      out.write("                                        <input type=\"hidden\" name=\"URL\" value=\"");
      out.print(URL);
      out.write("\">\r\n");
      out.write("                                        <input type=\"hidden\" name=\"sl\" value=\"");
      out.print(sl);
      out.write("\">\r\n");
      out.write("                                        <textarea class=\"ckeditor\" name=\"answer\" required=\"\">\r\n");
      out.write("                                            ");

                                                if (request.getParameter("ans") != null) {
                                                    out.println(request.getParameter("ans"));
                                                }
                                            
      out.write("\r\n");
      out.write("                                        </textarea>\r\n");
      out.write("                                        <input type=\"submit\" name=\"Post\" value=\"");
      out.print(SUBMIT);
      out.write("\"> \r\n");
      out.write("                                    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    ");
      out.print(RELATED_QUESTION);
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    ");

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
                                    
      out.write("\r\n");
      out.write("                                    <a href=\"Answer.jsp?q=");
      out.print(question_detail.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(questionID);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(question_detail);
      out.write("</a><br><br>\r\n");
      out.write("                                    ");

                                                }

                                            }
                                        }
                                    } catch (Exception error) {
                                        out.println("Error in inside blok" + error);
                                       
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

                                        }
                                    
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    Question you may like\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    ");

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
                                    
      out.write("\r\n");
      out.write("                                    <a href=\"Answer.jsp?q=");
      out.print(question.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(question_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(question);
      out.write("</a><br><br>\r\n");
      out.write("                                    ");

                                            }
                                        } catch (Exception msg) {
                                            out.println("Error in 'you may like question' " + msg);
                                        }
                                    
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");

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
                            
      out.write("\r\n");
      out.write("                            ");

                                if (session.getAttribute("email") != null) {
                            
      out.write("\r\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    ");
      out.print(COMPLETE_YOUR_PROFILE);
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CompleteUserProfile.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>");
 }
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clear-fix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("            <!--            <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\r\n");
      out.write("                            <div class=\"modal-dialog\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>-->\r\n");
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
      out.write("            <!-- Bootstrap JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("            <!-- Bootstrap Select JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("        </div> <!-- /.main-page-wrapper -->\r\n");
      out.write("\r\n");
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
