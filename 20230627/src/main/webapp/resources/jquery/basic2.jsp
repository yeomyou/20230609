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
	//= document.addEventListener('DOMContentLoaded', function(){
		$('li:nth-child(1)').css('background', 'red');
		
		let li = $('<li />').text('Melon');
		console.log(li);
		
		$('ul').append(li); // ul요소의 하위에 li 요소를 추가.
		
		//이벤트 : on
		//$('body>button').on('click', function(){
		//	//body 다음 			
		//	$('li:nth-child(1)').remove();
		//	})
		$('#addBtn').on('click', addBtn);
		function addBtn(e){
			let li = $('<li />').text($('#userInput').val()).append($('<button/>').text('삭제').on('click', delBtn));
	
			$('ul').append(li);
			// $('li:nth-child(2)').after(li);
			// $('li:nth-child(2)').before(li);
			//init.
			$('#userInput').val('');
			
		}
			$('ul').wrap($('<div />'));
		
		//버튼추가
		$('li').append($('<button/>').text('삭제').on('click', delBtn));
		function delBtn(e){
				// e.currentTarger : js의 DOM
				// $(e.currentTarger) :  jquery 객체
				$(e.currentTarget).parent().remove();
				//타겟(=버튼) 의 부모 삭제
		}
	});
</script>

</head>
<body>
	<button>요소 제거</button>
	<input id = "userInput"><button id="addBtn">추가</button>
	<ul>
		<li>Apple</li>
		<li>Banana</li>
		<li>Cherry</li>		
	</ul>

</body>
</html>