<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Detail</title>
</head>
<body>
	<h2>User ������</h2>
	<ul>
	<!-- UserVO�� �����ϴ� get�޼ҵ���� �Ҹ��� ��. -->
		<li>ID =  ${user.id}</li>
		<li>UserID =  ${user.userId}</li>
		<li>Name =  ${user.name}</li>
		<li>Gender =  ${user.gender}</li>
		<li>City =  ${user.city}</li>
	</ul>
</body>
</html>