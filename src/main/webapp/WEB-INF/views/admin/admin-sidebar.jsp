<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="${pageContext.request.contextPath}/resources/css/admin/admin-sidebar.css" rel="stylesheet">
 <c:if test="${not empty loginUser and loginUser.username ne 'codalsadmin'}">
        <script>
            location.href = "/greating/";
        </script>
</c:if>

<section class="sidebar">
	<div class="sidebar-div">
		<div class="greating-go-home">
			<a href="/greating/"><img
			src="/greating/resources/images/templates/img_header_logo.png"></a>
		</div>
		<div class="profile">
			<img src="/greating/resources/images/user/admin_photo2.png" alt="프로필 사진">
			<h3 class="sidebar-text">관리자 : ${loginUser.name}</h3>
		</div>
		<ul class="menu">
			<li><a href="/greating/admin/allList" class="sidebar-text">전체 도시락 목록</a></li>
			<li><a href="/greating/admin/popular" class="sidebar-text">투표 종료 인기 도시락 목록</a></li>
			<li><a href="/greating/admin/commingsoon" class="sidebar-text">출시 예정 도시락 목록</a></li>
      <li><a href="/greating/admin/register" class="sidebar-text">도시락 등록하기</a></li>
		</ul>
	</div>
</section>