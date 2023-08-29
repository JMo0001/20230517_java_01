<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>


	<div>
		<div>
			<h2>로그인</h2>
			<form action="<%=request.getContextPath()%>/login.login"
				method="post">
				id : <input type="text" name="username" required="required"> 
				pw : <input type="password" name="password" required="required">
				<button type="submit">로그인</button>
				<button type="button">회원가입 TODO</button>
				<!-- Spring Security 적용시 poist 방식에서 (form, ajax 적용해야함)
				csrf 공격을 막기 위해서 hidden 태그로 보내줌. token 값 전달해야 403 오류 발생 안함. -->
				<input type="hidden" name="${_csrf.parameterName} " value="${_csrf.token} }">
			</form>
		</div>
	</div>
</body>
</html>