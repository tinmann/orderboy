<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
			<head>
				<meta charset="utf-8">
				<meta name="author" content="Kodinger">
				<title>OrderBoy &mdash; Login</title>
				<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
				<link rel="stylesheet" type="text/css" href="css/my-login.css">
			</head>
			<body class="my-login-page">
				<section class="h-100">
					<div class="container h-100">
						<div class="row justify-content-md-center h-100">
							<div class="card-wrapper">
								<div class="brand">
									<img src="img/logo.jpg">
								</div>
								<div class="card fat">
									<div class="card-body">
										<h4 class="card-title">Login</h4>
        								<form:form id="loginForm" modelAttribute="userPojo" action="/loginUser" method="post">
										<div class="form-group">
											<label for="">User ID</label>	
											<form:input path="loginId" name="userId" id="userId" type="text" class="form-control" placeholder="User ID" required="required"/>
											<form:errors path="loginId" style="color: red;" />
										</div>
           								<div class="form-group">
										<label for="password">Password
											<a href="/forgetPassForm" class="float-right">
												Forgot Password?
											</a>
										</label>
										<form:input path="password" name="password" id="password" type="password" class="form-control" placeholder="Password" required="required data-eye"/>
										<form:errors path="password" style="color: red;" />
									</div>
									<div class="form-group">
										<span class="label label-danger" style="align-content: center;"> ${errorMessage}</span>
									</div>
									<div class="form-group">
									<label>
										<input type="checkbox" name="remember"> Remember Me
									</label>
								</div>

								<div class="form-group no-margin">
									<form:button class="btn btn-primary btn-block">Login</form:button>
								</div>
								<div class="margin-top20 text-center">
									Don't have an account? <a href="/addUserDetails">Create One</a>
								</div>								
							</form:form>
							<table align="center">
					           <tr>
					               <td style="font-style: italic; color: red;">${message}</td>
					           </tr>
					       </table>
						</div>
					</div>					
					<div class="footer">
						Copyright &copy; <script>document.write(new Date().getFullYear())</script>, Developed By <a href="#">OrderBoy</a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/my-login.js"></script>
</body>
</html>
	                   
		     
			   							
			                             