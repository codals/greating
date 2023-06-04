<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>

</head>


<body>

	<!-- header 가져오기 -->
	<jsp:include page="../templates/header.jsp" />
	<div class="hr"></div>

	<!-- 플로팅 공유 버튼 -->
	<div class="floating-container">
		<div class="floating-button">
			<img alt="" src="/greating/resources/images/templates/greating-floating-btn.png" onclick="toggleBox()">
			<div class="overlay">
			  <div style="display: flex;">
			      <div class="floating-overlay-button">
			        <img src="/greating/resources/images/templates/copy-link-icon.jpg" style="width: 28px; height: 28px; margin-top: 8px; margin-left: 10px;" onclick="copyLink()">>
			      </div>
			      <div class="floating-overlay-button">
			        <img src="/greating/resources/images/templates/kakao.png" onclick="share(${postDetail.post.id},'${kakaoShareKey}')">
			      </div>
			      <div class="floating-overlay-button">
			        <img src="" onclick="">
			      </div>
		    	</div>
		    </div>
		</div>
	</div>
	
	<!-- 플로팅 배너 -->	
	<div class="advertise">
		<div style="font-size: 15px; color: #999;">이것도 확인해보세요!</div>
		<div class="advertise-box">
			<div class="advertise-box-img">
				<img src="/greating/resources/images/templates/diy-floating-adv-v8.png">
			</div>	
		</div>
		<div class="advertise-box">
			<div class="advertise-box-btn"><a href="" style="color: black;">DIY 식단 투표하러 가기</a></div>
		</div>
		<div class="advertise-box">
			<div class="advertise-box-btn"><a href="" style="color: black;">DIY 식단 만들러 가기</a></div>
		</div>
	</div>
	
	
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
							${postDetail.subCategory.name}</span> , <span>한식</span>

					</span>

				</div>

				<div class="main-info-line">
					<span class="info-title">영양사</span> <span class="info-text">${postDetail.user.name}</span>

				</div>

				<div class="main-info-line">
					<span class="info-title">메인 구성</span> <span class="info-text">
						<span class="diy-dish-info">${postDetail.rice.name}</span> <span
						class="diy-dish-info">${postDetail.soup.name}</span> <span
						class="diy-dish-info">${postDetail.main.name}</span>
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
				<div class="tab-pane container active" id="detail">

					<div class="diy-detail">

						<!-- DIY 식단 관련 홍보 이미지 -->
						<div class="diy-advertise-sec" style="">
							<img src="/greating/resources/images/diy/img_greating_adv.png">
						</div>

					</div>

					<!-- 식단 정보 요약 -->
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
									<span class="info-title">작성일</span> <span class="info-text">${postDetail.post.createdAt}</span>
								</div>
							</div>

							<div class="info-img-section">
								<img src="/greating/resources/images/diy/img_low_calorie.png">
							</div>
						</div>
					</div>

					<!-- 식단 메뉴 설명 -->
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


					<!-- 식단 사진 샘플 -->
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


					<!-- 식단 Comments -->
					<div class="detail-info-section">
						<div class="info-section-title">
							<div style="display: inline-block">Greater's Comments</div>
							<hr
								style="margin-left: 10px; border: none; height: 0.5px; display: inline-block; background-color: black; width: 67%">
						</div>

						<div class="info-text-section comment-section">

							<div class="sub-info-line">
								<span class="info-title">1. </span> <span class="info-text">비지찌개에는
									삼겹살을 넣어주세요.</span>
							</div>
							<div class="sub-info-line">
								<span class="info-title">2. </span> <span class="info-text">파채를
									많이 넣어주세요.</span>
							</div>
							<div class="sub-info-line">
								<span class="info-title">3. </span> <span class="info-text">깻잎
									장아찌는 매콤하게 해주세요.</span>
							</div>
						</div>
					</div>

					<!-- DIY 식단 관련 홍보 이미지 -->
					<div class="diy-advertise-sec last-section">
						<img src="/greating/resources/images/diy/img_greating_adv.png">
					</div>

				</div>

				<!-- Tab 2 : 투표 현황/댓글 탭이 열리면 -->
				<div class="tab-pane container fade" id="comments">준비중인 기능입니다.
				</div>
			</div>
		</div>

	</div>


	<!-- footer 가져오기 -->
	<jsp:include page="../templates/footer.jsp" />

</body>
</html>