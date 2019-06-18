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

<style type="text/css">
.detailTr:hover {
	cursor: grab;
}

.detailTr:press {
	cursor: grabbing;
}

#hiddenTd{
	display: none;
	visibility: hidden;
}


</style>
<script type="text/javascript">
	$(document).ready(function() {
		$(".detailTr").on("click", function() {
			console.log("detailTr");
			//userId를 획득하는 방법
			//$(this).find(".userId").text()
			//$(this)클릭했을때.data("userId")

			//사용자 아이디를 #userId 값으로 설정해주고
			var detailId = $(this).find(".detailid").text();
			var detail_title = $(this).find(".detail_title").text();
			$("#detail_title").val(detail_title);
			$("#detail_id").val(detailId);

			//#frm 을 이용하여 submit();
			$("#frm").submit();

		});

		$("#formAddBtn").on("click", function() {
			$("#formAdd").submit();
		});

	});
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



					<h2 class="sub-header">${board_nm }</h2>


					<!-- 사용자 상세조회 : userId가 필요 이 form 태그는 화면상 안보일꺼임 -->
					<form id="frm"
							action="${pageContext.request.contextPath }/boradDetail"
							method="get">
							<input type="hidden" name="board_id" value="${board_id }">
							<input type="hidden" name="detail_id" id="detail_id">
						</form>



					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<th>게시글 번호</th>
								<th>제목</th>
								<th>작성자아이디</th>
								<th>등록일시</th>
							</tr>


							<c:forEach items="${detailList }" var="detail" varStatus="status">
								<c:choose>
								<c:when test="${detail.detail_use eq 'N' }">
									<tr>
										<td >${detail.rn }</td>
										<td colspan="3">삭제된 게시물입니다.</td>
									</tr>
								</c:when>
								
								<c:otherwise>
									<tr class="detailTr" data-detailid="${detail.detail_id }">
										<!-- ${status.index}/${status.count}/ 카운터 주기-->
										<td>${detail.rn }</td>
										
										


										<td class="detail_title"> 
											  <c:choose>
											  	 <c:when test="${detail.lv > 0}">
	                  						      <c:forEach begin="1" end="${detail.lv}">
	                           						 &nbsp;&nbsp;&nbsp; <!-- 답변글일경우 글 제목 앞에 공백을 준다. -->
	                        					  </c:forEach>
	                        						Re: ${detail.detail_title }
                    					 	 	 </c:when>
                    					 	 	 <c:when test="${detail.lv eq 0}">
                    					 	 	 	${detail.detail_title }
                    					 	 	 </c:when>
                    					 	  </c:choose>
                    					 </td>
										
										
										<td>${detail.userid }</td>
										<td>${detail.detail_dt}</td>
										<td id="hiddenTd" class="detailid">${detail.detail_id }</td>
									</tr>
								</c:otherwise>
							</c:choose>	
							</c:forEach>

						</table>
						
					</div>

					<form id="formAdd"
						action="${pageContext.request.contextPath }/boardForm"
						method="get">
						<input type="button" id="formAddBtn" value="게시글 등록"
							class="btn btn-default pull-right"> <input type="hidden"
							name="board_id" value="${board_id }">
					</form>

					<div class="text-center">
						<ul class="pagination">



							<c:choose>
								<c:when test="${pageVo.page == 1}">
									<li class="disabled"><span>««</span></li>
									<li class="disabled"><span>«</span></li>

								</c:when>
								<c:otherwise>
									<li><a
										href="${pageContext.request.contextPath}/detailPaging?page=1&board_id=${board_id}">««</a></li>
									<li><a
										href="${pageContext.request.contextPath}/detailPaging?page=${pageVo.page -1 }& pagesize=${pageVo.pageSize }
																			&board_id=${board_id}">«</a></li>

								</c:otherwise>
							</c:choose>



							<c:forEach begin="1" end="${paginationSize }" step="1" var="i">
								<c:choose>
									<c:when test="${pageVo.page == i}">
										<li class="active"><span>${pageVo.page }</span></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="${pageContext.request.contextPath}/detailPaging?page=${i }&pageSize=${pageVo.pageSize}&board_id=${board_id}">
												${i} </a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>


							<c:choose>
								<c:when test="${pageVo.page == paginationSize}">
									<li class="disabled"><span>»</span></li>
									<li class="disabled"><span>»»</span></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="${pageContext.request.contextPath}/detailPaging?page=${pageVo.page +1 }& pageSize=${pageVo.pageSize }
																				&board_id=${board_id}">»</a></li>
									<li><a
										href="${pageContext.request.contextPath}/detailPaging?page=${pageVo.pageSize }&board_id=${board_id}">»»</a></li>
								</c:otherwise>
							</c:choose>


						</ul>
					</div>
				</div>
			</div>

			<div class="row"></div>
			<!-- /.blog-main -->
		</div>
	</div>




</body>
</html>