<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><spring:message code="member.register" /></title>
	<style>
		.errMsg {
			color:rgba(255, 0, 0, 0.5);
		}
	</style>
</head>
<body>
	<h2><spring:message code="member.info"/></h2>
	<form:form action="step3" method="POST" modelAttribute="memberRegister">
		<label for="email"><spring:message code="email" /></label>
		<br />
		<form:input path="email" />
		<form:errors path="email" element="label" delimiter=" / " class="errMsg" />
		<br /><br />
		<label for="name"><spring:message code="name" /></label>
		<br />
		<form:input path="name" />
		<form:errors path="name" element="label" delimiter=" / " class="errMsg" />
		<br /><br />
		<label for="password"><spring:message code="password" /></label>
		<br />
		<form:password path="password" />
		<form:errors path="password" element="label" delimiter=" / " class="errMsg" />
		<br /><br />
		<label for="confirmPassword"><spring:message code="password.confirm" /></label>
		<br />
		<form:password path="confirmPassword" />
		<form:errors path="confirmPassword" element="label" delimiter=" / " class="errMsg" />
		<br /><br />
		<input type="submit" value="<spring:message code="register" />" />
	</form:form>
</body>
</html>