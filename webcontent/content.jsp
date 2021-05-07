<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 페이지 안에서 JSTL태그를 사용하려면 디렉티브를 통해 taglib선언을 해야 합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 형식 맞출때 쓰느 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글순서:${content.getBid()}<br>
작성자 :${content.getBname()}<br>
글제목 :${content.getBtitle() }<br>
글내용 :${content.getBcontent() }<br>
작성일자 :${content.getBdate() } 조회수:${content.getBhit() }<br>
<a href="/test/ge.do">목록으로돌아가기</a>
</body>
</html>