/** 
 * main3.js
 */
console.log('main3.js');
 let students = [
	 {name: "홍길동", age: 22, score: 85},
	 {name: "김김김", age: 25, score: 75},
	 {name: "박박박", age: 21, score: 95}
 ]
 
 function makeTr(obj = {}){
	 let tr = document.createElement('tr');
	 for(let prop in obj){
		 let td = document.createElement('td');
		 td.innerText = obj[prop];
		 tr.appendChild(td);
	 }
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', delFnc);
	td.appendChild(btn);
	tr.appendChild(td);	 
	 return tr;
 }
 function delFnc(event){
	 event.target.parentElement.parentElement.remove();
 }
 

 
 //배열의 값을 활용해서 목록에 정보생성.
 for(let student of students){
	 // student : {name: "홍길동", age: 22, score: 85}
	 let tr = makeTr(student);//tr생성
	 document.getElementById('target').appendChild(tr);
 }