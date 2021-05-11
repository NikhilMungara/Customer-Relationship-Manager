<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<header>CRM - Customer Relationship Manager</header>

<form action="addCustomer">
	
		<input type="number" name="id"><br>
		<input type="text" name="firstName"><br>
		<input type="text" name="lastName"><br>
		<input type="email" name="email"><br>
		<input type="submit"><br>
	
	</form>
	
	<form action="updateCustomer">
	
		<input type="number" name="id"><br>
		<input type="text" name="firstName"><br>
		<input type="text" name="lastName"><br>
		<input type="email" name="email"><br>
		<input type="submit"><br>

	</form>
	
	<form action="deleteCustomer">
	
		<input type="number" name="id"><br>
		<input type="text" name="firstName"><br>
		<input type="text" name="lastName"><br>
		<input type="email" name="email"><br>
		<input type="submit"><br>

	</form>
	

<h1>Customer Details</h1>
<sql:query var="listCustomers"   dataSource="${myDS}">
        SELECT * FROM customers;
    </sql:query>
<table>
	<tr>
		<th>ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
	</tr>
	<c:forEach var="customer" items="${listCustomers.rows}">
                <tr>
                    <td><c:out value="${customer.id}" /></td>
                    <td><c:out value="${customer.firstName}" /></td>
                    <td><c:out value="${customer.lastName}" /></td>
                    <td><c:out value="${customer.email}" /></td>
                </tr>
            </c:forEach>
</table>

</body>
</html>