<%@page import="co.kr.comment.commentvo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 페이지 안에서 JSTL태그를 사용하려면 디렉티브를 통해 taglib선언을 해야 합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 형식 맞출때 쓰느 -->
<%@ include file="home.jspf" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>
글순서:${content.getBid()}<br>
작성자 :${content.getBname()}<br>
글제목 :${content.getBtitle() }<br>
글내용 :${content.getBcontent() }<br>
작성일자 :${content.getBdate() } 조회수:${content.getBhit() }
<br>

<c:if test="${uid==content.getBname()}">

<a href="/test/updatecontent.do?bid=${content.getBid()}&btitle=${content.getBtitle()}&bcontent=${content.getBcontent()}">수정</a>
<a href="/test/deletecontent.do?bid=${content.getBid()}">삭제</a>

<br>

</c:if>

댓글
<br>

<c:choose>
	<c:when test="${uid!=null }">
	<form action="/test/comment.do" method="post">
	작성자:${uid}<br>
	<input type="text" name="comment" placeholder="댓글쓰기">
	<input type="hidden" name="bid" value="${content.getBid()}">
	<input type="hidden" name="uid" value="${uid}">
	<input type="hidden" name="id" value="${content.getBid()}">
	<input type="submit" value="작성완료">
	</form>
	</c:when>
		<c:otherwise>
		댓글을 입력하려면 로그인 해 주세요
		</c:otherwise>
</c:choose>
<br>

	<c:forEach var="arr" items="${array.getCommentList()}">			
		작성자:${arr.getUid()}<br>
		내용:${arr.getComment()}<br>
	</c:forEach>
<br>

	<c:forEach var="arr2" begin="1" end="${array.getPageTotalCount()}">
					<a href="content.do?id=${content.getBid()}&page=${arr2}">${arr2}</a> 
		</c:forEach> 
					&nbsp;<a href="#">>></a>
	<br>
	
<a href="/test/ge.do">목록으로돌아가기</a>
</body>
</html>