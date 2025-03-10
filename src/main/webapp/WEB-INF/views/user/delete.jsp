<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>

	<form action="deletePro" method="post">
		<label for="user_pass">비밀번호 확인</label>
		<input type="password" name="user_pass">
		<button type="submit">회원탈퇴</button>
	</form>

</body>
</html>