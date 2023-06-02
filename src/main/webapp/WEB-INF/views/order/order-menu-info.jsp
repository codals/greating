<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link href="${pageContext.request.contextPath}/resources/css/order/order-menu-info.css"
          rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/order/order-menu-info.js"></script>
</head>
<body>
<!-- header 가져오기 -->
<jsp:include page="../templates/header.jsp"/>
<div class="hr"></div>
<main class="contents hd__inner1100">
    <ul class="page-category">
        <li>Home</li>
        <li>></li>
        <li>마이그리팅</li>
        <li>></li>
        <li class="highlight">메뉴 미리보기</li>
    </ul>

    <section class="mealsChoice_sec">
        <h2 class="meals_title">[ 메뉴 미리보기 ]</h2>
        <div class="hr"></div>
        <div id="mchoice">
            <c:forEach var="dailyDiet" items="${weeklyDailyDiets}">
                <section class="meals-area">
                    <div class="meals-area-cont">
                        <h3 class="meals-area-cont-title">${dailyDiet.startDate} / ${dailyDiet.endDate}</h3>
                        <div class="meals-choice">
                            <ul class="box">
                                <c:forEach var="diet" items="${dailyDiet.diets}">
                                    <li class="meal-card">
                                        <div class="meal-card-img">
                                            <img src="${diet.thumbnailImgUrl}" alt="thumbnailImgUrl">
                                        </div>
                                        <div class="meal-card-title">${diet.name}</div>
                                        <div class="meal-card-price-sec">
                                            <span class="meal-card-price">${diet.price}</span>
                                        </div>

                                        <ul class="meal-icon-list">
                                            <li><img
                                                    src="https://image.greating.co.kr/II/basic/itemIcon/8DA3072A643F4523AC9A0AD7159FB811.png"
                                                    alt=""></li>
                                            <li><img
                                                    src="https://image.greating.co.kr/II/basic/itemIcon/E667B3364BEF4BCAA826E9A3ACDA7EA6.png"
                                                    alt=""></li>
                                            <li><img
                                                    src="https://image.greating.co.kr/II/basic/itemIcon/BF2E318528864F7E867313C0186A36BE.png"
                                                    alt=""></li>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </section>
            </c:forEach>
        </div>
    </section>
    <div class="meals-menu-btns">
        <div class="btnBox">

            <div class="btn">
                <div>
                    <a href="${pageContext.request.contextPath}/diets/mygreating/orders/schedule" class="btn-init green btn-buy">주문하기</a>
                    <a href="#" id="giftBtn" class="btn-init gift btn-buy">선물하기</a>
                </div>
            </div>

        </div>
    </div>

</main>
<jsp:include page="../templates/footer.jsp"/>


</body>
</html>
