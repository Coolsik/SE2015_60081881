<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>성적부여</title>
</head>
<body>
	<h1>성적부여 화면</h1>
	<b>${userSession.getName()} ${userSession.getType()}</b>님 환영합니다.
	<br />

	<table border="1">
		<th>학생</th>
		<th>성적</th>
		<th>성적부여</th>
		<c:forEach items="${courseArray}" var="item">
			<form action="${pageContext.request.contextPath}/SubjectController/submitScore" method="post">
			<tr>
				<input type="hidden" value ="${item.id}" name ="id" />
				<td><input type="hidden" value ="${item.courseNumber}" name ="cnum" /><c:out value="${item.id}" /></td>
				<td><c:out value="${item.score}" /></td>
				<td><input type="text" name ="score" /></td>
				<td><input type="submit" value = "성적부여"/></td>
			</tr>
			</form>
		</c:forEach>
	</table>
<a href = "${pageContext.request.contextPath}/SubjectController/submitScore">성적열람 </a>


</body>
</html>

