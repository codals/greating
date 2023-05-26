<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<link href="/greating/resources/css/order/meal-choice.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="/greating/resources/js/order/meal-choice.js"></script>

</head>
<body>

	<jsp:include page="/WEB-INF/views/templates/header.jsp" />

	<!-- 설계하기및 현재 단계 -->
	<div class="main-content contents hd__inner1100">
		<jsp:include page="/WEB-INF/views/order/order-header.jsp" />

		<div id="mchoice">

			<c:forEach var="i" begin="1" end="5">

				<section class="meals-area">
					<div class="meals-area-cont">
						<h3 class="meals-area-cont-title">2023-05-29 월 / 2023-05-30 화</h3>
						<div class="meals-choice">
							<ul class="box">
								<c:forEach var="j" begin="1" end="3">

									<li class="meal-card">
										<div class="meal-card-img">
											<img src="/greating/resources/images/diet/고기듬뿍유산슬덮밥1.jpg">
										</div>
										<div class="meal-card-count">
											<button type="button" class="minus-btn minus-btn-${i}-${j}"
												value="9500">
												<i class="fas fa-minus fa-lg" style="color: #ffffff;"></i>
											</button>
											<div class="meal-count meal-count-${i}-${j}">0</div>
											<button type="button" class="plus-btn plus-btn-${i}-${j}"
												value="9500">
												<i class="fas fa-plus fa-lg" style="color: #ffffff;"></i>
											</button>
										</div>
										<div class="meal-card-title">고기듬뿍 유산슬 덮밥 세트</div>
										<div class="meal-card-price-sec">
											<span class="meal-card-price">9500원</span>
										</div>

										<ul class="meal-icon-list">
											<li><img
												src="https://image.greating.co.kr/II/basic/itemIcon/8DA3072A643F4523AC9A0AD7159FB811.png"
												alt=""
												onerror="this.src='/front_pc/images/icon_menu_cow.png'"></li>
											<li><img
												src="https://image.greating.co.kr/II/basic/itemIcon/E667B3364BEF4BCAA826E9A3ACDA7EA6.png"
												alt=""
												onerror="this.src='/front_pc/images/icon_menu_cow.png'"></li>
											<li><img
												src="https://image.greating.co.kr/II/basic/itemIcon/BF2E318528864F7E867313C0186A36BE.png"
												alt=""
												onerror="this.src='/front_pc/images/icon_menu_cow.png'"></li>
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
						<a href="#" class="btn-init green btn-buy">주문하기 ( <span
							class="total-count">0</span> / 6 )
						</a> <a href="${header.referer}" id="cancelBtn" class="btn-init cancel btn-buy">취소 </a>
					</div>
				</div>

			</div>
		</div>

	</div>

	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />

</body>
</html>
