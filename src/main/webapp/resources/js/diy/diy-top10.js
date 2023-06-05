$(document).ready(function () {
  $('.slider').slick({
    autoplay: true,
    autoplaySpeed: 2000,
    slidesToShow: 4,
    slidesToScroll: 1,
  });

  $(".slider-card").click(function(){
    let id = $(this).data("id");
    location.href = "/greating/mealdiy/" + id;
  })
});
