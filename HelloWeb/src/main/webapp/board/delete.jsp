<%@page import="com.yedam.board.tblBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
	<%
		String bid = request.getParameter("no");
		int bno = Integer.parseInt(bid);
		tblBoardDao dao = tblBoardDao.getInstance();
		boolean result = dao.delete(bno);
		
		response.sendRedirect("blist.jsp");
	%>
</body>
</html>