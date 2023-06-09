/* 메인 카테고리에 따라 서브 카테고리 보여주기*/
  $(document).ready(function() {
    $('input[name="mainCategoryId"]').on('change', function() {
        $('input[name="mainCategoryId"]').not(this).prop('checked', false);
        
        var subcategorySec = $('.greating-sub-sec');
        subcategorySec.empty();

        if ($(this).prop('checked') && $(this).attr('id') === 'healthy-diet') {
        	 subcategorySec.append('<span>SUB CATEGORY</span>');
             subcategorySec.append('<div class="greating-subcategory-btns">');
             
             var subBtns =  subcategorySec.find('.greating-subcategory-btns');
             subBtns.append('<input id="type1" type="radio" name="subCategoryId" value="1" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type1">저당식단</label>');
             subBtns.append('<input id="type2" type="radio" name="subCategoryId" value="2" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type2">칼로리식단</label>');
             subBtns.append('<input id="type3" type="radio" name="subCategoryId" value="3" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type3">장수마을식단</label>');
             subBtns.append('<input id="type4" type="radio" name="subCategoryId" value="4" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type4">고단백식단</label>');
             subcategorySec.append('<p>ㆍ저당 식단: 당 섭취 조절이 필요한 분들을 위해 당류, 염류를 제한한 식단<br>ㆍ칼로리 식단: 350kcal 내외로 부담 없는 식단<br>ㆍ장수마을 식단: 100세 이상 장수 인구가 가장 많은 블루존 사람들의 식습관을 담은 식단<br>ㆍ고단백 식단: 단백질 섭취, 체력 증진을 위해 한 끼 평균 20g 이상의 단백질을 담은 식단</p>');
            
          } else if ($(this).prop('checked') && $(this).attr('id') === 'care-diet') {
         	 subcategorySec.append('<span>SUB CATEGORY</span>');
             subcategorySec.append('<div class="greating-subcategory-btns">');
             var subBtns =  subcategorySec.find('.greating-subcategory-btns');

             
             subBtns.append('<input id="type1" type="radio" name="subCategoryId" value="5"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type1">당뇨식단</label>');
             subBtns.append('<input id="type2" type="radio" name="subCategoryId" value="6"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type2">암환자식단</label>');
             subBtns.append('<input id="type3" type="radio" name="subCategoryId" value="7"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type3">신장질환식단</label>');
             subcategorySec.append('<p>ㆍ당뇨 식단 : 당뇨 환자도 믿고 먹을 수 있도록, 식약처 제조/가공 기준에 맞춰 설계한 식단 <br>ㆍ암환자 식단 : 암 수술 후 회복식으로 식약처 제조/가공 기준에 맞춰 설계한 식단 <br>ㆍ신장질환 식단 : 신장 질환자(투석 환자)도 안심하고 먹을 수 있는, 식약처 제조/가공 기준에 맞춰 설계한 식단<br></p>');

            
          } else if ($(this).prop('checked') && $(this).attr('id') === 'challenge-diet') {
        	  subcategorySec.append('<span>SUB CATEGORY</span>');
              subcategorySec.append('<div class="greating-subcategory-btns">');
              var subBtns =  subcategorySec.find('.greating-subcategory-btns');       
              
              subBtns.append('<input id="type1" type="radio" name="subCategoryId" value="10" onchange="handleCheckboxChange(this)"> ');
              subBtns.append('<label for="type1">뷰티핏</label>');
              subBtns.append('<input id="type2" type="radio" name="subCategoryId" value="11" onchange="handleCheckboxChange(this)">');
              subBtns.append('<label for="type2">베지라이프</label>');
              subBtns.append('<input id="type3" type="radio" name="subCategoryId" value="12" onchange="handleCheckboxChange(this)">');
              subBtns.append('<label for="type3">프로틴업</label>');
              
              subcategorySec.append('<p>ㆍ뷰티핏 : 한 끼 300kcal 내외로 가볍지만, 통곡물과 단백질로 영양 밸런스를 채운 식단 <br>ㆍ베지라이프 : 100% 순 식물성 식재료로 영양소를 골고루 섭취할 수 있는 채식 식단<br>ㆍ프로틴업 : 한 끼 단백질 27g(1일 기준치의 50%) 이상을 함유한 체력 관리용 고영양 식단 <br> </p>');


          } else {
        	  subcategory.empty();

          }
        
        
    });
  });
  
  function toggleRiceContainer() {
	  var riceN = document.getElementById('rice-n');
	  var isChecked = riceN.checked;

	  if (isChecked) {
	    var radioButtons = document.querySelectorAll('input[type="radio"][name="riceFoodId"]:checked');
	    const foodCards = document.querySelectorAll('.food-card');
	    
	    radioButtons.forEach(function (radio) {
	      radio.checked = false;
	    });
	    
	    foodCards.forEach(function(card) {
	    	card.classList.remove('selected');
	    });
	  }
	}
  
  function toggleSoupContainer() {
	  var soupN = document.getElementById('soup-n');
	  var isChecked = soupN.checked;
	  
	  if (isChecked) {
		  var radioButtons = document.querySelectorAll('input[type="radio"][name="soupFoodId"]:checked');
		  const foodCards = document.querySelectorAll('.food-card');
		  
		  radioButtons.forEach(function (radio) {
			  radio.checked = false;
		  });
		  
		  foodCards.forEach(function(card) {
			  card.classList.remove('selected');
		  });
	  }
  }
  
  function toggleMainContainer() {
	  var mainN = document.getElementById('main-n');
	  var isChecked = mainN.checked;
	  
	  if (isChecked) {
		  var radioButtons = document.querySelectorAll('input[type="radio"][name="mainFoodId"]:checked');
		  const foodCards = document.querySelectorAll('.food-card');
		  
		  radioButtons.forEach(function (radio) {
			  radio.checked = false;
		  });
		  
		  foodCards.forEach(function(card) {
			  card.classList.remove('selected');
		  });
	  }
  }
  
  

function changeBorderColor(button) {
    button.classList.toggle("clicked");
}

function blockSalad() {
	Swal.fire({
		title : '준비중인 기능입니다.',
	});  
//	alert("준비중인 기능입니다.");
	  // 도시락으로 선택되도록 변경
	  document.getElementById('diet').checked = true;
	}

function handleCheckboxChange(checkbox) {
    /* 색깔 바꾸기 */
	var checkboxes = document.getElementsByName(checkbox.name);
	checkboxes.forEach(function(cb) {
		if (cb !== checkbox) {
			cb.checked = false;
		}
	});
}

function previewImage(event) {
    var input = event.target;
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            var preview = document.getElementById('preview');
            preview.src = e.target.result;
            preview.style.display = 'block';
        };

        reader.readAsDataURL(input.files[0]);
    }
}

/* 밥 이미지 container 숨기기 */
document.addEventListener("DOMContentLoaded", function() {
    var riceY = document.getElementById("rice-y");
    var riceN = document.getElementById("rice-n");
    var riceContainer = document.getElementById("rice-container");

    riceY.addEventListener("change", function() {
        riceContainer.style.display = this.checked ? "block" : "none";
    });

    riceN.addEventListener("change", function() {
        riceContainer.style.display = this.checked ? "none" : "block";
    });
});

/* 밥 이미지 container 초기 숨김 */
document.addEventListener("DOMContentLoaded", function() {
    var riceContainer = document.getElementById("rice-container");
    riceContainer.style.display = "none";
});

/* 국 이미지 container 초기 숨김 */
document.addEventListener("DOMContentLoaded", function() {
    var soupOptionSec = document.querySelector(".soup-option-sec");
    soupOptionSec.style.display = "none";
});

/* 국 이미지 container 초기 숨김 */
document.addEventListener("DOMContentLoaded", function() {
	var mainOptionSec = document.querySelector(".main-option-sec");
	mainOptionSec.style.display = "none";
});

/* 국 이미지 container 숨기기 */
document.addEventListener("DOMContentLoaded", function() {
    var soupY = document.getElementById("soup-y");
    var soupN = document.getElementById("soup-n");
    var soupOptionSec = document.querySelector(".soup-option-sec");

    soupY.addEventListener("change", function() {
        soupOptionSec.style.display = this.checked ? "block" : "none";
    });

    soupN.addEventListener("change", function() {
        soupOptionSec.style.display = this.checked ? "none" : "block";
    });
});

/* 메인 이미지 container 숨기기 */
document.addEventListener("DOMContentLoaded", function() {
	var mainY = document.getElementById("main-y");
	var mainN = document.getElementById("main-n");
	var mainOptionSec = document.querySelector(".main-option-sec");
	
	mainY.addEventListener("change", function() {
		mainOptionSec.style.display = this.checked ? "block" : "none";
	});
	
	mainN.addEventListener("change", function() {
		mainOptionSec.style.display = this.checked ? "none" : "block";
	});
});

/* foodCard 선택여부 표시하기 */
function handleRiceRadioButtonChange(radio) {
    var riceFoodCards = document.querySelectorAll('#rice-container .food-card');
    riceFoodCards.forEach(function(card) {
        card.classList.remove('selected');
    });

    if (radio.checked) {
        radio.parentNode.classList.add('selected');
    }
}

function handleSoupRadioButtonChange(radio) {
	var soupFoodCards = document.querySelectorAll('#soup-container .food-card');
	soupFoodCards.forEach(function(card) {
		card.classList.remove('selected');
	});
	
	if (radio.checked) {
		radio.parentNode.classList.add('selected');
	}
	
	var selectedNameSec = document.getElementById("selected-soup-name-sec");
	selectedNameSec.textContent = "";
	
	var modalOpenButton = document.getElementById("soup-cart-button");
	modalOpenButton.style.backgroundColor = '#A6A6A6';
}

function handleModalSoupRadioButtonChange(button, soupName) {
	console.log(soupName)
	  var selectedMarketSoup = document.querySelector('input[name="soupFoodId"]:checked');
	  
	  var soupFoodCards = document.querySelectorAll('#soup-container .food-card');
	  soupFoodCards.forEach(function(card) {
	    card.classList.remove('selected');
	  });

	  button.parentNode.classList.add('selected');

	  var selectedNameSec = document.getElementById("selected-soup-name-sec");
	  selectedNameSec.textContent = soupName;
}

function clodeSoupModal() {
	  var modalOpenButton = document.getElementById("soup-cart-button");
	  modalOpenButton.style.backgroundColor = '#918c01';
}

function handleMainRadioButtonChange(radio) {
	var mainFoodCards = document.querySelectorAll('#main-container .food-card');
	mainFoodCards.forEach(function(card) {
		card.classList.remove('selected');
	});
	
	if (radio.checked) {
		radio.parentNode.classList.add('selected');
	}
	
	  var selectedNameSec = document.getElementById("selected-main-name-sec");
	  selectedNameSec.textContent = "";
	
	  var modalOpenButton = document.getElementById("main-cart-button");
	  modalOpenButton.style.backgroundColor = '#A6A6A6';
}

function handleModalMainRadioButtonChange(button, mainName) {
	  var selectedMarketMain = document.querySelector('input[name="mainFoodId"]:checked');

	  var mainFoodCards = document.querySelectorAll('#main-container .food-card');
	  mainFoodCards.forEach(function(card) {
	  card.classList.remove('selected');
	  });

	  button.parentNode.classList.add('selected');
	  
	  var selectedNameSec = document.getElementById("selected-main-name-sec");
	  selectedNameSec.textContent = mainName;
	  console.log(mainName);
}

function closeMainModal() {
	  var modalOpenButton = document.getElementById("main-cart-button");
	  modalOpenButton.style.backgroundColor = '#918c01';
}

function handleSideCheckboxButtonChange(checkbox) {
    var greatingCheckboxes = document.querySelectorAll('#side-container input[name="sideFoodIds"]:checked');
    var greatingSelectedCount = greatingCheckboxes.length;
    
	var modalCheckboxes = document.querySelectorAll('#sideDishModal input[name="sideFoodIds"]:checked');
    var modalSelectedCount = modalCheckboxes.length;
    
    if (greatingSelectedCount + modalSelectedCount > 2) {
    	Swal.fire({
    		title : '이미 2개가 선택되었습니다. <br>새로운 옵션을 선택하려면 이미 선택된 옵션을 취소해주세요.',
    	});  
//    	alert("이미 2개가 선택되었습니다. 새로운 옵션을 선택하려면 이미 선택된 옵션을 취소해주세요.");
    	checkbox.checked = false;
	    checkbox.parentNode.classList.remove('selected');
	    selectedCount--;
    } else {
	    checkbox.parentNode.classList.add('selected');
    }

	var sideFoodCards = document.querySelectorAll('#side-container .food-card');
	sideFoodCards.forEach(function(card) {
		var cardCheckbox = card.querySelector('input[name="sideFoodIds"]');
		if (cardCheckbox.checked) {
			card.classList.add('selected');
		} else {
			card.classList.remove('selected');
		}
	});
	
	if (modalSelectedCount == 0) {
		var modalOpenButton = document.getElementById("sides-cart-button");
		modalOpenButton.style.backgroundColor = '#A6A6A6';	
		var selectedNameSec = document.getElementById("selected-side-name-sec");
		selectedNameSec.textContent = "";
	}
}

function closeSideModal() {
	var modalOpenButton = document.getElementById("sides-cart-button");
	modalOpenButton.style.backgroundColor = '#918c01';

	var modalCheckboxes = document
			.querySelectorAll('#sideDishModal input[name="sideFoodIds"]:checked');
	var modalSelectedCount = modalCheckboxes.length;

	if (modalSelectedCount == 0) {
		var modalOpenButton = document.getElementById("sides-cart-button");
		modalOpenButton.style.backgroundColor = '#A6A6A6';
		var selectedNameSec = document.getElementById("selected-side-name-sec");
		selectedNameSec.textContent = "";
	}

}

function exitSideModal() {	
	var modalCheckboxes = document.querySelectorAll('#sideDishModal input[name="sideFoodIds"]:checked');
	var modalSelectedCount = modalCheckboxes.length;
	
	if (modalSelectedCount == 0) {
		var modalOpenButton = document.getElementById("sides-cart-button");
		modalOpenButton.style.backgroundColor = '#A6A6A6';
		var selectedNameSec = document.getElementById("selected-side-name-sec");
		selectedNameSec.textContent = "";
	}
	
}

function handleModalExtraRadioButtonChange(button, extraName) {	  
	  var selectedNameSec = document.getElementById("selected-extra-name-sec");
	  selectedNameSec.textContent = extraName;
	  console.log(extraName);
}

function closeExtraModal() {
	var modalOpenButton = document.getElementById("extra-cart-button");
	modalOpenButton.style.backgroundColor = '#918c01';
}

// 모달이 열릴 때 이벤트 리스너 등록
document.getElementById('cart').addEventListener('click', function() {
    var greatingCheckboxes = document.querySelectorAll('#side-container input[name="sideFoodIds"]:checked');
    var greatingSelectedCount = greatingCheckboxes.length;
    if (greatingSelectedCount === 2) {
    	Swal.fire({
    		title : '이미 2개가 선택되었습니다. <br>새로운 옵션을 선택하려면 이미 선택된 옵션을 취소해주세요.',
    	});  
//    	alert("이미 2개가 선택되었습니다. 새로운 옵션을 선택하려면 이미 선택된 옵션을 취소해주세요.");
    }
});

function handleModalSideCheckboxButtonChange(checkbox) {
    var greatingCheckboxes = document.querySelectorAll('#side-container input[name="sideFoodIds"]:checked');
    var greatingSelectedCount = greatingCheckboxes.length;
    
	var modalCheckboxes = document.querySelectorAll('#sideDishModal input[name="sideFoodIds"]:checked');
    var modalSelectedCount = modalCheckboxes.length;
    
    if (greatingSelectedCount + modalSelectedCount > 2) {
    	Swal.fire({
    		title : '이미 2개가 선택되었습니다. <br>새로운 옵션을 선택하려면 이미 선택된 옵션을 취소해주세요.',
    	});  
//    	alert("이미 2개가 선택되었습니다. 새로운 옵션을 선택하려면 이미 선택된 옵션을 취소해주세요.");
    	checkbox.checked = false;
	    checkbox.parentNode.classList.remove('selected');
	    selectedCount--;
    } else {
	    checkbox.parentNode.classList.add('selected');
    }  
    
	  var selectedNameSec = document.getElementById("selected-side-name-sec");
	  selectedNameSec.textContent = "건강마켓에서 선택됨";
}


function sendFile(event, imgUploadUrl, token) {
	event.preventDefault();

	var calorieErrorMessage = document.getElementById("calorieError").textContent;
	if (calorieErrorMessage === "최대 칼로리는 최소 칼로리보다 작을 수 없습니다.") {
		Swal.fire({
    		title : calorieErrorMessage,
    	}); 
//		alert(calorieErrorMessage);
		return; // 함수 실행 중단
	}

	var priceErrorMessage = document.getElementById("priceError").textContent;
	if (priceErrorMessage === "최대 가격은 최소 가격보다 작을 수 없습니다.") {
		Swal.fire({
    		title : priceErrorMessage,
    	}); 
//		alert(priceErrorMessage);
		return; // 함수 실행 중단
	}

	if (!validateForm()) {
		return;
	}

	var form = event.srcElement.form;
	var formData = new FormData(form);
	console.log(formData)

	const fileInput = document.getElementById('imgFile');

	console.log(fileInput.files[0]);
	
	if (!fileInput.files[0]) {
		formData.append('fileName', "default-img.png");
		submitFormWithFilename(formData);
	} else {
		const file = fileInput.files[0];

		/* 고유한 파일명 생성 */
		var newFilename = generateUniqueFilename();
		const originalFileName = file.name; // 원래 파일 이름
		const ext = originalFileName.split('.').pop(); // 파일 확장자 추출
		const newFileName = newFilename + '.' + ext; // 새로운 파일 이름에 확장자 추가
		const modifiedFile = new File([ file ], newFileName, {
			type : file.type
		});

		var prevFormData = new FormData();
		prevFormData.append('file', modifiedFile);
		formData.append('fileName', newFileName);

		console.log("url=", imgUploadUrl);
		console.log("token=", token);

		console.log(prevFormData)

		// 파일 업로드 AJAX 요청
		$.ajax({
			url : imgUploadUrl,
			type : 'POST',
			headers: { 'token': token },
			data : prevFormData,
			processData : false,
			contentType : false,
			success : function(response) {
				if (response.result === 'failed') {
					console.log(response)
					alert("사진 업로드 실패")
				} else if (response.result === 'successful') {
					console.log(response)
					submitFormWithFilename(formData);
				}
			}
		});
	}

}
    
function generateUniqueFilename() {
  var timestamp = new Date().getTime();
  return 'file_' + timestamp;
}

// function submitFormWithFilename(filename) {
function submitFormWithFilename(formData) {
  console.log('업로드하는 파일명:', formData.filename);
  
    // AJAX POST 요청을 보냅니다.
    $.ajax({
      url: '/greating/api/mealdiy/new',
      type: 'POST',
      data: formData,
      processData: false, // 데이터를 처리하지 않도록 설정합니다.
      contentType: false, // 기본 컨텐츠 유형을 설정하지 않도록 합니다.
      success: function(response) {
//        console.log(response);
//        alert("게시글 등록이 성공하였습니다.");
    	  
    	  Swal.fire({
        	  title: '게시글 등록이 성공하였습니다.',
          });
    	  
        location.href = "/greating/mealdiy/" + response;
      },
      error: function(xhr, status, error) {
        console.log(error);
        alert("실패하였습니다.")
      }
    });
  }

// 필수값 검증
function validateForm() {
	var dietName = document.querySelector('input[name="dietName"]').value;
	var dietType = document.querySelector('input[name="dietType"]:checked');
    var foodCountryId = document.querySelector('input[name="foodCountryId"]:checked');
    var mainCategoryId = document.querySelector('input[name="mainCategoryId"]:checked');
    var subCategoryId = document.querySelector('input[name="subCategoryId"]:checked');
    var rice = document.querySelector('input[name="rice"]:checked');
    var soup = document.querySelector('input[name="soup"]:checked');
    var mainCheckbox = document.querySelector('input[name="mainCheckbox"]:checked');    
   
    var valid = false;
    
    if (!dietType) {
    	Swal.fire({
      	  title: 'GREATING TYPE을 선택해주세요.',
        });
//    	alert("GREATING TYPE을 선택해주세요.");
        return valid;
    }

    if (!foodCountryId) {
    	Swal.fire({
        	  title: 'STYLE을 선택해주세요.',
          });
//    	alert("STYLE을 선택해주세요.");
        return valid;
    }

    if (!mainCategoryId) {
    	Swal.fire({
      	  title: 'CATEGORY를 선택해주세요.',
        });
//    	alert("CATEGORY를 선택해주세요.");
        return valid;
    }
    
    if (!subCategoryId) {
    	Swal.fire({
        	  title: 'SUB CATEGORY를 선택해주세요.',
          });
//    	alert("SUB CATEGORY를 선택해주세요.");
    	return valid;
    }
    
    if (dietName.trim() == '') {
    	Swal.fire({
      	  title: '제목을 입력해주세요.',
        });
//    	alert("제목을 입력해주세요.");
        return valid;
    }
    
    if (!rice) {
    	Swal.fire({
        	  title: '밥 포함 여부를 선택해주세요.',
          });
//    	alert("밥 포함 여부를 선택해주세요.");
        return valid;
    }
    
    if (!soup) {
    	Swal.fire({
      	  title: '국/찌개 포함 여부를 선택해주세요.',
        });
//    	alert("국/찌개 포함 여부를 선택해주세요.");
        return valid;
    }
    
    if (!mainCheckbox) {
    	Swal.fire({
			title : '메인요리  포함 여부를 선택해주세요.',
		});
//		alert("메인요리 포함 여부를 선택해주세요.");
		return valid;
    }
    
    if (rice.id === 'rice-n' && soup.id === 'soup-n' && mainCheckbox.id === "main-n") {
    	Swal.fire({
			title : '밥, 국, 메인 중 최소 1개 이상을 선택해주세요.',
		});
//    	alert("밥, 국, 메인 중 최소 1개 이상을 선택해주세요.");
        return valid;
    }
    
	valid = true;
    return valid;
}