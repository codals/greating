
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link
	href="${pageContext.request.contextPath}/resources/css/user/mypage-mydiy.css"
	rel="stylesheet">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
</head>
<body>

	<jsp:include page="/WEB-INF/views/templates/header.jsp" />
	<div class="hr"></div>

	<main class="contents hd__inner1100">
		<ul class="page-category">
			<li>Home</li>
			<li>></li>
			<li class="highlight">마이페이지</li>
		</ul>

		<div class="mypage-main d-flex">
 			<jsp:include page="./mypage-sidebar.jsp" />
			<div class="sub-cont">
	 				<jsp:include page="./mypage-welcome.jsp" />
 
				<div class="myDiy-cont">
					<div class="select-box">
						<i class="far fa-check-circle fa-lg" style="color: #afb0b1;">
						</i> 전체선택
					</div>
				</div>

				<ul>
					<c:forEach var="i" begin="1" end="3">

						<li class="myDiy-card">
							<div class="myDiy-card-img">
								<img
									src="${pageContext.request.contextPath}/resources/images/user/mypage-main.jpg">
							</div>
							<div class="myDiy-card-info">
								<span class="mb-2">[ 현대 그린푸드 ] 국산 대패 삼겹살 </span>
								<div class="hr"></div>
								<div class="myDiy-card-tags">
									<span style="font-size: 17px;"> 메인 구성 </span> <span
										class="myDiy-card-tag"> 귀리밥 </span> <span
										class="myDiy-card-tag"> 귀리밥 </span> <span
										class="myDiy-card-tag"> 귀리밥 </span>

								</div>
								<div class="myDiy-vote">
									<span style="font-size: 17px;"> 투표 현황 </span>
									<div class="myDiy-vote-num">
										<img
											src="${pageContext.request.contextPath}/resources/images/user/vote.png">
										<span> 400 Greating </span>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>

				</ul> 
			</div>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/templates/footer.jsp" />


</body>
</html>
