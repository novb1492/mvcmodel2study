<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/test/writeprocess.do" method="post">
작성자<input type="text" name="bname">
<br>
제목<input type="text" name="btitle">
<br>
내용<br>
<textarea rows="5" cols="10" name="bcontent"></textarea>
<input type="submit">
</form>
<a href="/test/here.do">취소</a>
</body>
</html>