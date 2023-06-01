<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DIY 식단</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- css로 가져오기 -->
<link href="${pageContext.request.contextPath}/resources/css/diy/diy-main.css" rel="stylesheet">

	
<script src="/greating/resources/js/diy/diy-main.js"></script>

</head>

<body>

	<!-- header 가져오기 -->
	<jsp:include page="../templates/header.jsp" />

	<!-- 1. 배너 -->
	<div class="banner-img">
		<div class="banner-content">
			<span class="banner-title">나만의 DIY 식단 </span> <span
				class="banner-description"> 원하는 밥/메인반찬/사이드 반찬 등을 담아<br>
				나만의 새로운 식단을 제안해보세요
			</span> <span class="banner-inner-icon"> <a href="${pageContext.request.contextPath}/mealdiy/new">
			<img src="${pageContext.request.contextPath}/resources/images/diy/img_healthy_icon_go.png">
			</a>
			</span>
		</div>
	</div>

	<main class="diy-main-start">
		<div class="main-content diy-main">

			<div class="secondary-main-content">
				<div class="simple-search-container">
					<span class="title">DIY 식단 간단 검색</span> <span class="search-text">다른
						유저가 이미 제안한 식단 중,<br>내가 원하는 식단이 있는지 쉽게 검색해보세요!
					</span>
					<div class="search-box">
						<input type="text" placeholder="검색어를 입력하세요">
						<button class="icon" type="button" onclick=""></button>
					</div>

					<div class="greating-category-sec">
						<div class="sub-title">카테고리</div>
						<div class="greating-category-btns">
							<input id="healthy-diet" type="checkbox" name="category" value="HEALTHY_DIET"> 
							<label for="healthy-diet">건강식단</label> 
							<input id="care-diet" type="checkbox" name="category" value="MEDICAL_DIET">
							<label for="care-diet">질병맞춤식단</label> 
							<input id="challenge-diet" type="checkbox" name="category" value="CHALLENGE_DIET"> 
							<label for="challenge-diet">챌린지식단</label>
						</div>
					</div>

					<div class="greating-country-sec">
						<div class="sub-title">분류</div>
						<div class="greating-country-btns">
							<input id="korean-diet" type="checkbox" name="country" value="KOREAN">
							<label for="korean-diet">한식</label> <input id="chinese-diet"
								type="checkbox" name="country" value="CHINESE"> <label
								for="chinese-diet">중식</label> <input id="japanese-diet"
								type="checkbox" name="country" value="JAPANESE"> <label
								for="japanese-diet">일식</label> <input id="western-diet"
								type="checkbox" name="country" value="WESTERN"> <label
								for="western-diet">양식</label> <input id="etc-diet"
								type="checkbox" name="country" value="ETC"> <label
								for="etc-diet">기타</label>
						</div>
					</div>

					<div class="greating-rice-sec">
						<div class="sub-title">밥</div>
						<div class="greating-rice-btns">
							<input id="rice-true" type="radio" name="rice-tf" value="y">
							<label for="rice-true">포함</label> <input id="rice-false"
								type="radio" name="rice-tf" value="n"> <label
								for="rice-false">미포함</label>
						</div>
					</div>

					<div class="greating-soup-sec">
						<div class="sub-title">국</div>
						<div class="greating-soup-btns">
							<input id="soup-true" type="radio" name="soup-tf" value="y">
							<label for="soup-true">포함</label> <input id="soup-false"
								type="radio" name="soup-tf" value="n"> <label
								for="soup-false">미포함</label>
						</div>
					</div>

					<div class="button-group">
						<button class="rectangle-gray-button" value="초기화" onclick="">초기화</button>
						<button class="rectangle-green-button" value="선택완료" onclick="search()">선택완료</button>
					</div>


				</div>
			</div>
			<div class="post-containers">
				<div class="today-post-container mb-5">
					<div class="today-title-sec">
						<div class="today-title-left">
							<span class="sub-title">오늘 업로드된 식단</span> <span class="sub-more">
								더보기 </span>
						</div>
						<div class="today-title-right">
							<span class="sub-option"> 최신순 보기 </span>
						</div>
					</div>
					<div class="hr"></div>

					<div class="today-post-list row row-cols-3">
						<c:forEach var="i" begin="1" end="3">
							<div class="col-4 today-post-card">
								<div class="today-post-img">
									<img src="${pageContext.request.contextPath}/resources/images/diet/우삼겹덮밥1.jpg">
								</div>
								<div class="today-post-info">
									<span> 연자육 소불고기 & 두부 도시락 세트 </span>
									<div class="today-post-sub-info">
										<div class="post-heart">348</div>
										<div class="post-writer">주먹왕 진우</div>
									</div>
									<div class="hr"></div>
									<div class="today-post-sub-info2">
										<div class="post-kcal">300 - 400 kcal</div>
										<div class="post-price">7000 - 8000원</div>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>


				<div class="weekly-post-container mb-5">
					<div class="weekly-title-sec">
						<div class="weekly-title-left">
							<span class="sub-title"> 이번주 인기식단 </span> <span class="sub-more">
								더보기 </span>
						</div>
						<div class="weekly-title-right">
							<span class="sub-option"> 최신순 보기 </span>
						</div>
					</div>
					<div class="hr"></div>

					<div class="weekly-post-list row row-cols-3">
						<c:forEach var="i" begin="1" end="3">
							<div class="col-4 weekly-post-card">
								<div class="weekly-post-img">
									<img src="${pageContext.request.contextPath}/resources/images/diet/갈릭포크후무스샐러드1.jpg">
								</div>
								<div class="weekly-post-info">
									<span> 갈릭포크후무스샐러드 </span>
									<div class="weekly-post-sub-info">
										<div class="post-heart">348</div>
										<div class="post-writer">주먹왕 진우</div>
									</div>
									<div class="hr"></div>
									<div class="weekly-post-sub-info2">
										<div class="post-kcal">300 - 400 kcal</div>
										<div class="post-price">7000 - 8000원</div>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="today-post-container">
					<div class="today-title-sec">
						<div class="today-title-left">
							<span class="sub-title">오늘 업로드된 식단</span> <span class="sub-more">
								더보기 </span>
						</div>
						<div class="today-title-right">
							<span class="sub-option"> 최신순 보기 </span>
						</div>
					</div>
					<div class="hr"></div>

					<div class="today-post-list row row-cols-3">
						<c:forEach var="i" begin="1" end="3">
							<div class="col-4 today-post-card">
								<div class="today-post-img">
									<img src="${pageContext.request.contextPath}/resources/images/diet/우삼겹덮밥1.jpg">
								</div>
								<div class="today-post-info">
									<span> 연자육 소불고기 & 두부 도시락 세트 </span>
									<div class="today-post-sub-info">
										<div class="post-heart">348</div>
										<div class="post-writer">주먹왕 진우</div>
									</div>
									<div class="hr"></div>
									<div class="today-post-sub-info2">
										<div class="post-kcal">300 - 400 kcal</div>
										<div class="post-price">7000 - 8000원</div>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

	</main>
	<!-- footer 가져오기 -->
	<jsp:include page="../templates/footer.jsp" />

</body>
</html>
