<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<title>게시물 등록</title>
<style>
	table{
		margin:auto;
		width:100%;
		height:auto;
	}
	tr {
		height:30px;
	}
	.text {
	 width:100%;
	}
</style>

<script type="text/javascript">
	$(document).ready(function(){
		var flag = "${flag}"
		if(flag === "U") {
			fn_detail("${boardIdx}");
		}
		
		$("#btn_save").on('click', function(){
			fn_save();
		});
		
		$("#btn_list").on('click', function(){
			location.href = "/board/boardList.do";
		});
	});
	
	function fn_detail(boardIdx) {
		$.ajax({
		    url: '/board/getBoardDetail.do',
		    method: 'post',
		    data : {"boardIdx" : boardIdx}, //{'파라미터 명칠' : 실제데이터}
		    dataType : 'json',
		    success: function (data, status, xhr) {
//		    	console.log(data.boardInfo);

			$("#boardTitle").val(data.boardInfo.boardTitle);
			$("#boardContent").val(data.boardInfo.boardContent);

		    },
		    error: function (data, status, err) {
		    	console.log(err);
		    }
		});
	}
	
	function fn_save(){
		var frm = $("#saveFrm").serialize();
//		console.log(frm);
		$.ajax({
		    url: '/board/saveBoard.do',
		    method: 'post',
		    data : frm,
		    dataType : 'json',
		    success: function (data, status, xhr) {
		    	if(data.resultChk > 0){
		    		alert("저장되었습니다.");
		    		location.href="/board/boardList.do";
		    	}else{
		    		alert("저장에 실패하였습니다.");
		    	}
		    },
		    error: function (data, status, err) {
		    	console.log(err);
		    }
		});
	}
</script>
</head>
<body>
	<div>
		<form id="saveFrm" name="saveFrm">
			<input type="hidden" id="statusFlag" name="statusFlag" value="${flag}"/>
			<input type="hidden" id="boardIdx" name="boardIdx" value="${boardIdx}"/>
			<table>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" class="text" id="boardTitle" name="boardTitle"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="20" cols="60" id="boardContent" name="boardContent" class="text"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div style="float:right;">
		<input type="button" id="btn_save" name="btn_save" value="저장"/>
		<input type="button" id="btn_list" name="btn_list" value="목록"/>
	</div>
</body>
</html>