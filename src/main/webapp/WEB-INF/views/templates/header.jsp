<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
<link href="/WEB-INF/views/templates/css/header.css" rel="stylesheet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	* {
		box-sizing: border-box;
	}
	
	body {
		font-size: 14px;
	}
	
	.banner {
		width: 90%;
		height: 45px;
		background: url("../images/v62_1140.png");
		background-repeat: no-repeat;
		background-position: right top;
		background-size: cover;
		opacity: 1;
		position: relative;
		top: 0px;
		left: 0px;
		overflow: hidden;
		margin: 0 auto;
		text-align: right;
	}
	
	.banner span {
		display: inline-block;
		vertical-align: middle;
		color: rgba(28, 28, 28, 1);
		font-family: "Noto Sans KR";
		font-weight: 300;
		font-size: 14px;
		opacity: 1;
	}
	
	.link {
		text-align: right;
		margin: 0 5px;
	}
	
	.link a.no-underline {
	  text-decoration: none;
	  color: inherit;
	}
	
	.divider {
		width: 1px;
		height: 15px;
		background: rgba(136, 136, 136, 1);
		margin: 0 5px;
	}
	
	.customer-service {
		width: 64px;
		height: 46px;
		background: url("../images/v62_1146.png");
		background-repeat: no-repeat;
		background-position: center center;
		background-size: cover;
		opacity: 1;
		vertical-align: middle;
	}
	
	.customer-service-label {
		text-align: right;
		margin: 0 5px;
	}
	
	.divider:last-child {
		display: none;
	}
</style>

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


