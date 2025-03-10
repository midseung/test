<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>

		<center>
			<c:if test="${not empty error}">
				<div style="color: red;">${error}</div>
			</c:if>

			<form:form action="update_pro" modelAttribute="user" method="post">
				<!-- 기존 폼 내용 -->
			</form:form>
		</center>

		<form:form action="update_pro" modelAttribute="user" method="post">
			<label>ID:</label>
			<form:input path="user_id" readonly="true" name="user_id" />
			<br>
			
			<label>Name:</label>
			<form:input path="user_name" name="user_name" />
			<br>

			<label>Age:</label>
			<form:input path="user_age" name="user_age" />
			<br>

			<label>Gender:</label>
			<form:input path="user_gender" name="user_gender" />
			<br>

			<label>Job:</label>
			<form:input path="user_job" name="user_job" />
			<br>

			<label>Address:</label>
			<form:input path="user_address" name="user_address" />
			<br>

			<label>비밀번호:</label>
			<input type="password" name="user_pass" name="user_pass" />
			<br>

			<button type="submit">수정</button>
		</form:form>

	</center>
	


</body>
</html>