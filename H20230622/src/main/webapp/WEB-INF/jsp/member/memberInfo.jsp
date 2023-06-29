<%@page import="com.yedam.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"></jsp:include>
<%
MemberVO member = (MemberVO) request.getAttribute("info");
%>
<form action="modifyMember.do">
	<input type="hidden" name="id" value="<%=member.getUserId() %>">
		<table class="table">

		<tr>
			<td colspan="2" align="center"><img width="150px"
				src="imgs/<%=member.getUserImg()%>"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=member.getUserId()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=member.getUserName()%></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input name="phone" value="<%=member.getUserPhone()%>"></td>
		</tr>
		<tr>
		<tr>
			<th>주소</th>
			<td><input name="addr" value="<%=member.getUserAddr()%>">
			</td>
		</tr>
		<th>생일</th>
		<td><input type="text" name="ubirth"
			value="<%=member.getUserBirth()%>" readonly></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="정보변경">
			</td>
		</tr>
	</table>
</form>

<jsp:include page="../footer.jsp"></jsp:include>