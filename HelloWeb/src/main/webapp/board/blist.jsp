<%@page import="java.util.List"%>
<%@page import="com.yedam.board.tblBoardDao"%>
<%@page import="com.yedam.board.tblBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판</h3>
	<table border='1'>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<%
			tblBoardDao dao = tblBoardDao.getInstance();
			List<tblBoardVO> list = dao.list();
			for (tblBoardVO vo : list) {
			%>
			<tr>
				<td><%=vo.getBrdNo()%></td>
				<td><a href="detail.jsp?no=<%=vo.getBrdNo()%>"><%=vo.getBrdTitle()%></a></td>
				<td><%=vo.getBrdWriter()%></td>
				<td><%=vo.getClickCnt() %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>