<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
			<link rel="stylesheet" href="css/bootstrap.min.css" />				
			<link rel="stylesheet" href="css/paper-kit.css" />	
			<link rel="stylesheet" href="css/nucleo-icons.css" />
			<link href='http://fonts.googleapis.com/css?family=Montserrat:400,300,700' rel='stylesheet' type='text/css'>
			<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
	        <head>
	            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	            <title>Login</title>	           
	        </head>
	        <body>	
	        <nav class="navbar navbar-expand-md fixed-top navbar-transparent">
        	<div class="container">
			<div class="navbar-translate">
	            <button class="navbar-toggler navbar-toggler-right navbar-burger" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-bar"></span>
					<span class="navbar-toggler-bar"></span>
					<span class="navbar-toggler-bar"></span>
	            </button>
	            <a class="navbar-brand" href="home.jsp">OrderBoy</a>
			</div>
			<div class="collapse navbar-collapse" id="navbarToggler">
	            <ul class="navbar-nav ml-auto">
					<li class="nav-item">
	                    <a href="userDetails" class="nav-link"><i class="nc-icon nc-badge"></i>Registration</a>
	                </li>
	                <li class="nav-item">
	                    <a href="#" target="_blank" class="nav-link"><i class="nc-icon nc-book-bookmark"></i>  Usermanual</a>
	                </li>
	            </ul>
	        </div>
		</div>
    </nav>
     <form:form id="loginForm" modelAttribute="userPojo" action="/loginUser" method="post">
	    <div class="wrapper">
	        <div class="page-header" style="background-image: url('../img/worldmap.jpg');">
	            <div class="filter"></div>
	                <div class="container">
	                    <div class="row">
	                        <div class="col-lg-4 ml-auto mr-auto">
	                            <div class="card card-register">
	                                <h3 class="title">Welcome</h3>									
	                                <form class="register-form">
	                                    <label>User ID</label>
	                                    <form:input path="loginId" name="userId" id="userId" type="text" class="form-control" placeholder="User ID" />
										<form:errors path="loginId" style="color: red;" />
	                                    <label>Password</label>
	                                    <form:input path="password" name="password" id="password" type="password" class="form-control" placeholder="Password" />
	                                    <form:errors path="password" style="color: red;" />
	                                    <form:button class="btn btn-danger btn-block btn-round">Login</form:button>
	                                </form>
	                                <div class="forgot">
	                                    <a href="#" class="btn btn-link btn-danger">Forgot password?</a>
	                                </div>
	                                <span class="label label-danger" style="align-content: center;"> ${errorMessage}</span> 	                                
	                            </div>
	                        </div>
	                    </div>						
	                </div>
		        </div>
		    </div>
	        </form:form>
	       <table align="center">
	           <tr>
	               <td style="font-style: italic; color: red;">${message}</td>
	           </tr>
	       </table>
	       <div class="footer register-footer text-center">
				<h6>&copy; <script>document.write(new Date().getFullYear())</script>, Powered By <a href="home.jsp">Orderboy</a></h6>
			</div>
  			</body>
	        <script type="text/javascript" href="js/bootstrap.min.js" ></script>
	        <script type="text/javascript" href="js/paper-kit.js" ></script>
	        <script type="text/javascript" href="js/jquery-3.2.1.js" ></script>
	        <script type="text/javascript" href="js/moment.min.js" ></script>
	        <script type="text/javascript" href="js/nouislider.js" ></script>
	        <script type="text/javascript" href="js/bootstrap-switch.min.js" ></script>
	        <script type="text/javascript" href="js/popper.js" ></script>
	        <script type="text/javascript" href="js/jquery-ui-1.12.1.custom.min.js" ></script>
        </html>