<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
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
		

		</div>

	<!-- footer 가져오기 -->
		<jsp:include page="../templates/footer.jsp"/>
		
	</body>
</html>