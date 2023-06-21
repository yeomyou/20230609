<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>
</head>
<body>
<form action="../boardAdd">
	Title : <input type="text" name ="title"><br>
	Writer : <input type="text" name ="writer"><br>
	Content : <textarea rows="3" cols="10" name="content"></textarea><br>
	<button type="submit">저장</button>
</form>

</body>
</html>