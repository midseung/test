<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
   <c:choose>
      <c:when test="${not empty sessionScope.user}">
         <a href="user/update">회원수정</a>
         <a href="user/mypage?id=${user.user_id }">회원정보</a>
         <a href="user/delete">회원탈퇴</a>
         <a href="user/logout">로그아웃</a>
         <h2>회원 목록</h2>
      </c:when>
      <c:otherwise>
         <a href="user/join">회원가입</a>
         <a href="user/login">로그인</a>
      </c:otherwise>
   </c:choose>
   <h2>회원 목록</h2>
   <ul>
      <c:forEach var="member" items="${memberList}">
         <li> <a href="user/mypage?id=${member.user_id }"> 아이디: ${member.user_id}, 이름: ${member.user_name}, 직업:
            ${member.user_job}</a></li>
      </c:forEach>
   </ul>
</body>
</html>