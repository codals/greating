let totalCount;

$(document).ready(function () {
  $('[class^="minus-btn"]').click(function () {

    let totalCount = parseInt($('.total-count').text());

    let classes = $(this).attr('class').split(' ');
    let i = classes[1].split('-')[2];
    let j = classes[1].split('-')[3];
    let count = parseInt($(`.meal-count-${i}-${j}`).text());
    if (count > 0) {
      count--;
      $(`.meal-count-${i}-${j}`).text(count);
      $('.total-count').text(totalCount - 1);
    } else {
    	Swal.fire({
      	  title: '0개 이상 선택해주세요.',
        });
//    	alert('0개 이상 선택해주세요.');
    }
  });

  $('[class^="plus-btn"]').click(function () {
    totalCount = parseInt($('.total-count').text());

    if (totalCount >= 6) {
    	Swal.fire({
        	  title: '최대 6개까지 선택이 가능합니다.',
          });
    	alert('최대 6개까지 선택이 가능합니다.');
      return;
    }

    let classes = $(this).attr('class').split(' ');
    let i = classes[1].split('-')[2];
    let j = classes[1].split('-')[3];
    let count = parseInt($(`.meal-count-${i}-${j}`).text());
    count++;
    $(`.meal-count-${i}-${j}`).text(count);
    $('.total-count').text(totalCount + 1);
    totalCount++;
  });
});

$(document).ready(function () {
  var button = $('.meals-choice-btns .btn');
  var content = $('.contents');
  var windowHeight = $(window).height();
  var contentHeight = content.height();
  var buttonHeight = button.outerHeight();
  var contentOffset = content.offset().top;

  $(window).scroll(function () {
    var scrollPosition = $(this).scrollTop();
    var scrollBottom = scrollPosition + windowHeight;

    if (scrollPosition > contentOffset && scrollBottom < contentOffset
        + contentHeight) {
      button.addClass('fixed');
    } else {
      button.removeClass('fixed');
    }
  });
});

$(document).ready(function () {
  $('.btn-buy').click(function () {
    if (totalCount !== 6) {
    	Swal.fire({
      	  title: '6개를 선택해야 합니다.',
        });
    	alert('6개를 선택해야 합니다.');
      return;
    }
    const mealCards = document.getElementsByClassName("meal-card");
    const order = [];

    for (let i = 0; i < mealCards.length; i++) {
      const mealCard = mealCards[i];
      const deliveryDate = mealCard.getElementsByClassName("meal-diet-date")[0].value;
      const dietId = +mealCard.getElementsByClassName("meal-diet")[0].value;
      const name = mealCard.getElementsByClassName("meal-card-title")[0].innerText;
      const price = mealCard.getElementsByClassName("meal-card-price-sec")[0].innerText;
      const cnt = +mealCard.getElementsByClassName("meal-count")[0].innerText;
      if (cnt > 0) {
        order.push({dietId, cnt, name, price, deliveryDate});
      }
    }
    console.log(order);
    let data = {
      orders: order
    }
    $.ajax({
      url: '/greating/api/diets/mygreating/orders',
      type: 'POST',
      dataType: 'json',
      contentType: 'application/json',
      async: false,
      data: JSON.stringify(data),
      success: function (response) {
        if (response) {
        	Swal.fire({
            	  title: '식단 주문을 성공하였습니다.',
              });
          location.href = 'http://localhost:8080/greating/diets/mygreating/orders/result';
          return;
        }
        Swal.fire({
      	  title: '식단 주문을 실패하였습니다.',
        });
      },
      error: function () {
          Swal.fire({
          	  title: '식단 주문을 실패하였습니다.',
            });
      }
    });
  });
});
