
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<link href="/greating/resources/css/user/mypage-myscrap.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
</head>
<body>

	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	<div class="hr"></div>

	<main class="contents hd__inner1100">

		<span class="page-category"> Home > 마이페이지 </span>

		<div class="mypage-main">
			<jsp:include page="./mypage-sidebar.jsp" />

			<div class="sub-cont">
				<jsp:include page="./mypage-welcome.jsp" />

				<div class="myScrap-cont">
					<div class="select-box">
						<i class="far fa-check-circle fa-lg" style="color: #afb0b1;">
						</i> 전체선택
					</div>
				</div>

				<ul>
					<c:forEach items="${list}" var="list">
						<li class="myScrap-card">
							<div class="myScrap-card-img">
								<i class="fas fa-solid fa-thumbs-up fa-lg" style="color: #918c01;"></i>
								<img src="/greating/resources/images/user/mypage-scrap.jpg">
							</div>
							<div class="myScrap-card-info">
								<h3>${list.postTitle }</h3>
								<div class="author-info">
									<p>영양사</p>
									<p>${list.userName }</p>
								</div>
								<div class="calorie-info">
									<p>희망칼로리</p>
									<p>${list.minCalorie}~${list.maxCalorie}Kcal</p>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>



				</ul>
			</div>
		</div>
	</main>


</body>
</html>