<%@page import="com.yedam.board.tblBoardVO"%>
<%@page import="com.yedam.board.tblBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<!-- 글번호 1건 조회/ 조회한 정보 페이지 작성 -->
	<%
		String bid = request.getParameter("no");
		int bno = Integer.parseInt(bid);
		tblBoardDao dao = tblBoardDao.getInstance();
		tblBoardVO brd = dao.select(bno);
		dao.updateCnt(bno);
	%>
	<table border='1'>
		<tr>
			<th>글번호</th>
			<td>
				<%=brd.getBrdNo() %>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<%=brd.getBrdTitle() %>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				<%=brd.getBrdWriter() %>
			</td>
		</tr>
		<tr>
			<td colspan="2"><textarea rows="3" cols="30"><%=brd.getBrdContent() %></textarea></td>
		</tr>
		<tr>
		<td colspan="2" align="center">
		<button a href="">수정</button><button>삭제</button>
		</td>
		</tr>
	</table>
	<br>
	<a href="blist.jsp">목록으로</a>
</body>
</html>