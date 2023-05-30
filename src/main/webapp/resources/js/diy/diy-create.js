/**
 * 
 */

  $(document).ready(function() {
    $('input[name="category"]').on('change', function() {
        $('input[name="category"]').not(this).prop('checked', false);
        
        var subcategorySec = $('.greating-sub-sec');
        subcategorySec.empty();

        if ($(this).prop('checked') && $(this).attr('id') === 'healthy-diet') {
        	 subcategorySec.append('<span>SUB CATEGORY</span>');
             subcategorySec.append('<div class="greating-subcategory-btns">');
             
             var subBtns =  subcategorySec.find('.greating-subcategory-btns');
             subBtns.append('<input id="type1" type="radio" name="subcategory" value="저당식단" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type1">저당식단</label>');
             subBtns.append('<input id="type2" type="radio" name="subcategory" value="칼로리식단" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type2">칼로리식단</label>');
             subBtns.append('<input id="type3" type="radio" name="subcategory" value="장수마을식단" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type3">장수마을식단</label>');
             subBtns.append('<input id="type4" type="radio" name="subcategory" value="고단백식단" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type4">고단백식단</label>');
             subcategorySec.append('<p>ㆍ저당 식단: 당 섭취 조절이 필요한 분들을 위해 당류, 염류를 제한한 식단<br>ㆍ칼로리 식단: 350kcal 내외로 부담 없는 식단<br>ㆍ장수마을 식단: 100세 이상 장수 인구가 가장 많은 블루존 사람들의 식습관을 담은 식단<br>ㆍ고단백 식단: 단백질 섭취, 체력 증진을 위해 한 끼 평균 20g 이상의 단백질을 담은 식단</p>');
            
          } else if ($(this).prop('checked') && $(this).attr('id') === 'care-diet') {
         	 subcategorySec.append('<span>SUB CATEGORY</span>');
             subcategorySec.append('<div class="greating-subcategory-btns">');
             var subBtns =  subcategorySec.find('.greating-subcategory-btns');

             
             subBtns.append('<input id="type1" type="radio" name="subcategory" value="당뇨식단"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type1">당뇨식단</label>');
             subBtns.append('<input id="type2" type="radio" name="subcategory" value="암환자식단"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type2">암환자식단</label>');
             subBtns.append('<input id="type3" type="radio" name="subcategory" value="신장질환식단"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type3">신장질환식단</label>');
             subcategorySec.append('<p>ㆍ당뇨 식단 : 당뇨 환자도 믿고 먹을 수 있도록, 식약처 제조/가공 기준에 맞춰 설계한 식단 <br>ㆍ암환자 식단 : 암 수술 후 회복식으로 식약처 제조/가공 기준에 맞춰 설계한 식단 <br>ㆍ신장질환 식단 : 신장 질환자(투석 환자)도 안심하고 먹을 수 있는, 식약처 제조/가공 기준에 맞춰 설계한 식단<br></p>');

            
          } else if ($(this).prop('checked') && $(this).attr('id') === 'challenge-diet') {
        	  subcategorySec.append('<span>SUB CATEGORY</span>');
              subcategorySec.append('<div class="greating-subcategory-btns">');
              var subBtns =  subcategorySec.find('.greating-subcategory-btns');       
              
              subBtns.append('<input id="type1" type="radio" name="subcategory" value="뷰티핏" onchange="handleCheckboxChange(this)"> ');
              subBtns.append('<label for="type1">뷰티핏</label>');
              subBtns.append('<input id="type2" type="radio" name="subcategory" value="베지라이프" onchange="handleCheckboxChange(this)">');
              subBtns.append('<label for="type2">베지라이프</label>');
              subBtns.append('<input id="type3" type="radio" name="subcategory" value="프로틴업" onchange="handleCheckboxChange(this)">');
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

function handleCheckboxChange(checkbox) {
	/* 샐러드일 경우 alert 띄우기 */
	var label = document.querySelector('label[for="' + checkbox.id + '"]');
    if (label.innerText === '샐러드') {
        alert("준비중입니다");
        checkbox.checked = false;
    /* 그 외의 경우 색깔 바꾸기 */
    } else {
    	var checkboxes = document.getElementsByName(checkbox.name);
        checkboxes.forEach(function (cb) {
          if (cb !== checkbox) {
            cb.checked = false;
          }
        });
    }
}

/*이미지 전송 로직*/
/*let selectedImage = null;

function previewImage(event) {
  const reader = new FileReader();
  const file = event.target.files[0];

  reader.onload = function () {
    const preview = document.getElementById('preview');
    preview.src = reader.result;
    preview.style.display = 'block';

    // 이미지를 페이지에서 저장해둠
    selectedImage = file;
  }

  reader.readAsDataURL(file);
}

function sendRequestWithImage() {
	  if (selectedImage) {
	    const formData = new FormData();
	    formData.append('image', selectedImage);

	    // 다른 API 요청에 이미지 첨부
	    fetch('/greating/api/mealdiy/new', {
	      method: 'POST',
	      body: formData,
	    })
	    .then(response => {
	      // 요청 완료 시 처리할 작업 수행
	      console.log('다른 API 요청 완료');
	    })
	    .catch(error => {
	      // 에러 처리
	      console.error('다른 API 요청 에러:', error);
	    });
	  } else {
	    // 이미지가 선택되지 않은 경우 예외 처리
	    console.error('이미지가 선택되지 않았습니다.');
	  }
	}*/


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

function handleMainRadioButtonChange(radio) {
	var mainFoodCards = document.querySelectorAll('#main-container .food-card');
	mainFoodCards.forEach(function(card) {
		card.classList.remove('selected');
	});
	
	if (radio.checked) {
		radio.parentNode.classList.add('selected');
	}
}

function handleSideCheckboxButtonChange(checkbox) {
	var sideFoodCards = document.querySelectorAll('#side-container .food-card');
	var selectedCount = 0;
	
	sideFoodCards.forEach(function(card) {
		var cardCheckbox = card.querySelector('input[type="checkbox"]');
		if (cardCheckbox.checked) {
			selectedCount++;
			card.classList.add('selected');
		} else {
			card.classList.remove('selected');
		}
	});
	
	if (selectedCount > 2) {
		checkbox.checked = false;
		checkbox.parentNode.classList.remove('selected');
		selectedCount--;
	}
}



