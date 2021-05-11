<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer form</title>
</head>
<body>
<header>CRM-Customer Relationship Manager</header>

	<form action="saveCustomer">
	
		<input type="text" name="firstName"><br>
		<input type="text" name="lastName"><br>
		<input type="email" name="email"><br>
		<input type="submit"><br>
	
	</form>
	
	<button onclick="goBack()">Go Back</button>

	<script>
	function goBack() {
  	window.history.back();
	}
	</script>
</body>
</html>