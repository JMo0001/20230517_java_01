<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/board/insert" method="post" enctype="multipart/form-data">
	제목:<input type="text" name="btitle"><br>
	내용:<input type="text" name="bcontent"><br>
	<input type="submit" value="등록">
	<!-- type="file"의 name은 VO/DTO의 field명과 다르게 지어야 함 -->
	<input type="file" name="uploadFile1"><br>
	<input type="file" name="uploadFile2"><br>
	<input type="file" name="uploadFile"><br>
	<input type="file" name="uploadFile"><br>
	<input type="checkbox" name="hobby" value="a"><br>
	<input type="checkbox" name="hobby" value="b"><br>
	<input type="checkbox" name="hobby" value="c"><br>
	<input type="submit" value="등록">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
</form>
</body>
</html>