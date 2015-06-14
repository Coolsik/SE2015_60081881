<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>강좌개설</title>
</head>
<body>
<h1>강좌개설 화면</h1>
 <b>${userSession.getName()} 교수</b><br/>
      <c:set var="userName" value="${userSession.getName()}"/>
     
<form action="${pageContext.request.contextPath}/SubjectController/makeSubject" method="post">
      <table>
      <tr>
      <td>강좌번호</td>
      <td>과목명</td>
      <td>연도</td>
      <td>학년</td>
      <td>정원</td>
      <td>학점</td>
      </tr>
      <tr>
      <td><input type="text" name="courseNum"><br /></td>
      <td><input type="text" name="courseName"><br /></td>
      <td><input type="text" name="year"><br /></td>
      <td><input type="text" name="grade"><br /></td>
      <td><input type="text" name="limit"><br /></td>
      <td><input type="text" name="credit"><br /></td>
      </tr>
      <td><input type="submit" value="개설"></td>
      </table>
</form>
      
</body>
</html>