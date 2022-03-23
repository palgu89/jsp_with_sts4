<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

<h2>Emp Detail</h2>

<ul class="list-group list-group-flush my-3">
    <li class="list-group-item">Empno: ${evo.empno }</li>
	<li class="list-group-item">Ename: ${evo.ename }</li>    
	<li class="list-group-item">Job: ${evo.job }</li>    
	<li class="list-group-item">MGR: ${evo.mgr }</li>    
	<li class="list-group-item">HireDate: ${evo.hireDate }</li>    
	<li class="list-group-item">Salary: ${evo.sal }</li>    
	<li class="list-group-item">Comm: ${evo.comm }</li>    
	<li class="list-group-item">Deptno: ${evo.deptno }</li>    
</ul>
<a type="button" class="btn btn-outline-primary" href="./list.em">List</a>
<a type="button" class="btn btn-outline-warning" href="./modify.em?empno=${evo.empno }">Modify</a>
<a type="button" class="btn btn-outline-danger" href="./remove.em?empno=${evo.empno }">Remove</a>
<jsp:include page="../footer.jsp"/>