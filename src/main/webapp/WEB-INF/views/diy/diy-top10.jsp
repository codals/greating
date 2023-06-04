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



<link
	href="${pageContext.request.contextPath}/resources/css/diy/diy-top10.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/diy/diy-top10.js"></script>
</head>
<body>
	<jsp:include page="../templates/header.jsp" />
	<div class="hr"></div>

	<main class="contents hd__inner1100">
		<ul class="page-category">
			<li>DIY 식단</li>
			<li>></li>
			<li class="highlight">DIY 식단 TOP 10</li>
		</ul>
		<div class="main-content hd__inner960">
			<div class="main-content-title">DIY 식단 TOP 10</div>


			<section class="healthy-top">
				<div class="healthy-top-title">건강식단 TOP 10</div>
				<hr>
				<div class="healthy-top-slide fadeInUp">
					<div class="slider healthy-slide">
						<c:forEach items="${healthyPostTop10}" var="post">
                            <div class="slider-card healthy-card" data-id="${post.id}">
								<img
									src="${post.imgUrl}"
									alt=""> <span> ${post.title}</span>
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
						<c:forEach items="${medicalPostTop10}" var="post">
							<div class="slider-card care-card" data-id="${post.id}">
								<img
									src="${post.imgUrl}"
									alt=""> <span> ${post.title}</span>
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
						<c:forEach items="${callengePostTop10}" var="post">
							<div class="slider-card challenge-card" data-id="${post.id}">
								<img
									src="${post.imgUrl}"
									alt=""> <span> ${post.title}</span>
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


	<!--  footer	 -->
	<jsp:include page="../templates/footer.jsp" />

</body>
</html>
