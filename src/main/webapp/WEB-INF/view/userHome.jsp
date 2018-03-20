<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>OrderBoy | Join Us</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<!-- CSS Files -->
    <link href="assets_com_profile/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets_com_profile/css/paper-bootstrap-wizard.css" rel="stylesheet" />
	<!-- Fonts and Icons -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
	<link href="assets_com_profile/css/themify-icons.css" rel="stylesheet">
</head>
<body>
	<div class="image-container set-full-height" style="background-image: url('assets_com_profile/img/image001.jpg')">	
		  <!--   Big container   -->
	    <div class="container">
	        <div class="row">	      
		        <div class="col-sm-8 col-sm-offset-2">
		            <!--      Wizard container        -->
		            <div class="wizard-container">
		                <div class="card wizard-card" data-color="orange" id="wizardProfile">
							<form:form method="POST" action="/addUserDetails" modelAttribute="userDetailsPojo">
								 <div class="wizard-footer">
								 
			                    	<div class="wizard-header text-center">
			                        	<h3 class="wizard-title">Create your company profile</h3>
										<p class="category">This information is for login and varification purpose.</p>
			                    	</div>
	
									<div class="wizard-navigation">
										<div class="progress-with-circle">
										     <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="3" style="width: 21%;"></div>
										</div>
										<ul>
				                            <li>
												<a href="#about" data-toggle="tab">
													<div class="icon-circle">
														<i class="ti-user"></i>
													</div>
													About
												</a>
											</li>
				                            <li>
												<a href="#company" data-toggle="tab">
													<div class="icon-circle">
														<i class="ti-briefcase"></i>
													</div>
													Company
												</a>
											</li>
				                            <li>
												<a href="#address" data-toggle="tab">
													<div class="icon-circle">
														<i class="ti-map"></i>
													</div>
													Address
												</a>
											</li>
				                        </ul>
									</div>
									<div class="tab-content">
		                            <div class="tab-pane" id="about">
		                            	<div class="row">
											<h5 class="info-text"> Please tell us more about yourself.</h5>
											<div class="col-sm-4 col-sm-offset-1">
												<div class="picture-container">
													<div class="picture">
														<img src="assets_com_profile/img/default-avatar.jpg" class="picture-src" id="wizardPicturePreview" title="" />
														<input type="file" id="wizard-picture">
													</div>
													<h6>Choose Picture</h6>
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label>First Name <small>(required)</small></label>
												 	<form:input path="firstName" type="text" class="form-control" placeholder="Your First Name..." />
												</div>
												<div class="form-group">
													<label>Last Name <small>(required)</small></label>
													<form:input path="lastName" type="text" class="form-control" placeholder="Your Last Name..." />
												</div>
												<div class="form-group">
													<label>Password <small>(required)</small></label>
													<form:input path="userPojo.password" type="password" class="form-control"  placeholder="Your Password..."/>
				                                    <form:errors path="userPojo.password" style="color: red;" />
				                                    <form:hidden path="userPojo.loginId" value ="1"/>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group">
													<label>Email <small>(required)</small></label>
													<form:input path="email" type="email" class="form-control" placeholder="example@company-name.com" />
												</div>
											</div>
										</div>
		                            </div>
			                             <div class="tab-pane" id="company">
			                                <div class="row">
			                                    <div class="col-sm-12">
			                                        <h5 class="info-text"> Please provide your company details. </h5>
			                                    </div>
			                                    <div class="col-sm-10 col-sm-offset-1">
			                                    	<div class="form-group">
			                                            <label>Company Name <small>(required)</small></label>
		                                    			<form:input path="companyName" type="text" class="form-control" placeholder="Enter Company Name..." />
			                                        </div>
			                                    </div>		                                    
			                                    <div class="col-sm-5 col-sm-offset-1">
			                                        <div class="form-group">
			                                            <label>Type <small>(required)</small></label>
	                                    				<form:select path="type" selected="type" class="form-control">
			                                     			<option value="">--- Select ---</option>
							                       			<option value="Dealer">Dealer</option>
							                       			<option value="Retailer">Retailer</option>
					                        			</form:select>
			                                        </div>
			                                    </div>
			                                    <div class="col-sm-5 ">
			                                        <div class="form-group">
			                                            <label>Ownership Type <small>(required)</small></label>
	                                    				<form:select path="ownershipType" selected="ownershipType" class="form-control">
					                                     	<option value="">--- Select ---</option>
									                       	<option value="INDIVIDUAL">INDIVIDUAL</option>
									                       	<option value="HUF">HUF</option>
									                       	<option value="PARTNERSHIP FIRM">PARTNERSHIP FIRM</option>					                
									                       	<option value="COMPANY">COMPANY</option>
									                       	<option value="AOP">AOP</option>
								                        </form:select>
			                                        </div>
			                                    </div>		                                    
												<div class="col-sm-5 col-sm-offset-1">
													<div class="form-group">
														<label>Mobile Number<small>(required)</small></label>
		                                    			<form:input path="phoneMobile" type="number" class="form-control" placeholder="Enter Mobile Number..." />
													</div>
												</div>
												<div class="col-sm-5">
													<div class="form-group">
													<label>Landline Number</label>
		                                    			<form:input path="phoneLand" type="number" class="form-control" placeholder="Enter Landline Number..." />
													</div>
												</div>
												<div class="col-sm-10 col-sm-offset-1">
			                                        <div class="form-group">
			                                            <label>GSTIN Number <small>(required)</small></label>
		                                    			<form:input path="gstnNo" type="text" class="form-control" placeholder="Enter GSTIN Number" />
			                                        </div>
			                                    </div>
			                                    <div class="col-sm-5 col-sm-offset-1">
			                                        <div class="form-group">
			                                            <label>Licence Number</label>
		                                    			<form:input path="licenceNo" type="text" class="form-control" placeholder="Enter Licence Number" />
			                                        </div>
			                                    </div>
			                                    <div class="col-sm-5">
			                                        <div class="form-group">
			                                           <label>CIN Number</label>
		                                    			<form:input path="cinNo" type="text" class="form-control" placeholder="Enter CIN Number" />
			                                        </div>
			                                    </div>
			                                   <%--  <div class="col-sm-10 col-sm-offset-1">
													<div class="form-group">
														<label>Website </label>
														<form:input path="website" type="website" class="form-control" placeholder="www.example.com" />
													</div>
												</div> --%>
			                                </div>
			                            </div>
			                            <div class="tab-pane" id="address">
                                  	 <div class="row">
		                                    <div class="row">
		                                    <div class="col-sm-8 col-sm-offset-2">
		                                        <div class="col-sm-4 col-sm-offset-2">
													<div class="choice" data-toggle="wizard-checkbox">
		                                                <input type="checkbox" name="jobb" value="Design">
		                                                <div class="card card-checkboxes card-hover-effect">
		                                                    <i class="ti-home"></i>
															<p>Home Address</p>
		                                                </div>
		                                            </div>
		                                        </div>
		                                        <div class="col-sm-4">
													<div class="choice" data-toggle="wizard-checkbox">
		                                                <input type="checkbox" name="jobb" value="Design">
		                                                <div class="card card-checkboxes card-hover-effect">
		                                                    <i class="ti-briefcase"></i>
															<p>Office Address</p>
		                                                </div>
		                                            </div>
		                                        </div>
		                                    </div>
		                                </div>
		                                </div>
		                                <div class="row">
		                                    <div class="col-sm-12">
		                                        <h5 class="info-text"> Please share your address? </h5>
		                                    </div>
		                                     <div class="col-sm-10 col-sm-offset-1">
		                                    	<div class="form-group">
		                                            <label>Address <small>(required)</small></label>
	                                    			<form:input path="address.area" type="text" class="form-control" placeholder="Enter the Adress..." />
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-5 col-sm-offset-1">
		                                        <div class="form-group">
		                                           <label>City <small>(required)</small></label>
	                                    			<form:input path="address.city" type="text" class="form-control" placeholder="Enter your City..." />
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-5">
		                                        <div class="form-group">
		                                           <label>State <small>(required)</small></label>
	                                    			<form:input path="address.state" type="text" class="form-control" placeholder="Enter your State..." />
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-5 col-sm-offset-1">
		                                        <div class="form-group">
		                                           <label>ZIP Code <small>(required)</small></label>
	                                    			<form:input path="address.pinCode" type="text" class="form-control" placeholder="Enter your Pincode..." />
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-5 ">
			                                        <div class="form-group">
			                                            <label>Country <small>(required)</small></label>
	                                    				<form:select  path="" class="form-control">
					                                     	<option value="">--- Select ---</option>
									                       	<option value="India">India</option>
									                       	<option value="USA">USA</option>
								                        </form:select>
			                                        </div>
			                                    </div>	
		                                </div>
		                            </div>
			                        </div>                        	
							 
		                            <div class="pull-right">
		                                <input type='button' class='btn btn-next btn-fill btn-warning btn-wd' name='next' value='Next' />
		                                <input class='btn btn-finish btn-fill btn-warning btn-wd' name='finish' type="submit" value="Submit" />
		                            </div>

		                            <div class="pull-left">
		                                <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='Previous' />
		                            </div>
		                            <div class="clearfix"></div>
		                        </div>
							</form:form>
						</div>
		            </div> <!-- wizard container -->
		        </div>
	    	</div><!-- end row -->
		</div> <!--  big container -->
	<div class="footer">
	        <div class="container text-center">
	            Copyright &copy; <script>document.write(new Date().getFullYear())</script>, Developed By <a href="#">OrderBoy</a>
	        </div>
	    </div>
	</div>
</body>

	<!--   Core JS Files   -->
	<script src="assets_com_profile/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="assets_com_profile/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets_com_profile/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
	<!--  Plugin for the Wizard -->
	<script src="assets_com_profile/js/paper-bootstrap-wizard.js" type="text/javascript"></script>
	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="assets_com_profile/js/jquery.validate.min.js" type="text/javascript"></script>
</html>
	