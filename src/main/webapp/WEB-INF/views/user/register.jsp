<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" />

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link
	href="${pageContext.request.contextPath}/resources/css/user/register.css"
	rel="stylesheet">

<title>Sign Up</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	<div class="hr"></div>

	<div class="main-content hd__inner1100">
		<ul class="page-category">
			<li>Home</li>
			<li>></li>
			<li class="highlight">회원가입</li>
		</ul>


		<div class="memberJoin">
			<div class="memberJoin__hp">
				<div class="memberJoin__hp-tit">
					<span class="hidden">h.point X greating</span>
				</div>
				<p class="memberJoin__hp-txt">현대백화점그룹과 그리팅의 다양한 멤버십 혜택을 드립니다.</p>

				<div class="memberJoin__hp-box">
					<ul>
						<li>
							<div class="box__info">
								<p class="box__sub">[H.Point 통합회원 한정]</p>
								<strong class="box__tit">구매금액 0.1% 적립</strong> <span
									class="box__txt"> *100Point 이상부터 사용가능 <br>*1Point는
									1원과 동일
								</span>
							</div>
						</li>
						<li>
							<div class="box__info">
								<p class="box__sub">[H.Point 통합회원 한정]</p>
								<strong class="box__tit">구매금액 0.1% 적립</strong> <span
									class="box__txt"> *100Point 이상부터 사용가능 <br>*1Point는
									1원과 동일
								</span>
							</div>
						</li>
						<li>
							<div class="box__info">
								<p class="box__sub">[H.Point 통합회원 한정]</p>
								<strong class="box__tit">구매금액 0.1% 적립</strong> <span
									class="box__txt"> *100Point 이상부터 사용가능 <br>*1Point는
									1원과 동일
								</span>
							</div>
						</li>
						<li>
							<div class="box__info">
								<p class="box__sub">[H.Point 통합회원 한정]</p>
								<strong class="box__tit">구매금액 0.1% 적립</strong> <span
									class="box__txt"> *100Point 이상부터 사용가능 <br>*1Point는
									1원과 동일
								</span>
							</div>
						</li>
					</ul>

				</div>

			</div>
			<section class="memberJoin_sec">


				<div class="green-box">
					<h3 class="green-box__title">
						<span>통합회원 가입</span>
					</h3>
					<img
						src="${pageContext.request.contextPath}/resources/images/user/h_point.png"
						alt="hpoint">
					<p class="green-box__desc">
						본인인증 절차없이 사용중인 이메일 또는<br> SNS계정 정보로 간편하게 가입하실 수 있습니다.
					</p>
					<div class="btn">
						<a href="#" class="btn-init green" id="hpointJoin">H.Point
							통합회원 가입하기</a>
					</div>

				</div>
				<div class="green-box">
					<h3 class="green-box__title">
						<span>그리팅 일반회원 가입</span>
					</h3>
					<img
						src="${pageContext.request.contextPath}/resources/images/user${pageContext.request.contextPath}.png"
						alt="hpoint">
					<p class="green-box__desc">
						본인인증 절차없이 사용중인 이메일 또는<br> SNS계정 정보로 간편하게 가입하실 수 있습니다.
					</p>
					<div class="btn">
						<a href="${pageContext.request.contextPath}/register-agreement"
							class="btn-init green" id="hpointJoin"> 일반회원 가입하기</a>
					</div>

				</div>
			</section>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />
</body>
</html>
