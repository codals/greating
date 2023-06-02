<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/greating/resources/css/templates/reset.css">

<link rel="stylesheet"
	href="/greating/resources/css/admin/admin-register.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/js/admin/admin-register.js"></script>

</head>
<body>
	<!--사이드바-->
	<jsp:include page="/WEB-INF/views/admin/admin-sidebar.jsp" />

	<div class="content">

		<div class="main-top">

			<div class="calendar">
				<div class="sec_cal">
					<div class="cal_nav">
						<a href="javascript:;" class="nav-btn go-prev">prev</a>
						<div class="year-month"></div>
						<a href="javascript:;" class="nav-btn go-next">next</a>
					</div>
					<div class="cal_wrap">
						<div class="days">
							<div class="day">MON</div>
							<div class="day">TUE</div>
							<div class="day">WED</div>
							<div class="day">THU</div>
							<div class="day">FRI</div>
							<div class="day">SAT</div>
							<div class="day">SUN</div>
						</div>
						<div class="dates"></div>
					</div>
				</div>
			</div>

			<div class="registered-diets">
				<span class="title">6월 2일 등록된 식단</span>
				<table>
					<thead>
						<tr>
							<th>식단 번호</th>
							<th>식단명</th>
							<th>식단 메인 카테고리</th>
							<th>식단 서브 카테고리</th>
						</tr>
					</thead>
					<tbody>
						<!-- 여기에 등록된 식단 데이터를 동적으로 추가할 수 있습니다. -->
						<tr>
							<td>1</td>
							<td>식단 1</td>
							<td>메인 카테고리 1</td>
							<td>서브 카테고리 1</td>
						</tr>
						<tr>
							<td>2</td>
							<td>식단 2</td>
							<td>메인 카테고리 2</td>
							<td>서브 카테고리 2</td>
						</tr>
						<!-- 추가적인 식단 데이터를 여기에 추가할 수 있습니다. -->
					</tbody>
				</table>
			</div>

		</div>
		<div class="main-bottom">
			<div class="main-bottom-group">
				<div class="update-diets">
					<div class="update-diets-header">
						<span> 식단 등록 </span>
						<button class="registerDietBtn" onclick="">등록하기</button>

					</div>
					<div class="update-diets-date">
						<label for="date">날짜를 선택하세요: <input type="date" id="date"
							max="2077-06-20" min="2023-06-01">
						</label>
					</div>
					<div class="update-diets-cate">
						<span> 도시락 카테고리 검색 : </span> <input type="radio" id="category1"
							name="category" value="category1"> <label for="category1">
							건강식단 </label> <input type="radio" id="category2" name="category"
							value="category2"> <label for="category2">질환맞춤식단
						</label> <input type="radio" id="category3" name="category"
							value="category3"> <label for="category3">챌린지식단 </label>
					</div>
					<div class="card-slide">
						<div class="slide-wrapper">
							<c:forEach var="i" begin="1" end="15">
								<div class="card">
									<img src="/greating/resources/images/diy/default.png">
									<div class="card-info">할수있다 할수있다 할수있다.</div>

								</div>
							</c:forEach>
						</div>
					</div>

					<div class="choosen-diets">
						<div class="choosen-text">선택된 도시락 :</div>
						<div class="choosen-result">
							<span> 1번 도시락 </span> <span> 2번 도시락 </span>

						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>