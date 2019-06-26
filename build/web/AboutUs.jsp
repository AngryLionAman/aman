<html lang="en">
    <head>
        <script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
  (adsbygoogle = window.adsbygoogle || []).push({
    google_ad_client: "ca-pub-8778688755733551",
    enable_page_level_ads: true
  });
</script>
        <meta charset="UTF-8">
        <!-- For IE -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- For Resposive Device -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>About Us | InquiryHere.com</title>

        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- responsive style sheet -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%!
    String WELCOME_NOTES = "";        
    String DESCRIPTION = "";
    String HOW_IT_WORK = "";
    String HOW_IT_WORK_DESCRIPTION = "";
    String MOTO = "";
    String MOTO_DESCRIPTION = "";
    String HELP_US ="";
    String HELP_US_DESCRIPTION ="";
    String NEED_HELP = "";
    String NEED_HELP_DESCRIPTION = "";
    String AUTHOR = "";
    String AUTHOR_DESCRIPTION = "";
%>
<%
    //String page_name = request.getParameter("page");
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
    if (sl.equalsIgnoreCase("hi")) {
        WELCOME_NOTES = "inquiryhere.com में आपकी रुचि के लिए धन्यवाद";
        DESCRIPTION = "inquiryhere.com एक free online प्रश्न और उत्तर का website हैं जिसका मकसद हैं हमारे अंदर के अनंत ज्ञान को बढ़ावा देना और अंदर छुपे हुए कला को दुनिया को दिखाना ताकि लोग उस ज्ञान को पढ़े और आपकी कदर करे। क्यूकी हमे विश्वास करते हियँ जानकारी बाटने में क्यूकी ज्ञान बाटकर ही हम दुनिये को सीक्तिछ केर सकते हैं।जैसे की हमलोग जानते हैं ,ज्ञान बाटने से ज्ञान बढ़ता ही हैं।";
        HOW_IT_WORK = "ये काम कैसे करता है"; 
        HOW_IT_WORK_DESCRIPTION = "अगर कोई व्यक्ति सवाल पूछता हैं तो उसके बाद दूसरा व्यक्ति उसका जवाब देता हैं जो की उस topic के  बारे में बखूबी जानते हैं।और हमारे website community के अंदर बहुत से expert हैं आपने आपने field के। हमरे एक्सपर्ट यूजर को सरल और आसान उत्तेर देते हैं जो की आसानी से समझ में आ जाये और वो उसी भासा में जवाब देते हीं जिस भासा में यूजर ने पूछा हैं। ";
        MOTO = "मकसद";
        MOTO_DESCRIPTION = "ये वेबसाइट दो भाषा में बनाया गया हियँ ,ज्यादातर आसान  हिंदी पे ध्यान दिए गया हैं ताकि यूजर को सरल और आसान उत्तर मिल सके।";
        HELP_US = "हमारी मदद करें";
        HELP_US_DESCRIPTION = "यदि आपको साइट के साथ कोई समस्या और सुझाव है, तो कृपया हमसे संपर्क करें फ़ॉर्म पर हमें बताएं";
        NEED_HELP = "मदद चाहिए ?";
        NEED_HELP_DESCRIPTION = "यदि आपको इस वेबसाइट से संबंधित किसी भी प्रकार की सहायता की आवश्यकता है, तो कृपया हमें सहायता फ़ॉर्म पर बताएं। हम हमेशा आपके लिए रहेंगे। हमें आपकी मदद करने में खुशी होगी।";
        AUTHOR = "लेखक";
        AUTHOR_DESCRIPTION = "प्रोग्रामर और लेखक : अमन कुमार <br> सह लेखक : पंकज कुमार <br> द्वारा वित्त : ललन सिंह ,पंकज कुमार";
    } else {
        WELCOME_NOTES = "Thanks for your interest in Inquiryhere.com";
        DESCRIPTION = "inquiryhere.com is a free online question and answer website whose purpose is to promote endless knowledge inside us and show the hidden art to the world so that people can read that knowledge and appreciate you. We believe that we can only make the world alive by knowing the knowledge of cuking knowledge.As we know, knowledge increases by enlightening knowledge.";
        HOW_IT_WORK = "How it work";
        HOW_IT_WORK_DESCRIPTION = "If a person asks questions, then the other person answers him, who knows the subject well.And there are many experts inside our website community. Our Expert gives simple and easy stimulation to the user who can be easily understood and in the same language as the user who has asked for it.";
        MOTO = "Our moto";
        MOTO_DESCRIPTION = "These websites have been created in two languages, mostly on easy Hindi, so that users can get simple and easy answers.";
        HELP_US = "Help us";
        HELP_US_DESCRIPTION = "if you have any problem and suggestion with site ,please let us know on contact us form";
        NEED_HELP = "You need help?";
        NEED_HELP_DESCRIPTION = "if you need any type of help related to this website ,please let us know on the help form.we will always there for you.we will happy to help you.";
        AUTHOR = "Author";
        AUTHOR_DESCRIPTION = "Programmer and writer: Aman Kumar <br> Co-author: Pankaj Kumar<br> Finance By: Lalan Singh, Pankaj Kumar ";
    }
%>

    </head>

    <body>
        <div class="main-page-wrapper">
            <!-- Header _________________________________ -->
            <jsp:include page="header.jsp">
                <jsp:param name="sl" value="<%=sl%>"></jsp:param>
            </jsp:include>
            <div class="clear-fix"></div>
            <div class="bodydata">
                <div class="container clear-fix">
                    <div class="row">
                         <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="themeBox" style="height:auto;">
                                            <div class="boxHeading">
                                                <%=WELCOME_NOTES%>
                                            </div><br>
                                            <div class="boxHeading">
                                               <%=DESCRIPTION%>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="themeBox" style="height:auto;">
                                            <div class="boxHeading">
                                                <%=HOW_IT_WORK%>
                                            </div><br>
                                            <div class="boxHeading">
                                               <%=HOW_IT_WORK_DESCRIPTION%>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="themeBox" style="height:auto;">
                                            <div class="boxHeading">
                                                <%=MOTO%>
                                            </div><br>
                                            <div class="boxHeading">
                                               <%=MOTO_DESCRIPTION%>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="themeBox" style="height:auto;">
                                            <div class="boxHeading">
                                                <%=HELP_US%>
                                            </div><br>
                                            <div class="boxHeading">
                                               <%=HELP_US_DESCRIPTION%>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="themeBox" style="height:auto;">
                                            <div class="boxHeading">
                                                <%=NEED_HELP%>
                                            </div><br>
                                            <div class="boxHeading">
                                               <%=NEED_HELP_DESCRIPTION%>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="themeBox" style="height:auto;">
                                            <div class="boxHeading">
                                                <%=AUTHOR%>
                                            </div><br>
                                            <div class="boxHeading">
                                               <%=AUTHOR_DESCRIPTION%>
                                            </div>
                                        </div>
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
            <%@include file="notificationhtml.jsp" %>
             <jsp:include page="footer.jsp">
                <jsp:param name="sl" value="<%=sl%>"/>
            </jsp:include>
            <script type="text/javascript" src="vendor/jquery-2.1.4.js"></script>
            <!-- Bootstrap JS -->
            <script type="text/javascript" src="vendor/bootstrap/bootstrap.min.js"></script>
            <!-- Bootstrap Select JS -->
            <script type="text/javascript" src="vendor/bootstrap-select/dist/js/bootstrap-select.js"></script>
        </div> 
    </body>
</html>