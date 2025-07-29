<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 삭제</h1>
	<h3>아래의 사원을 삭제하겠습니다. 삭제후 데이터는 복구될 수 없습니다.</h3>
	${message }
	<form action="./delete" method="post">
	<table border="1">
		<tr>
			<th>EMPLOYEE_ID</th>
			<td>${emp.employeeId }</td>
		</tr>
		<tr>
			<th>FIRST_NAME</th>
    		<td>${emp.firstName }</td>
    	</tr>
		<tr>
		    <th>LAST_NAME</th>
		    <td>${emp.lastName }</td>
		</tr>
		<tr>
		    <th>EMAIL</th>
		    <td><input type="text" name="email" value="" required></td>
		</tr>
		<tr>
			<th>&nbsp;</th>
			<td>
				<input type="hidden" name="empid" value="${emp.employeeId }">
				<button type="submit">사원삭제</button>
				<button type="reset">초기화</button>
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>