<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>설문 결과</title>
	</head>
	<body>
		<h2>설문 결과</h2>
		<ul>
			<c:forEach var="response" items="${answer.responses}" varStatus="status">
			<li>${status.count}번 문항: ${response}</li>
			</c:forEach>
		</ul>
		<p>응답자 위치: ${answer.res.location}</p>
		<p>응답자 나이: ${answer.res.age}</p>
	</body>
</html>