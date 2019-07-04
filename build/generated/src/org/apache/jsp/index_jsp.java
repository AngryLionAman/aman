package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        
            String name = null;
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
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        \r\n");
      out.write("\r\n");
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
        
      out.write("\r\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("validate.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("email", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(username), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("password", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(password), request.getCharacterEncoding()));
        return;
      }
      out.write(">\r\n");
      out.write("        ");

                    }
                }
            }
        
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
        
      out.write("\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html\" charset=\"utf-8\">\r\n");
      out.write("        <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-128307055-1\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            window.dataLayer = window.dataLayer || [];\r\n");
      out.write("            function gtag() {\r\n");
      out.write("                dataLayer.push(arguments);\r\n");
      out.write("            }\r\n");
      out.write("            gtag('js', new Date());\r\n");
      out.write("            gtag('config', 'UA-128307055-1');\r\n");
      out.write("        </script> \r\n");
      out.write("        <title>INQUIRYHERE.COM | HOME PAGE</title>\r\n");
      out.write("        <link rel=\"icon\" href=\"https://www.inquiryhere.com/images/inquiryhere_Logo.PNG\" type=\"image/png\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <meta property=\"og:description\" content=\"india's first question answer based social media where experts give \r\n");
      out.write("              you advise and suggestion related to your query .you can ask and share the \r\n");
      out.write("              information which you want to explore.our motive is to be specific according to your demand\" />\r\n");
      out.write("        <meta property=\"og:image\" content=\"https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG\" />\r\n");
      out.write("        <meta property=\"og:type\" content=\"website\">\r\n");
      out.write("        <meta property=\"og:locale\" content=\"en_US\">\r\n");
      out.write("        <meta property=\"og:title\" content=\"india first knowledge based social media platform where experts give\r\n");
      out.write("              you advise and suggestion related to your query\" />\r\n");
      out.write("        <meta property=\"og:url\" content=\"https://www.inquiryhere.com/\">\r\n");
      out.write("        <meta property=\"og:site_name\" content=\"inquiryhere.com\" />\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <script type=\"text/javascript\" src=\"http://www.google.com/jsapi\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            google.load(\"elements\", \"1\", {packages: \"transliteration\"});\r\n");
      out.write("        </script> \r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            function OnLoad() {\r\n");
      out.write("                var currValue = document.getElementById(\"text1\");\r\n");
      out.write("\r\n");
      out.write("                var options = {\r\n");
      out.write("                    sourceLanguage: google.elements.transliteration.LanguageCode.ENGLISH,\r\n");
      out.write("                    destinationLanguage: [google.elements.transliteration.LanguageCode.HINDI],\r\n");
      out.write("                    shortcutKey: 'ctrl+g',\r\n");
      out.write("                    transliterationEnabled: true\r\n");
      out.write("                };\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                var control = new\r\n");
      out.write("                        google.elements.transliteration.TransliterationControl(options);\r\n");
      out.write("                control.makeTransliteratable([\"text1\"]);\r\n");
      out.write("                var postValue = document.getElementById(\"text1\");\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            google.setOnLoadCallback(OnLoad);\r\n");
      out.write("\r\n");
      out.write("        </script> \r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            function take_value(el, question_id, action) {\r\n");
      out.write("            ");
 if (session.getAttribute("email") == null) { 
      out.write("\r\n");
      out.write("                alert(\"Please login first\");");

                } else {
      out.write("\r\n");
      out.write("                el.onclick = function (event) {\r\n");
      out.write("                    event.preventDefault();\r\n");
      out.write("                };\r\n");
      out.write("                if (action === \"upvote\") {\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_question_vote.jsp?question_id=\" + question_id + \"&action=upvote\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                }\r\n");
      out.write("                if (action === \"downvote\") {\r\n");
      out.write("                    var http = new XMLHttpRequest();\r\n");
      out.write("                    http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/submit_question_vote.jsp?question_id=\" + question_id + \"&action=downvote\", true);\r\n");
      out.write("                    http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                    http.send();\r\n");
      out.write("                }\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("        <style>\r\n");
      out.write("            a { color: black; } /* CSS link color */\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("page", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("index.jsp", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            ");

                int CurrentuserId = 0;
                String email = null;
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
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("            <div class=\"bodydata\">\r\n");
      out.write("                <div class=\"container clear-fix\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("                            ");
 // if (session.getAttribute("email") == null) {
      out.write("\r\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    ");
 
                                        if (session.getAttribute("email") != null) {
      out.write("\r\n");
      out.write("                                    ");
      out.print(FOLLOWED_TOPIC);
      out.write("\r\n");
      out.write("                                    ");
  } else {
      out.write("\r\n");
      out.write("                                    ");
      out.print(TOPIC_YOU_MAY_LIKE);
      out.write("\r\n");
      out.write("                                    ");
 }  
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <ul>\r\n");
      out.write("                                        ");


                                            if (session.getAttribute("Session_id_of_user") != null) {
                                                id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                                            } else {
                                                id_of_user = 0;
                                            }
                                            String sql = "";
                                            String topic_name;
                                            try {
                                                if (session.getAttribute("email") != null) {
                                                    sql = "select t.unique_id,t.topic_name,(select count(topic_id) "
                                                            + "from topic_followers_detail where topic_id = t.unique_id)as count"
                                                            + " from topic t right join topic_followers_detail de on t.unique_id = de.topic_id "
                                                            + "where user_or_followers_id ='" + id_of_user + "' and t.unique_id is not null and t.topic_name is not null LIMIT 5";
                                                } else {
                                                    sql = "SELECT t.unique_id AS unique_id,t.topic_name AS topic_name,"
                                                            + "(SELECT COUNT(user_or_followers_id) FROM topic_followers_detail "
                                                            + "WHERE topic_id = t.unique_id) AS count FROM topic t "
                                                            + "where t.unique_id IS NOT NULL AND t.topic_name IS NOT NULL ORDER BY RAND() LIMIT 5";
                                                }
                                                preparedStatement = connection.prepareStatement(sql);
                                                resultSet = preparedStatement.executeQuery();
                                                boolean status = true;
                                                while (resultSet.next()) {
                                                    topic_name = convertStringUpperToLower(resultSet.getString("topic_name"));
                                                    topic_id = resultSet.getInt("unique_id");
                                                    int count = resultSet.getInt("count");
                                                    if (topic_id != 0) {
                                                        status = false;
      out.write("\r\n");
      out.write("                                        <li><span title=\"Totoal followers of ");
      out.print(topic_name);
      out.write(" is ");
      out.print(count);
      out.write("\"><a href=\"topic.jsp?t=");
      out.print(topic_name.replaceAll(" ", "+"));
      out.write("&id=");
      out.print(topic_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(topic_name);
      out.write("</a> (");
      out.print(count);
      out.write(")</span></li>\r\n");
      out.write("                                            ");
 }
                                                    }
                                                    if (status) {
                                                        out.println("Something went wrong<br>or you may not followed any topic");
                                                    }
                                                } catch (Exception Exceptionmsg) {
                                                    out.println("Unable to retrieve!!" + Exceptionmsg);
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
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:200px;\">\r\n");
      out.write("                                        <div class=\"boxHeading\">\r\n");
      out.write("                                            ");
      out.print(POST_SOMETHING);
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div><textarea type=\"text\" class=\"anstext\" placeholder=\"");
      out.print(POST_YOUR_QUESTION_HERE);
      out.write("\" data-toggle=\"modal\" data-target=\"#myModal\" readonly=\"\"></textarea></div>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"float-right margintop20\" style=\"vertical-align:bottom\">\r\n");
      out.write("                                            <button type=\"button\" class=\"btn\" data-toggle=\"modal\" data-target=\"#myModal\">");
      out.print(POST);
      out.write("</button>\r\n");
      out.write("                                            <!-- btn-info btn-lg -->\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                    ");

                                        if (request.getParameter("iPageNo") == null && request.getParameter("cPageNo") == null) {
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <h4>");
      out.print(RECENT_POSTED_QUESTION);
      out.write("</h4>\r\n");
      out.write("                                    ");

                                        String sql3 = "SELECT q.total_view,date(q.posted_time) as date,q.q_id,(select count(*) from answer where q_id = q.q_id) as tac,"
                                                + "q.question,q.vote,user.firstname,user.higher_edu,user.ID FROM question q RIGHT JOIN newuser user ON user.id = q.id "
                                                + "WHERE q.q_id IS NOT NULL AND q.question IS NOT NULL ORDER BY q_id DESC LIMIT 10";
                                        String UserName_for_trending_question_T = null;
                                        String date = "";
                                        String higher_edu = "";
                                        try {
                                            preparedStatement = connection.prepareStatement(sql3);
                                            resultSet = preparedStatement.executeQuery();
                                            PreparedStatement ps2 = null;
                                            while (resultSet.next()) {
                                                String TrendingQuestion_T = resultSet.getString("question");
                                                int totalView = (resultSet.getInt("q.total_view") + 1);
                                                int question_id = resultSet.getInt("q.q_id");
                                                higher_edu = resultSet.getString("user.higher_edu");
                                                date = resultSet.getString("date");
                                                try {
                                                    String countView = "UPDATE question SET total_view = total_view + 1 WHERE q_id =? ";
                                                    ps2 = connection.prepareStatement(countView);
                                                    ps2.setInt(1, question_id);
                                                    ps2.executeUpdate();

                                                } catch (Exception msg) {
                                                    out.println("Error in cound the view" + msg);
                                                }
                                                int userID = resultSet.getInt("user.ID");
                                                int tac = resultSet.getInt("tac");
                                                int UpVote = resultSet.getInt("q.vote");
                                                UserName_for_trending_question_T = resultSet.getString("firstname").substring(0, 1).toUpperCase() + resultSet.getString("firstname").substring(1).toLowerCase();
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                        <div align=\"left\" style=\"font-size: 20px;font-family: serif;\">\r\n");
      out.write("                                            Posted by <a href=\"profile.jsp?user=");
      out.print(UserName_for_trending_question_T.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(userID);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> ");
      out.print(firstName(UserName_for_trending_question_T));
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
      out.write("                                        <div class=\"boxHeading marginbot10\" style=\"border-radius: 5px;padding-top: 10px;padding-bottom: 10px;padding-left: 10px; background: #d5d5fd;\" >\r\n");
      out.write("                                            <a href=\"Answer.jsp?q=");
      out.print(TrendingQuestion_T.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(question_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(TrendingQuestion_T);
      out.write(" ?</a>\r\n");
      out.write("                                            ");
  if (session.getAttribute("Session_id_of_user") != null) {
                                                    int Session_id_of_user = (Integer) session.getAttribute("Session_id_of_user");
                                                    if (userID == Session_id_of_user) {
      out.write("\r\n");
      out.write("                                            <a href=\"edit_q.jsp?Id=");
      out.print(question_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\">edit</a>\r\n");
      out.write("                                            ");
 }
                                                }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"questionArea\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(question_id);
      out.write("', '");
      out.print("upvote");
      out.write("');\" >Upvote(");
      out.print(UpVote);
      out.write(")</a>&nbsp;&nbsp; \r\n");
      out.write("                                            <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(question_id);
      out.write("', '");
      out.print("downvote");
      out.write("');\" >Downvote</a>&nbsp;&nbsp; \r\n");
      out.write("                                            <a href=\"Answer.jsp?q=");
      out.print(TrendingQuestion_T.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(question_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >Ans(");
      out.print(tac);
      out.write(")</a>&nbsp;&nbsp;\r\n");
      out.write("                                            <a href=\"javascript:void(0)\">View(");
      out.print(totalView);
      out.write(")</a>\r\n");
      out.write("                                            <!-- Comment on question -->\r\n");
      out.write("                                            <div align=\"right\">\r\n");
      out.write("\r\n");
      out.write("                                                ");

                                                    try {
                                                        PreparedStatement ps = null;
                                                        ResultSet rs = null;
                                                        String sql_question_comment = "SELECT unique_id,user_id,"
                                                                + "(SELECT firstname FROM newuser WHERE id = comments.user_id )AS fullname,"
                                                                + "q_id,comments,time FROM comments WHERE q_id = ? AND user_id IS NOT NULL AND q_id IS NOT NULL";
                                                        ps = connection.prepareStatement(sql_question_comment);
                                                        ps.setInt(1, question_id);
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            String question_comments = rs.getString("comments");
                                                            String userName = rs.getString("fullname");
                                                            String time = rs.getString("time");
                                                            int user_id = rs.getInt("user_id");

                                                            out.println(question_comments + ":- ");
                                                
      out.write("\r\n");
      out.write("                                                <a href=\"profile.jsp?user=");
      out.print(userName.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(user_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(convertStringUpperToLower(userName));
      out.write("</a>\r\n");
      out.write("                                                ");

                                                            out.println("(" + time + ") <br>_______________________________________<br>");
                                                        }
                                                        ps.close();
                                                        rs.close();
                                                    } catch (Exception msg) {
                                                        out.println("Error in loading question comment: -" + msg);
                                                    }
                                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");

                                                }
                                                ps2.close();
                                            } catch (Exception Exceptionmsg) {
                                                out.println("Error " + Exceptionmsg);

                                            }
                                        }
                                    
      out.write(" \r\n");
      out.write("                                    ");

                                        if (session.getAttribute("email") != null) {
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <h4>");
      out.print(RELATED_QUESTION);
      out.write("</h4>  \r\n");
      out.write("                                    ");

                                        //String name1 = null;
                                        String question, fname = null;
                                        int TotalAnswerCount = 0;
                                        int VoteCount = 0;
                                        int ide = 0;
                                        try {
                                            //tac = Total answer count
                                            //Migrated the join from right to inner. i don't know if any bug will create
                                            //Please god help me
                                            String sql4 = "select DISTINCT q.id,(SELECT firstname FROM newuser WHERE id= q.id) as firstname,"
                                                    + "q.q_id,q.total_view,q.question,q.vote,(select count(*) from answer where q_id = q.q_id) as tac from question q "
                                                    + "inner join question_topic_tag qtt on q.q_id = qtt.question_id where tag_id IN "
                                                    + "(select t.unique_id from topic t inner join topic_followers_detail de on t.unique_id = de.topic_id "
                                                    + "where user_or_followers_id = ?) and q.id is not null and q.q_id is not null "
                                                    + "and q.question is not null and (SELECT firstname FROM newuser WHERE id= q.id) is not null";
                                            preparedStatement = connection.prepareStatement(sql4);
                                            preparedStatement.setInt(1, id_of_user);
                                            resultSet = preparedStatement.executeQuery();

                                            while (resultSet.next()) {
                                                question = resultSet.getString("question");
                                                fname = resultSet.getString("firstname");
                                                TotalAnswerCount = resultSet.getInt("tac");
                                                VoteCount = (resultSet.getInt("q.vote") + 1);
                                                ide = resultSet.getInt("q.id");
                                                int question_id = resultSet.getInt("q.q_id");
                                                try {
                                                    PreparedStatement ps3 = null;
                                                    String countView = "UPDATE question SET total_view = total_view + 1 WHERE q_id =? ";
                                                    ps3 = connection.prepareStatement(countView);
                                                    ps3.setInt(1, question_id);
                                                    ps3.executeUpdate();
                                                    ps3.close();

                                                } catch (Exception msg) {
                                                    out.println("Error in cound the view" + msg);
                                                }
                                                int ViewCount = resultSet.getInt("q.total_view");
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\">\r\n");
      out.write("                                            <a href=\"Answer.jsp?q=");
      out.print(question.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(resultSet.getInt("q.q_id"));
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(question);
      out.write(" ?</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"questionArea\">\r\n");
      out.write("                                            <div class=\"postedBy\">");
      out.print(POSTED_BY);
      out.write(" : <a href=\"profile.jsp?user=");
      out.print(fname.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(ide);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(firstName(fname));
      out.write("</a></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(resultSet.getInt("q.q_id"));
      out.write("', '");
      out.print("upvote");
      out.write("');\" >Upvote(");
      out.print(VoteCount);
      out.write(")</a>&nbsp;&nbsp; \r\n");
      out.write("                                        <a href=\"javascript:void(0)\" onclick=\"this.style.color = 'red';return take_value(this, '");
      out.print(resultSet.getInt("q.q_id"));
      out.write("', '");
      out.print("downvote");
      out.write("');\" >Downvote</a>&nbsp;&nbsp; \r\n");
      out.write("                                        <a href=\"Answer.jsp?q=");
      out.print(question.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(resultSet.getInt("q.q_id"));
      out.write("&sl=");
      out.print(sl);
      out.write("\" >Ans(");
      out.print(TotalAnswerCount);
      out.write(")</a>&nbsp;&nbsp;                                         \r\n");
      out.write("                                        <a href=\"javascript:void(0)\">View(");
      out.print(ViewCount);
      out.write(")</a>\r\n");
      out.write("                                        <!-- Comment on question -->\r\n");
      out.write("                                        <div align=\"right\">\r\n");
      out.write("\r\n");
      out.write("                                            ");

                                                try {
                                                    PreparedStatement ps = null;
                                                    ResultSet rs = null;
                                                    String sql_question_comment = "SELECT unique_id,user_id,"
                                                            + "(SELECT firstname FROM newuser WHERE id = comments.user_id )AS fullname,"
                                                            + "q_id,comments,time FROM comments WHERE q_id = ? AND user_id IS NOT NULL AND q_id IS NOT NULL";
                                                    ps = connection.prepareStatement(sql_question_comment);
                                                    ps.setInt(1, resultSet.getInt("q.q_id"));
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        String question_comments = rs.getString("comments");
                                                        String userName = rs.getString("fullname");
                                                        String time = rs.getString("time");
                                                        int user_id = rs.getInt("user_id");

                                                        out.println(question_comments + ":- ");
                                            
      out.write("\r\n");
      out.write("                                            <a href=\"profile.jsp?user=");
      out.print(userName.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(user_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(convertStringUpperToLower(userName));
      out.write("</a>\r\n");
      out.write("                                            ");

                                                        out.println("(" + time + ") <br>_______________________________________<br>");
                                                    }
                                                    ps.close();
                                                    rs.close();
                                                } catch (Exception msg) {
                                                    out.println("Error in loading question comment: -" + msg);
                                                }
                                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    ");

                                                }
                                            } catch (Exception e) {
                                                out.println("<b style=color:red;>No question found related to your selected topic</b>Ex:" + e);

                                            }
                                        }
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <h4>");
      out.print(QUESTION_YOU_MAY_LIKE);
      out.write("</h4>\r\n");
      out.write("\r\n");
      out.write("                                    ");

                                        ResultSet rs1 = null;
                                        ResultSet rs2 = null;
                                        // ResultSet rs3 = null;
                                        PreparedStatement ps1 = null;
                                        PreparedStatement ps2 = null;
                                        // PreparedStatement ps3 = null;
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

                                            String query1 = "SELECT SQL_CALC_FOUND_ROWS id,(SELECT firstname FROM newuser "
                                                    + "WHERE id = question.id)AS firstname,q_id,(SELECT COUNT(*) FROM answer WHERE q_id = question.q_id) AS tac,"
                                                    + "question,vote,total_view FROM question ORDER BY RAND() LIMIT " + iPageNo + "," + showRows + "";
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
                                            int Vote = 0;
                                            int TotoalAnswerCount = 0;
                                    
      out.write("\r\n");
      out.write("                                    <form>\r\n");
      out.write("\r\n");
      out.write("                                        <input type=\"hidden\" name=\"iPageNo\" value=\"");
      out.print(iPageNo);
      out.write("\">\r\n");
      out.write("                                        <input type=\"hidden\" name=\"cPageNo\" value=\"");
      out.print(cPageNo);
      out.write("\">\r\n");
      out.write("                                        <input type=\"hidden\" name=\"showRows\" value=\"");
      out.print(showRows);
      out.write("\">\r\n");
      out.write("                                        ");


                                            while (rs1.next()) {
                                                Username = rs1.getString("firstname");
                                                userId = rs1.getInt("id");
                                                Vote = rs1.getInt("vote");
                                                TotoalAnswerCount = rs1.getInt("tac");
                                                int total_count = (rs1.getInt("total_view") + 1);
                                                PreparedStatement ps4 = null;
                                                try {
                                                    String countView = "UPDATE question SET total_view = total_view + 1 WHERE q_id =? ";
                                                    ps4 = connection.prepareStatement(countView);
                                                    ps4.setInt(1, rs1.getInt("q_id"));
                                                    ps4.executeUpdate();

                                                } catch (Exception msg) {
                                                    out.println("Error in cound the view" + msg);
                                                }
                                                ps4.close();
                                        
      out.write("\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"boxHeading marginbot10\">\r\n");
      out.write("                                                <a href=\"Answer.jsp?q=");
      out.print(rs1.getString("question").replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(rs1.getInt("q_id"));
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(rs1.getString("question"));
      out.write(" ?</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"questionArea\">\r\n");
      out.write("\r\n");
      out.write("                                                <div class=\"postedBy\">");
      out.print(POSTED_BY);
      out.write(" :<a href=\"profile.jsp?user=");
      out.print(Username.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(userId);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> ");
      out.print(firstName(Username));
      out.write("</a></div>\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <a href=\"javascript:void(0)\" onclick=\"return take_value(this, '");
      out.print(rs1.getInt("q_id"));
      out.write("', 'upvote');\">Upvote(");
      out.print(Vote);
      out.write(")</a>&nbsp;&nbsp;\r\n");
      out.write("                                            <a href=\"javascript:void(0)\" onclick=\"return take_value(this, '");
      out.print(rs1.getInt("q_id"));
      out.write("', 'upvote');\">Downvote</a>&nbsp;&nbsp;\r\n");
      out.write("                                            <a href=\"Answer.jsp?q=");
      out.print(rs1.getString("question").replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(rs1.getInt("q_id"));
      out.write("&sl=");
      out.print(sl);
      out.write("\">Ans(");
      out.print(TotoalAnswerCount);
      out.write(")</a>&nbsp;&nbsp;\r\n");
      out.write("                                            <a href=\"javascript:void(0)\">View(");
      out.print(total_count);
      out.write(")</a>\r\n");
      out.write("                                            <!-- Fetching the Comment on question -->\r\n");
      out.write("                                            <div align=\"right\">\r\n");
      out.write("\r\n");
      out.write("                                                ");

                                                    try {
                                                        PreparedStatement ps = null;
                                                        ResultSet rs = null;
                                                        String sql_question_comment = "SELECT unique_id,user_id,"
                                                                + "(SELECT firstname FROM newuser WHERE id = comments.user_id )AS fullname,"
                                                                + "q_id,comments,time FROM comments WHERE q_id = ? AND user_id IS NOT NULL AND q_id IS NOT NULL";
                                                        ps = connection.prepareStatement(sql_question_comment);
                                                        ps.setInt(1, rs1.getInt("q_id"));
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            String question_comments = rs.getString("comments");
                                                            String userName = rs.getString("fullname");
                                                            String time = rs.getString("time");
                                                            int user_id = rs.getInt("user_id");

                                                            out.println(question_comments + ":- ");
                                                
      out.write("\r\n");
      out.write("                                                <a href=\"profile.jsp?user=");
      out.print(userName.replaceAll(" ", "+"));
      out.write("&ID=");
      out.print(user_id);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(convertStringUpperToLower(userName));
      out.write("</a>\r\n");
      out.write("                                                ");

                                                            out.println("(" + time + ") <br>_______________________________________<br>");
                                                        }
                                                        ps.close();
                                                        rs.close();
                                                    } catch (Exception msg) {
                                                        out.println("Error in loading question comment: -" + msg);
                                                    }
                                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        ");

                                                }  // ps4.close();
                                            } catch (Exception e) {
                                                out.println(e);

                                            }
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        ");

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
                                        
      out.write("\r\n");
      out.write("                                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" >\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td colspan=\"3\">\r\n");
      out.write("                                                    <div>\r\n");
      out.write("                                                        ");

                                                            int i = 0;
                                                            int cPage = 0;
                                                            if (totalRows != 0) {
                                                                cPage = ((int) (Math.ceil((double) endResult / (totalRecords * showRows))));

                                                                int prePageNo = (cPage * totalRecords) - ((totalRecords - 1) + totalRecords);
                                                                if ((cPage * totalRecords) - (totalRecords) > 0) {
                                                        
      out.write("\r\n");
      out.write("                                                        <a href=\"index.jsp?iPageNo=");
      out.print(prePageNo);
      out.write("&cPageNo=");
      out.print(prePageNo);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> << Previous</a>\r\n");
      out.write("                                                        ");

                                                            }
                                                            for (i = ((cPage * totalRecords) - (totalRecords - 1)); i <= (cPage * totalRecords); i++) {
                                                                if (i == ((iPageNo / showRows) + 1)) {
      out.write("\r\n");
      out.write("                                                        <a href=\"index.jsp?iPageNo=");
      out.print(i);
      out.write("&sl=");
      out.print(sl);
      out.write("\" style=\"cursor:pointer;color:red\"><b>");
      out.print(i);
      out.write("</b></a>\r\n");
      out.write("                                                                ");

                                                                } else if (i <= totalPages) {
                                                                
      out.write("\r\n");
      out.write("                                                        <a href=\"index.jsp?iPageNo=");
      out.print(i);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\r\n");
      out.write("                                                        ");

                                                                }
                                                            }
                                                            if (totalPages > totalRecords && i < totalPages) {
                                                        
      out.write("\r\n");
      out.write("                                                        <a href=\"index.jsp?iPageNo=");
      out.print(i);
      out.write("&cPageNo=");
      out.print(i);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> >> Next</a>\r\n");
      out.write("                                                        ");

                                                                }
                                                            }
                                                        
      out.write("\r\n");
      out.write("                                                        <b>Rows ");
      out.print(startResult);
      out.write(" - ");
      out.print(endResult);
      out.write(", Total Rows ");
      out.print(totalRows);
      out.write(" </b>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                    ");

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
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    Fun Zone\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "funZoneList.jsp", out, false);
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                    <div class=\"boxHeading\">\r\n");
      out.write("                                        Education Zone\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div>\r\n");
      out.write("                                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "eduZoneList.jsp", out, false);
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <!--div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                    <div class=\"boxHeading\">\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div>\r\n");
      out.write("//                                    ");

//                                        //String UserName_for_trending_question = null;
//                                        try {
//                                            String v_count = "SELECT * FROM question ORDER BY TotalLiked DESC limit 10";
//                                            preparedStatement = connection.prepareStatement(v_count);
//                                            resultSet = preparedStatement.executeQuery();
//                                            while (resultSet.next()) {
//                                                String TrendingQuestion = resultSet.getString("question");
//                                                int questionID = resultSet.getInt("q_id");
//                                    
      out.write("\r\n");
      out.write("//                                    <a href=\"Answer.jsp?Id=");
      out.write("</a><br><br>\r\n");
      out.write("//                                    ");

//                                            }
//                                        } catch (Exception e) {
//                                            out.println("Error " + e);
//                                        }
//                                    
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        </div-->\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");

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
                                } catch (Exception msg) {
                                    out.println("Error in connection" + msg);
                                }
                                try {
                                    if (resultSet != null || !resultSet.isClosed()) {
                                        try {
                                            resultSet.close();
                                        } catch (Exception e) {
                                            out.println("Exception in closing resulatset " + e);
                                        }
                                    }
                                } catch (Exception msg) {
                                    out.println("Error in connection" + msg);
                                }
                                try {
                                    if (preparedStatement != null || !preparedStatement.isClosed()) {
                                        try {
                                            preparedStatement.close();
                                        } catch (Exception e) {
                                            out.println("Exception in closing preparedStatement " + e);
                                        }
                                    }
                                } catch (Exception msg) {
                                    out.println("Error in connection" + msg);
                                }
                            }
                        
      out.write("\r\n");
      out.write("                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clear-fix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
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
      out.write("</div>\r\n");
      out.write("                                    ");
if (sl.equalsIgnoreCase("hi")) {
      out.write("\r\n");
      out.write("                                    <textarea type=\"text\" class=\"anstext\" id=\"text1\" name=\"question\" placeholder=\"");
      out.print(EX);
      out.write("\" required=\"\"></textarea>\r\n");
      out.write("                                    ");
 } else {
      out.write("\r\n");
      out.write("                                    <textarea type=\"text\" class=\"anstext\" name=\"question\" placeholder=\"");
      out.print(EX);
      out.write("\" required=\"\"></textarea>\r\n");
      out.write("                                    ");
 }
      out.write("\r\n");
      out.write("                                </div>\r\n");
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
      out.write("            <!-- Bootstrap JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("            <!-- Bootstrap Select JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("        </div> <!-- /.main-page-wrapper -->\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("                                                var infolinks_pid = 3191741;\r\n");
      out.write("                                                var infolinks_wsid = 0;\r\n");
      out.write("        </script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"http://resources.infolinks.com/js/infolinks_main.js\"></script>\r\n");
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
