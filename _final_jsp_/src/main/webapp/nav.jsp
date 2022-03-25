<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="p-5 bg-primary text-white text-center">
  <h1>My Final JSP EX</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="/">INDEX</a>
      </li>
      <c:choose>
      	<c:when test="${ses.email ne '' && ses.email ne null }">
      	<li class="nav-item">      	
      	<c:choose>
      		<c:when test="${ses.grade > 100 }">
      			<a class="nav-link" href="/memCtrl/list">
      			${ses.nickName }(${ses.email })</a>	
      		</c:when>      		
      		<c:otherwise>
      			<a class="nav-link" href="/memCtrl/detail?email=${ses.email }">
      			${ses.nickName }(${ses.email })</a>
      		</c:otherwise>
      	</c:choose>        
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="/memCtrl/logout">Logout</a>
      	</li>	
      	</c:when>
      	<c:otherwise>
      	<li class="nav-item">
        	<a class="nav-link" href="/memCtrl/register">JOIN</a>
      	</li>
      	<li class="nav-item">
        <a class="nav-link" href="/member/login.jsp">Log In</a>
      	</li>
      	</c:otherwise>      
      </c:choose>
     	<li class="nav-item">
        		<a class="nav-link" href="/prodCtrl/list">Product List</a>
      	</li>
      	<li class="nav-item">
        		<a class="nav-link disabled" href="#">Disabled</a>
      	</li>
    </ul>
  </div>
</nav>

<div class="container mt-5">