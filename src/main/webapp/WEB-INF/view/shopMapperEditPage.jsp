<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
       
	
	<link rel="stylesheet" href="css/style.css" />
	
	<style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>

<script type="text/javascript">
var span = document.getElementsByClassName("close")[0];

var modal = document.getElementById('myModal');



// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
	
       
        <body>
        <h5 style="text-align: center;"> Edit Your Item </h5>
        <br/>
         <br/>
   <p>
            <form:form name ="editForm" id="editItemForm" modelAttribute="editSingleItemForm" action="/editSubmit" method="post" class= "owl-theme">
                <table align="center">
                    <tr class="single_abouts wow">
                        <td class = "main_menu_bg">
                            <label><b>Item ID:</b></label>
                        </td>
                        <td>
                            ${shopMapperObjectToEdit.itemDetails.itemAutoId}
                            
                        </td>
                       
                    </tr>
                    <tr class="single_abouts wow">
                        <td class = "main_menu_bg">
                            
                            <label><b>Item Name:</b> </label>
                        </td>
                        <td>
                          <%--   <form:input path="loginId" name="userId" id="userId" /> --%>
                           ${shopMapperObjectToEdit.itemDetails.name}
                        </td>
                       
                    </tr>
                     <tr class="single_abouts wow">
                        <td class = "main_menu_bg">
                            <form:label path="quantity" class="animated"><b>Item Quantity:</b></form:label>
                        </td>
                        <td>
                       <form:input path="quantity" name="quantity" id="itemId" onkeypress="return event.charCode >= 48 && event.charCode <= 57;" value="${shopMapperObjectToEdit.quantity}" />
                       
                        </td>
                       <%--  <td><form:errors  id="quantityErr" path="quantity" style="color: red;"></form:errors></td> --%>
                        <td><span id="quantityErr" style="color: red;"></span></td>
                    </tr>
                    
                     <form:hidden path="id" value ="${shopMapperObjectToEdit.id}"/>
                
                    <tr class="single_abouts wow">
                        <td></td>
                        <td align="left">
                            <form:button id="login" name="login" onclick="return validateForm()">Edit</form:button>
                        </td>
                    </tr>
                    
                   
                </table>
            </form:form>
            </p>
           
        </body>
        <script>
function validateForm() {
    var x = document.forms["editForm"]["quantity"].value;
    var modal = document.getElementById('quantityErr');
    if (!x || x == "" || x == " ")
    {
    
    	modal.innerHTML = "";
    	modal.innerHTML = "Please enter the Quantity";
       
        return false;
    }
    else 
    	{
    	modal.innerHTML = "";
    	return true;
    	}
   
    	
}
</script>
        </html>