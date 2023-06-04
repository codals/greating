<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Greating</title>
<meta charset="utf-8">

<!-- slide js  -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<!-- slick 사용을 위함.  -->
<script
	src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />

<!-- js -->
<script src="${pageContext.request.contextPath}/resources/js/main/slick.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main/main.js"></script>

<!--  css  -->
<link href="${pageContext.request.contextPath}/resources/css/templates/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/main/main.css" rel="stylesheet">

</head>
<body>

	<!-- header -->
	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	
	<!-- floating -->	
	<jsp:include page="/WEB-INF/views/templates/floating-adv.jsp" />
	
	<main id="contents">
		<div class="main">
			<section class="main_slide_sec">
				<div class="slides_sec">
					<div id="carousel-controls" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item ">
								<img class="d-block w-100"
									src="https://image.greating.co.kr/DP/banner/202305/4ED3BC15DEC740F384136B2996798A9C.jpg"
									alt="First slide">
							</div>
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="https://image.greating.co.kr/DP/banner/202303/FE4708EC52F94647AA3B4C56F9E19461.jpg"
									alt="Second slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100"
									src="https://image.greating.co.kr/DP/banner/202303/D6C75A548C644A988F129B1F34A66975.jpg"
									alt="Third slide">
							</div>
						</div>
						<a class="carousel-control-prev" href="#carousel-controls"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carousel-controls"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</section>

			<!--  Healthy 파트  -->
			<section class="main_healthy_sec">
				<div class="main-healthy-img">
					<img src="${pageContext.request.contextPath}/resources/images/main/img_main_healthy.png">

				</div>

				<div class="main-healthy">
					<ul class="row row-cols-2 row-cols-sm-2 row-cols-md-2" id="main-healthy-fadeList">

						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/5CFC57707AC0423A9B597056DEF317F7.jpg"
							alt=""></li>
						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/5898DED685D743A89856A19C5BE6AA81.jpg"
							alt=""></li>
						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/EC7CC52BF3EE4F0EA03E69A687D9FC19.jpg"
							alt=""></li>
						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/62054975CF664D119EE56C44AADD2854.jpg"
							alt=""></li>
						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/99BBFE58E8E6486FAC28E1FB58387C5D.jpg"
							alt=""></li>
					</ul>
				</div>

				<div class="main-healthy-list fadeInUp">
					<h3 class="main-healthy-h3 hPara fadeInUp">
						<img src="${pageContext.request.contextPath}/resources/images/main/txt_main_healthy.png"
							alt="믿고 먹는 밥상주치의 그리팅">
					</h3>
					<div class="main-healthy-select fadeInUp">
						<div class="box">
							<button value="healthy" onclick="">건강식단</button>
						</div>
						<div class="box">
							<button value="healthy" onclick="">고단백식단</button>
						</div>
						이번주 메뉴를 소개합니다.
					</div>

					<div class="main-meals fadeInUp">
						<div class="slider meals-slide">
							<div class="slider-card meals-card">
								<img
									src="https://image.greating.co.kr/IL/item/202305/04/M_F0B45E9D4C2D4E6A9A1B8F6278BE453D.jpg"
									alt="">
							</div>
							<div class="slider-card meals-card">
								<img
									src="https://image.greating.co.kr/IL/item/202206/22/M_73739E08C1E94719B3566C12F5D4273D.jpg"
									alt="">
							</div>
							<div class="slider-card meals-card">
								<img
									src="https://image.greating.co.kr/IL/item/202105/12/M_0F0F4859EBC54DEBB8A291659222E515.jpg"
									alt="">
							</div>
							<div class="slider-card meals-card">
								<img
									src="https://image.greating.co.kr/IL/item/202207/13/M_F2C7FC15CABB4129ABCE381AF609344E.jpg"
									alt="">
							</div>
							<div class="slider-card meals-card">
								<img
									src="https://image.greating.co.kr/IL/item/202303/15/M_32FEBD2BEBE14130814FA4D4A84D6802.jpg"
									alt="">
							</div>
							<div class="slider-card meals-card">
								<img
									src="https://image.greating.co.kr/IL/item/202205/17/M_2ADB12DAFAA34B7CAC23D47482EC7B59.jpg"
									alt="">
							</div>
						</div>


					</div>

				</div>

			</section>

			<section class="main_care_sec">
				<div class="main-care-img">
					<img src="${pageContext.request.contextPath}/resources/images/main/img_main_care.png" alt="#">
				</div>
				<div class="main-care">
					<ul
						class="row row-cols-2 row-cols-sm-2 row-cols-md-2 care-card"  id="main-care-fadeList">
						
						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/48D048BCB3D94070897135512ED477E6.jpg"
							alt=""></li>
						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/7201D78CD9364B148182D1A64CBFA7E5.jpg"
							alt=""></li>
					</ul>
				</div>
				<div class="care-list">

					<h3 class="care-h3 hPara fadeInUp">
						<img src="${pageContext.request.contextPath}/resources/images/main/txt_main_care.png"
							alt="질환맞춤식단 체험팩!">
					</h3>
					<p class="care-list-desc hPara fadeInUp">한 세트에 두 팩씩! 지금 체험해보세요</p>
					<ul class="hPara fadeInUp">
						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/852CD0177C1B421F9CBF60094A498183.jpg"
							alt=""></li>
						<li><img
							src="https://image.greating.co.kr/DP/banner/202303/8A58963557914DF19B62419E26316BC3.jpg"
							alt=""></li>
					</ul>



				</div>
			</section>

			<section class="main_challenge_sec">
				<div class="main-challenge-img">
					<img src="${pageContext.request.contextPath}/resources/images/main/img_main_challenge.png"
						usemap="#main_challenge" alt="#">
				</div>

			</section>

			<section class="event hd__inner1100">

				<h3 class="main__h3 hPara fadeInUp">
					<strong>이벤트 </strong> <i class="main__h3-more"> 자세히 보기 </i>
				</h3>

				<div class="event-slider hPara fadeInUp">
					<div class="slider-card event-card">
						<img
							src="https://image.greating.co.kr/DP/banner/202305/D87C73526E3D47319715A30B6F917974.jpg"
							alt="">
					</div>
					<div class="event-card">
						<img
							src="https://image.greating.co.kr/DP/banner/202305/5406795AAA9E4A72A056DB6433B09136.jpg"
							alt="">
					</div>
					<div class="event-card">
						<img
							src="https://image.greating.co.kr/DP/banner/202303/20AACFF7C3BD4E4594BC55C87BF2331A.jpg"
							alt="">
					</div>
					<div class="event-card">
						<img
							src="https://image.greating.co.kr/DP/banner/202305/D3D88121886E439AB3D55A711053FD9E.jpg"
							alt="">
					</div>
					<div class="event-card">
						<img
							src="https://image.greating.co.kr/DP/banner/202303/07968FA12376427BB329153FB6A22736.jpg"
							alt="">
					</div>
					<div class="event-card">
						<img
							src="https://image.greating.co.kr/DP/banner/202303/63E029119A224201A6270790FF8B07E9.jpg"
							alt="">
					</div>

				</div>
			</section>
		</div>
	</main>

	<!--  footer	 -->
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />

</body>
</html>
