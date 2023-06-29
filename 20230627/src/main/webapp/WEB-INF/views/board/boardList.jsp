<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>글목록</h3>

<table class="table">

	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach items="${boards }" var="board">
				<tr>
					<td>${board.brdNo }</td>
					<td><a href="boardDetail.do?bno=${board.brdNo }">${board.brdTitle }</a></td>
					<td>${board.brdWriter }</td>
					<td>${board.createDate }</td>
					<td>${board.clickCnt }</td>
				</tr>
			</c:forEach>
	</tbody>

</table>