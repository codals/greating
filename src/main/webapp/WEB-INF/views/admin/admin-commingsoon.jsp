<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>


<link rel="stylesheet" href="/greating/resources/css/admin/admin-popularList.css">
<!-- jQuery 라이브러리 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- admin-popular.js 파일 추가 -->
<script src="/greating/resources/js/admin/admin-commingSoon.js"></script>


<link rel="stylesheet"
	href="/greating/resources/css/admin/admin-popularList.css">
	
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<link href="/greating/resources/css/templates/alert.css"
	rel="stylesheet">
</head>
<body>
	<!--사이드바-->

	<jsp:include page="/WEB-INF/views/admin/admin-sidebar.jsp" />


	<div class="content">
		<div class="content-div">
			<h2 class="content-title">출시 예정 도시락 목록</h2>
			<table>
				<thead>
					<tr>
						<th>식단 이름</th>
						<th>작성자</th>
						<th>대분류</th>
						<th>소분류</th>
						<th>등록일</th>
						<th>출시여부</th>
						<th>정식식단등록 관리</th>
					</tr>
				</thead>
				<tbody>

					 <c:forEach items="${list}" var="diet">
	                    <tr>
	                    	
	                        <td><a href="/greating/mealdiy/${diet.id}">${diet.title}</a></td>
	                        <td>${diet.username}</td>
	                        <td>${diet.mainCategoryName}</td>
	                        <td>${diet.subCategoryName}</td>
	                        <td><c:out value="${fn:substring(diet.createdAt, 2, 10)}" /></td>
	                        <c:if test="${diet.status eq 2}"> <!--  출시 예정  -->
		                        <td> <span>출시 고려중</span></td>
		                         <td>
		                            <button class="approve-to-diet-${diet.id}"  id="diyToDietBtn" onclick="approveToDiet(${diet.id}, this)">상품등록</button>
		                        </td>
	                        </c:if>
	                        <c:if test="${diet.status eq 3}"> <!--  출시 예정  -->
		                        <td> <span>출시 완료</span></td>
		                         <td>
		                            <button class="cancel-diet-${diet.id}"  id="cancelDiet" onclick="cancelDiet(${diet.id}, this)">등록 취소</button>
		                        </td>
	                        </c:if>
	                    </tr>
	                </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>