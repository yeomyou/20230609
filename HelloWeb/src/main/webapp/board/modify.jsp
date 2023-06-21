<%@page import="com.yedam.board.tblBoardVO"%>
<%@page import="com.yedam.board.tblBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
</head>
<body>
	<form action="../modify">
		<table border="1">
			<%
			String bid = request.getParameter("no");
			int bno = Integer.parseInt(bid);
			tblBoardDao dao = tblBoardDao.getInstance();
			tblBoardVO brd = new tblBoardVO();

			response.sendRedirect("blist.jsp");
			%>
			<tr>
				<th>글번호</th>
				<td><input type="text" readonly value="<%=brd.getBrdNo()%>">
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" <%=brd.getBrdNo()%>>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" readonly value="<%=brd.getBrdWriter()%>">
			</tr>
			<tr>
				<td colspan="2"><textarea rows="3" cols="30"><%=brd.getBrdContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">수정</button>
				</td>
			</tr>


		</table>
	</form>
</body>
</html>