<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

<h2>Emp Register Form 
<a type="button" class="btn btn-outline-primary" href="./list.em">List</a></h2>
  <form action="./insert.em" method="post">
    <div class="mb-3 mt-3">
      <label for="empno">Empno:</label>
      <input type="text" class="form-control" placeholder="Enter empno" name="empno">
    </div>
    <div class="mb-3">
      <label for="ename">Ename:</label>
      <input type="text" class="form-control" placeholder="Enter ename" name="ename">
    </div>
    <div class="mb-3">
      <label for="sal">Salary:</label>
      <input type="text" class="form-control" placeholder="Enter Salary" name="sal">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>


<jsp:include page="../footer.jsp"/>