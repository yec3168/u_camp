<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>CustomerList</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
				   <th>번호</th>
			       <th>이메일</th>
			       <th>이름</th>
			       <th>나이</th>
			       <th>가입날짜</th>
				</tr> 
			</thead> 
			<tbody> 
				<c:forEach var="customer" items="${customerList}">
					<tr>
						<td>
						 	<a href="getCustomerDetail.do?email=${customer.email}">${customer.id}</a>
						 </td>
						<td>${customer.email}</td>
						<td>${customer.name}</td>
				        <td>${customer.age}</td>
				        <td>${customer.entry_date}</td>
					</tr>
			    </c:forEach>
			    
			</tbody> 
			<tr>
		    	<td colspan="5"><a href='/mymission'>돌아가기</a></td>
		    </tr>
		</table>
	</div>

</body>
</html>