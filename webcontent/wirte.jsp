<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%-- 페이지 안에서 JSTL태그를 사용하려면 디렉티브를 통해 taglib선언을 해야 합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 형식 맞출때 쓰느 -->
<%@ include file="home.jspf" %>

<c:if test="${uid==null }">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/test/writeprocess.do" method="post">
작성자:${uid }
<br>
제목:<input type="text" name="btitle">
<br>
내용:<br>
<textarea rows="5" cols="10" name="bcontent"></textarea>
<input type="hidden" name="bname" value="${uid }">
<input type="submit">
</form>
<a href="/test/ge.do">취소</a>
</body>
</html>