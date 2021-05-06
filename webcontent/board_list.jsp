<%@page import="co.kr.model.boardvo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 페이지 안에서 JSTL태그를 사용하려면 디렉티브를 통해 taglib선언을 해야 합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/test/write.do">글쓰기</a>
<br>
<table>
							<tr>
							<th>#번호</th>
							<th>작성자</th>
							<th>제목</th>
							<th>작성일</th>
							<th>조회수</th>
							</tr>
							<c:forEach var="arr" items="${arrays}">
							<tr>
							<td>${arr.getBid()}</td>
							<td>${arr.getBname()}</td>
							<td>${arr.getBtitle()}</td>
							<td>${arr.getBdate()}</td>
							<td>${arr.getBhit()}</td>
							</tr>
							</c:forEach>
</table>
</body>
</html>