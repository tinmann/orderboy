<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	                    <a href="/loginUserForm" class="nav-link"><i class="nc-icon nc-single-02"></i>SignIn</a>
	                </li>
	                <li class="nav-item">
	                    <a href="#" target="_blank" class="nav-link"><i class="nc-icon nc-book-bookmark"></i>  Usermanual</a>
	                </li>
	            </ul>
	        </div>
		</div>
    </nav>
     <form:form method="POST" action="/addUserDetails" modelAttribute="userDetailsPojo">
	    <div class="wrapper">
	        <div class="page-header" style="background-image: url('../img/worldmap.jpg');">
	            <div class="filter"></div>
	                <div class="container">
	                    <div class="row">
	                        <div class="col-lg-4 ml-auto mr-auto">
	                            <div class="card card-register">
	                                <h3 class="title">Registration</h3>									
	                                <form class="register-form">
	                                    <label>Firstname</label>
	                                    <form:input path="firstName" type="text" class="form-control" placeholder="Enter Firstname" />
										<form:errors path="firstName" style="color: red;" />
	                                    <label>Lastname</label>
	                                    <form:input path="lastName" type="text" class="form-control" placeholder="Enter Lastname" />
										<form:errors path="lastName" style="color: red;" />
	                                    <label>Type</label>
	                                    <form:select path="type" selected="type" class="form-control">
	                                     	<option value="">--- Select ---</option>
					                       	<option value="Dealer">Dealer</option>
					                       	<option value="Retailer">Retailer</option>
				                        </form:select>
                        				<form:errors path="type" style="color: red;"></form:errors>
                        				<label>Password</label>
	                                    <form:input path="userPojo.password" type="password" class="form-control" />
	                                    <form:errors path="userPojo.password" style="color: red;" />
	                                    <form:hidden path="userPojo.loginId" value ="1"/>
	                                    <input type="submit" value="Submit" class="btn btn-danger btn-block btn-round" />
	                                </form>		                                                                	                                
	                            </div>
	                        </div>
	                    </div>						
	                </div>
		        </div>
		    </div>
		    <!-- <div class="footer register-footer text-center">
				<h6>&copy; <script>document.write(new Date().getFullYear())</script>, Powered By <a href="home.jsp">Orderboy</a></h6>
			</div> -->
	        </form:form>	
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