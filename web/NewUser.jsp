
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@include file="site.jsp" %>
<%
    String sl = request.getParameter("sl");
    if (sl == null) {
        sl = "eng";
    }
    String firstname, lastname, password, email;
    firstname = request.getParameter("firstname");
    lastname = request.getParameter("lastname");
    email = request.getParameter("email");
    password = request.getParameter("password");

    if (firstname == null || lastname == null || email == null || password == null) {
        out.println("you can't access this page direcitly");
    } else {
        //Form validation
        /*Email validation*/
        boolean validFirstName = false;
        boolean validLastName = false;
        boolean validPassword = false;
        boolean emailValid = false;

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        if (email.matches(ePattern)) {
            //out.println("<b>"+email+"</b> email is valid");
            emailValid = true;
        }
        /**
         * * ****************
         */
        /*Firstname validation*/
        int length = firstname.length();
        if (length < 25) {
            Pattern p = Pattern.compile("[^A-Za-z0-9]");
            Matcher m = p.matcher(firstname);
            // boolean b = m.matches();
            boolean b = m.find();
            if (b != true) {
                validFirstName = true;
            }
        }

        /**
         * *****************
         */
        /*LastName validation*/
        length = lastname.length();
        if (length < 25) {
            Pattern p = Pattern.compile("[^A-Za-z0-9]");
            Matcher m = p.matcher(lastname);
            // boolean b = m.matches();
            boolean b = m.find();
            if (b != true) {
                validLastName = true;
            }
        }

        /**
         * *****************
         */
        /*Validate password lenght*/
        length = password.length();
        if (length >= 6) {
            validPassword = true;
        }

        /**
         * *****************
         */
        if (validFirstName == true && validLastName == true && validPassword == true && emailValid == true) {
            String Email = request.getParameter("email");
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
                String v_check = "SELECT email FROM newuser WHERE email = '" + Email + "'";
                preparedStatement = connection.prepareStatement(v_check);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {
                    String Stored_email = resultSet.getString("email");
                    if (Stored_email.equals(Email)) {
                        i = 1;
                    }
                }
                if (i == 1) {
                    response.sendRedirect("signup.jsp?sl=" + sl + "&Error=This email is already registered please choose another one");
                } else {
                    try {

                        Statement statement = connection.createStatement();
                        String p = "insert into newuser(firstname,lastname,email,password) values('" + firstname + "','" + lastname + "','" + email + "','" + password + "')";
                        statement.execute(p);
                        if (statement != null) {
                            statement.close();
                        }
                        session.setAttribute("email", email);
                        response.sendRedirect("CompleteProfilefFollowTopic.jsp?sl=" + sl);
                    } catch (Exception e1) {
                        out.print("Error:-" + e1);
                    }
                }
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
        } else {
            out.println("Its seem like you are doing effort to break the site rule"
                    + "<br>Plese follow the procedure ,don't try to be over smart other wise your activity "
                    + "will be recorede for the monitoring purpose");
        }
    }
%>