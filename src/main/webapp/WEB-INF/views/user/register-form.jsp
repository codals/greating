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
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
	integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
	integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
	crossorigin="anonymous"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/user/register-form.css"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/greating/resources/js/user/register.js"></script>


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
				<div class="row justify-content-center">
					<div class="col">
						<h1 class="text-center title">정보입력</h1>
						<div class="row justify-content-center social-login-img">
							<img
								src="${pageContext.request.contextPath}/resources/images/user/register-step.png"
								alt="social-login.png" style="width: 450px">
						</div>
						<div class="form-main-content"
							style="width: 750px; margin: 0 auto;">
							<span class="text register-sub-title">회원 정보 입력 (필수)</span>


							<form action="${pageContext.request.contextPath}/register"
								method="post">
								<div class="form-group">
									<label for="name">이름</label> <input type="text"
										class="register-input" id="name" name="name" required>
								</div>
								<p class="register-comment">* 한글은 10자, 영문은 20자 이내로 입력해 주세요</p>
								<div class="form-group">
									<label for="username">아이디</label> <input type="text"
										class="register-input" id="username" name="username" required>
									<button type="button" class="btn-init" id="overlapCheck"
										onclick="checkValidateUserName()">중복확인</button>
								</div>
								
									<span id="username-validation"></span>

								<p class="register-comment">* 6자리 이상의 영문 혹은 영문, 숫자를 조합하여 입력해
									주세요</p>
								<div class="form-group">
									<label for="password">비밀번호</label> <input type="password"
										class="register-input" id="password" name="password" required>
								</div>
								<span id="password-validation"></span>

								<p class="register-comment">* 영문, 대소문자, 숫자, 특수문자 중 3개 이상을
									조합하여 8자리 이상 입력해 주세요</p>
								<div class="form-group">
									<label for="confirm-password">비밀번호 확인</label> <input
										type="password" class="register-input" id="confirm-password"
										required>
								</div>
								<span id="password-same-result"></span>

								<div class="form-group">
									<label for="email">이메일</label> <input type="email"
										class="btn-input" id="email" name="email"
										placeholder="예: greating@hyundai.com" required>
									<button type="button" class="btn-init" onclick="checkValidateUserEmail()">중복확인</button>
								</div>
								<span id="email-check-result"></span>
								
								<p class="register-comment" style="color: #918c00">＊ 맞춤상품 추천
									및 Hpoint 서비스 이용을 위해 생년월일과 성별을 정확히 입력해 주세요.</p>
								<div class="form-group">
									<label for="birth">생년월일</label> <input type="birth"
										class="btn-input" id="birth" name="birth"
										placeholder="예: 20010415" required>
								</div>
								<div class="form-group">
									<label>성별</label>
									<div class="gender-group">
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" name="gender"
												id="gender-male" value="male" required> <label
												class="form-check-label" for="gender-male">남성</label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" name="gender"
												id="gender-female" value="female" required> <label
												class="form-check-label" for="gender-female">여성</label>
										</div>
									</div>
								</div>
								<!-- <div class="form-group">
									<label for="phone">휴대폰번호</label> <input type="tel"
										class="btn-input" id="phone" name="phone"
										placeholder="예: 01012345678" required>
									<button type="button" class="btn-init green" id="overlapCheck">인증번호
										전송</button>
								</div> -->
								<span class="text register-sub-title">어떤 식사 관리에 관심이
									있으신가요? (선택)</span>
								<p class="favor-choice">
									아래 보기 중 선택하시면 <span style="font-weight: bold">스푼 포인트
										100개</span>를 드려요!
								</p>
								<div class="box-container">
									<div class="rectangle-active">건강간식</div>
									<div class="rectangle">면역관리</div>
									<div class="rectangle">아침간편식</div>
									<div class="rectangle">저녁반찬</div>
									<div class="rectangle">체중관리</div>
									<div class="rectangle">혈당관리</div>
								</div>
								<hr>
								<span class="text register-sub-title">추천인 입력 (선택)</span>
								<p class="favor-choice">
									추천인 코드를 입력하시고 첫 구매를 확정하시면 고객님과 추천인 모두에게 <span
										style="font-weight: bold">스푼 포인트</span>를 드려요!<br> <span
										style="font-size: 11px; color: #888">(지급되는 스푼 포인트는 이벤트
										내용에 따라 달라질 수 있습니다)</span>
								</p>
								<div class="referral-code">
									<input type="text" class="btn-input" id="referral-code"
										name="referral-code" placeholder="추천인 코드">
									<button type="button" class="btn-init" id="btm-referral-code"
										style="background: #a8a8a8;">조회</button>
								</div>
								<div class="button-container">
									<input type="button" class="left-button"
										onclick="location.href='${header.referer}'" value="취소">
									<input type="submit" class="submitBtn" value="회원가입"
										onclick="submitRegisterForm(event)">
								</div>

								<div class="checkInfo hidden">
									<input type="checkbox" class="userNameValidation"> <input
										type="checkbox" class='userNameCheckResult'> <input
										type="checkbox" class="userEmailCheckResult"> <input
										type="checkbox" class="userPasswordValidation"> <input
										type="checkbox" class="userPasswordSame">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />
</body>
</html>
