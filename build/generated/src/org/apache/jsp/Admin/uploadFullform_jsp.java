package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class uploadFullform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <script src=\"../ckeditor/ckeditor.js\"></script>\n");
      out.write("        <title>Upload the FullForm</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Upload Short word and its full form technical and non technical !</h1>\n");
      out.write("    <center>\n");
      out.write("         <form name=\"save_full_form\" method=\"post\" action=\"saveFullForm.jsp\">\n");
      out.write("             Short Word: <input type=\"text\" name=\"shord_word\" required=\"\" /><br><br>\n");
      out.write("             Full form: <input type=\"text\" name=\"full_form\" required=\"\" /><br><br>\n");
      out.write("            <select name=\"category\">\n");
      out.write("                <option>null</option>\n");
      out.write("                <option>education</option>\n");
      out.write("                <option selected=\"\">defence</option>\n");
      out.write("                <option>technical</option>\n");
      out.write("                <option>fun</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" value=\"Save full form\"> \n");
      out.write("         </form> \n");
      out.write("    </center>\n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
