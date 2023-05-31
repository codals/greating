///**
// * 
// */
//
///* AJAX로 form 보내기 */
//$(document).ready(function() {
//  // 폼이 제출될 때 실행되는 이벤트 핸들러
//  $('#diy-form').submit(function(event) {
//    event.preventDefault(); // 폼 제출을 막습니다.
//
//    // 폼 데이터를 FormData 객체로 가져옵니다.
//    var formData = new FormData(this);
//
//    // AJAX POST 요청을 보냅니다.
//    $.ajax({
//      url: '/greating/api/mealdiy/new',
//      type: 'POST',
//      data: formData,
//      processData: false, // 데이터를 처리하지 않도록 설정합니다.
//      contentType: false, // 기본 컨텐츠 유형을 설정하지 않도록 합니다.
//      success: function(response) {
//        console.log(response);
//        location.href = "/greating/mealdiy/" + response;
//      },
//      error: function(xhr, status, error) {
//        // 요청이 실패했을 때 실행되는 콜백 함수
//        console.log(error);
//        // 오류 처리 등을 여기에 작성하세요.
//        alert("실패하였습니다.")
//      }
//    });
//  });
//});


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

function changeBorderColor(button) {
    button.classList.toggle("clicked");
}

function blockSalad() {
	  alert("준비중인 기능입니다.");
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
}

function handleModalSoupRadioButtonChange(button) {
	  var selectedMarketSoup = document.querySelector('input[name="soupFoodId"]:checked');

//	  if (selectedMarketSoup) {
//	    var name = selectedMarketSoup.parentNode.querySelector('.modal-food-card-name').innerText;
//	    var imgUrl = selectedMarketSoup.parentNode.querySelector('.modalFoodImg').getAttribute('src');
//
//	    var selectedSoupNameElement = document.querySelector('#selectedMarketSoupName .text-border');
//	    selectedSoupNameElement.innerText = name;
//	  }

	  var soupFoodCards = document.querySelectorAll('#soup-container .food-card');
	  soupFoodCards.forEach(function(card) {
	    card.classList.remove('selected');
	  });

	  button.parentNode.classList.add('selected');
	  
	  // 모달창을 띄우는 버튼의 스타일 변경
	  var modalOpenButton = button.parentNode.querySelector('.modal-open-button');
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
}

function handleModalMainRadioButtonChange(button) {
	  var selectedMarketMain = document.querySelector('input[name="mainFoodId"]:checked');

//	  if (selectedMarketMain) {
//	    var name = selectedMarketMain.parentNode.querySelector('.modal-food-card-name').innerText;
//	    var imgUrl = selectedMarketMain.parentNode.querySelector('.modalFoodImg').getAttribute('src');
//
//	    var selectedMainNameElement = document.querySelector('#selectedMarketMainName .text-border');
//	    selectedMainNameElement.innerText = name;
//	  }

	  var mainFoodCards = document.querySelectorAll('#main-container .food-card');
	  mainFoodCards.forEach(function(card) {
	    card.classList.remove('selected');
	  });

	  button.parentNode.classList.add('selected');
	  
	  // 모달창을 띄우는 버튼의 스타일 변경
	  var modalOpenButton = button.parentNode.querySelector('.modal-open-button');
	  modalOpenButton.style.backgroundColor = '#918c01';
}

function handleSideCheckboxButtonChange(checkbox) {
	  var checkboxes = document.querySelectorAll('#side-container input[name="sideFoodIds"]:checked');
	  var selectedCount = checkboxes.length;

	  if (selectedCount > 2) {
	    checkbox.checked = false;
	    checkbox.parentNode.classList.remove('selected');
	    selectedCount--;
	  } else {
	    checkbox.parentNode.classList.add('selected');
	  }

	  var sideFoodCards = document.querySelectorAll('#side-container .food-card');
	  sideFoodCards.forEach(function (card) {
	    var cardCheckbox = card.querySelector('input[name="sideFoodIds"]');
	    if (cardCheckbox.checked) {
	      card.classList.add('selected');
	    } else {
	      card.classList.remove('selected');
	    }
	  });
	}

//function handleModalSideCheckboxButtonChange(button) {
//	  // 선택된 체크박스 해제
//	  var greatingCheckboxes = document.querySelectorAll('#side-container input[name="sideFoodIds"]');
//	  greatingCheckboxes.forEach(function (checkbox) {
//	    checkbox.checked = false;
//	  });
//	  
//	  var checkboxes = document.querySelectorAll('#sideDishModal input[name="sideFoodIds"]');
//	  var selectedCount = 0;
//
//	  checkboxes.forEach(function(checkbox) {
//	    checkbox.checked = false;
//	  });
//
//	  checkboxes.forEach(function(checkbox) {
//	    if (checkbox.checked) {
//	      selectedCount++;
//	    }
//	  });
//
//	  if (selectedCount > 2) {
//	    button.checked = false;
//	  } else {
//	    button.checked = true;
//	  }
//
//	  // 체크박스 선택 개수 제한
//	  checkboxes.forEach(function(checkbox) {
//	    checkbox.disabled = selectedCount >= 2 && !checkbox.checked;
//	  });
//
//	  // 모달창을 띄우는 버튼의 스타일 변경
//	  var modalOpenButton = document.querySelector('#sideDishModal .modal-open-button');
//	  modalOpenButton.style.backgroundColor = selectedCount > 2 ? '#ccc' : '#918c01';
//	}


// /*마우스 안 올려도 증감표시 보이게 설정*/
//const numberInputs = document.querySelectorAll('input[type="number"]');
//numberInputs.forEach(input => {
//  input.addEventListener('mouseover', () => {
//    input.style.setProperty('-webkit-appearance', 'textfield');
//  });
//
//  input.addEventListener('mouseout', () => {
//    input.style.setProperty('-webkit-appearance', 'none');
//  });
//});
//


//모달이 열릴 때 이벤트 리스너 등록
document.getElementById('cart').addEventListener('click', function() {
  // 모달 내 체크박스 요소 선택
  var modalCheckboxes = document.querySelectorAll('#sideDishModal input[name="sideFoodIds"]');
  var selectedCount = 0;

  // side-container의 체크박스 해제
  var sideCheckboxes = document.querySelectorAll('#side-container input[name="sideFoodIds"]');
  sideCheckboxes.forEach(function(checkbox) {
    checkbox.checked = false;
    handleCheckboxChange(checkbox)
  });

  // 모달 내 체크박스 선택 개수 계산
  modalCheckboxes.forEach(function(checkbox) {
    if (checkbox.checked) {
      selectedCount++;
    }
  });

});

/* 파일 전송 API 요청*/
//const form = document.getElementById('diy-form');
//const submitButton = document.getElementById('diy-diet-form-subbtn');
//
//submitButton.addEventListener('click', (event) => {
//  event.preventDefault();
//
//  const fileInput = document.getElementById('imgFile');
//  const file = fileInput.files[0];
//
//  const url = 'http://119.209.77.170:48000/upload/codals?token=wecangohdite';
//
//  const formData = new FormData();
//  formData.append('file', file);
//
//  fetch(url, {
//    method: 'POST',
//    body: formData,
////    headers: {
////      'team': team,
////      'token': token
////    }
//  })
//  .then(response => {
//    const filename = file.name;
//    return response.json().then(data => ({ filename, data }));
//  })
//  .then(({ filename, data }) => {
//    console.log('Filename:', filename);
//    console.log('Response data:', data);
//    alert("수행완료");
//  })
//  .catch(error => {
//    console.error(error);
//    alert("실패");
//  });
//});

//function sendFile() {
//    var fileInput = document.getElementById('imgFile');
//    var file = fileInput.files[0]; // Get the first selected file
//
////    if (!file) {
////      alert('파일을 선택해주세요.');
////      return;
////    }
//
//    var formData = new FormData();
//    formData.append('file',file);
//    console.log(formData)
//    console.log(file)
//    console.log(fileInput.files)
//
//    $.ajax({
//      type: 'POST',
//      url: 'http://119.209.77.170:48000/upload/codals?token=wecangohdite', 
//      data: formData,
//      processData: false,
//      contentType: false,
//      success: function(response) {
//        // Handle success response
//        console.log(response);
//        alert("실행 완료");
//
//      },
//      error: function(error) {
//        // Handle error response
//        console.error(error);
//      }
//    });
//  }

//$(document).ready(function() {
//	$('#diy-form').submit(function(event) {
function sendFile(event) {
	  event.preventDefault(); // 폼 제출을 막습니다.

	  var form = event.srcElement.form; // 이벤트가 발생한 요소를 참조합니다.
	  
	  var formData = new FormData(form);
	  console.log(formData)
	  
      var prevFormData = new FormData();
      const fileInput = document.getElementById('imgFile');
      const file = fileInput.files[0];
//      prevFormData.append('file',file);    
//      console.log(file.name);
//      console.log(fileInput.files);
      
      /* 고유한 파일명 생성 */
      var newFilename = generateUniqueFilename();
      const originalFileName = file.name; // 원래 파일 이름
      const ext = originalFileName.split('.').pop(); // 파일 확장자 추출
      const newFileName = newFilename + '.' + ext; // 새로운 파일 이름에 확장자 추가
      const modifiedFile = new File([file], newFileName, { type: file.type });

      prevFormData.append('file', modifiedFile);
      formData.append('fileName', newFileName);
      
      
//      file.name = newFilename;
      console.log(prevFormData)
      
      /* 파일 전송용 API URL */
      const url = 'http://119.209.77.170:48000/upload/codals?token=wecangohdite';
      
      // 파일 업로드 AJAX 요청
      $.ajax({
        url: url,
        type: 'POST',
        data: prevFormData,
        processData: false,
        contentType: false,
        success: function(response) {
          if (response.result === 'failed') {
        	  console.log(response)
            alert("사진 업로드 실패")
          } else if (response.result === 'successful') {
        	  console.log(response)
            // 다른 정보와 함께 AJAX 요청
//            submitFormWithFilename(response.filename);
        	  submitFormWithFilename(formData);
          }
        }
      });
	}
//    });
    
function generateUniqueFilename() {
  // 고유한 파일명 생성 로직
  // 적절한 고유한 파일명을 반환하는 함수를 구현해야 합니다.
  // 이 예시 코드에서는 현재 시간을 기반으로 파일명을 생성하는 간단한 예시를 사용합니다.
  var timestamp = new Date().getTime();
  return 'file_' + timestamp;
}

//function submitFormWithFilename(filename) {
function submitFormWithFilename(formData) {
  // 파일명과 함께 다른 정보와 함께 AJAX 요청을 보내는 로직
  // 이 함수를 서버 측 로직으로 변경해야 합니다.
  console.log('Submitting form with filename:', formData.filename);
  
//  formData.append('fileName',filename);

    // AJAX POST 요청을 보냅니다.
    $.ajax({
      url: '/greating/api/mealdiy/new',
      type: 'POST',
      data: formData,
      processData: false, // 데이터를 처리하지 않도록 설정합니다.
      contentType: false, // 기본 컨텐츠 유형을 설정하지 않도록 합니다.
      success: function(response) {
        console.log(response);
        location.href = "/greating/mealdiy/" + response;
      },
      error: function(xhr, status, error) {
        console.log(error);
        alert("실패하였습니다.")
      }
    });
  }
//  });