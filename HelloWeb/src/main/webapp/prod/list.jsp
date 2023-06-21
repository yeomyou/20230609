<%@page import="com.yedam.common.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<ul>
	<%
	BoardDao dao = new BoardDao();
	List<BoardVO> list = dao.showList();
	for (BoardVO vo : list) {
	%>
	<li>게시글: <%=vo.getTitle()%></li>
	<%
	}
	%>
</ul>
	<a href="../second">secondservlet</a>
</body>
</html>