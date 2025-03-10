<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>


	<center>
		<h2>회원가입</h2>
		<form:form action="join_pro" modelAttribute="user" method="post" >
			ID: <form:input path="user_id"/> <br>
			<form:errors path="user_id"/> <br>
			password: <form:input path="user_pass"/><br>
			<form:errors path="user_pass"/> <br>
			이름: <form:input path="user_name"/><br>
			<form:errors path="user_name"/> <br>
			나이: <form:input path="user_age"/><br>
			<form:errors path="user_age"/> <br>
			성별: <form:input path="user_gender"/><br>
			<form:errors path="user_gender"/> <br>
			직업: <form:input path="user_job"/><br>
			
			주소: <form:input path="user_address"/><br>
			<form:errors path="user_address"/> <br>
			<button type="submit">가입</button>
		</form:form>
	</center>
</body>
</html>