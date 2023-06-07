<!-- JSP 페이지 설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Google Fonts 스타일시트 -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<!-- CSS -->
<link href="/greating/resources/css/templates/pagination.css" rel="stylesheet" />

<!-- 페이징 버튼 -->
<div class="pagination">
	<c:if test="${dto.page > 1}">
		<c:if test="${dto.totalPage > 5}">
			<a href="page=1">처음</a>
		</c:if>
		<a href="?page=${dto.page - 1}">이전</a>
	</c:if>

	<!-- 현재 선택한 페이지가 가운데 있게하는 로직 -->
	<c:set var="startPage" value="${dto.page - 2}" />
	<c:set var="endPage" value="${dto.page + 2}" />
	<!-- 다만 첫번째 페이지부터 3페이지까지는 1 2 3 4 5 가 띄워져야함 -->
	<c:if test="${startPage < 1}">
		<c:set var="startPage" value="1" />
		<c:set var="endPage" value="5" />
	</c:if>
	<c:if test="${endPage > dto.totalPage}">
		<c:set var="startPage" value="${dto.totalPage - 4}" />
		<c:set var="endPage" value="${dto.totalPage}" />
	</c:if>


	<c:choose>
		<c:when test="${startPage < 1}">
			<c:set var="startPage" value="1" />
		</c:when>
		<c:when test="${endPage > dto.totalPage}">
			<c:set var="startPage" value="${dto.totalPage - 4}" />
		</c:when>
	</c:choose>

	<c:if test="${startPage < 1}">
		<c:set var="startPage" value="1" />
	</c:if>
	<c:if test="${endPage > dto.totalPage}">
		<c:set var="endPage" value="${dto.totalPage}" />
	</c:if>

	<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
		<c:choose>
			<c:when test="${pageNum eq dto.page}">
				<strong>${pageNum}</strong>
			</c:when>
			<c:otherwise>
				<a href="?page=${pageNum}">${pageNum}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${dto.page < dto.totalPage}">
		<a href="?page=${dto.page + 1}">다음</a>
		<c:if test="${dto.totalPage > 5}">
			<a href="?page=${dto.totalPage}">끝</a>
		</c:if>
	</c:if>
</div>