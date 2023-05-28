<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DIY 식단 상세보기</title>

<!-- css로 가져오기 -->
<link href="/greating/resources/css/reset.css" rel="stylesheet">
<link href="/greating/resources/css/diy/diy-detail.css" rel="stylesheet">

<!-- js 가져오기 -->
<script src="/greating/resources/js/diy/diy-detail.js"></script>

<!-- font 가져오기 -->
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=NanumMyeongjo&display=swap"
	rel="stylesheet" />

<!-- bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

</head>

<body>

	<!-- header 가져오기 -->
	<jsp:include page="../templates/header.jsp" />

	<!-- 본 페이지 내용 -->
	<div class="main-content hd__inner1100">
		<div class="main-info-container">

			<div class="main-img">
				<img src="/greating/resources/images/diy/img_diy_sample.png"
					alt="Main Image">
			</div>

			<div class="main-info-text-container">

				<div class="main-introduction">
					<span class="diy-type">DIY 도시락</span>
				</div>

				<div class="main-title">
					<span class="title-text">돼지고기콩비지찌개 & 파채돼지불고기</span> <span
						class="new-badge">New</span>
				</div>

				<div class="main-info-line">
					<!-- 
						<span class="diy-category-info">건강식단 > 칼로리식단</span>
						<span class="diy-category-info">한식</span>
						-->
					<span class="info-title">분류</span> 
					<span class="info-text">
						<span>건강식단 > 칼로리식단</span>
						, 
						<span>한식</span>
					</span>

				</div>

				<div class="main-info-line">
					<span class="info-title">영양사</span> 
					<span class="info-text">주먹왕진우</span>
				</div>

				<div class="main-info-line">
					<span class="info-title">메인 구성</span> <span class="info-text">
						<span class="diy-dish-info">귀리밥</span> <span class="diy-dish-info">파채돼지불고기</span>
						<span class="diy-dish-info">돼지고기콩비지찌개</span>
					</span>
				</div>

				<div class="main-info-line">
					<span class="info-title">희망 칼로리</span> <span class="info-text">400
						~ 500kcal</span>
				</div>

				<div class="main-info-line">
					<span class="info-title">투표 현황</span>
					<div class="diy-vote-info">
						<img src="/greating/resources/images/diy/img_greating_vote.png"
							style="width: 30px; heigh: 30px;"> <span class="vote-count">481</span>
						votes
					</div>
				</div>

				<div class="button-group">
					<button class="white-button">
						<!-- <img src="/greating/resources/images/diy/img_" alt="이미지_설명"> -->
						<span>♡ 투표하기</span>
					</button>
					<button class="green-button">
						<img src="/greating/resources/images/diy/img_scrap_icon.png"
							style="width: 22px; heigh: 22px;"scrapicon"> <span>스크랩</span>
					</button>
				</div>

			</div>
		</div>

		<div class="detail-info-container">
			 
			 <!-- 탭 -->
			<div class="tab-menu">
				<ul class="nav nav-pills tab-menu__inner">
				  <li class="nav-item tab-menu__list tnb-area__list tab-menu__list--on">
				    <a class="nav-link active" data-toggle="pill" href="#detail"><strong>식단 정보</strong></a>
				  </li>
				  <li class="nav-item tab-menu__list">
				    <a class="nav-link" data-toggle="pill" href="#comments">
				    	<strong>투표 현황 / 댓글</strong>
				    	<span class="tab-menu__count" id="reviwCnt">8</span>
			    	</a>
				  </li>
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
							<div style="display:inline-block">Greating Info</div>
						 	<hr style="margin-left: 10px; border: none; height: 1px; display:inline-block; background-color: black; width: 79%">
						 </div>
						 
						 <div class="info-img-text-sec">
							 <div class="info-text-section">
								<div class="sub-info-line">
									<span class="info-title">분류</span> 
									<span class="info-text">
										<span>건강식단 > 칼로리식단</span>
										, 
										<span>한식</span>
									</span>
								</div>
								
								<div class="sub-info-line">
									<span class="info-title">희망 칼로리</span> 
									<span class="info-text">400 ~ 500kcal</span>
								</div>
								
								<div class="sub-info-line">
									<span class="info-title">희망 가격대</span> 
									<span class="info-text">8000 ~ 9000원</span>
								</div>
								
								<div class="sub-info-line">
									<span class="info-title">영양사</span> 
									<span class="info-text">주먹왕진우</span>
								</div>
								
								<div class="sub-info-line last-line">
									<span class="info-title">작성일</span> 
									<span class="info-text">2023.05.26</span>
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
							<div style="display:inline-block">Greating Components</div>
						 	<hr style="margin-left: 10px; border: none; height: 1px; display:inline-block; background-color: black; width: 65.5%">
						 </div>
						 
						 <div class="info-text-section">
							 <div class="sub-info-line">
								<span class="info-title">Rice</span> 
								<span class="info-text">귀리밥</span>
							 </div>
							 <div class="sub-info-line">
								<span class="info-title">Soup</span> 
								<span class="info-text">돼지고기콩비지찌개</span>
							 </div>
							 <div class="sub-info-line">
								<span class="info-title">Main Dish</span> 
								<span class="info-text">파채돼지불고기</span>
							 </div>
							 <div class="sub-info-line">
								<span class="info-title">Side Dish 1</span> 
								<span class="info-text">깻잎 장아찌</span>
							 </div>
							 <div class="sub-info-line last-line">
								<span class="info-title">Side Dish 2</span> 
								<span class="info-text">오징어젓갈</span>
							 </div>
						 </div>
						 
					</div>
					
					
					<!-- 식단 사진 샘플 -->
					<div class="detail-info-section">
						<div class="info-section-title">
							<div style="display:inline-block">Greating Samples</div>
						 	<hr style="margin-left: 10px; border: none; height: 0.5px; display:inline-block; background-color: black; width: 72%">
						 </div>
						 
						 <div class="info-text-section">
						 	<div class="img-section">
						 		<img src="/greating/resources/images/food/귀리현미밥.png">
							 	<img src="/greating/resources/images/food/돼지고기콩비지찌개.png">
							 	<img src="/greating/resources/images/food/파채돼지불고기.png">
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
				<div class="tab-pane container fade" id="comments">
					준비중인 기능입니다.
				</div>
			</div>
		</div>

	</div>


	<!-- footer 가져오기 -->
	<jsp:include page="../templates/footer.jsp" />

</body>
</html>