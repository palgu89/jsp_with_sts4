<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />
<jsp:include page="nav.jsp" />

<h2>JavaServer Pages Technology</h2>
<div class="mt-4 p-5 bg-success text-white rounded">
	<h1>Welcome ${ses.nickName } ( ${ses.email } )</h1>
	<h3>Grade : ${ses.grade }, Last-Login : ${ses.lastLogin }</h3>
	<p>technology provides a simplified, fast way to create dynamic web
		content. JSP technology enables rapid development of web-based
		applications that are server- and platform-independent.</p>
</div>

<script>
	let msg_reg = '<c:out value="${msg_reg }"/>';
	let msg_login = '<c:out value="${msg_login }"/>';
	let msg_logout = '<c:out value="${msg_logout }"/>';
	let msg_resign = '<c:out value="${msg_resign }"/>';
	
	if(msg_reg.length > 0){
		alert("회원가입이 " + (parseInt(msg_reg) > 0 ? "완료되었습니다" : "실패하였습니다"));
	}else if (msg_login.length > 0) {
		alert("로그인 실패");
	}else if (msg_logout.length > 0) {
		alert("로그아웃 되었습니다");
	}else if (msg_resign.length > 0) {
		alert("회원탈퇴가 완료되었습니다");
	}
</script>
<jsp:include page="footer.jsp" />
