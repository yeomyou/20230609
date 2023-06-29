<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table class="table">
	<tr>
		<th>사진</th>
		<td><img class="image" width="100px" src='images/${member.userImg }'>
		<input type="file" id="image" style="display:none;"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><c:out value="${member.userName }" /></td>
	</tr>
	<tr>
		<th>아이디</th>
		<td class="uid">${member.userId }</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="text" class="passwd" name="pw"
			value="${member.userPw }"></td>
	</tr>
	<tr>
		<th>생일</th>
		<td><fmt:formatDate pattern="yyyy-MM-dd"
				value="${member.userBirth }" /></td>
	</tr>
	<tr>
		<th>번호</th>
		<td><input type="text" class="phone" value="${member.userPhone }"></td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" class="addr" value="${member.userAddr }"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button id="saveBtn">저장</button>
		</td>
	</tr>
</table>

<script>
	document.getElementById('image').addEventListener('change', function(e){
	 	console.log(e.target.files[0]);
	 	//multipart/form-data
	 	let formData = new FormData(); // <-- <form></form>
	 	formData.append('id', document.querySelector('td.uid').innerText);
	 	formData.append('image',e.target.files[0]);
		let xhtp = new XMLHttpRequest();
		xhtp.open('post','imageUpload.do');
		xhtp.send(formData);
		xhtp.onload = function(){
		let result = JSON.parse(xhtp.responseText);
		console.log(result)
			if(result.retCode == 'Success'){
				alert("성공");
				document.querySelector('img.image').src='images/'+result.path;
			}else if(result.retCode == 'Fail'){
				alert("이미지 업로드 실패");
			}else{
				alert("알수없는 코드");
			}
		}
		
	});

	//img 클릭 이벤트.
	document.querySelector('img.image').addEventListener('click', function(e){
		document.getElementById('image').click();
	});


	document.querySelector('#saveBtn').addEventListener('click', function(e){
		let id = document.querySelector('td.uid').innerText;
		let pw = document.querySelector('input.passwd').value;
		let ph = document.querySelector('input.phone').value;
		let ad = document.querySelector('input.addr').value;
		console.log(id, pw, ph, ad);
		let xhtp = new XMLHttpRequest();
		//get 방식
		//xhtp.open('get', 'memberModify.do?uid='+id+'&upw='+pw+'&uph='+ph+'&uad='+ad);
		//xhtp.send();
		
		//post 방식
		xhtp.open('post', 'memberModify.do')
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhtp.send('uid='+id+'&upw='+pw+'&uph='+ph+'&uad='+ad);
		
		xhtp.onload = function(){
			console.log(xhtp.responseText);
			let result = JSON.parse(xhtp.responseText);
			if(result.retCode == 'Success'){
				alert("저장성공");
			}else if(result.retCode == 'Fail'){
				alert("저장실패");
			}else{
				alert("알 수 없는 코드");
			}
		}
	});
</script>