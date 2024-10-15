<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer 세부정보.</h2>
	
	<ul>
		<li>ID 	:	${customer.id}</li>
		<li>Email	:	${customer.email}</li>
		<li>Name	:	${customer.name}</li>
		<li>Age	:	${customer.age}</li>
		<li>EntryDate 	:	${customer.entry_date}</li>
	</ul>
</body>
</html>