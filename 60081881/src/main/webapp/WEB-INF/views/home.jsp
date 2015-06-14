<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>[mid]60081881_우웅식</h1>
	<P>The time on the server is ${serverTime}.</P>
	<form action="${pageContext.request.contextPath}/loginController/login.do" method="post">
	<table>
	<tr>
	<td>ID</td>
	<td><input type="text" name="userID"><br /></td>
	</tr>
	<tr>
	<td>Password</td>
	<td><input type="password" name="userPassword"><br/></td>
	</tr>
	</table>
		<input type="submit" value="로그인">
	</form>
	<button type="button" onclick="window.location.href='${pageContext.request.contextPath}/loginController/register.do'">회원가입</button>
	<script language="JavaScript">
		var error = "${errorMessage}";

		if (error) {
			alert("${errorMessage}");
			location.href = '${pageContext.request.contextPath}';
		}
	</script>
</body>
</html>
