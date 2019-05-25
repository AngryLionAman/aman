package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SearchBar_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    public boolean foundSpace(String str) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(str);
        boolean found = matcher.find();
        return found;
    }


    public List<String> searchWordProcess(String RealValue) {
        List<String> WordForSearching = new ArrayList();
        try {
            String RemoveFromBack = RealValue;
            WordForSearching.add(RealValue);
            if (foundSpace(RemoveFromBack)) {
                while (foundSpace(RemoveFromBack)) {
                    RemoveFromBack = RemoveFromBack.substring(0, RemoveFromBack.lastIndexOf(" "));
                    if (!WordForSearching.contains(RemoveFromBack)) {
                        WordForSearching.add(RemoveFromBack);
                    }
                }
            }
            //Remove from last opposite
            String RemoveFromFront = RealValue;
            if (foundSpace(RemoveFromFront)) {
                while (foundSpace(RemoveFromFront)) {
                    RemoveFromFront = RemoveFromFront.substring(RemoveFromFront.indexOf(32) + 1, RemoveFromFront.length());
                    if (!WordForSearching.contains(RemoveFromFront)) {
                        WordForSearching.add(RemoveFromFront);
                    }

                }
            }
            //Split the word by space
            String SplitWordBySapce = RealValue;
            if (foundSpace(SplitWordBySapce)) {
                String[] word = SplitWordBySapce.split(" ");
                for (String obj : word) {
                    if (!WordForSearching.contains(obj)) {
                        WordForSearching.add(obj);
                    }

                }
            }
        } catch (Exception msg) {
            //out.println(msg);
        }
        return WordForSearching;
    }

             String YOUR_ACTIVITY = "";
            String QUESTION = "";
            String ANSWER = "";
            String TOPIC = "";
            String USER_PROFILE = "";
            String ANS = "";
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/site.jsp");
    _jspx_dependants.add("/validator.jsp");
    _jspx_dependants.add("/wordProcessing.jsp");
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
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        \r\n");
      out.write("         \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
      out.write('\n');
      out.write('\n');
      out.write("\r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

    //We can also define as 
// String[] NotSearchableString = {"who", "what", "when", "where", "why", "whome", "whose", "which", "how", "is",
//        "my", "you", "your", "mine"};
//    int SizeOfNotSearchableString = NotSearchableString.length;
//Or we can use like this
//    List<String> notSearchableString = new ArrayList();
//    notSearchableString.add("is");
//    notSearchableString.add("am");
//    notSearchableString.add("are");

      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
            String sl = request.getParameter("sl");
            if (sl == null) {
                sl = "en";
            }
            if (sl.equalsIgnoreCase("hi")) {
                YOUR_ACTIVITY = "आपकी गतिविधि";
                QUESTION = "प्रश्न";
                ANSWER = "उत्तर";
                TOPIC = "विषय";
                USER_PROFILE = "उपयोगकर्ता प्रोफ़ाइल";
                ANS = "उत्तर";

            } else {
                YOUR_ACTIVITY = "Your Activity";
                QUESTION = "Question";
                ANSWER = "Answer";
                TOPIC = "Topic";
                USER_PROFILE = "User Profile";
                ANS = "Ans";
            }
        
      out.write("\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <title>Search | InquiryHere.com</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            function take_value(str) {\r\n");
      out.write("                //document.getElementById(\"demo\").innerHTML = \"Welcome\" + firstname+lastname;\r\n");
      out.write("\r\n");
      out.write("                var http = new XMLHttpRequest();\r\n");
      out.write("                http.open(\"POST\", \"");
      out.print(DB_AJAX_PATH);
      out.write("/SearchHint.jsp?str=\" + str, true);\r\n");
      out.write("                http.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                http.send();\r\n");
      out.write("\r\n");
      out.write("                http.onload = function () {\r\n");
      out.write("                    http.responseText;\r\n");
      out.write("                    document.getElementById(\"demo\").innerHTML = http.responseText;\r\n");
      out.write("                    //alert(http.responseText);\r\n");
      out.write("                };\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
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
                        int CurrentuserId = 0;
                        Connection connection = null;
                        ResultSet rs2 = null;
                        ResultSet resultSetQuestion = null;
                        ResultSet resultSetAnswer = null;
                        //ResultSet resultSet = null;
                        ResultSet resultSetTopic = null;
                        ResultSet resultSetUser = null;
                        //PreparedStatement preparedStatement = null;
                        PreparedStatement ps2 = null;
                        PreparedStatement preparedStatementQuestion = null;
                        PreparedStatement preparedStatementAnswer = null;
                        PreparedStatement preparedStatementTopic = null;
                        PreparedStatement preparedStatementUser = null;
                        try {
                            if (connection == null || connection.isClosed()) {
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException ex) {
                                    out.println("Exception in loading the class forname Driver" + ex);
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
                    
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(ex), request.getCharacterEncoding()), out, false);

                            }
                            connection = DriverManager.getConnection(DB_URL_, DB_USERNAME_, DB_PASSWORD_);
                        }
                    
      out.write("\r\n");
      out.write("                    ");

                        int totalRowsquestion = 0;
                        int totalRowsAnswer = 0;
                        int totalRowsTopic = 0;
                        int totalRowsUser = 0;
                        List<String> SearchValue = searchWordProcess(convertStringUpperToLower(request.getParameter("search")).toLowerCase());

                        Iterator itr = SearchValue.iterator();
                        try { //For the question count 
                            String Q = "SELECT * FROM question WHERE lower(question) LIKE '%" + SearchValue.get(0) + "%'";
                            while (itr.hasNext()) {
                                Q += " OR lower(question) LIKE '%" + itr.next() + "%'";
                            }
                            Q += ";";
                            preparedStatementQuestion = connection.prepareStatement(Q);
                            resultSetQuestion = preparedStatementQuestion.executeQuery();
                            String query2 = "SELECT FOUND_ROWS() as cnt";
                            ps2 = connection.prepareStatement(query2);
                            rs2 = ps2.executeQuery();

                            try {
                                if (rs2.next()) {
                                    totalRowsquestion = rs2.getInt("cnt");
                                }
                            } catch (Exception msg) {
                                out.println(msg);
                            }
                        } catch (Exception msg) {
                            out.println(msg);
                        }
                        try {//For Answer count and resultset value
                            String Q_a = "Select q.question,q.q_id, substring(ans.answer,1,500) "
                                    + "from question q right join answer ans on ans.q_id = q.q_id where lower(answer) LIKE '%" + SearchValue.get(0) + "%'";
                            while (itr.hasNext()) {
                                Q_a += " or lower(answer) LIKE '%" + itr.next() + "%'";
                            }
                            // Q_a += ";";
                            preparedStatementAnswer = connection.prepareCall(Q_a);
                            resultSetAnswer = preparedStatementAnswer.executeQuery();
                            String query2 = "SELECT FOUND_ROWS() as cnt";
                            ps2 = connection.prepareStatement(query2);
                            rs2 = ps2.executeQuery();

                            try {
                                if (rs2.next()) {
                                    totalRowsAnswer = rs2.getInt("cnt");
                                }
                            } catch (Exception msg) {
                                out.println(msg);
                            }
                        } catch (Exception msg) {
                            out.println(msg);
                        }
                        try {//For Topic count and resultset value
                            String T = "SELECT * FROM topic WHERE lower(topic_name) LIKE '%" + SearchValue.get(0) + "%'";
                            while (itr.hasNext()) {
                                T += " or lower(topic_name) LIKE '%" + itr.next() + "%'";
                            }
                            preparedStatementTopic = connection.prepareStatement(T);
                            resultSetTopic = preparedStatementTopic.executeQuery();
                            String query2 = "SELECT FOUND_ROWS() as cnt";
                            ps2 = connection.prepareStatement(query2);
                            rs2 = ps2.executeQuery();

                            try {
                                if (rs2.next()) {
                                    totalRowsTopic = rs2.getInt("cnt");
                                }
                            } catch (Exception msg) {
                                out.println(msg);
                            }
                        } catch (Exception msg) {
                            out.println(msg);
                        }
                        try {//For User count and resultset value
                            String SQL_T = "SELECT * FROM newuser WHERE lower(firstname) LIKE '%" + SearchValue.get(0) + "%' ";
                            while (itr.hasNext()) {
                                SQL_T += " OR lower(firstname) LIKE '%" + itr.next() + "%'";
                            }
                            preparedStatementUser = connection.prepareStatement(SQL_T);
                            resultSetUser = preparedStatementUser.executeQuery();
                            String query2 = "SELECT FOUND_ROWS() as cnt";
                            ps2 = connection.prepareStatement(query2);
                            rs2 = ps2.executeQuery();

                            try {
                                if (rs2.next()) {
                                    totalRowsUser = rs2.getInt("cnt");
                                }
                            } catch (Exception msg) {
                                out.println(msg);
                            }
                        } catch (Exception msg) {
                            out.println(msg);
                        }


                    
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"themeBox\" style=\"min-height:available\">\r\n");
      out.write("                                    <div class=\"boxHeading\">\r\n");
      out.write("                                        ");
      out.print(YOUR_ACTIVITY);
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div>\r\n");
      out.write("                                        <a href=\"SearchBar.jsp?value=Question&search=");
      out.print(request.getParameter("search"));
      out.write('"');
      out.write('>');
      out.print(QUESTION);
      out.write(' ');
      out.write('(');
      out.print(totalRowsquestion);
      out.write(")</a><br>\r\n");
      out.write("                                        <a href=\"SearchBar.jsp?value=Answer&search=");
      out.print(request.getParameter("search"));
      out.write('"');
      out.write('>');
      out.print(ANSWER);
      out.write(' ');
      out.write('(');
      out.print(totalRowsAnswer);
      out.write(")</a><br>\r\n");
      out.write("                                        <a href=\"SearchBar.jsp?value=Topic&search=");
      out.print(request.getParameter("search"));
      out.write('"');
      out.write('>');
      out.print(TOPIC);
      out.write(' ');
      out.write('(');
      out.print(totalRowsTopic);
      out.write(")</a><br>\r\n");
      out.write("                                        <a href=\"SearchBar.jsp?value=UserProfile&search=");
      out.print(request.getParameter("search"));
      out.write('"');
      out.write('>');
      out.print(USER_PROFILE);
      out.write(' ');
      out.write('(');
      out.print(totalRowsUser);
      out.write(")</a><br>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;margin-bottom:0px;\">\r\n");
      out.write("                                            <p id=\"demo\"></p>\r\n");
      out.write("                                            ");

                                                String ParametrVariable = request.getParameter("value");
                                                if (ParametrVariable == null) {
                                                    ParametrVariable = "Question";
                                                }
                                                if (ParametrVariable != null && SearchValue != null) {
                                                    if (ParametrVariable.equals("Question")) {
                                                        out.println("<center><div class=boxHeading>" + QUESTION + "</div></center>");
                                                        try {
                                                            String Question_asked_by_user;
                                                            //String SearchValue_Case_Converted = SearchValue;

                                                            boolean count = true;
                                                            while (resultSetQuestion.next()) {
                                                                count = false;
                                                                Question_asked_by_user = resultSetQuestion.getString("question");
                                                                int question_id = resultSetQuestion.getInt("q_id");
                                            
      out.write(" <br>Q. <a href=\"Answer.jsp?Id=");
      out.print(question_id);
      out.write("\" ><h6>");
      out.print(Question_asked_by_user);
      out.write(" ?</h6></a>");

                                                }
                                                resultSetQuestion.close();;
                                                preparedStatementQuestion.close();
                                                if (count) {
                                                    out.println("No related question found");
                                                }
                                            } catch (Exception e1) {
                                                out.println("Error in Question search : " + e1);
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
                                            
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(e1), request.getCharacterEncoding()), out, false);

                                                    }
                                                }
                                                //Staring answer programming....................................................
                                                if (ParametrVariable.equals("Answer")) {
                                                    out.println("<center><div class=boxHeading>" + ANSWER + "</div></center>");
                                                    try {
                                                        String Answer_given_by_user;
                                                        //int Question_id = 0;
                                                        //String SearchValue_Case_Converted = SearchValue.toLowerCase();

                                                        boolean count = true;
                                                        while (resultSetAnswer.next()) {
                                                            count = false;
                                                            Answer_given_by_user = resultSetAnswer.getString("substring(ans.answer,1,500)");
                                                            String Question_by_user = resultSetAnswer.getString("question");
                                                            int question_id = resultSetAnswer.getInt("q.q_id");
                                            
      out.write("<br> Q. <a href=\"Answer.jsp?q=");
      out.print(Question_by_user.replaceAll(" ", "-"));
      out.write("&Id=");
      out.print(question_id);
      out.write("\" >");
      out.print(Question_by_user);
      out.write(" ?</a>");

                                                    out.println("<br>Ans.</b>&nbsp;&nbsp;&nbsp;&nbsp;" + Answer_given_by_user);

                                                }
                                                resultSetAnswer.close();
                                                preparedStatementAnswer.close();
                                                if (count) {
                                                    out.println("No related answer found");
                                                }
                                            } catch (Exception e2) {
                                                out.println("Error in Answer search : " + e2);
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
                                            
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ExceptionCollector.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userName", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(email), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userID", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(CurrentuserId), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("URLParameter", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(URL), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ExceptionMessage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(e2), request.getCharacterEncoding()), out, false);

                                                    }
                                                }
                                                //Starting the topic search program

                                                if (ParametrVariable.equals("Topic")) {
                                                    out.println("<center><div class=boxHeading>" + TOPIC + "</div></center>");
                                                    try {
                                                        //String SearchValue_Case_Converted = SearchValue.toLowerCase();

                                                        int count_ = 1;
                                                        boolean count = true;
                                                        while (resultSetTopic.next()) {
                                                            count = false;
                                                            String Topic_assgned_by_user = convertStringUpperToLower(resultSetTopic.getString("topic_name"));
                                                            int selected_topic_id = resultSetTopic.getInt("unique_id");
                                                            out.print("<br><br>" + count_++ + "<b>&nbsp;&nbsp;<a href=topic.jsp?t=" + Topic_assgned_by_user.replaceAll(" ", "+") + "&id=" + selected_topic_id + ">" + Topic_assgned_by_user + "</a></b>");

                                                        }
                                                        resultSetTopic.close();
                                                        preparedStatementTopic.close();
                                                        if (count) {
                                                            out.println("No related topic found");
                                                        }
                                                        out.println("<br><br><a href=FollowMoreTopic.jsp>For more topic</a>");
                                                    } catch (Exception e) {
                                                        out.println("Error in Topic Search:" + e);
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
                                                }
                                                //Satring the userprofile search option

                                                if (ParametrVariable.equals("UserProfile")) {
                                                    out.println("<center><div class=boxHeading> " + USER_PROFILE + " </div></center>");
                                                    try {
                                                        String StoredUserFirstName;
                                                        int StoredUserID;
                                                        //String SearchValue_Case_Converted = SearchValue.toLowerCase();
//                                                        String SQL_T = "SELECT * FROM newuser WHERE lower(firstname) LIKE '%" + SearchValue.get(0) + "%' ";
//                                                        while (itr.hasNext()) {
//                                                            SQL_T += " OR lower(firstname) LIKE '%" + itr.next() + "%'";
//                                                        }
//                                                        preparedStatement = connection.prepareStatement(SQL_T);
//                                                        resultSet = preparedStatement.executeQuery();
                                                        int count_ = 1;
                                                        boolean count = true;
                                                        while (resultSetUser.next()) {
                                                            count = false;
                                                            StoredUserID = resultSetUser.getInt("ID");
                                                            StoredUserFirstName = convertStringUpperToLower(resultSetUser.getString("firstname"));
                                                            out.print("<br><br>" + count_++ + "<b>&nbsp;&nbsp;<a href=profile.jsp?user=" + StoredUserFirstName.replaceAll(" ", "+") + "&ID=" + StoredUserID + ">" + StoredUserFirstName + " </a></b>");

                                                        }
                                                        resultSetUser.close();
                                                        preparedStatementUser.close();
                                                        if (count) {
                                                            out.println("No related user profile found");
                                                        }
                                                        out.println("<br><br><a href=UserProfile.jsp>For more user</a>");
                                                    } catch (Exception e) {
                                                        out.println("Error in User profile search:" + e);
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
                                                    }

                                                }//IF statement closed here
                                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            ");

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
//                                                    try {
//                                                        if (resultSet != null || !resultSet.isClosed()) {
//                                                            try {
//                                                                resultSet.close();
//                                                            } catch (Exception e) {
//                                                                out.println("Exception in closing resulatset " + e);
//                                                            }
//                                                        }
//                                                    } catch (Exception error) {
//                                                        out.println(error);
//                                                    }
//                                                    try {
//                                                        if (preparedStatement != null || !preparedStatement.isClosed()) {
//                                                            try {
//                                                                preparedStatement.close();
//                                                            } catch (Exception e) {
//                                                                out.println("Exception in closing preparedStatement " + e);
//                                                            }
//                                                        }
//                                                    } catch (Exception error) {
//                                                        out.println(error);
//                                                    }
                                                }
                                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"clear-fix\"></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row margintop10\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- j Query -->\r\n");
      out.write("                ");
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
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("                <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("                <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("            </div> <!-- /.main-page-wrapper -->\r\n");
      out.write("    </body>\r\n");
      out.write(" </html>");
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
