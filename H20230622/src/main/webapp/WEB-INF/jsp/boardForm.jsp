<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>

<c:if test="${not empty ErrorMsg }">
	<p>
		메세지: <b>${ErrorMsg }</b>
	</p>

</c:if>
<h3>게시글 등록</h3>
<form action="addBoard.do" method="post">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
			<c:choose>
				<c:when test="${empty loginId }">
					<input type="text" name="writer" readonly>
				</c:when>
				<c:otherwise>
					<input type="text" name="writer" readonly value="${loginId }">
				</c:otherwise>
			</c:choose>
			</td>

		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols="30" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<c:choose>
				<c:when test="${empty loginId }">
				<input type="submit" value="저장" disabled> 
				</c:when>
				<c:otherwise>
				 <input type="submit" value="저장">
				 <input type="reset" value="초기화">
				</c:otherwise>
				</c:choose>
				</td>
		</tr>
	</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>