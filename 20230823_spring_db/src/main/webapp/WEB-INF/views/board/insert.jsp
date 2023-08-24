<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/board/insert">
	제목:<input type="text" name="btitle"><br>
	내용:<input type="text" name="bcontent"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>