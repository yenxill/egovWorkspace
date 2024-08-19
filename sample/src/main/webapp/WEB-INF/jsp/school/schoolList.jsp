<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table>
		<tr>
			<th>학교명</th>
			<th>지역구</th>
			<th>주소</th>
			<th>연락처</th>
		</tr>
		<c:forEach var="school" items="${schoolList }">
			<tr>
				<td><a href="/school/getSchoolInfo.do?schoolIdx=${school.schoolId}">${school.schoolName }</a></td>
				<td>${school.schoolArea }</td>
				<td>${school.schoolAddr }</td>
				<td>${school.schoolPhone }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>