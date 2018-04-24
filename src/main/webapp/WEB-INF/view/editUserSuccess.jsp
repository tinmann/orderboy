<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
	 	<link rel="stylesheet" href="css/bootstrap.min.css" />
        <title>OrderBoy &mdash; Notify</title>
    </head>
    <body>
	    <div class="row my-auto">
	       <div class="col-lg-6 col-md-8 col-sm-12 mx-auto">
	           <div class="card p-5 border-0">
	               <div class="card-block text-center py-5">
	                   <h2 class="mb-3 display-4">Thank You!</h2>
	                   <p class="lead text-secondary mb-5 px-4">You have been successfully updated your profile, Please note your <strong>User ID - ${userDetailsObj.userPojo.loginId}</strong> for your future transactions. Also check your eMail for any other details.</p>
	                   <a class="btn btn-lg btn-secondary" href="#">Home</a>
	               </div>
	           </div>
	       </div>
	   </div>        
    </body>
</html>