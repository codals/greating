<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Greating</title>
<meta charset="utf-8">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<link href="/greating/resources/css/diy/diy-create.css" rel="stylesheet">
<script src="/greating/resources/js/diy/diy-create.js"></script>
</head>
<body>
	<jsp:include page="../templates/header.jsp" />


	<main class="contents hd__inner1100">
		<div class="form-content">
			<form id="diy-form" class="hd__inner900" action="" method="post"
				enctype="multipart/form-data">
				<div class="diy-form-title">
					<span class="main-title"> MAKE MY OWN GREATING </span> <span
						class="main-title-desc"> 나만의 도시락 만들기 </span>

				</div>
				<div class="hr"></div>

				<div class="diy-form-section-1">
					<div class="diy-form-sec1-left">
						<div class="diy-form-img">
							<div class="div-form-img-btn">
								<input type="file" id="chooseFile" name="chooseFile"
									accept="image/*"> <span>?</span>
							</div>

						</div>
						<div class="diy-form-img-desc">
							<span> * 도시락 화면에 등록할 메인 이미지를 선택해주세요.* </span>
						</div>
					</div>
					<div class="diy-form-sec1-right">
						<div class="greating-type-sec">
							<span>GREATING TYPE</span>
							<div class="greating-type-btns">
								<input id="diet" type="checkbox" name="diet-type" value="도시락"
									onchange="handleCheckboxChange(this)"> <label
									for="diet">도시락 </label> <input id="salad" type="checkbox"
									name="diet-type" value="샐러드"
									onchange="handleCheckboxChange(this)"> <label
									for="salad">샐러드</label>
							</div>
						</div>
						<div class="greating-category-sec">
							<span>CATEGORY</span>
							<div class="greating-category-btns">
								<input id="healthy-diet" type="checkbox" name="category"
									value="건강식단" onchange="handleCheckboxChange(this)"> <label
									for="healthy-diet">건강식단 </label> <input id="care-diet"
									type="checkbox" name="category" value="건강식단"
									onchange="handleCheckboxChange(this)"> <label
									for="care-diet">질병맞춤식단</label> <input id="challenge-diet"
									type="checkbox" name="category" value="챌린지식단"
									onchange="handleCheckboxChange(this)"> <label
									for="challenge-diet">챌린지식단 </label>

							</div>

						</div>
						<div class="greating-sub-sec"></div>

					</div>

				</div>
				<div class="diy-form-section-2">
					<div class="diy-diet-title">
						<span> TITLE </span> <span> 도시락을 등록할 이름을 입력해주세요 </span> <input
							type="text" name="dietName">
					</div>

					<div class="diy-diet-cal-price">
						<div class="diy-diet-cal">
							<span>희망 칼로리 </span> <input type="number"> ~ <input
								type="number"> kcal
						</div>
						<div class="diy-diet-price">
							<span> 희망 가격대 </span> <input type="number"> ~ <input
								type="number"> 원
						</div>
					</div>

				</div>


				<div class="diy-form-section-3">

					<span> RICE </span>
					<div class="hr"></div>
					<div class="diy-diet-rice-btns">
						<input id="rice-y" type="checkbox" name="rice" value="밥포함"
							onchange="handleCheckboxChange(this)"> <label
							for="rice-y">밥 포함 </label> <input id="rice-n" type="checkbox"
							name="rice" value="밥미포함" onchange="handleCheckboxChange(this)">
						<label for="rice-n">밥 미포함 </label>

					</div>
					<div class="image-container">
						<div class="image-wrapper">
							<c:forEach var="i" begin="1" end="15">
								<div class="food-card">
									<input type="checkbox" id="food-rice-${i}" name="riceCheckbox"
										onchange="handleCheckboxChange(this)"> <label
										for="food-rice-${i}"> <img
										src="/greating/resources/images/food/쌀밥.png" alt="Image 1">
									</label> <span>쌀밥 </span>
								</div>

							</c:forEach>

						</div>
					</div>


				</div>

				<div class="diy-form-section-4">

					<span> SOUP </span>
					<div class="hr"></div>
					<div class="diy-diet-soup-btns">
						<input id="soup-y" type="checkbox" name="soup" value="국포함"
							onchange="handleCheckboxChange(this)"> <label
							for="soup-y">국 포함 </label> <input id="soup-n" type="checkbox"
							name="soup" value="밥미포함" onchange="handleCheckboxChange(this)">
						<label for="soup-n">국 미포함 </label>

					</div>
					<span class="d-flex mb-2">옵션1. 그리팅 인기 메뉴에서 선택하기 </span>
					<div class="image-container">
						<div class="image-wrapper">
							<c:forEach var="i" begin="1" end="5">

								<div class="food-card">
									<input type="checkbox" id="food-soup-${i}" name="soupCheckbox"
										onchange="handleCheckboxChange(this)"> <label
										for="food-soup-${i}"> <img
										src="/greating/resources/images/food/돼지고기콩비지찌개.png"
										alt="Image 1">
									</label> <span> 돼지고기 콩비지찌개 </span>
								</div>


							</c:forEach>

						</div>
					</div>
					<span class="d-flex mt-5 mb-1">옵션2.건강 마켓에서 선택하기 </span>
					<!-- Button trigger modal -->
					<button id="cart" type="button" data-toggle="modal"
						data-target="#soupModal">
						<i class="fas fa-shopping-cart"></i>선택하러 가기
					</button>





				</div>



				<div class="diy-form-section-5">

					<span> Main Dish </span>
					<div class="hr"></div>
					<div class="diy-diet-main-btns">
						<input id="main-y" type="checkbox" name="mainCheckbox" value="포함"
							onchange="handleCheckboxChange(this)"> <label
							for="main-y">포함 </label> <input id="main-n" type="checkbox"
							name="mainCheckbox" value="밥미포함" onchange="handleCheckboxChange(this)">
						<label for="main-n">미포함 </label>

					</div>
					<span class="d-flex mb-2">옵션1. 그리팅 인기 메뉴에서 선택하기 </span>
					<div class="image-container">
						<div class="image-wrapper">
							<c:forEach var="i" begin="1" end="5">
								<div class="food-card">
									<input type="checkbox" id="food-main-${i}" name="mainCheckbox"
										onchange="handleCheckboxChange(this)"> <label
										for="food-main-${i}"> <img
										src="/greating/resources/images/food/미강돼지고기배추볶음.png"
										alt="Image 1">
									</label> <span>미강돼지고기배추볶음 </span>
								</div>
							</c:forEach>
						</div>
					</div>
					<span class="d-flex mt-5 mb-1"> 옵션2.건강 마켓에서 선택하기 </span>
					<button id="cart" type="button" data-toggle="modal"
						data-target="#mainDishModal">
						<i class="fas fa-shopping-cart"></i>선택하러 가기
					</button>


				</div>


				<div class="diy-form-section-6">

					<span> Side Dish </span>
					<div class="hr"></div>
					<span class="side-choice-desc"> 최대 2개까지 선택해주세요 ( 0~2개 )</span> <span
						class="d-flex mb-2">옵션1. 그리팅 인기 메뉴에서 선택하기 </span>
					<div class="image-container">
						<div class="image-wrapper">
							<c:forEach var="i" begin="1" end="15">
								<div class="food-card">
									<input type="checkbox" id="food-side-${i}" name="sideCheckbox">
									<label for="food-side-${i}"> <img
										src="/greating/resources/images/food/스크램블에그.png" alt="Image 1">
									</label> <span>스크램블에그 </span>

								</div>
							</c:forEach>

						</div>
					</div>
					<span class="d-flex mt-5 mb-1"> 옵션2.건강 마켓에서 선택하기 </span>
					<button id="cart" type="button" data-toggle="modal"
						data-target="#sideDishModal">
						<i class="fas fa-shopping-cart"></i>선택하러 가기
					</button>

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
					<span class="d-flex mt-2">특별한 요구사항이 있다면 작성해주세요. 정식 메뉴로 등록될
						때, 밥상 주치의 그리팅이 적절히 반영하여 식단을 만들어드립니다.</span> <span class="d-flex mt-1">ex)
						닭곰탕의 당면은 곤약면이었으면 좋겠어요! / 돼지감자장아찌는 살짝 매콤하게 해주세요.</span>

					<div class="diy-diet-comments mt-4">
						<div class="comment">
							<span>1.</span> <input type="text">
						</div>
						<div class="comment">
							<span>2.</span> <input type="text">
						</div>
						<div class="comment">
							<span>3.</span> <input type="text">
						</div>

					</div>


				</div>
				<div class="submut-btn mt-5">
					<input id="diy-diet-form-cancelbtn" type="button" value="등록 취소">
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
											src="/greating/resources/images/market/가자미미역국.png"> <span
											class="d-flex">달콤한 겨울 무 </span> <span
											class="d-flex modal-food-card-name">쇠고기 무국 </span> <span
											class="d-flex modal-food-card-price">5800원 </span>
										</label>
									</c:forEach>

								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="modalCloseBtn"
									data-dismiss="modal">Close</button>
								<button type="button" class="modalSaveBtn">Save</button>
							</div>
						</div>
					</div>
				</div>
				<!-- Modal -->
				<div class="modal fade" id="mainDishModal" tabindex="-1" role="dialog"
					aria-labelledby="mainDishModalLabel" aria-hidden="true">
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
									class="d-flex modalTitleDesc"> 원하는 Main Dish를 선택하세요. ( 1개 )</span>
								<div class="modal-food-content">
									<c:forEach var="i" begin="1" end="5">

										<input class="modal-food-card" type="checkbox"
											id="modalFood-main-${i}" name="soupModalCheckBox"
											onchange="handleCheckboxChange(this)">
										<label for="modalFood-main-${i}"> <img
											class="modalFoodImg"
											src="/greating/resources/images/market/LA갈비.png"> <span
											class="d-flex">LA갈비 맛있음 </span> <span
											class="d-flex modal-food-card-name">LA갈비 </span> <span
											class="d-flex modal-food-card-price">5800원 </span>
										</label>
									</c:forEach>

								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="modalCloseBtn"
									data-dismiss="modal">Close</button>
								<button type="button" class="modalSaveBtn">Save</button>
							</div>
						</div>
					</div>
				</div>
				
						<!-- Modal -->
				<div class="modal fade" id="sideDishModal" tabindex="-1" role="dialog"
					aria-labelledby="sideDishModalLabel" aria-hidden="true">
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
									class="d-flex modalTitleDesc"> 원하는 Side Dish를 선택하세요. ( 0 - 2개 )</span>
								<div class="modal-food-content">
									<c:forEach var="i" begin="1" end="5">

										<input class="modal-food-card" type="checkbox"
											id="modalFood-side-${i}" name="soupModalCheckBox">
										<label for="modalFood-side-${i}"> <img
											class="modalFoodImg"
											src="/greating/resources/images/market/깻잎지.png"> <span
											class="d-flex">깻잎지 맛있음 </span> <span
											class="d-flex modal-food-card-name">깻잎지 </span> <span
											class="d-flex modal-food-card-price">3000원 </span>
										</label>
									</c:forEach>

								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="modalCloseBtn"
									data-dismiss="modal">Close</button>
								<button type="button" class="modalSaveBtn">Save</button>
							</div>
						</div>
					</div>
				</div>
				
					
						<!-- Modal -->
				<div class="modal fade" id="etcFoodModal" tabindex="-1" role="dialog"
					aria-labelledby="etcFoodModalLabel" aria-hidden="true">
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
								<span class="d-flex modalTitle"> 추가 구성  </span> <span
									class="d-flex modalTitleDesc"> 원하는 추가 구성품을 선택하세요. ( 0 - 2개 )</span>
								<div class="modal-food-content">
									<c:forEach var="i" begin="1" end="5">

										<input class="modal-food-card" type="checkbox"
											id="modalFood-etc-${i}" name="soupModalCheckBox"
											onchange="handleCheckboxChange(this)">
										<label for="modalFood-etc-${i}"> <img
											class="modalFoodImg"
											src="/greating/resources/images/market/탕수육.png"> <span
											class="d-flex">탕수육 겁나 맛있음 </span> <span
											class="d-flex modal-food-card-name">탕수육  </span> <span
											class="d-flex modal-food-card-price">3000원 </span>
										</label>
									</c:forEach>

								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="modalCloseBtn"
									data-dismiss="modal">Close</button>
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
