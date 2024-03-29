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

<title>사용자 수정</title>
<!-- css,js -->
<%@include file="/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
 $(document).ready(function(){
	 var msg = '${msg}';
	 if(msg != '')
		 alert(msg);
	 
	 
	 //주소찾기 버튼 클릭 이벤트 핸들러
	$("#addrSearchBtn").on("click", function(){
		
	    new daum.Postcode({
	        oncomplete: function(data) {
				//주소 input value에 설정 data.roadAddress
				//우편번호 input value에 설정 data.zonecode
	            
				console.log(data);
	            console.log(data.roadAddress);
	            console.log(data.zonecode);
	            
	            $("#zipcd").val(data.zonecode);
	            $("#addr1").val(data.roadAddress);
	            
	            
	        }
	    }).open();
	    
	});
	 
	 //사용자 등록버튼 클릭 이벤트 핸들러
	 $("#userRegBtn").on("click", function(){
		console.log("userRegBtn click"); 
		
		//유효성 체크를 해야된다 클라이언트에서도 하고 서버에서도 해야한다. 일단 넘어간다. 나중에
		
		//여기까지 도달하면 유효성 검사완료 (submit한다.)
		$("#frm").submit();
		
	 });
	 
	 
	 
	 
	 
	
	//개발용 데이타 초기화 함수 ************* 추후 지워야함
// 	dataInit();
  
});
 
//  function dataInit(){
// 	 $("#userId").val("userTest");
// 	 $("#name").val("대덕인");
// 	 $("#alias").val("대덕");
// 	 $("#addr1").val("대전광역시 중구 중앙로76");
// 	 $("#addr2").val("영민빌딩 2층 204호");
// 	 $("#zipcd").val("12345");
// 	 $("#birth").val("2019-05-03");
// 	 $("#pass").val("userTest1234");
//  }
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
						<h2 class="sub-header">사용자 수정</h2>

						<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/modify" method="post" 
							enctype="multipart/form-data">
							<input type="hidden" name="userId" value="${userVo.userId }" >
						
							<div class="form-group">
								<label for="filename" class="col-sm-2 control-label">사용자이미지</label>
								<div class="col-sm-10">
<%-- 									<img alt="" src="${pageContext.request.contextPath }/profile?userId=${userVo.userId}"> --%>
										<input type="file" name="profile" id="filename"  >
								</div>
							</div>
						
							
							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label">사용자아이디</label>
								<div class="col-sm-10">
									 <label class="form-control" id="userId">${userVo.userId }</label>
								</div>
							</div>
							

							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">사용자
									이름</label>
								<div class="col-sm-10">
								 <input type="text" class="form-control" id="name"
										name="name" placeholder="사용자 이름" value="${userVo.name }">
								</div>
							</div>
							
							<div class="form-group">
								<label for="alias" class="col-sm-2 control-label">별명</label>
								<div class="col-sm-10">
									 <input type="text" class="form-control" id="alias"
										name="alias" placeholder="사용자 별명" value="${userVo.alias }">
								</div>
							</div>
							
							<div class="form-group">
								<label for="addr1" class="col-sm-2 control-label">주소</label>
								<div class="col-sm-8">
									 <input type="text" class="form-control" id="addr1"
										name="addr1" placeholder="주소"  value="${userVo.addr1 }" readonly>
								</div>
								<div class="col-sm-2">
									<button id="addrSearchBtn" class="btn btn-default" type="button">주소검색</button>
								</div>
							</div>
							
							<div class="form-group">
								<label for="addr2" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-10">
									 <input type="text" class="form-control" id="addr2"
										name="addr2" placeholder="상세주소" value="${userVo.addr2 }" >
								</div>
							</div>
							
							<div class="form-group">
								<label for="zipcd" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									 <input type="text" class="form-control" id="zipcd"
										name="zipcd" placeholder="우편번호" value="${userVo.zipcd }" readonly>
								</div>
							</div>
							
							<div class="form-group">
								<label for="birth" class="col-sm-2 control-label">생일</label>
								<div class="col-sm-10">
									 <input type="date" class="form-control" id="birth"
										name="birth" placeholder="생일" value=
										<fmt:formatDate value="${userVo.birth}" pattern="yyyy-MM-dd"/>>
																	
								</div>
							</div>
							
							<div class="form-group">
								<label for="pass" class="col-sm-2 control-label">비밀번호</label>
								<div class="col-sm-10">
									 <input type="password" class="form-control" id="pass"
										name="pass" placeholder="비밀번호" value="${userVo.pass }">
																	
								</div>
							</div>
							
							
							
							
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="userRegBtn" type="button" class="btn btn-default">수정확인</button>
								</div>
							</div>
							
							
							
						</form>

					</div>
				</div>

				<div class="row"></div>
				<!-- /.blog-main -->
			</div>
		</div>
	</div>
</body>
</html>
