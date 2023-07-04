<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="resources/jquery/jquery-3.7.0.min.js"></script>
<script>
	let today = new Date('Apr 4, 2023, 12:00:00 AM');
	Date.prototype.timeFormat = function(){
		console.log(this.getFullYear());
		let yyyy = this.getFullYear();
		let mm = this.getMonth() +1;
		let dd = this.getDate();
		
		return yyyy+ '-' + ('0'+mm).slice(-2) + '-' + ('0'+dd).slice(-2);
	}
	console.log(today.timeFormat());


	$(document).ready(function() {
		$.ajax({
			url: 'memberListJson.do',
			method: 'get',
			success: function(result){
				console.log(result);
				result.forEach(item => {
					let tr =$('<tr />').append(
							
							$('<td/>').text(item.userId),
							$('<td/>').text(item.userName),
							$('<td/>').text(new Date(item.userBirth).timeFormat()),
							$('<td/>').text(item.userPhone),
							$('<td/>').append(
								$('img')
							.attr('src' , 'images/'+item.userImg)
							.attr('width', '25px')),
							$('<td />').append($('<button/>').text('삭제').on('click', delFnc)  )
							
				)
				tr.on('click', modifyFnc)
					
					
				//$('tr:nth-child(-n+5)').on('click', modifyFnc);
				$('#list').append(tr);
				})
			},
			
			error: function(err){
				console.log(err);
			}
			
		});
		function delFnc(e){
			console.log(e);
			console.log($(this).parent().parent().find('td:nth-child(1)').text());
			let id = $(this).parent().parent().find('td:nth-child(1)').text()
			//e.stopPropagation() // 상위로 이벤트 전달 차단.
			$.ajax({
				url: 'memberDelJson.do',
				method: 'post',
				data: {uid: id},
				success: function(result){
					console.log(result);
					if(result.retCode == 'Success'){
					$(this).parent().parent().remove();						
					}else{
						alert('삭제실패');
					}
				},
				error: function(err){
					console.log(err);
				}
			})
		}		
		function modifyFnc(e){
			console.log(this);
			console.log($(this).children().eq(0).text());
			console.log($(this).find('td:nth-child(1)').eq(0).text());
			let id = $(this).find('td:nth-child(1)').eq(0).text();
			
			$.ajax({
				url: 'memberInfoJson.do',
				method: 'post',
				data: {uid: id},
				success: function(result){
					console.log(result);
					$('#uid').val(result.userId);
					$('#upw').val(result.userPw);
					$('#uname').val(result.userName);
					$('#uph').val(result.userPhone);
					$('#uad').val(result.userAddr);
					$('#ubi').val(new Date(result.userBirth).timeFormat());
					
				},
				error: function(err){
					console.log(err)
				}
			})
		}
		//등록버튼 클릭시
		$('form[name="myFrm"]').on('submit', submitForm);
				
		function submitForm(e){
			e.preventDefault();
			console.log(e);
			
			$.ajax({
				url: $('form[name="myFrm"]').attr('action'),
				method: 'post',
				data: $('form[name="myFrm"]').serialize(),//{uid: }//"uid="+$('input[name="uid"]').val(),
				success: function(result){
					console.log(result);
					result.forEach(item=>{
							let tr =$('<tr />').append(
									
									$('<td/>').text(item.userId),
									$('<td/>').text(item.userName),
									$('<td/>').text(new Date(item.userBirth).timeFormat()),
									$('<td/>').text(item.userPhone)
						)
					$('#list').append(tr);
					})
				},
				error: function(err){
					console.log(err);
				}
				
			});
		}//submit
		
		
		$('#modi').on('click', editForm);
		
		function editForm(e){
			e.preventDefault();
			console.log(e);
			
			$.ajax({
				url: 'memberEditJson.do',
				method: 'post',
				//data:  $('memberEditJson.do').serialize(),
				data: {
					uid : $('#uid').val(),
					upw : $('#upw').val(),
					uph : $('#uph').val(),
					uad : $('#uad').val()
				},
				success: function(result){
					//Array.prototype.forEach(function(item, idx, ary){})
					//console.log(result);
					//console.log($('#list tr'));
					$('#list tr').each(function (idx, item) {
						console.log(idx,item);
						if($(item).children().eq(0).text() == result.userId){
							$(item).children().eq(3).text(result.userPhone);
						}
					});

				},
				error: function(err){
					console.log(err);
				}
				
			})
			
		}
		
		
	})
</script>
<h3>JQUERY 연습 AJAX : SinglePage Application</h3>
<form name="myFrm" action="memberAdd.do">
	<table class="table">
		<tr>
			<th>아이디</th>	
			<td><input type="text" name="uid" id="uid" value="newbie"></td>
		</tr>
		<tr>
			<th>비밀번호</th>	
			<td><input type="password" name="upw" id="upw" value="1111"></td>
		</tr>
		<tr>
			<th>이름</th>	
			<td><input type="text" name="uname" id="uname" value="newbie"></td>
		</tr>
		<tr>
			<th>연락처</th>	
			<td><input type="text" name="uph" id="uph" value="010-1111-4444"></td>
		</tr>
		<tr>
			<th>주소</th>	
			<td><input type="text" name="uad" id="uad" value="Dokdo"></td>
		</tr>
		<tr>
			<th>생일월일</th>	
			<td><input type="date" name="ubi" id="ubi" value="1984-04-04" ></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="초기화">		
				<input type="button" value="변경" id="modi">
			</td>
		</tr>
	</table>
</form>

<br><br><br>

<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>생일</th>
			<th>연락처</th>
			<th>사진</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody id="list">

	</tbody>
</table>