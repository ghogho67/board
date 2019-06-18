<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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

<style type="text/css">

.replyTr:hover {
	cursor: grab;
}

.replyTr:press {
	cursor: grabbing;
}
#hiddenTd{
	display: none;
	visibility: hidden;
}

</style>


<script type="text/javascript">
$(document).ready(function(){
	$(".replyTr").on("click", function() {
		console.log("detailTr");
		var message = confirm("정말로 삭제하시겟습니까?");
		if(message == true){
			var reply_id = $(this).find(".reply_id").text();
			$("#reply_id").val(reply_id);

			//#frm 을 이용하여 submit();
			$("#frm").submit();
			
		}else{
		 false	
		}
		
	});
	
		
	$("#replyInsertBtn").on("click", function(){
		var numChar = $("#reply_text").val().length;
		if( numChar == 0){
    	alert("댓글입력을 해주세요.");
		}else if (numChar > 500){
			alert("댓글입력은 500자 이하만 가능합니다.");
			 $("#reply_text").focus();
		}else{
			$("#replyInsert").submit();
		}
	 });


	
	
		

	$("#boardModifyBtn").on("click", function(){
		$("#detailModify").submit();
	});	
	
	$("#detailDeleteBtn").on("click", function(){
		$("#detailDelete").submit();
	});		
	
	$("#replyDetailBtn").on("click", function(){
		$("#insetReplyDetail").submit();
	});		

});	
	



</script>

</head>

<body>


	<!-- header -->
	<%@include file="/common/header.jsp"%>


	<div class="container-fluid">
		<div class="row">
			<!-- left -->
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시글상세내역</h2>
						
						
						
						
						<form class="form-horizontal" role="form" id="frm" action="${pageContext.request.contextPath}/replyDelete" method="get">
						
							<input type="hidden" id="userId" name="board_id"  value="${detailVo.board_id }">
							<input type="hidden" id="userId" name="detail_id"  value="${detailVo.detail_id }">
							<input type="hidden" id="reply_id" name="reply_id">
						
						<%-- <div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자이미지</label>
								<div class="col-sm-10">
									<img src="${pageContext.request.contextPath }/profile?userId=${param.userId}">
								</div>
							</div> --%>
						
				

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자
									아이디</label>
								<div class="col-sm-10">
									<label class="control-label">${detailVo.userid }</label>
									<%-- <input type="text" class="form-control" id="userId"
										name="userId" placeholder="사용자 아이디">--%>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">작성일자</label>
								<div class="col-sm-10">
									<label class="control-label">${detailVo.detail_dt }</label>
								</div>
							</div>

						
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<label class="control-label">${detailVo.detail_title }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">내용</label>
								<div class="col-sm-10">
									<label class="control-label">${detailVo.detail_text }</label>
								</div>
							</div>
							
							
							
							<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
								<div class="col-sm-6" >
								<c:forEach items="${amentList }" var="ament" step="1">
									<a href="${pageContext.request.contextPath }/download?ament_id=${ament.ament_id }">
																					${ament.ament_nm }</a><br>
								</c:forEach>
								</div>
							</div>
							
							
							
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button id="boardModifyBtn" type="button" class="btn btn-default">게시글 수정</button>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button id="detailDeleteBtn" type="button" class="btn btn-default">게시글 삭제</button>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button id="replyDetailBtn" type="button" class="btn btn-default">답글 등록</button>
									</div>
								</div>
							</form>
						<form action="${pageContext.request.contextPath}/replyDetailBoard" id="insetReplyDetail" method="get">
							<input type="hidden" id="userId" name="board_id"  value="${board_id }">
							<input type="hidden" id="userId" name="detail_id"  value="${detail_id }">
							<input type="hidden" id="userId" name="amentList"  value="${amentList }">
						</form>	
						
						<form id="replyInsert" action="${pageContext.request.contextPath}/replyInsert" method="post">
							<label class="col-sm-2 control-label">댓글 : </label>
							<input type="text" name="reply_text" id="reply_text" class="col-sm-8 control-label">
							<button type="button" class="btn btn-default" id="replyInsertBtn" >댓글등록</button>
							<input type="hidden" name="detail_id" value="${detail_id }">
							<input type="hidden" name="board_id" value="${board_id }">
						</form>	
						
						<form action="${pageContext.request.contextPath}/boardDetailModify" id="detailModify" method="get">
							<input type="hidden" id="userId" name="board_id"  value="${board_id }">
							<input type="hidden" id="userId" name="detail_id"  value="${detail_id }">
						</form>
						
						<form action="${pageContext.request.contextPath}/boardDetailDelete" id="detailDelete" method="get">
							<input type="hidden" id="userId" name="board_id"  value="${board_id }">
							<input type="hidden" id="userId" name="detail_id"  value="${detail_id }">
						</form>
						  
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<th>댓글 번호</th>
								<th>댓글 내용</th>
								<th>작성자아이디</th>
								<th>작성일시</th>
							</tr>

							<c:forEach items="${replyVoList }" var="reply" varStatus="status">
								<c:choose>
								<c:when test="${reply.reply_use eq 'N' }">
									<tr>
										<td >${reply.rn }</td>
										<td colspan="3">삭제된 게시물입니다.</td>
									</tr>
								</c:when>
								
								<c:otherwise>
									<tr class="replyTr" data-detailid="${reply.reply_id  }">
										<!-- ${status.index}/${status.count}/ 카운터 주기-->
										<td>${reply.rn }</td>
										<td>${reply.reply_text }</td>
										<td>${reply.userid }</td>
										<td>${reply.reply_dt}</td>
										<td id="hiddenTd" class="reply_id">${reply.reply_id }</td>
									</tr>
								</c:otherwise>
							</c:choose>	
							</c:forEach>
								
	
						</table>
					</div>
									
					</div>
				</div>

				<div class="row"></div>
				<!-- /.blog-main -->
			</div>
		</div>
	</div>
</body>
</html>
