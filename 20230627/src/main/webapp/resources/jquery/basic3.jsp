<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src='jquery-3.7.0.min.js'></script>
<script>
	$(document).ready(function(){
		//$('button').on('click', function(){
			//let tr = $('<tr />');
			//tr.append($('<td/>').text( $('input.id').val()));
			//tr.append($('<td/>').text( $('input.name').val()));
			//$('#target').append(tr);
			//$('input.id').clone().appendTo(".clone");
			//$('input.name').clone().appendTo(".clone");
			
			
		//})
		
		$('button').on('click', addFnc2);
		
		function addFnc(e){
			let tr = $('<tr />');
			tr.append($('<td/>').text( $('input.id').val()));
			tr.append($('<td/>').text( $('input.name').val()));
			$('#target').append(tr);
		}
		function addFnc2(e){
			if($('input.id').val() == false || $('input.name') == false){
				alert('값을 입력하세요')
				return;
			}
			let cloned = $('.clone)').clone();
			cloned.removeClass('clone');
			cloned.css('display', 'table-row');
			cloned.find('td.id').text($('input.id').val());
			cloned.find('td.name').text($('input.name').val());
			$('#target').append(cloned);
			
			//init
			$('input.id').val('')
			$('input.name').val('')
		}
			
		
		
	})
</script>
</head>
<body>
	ID:<input class="id">
	NAME:<input class="name">
	<button>등록</button>
	<br>
	<table border="1">
		<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
		</tr>
		</thead>
		<tbody id="target">
		<tr class = "clone" style="display=:none;">
			<td class="id">HONG</td>
			<td class="name">HONG1</td>
		</tr>
		</tbody>		
	</table>
</body>
</html>