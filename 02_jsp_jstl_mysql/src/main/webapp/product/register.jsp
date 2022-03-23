<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Register Page</title>
</head>
<body>
	<h1>Product Register Page Load Success</h1>
	<form action="./insert.pd" method="post">
		Name: <input type="text" name="pname"><br>
		Price: <input type="text" name="price"><br>
		Made By: <input type="text" name="madeBy"><br>
		<button type="submit">Submit</button>
	</form>
	<h3><a href="/product/list.pd">Product List</a></h3>
</body>
</html>