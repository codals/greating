<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DIY 식단</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/greating/resources/js/diy/diy-main.js"></script>

<link
	href="${pageContext.request.contextPath}/resources/css/diy/diy-main-new.css"
	rel="stylesheet">
<!-- alert 창 커스텀  -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<link href="/greating/resources/css/templates/alert.css" rel="stylesheet">


</head>
<body>

	<!-- header 가져오기 -->
	<jsp:include page="../templates/header.jsp" />
	
	<!-- 1. 배너 -->
	<div class="banner-img">
		<div class="banner-content">
			<span class="banner-small-description" style="font-size: 20px;">그리팅 사용자들이 직접 제안하는</span>
			<span class="banner-title">DIY 식단 검색</span>
			<span class="banner-description">내가 원하는 스타일과 구성으로 제안된<br>DIY 식단이 있는지 찾아보세요.</span>
			<div class="search-keyword-box">
				<input type="text" placeholder="검색어를 입력하세요">
				<button class="icon" type="button" onclick="openSearchBox()"></button>
			</div>
		</div>
	</div>


	<div class="hd__inner960">
		<div class="search-container">
			<!-- <div class="search-keyword-box">
			<input type="text" placeholder="검색어를 입력하세요">
			<button class="icon" type="button" onclick="openSearchBox();"></button>
		</div> -->

			<div class="greating-category-sec">
				<div class="sub-title">
					카테고리 - 어떤 식단을 선호하시나요?
					<hr>
				</div>
				<div class="greating-category-btns">
					<input id="healthy-diet" type="checkbox" name="category"
						value="HEALTHY_DIET"> <label for="healthy-diet">건강식단</label>
					<input id="care-diet" type="checkbox" name="category"
						value="MEDICAL_DIET"> <label for="care-diet">질병맞춤식단</label>
					<input id="challenge-diet" type="checkbox" name="category"
						value="CHALLENGE_DIET"> <label for="challenge-diet">챌린지식단</label>
				</div>
			</div>

			<div class="greating-country-sec">
				<div class="sub-title">분류 - 어떤 메뉴를 좋아하시나요?</div>
				<hr>
				<div class="greating-country-btns">
					<input id="korean-diet" type="checkbox" name="country" value="KOREAN">
					<label for="korean-diet">한식</label>
					<input id="chinese-diet" type="checkbox" name="country" value="CHINESE">
					<label for="chinese-diet">중식</label> 
					<input id="japanese-diet" type="checkbox" name="country" value="JAPANESE"> 
					<label for="japanese-diet">일식</label> 
					<input id="western-diet" type="checkbox" name="country" value="WESTERN">
					<label for="western-diet">양식</label>
					<input id="etc-diet" type="checkbox" name="country" value="ETC"> 
					<label for="etc-diet">기타</label>
				</div>
			</div>
			<div class="greating-sub-sec">
				<div class="greating-rice-sec">
					<div class="sub-title">
						밥
						<hr>
					</div>
					<div class="greating-rice-btns">
						<input id="rice-true" type="radio" name="rice-tf" value="y">
						<label for="rice-true">밥 포함</label>
						<input id="rice-false" type="radio" name="rice-tf" value="n">
						<label for="rice-false">밥 미포함</label>
					</div>
				</div>

				<div class="greating-soup-sec">
					<div class="sub-title">
						국
						<hr>
					</div>
					<div class="greating-soup-btns">
						<input id="soup-true" type="radio" name="soup-tf" value="y">
						<label for="soup-true">국 포함</label> 
						<input id="soup-false" type="radio" name="soup-tf" value="n">
						<label for="soup-false">국 미포함</label>
					</div>
				</div>
				
			</div>

			<div class="button-group">
				<button class="rectangle-gray-button" value="초기화" onclick="resetSelection()">초기화</button>
				<button class="rectangle-green-button" value="선택완료" onclick="search()">검색하기</button>
			</div>
		</div>

	</div>

	<div class="main-content hd__inner1100">
		<div class="hd__inner960">
			<div style="margin:30px 0px -30px 20px;">
				<h5 style="font-weight: bold;">실시간 인기 DIY 식단</h5>
			</div>
			<div class="diet-card-list">
				<c:forEach var="post" items="${healthyPostTop10}">
					<div class="diet-card">
						<div class="diet-card-img">
							<img src="${post.imgUrl}"> 
						</div>
						<div class="diet-card-info">
							<span><a href="/greating/mealdiy/${post.id}" style="color:black;">${post.title}</a></span>
							<div class="diet-card-sub-info">
								<div class="post-heart">${post.voteCnt}</div>
								<div class="post-writer">${post.username}</div>
							</div>
							<div class="hr"></div>
							<div class="diet-card-sub-info2">
								<div class="post-kcal">${post.minCalorie} - ${post.maxCalorie} kcal</div>
								<div class="post-price">${post.minPrice} - ${post.maxCalorie}원</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<!-- footer 가져오기 -->
	<jsp:include page="../templates/footer.jsp" />

</body>
</html>