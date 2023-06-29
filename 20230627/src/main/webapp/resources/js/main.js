/**
 * main.js
*/

console.log("main.js");

let obj = {name: "홍길동", age: 21, phone: "010-1111-1234"}
console.log(obj['age']);
console.log(obj.name);

for(let prop in obj){
	console.log("속성:" + prop + ", 값:" + obj[prop]);
}


let ary = []
ary.push({name: "김민수", age: 24, phone: "010-2222-2222"})
ary.push(obj);
ary.push("황영길");
ary.pop();

console.log(ary);

for(let val of ary){
	for (let prop in val){
		console.log(val[prop]);
	}
}

let ulTag = document.createElement('ul');

for(let val of ary){
	
	let liTag = document.createElement('li');
	liTag.innerText = val['name'];
	ulTag.appendChild(liTag);
	
}
console.log(ulTag);

document.getElementById('page-content-wrapper').appendChild(ulTag);

