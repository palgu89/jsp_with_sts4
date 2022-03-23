<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

<h2>Emp List 
<a type="button" class="btn btn-outline-primary" href="./register.em">Register</a></h2>
  <table class="table">
    <thead>
      <tr>
        <th>Empno</th>
        <th>Ename</th>
        <th>HireDate</th>
        <th>Deptno</th>
      </tr>
    </thead>
    <tbody>
	  <c:forEach var="evo" items="${list }">
    	<tr>
			<td>${evo.empno }</td>
			<td><a href="./detail.em?empno=${evo.empno }">${evo.ename }</a></td>
			<td>${evo.hireDate }</td>
			<td>${evo.deptno }</td>
    	</tr>
	  </c:forEach>    
    </tbody>
  </table>

<jsp:include page="../footer.jsp"/>