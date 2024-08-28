<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<title>Insert title here</title>
<script type="text/javascript">
<script type="text/javascript">
$(document).ready(function(){
	
});

function fn_insert(){
	var frm = $("#frm").serialize();
	$.ajax({
	    url: '/studentMng/insertStudentMng.do',
	    method: 'post',
	    data : frm,
	    dataType : 'json',
	    success: function (data, status, xhr) {
	        if(data.resultChk > 0){
	        	alert("저장되었습니다.");
	        	var frm = $("#frm");
	        	frm.attr("action", "/studentMng/getStudentMngList.do");
	        	frm.attr("method", "POST");
	        	frm.submit();
	        	
	        	//location.href = "/studentMng/getStudentMngList.do";
	        	
	        }
	    },
	    error: function (data, status, err) {
	    }
	});
}
</script>
</head>
<body>

<form id="frm" name="frm">
	<table>
		<tr>
			<th>학생 이름</th>
			<td>
				<input type="text" id="studentName"	name="studentName" value=""/>
			</td>
		</tr>
		<tr>
			<th>학교 명</th>
			<td>
				<select id="schoolId" name="schoolId">
					<option value="">--학교를 선택해주세요--</option>
					<c:forEach var="schoolInfo" items="${schoolList }">
						<option value="${schoolInfo.schoolId }">${schoolInfo.schoolName }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th>졸업여부</th>
			<td>
				<input type="text" id="graduateYn"	name="graduateYn" value=""/>
			</td>
		</tr>
	</table>
</form>
<a href="#">등록</a>
<a href="javascript:fn_insert();">등록</a>
</body>
</html>