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

<title>사용자 등록</title>
<!-- css,js -->
<%@include file="/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
 $(document).ready(function(){
	 
	 //사용자 등록버튼 클릭 이벤트 핸들러
// 	 $("#creategBtn").on("click", function(){
// 		console.log("userRegBtn click"); 
// 		console.log($("#frm").serialize());
// 		$("#frm").submit();
		
// 	 });
	 
	 $(".modifyBtn").on("click", function(){
			console.log("modifyBtn click"); 
			$(this).parent("div").parent("form").submit();
// 			$("#newfrm").submit();
		 });
	 
	
});
 

</script>

</head>

<body>


<%request.setCharacterEncoding("UTF-8");%>
	<!-- header -->
	<%@include file="/common/header.jsp"%>


	<div class="container-fluid">
		<div class="row">
			<!-- left -->
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판 등록</h2>
						

						<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/addBoard" method="post"> 
								<input type="hidden" name="userId" value="${USER_INFO }" >
								<div class="form-group">
									<label for="BOARD_ID" class="col-sm-2 control-label">게시판이름</label>
									<div class="col-sm-3">
										 <input type="text" class="form-control" name="board_nm" 
										 			placeholder="게시판 이름">
									</div>
									<select name="combobox" form ="frm">
										<option value="Y">사용</option>
										<option value="N">비사용</option>
									</select>
									<button id="creategBtn" type="submit" class="btn btn-default">생성</button>
<!-- 									<input type="submit" value="생성"  class="btn btn-default"> -->
								</div>
							</form>
							
<%-- 							<form id="freeboad" class="form-horizontal" role="form" action="${pageContext.request.contextPath }" method="post">  --%>
<!-- 								<div class="form-group"> -->
<!-- 									<label for="name" class="col-sm-2 control-label">자유게시판</label> -->
<!-- 									<div class="col-sm-3"> -->
<!-- 									 <input type="text" class="form-control" id="name" -->
<!-- 											name="name" placeholder="게시판이름" value=""> -->
<!-- 									</div> -->
<!-- 									<select id="selectbox" name="selectbox"> -->
<!-- 										<option value="Y">사용</option> -->
<!-- 										<option value="N">비사용</option> -->
<!-- 									</select> -->
<!-- 									<button id="freeBoardBtn" type="button" class="btn btn-default">수정</button> -->
<!-- 								</div> -->
<!-- 							</form> -->
							
							
<%-- 							<form id="qandA" class="form-horizontal" role="form" action="${pageContext.request.contextPath }" method="post">  --%>
<!-- 								<div class="form-group"> -->
<!-- 									<label for="alias" class="col-sm-2 control-label">Q&A게시판</label> -->
<!-- 									<div class="col-sm-3"> -->
<!-- 										 <input type="text" class="form-control" id="alias" -->
<!-- 											name="alias" placeholder="게시판이름" value=""> -->
<!-- 									</div> -->
<!-- 									<select id="selectbox" name="selectbox"> -->
<!-- 										<option value="Y">사용</option> -->
<!-- 										<option value="N">비사용</option> -->
<!-- 									</select> -->
<!-- 									<button id="qandABtn" type="button" class="btn btn-default">수정</button>						 -->
<!-- 								</div> -->
<!-- 							</form> -->
							
							
						<c:set var="boardList" value="${BOARD_INFO }"/>
						<c:forEach var="board" items="${boardList }" step="1">
								<form id="newfrm${board.board_id }" class="form-horizontal " role="form" action="${pageContext.request.contextPath }/modify" method="post"> 
								<div class="form-group">
									<label for="alias" class="col-sm-2 control-label" >${board.board_nm }</label>
									<div class="col-sm-3">
										 <input type="text"  name="board_nm" class="form-control" placeholder="게시판이름" >
										 <input type="hidden" name="board_id" value="${board.board_id }">
									</div>
									<select name="combobox" form="newfrm${board.board_id }">
										<option value="Y" ${board.board_use eq "Y" ? "selected" : "Y"}>사용</option>
										<option value="N" ${board.board_use eq "N" ? "selected" : "N"}>비사용</option>
										
									</select>
										<button class="modifyBtn btn btn-default" type="button">수정</button>
<!-- 								<input type="submit" value="수정"  class="btn btn-default">					 -->
								</div>
							</form>
						</c:forEach>	
													
							
							
						

					</div>
				</div>

				<div class="row"></div>
				<!-- /.blog-main -->
			</div>
		</div>
	</div>
</body>
</html>
