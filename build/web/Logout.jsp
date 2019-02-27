<%
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
%>

<%
    session.setAttribute("name", null);
    session.setAttribute("email", null);
    session.setAttribute("Session_id_of_user", null);
    session.invalidate();
    response.sendRedirect("Login.jsp?sl=" + sl + "&msg=logout");
%>
