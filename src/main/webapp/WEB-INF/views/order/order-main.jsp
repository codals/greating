<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link
	href="${pageContext.request.contextPath}/resources/css/order/order-main.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/order/order-main.js"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	<div class="hr"></div>
	<div class="main-content contents hd__inner1100">
		<ul class="page-category">
			<li>Home</li>
			<li>></li>
			<li>마이그리팅</li>
			<li>></li>
			<li class="highlight">주문하기</li>
		</ul>

		<section class="mygreating-info">
			<img src="/greating/resources/images/order/myGreating.jpeg">

		</section>

		<div class="meals-menu-btns">
			<div class="btnBox">
				<div class="btn fixed">
					<div>
						<a href="${pageContext.request.contextPath}/diets/mygreating/preview" class="btn-init gift btn-meal-info">메뉴미리보기</a>
						<a href="${pageContext.request.contextPath}/diets/mygreating/orders/schedule"
							class="btn-init green btn-buy">주문하기 </a>
					</div>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="../templates/footer.jsp"/>
	
</body>
</html>