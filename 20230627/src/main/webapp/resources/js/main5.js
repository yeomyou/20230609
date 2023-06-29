document.querySelectorAll('#page_content-wrapper table').forEach(function(tbl){
	tbl.innerHTML = "";
	
});
document.querySelectorAll('#page_content-wrapper h3').forEach(function(elem){
	elem.remove();
	
});


const array1 = ['a','b','c'];

array1.forEach(function(element,idx,ary){
	console.log(element,idx,ary);
})