<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "domain.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<%
// HttpServletRequest request => 리퀘스트 객체의 오리지널 이름을 사용해야 함
List<ProductVO> list = (ArrayList<ProductVO>) request.getAttribute("list");
%>
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
			<% for(ProductVO pvo : list) { %>
			<tr>
				<td><%=pvo.getPno() %></td>
				<td><a href="./detail.pd?pno=<%=pvo.getPno() %>"><%=pvo.getPname() %></a></td>
				<td><%=pvo.getPrice() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<h3><a href="/product/register.pd">Product Register</a></h3>
</body>
</html>