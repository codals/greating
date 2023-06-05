let totalMeals = 0;
let week = 0;
let meal = 0;

$(document).ready(function () {
  $('.radio-input-week').on('click', function () {
    week = Number.parseInt($('input[name="experience"]:checked').val());
    if (isEmpty(week, meal)) {
      totalMeals = week * meal;
      $('.meals-final__cont__num').text(totalMeals);
    }
  });

  $('.radio-input-meal').on('click', function () {
    meal = +$('input[name="meals"]:checked').val();
    if (isEmpty(week, meal)) {
      totalMeals = week * meal;
      $('.meals-final__cont__num').text(totalMeals);
    }
  });

  $('.green_normal').on('click', function () {
    if (totalMeals === 0) {
      alert('선택을 완료해주세요');
      return;
    }
    location.href = '/greating/diets/mygreating/orders/delivery';
  });
});

function isEmpty(week, meal) {
  return week !== 0 && meal !== 0;
}
