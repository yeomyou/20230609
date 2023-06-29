<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>검색조건</h3>
시도:<select id="search">
	
	</select>
<button id="searchBtn">조회</button>
<br>
	<div id = "show">
		<table border="1">
			<thead>
			<tr>
			<th>센터 id</th><th>센터명</th><th>연락처</th><th>우편번호</th><th>시도</th>
			</tr>
			</thead>
			<tbody id="list">
	
			</tbody>
		</table>
	</div>
<script>
	let totalData = [];
	let sidoAry = [];

	let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=100&serviceKey=66NjzBri27RIAoXACasSVOCzz0AQ%2BCaQW2BqMr3pq%2BUpGTNBA%2FbAIN0oUOluQPdtFyNgn8SHgY8VnOV0TeWedQ%3D%3D`;
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', url);
	xhtp.send();
	
	xhtp.onload = function() {
		let tbody= document.getElementById("list");
		let data = JSON.parse(xhtp.responseText);
		console.log(data.data);
		totalData = data.data;
		for(let i=0; i<data.data.length; i++){
			tbody.appendChild(makeRow(data.data[i]));
			if(!(sidoAry.includes(data.data[i].sido))){
				sidoAry.push(data.data[i].sido);
			}
		}
		
		
		//sido 정보 = totalSido
	

		for(let j=0; j<sidoAry.length; j++){
			let option = document.createElement('option');
			option.setAttribute('value', sidoAry[j]);
			option.innerText = sidoAry[j];
			document.getElementById('search').appendChild(option);
		}
	}
	//보여줄 필드
	let fields = ['id','centerName','phoneNumber','sido','zipCode'];
	//센터 정보 생성.
	function makeRow(obj={}){
		let tr = document.createElement('tr');
		for(let field of fields){
			let td = document.createElement('td');
			if(field == 'centerName'){
				let ahref = document.createElement('a');
				ahref.setAttribute('href', 'map.jsp?lat='+obj.lat+'&lng='+obj.lng+'&centerName='+obj.centerName);
				ahref.target = "_blank";
				ahref.innerText = obj[field];
				td.appendChild(ahref);
				tr.appendChild(td);
			}else{
			td.innerText = obj[field];
			tr.appendChild(td);
			}
		}
		return tr;
	}
	document.querySelector('#searchBtn').addEventListener('click', findFnc2);
	
	function findFnc2(){
		console.log(totalData);
		//1.기존목록 clear 
		document.getElementById('list').innerHTML = "";
		//2 입력값 비교. 3.tbody.appendChild(makeRow(obj));
		for(let obj of totalData){
			console.log(obj);
			if(obj.sido == document.getElementById('search').value){
				document.getElementById('list').appendChild(makeRow(obj));
				//document.getElementById('list') <- tbody
			}
		}
	}
	
	function findFnc1(){
			let trs =document.querySelectorAll('tbody tr');
			let ary = [];
				
			for(let tr of trs){
				if(tr.children[3].innerText == document.getElementById('search').value){
					ary.push(tr);
				}
			}
			console.log(ary);
			document.getElementById('list').innerHTML = "";
			for(let tr of trs){
				document.getElementById('list').appendChild(makeRow(tr));
			
		}
	}

</script>
</body>
</html>