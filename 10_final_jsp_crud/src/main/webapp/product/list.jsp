<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<h2>Product List
<c:if test="${ses.email ne '' && ses.email ne null }">
<a href="/prodCtrl/register" class="btn btn-outline-success">Reigster</a>
</c:if>
</h2>
<table class="table table-hover">
    <thead>
      <tr>
      	<th>#</th>
        <th>Pname</th>
        <th>Price</th>
        <th>Writer</th>
        <th>Mod At</th>        
        <th>ReadCount</th>        
        <th>Attached</th>        
      </tr>
    </thead>
    <tbody>
    <c:forEach var="pvo" items="${list }">
      <tr>
        <td>${pvo.pno}</td>
        <td>
        <a href="/prodCtrl/detail?pno=${pvo.pno}">${pvo.pname}</a>
        </td>
        <td>${pvo.price}</td>
        <td>${pvo.writer}</td>
        <td>${pvo.modAt}</td>
        <td>${pvo.readCount}</td>
        <td>
        <c:if test="${pvo.imageFile ne '' && pvo.imageFile ne null }">
        <img src="../_fileUpload/th_${pvo.imageFile}">
        </c:if>
        </td>
      </tr>
    </c:forEach>  
    </tbody>
  </table>
  
<jsp:include page="../footer.jsp"/>