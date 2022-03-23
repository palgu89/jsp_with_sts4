<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

<h2>Emp Modify Form</h2>
  <form action="./update.em" method="post">
    <div class="mb-3 mt-3">
      <label for="empno">Empno:</label>
      <input type="text" class="form-control" name="empno" value="${evo.empno }" readonly>
    </div>
    <div class="mb-3">
      <label for="ename">Ename:</label>
      <input type="text" class="form-control" value="${evo.ename }" readonly>
    </div>
    <div class="mb-3">
      <label for="hireDate">HireDate:</label>
      <input type="text" class="form-control" value="${evo.hireDate }" readonly>
    </div>
    <div class="mb-3">
      <label for="sal">Salary:</label>
      <input type="text" class="form-control" name="sal" value="${evo.sal }">
    </div>
    <div class="mb-3">
      <label for="comm">Comm:</label>
      <input type="text" class="form-control" name="comm" value="${evo.comm }">
    </div>
    <div class="mb-3">
      <label for="mgr">MGR:</label>
      <input type="text" class="form-control" name="mgr" value="${evo.mgr }">
    </div>
    <div class="mb-3">
      <label for="job">Job:</label>
      <input type="text" class="form-control" name="job" value="${evo.job }">
    </div>
    <div class="mb-3">
      <label for="deptno">Deptno:</label>
      <input type="text" class="form-control" name="deptno" value="${evo.deptno }">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>


<jsp:include page="../footer.jsp"/>