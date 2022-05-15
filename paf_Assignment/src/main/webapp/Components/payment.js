$(document).on("click", "#btnSave", function(event)
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status = validatepaymentForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 }
 // If valid------------------------
var type = ($("#hidpayment_idSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "paymentAPI", 
 type : type, 
 data : $("#formpayment").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onpaymentSaveComplete(response.responseText, status); 
 } 
 }); 
});
 
function onpaymentSaveComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divpaymentsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 }
$("#hidbidSave").val(""); 
$("#formpayment")[0].reset(); 
}

$(document).on("click", ".btnUpdate", function(event)
		{ 
		$("#hidPayment_idSave").val($(this).data("Payment_id")); 
		 $("#Payment_customer_id").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#Payment_customer_name").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#Payment_date").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#Payment_amount").val($(this).closest("tr").find('td:eq(3)').text()); 
		 $("#Payment_description").val($(this).closest("tr").find('td:eq(4)').text());
		});
 
 $(document).on("click", ".btnRemove", function(event)
		{ 
		 $.ajax( 
		 { 
		 url : "paymentAPI", 
		 type : "DELETE", 
		 data : "Payment_id=" + $(this).data("Payment_id"),
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onpaymentDeleteComplete(response.responseText, status); 
		 } 
		 }); 
		});
 
 
 function onpaymentDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divpaymentGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}
//client model--------------------------------
function validatepaymentForm()
{
	// Payment_customer_id
	if ($("#Payment_customer_id").val().trim() == "")
	{
	return "Insert Customer id.";
	}
	// Payment_customer_name
	if ($("#Payment_customer_name").val().trim() == "")
	{
	return "Insert Customer Name.";
	}
	

// Payment_date-------------------------------
if ($("#Payment_date").val().trim() == ""){
		
		return "Insert Payment date.";
}
	// Payment_amount------------------------
	if ($("#Payment_amount").val().trim() == ""){
		
		return "Payment amount.";
	}
	// Payment_description------------------------
	if ($("#Payment_description").val().trim() == ""){
		
		return "Insert Payment description.";
	}

return true;
}

 
 