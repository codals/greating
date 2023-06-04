<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSP 페이지 설정 -->

<!-- Google Fonts 스타일시트 -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />

<!-- 사용될 CSS 파일 -->
<link href="/greating/resources/css/templates/floating.css" rel="stylesheet">
<script src="/greating/resources/js/templates/floating.js"></script>

<!--  bootstrap  -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- 플로팅 배너 -->	
	<div class="advertise">
		<div style="font-size: 15px; color: #999;">이것도 확인해보세요!</div>
		<div class="advertise-box">
			<a href="/greating/mealdiy" style="color: black;">
				<div class="advertise-box-img">
				<img src="/greating/resources/images/templates/diy-floating-adv-v8.png">
				</div>	
			</a>
		</div>
		<div class="advertise-box">
			<div class="advertise-box-btn"><a href="/greating/mealdiy/popular" style="color: black;">DIY 식단 TOP 10</a></div>
		</div>
		<div class="advertise-box">
			<div class="advertise-box-btn"><a href="/greating/mealdiy/new" style="color: black;">DIY 식단 만들러 가기</a></div>
		</div>
	</div>