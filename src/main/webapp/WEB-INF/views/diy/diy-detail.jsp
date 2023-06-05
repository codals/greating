<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DIY 식단 상세보기</title>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- css로 가져오기 -->
<link href="/greating/resources/css/diy/diy-detail.css" rel="stylesheet">

<!-- js 가져오기 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

<script src="/greating/resources/js/diy/diy-detail.js"></script>
<script src="/greating/resources/js/diy/kakao-share.js"></script>

<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<!-- bootstrap -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>

<!-- alert 창 커스텀  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<link href="/greating/resources/css/templates/alert.css"
	rel="stylesheet">

</head>

<body>

	<!-- header 가져오기 -->
	<jsp:include page="../templates/header.jsp" />
	<div class="hr"></div>

	<!-- floating banner 가져오기 -->
	<jsp:include page="/WEB-INF/views/templates/floating-adv.jsp" />
	<jsp:include page="/WEB-INF/views/templates/floating-sharing-btn.jsp" />

	<!-- 본 페이지 내용 -->
	<div class="main-content hd__inner1100">
		<ul class="page-category">
			<li>DIY 식단</li>
			<li>></li>
			<li class="highlight">DIY 도시락 상세</li>
		</ul>
		<div class="main-info-container">

			<div class="main-img">
				<img src="${postDetail.post.imgUrl}" alt="Main Image">
			</div>

			<div class="main-info-text-container">

				<div class="main-introduction">
					<span class="diy-type">DIY 도시락</span>
				</div>

				<div class="main-title">
					<span class="title-text">${postDetail.post.title}</span> <span
						class="new-badge">New</span>
				</div>

				<div class="main-info-line">

					<span class="info-title">분류</span> <span class="info-text">
						<span>${postDetail.mainCategory.name} >
							${postDetail.subCategory.name} > ${postDetail.foodCountry}</span>

					</span>

				</div>

				<div class="main-info-line">
					<span class="info-title">영양사</span> <span class="info-text">${postDetail.post.username}</span>

				</div>

				<div class="main-info-line">
					<span class="info-title">메인 구성</span> <span class="info-text">
						<c:if test="${not empty postDetail.rice}">
							<span class="diy-dish-info">${postDetail.rice.name}</span>
						</c:if> <c:if test="${not empty postDetail.soup}">
							<span class="diy-dish-info">${postDetail.soup.name}</span>
						</c:if> <c:if test="${not empty postDetail.main}">
							<span class="diy-dish-info">${postDetail.main.name}</span>
						</c:if>
					</span>
				</div>

				<div class="main-info-line">
					<span class="info-title">희망 칼로리</span> <span class="info-text">
						${postDetail.post.minCalorie} ~ ${postDetail.post.maxCalorie}kcal</span>
				</div>

				<div class="main-info-line">
					<span class="info-title">투표 현황</span>
					<div class="diy-vote-info">
						<img src="/greating/resources/images/diy/img_greating_vote.png"
							style="width: 30px; heigh: 30px;"> <span class="vote-count">${postDetail.post.voteCnt}</span>
						votes
					</div>
				</div>

				<div class="button-group">
					<c:if test="${isVoted eq true}">
						<button class="vote-button"
							onclick="checkVoteCancel(${postDetail.post.id})">
							<i class="fas fa-thumbs-up"></i><span> 투표완료</span>
						</button>

					</c:if>
					<c:if test="${isVoted ne true}">
						<button class="vote-button"
							onclick="checkVote(${postDetail.post.id})">
							<i class="far fa-thumbs-up"></i><span> 투표하기</span>
						</button>
					</c:if>
					<c:if test="${isScrapped eq true}">
						<button class="scrap-button"
							onclick="checkScrapCancel(${postDetail.post.id})">
							<i class="fas fa-bookmark"></i> <span>스크랩</span>
						</button>
					</c:if>
					<c:if test="${isScrapped ne true}">
						<button class="scrap-button"
							onclick="checkScrap(${postDetail.post.id})">
							<i class="far fa-bookmark"></i> <span>스크랩</span>
						</button>
					</c:if>
				</div>

			</div>
		</div>

		<div class="detail-info-container">

			<!-- 탭 -->
			<div class="tab-menu">
				<ul class="nav nav-pills tab-menu__inner">
					<li
						class="nav-item tab-menu__list tnb-area__list tab-menu__list--on">
						<a class="nav-link active" data-toggle="pill" href="#detail"><strong>식단
								정보</strong></a>
					</li>
					<li class="nav-item tab-menu__list"><a class="nav-link"
						data-toggle="pill" href="#comments"> <strong>투표 현황 /
								댓글</strong> <span class="tab-menu__count" id="reviwCnt">8</span>
					</a></li>
				</ul>
			</div>

			<!-- Tab panes -->
			<div class="tab-content">

				<!-- Tab 1 : 식단 정보 탭이 열리면 -->
				<div class="tab-pane container fade show active" id="detail">
					<div class="diy-detail">
						<!-- DIY 식단 관련 홍보 이미지 -->
						<div class="diy-advertise-sec" style="">
							<img src="/greating/resources/images/diy/diy-detail-banner.jpeg">
						</div>

					</div>

					<div class="detail-info-section">
						<div class="info-section-title">
							<div style="display: inline-block">Greating Info</div>
							<hr
								style="margin-left: 10px; border: none; height: 1px; display: inline-block; background-color: black; width: 79%">
						</div>
						<div class="info-img-text-sec">
							<div class="info-text-section">
								<div class="sub-info-line">
									<span class="info-title">분류</span> <span class="info-text">
										<span>${postDetail.mainCategory.name} >
											${postDetail.subCategory.name} </span> , <span>한식</span>

									</span>
								</div>
								<div class="sub-info-line">
									<span class="info-title">희망 칼로리</span> <span class="info-text">${postDetail.post.minCalorie}
										~ ${postDetail.post.maxCalorie}</span>
								</div>
								<div class="sub-info-line">
									<span class="info-title">희망 가격대</span> <span class="info-text">${postDetail.post.minPrice}
										~ ${postDetail.post.maxPrice} 원</span>
								</div>
								<div class="sub-info-line">
									<span class="info-title">영양사</span> <span class="info-text">${postDetail.user.name}</span>
								</div>

								<div class="sub-info-line last-line">
									<fmt:formatDate value="${postDetail.post.createdAt}"
										pattern="yyyy-MM-dd" var="formattedDate" />

								</div>

							</div>
							<div class="info-img-section">
								<img src="/greating/resources/images/diy/img_low_calorie.png">
							</div>
						</div>
					</div>
					<div class="detail-info-section">
						<div class="info-section-title">
							<div style="display: inline-block">Greating Components</div>
							<hr
								style="margin-left: 10px; border: none; height: 1px; display: inline-block; background-color: black; width: 65.5%">
						</div>
						<div class="info-text-section">

							<div class="sub-info-line">
								<span class="info-title">Rice</span> <span class="info-text">${postDetail.rice.name}</span>
							</div>
							<div class="sub-info-line">
								<span class="info-title">Soup</span> <span class="info-text">${postDetail.soup.name}</span>
							</div>
							<div class="sub-info-line">
								<span class="info-title">Main Dish</span> <span
									class="info-text">${postDetail.main.name}</span>
							</div>
							<div class="sub-info-line">
								<span class="info-title">Side Dish 1</span> <span
									class="info-text">${postDetail.side1.name}</span>
							</div>
							<div class="sub-info-line last-line">
								<span class="info-title">Side Dish 2</span> <span
									class="info-text">${postDetail.side2.name}</span>
							</div>

						</div>
					</div>

					<div class="detail-info-section">
						<div class="info-section-title">
							<div style="display: inline-block">Greating Samples</div>
							<hr
								style="margin-left: 10px; border: none; height: 0.5px; display: inline-block; background-color: black; width: 72%">
						</div>

						<div class="info-text-section">
							<div class="img-section">
								<img src="${postDetail.rice.imgUrl}"> <img
									src="${postDetail.soup.imgUrl}"> <img
									src="${postDetail.main.imgUrl}"> <img
									src="${postDetail.side1.imgUrl}"> <img
									src="${postDetail.side2.imgUrl}"> <img
									src="${postDetail.extra.imgUrl}">
							</div>
						</div>
					</div>
					<div class="detail-info-section">
						<!-- comment 섹션  -->
						<div class="info-section-title">

							<div style="display: inline-block">Greater's Comments</div>
							<hr
								style="margin-left: 10px; border: none; height: 0.5px; display: inline-block; background-color: black; width: 67%">
						</div>

						<div class="info-text-section comment-section"></div>

					</div>

					<div class="diy-related-post-section">
						<div class="info-section-title">
							<div style="display: inline-block">Other Greating</div>
							<hr
								style="margin-left: 10px; border: none; height: 0.5px; display: inline-block; background-color: black; width: 72%">
						</div>

						<div class="diy-realted-post">
							<div class="related-post-card">
								<div class="related-post-card-img">
									<img src="/greating/resources/images/diy/img_diy_sample.png">
								</div>
								<div class="related-post-card-info">진우형 도시락</div>
							</div>
							<div class="related-post-card">
								<div class="related-post-card-img">
									<img src="/greating/resources/images/diy/img_diy_sample.png">
								</div>
								<div class="related-post-card-info">진우형 도시락</div>
							</div>
							<div class="related-post-card">
								<div class="related-post-card-img">
									<img src="/greating/resources/images/diy/img_diy_sample.png">
								</div>
								<div class="related-post-card-info">진우형 도시락 진우형 도시락 진우형
									도시락</div>
							</div>
							<div class="related-post-card">
								<div class="related-post-card-img">
									<img src="/greating/resources/images/diy/img_diy_sample.png">
								</div>
								<div class="related-post-card-info">진우형 도시락 진우형 도시락 진우형
									도시락</div>
							</div>
						</div>


					</div>

					<div class="market-section">
						<div class="info-section-title">
							<div style="display: inline-block">In Greating Market</div>
							<hr
								style="margin-left: 10px; border: none; height: 0.5px; display: inline-block; background-color: black; width: 65%">
						</div>

						<ul class="market-cards">
							<c:forEach var="item" begin="1" end="4">

								<li class="market-card">
									<div class="market-card-img">

										<img src="/greating/resources/images/market/LA갈비.png">
									</div> <span> LA 갈비 </span>
								</li>
							</c:forEach>

						</ul>
					</div>

				</div>
				<!-- tab1 종료  -->
				<div class="tab-pane fade container" id="comments">준비중인 기능입니다.</div>

			</div>

		</div>
	</div>

	<!-- footer 가져오기 -->
	<jsp:include page="../templates/footer.jsp" />

</body>
</html>