/**
 * main6
 */

 const str = `Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s`;
  
 const strAry = str.split(' ')
 
 let outer = document.querySelector('div.outer');
 strAry.forEach(function (word){
	 let span = document.createElement('span');
	 span.innerText = word;
	 outer.appendChild(span);
 })