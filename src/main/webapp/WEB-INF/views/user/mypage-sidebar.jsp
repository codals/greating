<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link href="${pageContext.request.contextPath}/resources/css/user/mypage-sidebar.css" rel="stylesheet">
    

		<aside class="snb">
			<h2 class="page-title">마이페이지</h2>
			<ul class="snb-box myPageBox">
				<li class="snb-box-list">
					<ul class="snb-box-inner">
						<li class="snb-box-inner-list"><h4>나의 쇼핑내역</h4></li>
						<li class="snb-box-inner-list"><a href="#"> 주문/배송 조회·변경</a></li>
						<li class="snb-box-inner-list"><a href="#"> 취소/교환/반품 조회 </a></li>
						<li class="snb-box-inner-list"><a href="#"> 일자별 배송상품 조회</a></li>
						<li class="snb-box-inner-list"><a href="#"> 구독관리</a></li>
					</ul>


				</li>
				
				<li class="snb-box-list">
					<ul class="snb-box-inner">
						<li class="snb-box-inner-list"><h4>나의 식단</h4></li>
						<li class="snb-box-inner-list"><a href="${pageContext.request.contextPath}/mypage/diets"> 내가 등록한 식단 </a></li>
						<li class="snb-box-inner-list"><a href="${pageContext.request.contextPath}/mypage/scrap"> 나의 스크랩 식단 </a></li>
						<li class="snb-box-inner-list"><a href="${pageContext.request.contextPath}/mypage/voted"> 내가 투표한 식단 </a></li>
					</ul>


				</li>
				
				<li class="snb-box-list">
					<ul class="snb-box-inner">
						<li class="snb-box-inner-list"><h4>회원정보</h4></li>
						<li class="snb-box-inner-list"><a href="${pageContext.request.contextPath}/mypage/profile"> 회원정보 수정  </a></li>
					</ul>
				</li>

			</ul>

		</aside>
