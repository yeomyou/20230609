/**
 * main4.js
 */
let jsonData = `[{"id":1,"first_name":"Wildon","last_name":"Rowcliffe","email":"wrowcliffe0@narod.ru","gender":"Male","salary":3380},
{"id":2,"first_name":"Ingelbert","last_name":"Hurtado","email":"ihurtado1@smh.com.au","gender":"Male","salary":2030},
{"id":3,"first_name":"Marley","last_name":"Glowinski","email":"mglowinski2@gnu.org","gender":"Female","salary":1337},
{"id":4,"first_name":"Torry","last_name":"Randall","email":"trandall3@globo.com","gender":"Polygender","salary":1296},
{"id":5,"first_name":"Ivory","last_name":"Cockerham","email":"icockerham4@cpanel.net","gender":"Female","salary":2907},
{"id":6,"first_name":"Michele","last_name":"Fidell","email":"mfidell5@illinois.edu","gender":"Female","salary":4178},
{"id":7,"first_name":"Myrtice","last_name":"MacAllister","email":"mmacallister6@delicious.com","gender":"Female","salary":3718},
{"id":8,"first_name":"Hewett","last_name":"Eburah","email":"heburah7@fda.gov","gender":"Male","salary":2524},
{"id":9,"first_name":"Jennine","last_name":"Warhurst","email":"jwarhurst8@theguardian.com","gender":"Female","salary":2761},
{"id":10,"first_name":"Eberto","last_name":"Eliyahu","email":"eeliyahu9@unicef.org","gender":"Male","salary":1314},
{"id":11,"first_name":"Gale","last_name":"Linkleter","email":"glinkletera@icio.us","gender":"Female","salary":2145},
{"id":12,"first_name":"Darb","last_name":"Melior","email":"dmeliorb@taobao.com","gender":"Male","salary":2530},
{"id":13,"first_name":"Adlai","last_name":"Dahlberg","email":"adahlbergc@rediff.com","gender":"Genderfluid","salary":3976},
{"id":14,"first_name":"Olwen","last_name":"Vinden","email":"ovindend@nydailynews.com","gender":"Female","salary":2807},
{"id":15,"first_name":"Calli","last_name":"Legonidec","email":"clegonidece@opera.com","gender":"Female","salary":1687}]`;

let data = JSON.parse(jsonData);
/*console.log(data);*/

let xhtp = new XMLHttpRequest();
xhtp.open('get', 'resources/data/MOCK_DATA.json');
xhtp.send();
xhtp.onreadystatechange = function (){
	if(xhtp.readyState == 4 && xhtp.status==200){
		console.log(xhtp.responseText);
		let data = JSON.parse(xhtp.responseText);
		console.log(data);
	}
}