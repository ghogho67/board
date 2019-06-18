<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- left -->
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a 
						href="#">Main <span class="sr-only">(current)</span></a></li>
					
					<li class="active"><a 
						href="${pageContext.request.contextPath}/addBoard">게시판등록</a></li>
<!-- 					<li class="active"><a  -->
<%-- 						href="${pageContext.request.contextPath}/freeBoard">자유게시판</a></li> --%>
<!-- 					<li class="active"><a  -->
<%-- 						href="${pageContext.request.contextPath}/qandABoard">Q&A게시판</a></li> --%>
					
					
					<c:set var="boardList" value="${BOARD_INFO }"/>
					
						
					<c:forEach items="${boardList }" var="board" step="1">
						
						
							<c:if test="${board.board_use == 'Y' }">
								<li class="active"><a 
									href="${pageContext.request.contextPath}/detailPaging?board_id=${board.board_id}&board_nm=${board.board_nm}">${board.board_nm }</a></li>
							</c:if>
							
							<c:if test="${board.board_use == 'N' }">
									<li class="active" style="display:none;"><a 
										href="${pageContext.request.contextPath}/detailPaging">${board.board_nm }</a></li>
							
							</c:if>
					</c:forEach>
							
						
						
						
					
			
				</ul>
			</div>
			