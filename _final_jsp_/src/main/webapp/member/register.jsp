<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp" />
<jsp:include page="../nav.jsp" />

<form action="/memCtrl/insert" method="post">
  <div class="mb-3 mt-3">
    <label for="email" class="form-label">Email:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
  </div>
  <div class="mb-3">
    <label for="pwd" class="form-label">Password:</label>
    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
  </div>
  <div class="mb-3">
    <label for="nick" class="form-label">NickName:</label>
    <input type="text" class="form-control" id="nick" placeholder="Enter NickName" name="nickName">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="../footer.jsp" />
