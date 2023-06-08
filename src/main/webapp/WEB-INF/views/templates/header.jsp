<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.codals.greating.user.entity.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JSP 페이지 설정 -->

<!-- Google Fonts 스타일시트 -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />

<!-- 헤더에 사용될 CSS 파일 -->
<link href="${pageContext.request.contextPath}/resources/css/templates/header.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/templates/reset.css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/resources/js/templates/header.js"></script>

<!--  bootstrap  -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- alert 창 커스텀  -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
	<link href="/greating/resources/css/templates/alert.css" rel="stylesheet">
	
<div id="wrap">
	<header id="header" class="hd__header" care>
		<!-- 맨 위 로그인/유저 관련 배너들 -->
		<div class="banner">
			<!-- 로그인된 사용자인 경우 -->
			<c:if test="${not empty sessionScope.loginUser && sessionScope.loginUser.role == Role.USER}">
				<span class="welcome-message">
				<a href="${pageContext.request.contextPath}/mypage/profile"
				style="color: inherit; text-decoration: none;">
				${sessionScope.loginUser.name}님</a></span>
				<span class="divider"></span>
				<span class="link">쿠폰등록</span>
				<span class="divider"></span>
				<span class="customer-service-label">고객센터</span>
				<span class="divider"></span>
				<span class="link"><a href="javascript:logout()" style="color: black;">로그아웃</a></span>
			</c:if>

			<c:if test="${not empty sessionScope.loginUser && sessionScope.loginUser.role == Role.ADMIN}">
				<span class="welcome-message">
				<a href="${pageContext.request.contextPath}/mypage/profile"
				   style="color: inherit; text-decoration: none;">
				${sessionScope.loginUser.name}님</a></span>
				<span class="divider"></span>
				<span class="link">쿠폰등록</span>
				<span class="divider"></span>
				<span class="admin-page">관리자 페이지</span>
				<span class="divider"></span>
				<span class="link"><a href="javascript:logout()" style="color: black;">로그아웃</a></span>
			</c:if>

			<!-- 로그인되지 않은 사용자인 경우 -->
			<c:if test="${empty sessionScope.loginUser}">
				<span class="link"><a href="${pageContext.request.contextPath}/login" class="no-underline">로그인</a></span>
				<span class="divider"></span>
				<span class="link"><a href="${pageContext.request.contextPath}/register" class="no-underline">회원가입</a></span>
				<span class="divider"></span>
				<span class="link">쿠폰등록</span>
				<span class="divider"></span>
				<span class="customer-service-label">고객센터</span>
			</c:if>
		</div>

		<div class="header">
			<div class="header__inner">
				<!-- 두번째 헤더 -->
				<div class="header__sec">
					<h1 class="logo">
						<a href="${pageContext.request.contextPath}">
							<img src="${pageContext.request.contextPath}/resources/images/templates/img_header_logo.png" alt="그리팅몰">
						</a>
					</h1>

					<div class="menu">
						<a href="#">건강마켓</a>
						<a href="#" class="on">식단관리<i>N</i></a>
					</div>

					<nav class="direct">
						<div class="direct__search btn__modal-open" data-login="y"
							id="searchPopup" data-popup-name="popup_search">
							<!-- 검색 입력 필드 -->
							<input type="text" id="searchInput2" class="search-input"
								placeholder="맛있는 단백질 보충, 고단백 식단 출시!" autocomplete="off">
							<button type="button" class="direct__search-remove"
								style="display: none;">지우기</button>
							<a href="#" class="btn__modal-open" data-login="n"
								data-popup-name="popup_search">검색</a>
						</div>
						<a href="/spComn/checkAddress" class="direct__btn"> <img
							src="${pageContext.request.contextPath}/resources/images/templates/btn_header_shipping.jpg"
							alt="하루·택배 배송안내">
						</a> <a href="cart" class="direct__cart">
						<span id="cartCnt">0</span> 
						<img src="${pageContext.request.contextPath}/resources/images/templates/icon_header_cart.png" alt="장바구니">
						</a>
					</nav>
				</div>

			<div id="careHeadCategory" class="navbar header__sec">
				<div class="all">
			        <a href="#" class="L-Affiliate-Tagged">
			            <span class="all__icon">
			                <span></span> 
			                <span></span> 
			                <span></span> 
			            </span>
			            <div>카테고리</div>
			        </a>
			        <div class="all-menu">
			            <div class="all-menu__inner">
			                <ul class="all-menu__depth1">
			                    <li><a href="#" class="L-Affiliate-Tagged">건강식단</a>
			                        <ul class="all-menu__depth2">
			                            <li><a href="#" class="L-Affiliate-Tagged">저당식단</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">칼로리식단</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">장수마을식단</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">고단백식단</a></li>
			                            <li><a href="${pageContext.request.contextPath}/diets/mygreating" class="L-Affiliate-Tagged">마이그리팅</a></li>
			                        </ul>
			                    </li>
			                    <li><a href="#" class="L-Affiliate-Tagged">질환맞춤식단</a>
			                        <ul class="all-menu__depth2">
			                            <li><a href="#" class="L-Affiliate-Tagged">당뇨식단</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">암환자식단</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">당뇨식단(냉동)</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">신장질환식단<br>(투석환자용)</a></li>
			                        </ul>
			                    </li>
			                    <li><a href="#" class="L-Affiliate-Tagged">챌린지식단</a>
			                        <ul class="all-menu__depth2">
			                            <li><a href="#" class="L-Affiliate-Tagged">뷰티핏</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">베지라이프</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">프로틴업</a></li>
			                        </ul>
			                    </li>
			                    <li><a href="${pageContext.request.contextPath}/mealdiy" class="L-Affiliate-Tagged">DIY 도시락</a>
			                        <ul class="all-menu__depth2">
			                            <li><a href="${pageContext.request.contextPath}/mealdiy/popular" class="L-Affiliate-Tagged">TOP 10 모아보기</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">테마별 모아보기</a></li>
			                            <li><a href="${pageContext.request.contextPath}/mealdiy/new" class="L-Affiliate-Tagged">DIY 도시락 만들기</a></li>
			                        </ul>
			                    </li>
			                    <li><a href="#" class="L-Affiliate-Tagged">서비스</a>
			                        <ul class="all-menu__depth2">
			                            <li><a href="#" class="L-Affiliate-Tagged">이용방법</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">배송안내</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">모바일 이용권</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">단체주문상담</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">멤버십 안내</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">공지사항</a></li>
			                            <li><a href="#" class="L-Affiliate-Tagged">고객센터</a></li>
			                        </ul>
			                    </li>
			                </ul>
			            </div>
			        </div>
			    </div>

				<!-- 카테고리 - 기본 - 나란히 -->
				<div class="gnb">
				    <div class="gnb__inner">
				      <div class="swiper-container">
				        <div class="swiper-wrapper">
				          <li class="gnb__list"><a href="#" class="gnb__list-name L-Affiliate-Tagged">건강식단</a></li>
				          <li class="gnb__list"><a href="#" class="gnb__list-name L-Affiliate-Tagged">질환맞춤식단</a></li>
				          <li class="gnb__list"><a href="#" class="gnb__list-name L-Affiliate-Tagged">챌린지식단</a></li>
				          <li class="gnb__list"><a href="${pageContext.request.contextPath}/mealdiy" class="gnb__list-name L-Affiliate-Tagged">DIY 도시락</a></li>
				          <li class="gnb__list"><a href="#" class="gnb__list-name L-Affiliate-Tagged">이벤트</a></li>
				          <li class="gnb__list"><a href="#" class="gnb__list-name L-Affiliate-Tagged">리뷰</a></li>
				          <li class="gnb__list"><a href="#" class="gnb__list-name L-Affiliate-Tagged">이용방법</a></li>
				        </div>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
		</div>
	</header>
</div>
