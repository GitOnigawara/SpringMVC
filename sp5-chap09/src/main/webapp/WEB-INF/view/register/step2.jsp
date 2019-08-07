<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><spring:message code="member.register" /></title>
</head>
<body>
	<h2><spring:message code="member.info"/></h2>
	<form:form action="step3" method="POST" modelAttribute="memberRegister">
		<label for="email"><spring:message code="email" /></label>
		<form:input path="email" />
		<br />
		<label for="name"><spring:message code="name" /></label>
		<form:input path="name" />
		<br />
		<label for="password"><spring:message code="password" /></label>
		<form:password path="password" />
		<br />
		<label for="confirmPassword"><spring:message code="password.confirm" /></label>
		<form:password path="confirmPassword" />
		<br />	
		<input type="submit" value="<spring:message code="register" />" />
	</form:form>
</body>
</html>