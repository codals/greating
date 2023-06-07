<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset='utf-8'>
<title>register</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link
	href="${pageContext.request.contextPath}/resources/css/user/register-agreement.css"
	rel="stylesheet">

<script src="/greating/resources/js/user/register.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<link href="/greating/resources/css/templates/alert.css"
	rel="stylesheet">

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
		<div class="form-main">
			<div class="row justify-content-center">
				<div class="col">
					<h1 class="text-center title">약관동의</h1>
					<div class="join-header-section">
						<ol class="join-header">
							<li class="on">약관동의</li>
							<li>정보입력</li>
							<li>가입완료</li>
						</ol>
					</div>
					<p class="text small register-comment">
						- 필수 약관에 동의하셔야 그리팅몰 회원가입이 가능합니다.<br> - 선택 약관에 동의하지 않으셔도 회원가입이
						가능합니다.
					</p>
					<hr>
					<label
						class="checkbox-container d-flex align-items-center justify-content-between all-agreement-check">
						<input type="checkbox" class="all-check"> <span
						class="checkmark"></span> <span class="text">전체 약관 동의</span>
					</label>
					<hr>
					<label
						class="checkbox-container d-flex align-items-center justify-content-between">
						<input type="checkbox" class="must-check agreement-check"> <span
						class="checkmark"></span> <span class="text">회원 서비스 이용약관
							(필수)</span> <img
						src="${pageContext.request.contextPath}/resources/images/user/register-plus.png"
						class="flex-right" alt="register-plus.png">
					</label>
					<hr>
					<label
						class="checkbox-container d-flex align-items-center justify-content-between">
						<input type="checkbox" class="must-check agreement-check"> <span
						class="checkmark"></span> <span class="text">개인정보 수집 및 이용동의
							(필수)</span> <img
						src="${pageContext.request.contextPath}/resources/images/user/register-plus.png"
						class="flex-right" alt="register-plus.png">
					</label>
					<hr>
					<label
						class="checkbox-container d-flex align-items-center justify-content-between">
						<input type="checkbox" class="agreement-check"> <span class="checkmark"></span> <span
						class="text">마케팅 수신 동의 (선택)</span> <span class="point"
						id="marketing_spoon">+1,000스푼 적립!</span> <img
						src="${pageContext.request.contextPath}/resources/images/user/register-plus.png"
						class="flex-right" alt="register-plus.png">
					</label>
					<hr>
					<label
						class="checkbox-container d-flex align-items-center justify-content-between">
						<input type="checkbox" class="agreement-check"> <span class="checkmark"></span> <span
						class="text">평생회원 신청 동의 (선택)</span> <span class="point"
						id="marketing_spoon">+1,000스푼 적립!</span> <img
						src="${pageContext.request.contextPath}/resources/images/user/register-plus.png"
						class="flex-right" alt="register-plus.png">
					</label>
					<hr>
					<p class="text small register-comment">
						- 마케팅 수신 동의 시, 그리팅에서 제공하는 다양한 쿠폰 및 할인 이벤트 등을 받아보실 수 있습니다.<br>
						- 결제/배송/교환/환불 등의 주문거래 관련 정보는 수신여부 동의 상관 없이 발송됩니다.<br> - 평생회원을
						신청하시면, 1년 이상 그리팅몰을 방문하지 않아도 탈퇴 전까지 개인정보가 안전하게 보관됩니다.<br>
					</p>
					<hr>
					<p class="text-center small register-comment">
						만 14세 미만 아동은 회원가입이 제한됩니다.<br> 본인은 만 14세 이상으로 개인정보 및 약관 동의 내용을
						확인하였으며, 위 내용에 동의 합니다.<br>
					</p>
					<div class="button-container">
						<button class="left-button"
							onclick="location.href='${pageContext.request.contextPath}/register'">취소</button>
						<button class="right-button">다음</button>
					</div>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />
</body>
</html>
