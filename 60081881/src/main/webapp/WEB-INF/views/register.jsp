<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>Register</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<form action="${pageContext.request.contextPath}/loginController/register.do" method="post">
	<table>
	<tr>
	<td>ID</td>
	<td><input type="text" name="userID"><br /></td>
	</tr>
		<tr>
	<td>이름</td>
	<td><input type="text" name="userName"><br /></td>
	</tr>
	<tr>
	<td>Password</td>
	<td><input type="password" name="userPassword"><br/></td>
	</tr>
	<tr>
	<td> </td>
	<td><input type="radio" name="radio" value="학생">학생
	<input type="radio" name="radio" value="교수">교수
	<input type="radio" name="radio" value="관리자">관리자</td>
	</tr>
	</table>
		<input type="submit" value="가입신청">
	</form>
</body>
</html>