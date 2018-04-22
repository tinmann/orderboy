<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        	<head>
				<meta charset="utf-8">
				<meta name="author" content="Kodinger">
				<title>OrderBoy &mdash; Forgot Password</title>
				<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
				<link rel="stylesheet" type="text/css" href="css/my-login.css">
			</head>
			<body class="my-login-page">
				<section class="h-100">
					<div class="container h-100">
						<div class="row justify-content-md-center align-items-center h-100">
							<div class="card-wrapper">
								<div class="brand">
									<img src="img/logo.jpg">
								</div>
								<div class="card fat">
									<div class="card-body">
										<h4 class="card-title">Forgot Password</h4>
										<form method="POST">
										 
											<div class="form-group">
												<label for="email">E-Mail Address</label>
												<input id="email" type="email" class="form-control" name="email" value="" required autofocus>
												<div class="form-text text-muted">
													By clicking "Reset Password" we will send a password reset link
												</div>
											</div>
			
											<div class="form-group no-margin">
												<button type="submit" class="btn btn-primary btn-block">
													Reset Password
												</button>
											</div>
										</form>
									</div>
								</div>
								<div class="footer">
									Copyright &copy; <script>document.write(new Date().getFullYear())</script> | Developed By <a href="#">OrderBoy</a>
								</div>
							</div>
						</div>
					</div>
				</section>
			</body>
		</html>