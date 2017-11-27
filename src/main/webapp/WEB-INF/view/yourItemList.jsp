<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<script type="text/javascript">
//When the user clicks on <span> (x), close the modal


</script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<script type="text/javascript" src="js/bootstrap/jquery.dataTables.min.js"></script>
<!-- <script type="text/javascript" src="js/bootstrap/jquery-1.12.4.js"></script>  -->
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/jquery.dataTables.min.css" />
<script type="text/javascript" src="js/itemActions.js"></script>
<h2>Your items List</h2>
<table id="yourItemsList" class="display" cellspacing="0" width="100%">
 <tr>
             <th>Item HSN</th>
             <th>Item Id</th>
             <th>Item Name</th>
             <th>Item Quantity</th>
             <th>Edit</th>
             <th>Delete</th>
             
             </tr>
     <c:forEach items="${itemDetailsMappedObj}" var="itemDetailMappedObject" varStatus="gridRow">
                <tr>
                <td>${itemDetailMappedObject.itemDetails.ssnObject.ssnNumber}</td>
                <td>${itemDetailMappedObject.itemDetails.itemAutoId}</td>
                <td>${itemDetailMappedObject.itemDetails.name}</td>
                <td>${itemDetailMappedObject.quantity}</td>
                <td><a id="edit_${itemDetailMappedObject.id}" href="#" onclick="editMyItem(this.id)">Edit</a></td>
                <td><a id="delete_${itemDetailMappedObject.id}" href="#" onclick="deleteMyItem(this.id)">Delete</a>   <!-- <span class="delete-icon"> x Delete </span> --></td>
                  
                   
                </tr>
              </c:forEach>
</table>

<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div id="popUpContent"></div>
  </div>

</div>



<div id="myModal_delete" class="modal">

  <!-- Modal content -->
 <!--  <div class="modal-content"> -->
    <div id="popUpContent_delete"></div>
 <!--  </div> -->

</div>
<script type="text/javascript">
 $(document).ready(function() {
	
    $('#yourItemsList').dataTable({
    	"bSort": false,
    	"bFilter" :true,
    	 "ordering" : true,
         //"order": [[ 3, "desc" ]],
         "info" : true,
         "columns": [{
             "orderable": true
         }, {
             "orderable": true
         }, {
             "orderable": true
         }, {
             "orderable": true
         }, {
             "orderable": true
         }, {
             "orderable": true
         }],
        "scrollY":        "200px",
        "scrollCollapse": false,
        "info":           true,
        "paging":         true
    });

   
} );
 


</script>

