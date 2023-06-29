<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<h3>게시판</h3>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="vo">
			<tr>
				<td><c:out value="${vo.brdNo }" /></td>
				<td><a href="getBoard.do?bno=${vo.brdNo }">${vo.brdTitle }</a></td>
				<td>${vo.userName }</td>
				<td>${vo.clickCnt }</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
<br>
<div class="center">
	<div class="pagination">
		<c:if test="${page.prev }">
			<a href="boardList.do?page=${page.startPage - 1 }"> prev </a>
		</c:if>
		<!-- 현재페이지 -->
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
			<c:choose>
				<c:when test="${i == curPage }">
					<a href="boardList.do?page=${i }" class="active"><c:out
							value="${i }"></c:out></a>
				</c:when>
				<c:otherwise>
					<a href="boardList.do?page=${i }"><c:out value="${i }"></c:out></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<!-- 다음페이지 -->
		<c:if test="${page.next }">
			<a href="boardList.do?page=${page.endPage + 1 }"> next </a>
		</c:if>

	</div>
</div>

<br>
<jsp:include page="footer.jsp"></jsp:include>
