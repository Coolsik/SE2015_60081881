<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>수강신청</title>
</head>
<body>
	<h1>수강신청 화면</h1>
	<b>${userSession.getName()} ${userSession.getType()}</b>님 환영합니다.
	<br />
	<c:set var="usertype" value="${userSession.getType()}" />
	<c:choose>
		<c:when test="${usertype == '교수'}">
			<a
				href="${pageContext.request.contextPath}/SubjectController/chooseSubject">강의개설</a>
			<a
				href="${pageContext.request.contextPath}/SubjectController/submitScore">성적부여</a>
		</c:when>
		<c:otherwise>
			<a
				href="${pageContext.request.contextPath}/SugangController/chooseSubject">수강신청</a>
			<a
				href="${pageContext.request.contextPath}/SubjectController/checkScore">성적열람</a>
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
	<input type="hidden" name="errorMessage" value="${errorMessage}" />


	<script language="JavaScript">
		var error = "${errorMessage}";

		if (error) {
			alert("${errorMessage}");
			//if(error =="makeSuccess"){
			location.href = '${pageContext.request.contextPath}/loginController/login.do';
			//}
		}
	</script>
</body>
</html>

