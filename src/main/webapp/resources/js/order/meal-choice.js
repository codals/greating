$(document).ready(function() {
	$('[class^="minus-btn"]').click(function() {
		
		let totalCount = parseInt( $('.total-count').text());

		let classes = $(this).attr('class').split(' ');
		let i = classes[1].split('-')[2];
		let j = classes[1].split('-')[3];
		let count = parseInt($(`.meal-count-${i}-${j}`).text());
		if (count > 0) {
			count--;
			$(`.meal-count-${i}-${j}`).text(count);
			$('.total-count').text(totalCount-1);

		} else {
			alert('0개 이상 선택해주세요. ');
		}
	});

	$('[class^="plus-btn"]').click(function() {
		let totalCount = parseInt( $('.total-count').text());
				
		if(totalCount >= 6) {
			alert('최대 6개까지 선택이 가능합니다. ');
			return;
		}
		
		let classes = $(this).attr('class').split(' ');
		let i = classes[1].split('-')[2];
		let j = classes[1].split('-')[3];
		let count = parseInt($(`.meal-count-${i}-${j}`).text());
		count++;
		$(`.meal-count-${i}-${j}`).text(count);
		$('.total-count').text(totalCount+1);
	});
});


$(document).ready(function() {
	  var button = $('.meals-choice-btns .btn');
	  var content = $('.contents');
	  var windowHeight = $(window).height();
	  var contentHeight = content.height();
	  var buttonHeight = button.outerHeight();
	  var contentOffset = content.offset().top;
	  
	  
	  $(window).scroll(function() {
	    var scrollPosition = $(this).scrollTop();
	    var scrollBottom = scrollPosition + windowHeight;

	    if (scrollPosition > contentOffset && scrollBottom < contentOffset + contentHeight) {
	      button.addClass('fixed');
	    } else {
	      button.removeClass('fixed');
	    }
	  });
	});
