<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>common_error</title>
</head>
<body>
<h2>common_error페이지</h2>
<h2>웁스! 잘못된 접근입니다. 관리자에게 문의하세요</h2>
e : ${e }
<hr>
메세지 : ${e.getMessage() }
<hr>
<c:forEach items="${e.getStackTrace() }" var="stack" >
	${stack.toString() }<br>
</c:forEach>
</body>
</html>