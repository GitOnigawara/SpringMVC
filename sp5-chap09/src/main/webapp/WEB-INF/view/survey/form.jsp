<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>설문조사</title>
	</head>
	<body>
		<h2>설문조사</h2>
		<form method="POST">
			<c:forEach items="${questions}" var="qes" varStatus="status">
				<p>${qes.title}</p>
				<c:choose>
					<c:when test="${qes.choice}">
						<c:forEach items="${qes.options}" var="opt">
						<input type="radio" name="responses[${status.index}]" value="${opt}" />
						<label>${opt}</label>
						<br />
						</c:forEach>
					</c:when>
					<c:otherwise>
						<input type="text" name="responses[${status.index}]" />
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<p>응답자 위치</p>
			<input type="text" name="res.location" />
			<p>응답자 나이</p>
			<input type="text" name="res.age" />
			<br /><br />
			<input type="submit" value="제출" />
		</form>
	</body>
</html>