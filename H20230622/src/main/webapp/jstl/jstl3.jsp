<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl3.jsp</title>
</head>
<body>

<%
	List<String> list = new ArrayList<>();
	for(int i=1; i<=10; i++){
		list.add(String.valueOf(i));
		
	}
	request.setAttribute("list", list);
%>
<h3>반복문.</h3>
<c:forEach begin="1" end="10" var="i" step="1">
<p><c:out value="${i}"></c:out></p>
</c:forEach>


<%
	for(String msg : list){}
%>
<c:forEach items="${list }" var = "msg">
	<p><c:out value="${msg}"></c:out></p>
</c:forEach>
</body>
</html>