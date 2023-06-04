$(document).ready(function() {
  var button = $('.meals-menu-btns .btn');
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
    
    if (scrollPosition === 0) {
        button.addClass('fixed');
      } 
  
  });
});
