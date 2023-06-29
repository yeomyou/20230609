document.querySelector('a[href="index.html"]').addEventListener('click', function (e){
	e.preventDefault();
	console.log(e);
	let id = document.getElementById('inputEmail').value;
	let pw = document.getElementById('inputPassword').value;
	
	location.href="login.do?uid="+id+"&upw="+pw;
});