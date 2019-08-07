<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><spring:message code="member.register" /></title>
</head>
<body>
	<h2><spring:message code="term"/></h2>
	<p><spring:message code="term.contents"/></p>
	<form action="step2" method="post">
		<label for="agree"><spring:message code="term.agree"/></label>
		<input type="checkbox" name="agree" value="true" id="agree"/>
		<input type="submit" value="<spring:message code="btn.next" />">
	</form>
</body>
</html>