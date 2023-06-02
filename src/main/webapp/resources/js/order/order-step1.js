let totalMeal = 0;
let week = 0;
let meal = 0;

$(document).ready(function() {
  $('.radio-input-week').on('click', function() {
    week = +$('input[name="experience"]:checked').val();
    console.log('week : ' + week + ' meal : ' + meal);
    if (week != 0 && meal != 0) {
      totalMeal = week * meal;
      $('.meals-final__cont__num').text(totalMeal);
    }
  });

  $('.radio-input-meal').on('click', function() {
    meal = +$('input[name="meals"]:checked').val();
    console.log('week : ' + week + ' meal : ' + meal);
    if (week != 0 && meal != 0) {
      console.log('변경되어야함');
      totalMeal = week * meal;
      $('.meals-final__cont__num').text(totalMeal);
    }
  });
});
