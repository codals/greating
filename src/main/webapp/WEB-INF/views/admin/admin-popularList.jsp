<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/greating/resources/css/templates/reset.css">

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
						<th>수락하기</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${popularDietList}" var="diet">
						<tr>
							<td>${diet.name}</td>
							<td>${diet.author}</td>
							<td>${diet.category}</td>
							<td>${diet.subcategory}</td>
							<td>${diet.voteCount}</td>
							<td>${diet.createdDate}</td>
							<td>
								<p style="display: inline-block; margin-right: 10px;">✅</p>
								<p style="display: inline-block;">❌</p>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>