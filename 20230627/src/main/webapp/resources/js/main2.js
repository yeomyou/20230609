/**
 * main2.js
 */

console.log("main2.js");

//버튼 : 클릭 이벤트 등록

	document.getElementById('saveBtn').addEventListener('click', function(e){
	let name= document.getElementById('name').value;
	let age= document.getElementById('age').value;
	let score= document.getElementById('score').value;	
	
	let obj = {
		name : name,
		age : age,
		score : score
	}
	let tr = document.createElement('tr');
	//속성값,
	for(let prop in obj){
	let td = document.createElement('td');
		td.innerText = obj[prop];
		tr.appendChild(td);
	}
	//삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', function(e){
		e.target.parentElement.parentElement.remove();
		//<tr-td-btn-td-tr>이므로tr 삭제.
	});
	
	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	
	console.log(tr);
	document.getElementById('target').appendChild(tr);
	
	document.getElementById('name').value="";
	document.getElementById('age').value="";
	document.getElementById('score').value="";
	document.getElementById('name').focus();
})
