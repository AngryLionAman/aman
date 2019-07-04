<%
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
%>
<%
    Cookie[] cookies= request.getCookies();
     //check null because there are chances that there are no cookies
     if(cookies !=null)
     {
       for(int i=0 ;i<cookies.length;i++ )
       {
         Cookie cookie = cookies[i];
         if(cookie.getName().equals("username-cookie"))
         {
         cookie.setMaxAge(0);
            response.addCookie(cookie);
         }
         if(cookie.getName().equals("password-cookie"))
         {
         cookie.setMaxAge(0);
            response.addCookie(cookie);
         }
       }
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
