<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${content_path == null}">
	<c:set var="content_path" value="/content/member/login.jsp" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css" />
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.member == null}">
			<jsp:include page="content/member/login.jsp" />
		</c:when>
		<c:otherwise>
			<header id="header">
				<jsp:include page="/layout/gnb.jsp" />
			</header>
			<div class="page">
				<div id="left">
					<jsp:include page="/layout/sidebar.jsp" />
				</div>
				<div id="right">
					<jsp:include page="/layout/content.jsp" />
				</div>
			</div>
			<footer id="footer">
			
			</footer>
		</c:otherwise>
	</c:choose>
</body>
</html>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/common.js"></script>