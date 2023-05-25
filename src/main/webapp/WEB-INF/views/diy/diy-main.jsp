<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIY 식단</title>
		
		<!-- css로 가져오기 -->
		<link href="/greating/resources/css/reset.css" rel="stylesheet">
		<link href="/greating/resources/css/diy/diy-main.css" rel="stylesheet">
		
		<!-- font 가져오기 -->
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
		<link href="https://fonts.googleapis.com/css?family=NanumMyeongjo&display=swap" rel="stylesheet" />

	</head>
	
	<body>
	
		<!-- header 가져오기 -->
		<jsp:include page="../templates/header.jsp"/>

		<!-- 1. 배너 -->
		<div class="banner-img">
			<span class="banner-title">나만의 DIY 식단 </span>
			<span class="banner-description">원하는 밥/메인반찬/사이드 반찬 등을 담아<br>나만의 새로운 식단을 제안해보세요</span>
			<span class="banner-inner-icon">
				<a href="#">
					<img src="/greating/resources/images/diy/img_healthy_icon_go.png">
				</a>
			</span>
		</div>
		
		<div class="main-content hd__inner1100">
		
		<div class="secondary-main-content">
		
			<!-- 2. 검색 모달 -->
			<div class="simple-search-container">
			
				<span class="title">DIY 식단 간단 검색</span>
				<span class="search-text">다른 유저가 이미 제안한 식단 중,<br>내가 원하는 식단이 있는지 쉽게 검색해보세요!</span>
			  	<div class="search-box">
			  		<input type="text" placeholder="검색어를 입력하세요">
					<button class="icon" type="button" onclick=""></button>	  			
				</div>
				
				<div class="sub-title greating-category-sec">카테고리
				  <div class="greating-category-btns">
				    <input id="healthy-diet" type="checkbox" name="category" value="건강식단">
				    <label for="healthy-diet">건강식단</label>
				
				    <input id="care-diet" type="checkbox" name="category" value="건강식단">
				    <label for="care-diet">질병맞춤식단</label>
				
				    <input id="challenge-diet" type="checkbox" name="category" value="챌린지식단">
				    <label for="challenge-diet">챌린지식단</label>
				  </div>
				</div>
			  	
			  	<div class="sub-title greating-country-sec">분류
				  <div class="greating-country-btns">
				    <input id="korean-diet" type="checkbox" name="country" value="한식">
				    <label for="korean-diet">한식</label>
				
				    <input id="chinese-diet" type="checkbox" name="country" value="중식">
				    <label for="chinese-diet">중식</label>
				
				    <input id="japanese-diet" type="checkbox" name="country" value="일식">
				    <label for="japanese-diet">일식</label>
				
				    <input id="western-diet" type="checkbox" name="country" value="양식">
				    <label for="western-diet">양식</label>
				
				    <input id="etc-diet" type="checkbox" name="country" value="기타">
				    <label for="etc-diet">기타</label>
				  </div>
				</div>
			  	
			  	<div class="sub-title greating-rice-sec">밥
				  <div class="greating-rice-btns">
				    <input id="rice-true" type="radio" name="rice-tf" value="포함">
				    <label for="rice-true">포함</label>
				
				    <input id="rice-false" type="radio" name="rice-tf" value="미포함">
				    <label for="rice-false">미포함</label>
				  </div>
				</div>
			  	
			  	<div class="sub-title greating-soup-sec">국
				  <div class="greating-soup-btns">
				    <input id="soup-true" type="radio" name="soup-tf" value="포함">
				    <label for="soup-true">포함</label>
				
				    <input id="soup-false" type="radio" name="soup-tf" value="미포함">
				    <label for="soup-false">미포함</label>
				  </div>
				</div>
				
				<div class="button-group">
				  <button class="rectangle-gray-button" value="초기화" onclick="">초기화</button>
				  <button class="rectangle-green-button" value="선택완료" onclick="">선택완료</button>
				</div>
				
			  	
		  	</div>
			
			<!-- 3. 인기글 부분 -->
			<div class="post-containers">
				<div class="today-post-container">
					<div class="sub-title">오늘 업로드된 식단</div>
				</div>				
			</div>

		</div>
	</div>
						

	<!-- footer 가져오기 -->
		<jsp:include page="../templates/footer.jsp"/>
		
	</body>
</html>