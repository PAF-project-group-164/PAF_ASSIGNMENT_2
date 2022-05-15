<%@page import="com.Payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/payment.js"></script>
</head>
<body>
<div class="container"><div class="row"><div class="col-6"> 
<h1>Payment Management</h1>
<form id="formpayment" name="formpayment" method="post" action="payment.jsp">
Customer ID: 
 <input id="Payment_customer_id" name="Payment_customer_id" type="text" 
 class="form-control form-control-sm">
 <br> Customer Name: 
 <input id="Payment_customer_name" name="Payment_customer_name" type="text" 
 class="form-control form-control-sm">
 <br> Date: 
 <input id="Payment_date" name="Payment_date" type="text" 
 class="form-control form-control-sm">
  <br> Amount: 
 <input id="Payment_amount" name="Payment_amount" type="text" 
 class="form-control form-control-sm">
  <br> Payment Description: 
 <input id="Payment_description" name="Payment_description" type="text" 
 class="form-control form-control-sm">
 <br>
 
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidPayment_idSave" 
 name="hidPayment_idSave" value="">
 
</form>

<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

<div id="divpaymentGrid">
<% 
Payment paymentobj = new Payment();
out.print(paymentobj.readpayment());
%>

</div>
</div> </div> </div>
</body>
</html>