<%@page import="co.kr.model.boardvo"%>
<%@page import="java.util.ArrayList"%>
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
request<br>
	<c:forEach var="arr2" items="${arrays2}">
	${arr2.getUserid() }
	${arr2.getUsername() }
	${arr2.getUseremail() }
	${arr2.getUsercreated() }
	</c:forEach>
	<br>
session<br>
	${uid }
	${uname }
	${uemail }
	${ucreated }
	<br>
	<c:choose>
	<c:when test="${uid!=null }">
	<a href="/test/logout.do">로그아웃</a>
	</c:when>
	<c:otherwise>
	<a href="/test/login.do">로그인</a>
	</c:otherwise>
	</c:choose>
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
							<c:forEach var="arr" items="${array.getMessageList()}">
							<tr>
							<td>${arr.getBid()}</td>
							<td>${arr.getBname()}</td>
							<td><a href="/test/content.do?id=${arr.getBid()}">${arr.getBtitle()}</a></td>
							<td>${arr.getBdate()}</td>
							<td>${arr.getBhit()}</td>
							</tr>
							</c:forEach>
					</table>
					<br>
					<a href="#"><<</a> &nbsp; 
					<c:forEach var="pagenum" begin="1" end="${array.getPageTotalCount()}">
					<a href="ge.do?page=${pagenum}">${pagenum}</a> 
					</c:forEach> 
					&nbsp;<a href="#">>></a>
					
					<br>
<form action="/test/search.do">
검색 <input type="text" name="title" placeholder="제목을 입력해주세요"><input type="submit" value="검색">
</form>

</body>
</html>