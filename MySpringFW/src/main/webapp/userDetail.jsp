<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Detail</title>
</head>
<body>
	<h2>User 상세정보</h2>
	<ul>
	<!-- UserVO에 존재하는 get메소드들이 불리는 것. -->
		<li>ID =  ${user.id}</li>
		<li>UserID =  ${user.userId}</li>
		<li>Name =  ${user.name}</li>
		<li>Gender =  ${user.gender}</li>
		<li>City =  ${user.city}</li>
	</ul>
</body>
</html>