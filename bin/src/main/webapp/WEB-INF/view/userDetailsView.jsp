<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	
	<link rel="stylesheet" href="css/style.css" />
	
    <head>
    </head>
    <body>
        <h5 style="text-align: center;">Submitted User Information</h5>
        <br/>
        <br/>
    <table align="center">
        <tr>
            <td>First Name :</td>
            <td>${firstName}</td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td>${lastName}</td>
        </tr>
        <tr>
            <td>Type :</td>
            <td>${type}</td>
        </tr>
        <tr>
            <td>Password :</td>
            <td>${password}</td>
        </tr>
    </table>
    <%-- <p>${userObj.firstName}
     ${userObj.lastName}
      ${userObj.type}
       ${userObj.userPojo.password}
    </p> --%>
    <p align="center"><b>Please note your USERID = ${userObj.loginId} for your future Transactions.</b></p>
    <br>
    <br/>
    <p  align="center"> <a href="/loginUserForm">Login</a></p>
        
    </body>
</html>