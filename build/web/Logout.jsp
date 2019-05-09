<%
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
%>
<script>
// FB.logout(function(response) {
//  FB.Auth.setAuthResponse(null, 'unknown');
//});
</script>
<%
    session.setAttribute("name", null);
    session.setAttribute("email", null);
    session.setAttribute("Session_id_of_user", null);
    session.invalidate();
    response.sendRedirect("Login.jsp?sl=" + sl + "&msg=logout");
%>
