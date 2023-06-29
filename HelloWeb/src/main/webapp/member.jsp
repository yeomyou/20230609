<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h3>회원정보</h3>
    <form action="queryTest" method="post">
        ID : <input type="text" name="id" id="id" value="user1"><br>
        PW : <input type="password" name="pwd" id="pwd" value="1111"><br>
        이름 : <input type="text" name="name" id="name" value="홍길동"><br>
        취미 : 
        <input type="checkbox" name="hobby" id="hobby" value="climbing">등산
        <input type="checkbox" name="hobby" id="hobby" value="sport">운동
        <input type="checkbox" name="hobby" id="hobby" value="reading">독서
        <input type="checkbox" name="hobby" id="hobby" value="traveling">여행<br>
        성별 : 
        <input type="radio" name="gender" id="male" value="male">남자
        <input type="radio" name="gender" id="female" value="femail">여자<br>
        종교 :
        <select name="religion" id="religion">
            <option value="Christinity">기독교</option>
            <option value="Buddhism">불교</option>
            <option value="Catholicism">천주교</option>
            <option value="Atheism">무교</option>
        </select>
        자기소개<br>
        <textarea name="intro" id="" cols="30" rows="10"></textarea>
        <input type="submit" value="전송">
        <input type="reset" value="취소">

    </form>

</body>

</html>