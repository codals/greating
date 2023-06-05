function navigateToMealDiy(id) {
    location.href = "/greating/mealdiy/" + id;
  }


//function confirmDelete(id) {
//    var confirmation = confirm('정말 삭제하시겠습니까?');
//    if (confirmation) {
//        console.log("js 함수까지는 왔습니다." + id);
//        $.ajax({
//            url: '/greating/mypage/deleteDiy?id=' + id,
//            type: 'GET',
//            data: { id: id },
//            success: function(response) {
//                console.log('게시물 삭제 성공!');
//                // 여기에 성공 시 동작할 코드 작성
//                // 예를 들어, 해당 요소를 삭제하거나 화면을 갱신할 수 있습니다.
//                alert("삭제 성공");
//            },
//            error: function() {
//                console.log('게시물 삭제 실패!');
//                // 여기에 실패 시 동작할 코드 작성
//                alert("삭제 실패");
//            }
//        });
//    }
//}

function confirmDelete(id) {
    var confirmation = confirm('정말 삭제하시겠습니까?');
    if (confirmation) {
        console.log("js 함수까지는 왔습니다." + id);
        $.ajax({
            url: '/greating/mypage/deleteDiy/' + id,
            type: 'DELETE',
            dataType: 'json',
            contentType: 'application/json',
            async: false,
            success: function(response) {
                console.log('게시물 삭제 성공!');
                // 여기에 성공 시 동작할 코드 작성
                // 예를 들어, 해당 요소를 삭제하거나 화면을 갱신할 수 있습니다.
                alert("삭제 성공");
                location.reload();
            },
            error: function() {
                console.log('게시물 삭제 실패!');
                // 여기에 실패 시 동작할 코드 작성
                alert("삭제 실패");
            }
        });
    }
}


//커서를 올리면 포인터로 변경
$(".myDiy-card-img, .mb-2").hover(function() {
  $(this).css("cursor", "pointer");
});