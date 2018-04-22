<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
				
		<title>OrderBoy &mdash; Admin Dashboard</title>

		<!-- Favicon -->
		<link rel="shortcut icon" href="#">

		<!-- Switchery css -->
		<link href="assets_admin_dash/plugins/switchery/switchery.min.css" rel="stylesheet" />
		
		<!-- Bootstrap CSS -->
		<link href="assets_admin_dash/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		
		<!-- Font Awesome CSS -->
		<link href="assets_admin_dash/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		
		<!-- Custom CSS -->
		<link href="assets_admin_dash/css/style.css" rel="stylesheet" type="text/css" />	
		
		<!-- BEGIN CSS for this page -->

		<!-- END CSS for this page -->
				
</head>

<body class="adminbody">

<div id="main">

	<!-- top bar navigation -->
	<div class="headerbar">

		<!-- LOGO -->
        <div class="headerbar-left">
			<a href="/showAdminHome" class="logo"> <span>OrderBoy</span></a>
        </div>

        <nav class="navbar navbar-light bg-dark">

                    <ul class="list-inline float-right mb-0">

						<li class="list-inline-item dropdown notif">
                            <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                <i class="fa fa-fw fa-question-circle"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-arrow-success dropdown-lg">
                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h5><small>Help and Support</small></h5>
                                </div>

                                <!-- item-->
                                <a target="_blank" href="#" class="dropdown-item notify-item">                                    
                                    <p class="notify-details ml-0">
                                        <b>Support</b>
                                        <span>Contact Us</span>
                                    </p>
                                </a>

                                <!-- All-->
                                <a title="faq" target="_blank" href="#" class="dropdown-item notify-item notify-all">
                                    <i class="fa fa-link"></i> FAQ
                                </a>

                            </div>
                        </li>
						
                        <li class="list-inline-item dropdown notif">
                            <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                <i class="fa fa-fw fa-envelope-o"></i><span class="notif-bullet"></span>
                            </a>
                        
                        </li>
                        
						<li class="list-inline-item dropdown notif">
                            <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                <i class="fa fa-fw fa-bell-o"></i><span class="notif-bullet"></span>
                            </a>
                           
                        </li>

                        <li class="list-inline-item dropdown notif">
                            <a class="nav-link dropdown-toggle nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                            	<i class="fa fa-fw fa-user-circle"></i><span></span>
                                <!-- <img src="#" alt="" class="avatar-rounded"> -->
                            </a>
                            <div class="dropdown-menu dropdown-menu-right profile-dropdown">
                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h5 class="text-overflow"><small>Hello, admin</small> </h5>
                                </div>

                                <!-- item-->
                                <a href="pro-profile.html" class="dropdown-item notify-item">
                                    <i class="fa fa-user"></i> <span>Profile</span>
                                </a>

                                <!-- item-->
                                <a href="#" class="dropdown-item notify-item">
                                    <i class="fa fa-power-off"></i> <span>Logout</span>
                                </a>
								
                            </div>
                        </li>

                    </ul>

                    <ul class="list-inline menu-left mb-0">
                        <li class="float-left">
                            <button class="button-menu-mobile open-left">
								<i class="fa fa-fw fa-bars"></i>
                            </button>
                        </li>                        
                    </ul>

        </nav>

	</div>
	<!-- End Navigation -->
	
 
	<!-- Left Sidebar -->
	<div class="left main-sidebar">
	
		<div class="sidebar-inner leftscroll">

			<div id="sidebar-menu">
        
			<ul>

					<li class="submenu">
						<a href="/showAdminHome"><i class="fa fa-fw fa-tachometer"></i><span> Dashboard </span> </a>
                    </li>					
					
            </ul>

            <div class="clearfix"></div>

			</div>
        
			<div class="clearfix"></div>

		</div>

	</div>
	<!-- End Sidebar -->


    <div class="content-page">
	
		<!-- Start content -->
        <div class="content">
            
			<div class="container-fluid">

					
							<div class="row">
									<div class="col-xl-12">
											<div class="breadcrumb-holder">
													<h1 class="main-title float-left">Dashboard</h1>
													<ol class="breadcrumb float-right">
														<li class="breadcrumb-item">Home</li>
														<li class="breadcrumb-item active">Dashboard</li>
													</ol>
													<div class="clearfix"></div>
											</div>
									</div>
							</div>
							<!-- end row -->

							
							<div class="row">
									<div class="col-xl-12">									
										
										<%@include file="../yourItemList.jsp" %>
										
									</div>
							</div>



            </div>
			<!-- END container-fluid -->

		</div>
		<!-- END content -->

    </div>
	<!-- END content-page -->
    
	<footer class="footer">
		<span class="text-right">
			Copyright &copy; <script>document.write(new Date().getFullYear())</script>, Developed By <a href="#">OrderBoy</a>
		</span>		
	</footer>

</div>
<!-- END main -->

<script src="assets_admin_dash/js/modernizr.min.js"></script>
<script src="assets_admin_dash/js/jquery.min.js"></script>
<script src="assets_admin_dash/js/moment.min.js"></script>

<script src="assets_admin_dash/js/popper.min.js"></script>
<script src="assets_admin_dash/js/bootstrap.min.js"></script>

<script src="assets_admin_dash/js/detect.js"></script>
<script src="assets_admin_dash/js/fastclick.js"></script>
<script src="assets_admin_dash/js/jquery.blockUI.js"></script>
<script src="assets_admin_dash/js/jquery.nicescroll.js"></script>
<script src="assets_admin_dash/js/jquery.scrollTo.min.js"></script>
<script src="assets_admin_dash/plugins/switchery/switchery.min.js"></script>

<!-- App js -->
<script src="assets_admin_dash/js/pikeadmin.js"></script>

<!-- BEGIN Java Script for this page -->

<!-- END Java Script for this page -->

</body>
</html>