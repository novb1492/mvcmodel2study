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

<br>

글순서:${bid}<br>
작성자 :${uid}<br><!-- session -->
<form action="/test/updatecontentprocess.do" method="post">
글제목 : <input type="text" name="btitle" value="${btitle}"><br>
글내용 : 
<br>
<textarea rows="10" cols="100" name="bcontent">${bcontent}</textarea>
<br>
<input type="hidden" name="bid" value="${bid}">
<input type="hidden" name="uid" value="${uid}">
<input type="submit" value="수정완료">
</form>
</body>
</html>