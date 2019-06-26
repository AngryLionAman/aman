<%
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "en";
    }
%> 
<!-- Footer ______________________________ -->
<footer>     	
    <div class="container">
        <div class="clear-fix">						
            <div class="row ">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="float-right reserved">
                        © 2019 
                    </div>
                    <div class="float-right reserved">
                        <a href="AboutUs.jsp?sl=<%=sl%>" style="color: white;">About Us</a>   &nbsp;&nbsp; 
                    </div>
                    <div class="float-right reserved">
                        <a href="ContactUs.jsp?sl=<%=sl%>" style="color: white;">Contact Us</a> &nbsp;&nbsp;
                    </div>
                    <div class="float-right reserved">
                        <a href="privacy.jsp?sl=<%=sl%>" style="color: white;">Privacy Policy</a> &nbsp;&nbsp;
                    </div>
                    <div class="float-right reserved">
                        <a href="terms.jsp?sl=<%=sl%>" style="color: white;">Terms</a> &nbsp;&nbsp;
                    </div>
                    <div class="float-right reserved">
                        <a href="index.jsp?sl=<%=sl%>" style="color: white;">Home</a> &nbsp;&nbsp;
                    </div>
                </div>
            </div>
        </div> 
    </div> 
</footer>