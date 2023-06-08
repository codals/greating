<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="/greating/resources/css/admin/admin-popularList.css">
<!-- jQuery 라이브러리 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- admin-popular.js 파일 추가 -->
<script src="/greating/resources/js/admin/admin-popular2.js"></script>


<link rel="stylesheet"
	href="/greating/resources/css/admin/admin-popularList.css">	
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<link href="/greating/resources/css/templates/alert.css"
	rel="stylesheet">
	
	
	
</head>
<body>
	<!--사이드바-->

	<jsp:include page="/WEB-INF/views/admin/admin-sidebar.jsp" />


	<div class="content">
		<div class="content-div">
			<h2 class="content-title">투표종료 인기 DIY 도시락 목록</h2>
			<table>
				<thead>
					<tr>
						<th>도시락 명</th>
						<th>작성자</th>
						<th>대분류</th>
						<th>소분류</th>
						<th>투표수</th>
						<th>작성일</th>
						<th>승인여부</th>
						<th>승인관리</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${list}" var="post">
						<tr>
							<td><a href="/greating/mealdiy/${post.id}">${post.title}</a></td>
							<td>${post.username}</td>
							<td>${post.mainCategoryName}</td>
							<td>${post.subCategoryName}</td>
							<td>${post.voteCnt}</td>
							<td><c:out value="${fn:substring(post.createdAt, 2, 10)}" /></td>
							<c:if test="${post.status eq 2}">	
									<td><span>승인 완료</span></td>
									<td>
									<button class="cancel-approve-${post.id}" id="cancelApprovalBtn"
										onclick="cancelApproval(${post.id}, this)">승인 취소</button></td>
								</c:if> 
							<c:if test="${post.status eq 0}">
									<td><span>승인 대기중</span></td>
									<td><button class="approve-${post.id}" id="approveBtn"
										onclick="approve(${post.id}, this)">승인 하기</button></td>
								</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>