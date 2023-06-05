$(document).ready(function () {
  $(".myDiy-card").click(function(){
    let id = $(this).data("id");
    location.href = "/greating/mealdiy/" + id;
  })
});
