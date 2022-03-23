<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<h1>Product List Page</h1>
	<table border="1">
		<thead>
			<tr>
				<th>PNO</th>
				<th>PNAME</th>
				<th>PRICE</th>
			</tr>
		</thead>
		<tbody>
		
		<c:choose>
			<c:when test="${list.size() > 0 }">
				<c:forEach var="pvo" items="${list }">
				<tr>
					<td>${pvo.pno }</td>
					<td><a href="./detail.pd?pno=${pvo.pno }">${pvo.pname }</a></td>
					<td>${pvo.price }</td>
				</tr>
				</c:forEach>			
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="3"><h3>등록된 상품이 없습니다.</h3></td>
				</tr>
			</c:otherwise>
		</c:choose>
		
		</tbody>
	</table>
	<h3><a href="/product/register.pd">Product Register</a></h3>
</body>
</html>