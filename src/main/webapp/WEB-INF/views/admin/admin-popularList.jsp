<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/greating/resources/css/admin/admin-popularList.css">

</head>
<body>
	<!--사이드바-->
	<div class="sidebar">
		<div class="sidebar-div">
			<div class="profile">
				<img
					src="/greating/resources/images/user/eddy.png"
					alt="프로필 사진">
				<h3 class="sidebar-text">관리자 : Eddy Bang</h3>
			</div>
			<ul class="menu">
				<li><a href="#" class="sidebar-text">인기 식단 목록</a></li>
				<li><a href="#" class="sidebar-text">출시 예정 식단 목록</a></li>
			</ul>
		</div>
	</div>


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