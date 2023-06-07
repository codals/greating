function approve(postId, button) {
    console.log(postId);
    
    $.ajax({
        url: "/greating/api/admin/approve",
        type: "POST",
        data: { postId: postId },
        success: function(response) {
            console.log("Post status approved!");
            
            // 성공 메시지로 텍스트 업데이트
            $(button).text("승인완료");
            
            // 취소 버튼 생성
         
            
//            var checkCancelButton = $('#cancelButton')
//            console.log(checkCancelButton);
            if ($(button).next('.cancel-button').length === 0) {
            	console.log("test");
            	var cancelButton = $('<button>').addClass('cancel-button').text("취소").click(function() {
                    cancelApproval(postId, button);
                });
                $(button).after(cancelButton);

            }else{

            }
            
            // 취소 버튼 추가
            
            
            
            // 상태를 업데이트하거나 화면을 갱신하는 등의 동작을 수행할 수 있습니다.
        },
        error: function() {
            console.log("Failed to approve post!");
        }
    });
}

function cancelApproval(postId, button) {
    console.log(postId);
    
    $.ajax({
        url: "/greating/api/admin/approveCancel",
        type: "POST",
        data: { postId: postId },
        success: function(response) {
            console.log("Post approval canceled!");
            
            // 성공 메시지로 텍스트 업데이트
            $(button).text("✅");
            
            // 취소 버튼 삭제
            $(button).next().remove();
            
            // 상태를 업데이트하거나 화면을 갱신하는 등의 동작을 수행할 수 있습니다.
        },
        error: function() {
            console.log("Failed to cancel post approval!");
        }
    });
}

function deleteDiet(dietId, button) {
    var confirmation = confirm("식단을 삭제하시겠습니까?");
    let data = {
            'dietId': dietId
    }
    console.log(data);
    if (confirmation) {
        $.ajax({
            url: "/greating/api/admin/deleteDiet",
            type: "POST",
            data: data,
            success: function(response) {
                console.log("Diet deleted successfully!");
                alert("삭제되었습니다.");
                // 해당 행을 삭제
                $(button).closest("tr").remove();
                
                // 삭제 성공 메시지 등 필요한 동작 수행
                
            },
            error: function() {
                console.log("Failed to delete diet!");
            }
        });
    }
}
