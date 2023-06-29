<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>생일</th>
			<th>번호</th>
			<th>주소</th>
			<th>사진</th>
		</tr>
	</thead>
	<tbody>
	    <c:forEach var="member" items="${members }">
	    	<tr>
	    		<td><c:out value="${member.userId }"/></td>
	    		<td><c:out value="${member.userName }"/></td>
	    		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.userBirth }"/></td>
	    		<td><c:out value="${member.userPhone }"/></td>
	    		<td><c:out value="${member.userAddr }"/></td>
	    		<td><img width="20px" src='images/${member.userImg }'></td>
	    		
	    	</tr>
	    </c:forEach>
	</tbody>

</table>