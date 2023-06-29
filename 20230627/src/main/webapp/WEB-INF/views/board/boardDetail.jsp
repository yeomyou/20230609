<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

				<tr>
					<td>${board.brdNo }</td>
					<td>${board.brdTitle }</td>
					<td>${board.brdWriter }</td>
					<td>${board.createDate }</td>
					<td>${board.clickCnt }</td>
				</tr>
				<tr>
				<td><textarea id="content" name="content">${board.brdContent }</textarea></td>
				</tr>

	</tbody>

</table>
<script>
#content{
	diplay:inline-block;
	width:1000px;
	height:300px;
}
</script>