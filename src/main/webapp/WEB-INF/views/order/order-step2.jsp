<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>order-step2</title>
	<link href="/greating/resources/css/order/order-step2.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
</head>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/templates/header.jsp"/>
<div class="hr"></div>

<div class="main-content hd__inner1100">
    <!-- 카테고리 -->
    <ul class="page-category">
        <li>Home</li>
        <li>></li>
        <li>마이그리팅</li>
        <li>></li>
        <li class="highlight">건강식단</li>
    </ul>

    <form action="/" method="post" name="order1-form">

        <!-- 설계하기및 현재 단계 -->
        <h2 class="meals__title">
            <span>설계하기</span>
        </h2>
        <img src="/greating/resources/images/order/order2step.png"/>
        <ol class="meals-order">

            <li style="color: rgb(174, 170, 170);">기간/끼니수 선택</li>
            <li class="on">배송일 선택</li>
            <li style="color: rgb(174, 170, 170);">메뉴 선택</li>
        </ol>

        <!-- 배송희망일 선택 -->
        <div class="section-cover">
            <section class="meals-area1">
                <div class="meals-area_div">
                    <h2 class="meals-area_div_title">
                        <span><strong>배송 희망일</strong>선택</span>
                    </h2>

                    <!-- <div class="radio-container">
                        <label class="radio-label"> <input class="radio-input"
                            type="radio" name="experience" value="체험팩"> <span
                            class="radio-custom">월수금</span>
                        </label> <label class="radio-label"> <input class="radio-input"
                            type="radio" name="experience" value="1주"> <span
                            class="radio-custom">화목토</span>
                        </label> <label class="radio-label"> <input class="radio-input"
                            type="radio" name="experience" value="2주"> <span
                            class="radio-custom">직접선택 (초기화)</span>
                        </label>
                    </div> -->
                </div>
            </section>
            <!-- 달력 -->
            <div class="calendar"></div>
        </div>


        <div class="meals-final">
				<span class="meals-final__head">최대 <strong><span
                        class="tmpChkDayCnt">3</span>회</strong> 지정 가능하며, <span
                        class="tmpFreeDayCnt"><strong>2회</strong>까지</span> 무료배송 됩니다.<br>
					<br>선택한 횟수는
				</span>
            <div class="count-cover">
                <p class="meals-final__cont">
                    <em><span class="meals-final__cont__num" data-total-count="3">3</span>회</em>
                </p>

                <!-- 200225 식단 배송비 부과 로직 관련 추가 -->
                <p class="meals-final__delivery">
                    <!-- <span class="meals-final__delivery__tit">배송비</span> -->
                    <span class="meals-final__delivery__price"> <span> X
								3,000원 = </span> <del>9,000원</del> <strong
                            class="meals-final__delivery__result">3,000원</strong>
						</span> <span class="Qmark"></span>
                </p>
            </div>
        </div>
        <div class="meals-btn">
            <a href="${header.referer}" class="btn-init-white prev"><span>이전단계</span></a><a
                href="#" class="btn-init-green next" id="btn_next"><span
                id="next_text">다음단계</span></a>
        </div>

    </form>

</div>
<script src="${pageContext.request.contextPath}/resources/js/order/order-step2.js"></script>
<!--  footer	 -->
<jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
