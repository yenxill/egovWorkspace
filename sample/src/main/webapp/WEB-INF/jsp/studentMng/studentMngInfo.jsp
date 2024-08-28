<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

</script>


</head>
<body>
	<form id="frm" name="frm">
		<input type="hidden" id="schoolId" name="schoolId" value="${studentInfo.studentId }"/>
	</form>
	<table style="border: 1px solid #444444;">
		<tr>
			<th style="border: 1px solid #444444;">학생이름</th>
			<td style="border: 1px solid #444444;">${studentInfo.studentName }</td>
			
		</tr>
		<tr>
			<th style="border: 1px solid #444444;">학교명</th>
			<td style="border: 1px solid #444444;">${studentInfo.schoolName }</td>
		</tr>
		<tr>
			<th style="border: 1px solid #444444;">졸업 여부</th>
			<td style="border: 1px solid #444444;">${studentInfo.graduateYn }</td>
		</tr>
		
	</table>

	<a href="/studentMng/getStudentMngList.do">목록으로</a>

</body>
</html>