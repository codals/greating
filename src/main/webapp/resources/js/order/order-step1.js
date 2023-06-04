// 라디오 버튼 요소들을 가져옵니다.
const experienceRadio = document.querySelectorAll('input[name="experience"]');
const mealsRadio = document.querySelectorAll('input[name="meals"]');

// 총 선택 끼니 수를 나타내는 요소를 가져옵니다.
const totalCountElement = document.querySelector('.meals-final__cont__num');

experienceRadio.forEach(radio => {
    radio.addEventListener('change', updateTotalCount);
});

mealsRadio.forEach(radio => {
    radio.addEventListener('change', updateTotalCount);
});

// 총 선택 끼니 수를 업데이트하는 함수를 정의합니다.
function updateTotalCount() {
	
	const experienceValue = document.querySelector('input[name="experience"]:checked').value;
    const mealsValue = document.querySelector('input[name="meals"]:checked').value;

    let period = 0;
    if (experienceValue === '1주') {
      period = 1;
    } else if (experienceValue === '2주') {
      period = 2;
    }
    
    let mealCount = 0;
    if (mealsValue === '6끼') {
        mealCount = 6;
    } else if (mealsValue === '9끼') {
        mealCount = 9;
    } 

    // 일주일에 몇 끼를 선택했는지에 따라 총 선택 끼니 수를 계산합니다.
    const totalCount = period * mealCount;
    console.log(totalCount)

    // 총 선택 끼니 수를 업데이트합니다.
    totalCountElement.textContent = totalCount;
    totalCountElement.dataset.totalCount = totalCount;
  }