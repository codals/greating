<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>order-step1</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <link href="${pageContext.request.contextPath}/resources/css/order/order-step1.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/order/order-step1.js"></script>
</head>

<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	<div class="hr"></div>
	
	<!-- floating -->	
	<jsp:include page="/WEB-INF/views/templates/floating-adv.jsp" />

<div class="main-content hd__inner1100">
    <!-- 카테고리 -->
    <ul class="page-category">
        <li>Home</li>
        <li>></li>
        <li>마이그리팅</li>
        <li>></li>
        <li class="highlight">건강식단</li>
    </ul>
    <jsp:include page="/WEB-INF/views/order/order-header.jsp"/>
    <form action="/" method="post" name="order1-form">
        <!-- 식단관리 기간을 선택하세요 -->
        <section class="meals-area1">
            <div class="meals-area_div">
                <h2 class="meals-area_div_title">
                    <span>식단관리 기간을 선택하세요.</span>
                </h2>

                <div class="radio-container">
                    <label class="radio-label">
                        <input class="radio-input radio-input-week" type="radio" name="experience" value="0">
                        <span class="radio-custom">체험팩</span>
                    </label>
                    <label class="radio-label">
                        <input class="radio-input radio-input-week" type="radio" name="experience" value="1">
                        <span class="radio-custom">1주</span>
                    </label> <label class="radio-label">
                    <input class="radio-input radio-input-week" type="radio" name="experience" value="2">
                    <span class="radio-custom">2주</span>
                </label>
                </div>


            </div>
        </section>

        <!-- 일주일에 몇끼 드실건가요? -->
        <section class="meals-area2 weektype">
            <div class="meals-area_div" id="weekend">
                <h2 class="meals-area_div_title">
                    <span>일주일에 몇 끼를 드실건가요?</span>
                    <span class="meals-area__cont__desc">(주6일 기준)</span>
                </h2>
                <div class="radio-container">
                    <label class="radio-label">
                        <input class="radio-input radio-input-meal" type="radio" name="meals" value="6">
                        <span class="radio-custom">6끼<br>(하루 1끼)</span>
                    </label>
                    <label class="radio-label">
                        <input class="radio-input radio-input-meal" type="radio" name="meals" value="9">
                        <span class="radio-custom">9끼<br>(하루 1~2끼)</span>
                    </label>
                </div>
            </div>
        </section>

        <div class="meals-final">
            <span class="meals-final__head">총 선택 끼니 수</span>

            <p class="meals-final__cont">
            <h1 class="meals-area_div_title meal_count_title">
                <span class="meals-final__cont__num" data-total-count="0">0</span>끼
            </h1>
            </p>
        </div>

        <div class="meals-btn">
            <a href="order2" class="btn-init">
                <p class="meals-span">빠른주문</p>
            </a>
            <a href="javascript:void(0)" class="btn-init green_normal">
                <p class="meals-span meals-next-step" id="next_text">다음단계</p>
            </a>
        </div>
    </form>

</div>

<!--  footer	 -->
<jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
