
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/greating/resources/css/user/mypage-pagination.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	<link href="${pageContext.request.contextPath}/resources/css/user/mypage-mydiy.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
            crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/resources/js/user/mypage-mydiy.js"></script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	<div class="hr"></div>

	<main class="contents hd__inner1100">
		<ul class="page-category">
			<li>Home</li>
			<li>></li>
			<li class="highlight">마이페이지, ${dto.page }</li>
		</ul>

		<div class="mypage-main d-flex">
			<jsp:include page="./mypage-sidebar.jsp" />
			<div class="sub-cont">
				<jsp:include page="./mypage-welcome.jsp" />

				<div class="myDiy-cont">
					<div class="select-box">
						<i class="far fa-check-circle fa-lg" style="color: #afb0b1;">
						</i> 전체선택
					</div>
				</div>

				<ul>
					<c:forEach items="${list}" var="item">
						<li class="myDiy-card" data-id="${item.id}">
							<div class="myDiy-card-img">
								<img src="${item.imgUrl}" alt="">
							</div>
							<div class="myDiy-card-info">
								<span class="mb-2">${item.title}</span>
								<div class="hr"></div>
								<div class="myDiy-card-tags">
									<span style="font-size: 17px;"> 메인 구성 </span>
									<span class="myDiy-card-tag">${item.riceFoodName}</span>
									<span class="myDiy-card-tag">${item.soupFoodName}</span>
									<span class="myDiy-card-tag">${item.mainFoodName}</span>
								</div>
								<div class="myDiy-vote">
									<span style="font-size: 17px;"> 투표 현황 </span>
									<div class="myDiy-vote-num">
										<img src="${pageContext.request.contextPath}/resources/images/user/vote.png" alt="">
										<span>${item.voteCnt} Greating</span>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>


				<c:if test="${dto.totalCount == 0 }">
					<div class="noContentDiv">
					<img class="mark_exclamation" src="/greating/resources/images/user/exclamationMark.png">
					<p class="noContents">아직 작성한 식단이 없습니다.</p>
					</div>
				</c:if>


				<!-- 페이징 버튼 -->
				<div class="pagination">


					<c:if test="${dto.page > 1}">
						<c:if test="${dto.totalPage > 5}">
							<a href="/greating/mypage/diets?page=1">처음</a>
						</c:if>
						<a href="/greating/mypage/diets?page=${dto.page - 1}">이전</a>
					</c:if>

					<!-- 현재 선택한 페이지가 가운데 있게하는 로직 -->
					<c:set var="startPage" value="${dto.page - 2}" />
					<c:set var="endPage" value="${dto.page + 2}" />
					<!-- 다만 첫번째 페이지부터 3페이지까지는 1 2 3 4 5 가 띄워져야함 -->
					<c:if test="${startPage < 1}">
						<c:set var="startPage" value="1" />
						<c:set var="endPage" value="5" />
					</c:if>
					<c:if test="${endPage > dto.totalPage}">
						<c:set var="startPage" value="${dto.totalPage - 4}" />
						<c:set var="endPage" value="${dto.totalPage}" />
					</c:if> 

			
					<c:choose>
						<c:when test="${startPage < 1}">
							<c:set var="startPage" value="1" />
						</c:when>
						<c:when test="${endPage > dto.totalPage}">
							<c:set var="startPage" value="${dto.totalPage - 4}" />
						</c:when>
					</c:choose>

					<c:if test="${startPage < 1}">
						<c:set var="startPage" value="1" />
					</c:if>
					<c:if test="${endPage > dto.totalPage}">
						<c:set var="endPage" value="${dto.totalPage}" />
					</c:if>



					<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
						<c:choose>
							<c:when test="${pageNum eq dto.page}">
								<strong>${pageNum}</strong>
							</c:when>
							<c:otherwise>
								<a href="/greating/mypage/diets?page=${pageNum}">${pageNum}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${dto.page < dto.totalPage}">
						<a href="/greating/mypage/diets?page=${dto.page + 1}">다음</a>
						<c:if test="${dto.totalPage > 5}">
					        <a href="/greating/mypage/diets?page=${dto.totalPage}">끝</a>
					    </c:if>
					</c:if>
				</div>


			</div>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />


</body>
</html>
