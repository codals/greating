$(window).on("scroll", function() {
  var element = $("#main-healthy-fadeList");
  var position = element.offset().top;
  var windowHeight = $(window).height();
  var scrollPosition = $(window).scrollTop();

  console.log("position", position);
  console.log("windowHeight", windowHeight);
  console.log("scrollPosition", scrollPosition);
  // Check if the element is within the visible area
  if (position-500 < scrollPosition &&  scrollPosition < position) {
    element.addClass("fadeInUp"); 
    console.log("진입 ");// Add the fadeInUp class to start the animation\
//    element.animate({"animation:fadeInUp 2s both 0.25s"});

  }else{
	  element.removeClass("fadeInUp");
 }
});