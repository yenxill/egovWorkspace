<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>학교명</th>
			<td>${schoolInfo.schoolName }</td>
		</tr>
		
		<tr>
			<th>지역구</th>
			<td>${schoolInfo.schoolArea }</td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td>${schoolInfo.schoolAddr }</td>
		</tr>
		
		<tr>
			<th>연락처</th>
			<td>${schoolInfo.schoolPhone }</td>
		</tr>
	</table>
	<a href="/school/getSchoolList.do">목록으로</a>
</body>
</html>