<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link href="/greating/resources/css/order/order-step1.css"
	rel="stylesheet">
<style type="text/css">
</style>
<meta charset="UTF-8">
<title>order-step1</title>
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/templates/header.jsp" />

	<div class="main-content hd__inner1100">
		<!-- 카테고리 -->
		<div>
			<ul class="menu-category">
				<li>HOME</li> >
				<li>건강식단</li> >
				<!-- 메뉴명에 따른 3depth 텍스트 수정 -->
				<li>고단백식단</li>
			</ul>
		</div>

		<form action="/" method="post" name="order1-form">

			<!-- 설계하기및 현재 단계 -->
			<h2 class="meals__title">
				<span>설계하기</span>
			</h2>
			<img src="/greating/resources/images/order/order1step.png" />
			<ol class="meals-order">

				<li class="on">기간/끼니수 선택</li>
				<li style="color: rgb(174, 170, 170);">배송일 선택</li>
				<li style="color: rgb(174, 170, 170);">메뉴 선택</li>
			</ol>





			<!-- 식단관리 기간을 선택하세요 -->
			<section class="meals-area1">
				<div class="meals-area_div">
					<h2 class="meals-area_div_title">
						<span>식단관리 기간을 선택하세요.</span>
					</h2>

					<div class="radio-container">
						<label class="radio-label"> <input class="radio-input"
							type="radio" name="experience" value="체험팩"> <span
							class="radio-custom">체험팩</span>
						</label> <label class="radio-label"> <input class="radio-input"
							type="radio" name="experience" value="1주"> <span
							class="radio-custom">1주</span>
						</label> <label class="radio-label"> <input class="radio-input"
							type="radio" name="experience" value="2주"> <span
							class="radio-custom">2주</span>
						</label>
					</div>




				</div>
			</section>

			<!-- 일주일에 몇끼 드실건가요? -->
			<section class="meals-area2 weektype">
				<div class="meals-area_div" id="weekend">
					<h2 class="meals-area_div_title">
						<span>일주일에 몇 끼를 드실건가요?</span> <span class="meals-area__cont__desc">(주
							6일 기준)</span>
					</h2>

					<div class="radio-container">
						<label class="radio-label"> <input class="radio-input"
							type="radio" name="meals" value="6끼"> <span
							class="radio-custom">6끼<br>(하루 1끼)
						</span>

						</label> <label class="radio-label"> <input class="radio-input"
							type="radio" name="meals" value="9끼"> <span
							class="radio-custom">9끼<br>(하루 1~2끼)
						</span>
						</label>
					</div>



				</div>
			</section>

			<div class="meals-final">
				<h3>
					<span class="meals-final__head">총 선택 끼니 수</span>
				</h3>

				<p class="meals-final__cont">
				<h1 class="h1 meals-area_div_title">
					<span class="meals-final__cont__num" data-total-count="0">0</span>끼
				</h1>
				</p>
			</div>

			<div class="meals-btn">
				<a href="#" class="btn-init">
					<p class="meals-span">빠른주문</p>
				</a> <a href="#" class="btn-init white normal"><p class="meals-span"
						id="next_text">선택을 완료해주세요</p></a>
			</div>
		</form>

	</div>

	<!--  footer	 -->
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />
</body>
</html>