<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<link href="${pageContext.request.contextPath}/resources/css/order/meal-choice.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/order/meal-choice.js"></script>

</head>
<body>

	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	<div class="hr"></div>

	<!-- 설계하기및 현재 단계 -->
	<div class="main-content contents hd__inner1100">
		<ul class="page-category">
			<li>Home</li>
			<li>></li>
			<li>마이그리팅 </li>
			<li>></li>
			<li class="highlight">주문하기</li>
		</ul>
		<jsp:include page="/WEB-INF/views/order/order-header.jsp" />

		<div id="mchoice">

			<c:forEach var="dailyDiet" items="${dailyDiets}" varStatus="status">

				<section class="meals-area">
					<div class="meals-area-cont">
						<h3 class="meals-area-cont-title">${dailyDiet.deliveryDate}</h3>
						<div class="meals-choice">
							<ul class="box">
								<c:forEach var="diet" items="${dailyDiet.diets}" varStatus="status2">
									<li class="meal-card">
										<input value="${diet.dietId}" class="meal-diet meal-diet-${status.index + 1}-${status2.index + 1}" type="hidden">
										<input value="${dailyDiet.deliveryDate}" class="meal-diet-date meal-diet-date-${status.index + 1}-${status2.index + 1}" type="hidden">
										<div class="meal-card-img">
											<img src="${diet.thumbnailImgUrl}" alt="thumbnailImgUrl">
										</div>
										<div class="meal-card-count">
											<button type="button" class="minus-btn minus-btn-${status.index + 1}-${status2.index + 1}"
												value="9500">
												<i class="fas fa-minus fa-lg" style="color: #ffffff;"></i>
											</button>
											<div class="meal-count meal-count-${status.index + 1}-${status2.index + 1}">0</div>
											<button type="button" class="plus-btn plus-btn-${status.index + 1}-${status2.index + 1}"
												value="9500">
												<i class="fas fa-plus fa-lg" style="color: #ffffff;"></i>
											</button>
										</div>
										<div class="meal-card-title">${diet.name}</div>
										<div class="meal-card-price-sec">
											<span class="meal-card-price">${diet.price}</span>
										</div>

										<ul class="meal-icon-list">
											<li><img
												src="https://image.greating.co.kr/II/basic/itemIcon/8DA3072A643F4523AC9A0AD7159FB811.png"
												alt=""></li>
											<li><img
												src="https://image.greating.co.kr/II/basic/itemIcon/E667B3364BEF4BCAA826E9A3ACDA7EA6.png"
												alt=""></li>
											<li><img
												src="https://image.greating.co.kr/II/basic/itemIcon/BF2E318528864F7E867313C0186A36BE.png"
												alt=""></li>
										</ul>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</section>
			</c:forEach>
		</div>
		<div class="meals-choice-btns">
			<div class="btnBox">

				<div class="btn">
					<div>
						<a href="#" class="btn-init green btn-buy">주문하기 ( <span class="total-count">0</span> / 6 )
						</a> <a href="${header.referer}" id="cancelBtn" class="btn-init cancel btn-buy">취소 </a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />
</body>
</html>
