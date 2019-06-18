<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">




<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>사용자 리스트</title>
<!-- css,js -->
<%@include file="/common/basicLib.jsp"%>
<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<style type="text/css">
.userTr:hover {
	cursor: grab;
}

.userTr:press {
	cursor: grabbing;
}
</style>
<script
	src="${pageContext.request.contextPath }/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	$(document).ready(function() {
		$("#attachmentsAdd").on("click", function(){
			if($(".file").length != 5){
				$("#fileAdd").append("<input type='file' name='file' class='file'>")
			}else{
				alert("첨부파일 5까지 가능합니다.")
			}
				
			
		});
		
		
		
						// Editor Setting
						nhn.husky.EZCreator
								.createInIFrame({
									oAppRef : oEditors, // 전역변수 명과 동일해야 함.
									elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
									sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
									fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
									htParams : {
										// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
										bUseToolbar : true,
										// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
										bUseVerticalResizer : true,
										// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
										bUseModeChanger : true,
									}
								});

						// 전송버튼 클릭이벤트
						$("#savebutton").click(
								function() {
									if (confirm("저장하시겠습니까?")) {
										// id가 smarteditor인 textarea에 에디터에서 대입
										oEditors.getById["smarteditor"].exec(
												"UPDATE_CONTENTS_FIELD", []);

										// 이부분에 에디터 validation 검증
										if (validation()) {
											$("#frm").submit();
										}
									}
								});
						
						
						
						 $("#detail_title").keydown(function(){
							    var numChar = $(this).val().length;
							    var maxNum = 140;
							    var charRemain = maxNum - numChar;
							    if(charRemain == 0){
							     	alert("제목을 입력하세요");
							     	$("#detail_title").focus();
							    } 
							  });
						
					});
	
	

	// 필수값 Check
	function validation() {
		var contents = $.trim(oEditors[0].getContents());
		if (contents === '<p>&nbsp;</p>' || contents === '') { // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}

		return true;
	}
</script>





</head>

<body>

	<%@include file="/common/header.jsp"%>
	<div class="row">
		<!-- left -->
		<%@include file="/common/left.jsp"%>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-8 blog-main">

					<h2 class="sub-header">게시글 등록</h2>
					<form action="${pageContext.request.contextPath }/boardForm"
							method="post" id="frm" enctype="multipart/form-data">
					<div class="table-responsive">
						<label class="col-sm- control-label">제목 :</label>
						<input type="text" name="detail_title" id="detail_title"><br>
						<label class="control-label">작성자 : </label>
						<label class="control-label">${userid }</label>
						
						<input type="hidden" name="userid" value="${userid }">
						<input type="hidden" name="board_id" value="${board_id }">
						
						
						
							<textarea name="detail_text" id="smarteditor" rows="10" class="inputSize"
								cols="100" style="width: 766px; height: 412px;"></textarea>

						
						
						<div id="fileAdd">
						
						</div>
						
						<input type="button" id="attachmentsAdd" name="attachmentsAdd" value="첨부파일추가버튼">



						
						
					</div>
					<input type="button" id="savebutton" value="게시글등록" />

				 </form>
					<div class="text-center"></div>
				</div>
			</div>

			<div class="row"></div>
			<!-- /.blog-main -->
		</div>
	</div>




</body>
</html>