<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>

<h2>Product Modify</h2>
<form action="/prodCtrl/update" method="post" enctype="multipart/form-data">
<input type="hidden" name="pno" value="${pvo.pno }">
<table class="table">
  <tr>
    <th>속성</th>
    <th>속성 값</th>
  </tr>
  <tr>
    <td>PNO</td>
    <td>${pvo.pno }</td>
  </tr>
  <tr>
    <td>Writer</td>
    <td>${pvo.writer }</td>
  </tr>
  <tr>
    <td>Reg At</td>
    <td>${pvo.regAt }</td>
  </tr>
  <tr>
    <td>Mod At</td>
    <td>${pvo.modAt }</td>
  </tr>
  <tr>
    <td>Read Count</td>
    <td>${pvo.readCount - 1 }</td>
  </tr>
  <tr>
    <td>Product Name</td>
    <td><input type="text" name="pname" value="${pvo.pname }" class="form-control" required></td>
  </tr>
  <tr>
    <td>Price</td>
    <td><input type="text" name="price" value="${pvo.price }" class="form-control" required></td>
  </tr>
  <tr>
    <td>Made By</td>
    <td><input type="text" name="madeBy" value="${pvo.madeBy }" class="form-control" required></td>
  </tr>
  <tr>
    <td>Category</td>
    <td><input type="text" name="category" value="${pvo.category }" class="form-control" required></td>
  </tr>
   <tr>
    <td>Description</td>
    <td><textarea name="description" class="form-control">${pvo.description }</textarea></td>
  </tr>
  <tr>
    <td>Image File</td>
    <td>${pvo.imageFile }
    <input type="hidden" name="imageFile" value="${pvo.imageFile }">
    </td>
  </tr>
  <tr>
    <td>Image File:</td>
    <td>
    <input type="file" class="form-control" id="file" name="new_imageFile"
     accept="image/png, image/jpeg, image/gif">
     </td>
  </tr>
  <tr>
  <td colspan="2" class="text-center">
  	<button type="submit" class="btn btn-danger">SUBMIT</button>
  </td>
  </tr>
</table>
</form>  
<jsp:include page="../footer.jsp"/>