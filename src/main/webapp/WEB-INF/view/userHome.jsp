<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	
	<link rel="stylesheet" href="css/style.css" />
	
    <head>
    </head>
    <body>
        <h3 style="text-align: center;">Welcome!!! Enter The User Details</h3>
        <br/>
        <br/>
        <form:form method="POST" action="/addUserDetails" modelAttribute="userDetailsPojo">
             <table align="center">
                
                
                 <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName"/></td>
                    <td><form:errors path="firstName" style="color: red;"></form:errors></td>
                </tr>               
                
              <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td><form:input path="lastName"/></td>
                    <td><form:errors path="lastName" style="color: red;"></form:errors></td>
                </tr>
                <tr>
                    <td><form:label path="type">Type</form:label></td>
                    <td>
                    <form:select path="type" selected="type">
                        <%-- <form:options items="${typeList}" /> --%>
                       <option value="">--- Select ---</option>
                       <option value="Dealer">Dealer</option>
                       <option value="Retailer">Retailer</option>
                        </form:select>
                    </td>
                    <td><form:errors path="type" style="color: red;"></form:errors></td>
                </tr>
                 <tr>
                    <td><form:label path="userPojo.password">Password</form:label></td>
                    <td><form:password path="userPojo.password"/></td>
                    <td><form:errors path="userPojo.password" style="color: red;"></form:errors></td>
                </tr>  
                
                <form:hidden path="userPojo.loginId" value ="1"/>
                
              
                
                <tr>
                    <td></td>
                        <td align="left">
                        <input type="submit" value="Submit"/></td>
                </tr>
                <tr>
                <td></td>
                <td><a href="home.jsp">Home</a>
                        <a href="/loginUserForm">Login</a>
                        </td>
                 </tr>
            </table>
        </form:form>
    </body>
</html>