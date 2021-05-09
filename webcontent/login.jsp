<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="home.jspf" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/test/loginprocess.do" method="post">
아이디:<input type="text" name="id" placeholder="아이디를입력하십시오"><br>
비밀번호:<input type="password" name="pwd" placeholder="비밀번호를 임력하시오"><br>
<input type="submit" value="로그인">
</form>
</body>
</html>