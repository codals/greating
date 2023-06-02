let totalMeals = 0;
let week = 0;
let meal = 0;

$(document).ready(function() {
  $('.radio-input-week').on('click', function() {
    week = +$('input[name="experience"]:checked').val();
    if (week !== 0 && meal !== 0) {
      totalMeals = week * meal;
      $('.meals-final__cont__num').text(totalMeals);
    }
  });

  $('.radio-input-meal').on('click', function() {
    meal = +$('input[name="meals"]:checked').val();
    console.log('week : ' + week + ' meal : ' + meal);
    if (week !== 0 && meal !== 0) {
      totalMeals = week * meal;
      $('.meals-final__cont__num').text(totalMeals);
    }
  });
  $('.green_normal').on('click', function () {
    console.log(totalMeals);
    if (totalMeals === 0) {
      alert('선택을 완료해주세요');
      return;
    }
   location.href = '/greating/diets/mygreating/orders/delivery';
  });
});
