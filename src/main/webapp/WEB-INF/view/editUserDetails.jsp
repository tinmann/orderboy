<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/bootstrap.min.css" />				
			
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
	                    <a href="#" target="_blank" class="nav-link"><i class="nc-icon nc-book-bookmark"></i>  User Manual</a>
	                </li>
	            </ul>
	        </div>
		</div>
    </nav>
     <form:form method="POST" action="/editUserDetailsPost" modelAttribute="userDetailsPojo">
	    <div class="wrapper">
	        <div class="page-header" style="background-image: url('../img/worldmap.jpg');">
	            <div class="filter"></div>
	                <div class="container">
	                    <div class="row">
	                        <div class="col-lg-4 ml-auto mr-auto">
	                            <div class="card card-register">
	                                <h3 class="title">Edit User</h3>									
	                                <form class="register-form">
	                                    <label>Company Name</label>
	                                    <form:input path="companyName" type="text" class="form-control" placeholder="Enter Company Name" />
										<form:errors path="companyName" style="color: red;" />
	                                    <label>First Name</label>
	                                    <form:input path="firstName" type="text" class="form-control" placeholder="Enter First Name" />
										<form:errors path="firstName" style="color: red;" />
	                                    <label>Last Name</label>
	                                    <form:input path="lastName" type="text" class="form-control" placeholder="Enter Last Name" />
										<form:errors path="lastName" style="color: red;" />
	                                    <label>Type</label>
	                                    <form:select path="type" selected="type" class="form-control">
	                                     	<option value="">--- Select ---</option>
					                       	<option value="Dealer">Dealer</option>
					                       	<option value="Retailer">Retailer</option>
				                        </form:select>
                        				<form:errors path="type" style="color: red;"></form:errors>
                        				
                        				<label>Ownership Type</label>
	                                    <form:select path="ownershipType" selected="ownershipType" class="form-control">
	                                     	<option value="">--- Select ---</option>
					                       	<option value="INDIVIDUAL">INDIVIDUAL</option>
					                       	<option value="HUF">HUF</option>
					                       	<option value="PARTNERSHIP FIRM">PARTNERSHIP FIRM</option>					                
					                       	<option value="COMPANY">COMPANY</option>
					                       	<option value="AOP">AOP</option>
				                        </form:select>
                        				<form:errors path="ownershipType" style="color: red;"></form:errors>
                        				
                        				<label>Address</label>
                        				
                        				<label>State</label>
	                                    <form:input path="address.state" type="text" class="form-control" placeholder="Enter the State" />
										<form:errors path="address.state" style="color: red;" />
										<label>City</label>
	                                    <form:input path="address.city" type="text" class="form-control" placeholder="Enter the City" />
										<form:errors path="address.city" style="color: red;" />
										<label>Area</label>
	                                    <form:input path="address.area" type="text" class="form-control" placeholder="Enter the Area" />
										<form:errors path="address.area" style="color: red;" />
										<label>Country</label>
	                                    <form:input path="address.country" type="text" class="form-control" placeholder="Enter the Country" />
										<form:errors path="address.country" style="color: red;" />
										<label>Pincode</label>
	                                    <form:input path="address.pinCode" type="text" class="form-control" placeholder="Enter the Pincode" />
										<form:errors path="address.pinCode" style="color: red;" />
										
                        				
                        				
                        				
                        				<label>Land Number</label>
	                                    <form:input path="phoneLand" type="text" class="form-control" placeholder="Enter Landline Number" />
										<form:errors path="phoneLand" style="color: red;" />
										
										<label>Mobile Number</label>
	                                    <form:input path="phoneMobile" type="text" class="form-control" placeholder="Enter Mobile Number" />
										<form:errors path="phoneMobile" style="color: red;" />
										
										<label>Email</label>
	                                    <form:input path="email" type="text" class="form-control" placeholder="Enter Email" />
										<form:errors path="email" style="color: red;" />
                        				
										
										<label>GSTIN Number</label>
	                                    <form:input path="gstnNo" type="text" class="form-control" placeholder="Enter GSTIN Number" />
										<form:errors path="gstnNo" style="color: red;" />
										
										<label>Licence Number</label>
	                                    <form:input path="licenceNo" type="text" class="form-control" placeholder="Enter Licence Number" />
										<form:errors path="licenceNo" style="color: red;" />
										
										<label>CIN Number</label>
	                                    <form:input path="cinNo" type="text" class="form-control" placeholder="Enter CIN Number" />
										<form:errors path="cinNo" style="color: red;" />
										
										
                        				<label>Password</label>
	                                    <form:input path="userPojo.password" type="password" class="form-control" />
	                                    <form:errors path="userPojo.password" style="color: red;" />
	                                     <form:hidden path="userPojo.loginId" value ="userPojo.loginId"/> 
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
	        
	
</html>