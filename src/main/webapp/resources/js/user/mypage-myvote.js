$(document).ready(function () {
  $(".myScrap-card").click(function(){
    let id = $(this).data("id");
    location.href = "/greating/mealdiy/" + id;
  }).css("cursor", "pointer");
});
