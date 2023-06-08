<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSP 페이지 설정 -->

<!-- Google Fonts 스타일시트 -->
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />

<!-- 사용될 CSS 파일 -->
<link href="/greating/resources/css/templates/floating.css"
	rel="stylesheet">
<script src="/greating/resources/js/templates/floating.js"></script>

<!--  bootstrap  -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 플로팅 공유 버튼 -->
<div class="floating-container">
	<div class="floating-button">
		<img alt=""
			src="/greating/resources/images/templates/greating-floating-btn.png"
			onclick="toggleBox()">
		<div class="overlay">
			<div style="display: flex;">
				<div class="floating-overlay-button">
					<img src="/greating/resources/images/templates/copy-link-icon.jpg"
						style="width: 28px; height: 28px; margin-top: 8px; margin-left: 10px;"
						onclick="copyLink()">
				</div>
				<div class="floating-overlay-button">
					<img src="/greating/resources/images/templates/kakao.png"
						onclick="share(${postDetail.post.id},'${kakaoShareKey}')">
				</div>
				
				<div class="floating-overlay-button">
				<img src="/greating/resources/images/diy/youtube-new.png" onclick="linkYoutube()">
				</div>
			</div>
		</div>
	</div>
</div>
