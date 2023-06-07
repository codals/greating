
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/greating/resources/css/user/mypage-pagination.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link
	href="${pageContext.request.contextPath}/resources/css/user/mypage-main.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"
	integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
	crossorigin="anonymous"></script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	<div class="hr"></div>

	<main class="contents hd__inner1100">
		<ul class="page-category">
			<li>Home</li>
			<li>></li>
			<li class="highlight">마이페이지</li>
		</ul>

		<div class="mypage-main d-flex">
			<jsp:include page="./mypage-sidebar.jsp" />
			<div class="sub-cont">
				<jsp:include page="./mypage-welcome.jsp" />

				<div class="myDiy-cont">
					<img class="mypage-main" alt="mypage-main" src="${pageContext.request.contextPath}/resources/images/user/mypage-main.png">
					<a class="img-on" href="${pageContext.request.contextPath}/mealdiy/new">나만의 DIY 도시락 만들어보기</a>
				</div>


			</div>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />


</body>
</html>
