function approve(postId, button) {
	
	
	console.log(postId);
	
	$.ajax({
        url: "/greating/api/admin/approve",
        type: "POST",
        data: { postId: postId },
        success: function(response) {
            // 요청이 성공하면 처리할 코드를 작성합니다.
        		console.log("Post status approved!");
//        		e.target.closest('td .approve').html("성공");
//        		button.innerText = "성공";
        		 $(button).text("성공 ");
        	
            // 상태를 업데이트하거나 화면을 갱신하는 등의 동작을 수행할 수 있습니다.
        },
        error: function() {
            // 요청이 실패하면 처리할 코드를 작성합니다.
            console.log("Failed to approve post!");
        }
    });
}
    