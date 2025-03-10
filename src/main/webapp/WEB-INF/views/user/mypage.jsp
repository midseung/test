<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>

	<header>
		<h2>마이페이지</h2>
	</header>
	<section>
		<form:form modelAttribute="user" method="post">
			<form:label path="user_id">ID</form:label>
			<form:input path="user_id" readonly="true" />

			<form:label path="user_name">이름</form:label>
			<form:input path="user_name" readonly="true" />

			<form:label path="user_age">나이</form:label>
			<form:input path="user_age" readonly="true" />

			<form:label path="user_gender">성별</form:label>
			<form:input path="user_gender" readonly="true" />

			<form:label path="user_job">직업</form:label>
			<form:input path="user_job" readonly="true" />

			<form:label path="user_address">주소</form:label>
			<form:input path="user_address" readonly="true" />
		</form:form>
	</section>
	<footer> © 솔데스크 </footer>
	<form action="home">
		<button type="submit">홈</button>
	</form>

</body>
</html>