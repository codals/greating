<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Greating Top 100</title>

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



<link href="/greating/resources/css/diy/diy-top10.css" rel="stylesheet">
<script src="/greating/resources/js/diy/diy-top10.js"></script>
</head>
<body>
	<jsp:include page="../templates/header.jsp" />
	<div class="hr"></div>

	<main class="contents hd__inner1100">
		<div class="main-content hd__inner960">
			<div class="main-content-title">DIY 식단 TOP 10</div>


			<section class="healthy-top">
				<div class="healthy-top-title">건강식단 TOP 10</div>
				<hr>
				<div class="healthy-top-slide fadeInUp">
					<div class="slider healthy-slide">
						<c:forEach var="i" begin="1" end="5">
							<div class="slider-card healthy-card">
								<img
									src="https://image.greating.co.kr/IL/item/202305/04/M_F0B45E9D4C2D4E6A9A1B8F6278BE453D.jpg"
									alt=""> <span> 건강도시락${i}</span>
							</div>
							<div class="slider-card healthy-card">
								<img
									src="https://image.greating.co.kr/IL/item/202206/22/M_73739E08C1E94719B3566C12F5D4273D.jpg"
									alt=""> <span> 건강도시락${i}</span>


							</div>
							<div class="slider-card healthy-card">
								<img
									src="https://image.greating.co.kr/IL/item/202105/12/M_0F0F4859EBC54DEBB8A291659222E515.jpg"
									alt=""> <span> 건강도시락${i}</span>

							</div>
						</c:forEach>
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

			<section class="care-top">
				<div class="care-top-title">질환맞춤 TOP 10</div>
				<hr>
				<div class="care-top-slide fadeInUp">
					<div class="slider care-slide">
						<c:forEach var="i" begin="1" end="5">
							<div class="slider-card care-card">
								<img
									src="https://image.greating.co.kr/IL/item/202305/04/M_F0B45E9D4C2D4E6A9A1B8F6278BE453D.jpg"
									alt=""> <span> 질환맞춤도시락${i}</span>
							</div>
							<div class="slider-card care-card">
								<img
									src="https://image.greating.co.kr/IL/item/202206/22/M_73739E08C1E94719B3566C12F5D4273D.jpg"
									alt=""> <span> 질환맞춤도시락${i}</span>


							</div>
							<div class="slider-card care-card">
								<img
									src="https://image.greating.co.kr/IL/item/202105/12/M_0F0F4859EBC54DEBB8A291659222E515.jpg"
									alt=""> <span> 질환맞춤도시락${i}</span>

							</div>
						</c:forEach>
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

			<section class="challenge-top">
				<div class="challenge-top-title">챌린지 TOP 10</div>
				<hr>
				<div class="challenge-top-slide fadeInUp">
					<div class="slider challenge-slide">
						<c:forEach var="i" begin="1" end="5">
							<div class="slider-card challenge-card">
								<img
									src="https://image.greating.co.kr/IL/item/202305/04/M_F0B45E9D4C2D4E6A9A1B8F6278BE453D.jpg"
									alt=""> <span> 챌린지도시락${i}</span>
							</div>
							<div class="slider-card challenge-card">
								<img
									src="https://image.greating.co.kr/IL/item/202206/22/M_73739E08C1E94719B3566C12F5D4273D.jpg"
									alt=""> <span> 챌린지도시락${i}</span>


							</div>
							<div class="slider-card challenge-card">
								<img
									src="https://image.greating.co.kr/IL/item/202105/12/M_0F0F4859EBC54DEBB8A291659222E515.jpg"
									alt=""> <span> 챌린지도시락${i}</span>

							</div>
						</c:forEach>
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
		</div>

	</main>
</body>
</html>