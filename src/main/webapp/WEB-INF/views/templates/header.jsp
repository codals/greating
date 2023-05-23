<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/header.css" rel="stylesheet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 맨 위 배너 -->
<header>
	<div class="banner">
	  <c:if test="${not empty sessionScope.loginUser}">
	    <span class="welcome-message">${sessionScope.loginUser}님</span>
	    <span class="divider"></span>
	    <span class="link">쿠폰등록</span>
	    <span class="divider"></span>
	    <span class="customer-service-label">고객센터</span>
	    <span class="divider"></span>
	    <span class="link">로그아웃</span>
	  </c:if>
	  <c:if test="${empty sessionScope.loginUser}">
	    <span class="link"><a href="/greating/login" class="no-underline">로그인</a></span>
	    <span class="divider"></span>
	    <span class="link"><a href="/greating/signup" class="no-underline">회원가입</a></span>
	    <span class="divider"></span>
	    <span class="link">쿠폰등록</span>
	    <span class="divider"></span>
	    <span class="customer-service-label">고객센터</span>
	  </c:if>
	</div>
</header>

<!-- 두번째 헤더 -->
<header id="header" class="hd__header" care>
	<div class="header">
		<div class="header__inner">
			<div class="header__sec">
				<h1 class="logo">
					<a href="javascript:fnMoveHome('');">
					<img src="${pageContext.request.contextPath}/resources/images/img_header_logo.png" alt="그리팅몰"></a>
				</h1>

				<div class="menu">
					<a href="javascript:fnMoveHome('market');">건강마켓</a> <a
						href="javascript:fnMoveHome('meals');" class="on">식단관리<i>N</i></a>
				</div>

				<nav class="direct">
					<div class="direct__search btn__modal-open" data-login="y"
						id="searchPopup" data-popup-name="popup_search">
						<!-- 2021.09.23 YSC 상품권 내리기 <input type="text" id="searchInput2" class="search-input" placeholder="그리팅 '기프트 카드' 출시!" autocomplete="off">  -->
						<input type="text" id="searchInput2" class="search-input"
							placeholder="맛있는 단백질 보충, 고단백 식단 출시!" autocomplete="off">
						<button type="button" class="direct__search-remove"
							style="display: none;">지우기</button>
						<a href="#" class="btn__modal-open" data-login="n"
							data-popup-name="popup_search">검색</a>
					</div>
					<a href="/spComn/checkAddress" class="direct__btn">
						<img src="${pageContext.request.contextPath}/resources/images/btn_header_shipping.jpg" alt="하루·택배 배송안내">
					</a>

					<a href="/order/orderCart" class="direct__cart">
					  <span id="cartCnt">0</span>
					  <img src="${pageContext.request.contextPath}/resources/images/icon_header_cart.png" alt="장바구니">
					</a>
				</nav>
			</div>

			<!-- <div id="careHeadCategory" class="header__sec">
				<div class="all">
					<a href="#"> <span class="all__icon"> <span></span> <span></span>
							<span></span>
					</span>
						<div>카테고리</div>
					</a>

					<div class="all-menu">
						<div class="all-menu__inner">
							<ul class="all-menu__depth1">
								<li><a href="/planMeals/healthyMeals">건강식단</a>

									<ul class="all-menu__depth2">
										<li><a href="/planMeals/careLow">저당식단</a></li>
										<li><a href="/planMeals/careLight">칼로리식단</a></li>
										<li><a href="/planMeals/careWellness">장수마을식단</a></li>
										<li><a href="/planMeals/careHighP">고단백식단</a></li>
										<li><a href="/planMeals/careMyGreating">마이그리팅</a></li>
									</ul></li>

								<li><a href="/planMeals/planMeals">질환맞춤식단</a>

									<ul class="all-menu__depth2">
										<li><a href="/planMeals/careDiabetes">당뇨식단</a></li>
										<li><a href="/planMeals/careCancer">암환자식단</a></li>
										<li><a
											href="/market/marketDetail?itemId=136843&toggle=meals">당뇨식단(냉동)</a>
										</li>
										<li><a
											href="/market/marketDetail?itemId=136840&toggle=meals">신장질환식단<br>(투석환자용)
										</a></li>
									</ul></li>

								<li><a href="/planMeals/challenge">챌린지식단</a>

									<ul class="all-menu__depth2">
										<li><a
											href="/market/marketDetail?itemId=102760&toggle=meals">뷰티핏</a>
										</li>
										<li><a
											href="/market/marketDetail?itemId=127243&toggle=meals">베지라이프</a>
										</li>
										<li><a
											href="/market/marketDetail?itemId=102759&toggle=meals">프로틴업</a>
										</li>
									</ul></li>

								<li><a href="/story/storyMain">스토리</a>

									<ul class="all-menu__depth2">
										<li><a href="/story/storyMain">브랜드 소개</a></li>
										<li><a href="/story/greatingLife/greatingLifeList">그리팅
												매거진</a></li>
										<li><a href="/story/month/monthStoryList">그리팅 TV</a></li>
									</ul></li>

								<li><a href="#none">서비스</a>

									<ul class="all-menu__depth2">
										<li><a href="/story/guideMain">이용방법</a></li>
										<li><a href="/spComn/checkAddress">배송안내</a></li>
										<li><a href="/main/boardDetail?freeboardId=340">모바일
												이용권</a></li>
										<li><a href="/groupOrder/groupOrderMain">단체주문상담</a></li>
										<li><a href="/serviceCenter/benefit">멤버십 안내</a></li>
										<li><a href="/serviceCenter/notice">공지사항</a></li>
										<li><a href="/serviceCenter/serviceCenterMain">고객센터</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="gnb">
					<div class="gnb__inner">
						<div class="swiper-container">
							<div class="swiper-wrapper">
								<li class="gnb__list"><a href="/planMeals/healthyMeals"
									class="gnb__list-name">건강식단</a></li>
								<li class="gnb__list"><a href="/planMeals/planMeals"
									class="gnb__list-name">질환맞춤식단</a></li>
								<li class="gnb__list"><a href="/planMeals/challenge"
									class="gnb__list-name">챌린지식단</a></li>
								<li class="gnb__list"><a
									href="/event/eventList?targetMenuType=1" class="gnb__list-name">이벤트</a>
								</li>
								<li class="gnb__list"><a href="/story/reviewMain"
									class="gnb__list-name">리뷰</a></li>
								<li class="gnb__list"><a href="/story/guideMain"
									class="gnb__list-name">이용방법</a></li>
							</div>
						</div>
					</div>
				</div>
			</div> -->

		</div>
	</div>
</header>
