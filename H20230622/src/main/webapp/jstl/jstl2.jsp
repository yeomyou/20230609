<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 if (30>20){}
%>
<c:if test="${30>20}">
	<p>true</p>
</c:if>

<c:set var="score" value="50"></c:set>
<c:out value="${score }"></c:out>


<c:set var="mathScore" value="80"></c:set>
<c:choose>
	<c:when test="${mathScore>90}">
	<p>A학점입니다.</p>
	</c:when>
	<c:when test="${mathScore>80}">
	<p>B학점입니다.</p>
	</c:when>
	<c:when test="${mathScore690}">
	<p>C학점입니다.</p>
	</c:when>
	<c:otherwise>
	<p>F학점입니다.
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${!empty loginId }">
	<p>ID: <c:out value="${loginName }"></c:out></p>
	</c:when>
	<c:otherwise>
	<p>손님입니다.</p>
	</c:otherwise>
</c:choose>

</body>
</html>