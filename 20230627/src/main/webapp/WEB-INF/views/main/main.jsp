<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Main Tiles</h3>

<table border="1">
	<tr>
		<th>이름</th>
		<td><input type="text" id="name" value="홍"></td>
	</tr>
	<tr>
		<th>나이</th>
		<td><input type="number" id="age" value="25"></td>
	</tr>
	<tr>
		<th>점수</th>
		<td><input type="number" id="score" value="50"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button class="btn btn-primary" id="saveBtn">저장</button>
		</td>
	</tr>
</table>
<br>
<h3>학생목록</h3>
<table id="list" border="1" class="table">
	<thead>
	<tr><th>이름</th>  <th>나이</th>  <th>점수</th> <th>삭제</th></tr>
	</thead>
	<tbody id="target"></tbody>
</table>

<style>
 div.outer {
 display:inline-block;
 width: 700px;
 height: 500px;
 background-color:yellow;
}
 .outer span{
 display:inline-block;
 width:120px;
 height:60px;
 margin: 2px;
 padding: 2px;
 background-color: red;
 }
</style>


<p id="time"></p>
<input type="text" id="userInput"><br>
<br>
<div class="outer" id="outer">
<span>Hello</span>
</div>
<script src="resources/js/main6.js"></script>
<script>

let secs = 100;
	setInterval(function(){
		//document.getElementById('time').innerText = new Date();
		document.getElementById('time').innerText = secs--;
	}, 1000);
	



const strArys = [];
let strs = '';
document.querySelectorAll('div.outer span').forEach(function(word){
	strs = word;
	strArys.push(strs);
});



strAry.push();


	document.getElementById('userInput').addEventListener('change', function(e){
		// this.value  = 이벤트를 받는 element.		
		let val = document.getElementById('userInput').value
		console.log(val);
		console.log(strArys);
		// strArys.innerText
		
			document.querySelectorAll('div.outer span').forEach(function(word){
				console.log('word'+word);
				if(val == word.innerText){
					word.remove();
					}
			});
		
	});
</script>


