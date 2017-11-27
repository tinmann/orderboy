<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
       
	
	<link rel="stylesheet" href="css/style.css" />
	
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
           
        </head>
        <body>
        <h5 style="text-align: center;"> Login Form </h5>
        <br/>
         <br/>
   <p>
            <form:form id="loginForm" modelAttribute="userPojo" action="/loginUser" method="post" class= "owl-theme">
                <table align="center">
                    <tr class="single_abouts wow">
                        <td class = "main_menu_bg">
                            <form:label path="id" class="animated">User ID: </form:label>
                        </td>
                        <td>
                            <form:input path="loginId" name="userId" id="userId" />
                            
                        </td>
                        <td><form:errors path="loginId" style="color: red;"></form:errors></td>
                    </tr>
                    <tr class="single_abouts wow">
                        <td class = "main_menu_bg">
                            <form:label path="password" class="animated">Password:</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                        <td><form:errors path="password" style="color: red;"></form:errors></td>
                    </tr>
                
                    <tr class="single_abouts wow">
                        <td></td>
                        <td align="left">
                            <form:button id="login" name="login">Login</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                    <td></td>
                    <td>
                   <span style="color: red;"> ${errorMessage}</span> 
                    </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><a href="home.jsp">Home</a>
                        <a href="/userDetails">New User Registration</a>
                        </td>
                    </tr>
                </table>
            </form:form>
            </p>
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
        </body>
        </html>