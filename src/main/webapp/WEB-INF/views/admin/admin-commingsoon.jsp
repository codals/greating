<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="/greating/resources/css/templates/reset.css">

<link rel="stylesheet" href="/greating/resources/css/admin/admin-popularList.css">
<!-- jQuery 라이브러리 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- admin-popular.js 파일 추가 -->
<script src="/greating/resources/js/admin/admin-popular.js"></script>


<link rel="stylesheet"
	href="/greating/resources/css/admin/admin-popularList.css">
</head>
<body>
	<!--사이드바-->

	<jsp:include page="/WEB-INF/views/admin/admin-sidebar.jsp" />


	<div class="content">
		<div class="content-div">
			<h2 class="content-title">인기 식단 목록</h2>
			<table>
				<thead>
					<tr>
						<th>식단 이름</th>
						<th>작성자</th>
						<th>대분류</th>
						<th>소분류</th>
						<th>투표수</th>
						<th>작성일</th>
						<th>승인여부</th>
					</tr>
				</thead>
				<tbody>

					 <c:forEach items="${list}" var="diet">
	                    <tr>
	                    	
	                        <td><a href="/greating/mealdiy/${diet.id}">${diet.title}</a></td>
	                        <td>${diet.username}</td>
	                        <td>${diet.mainCategoryName}</td>
	                        <td>${diet.subCategoryName}</td>
	                        <td>${diet.voteCnt}</td>
	                        <td>${diet.createdAt}</td>
	                        <td>
	                            <button class="approve-${diet.id}" onclick="approve(${diet.id}, this)" style="display: inline-block; margin-right: 10px;">✅</button>
	                        </td>
	                    </tr>
	                </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>