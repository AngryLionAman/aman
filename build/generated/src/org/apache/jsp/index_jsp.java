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
String DB_AJAX_PATH = "http://localhost:8081/InquiryHere";

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
                                    
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/site.jsp");
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

      out.write("<html lang=\"en\"><head>\r\n");
      out.write("        \r\n");
      out.write("         \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

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
      out.write("        <title>Home Page</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        <meta property=\"og:description\" content=\"india first knowledge based social media where experts give you advise and suggestion related to your query .you can ask and share the information which you want to explore.our motive is to be specific according to your demand\" />\r\n");
      out.write("        <meta property=\"og:image\" content=\"https://www.inquiryhere.com/images/logo/inquiryhere_Logo.PNG\" />\r\n");
      out.write("        <meta property=\"og:type\" content=\"website\">\r\n");
      out.write("        <meta property=\"og:locale\" content=\"en_US\">\r\n");
      out.write("        <meta property=\"og:title\" content=\"india first knowledge based social media platform where experts give you advise and suggestion related to your query\" />\r\n");
      out.write("        <meta property=\"og:url\" content=\"https://www.inquiryhere.com/\">\r\n");
      out.write("        <meta property=\"og:site_name\" content=\"https://www.inquiryhere.com/\" />\r\n");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            ");

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
      out.write("            ");

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
                                                    topic_name = resultSet.getString("topic_name");
                                                    topic_id = resultSet.getInt("unique_id");
                                                    if (topic_id != 0) {
      out.write("\r\n");
      out.write("                                        <li><a href=\"topic.jsp?id=");
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
      out.write("\" data-toggle=\"modal\" data-target=\"#myModal\"></textarea></div>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <h4>");
      out.print(RECENT_POSTED_QUESTION);
      out.write("</h4>\r\n");
      out.write("                                    ");

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
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\">\r\n");
      out.write("                                            <a href=\"Answer.jsp?Id=");
      out.print(question_id);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(TrendingQuestion_T);
      out.write(" ?</a>\r\n");
      out.write("                                           \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"questionArea\">\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"postedBy\">");
      out.print(POSTED_BY);
      out.write(" :<a href=\"profile.jsp?ID=");
      out.print(userID);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> ");
      out.print(UserName_for_trending_question_T);
      out.write("</a>\r\n");
      out.write("                                             &nbsp;&nbsp;&nbsp;&nbsp; \r\n");
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
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                    </div>");

                                            }
                                        } catch (Exception e) {
                                            out.println("Error " + e);
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

                                    
      out.write("\r\n");
      out.write("                                    <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"boxHeading marginbot10\">\r\n");
      out.write("                                            <a href=\"Answer.jsp?Id=");
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
      out.write(" : <a href=\"profile.jsp?ID=");
      out.print(ide);
      out.write("&sl=");
      out.print(sl);
      out.write('"');
      out.write('>');
      out.print(fname);
      out.write("</a></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    ");
             }
                                            }
                                            stmt2.close();
                                            rs2.close();
                                        } catch (Exception e) {
                                            out.println("<b style=color:red;>No question found related to your selected topic</b>");
                                        }
                                    } else {
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <h4>");
      out.print(QUESTION_YOU_MAY_LIKE);
      out.write("</h4>\r\n");
      out.write("\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                                    ");

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
                                        
      out.write("\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"boxHeading marginbot10\">\r\n");
      out.write("                                                <a href=\"Answer.jsp?Id=");
      out.print(rs1.getInt("q_id"));
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(rs1.getString("question"));
      out.write(" ?</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");

                                                String query3 = "SELECT ID,firstname FROM newuser WHERE id='" + rs1.getString("id") + "' ";
                                                ps3 = connection.prepareStatement(query3);
                                                rs3 = ps3.executeQuery();

                                                while (rs3.next()) {
                                                    Username = rs3.getString("firstname");
                                                    userId = rs3.getInt("ID");
                                                    //out.println(fname);
                                                }
                                                rs3.close();
                                                ps3.close();
      out.write("\r\n");
      out.write("                                            <div class=\"questionArea\">\r\n");
      out.write("\r\n");
      out.write("                                                <div class=\"postedBy\">");
      out.print(POSTED_BY);
      out.write(" :<a href=\"profile.jsp?ID=");
      out.print(userId);
      out.write("&sl=");
      out.print(sl);
      out.write("\"> ");
      out.print(Username);
      out.write("</a></div>\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        ");

                                                }
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
      out.write("\r\n");
      out.write("                            <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                <div class=\"boxHeading\">\r\n");
      out.write("                                    ");
      out.print(TRENDING_QUESTION);
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    ");

                                        String UserName_for_trending_question = null;
                                        try {
                                            String v_count = "SELECT * FROM question ORDER BY TotalLiked DESC limit 10";
                                            preparedStatement = connection.prepareStatement(v_count);
                                            resultSet = preparedStatement.executeQuery();
                                            while (resultSet.next()) {
                                                String TrendingQuestion = resultSet.getString("question");
                                                int questionID = resultSet.getInt("q_id");
                                    
      out.write("\r\n");
      out.write("                                    <a href=\"Answer.jsp?Id=");
      out.print(questionID);
      out.write("&sl=");
      out.print(sl);
      out.write("\" >");
      out.print(TrendingQuestion);
      out.write("</a><br><br>\r\n");
      out.write("                                    ");

                                            }
                                        } catch (Exception e) {
                                            out.println("Error " + e);
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
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                        </div>          \r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal fade\" id=\"myModalN\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Modal content-->\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                            <h4 class=\"modal-title\">");
      out.print(YOUR_CURRENT_NODIFICATION);
      out.write("</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "NodificationScript.jsp", out, false);
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
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
