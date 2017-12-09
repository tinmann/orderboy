

function editMyItem(itemMapId)
{
	
	var arr = itemMapId.split('_');
	itemMapId = arr[1];
	var modal = document.getElementById('myModal');
	var span = document.getElementsByClassName("close")[0];
	

	
	$.ajax({
		url: "http://localhost:8080/editSingleMapItem",
		type: "GET",
		data: {"itemMapId":itemMapId},
		
		success: function(result)
		{			
			 $("#popUpContent").html(result);  
			 modal.style.display = "block";
		}
	}).fail(function(jqXHR,textStatus,errorThrown){		
		console.log(textStatus);
		console.log(errorThrown);
	});
}


function deleteMyItem(itemMapId)
{
	var arr = itemMapId.split('_');
	itemMapId = arr[1];
	
	var modal = document.getElementById('myModal_delete');
	var span = document.getElementsByClassName("close")[0];
	
	$.ajax({
		url: "http://localhost:8080/deleteSingleMapItem",
		type: "GET",
		data: {"itemMapId":itemMapId},
		
		success: function(result)
		{			
			 $("#popUpContent_delete").html(result); 
			
			 modal.style.display = "block";
			
		}
	}).fail(function(jqXHR,textStatus,errorThrown){		
		console.log(textStatus);
		console.log(errorThrown);
	});

}