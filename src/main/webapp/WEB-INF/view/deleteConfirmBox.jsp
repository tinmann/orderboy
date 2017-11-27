<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Bootstrap Optional Theme -->
<link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- JQuery Javascript -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<!-- Bootscript JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	<style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%;
    height: 100%; 
    overflow: auto;
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

var modal = document.getElementById('myModal_delete');



// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</head>

<body>
<div id="modalConfirmYesNo" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" 

                class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 id="lblTitleConfirmYesNo" class="modal-title">Warning</h4>
            </div>
            <div class="modal-body">
                <p id="lblMsgConfirmYesNo">Are you sure you want to delete the  item ${shopMapperObjectToDelete.itemDetails.name }</p>
            </div>
            <div class="modal-footer">
                <button id="yes_${shopMapperObjectToDelete.id}"  type="button" class="btn btn-primary" onclick="deleteConfirmYes(this.id)">Yes</button>
                <button id="no_${shopMapperObjectToDelete.id}"   type="button" class="btn btn-default" onclick="deleteConfirmNo(this.id)">No</button>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">


function deleteConfirmYes(itemMapId) {
	var arr = itemMapId.split('_');
	itemMapId = arr[1];
	$.ajax({
		url: "http://localhost:8080/deleteSingleMapItemConfirmed",
		type: "GET",
	/* 	dataType: "JSON", */
		data: {"itemMapId":itemMapId},
		
		success: function(result)
		{	
			modal.style.display = "none";
			/* window.location.reload(true); */
			window.location.href = "http://localhost:8080/addUserItemUpload";
			
		}
	}).fail(function(jqXHR,textStatus,errorThrown){		
		console.log(textStatus);
		console.log(errorThrown);
	});
	
}

function deleteConfirmNo(id) {
	var modal = document.getElementById('myModal_delete');
	 modal.style.display = "none";
	 window.location.href = "http://localhost:8080/addUserItemUpload";
}


</script>
</html>