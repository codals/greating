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


