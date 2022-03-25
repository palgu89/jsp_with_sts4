<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>

<form action="/prodCtrl/insert" method="post" enctype="multipart/form-data">
  <div class="mb-3 mt-3">
    <label for="pname" class="form-label">Product Name:</label>
    <input type="text" class="form-control" id="pname" placeholder="Enter Product Name" name="pname">
  </div>
  <div class="mb-3">
    <label for="price" class="form-label">Price:</label>
    <input type="text" class="form-control" id="price" placeholder="Enter price" name="price">
  </div>
  <div class="mb-3">
    <label for="madeBy" class="form-label">Manufacturer:</label>
    <input type="text" class="form-control" id="madeBy" placeholder="Enter Manufacturer" name="madeBy">
  </div>
  <div class="mb-3">
    <label for="writer" class="form-label">Writer:</label>
    <input type="text" class="form-control" value="${ses.email }" name="writer" readonly>
  </div>
  <div class="mb-3">
    <label for="category" class="form-label">Category:</label>
    <input type="text" class="form-control" id="category" placeholder="Enter Category" name="category">
  </div>
  <div class="mb-3">
    <label for="desc" class="form-label">Description:</label>
    <textarea class="form-control" id="description" placeholder="Enter Descripition" name="description">
    </textarea>    
  </div>
  <div class="mb-3">
    <label for="file" class="form-label">Image File:</label>
    <input type="file" class="form-control" id="file" name="imageFile"
     accept="image/png, image/jpeg, image/gif">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
  
<jsp:include page="../footer.jsp"/>