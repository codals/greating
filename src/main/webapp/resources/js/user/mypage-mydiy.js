function navigateToMealDiy(id) {
    location.href = "/greating/mealdiy/" + id;
  }


function confirmDelete(id) {
    var confirmation = confirm('정말 삭제하시겠습니까?');
    if (confirmation) {
      window.location.href = '/mypage/diets/delete';
    }
  }

//커서를 올리면 포인터로 변경
$(".myDiy-card-img, .mb-2").hover(function() {
  $(this).css("cursor", "pointer");
});