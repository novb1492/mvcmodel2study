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
<form action="/test/singupprocess.do">
id:<input type="text" name="id" placeholder="id"><br>
pwd:<input type="password" name="pwd"><br>
name:<input type="text" name="name" placeholder="name"><br>
email:<input type="email" name="email" placeholder="email"><br>
<input type="submit" value="done">
</form>
</body>
</html>