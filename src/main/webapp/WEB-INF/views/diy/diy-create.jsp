<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Greating | DIY 식단</title>
<meta charset="utf-8">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<link
	href="${pageContext.request.contextPath}/resources/css/diy/diy-create.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/diy/diy-create.js"></script>
</head>
<body>
	<jsp:include page="../templates/header.jsp" />
	<div class="hr"></div>
	<main class="contents hd__inner1100">

		<ul class="page-category">
			<li>DIY 식단</li>
			<li>></li>
			<li class="highlight">DIY 나만의 도시락 만들기</li>
		</ul>

		<div class="form-content">
			<form id="diy-form" class="hd__inner900" action="/greating/api/mealdiy/new" method="post" enctype="multipart/form-data">
				
				<div class="diy-form-title">
					<span class="main-title"> MAKE MY OWN GREATING </span> <span
						class="main-title-desc"> 나만의 도시락 만들기 </span>

				</div>
				<div class="hr"></div>

				<div class="diy-form-section-1">
					<div class="diy-form-sec1-left">

						<div class="diy-form-img">
							<div class="image-preview">
								<img id="preview" src="#" alt="Preview" style="display: none;">
							</div>
						</div>
						
						<div class="diy-form-img-desc">
							<span> * 도시락 화면에 등록할 메인 이미지를 선택해주세요.* </span>
						</div>
						
						<div class="div-form-img-btn">
						    <input type="file" id="imgUpload" name="imgUpload" accept="image/*">
<!--  						    <input type="file" id="imgUpload" name="imgUpload" accept="image/*" onchange="previewImage(event)"> -->
						    <label for="imgUpload">파일 선택</label>
						</div>
						
					</div>
					<div class="diy-form-sec1-right">
						<div class="greating-type-sec">
							<span>GREATING TYPE</span>
							<div class="greating-type-btns">
								<input id="diet" type="radio" name="dietType" value="도시락" onchange="handleCheckboxChange(this)">
								<label for="diet">도시락 </label>
								<input id="salad" type="radio" name="dietType" value="샐러드" onchange="handleCheckboxChange(this)">
								<label for="salad">샐러드</label>
							</div>
						</div>
						<div class="greating-category-sec">
							<span>CATEGORY</span>
							<div class="greating-category-btns">
								<input id="healthy-diet" type="radio" name="category" value="건강식단" onchange="handleCheckboxChange(this)">
								<label for="healthy-diet">건강식단 </label>
								<input id="care-diet" type="radio" name="category" value="건강식단" onchange="handleCheckboxChange(this)">
								<label for="care-diet">질병맞춤식단</label>
								<input id="challenge-diet" type="radio" name="category" value="챌린지식단" onchange="handleCheckboxChange(this)">
								<label for="challenge-diet">챌린지식단 </label>
							</div>

						</div>
						<div class="greating-sub-sec"></div>
					</div>

				</div>
				<div class="diy-form-section-2">
					<div class="diy-diet-title">
						<span> TITLE </span>
						<span> 도시락을 등록할 이름을 입력해주세요 </span>
						<input type="text" name="dietName">
					</div>

					<div class="diy-diet-cal-price">
						<div class="diy-diet-cal">
							<span>희망 칼로리 </span>
							<input type="number" name="minCalorie" min="200" max="800" step="50" placeholder="최소 200">
							 ~ 
							<input type="number" name="maxCalorie" min="200"  max="800" step="50" placeholder="최대 800"> kcal
						</div>
						<div class="diy-diet-price">
							<span> 희망 가격대 </span>
							<input type="number" name="minPrice" min="7000" max="15000" step="1000" placeholder="최소 7000">
							~
							<input type="number" name="maxPrice" min="7000" max="15000" step="1000" placeholder="최대 15000"> 원
						</div>
					</div>
				</div>
				
				<div class="diy-form-section-3">
				    <span> RICE </span>
				    <div class="hr"></div>
				    <div class="diy-diet-rice-btns">
				        <input id="rice-y" type="radio" name="rice" value="밥포함" onchange="toggleContainer(this)">
				        <label for="rice-y">밥 포함</label>
				        <input id="rice-n" type="radio" name="rice" value="밥미포함" onchange="toggleContainer(this)">
				        <label for="rice-n">밥 미포함</label>
				    </div>
				    <div class="image-container" id="rice-container">
				        <div class="image-wrapper">
				            <c:forEach var="rice" items="${rices}">
				                <div class="food-card">
				                    <input type="radio" id="food-rice-${rice.id}" name="riceFoodId" value="${rice.id}" onchange="handleRiceRadioButtonChange(this)">
				                    <label for="food-rice-${rice.id}">
				                        <img src="${rice.imgUrl}" alt="Image-${rice.id}">
				                    </label>
				                    <span>${rice.name}</span>
				                </div>
				            </c:forEach>
				        </div>
				    </div>
				</div>
				
				<div class="diy-form-section-4">
				    <span> SOUP </span>
				    <div class="hr"></div>
				    <div class="diy-diet-soup-btns">
				        <input id="soup-y" type="radio" name="soup" value="국포함">
				        <label for="soup-y">국 포함</label>
				        <input id="soup-n" type="radio" name="soup" value="국미포함">
				        <label for="soup-n">국 미포함</label>
				    </div>
				    <div class="soup-option-sec">
					    <span class="d-flex mb-2 food-option-title">옵션1. 그리팅 인기 메뉴에서 선택하기</span>
					    <div class="image-container" id="soup-container">
					        <div class="image-wrapper">
					            <c:forEach var="soup" items="${soups}">
					                <div class="food-card">
					                    <input type="radio" id="food-soup-${soup.id}" name="soupFoodId" value="${soup.id}" onchange="handleSoupRadioButtonChange(this)">
					                    <label for="food-soup-${soup.id}">
					                        <img src="${soup.imgUrl}" alt="Image-${soup.id}">
					                    </label>
					                    <span>${soup.name}</span>
					                </div>
					            </c:forEach>
					        </div>
					    </div>
					    <span class="d-flex mt-5 mb-1 food-option-title">옵션2.건강 마켓에서 선택하기 </span>
					    <!-- Button trigger modal -->
					    <button id="cart" type="button" data-toggle="modal" data-target="#soupModal">
					        <i class="fas fa-shopping-cart"></i>선택하러 가기
					    </button>
				    </div>
				</div>

				<div class="diy-form-section-5">
					<span> Main Dish </span>
					<div class="hr"></div>
					<div class="diy-diet-main-btns">
						<input id="main-y" type="radio" name="mainCheckbox" value="포함">
						<label for="main-y">메인 포함 </label>
						<input id="main-n" type="radio" name="mainCheckbox" value="밥미포함">
						<label for="main-n">메인 미포함 </label>
					</div>
					<div class="main-option-sec">
						<span class="d-flex mb-2 food-option-title">옵션1. 그리팅 인기 메뉴에서 선택하기 </span>
						<div class="image-container" id="main-container">
							<div class="image-wrapper">
								<c:forEach var="main" items="${mains}">
									<div class="food-card">
										<input type="radio" id="food-main-${main.id}" name="mainFoodId" value="${main.id}" onchange="handleMainRadioButtonChange(this)">
											<label for="food-main-${main.id}">
											<img src="${main.imgUrl}" alt="Image 1">
										</label> <span>${main.name} </span>
									</div>
								</c:forEach>
							</div>
						</div>
						<span class="d-flex mt-5 mb-1 food-option-title"> 옵션2.건강 마켓에서 선택하기 </span>
						<button id="cart" type="button" data-toggle="modal"
							data-target="#mainDishModal">
							<i class="fas fa-shopping-cart"></i>선택하러 가기
						</button>
					</div>
				</div>


				<div class="diy-form-section-6">
					<span> Side Dish </span>
					<div class="hr"></div>
					<span class="side-choice-desc"> 최대 2개까지 선택해주세요 ( 0~2개 )</span>
					<div class="side-option-sec">
						<span class="d-flex mb-2 food-option-title">옵션1. 그리팅 인기 메뉴에서 선택하기 </span>
						<div class="image-container" id="side-container">
							<div class="image-wrapper">
								<c:forEach var="side" items="${sides}">
									<div class="food-card">
										<input type="checkbox" id="food-side-${side.id}" name="sideFoodId" value="${side.id}" onchange="handleSideCheckboxButtonChange(this)">
										<label for="food-side-${side.id}">
											<img src="${side.imgUrl}" alt="Image-${side.id}">
										</label>
										<span>${side.name}</span>
									</div>
								</c:forEach>
	
							</div>
						</div>
						<span class="d-flex mt-5 mb-1 food-option-title"> 옵션2.건강 마켓에서 선택하기 </span>
						<button id="cart" type="button" data-toggle="modal"
							data-target="#sideDishModal">
							<i class="fas fa-shopping-cart"></i>선택하러 가기
						</button>
					</div>
				</div>

				<div class="diy-form-section-7">

					<span> + 추가 상품 </span>
					<div class="hr"></div>
					<span class="d-flex mt-2 mb-1"> 건강마켓에서 추가 구성을 선택해보세요. </span>
					<button id="cart" type="button" data-toggle="modal"
						data-target="#etcFoodModal">
						<i class="fas fa-shopping-cart"></i>선택하러 가기
					</button>

				</div>

				<div class="diy-form-section-8">

					<span> Comments </span>
					<div class="hr"></div>
					<span class="d-flex mt-2">특별한 요구사항이 있다면 작성해주세요.<br>정식 메뉴로 등록될 때, 밥상 주치의 그리팅이 적절히 반영하여 식단을 만들어드립니다.</span>
					<span class="d-flex mt-1">ex) 닭곰탕의 당면은 곤약면이었으면 좋겠어요! / 돼지감자장아찌는 살짝 매콤하게 해주세요.</span>

					<!-- <div class="diy-diet-comments mt-4">
						<div class="comment">
							<span>1.</span> <input type="text">
						</div>
						<div class="comment">
							<span>2.</span> <input type="text">
						</div>
						<div class="comment">
							<span>3.</span> <input type="text">
						</div>

					</div> -->
					
					<div class="diy-diet-content mt-4">
					  <textarea name="content" rows="3"></textarea>
					</div>


				</div>
				<div class="submut-btn mt-5">
					<input id="diy-diet-form-cancelbtn" type="button" value="등록 취소" onclick=" location.href='${header.referer}'">
<!--  					<input id="diy-diet-form-subbtn" type="submit" value="등록 완료" onclick="sendRequestWithImage()"> -->
 					<input id="diy-diet-form-subbtn" type="submit" value="등록 완료">

				</div>

				<!-- Modal -->
				<div class="modal fade" id="soupModal" tabindex="-1" role="dialog"
					aria-labelledby="soupModalLabel" aria-hidden="true">
					<div class="modal-dialog  modal-lg" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="soupModalLabel">건강마켓에서 선택하기</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<span class="d-flex modalTitle"> Soup </span> <span
									class="d-flex modalTitleDesc"> 원하는 국/찌개 종류를 선택하세요. </span>
								<div class="modal-food-content">
									<c:forEach var="i" begin="1" end="5">

										<input class="modal-food-card" type="checkbox"
											id="modalFood-soup-${i}" name="soupModalCheckBox"
											onchange="handleCheckboxChange(this)">
										<label for="modalFood-soup-${i}"> <img
											class="modalFoodImg"
											src="${pageContext.request.contextPath}/resources/images/market/가자미미역국.png">
											<span class="d-flex">달콤한 겨울 무 </span> <span
											class="d-flex modal-food-card-name">쇠고기 무국 </span> <span
											class="d-flex modal-food-card-price">5800원 </span>
										</label>
									</c:forEach>

								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="modalCloseBtn" data-dismiss="modal">Close</button>
								<button type="button" class="modalSaveBtn">Save</button>
							</div>
						</div>
					</div>
				</div>
				<!-- Modal -->
				<div class="modal fade" id="mainDishModal" tabindex="-1"
					role="dialog" aria-labelledby="mainDishModalLabel"
					aria-hidden="true">
					<div class="modal-dialog  modal-lg" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="mainDishModalLabel">건강마켓에서 선택하기</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<span class="d-flex modalTitle"> Main Dish </span> <span
									class="d-flex modalTitleDesc"> 원하는 Main Dish를 선택하세요. (
									1개 )</span>
								<div class="modal-food-content">
									<c:forEach var="i" begin="1" end="5">

										<input class="modal-food-card" type="checkbox"
											id="modalFood-main-${i}" name="soupModalCheckBox"
											onchange="handleCheckboxChange(this)">
										<label for="modalFood-main-${i}"> <img
											class="modalFoodImg"
											src="${pageContext.request.contextPath}/resources/images/market/LA갈비.png">
											<span class="d-flex">LA갈비 맛있음 </span> <span
											class="d-flex modal-food-card-name">LA갈비 </span> <span
											class="d-flex modal-food-card-price">5800원 </span>
										</label>
									</c:forEach>

								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="modalCloseBtn" data-dismiss="modal">Close</button>
								<button type="button" class="modalSaveBtn">Save</button>
							</div>
						</div>
					</div>
				</div>

				<!-- Modal -->
				<div class="modal fade" id="sideDishModal" tabindex="-1"
					role="dialog" aria-labelledby="sideDishModalLabel"
					aria-hidden="true">
					<div class="modal-dialog  modal-lg" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="sideDishModalLabel">건강마켓에서 선택하기</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<span class="d-flex modalTitle"> Side Dish </span> <span
									class="d-flex modalTitleDesc"> 원하는 Side Dish를 선택하세요. ( 0
									- 2개 )</span>
								<div class="modal-food-content">
									<c:forEach var="i" begin="1" end="5">

										<input class="modal-food-card" type="checkbox"
											id="modalFood-side-${i}" name="soupModalCheckBox">
										<label for="modalFood-side-${i}"> <img
											class="modalFoodImg"
											src="${pageContext.request.contextPath}/resources/images/market/깻잎지.png">
											<span class="d-flex">깻잎지 맛있음 </span> <span
											class="d-flex modal-food-card-name">깻잎지 </span> <span
											class="d-flex modal-food-card-price">3000원 </span>
										</label>
									</c:forEach>

								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="modalCloseBtn" data-dismiss="modal">Close</button>
								<button type="button" class="modalSaveBtn">Save</button>
							</div>
						</div>
					</div>
				</div>


				<!-- Modal -->
				<div class="modal fade" id="etcFoodModal" tabindex="-1"
					role="dialog" aria-labelledby="etcFoodModalLabel"
					aria-hidden="true">
					<div class="modal-dialog  modal-lg" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="etcFoodModalLabel">건강마켓에서 선택하기</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<span class="d-flex modalTitle"> 추가 구성 </span> <span
									class="d-flex modalTitleDesc"> 원하는 추가 구성품을 선택하세요. ( 0 -
									2개 )</span>
								<div class="modal-food-content">
									<c:forEach var="i" begin="1" end="5">

										<input class="modal-food-card" type="checkbox"
											id="modalFood-etc-${i}" name="soupModalCheckBox"
											onchange="handleCheckboxChange(this)">
										<label for="modalFood-etc-${i}"> <img
											class="modalFoodImg"
											src="${pageContext.request.contextPath}/resources/images/market/탕수육.png">
											<span class="d-flex">탕수육 겁나 맛있음 </span> <span
											class="d-flex modal-food-card-name">탕수육 </span> <span
											class="d-flex modal-food-card-price">3000원 </span>
										</label>
									</c:forEach>

								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="modalCloseBtn" data-dismiss="modal">Close</button>
								<button type="button" class="modalSaveBtn">Save</button>
							</div>
						</div>
					</div>
				</div>


			</form>

		</div>

	</main>



</body>
</html>
