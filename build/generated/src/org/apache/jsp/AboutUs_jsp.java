package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AboutUs_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
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
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <!-- For IE -->\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- For Resposive Device -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <title>About Us | InquiryHere.com</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <!-- responsive style sheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\">\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write('\r');
      out.write('\n');

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
        AUTHOR_DESCRIPTION = "Programmer and writer: Aman Kumar <br> Co-author: Pankaj Kumar Finance By: Lalan Singh, Pankaj Kumar ";
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-page-wrapper\">\r\n");
      out.write("            <!-- Header _________________________________ -->\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
      out.write("            <div class=\"bodydata\">\r\n");
      out.write("                <div class=\"container clear-fix\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                         <div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                ");
      out.print(WELCOME_NOTES);
      out.write("\r\n");
      out.write("                                            </div><br>\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                               ");
      out.print(DESCRIPTION);
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                ");
      out.print(HOW_IT_WORK);
      out.write("\r\n");
      out.write("                                            </div><br>\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                               ");
      out.print(HOW_IT_WORK_DESCRIPTION);
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                ");
      out.print(MOTO);
      out.write("\r\n");
      out.write("                                            </div><br>\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                               ");
      out.print(MOTO_DESCRIPTION);
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                ");
      out.print(HELP_US);
      out.write("\r\n");
      out.write("                                            </div><br>\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                               ");
      out.print(HELP_US_DESCRIPTION);
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                ");
      out.print(NEED_HELP);
      out.write("\r\n");
      out.write("                                            </div><br>\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                               ");
      out.print(NEED_HELP_DESCRIPTION);
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                        <div class=\"themeBox\" style=\"height:auto;\">\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                                ");
      out.print(AUTHOR);
      out.write("\r\n");
      out.write("                                            </div><br>\r\n");
      out.write("                                            <div class=\"boxHeading\">\r\n");
      out.write("                                               ");
      out.print(AUTHOR_DESCRIPTION);
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clear-fix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clear-fix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clear-fix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clear-fix\"></div>\r\n");
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
      out.write("             ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sl", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(sl), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/jquery-2.1.4.js\"></script>\r\n");
      out.write("            <!-- Bootstrap JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("            <!-- Bootstrap Select JS -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"vendor/bootstrap-select/dist/js/bootstrap-select.js\"></script>\r\n");
      out.write("        </div> \r\n");
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
