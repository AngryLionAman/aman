package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
                response.sendRedirect("index.jsp");
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
      out.write("        <script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            (adsbygoogle = window.adsbygoogle || []).push({\r\n");
      out.write("                google_ad_client: \"ca-pub-8778688755733551\",\r\n");
      out.write("                enable_page_level_ads: true\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-128307055-1\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            window.dataLayer = window.dataLayer || [];\r\n");
      out.write("            function gtag() {\r\n");
      out.write("                dataLayer.push(arguments);\r\n");
      out.write("            }\r\n");
      out.write("            gtag('js', new Date());\r\n");
      out.write("            gtag('config', 'UA-128307055-1');\r\n");
      out.write("        </script> \r\n");
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
        
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(e), request.getCharacterEncoding()), out, false);

            }
        
      out.write("\r\n");
      out.write("        <title>");
      out.print(StoredQuestion);
      out.write("</title>\r\n");
      out.write("        <link rel=\"icon\" href=\"https://www.inquiryhere.com/images/inquiryhere_Logo.PNG\" type=\"image/png\">\r\n");
      out.write("        <meta property=\"og:title\" content=\"");
      out.print(StoredQuestion);
      out.write("\" />\r\n");
      out.write("        ");

            if (StoredAnswer != null) {
        
      out.write("<meta property=\"og:description\" content=\"");
      out.print(StoredAnswer);
      out.write("\"/>");

        } else {
        
      out.write("<meta property=\"og:description\" content=\"");
      out.print(StoredQuestion);
      out.write("\"/>");

            }
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <meta property=\"og:url\" content=\"https://www.inquiryhere.com/\">\r\n");
      out.write("        <meta property=\"og:site_name\" content=\"https://www.inquiryhere.com/\" />\r\n");
      out.write("        <meta property=\"og:image\" content=\"https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG\" />\r\n");
      out.write("        <meta property=\"og:type\" content=\"website\">\r\n");
      out.write("        <meta property=\"og:locale\" content=\"en_US\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
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
//                if (session.getAttribute("email") != null) {
//                    email = (String) session.getAttribute("email");
//                    try {
//                        String sql = "SELECT * FROM newuser WHERE email = '" + email + "'";
//                        preparedStatement = connection.prepareCall(sql);
//                        resultSet = preparedStatement.executeQuery();
//                        while (resultSet.next()) {
//                            id_of_user = resultSet.getInt("id");
//                            name = resultSet.getString("firstname");
//                        }
//                    } catch (Exception e) {
//                        out.println("Unable to retrieve!!" + e);
//                    }
//                }
            
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
                                                /*if (session.getAttribute("email") != null) {
                                                    p_fetch_topic = "select t.unique_id,t.topic_name from topic t "
                                                            + "right join topic_followers_detail de "
                                                            + "on t.unique_id = de.topic_id "
                                                            + "where user_or_followers_id= '" + id_of_user + "'";
                                                } else {
                                                    p_fetch_topic = "select * from topic LIMIT 50,20";
                                                }*/
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
                                            
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(e), request.getCharacterEncoding()), out, false);

                                                }
                                            
      out.write("\r\n");
      out.write("                                        <a href=\"FollowMoreTopic.jsp?sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(CLICK_HERE_TO_MORE_TOPIC);
      out.write("</a>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div> \r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\">\r\n");
      out.write("\r\n");
      out.write("                                            ");
      out.print(QUESTION);
      out.write(" : ");
      out.print(StoredQuestion);
      out.write(" ?\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        ");

                                            String fullName_of_user_who_asked_the_question = null;
                                            try {
                                                String sql_p = "SELECT user.firstname,q.q_id,q.id FROM newuser user RIGHT JOIN question q on user.id=q.id where q_id= (?)";
                                                preparedStatement = connection.prepareStatement(sql_p);
                                                preparedStatement.setInt(1, Question);
                                                resultSet = preparedStatement.executeQuery();
                                                while (resultSet.next()) {
                                                    q_id = resultSet.getInt("q_id");
                                                    q_asked_by_user = resultSet.getInt("id");
                                                    fullName_of_user_who_asked_the_question = convertStringUpperToLower(resultSet.getString("firstname"));
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
                                        
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(e), request.getCharacterEncoding()), out, false);

                                            }
                                        
      out.write("\r\n");
      out.write("                                        <div class=\"questionArea\">\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"postedBy\">");
      out.print(POSTED_BY);
      out.write(" :<a href=\"profile.jsp?user=");
      out.print(fullName_of_user_who_asked_the_question.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(q_asked_by_user);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(fullName_of_user_who_asked_the_question);
      out.write("</a> </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(q_id);
      out.write("', 'upvote', 'question');\" >Upvote</a> &nbsp;&nbsp; \r\n");
      out.write("                                        <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(q_id);
      out.write("', 'downvote', 'question');\" >Downvote</a> &nbsp;&nbsp;\r\n");
      out.write("                                        <a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal_q_comment\">Comment</a>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <!-- **************If having the comment on the question****************** -->\r\n");
      out.write("\r\n");
      out.write("                                    <p align=\"right\"><a href=\"\">user profile</a>&nbsp;&nbsp;This is first comment</p>\r\n");
      out.write("                                    <p align=\"right\"><a href=\"\">user profile</a>&nbsp;&nbsp;This is second comment</p>\r\n");
      out.write("                                    <!-- **************End of the programm****************** -->\r\n");
      out.write("                                    <div class=\"boxHeading marginbot10\">");
      out.print(ANSWER);
      out.write(":</div>\r\n");
      out.write("\r\n");
      out.write("                                    ");

                                        try {
                                            String sql_p = "SELECT user.firstname,ans.answer,ans.a_id,ans.Answer_by_id FROM newuser user RIGHT JOIN answer ans on user.id = ans.Answer_by_id where q_id = '" + q_id + "' order by vote desc";
                                            preparedStatement = connection.prepareStatement(sql_p);
                                            resultSet = preparedStatement.executeQuery();
                                            int count = 0;

                                            while (resultSet.next()) {
                                                count++;
                                                String answer = resultSet.getString("answer");
                                                int who_gave_answer = resultSet.getInt("Answer_by_id");
                                                String firstname = convertStringUpperToLower(resultSet.getString("firstname"));
                                                int answer_id = resultSet.getInt("ans.a_id");
                                    
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
      out.print(firstname);
      out.write("</a> \r\n");
      out.write("                                                &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                                                ");
  if (session.getAttribute("Session_id_of_user") != null) {
                                                        int Session_id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                                                        if (who_gave_answer == Session_id_of_user) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                <a href=\"edit_a.jsp?q_id=");
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
      out.write("', 'downvote', 'answer');\" >Downvote</a>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                        <!-- **************If having the comment on the question****************** -->\r\n");
      out.write("\r\n");
      out.write("                                    <p align=\"right\"><a href=\"\">user profile</a>&nbsp;&nbsp;This is first comment</p>\r\n");
      out.write("                                    <p align=\"right\"><a href=\"\">user profile</a>&nbsp;&nbsp;This is second comment</p>\r\n");
      out.write("                                    <!-- **************End of the programm****************** -->\r\n");
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
                                    
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(e), request.getCharacterEncoding()), out, false);

                                        }
                                    
      out.write("\r\n");
      out.write("                                    <form name=\"submitquestion\" method=\"post\" action=\"SubmitAnswer.jsp?_id_of_user=");
      out.print(id_of_user);
      out.write("&q_id=");
      out.print(q_id);
      out.write("&URL=");
      out.print(request.getRequestURL());
      out.write("?Id=");
      out.print(q_id);
      out.write("&sl=");
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
                                    
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(error), request.getCharacterEncoding()), out, false);

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
                                    
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(e), request.getCharacterEncoding()), out, false);

                                        }
                                    
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                ");

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
      out.write("                            </div>\r\n");
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
      out.write("            <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("<!--  Comment dialog box   -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal fade\" id=\"myModal_q_comment\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Modal content-->\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                            <h4 class=\"modal-title\">Comment Box</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
if (session.getAttribute("email") != null) {
      out.write("\r\n");
      out.write("                        <form name=\"submitquestioncomment\" method=\"post\" action=\"SubmitQuestionComment.jsp\">\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <div>Put Your Comment Here</div>\r\n");
      out.write("                                    <textarea type=\"text\" class=\"anstext\" name=\"questionComment\" placeholder=\"Type comment here.\"  required=\"\"></textarea\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <!-- <p>Some text in the modal.</p> -->\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-footer\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn\" name=\"submit\" value=\"submit_question_commit\">post</button>\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">close</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        ");
} else {
      out.write("\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <div><h4 style=\"color: red;\">Please Login first!!!</h4></div>\r\n");
      out.write("                                <div><a href=\"Login.jsp?sl=");
      out.print(sl);
      out.write("\">Click here to login</a></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-footer\">                                                    \r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">close</button>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("    </body></html>");
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
