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
             subBtns.append('<input id="type1" type="checkbox" name="subcategory" value="저당식단" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type1">저당식단</label>');
             subBtns.append('<input id="type2" type="checkbox" name="subcategory" value="칼로리식단" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type2">칼로리식단</label>');
             subBtns.append('<input id="type3" type="checkbox" name="subcategory" value="장수마을식단" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type3">장수마을식단</label>');
             subBtns.append('<input id="type4" type="checkbox" name="subcategory" value="고단백식단" onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type4">고단백식단</label>');
             subcategorySec.append('<p>저당 식단: 당 섭취 조절이 필요한 분들을 위해 당류, 염류를 제한한 식단<br>칼로리 식단: 350kcal 내외로 부담 없는 식단<br>장수마을 식단: 100세 이상 장수 인구가 가장 많은 블루존 사람들의 식습관을 담은 식단<br>고단백 식단: 단백질 섭취, 체력 증진을 위해 한 끼 평균 20g 이상의 단백질을 담은 식단</p>');
            
          } else if ($(this).prop('checked') && $(this).attr('id') === 'care-diet') {
         	 subcategorySec.append('<span>SUB CATEGORY</span>');
             subcategorySec.append('<div class="greating-subcategory-btns">');
             var subBtns =  subcategorySec.find('.greating-subcategory-btns');

             
             subBtns.append('<input id="type1" type="checkbox" name="subcategory" value="당뇨식단"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type1">당뇨식단</label>');
             subBtns.append('<input id="type2" type="checkbox" name="subcategory" value="암환자식단"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type2">암환자식단</label>');
             subBtns.append('<input id="type3" type="checkbox" name="subcategory" value="신장질환식단"  onchange="handleCheckboxChange(this)">');
             subBtns.append('<label for="type3">신장질환식단</label>');
             subcategorySec.append('<p> 당뇨 식단 : 당뇨 환자도 믿고 먹을 수 있도록, 식약처 제조/가공 기준에 맞춰 설계한 식단 <br>암환자 식단 : 암 수술 후 회복식으로 식약처 제조/가공 기준에 맞춰 설계한 식단 <br> 신장질환 식단 : 신장 질환자(투석 환자)도 안심하고 먹을 수 있는, 식약처 제조/가공 기준에 맞춰 설계한 식단<br></p>');

            
          } else if ($(this).prop('checked') && $(this).attr('id') === 'challenge-diet') {
        	  subcategorySec.append('<span>SUB CATEGORY</span>');
              subcategorySec.append('<div class="greating-subcategory-btns">');
              var subBtns =  subcategorySec.find('.greating-subcategory-btns');       
              
              subBtns.append('<input id="type1" type="checkbox" name="subcategory" value="뷰티핏" onchange="handleCheckboxChange(this)"> ');
              subBtns.append('<label for="type1">뷰티핏</label>');
              subBtns.append('<input id="type2" type="checkbox" name="subcategory" value="베지라이프" onchange="handleCheckboxChange(this)">');
              subBtns.append('<label for="type2">베지라이프</label>');
              subBtns.append('<input id="type3" type="checkbox" name="subcategory" value="프로틴업" onchange="handleCheckboxChange(this)">');
              subBtns.append('<label for="type3">프로틴업</label>');
              
              subcategorySec.append('<p>뷰티핏 : 한 끼 300kcal 내외로 가볍지만, 통곡물과 단백질로 영양 밸런스를 채운 식단 <br> 베지라이프 : 100% 순 식물성 식재료로 영양소를 골고루 섭취할 수 있는 채식 식단<br>프로틴업 : 한 끼 단백질 27g(1일 기준치의 50%) 이상을 함유한 체력 관리용 고영양 식단 <br> </p>');


          } else {
        	  subcategory.empty();

          }
        
        
    });
  });



  

function changeBorderColor(button) {
    button.classList.toggle("clicked");
}

function handleCheckboxChange(checkbox) {
    var checkboxes = document.getElementsByName(checkbox.name);
    checkboxes.forEach(function (cb) {
      if (cb !== checkbox) {
        cb.checked = false;
      }
    });  
    
}
