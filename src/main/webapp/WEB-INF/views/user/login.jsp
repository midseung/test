<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>


	<header>
		<h2>로그인</h2>
	</header>	
	<section>
		<form:form modelAttribute="user" action="login_pro" method="post">
			<form:label path="user_id">ID</form:label>
			<form:input path="user_id"/>
			
			<form:label path="user_pass">ID</form:label>
			<form:password path="user_pass"/>
			
			<button type="submit">로그인</button>
			
		</form:form>
	</section>


</body>
</html>