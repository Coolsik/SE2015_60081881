<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>성적열람</title>
</head>
<body>
	<h1>성적열람 화면</h1>
	<b>${userSession.getName()} 학생</b>
	<br />
	<c:set var="userName" value="${userSession.getName()}" />

	<table border="1">
		<thead>
			<tr>
				<th>강좌번호</th>
				<th>과목명</th>
				<th>담당교수</th>
				<th>개설년도</th>
				<th>학년</th>
				<th>학점</th>
				<th>정원</th>
				<th>평점</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${courseArray}" var="item">
				<td><c:out value="${item.courseNumber}" /></td>
				<td><c:out value="${item.courseName}" /></td>
				<td><c:out value="${item.profId}" /></td>
				<td><c:out value="${item.year}" /></td>
				<td><c:out value="${item.grade}" /></td>
				<td><c:out value="${item.credit}" /></td>
				<td><c:out value="${item.limit}" /></td>
				<td><c:out value="${item.score}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>