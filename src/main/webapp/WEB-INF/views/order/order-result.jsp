<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>order-result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
            integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
            integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
    <link href="/greating/resources/css/templates/reset.css" rel="stylesheet">
    <link href="/greating/resources/css/order/order-result.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/templates/header.jsp"/>
<div class="main-content hd__inner1100">
    <ul class="content-info">
        <li>HOME > 건강식단</li>
        <li>저당식단</li>
    </ul>
    <div class="order">
        <div class="order-result-hp">
            <h2 class="meals__title"><span>설계완료</span></h2>
            <section class="meals-area">
                <div class="meals-area__cont">
                    <div class="mealsConfirm__head">
                        <div class="btn-order-check">
                            <img src="/greating/resources/images/order/order-result-check.png">
                        </div>
                        <em class="mealsConfirm__check">
                            <span>저당식단</span> / <span>1주</span> / <span>6끼니</span>
                        </em>
                        <p class="mealsConfirm__count">배송횟수 <strong>3회</strong></p>
                    </div>
                    <div class="mealsConfirm__row">
                        <table class="mealsConfirm__table">
                            <c:forEach var="i" begin="1" end="3">
                                <tr>
                                    <td class="order-td-1">
                                        <strong>05.27<br>토요일<br>도착예정</strong>
                                        <button class="btn-menu-add">+ 메뉴추가</button>
                                    </td>
                                    <td class="order-td-2">
                                        <span>꿍팟퐁커리&모둠버섯 데리야끼볶음 세트</span><br>
                                        <span>진저포크구이&삼채 우엉조림 세트</span>
                                    </td>
                                    <td class="order-td-3">
                                        <span>1개</span><br>
                                        <span>1개</span>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </section>
            <div class="meals-final">
                <p class="meals-final__cont">
                    <span class="meals-final__cont-txt">Total</span>
                    <em><span class="meals-final__cont__num" id="totalPriceWithAdd" data-total-count="57000">57,000원</span></em>
                </p>
            </div>
            <div class="meals-btn">
                <a href="${header.referer}" class="btn-init white prev" id="btnPrev"><span>이전으로</span></a>
                <a href="${pageContext.request.contextPath}/diets/mygreating/cart" class="btn-init orange" id="btnCart"><span>장바구니 담기</span></a>
                <a href="#" class="btn-init green" id="btnOrder"><span>바로주문</span></a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>