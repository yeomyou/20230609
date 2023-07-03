<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p{
	color: red;
	}
</style>
<script src='jquery-3.7.0.min.js'></script>
</head>
<body>
	<p>Hello,world1</p>
	<p>Hello,world2</p>
<script>
	$('p:nth-child(1)').after($('<p/>').text('Hello, World3'))
	$('p').css('background', 'yellow');
</script>
</body>
</html>