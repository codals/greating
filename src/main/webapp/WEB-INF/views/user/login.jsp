<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='utf-8'>
    <title>login</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
            integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
            integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
    <link href="${pageContext.request.contextPath}/resources/css/user/register.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/user/login.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/templates/header.jsp"/>
<div class="hr"></div>
<div class="main-content hd__inner1100">
   <ul class="page-category">
			<li>Home</li>
			<li>></li>
			<li class="highlight">로그인</li>
	</ul>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <h1 class="text-center title">로그인</h1>
                <p class="text-center small login-message">로그인을 하시면 다양한 혜택을 누리실 수 있습니다.</p>
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link" href="#">H.Point 회원</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">greeting 회원</a>
                    </li>
                </ul>
                <div class="form-group">
                    <input type="text" class="form-username" id="username" name="username" placeholder="아이디">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호">
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label class="form-check-label" for="rememberMe">아이디 저장</label>
                </div>
                <button class="btn btn-primary btn-block login-button">로그인</button>
                <div class="col justify-content-center login-links">
                    <span><a href="#">아이디 찾기</a></span>
                    <div class="divider"></div>
                    <span><a href="#">비밀번호 찾기</a></span>
                    <div class="divider"></div>
                    <span><a href="${pageContext.request.contextPath}/register">회원가입</a></span>
                </div>
                <hr>
                <div class="row justify-content-center social-login-img">
                    <img src="${pageContext.request.contextPath}/resources/images/user/social-login.png" alt="social-login.png" width="300px">
                </div>
                <button type="button" class="btn btn-primary btn-non-member">비회원 주문조회</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
