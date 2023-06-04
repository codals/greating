<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="${pageContext.request.contextPath}/resources/css/admin/admin-sidebar.css" rel="stylesheet">
<section class="sidebar">
	<div class="sidebar-div">
		<div class="profile">
			<img src="/greating/resources/images/user/eddy.png" alt="프로필 사진">
			<h3 class="sidebar-text">관리자 : Eddy Bang</h3>
		</div>
		<ul class="menu">
			<li><a href="/greating/admin/popular" class="sidebar-text">인기 식단 목록</a></li>
			<li><a href="/greating/admin/commingsoon" class="sidebar-text">출시 예정 식단 목록</a></li>
		</ul>
	</div>
</section>