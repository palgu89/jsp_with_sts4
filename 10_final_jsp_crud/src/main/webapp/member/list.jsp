<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>

<table class="table table-hover">
    <thead>
      <tr>
        <th>Email</th>
        <th>Nickname</th>
        <th>Reg At</th>
        <th>Last Login</th>
        <th>Grade</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="mvo" items="${list }">
      <tr>
        <td>${mvo.email }</td>
        <td>${mvo.nickName }</td>
        <td>${mvo.regAt }</td>
        <td>${mvo.lastLogin }</td>
        <td><input type="number" value="${mvo.grade }" data-email="${mvo.email }" style="width:50px;">
        &nbsp;<button type="button" class="btn btn-outline-danger btn-sm">
        조정</button></td>
      </tr>
    </c:forEach>  
    </tbody>
  </table>
  
<jsp:include page="../footer.jsp"/>