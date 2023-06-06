function approve(postId, button) {
    console.log(postId);

    var confirmation = confirm("DIY식단을 정식 식단으로 등록하시겠습니까?");
    if (confirmation) {
        $.when(
            $.ajax({
                url: "/greating/api/admin/approveDiy",
                type: "POST",
                data: { 'postId': postId },
                success: function(response) {
                    console.log("Post status approved!");

                    // 성공 메시지로 텍스트 업데이트
                    $(button).text("식단 등록 성공");

                    // 취소 버튼 생성
                    if ($(button).next('.cancel-button').length === 0) {
                        console.log("test");
                        var cancelButton = $('<button>').addClass('cancel-button').text("취소").click(function() {
                            cancelApproval(postId, button);
                        });
                        $(button).after(cancelButton);
                    }
                },
                error: function() {
                    console.log("Failed to approve post!");
                }
            }),

            $.ajax({
                url: "/greating/api/admin/registerDiy",
                type: "POST",
                data: { 'postId': postId },
                success: function(response) {
                    console.log("DIY식단 등록 성공!");
                    // 여기에 성공 시 동작할 코드 작성
                    // 예를 들어, 화면 갱신이나 다른 동작을 수행할 수 있습니다.
                },
                error: function() {
                    console.log("DIY식단 등록 실패!");
                    // 여기에 실패 시 동작할 코드 작성
                }
            })
        ).done(function() {
            console.log("Both requests completed successfully!");
        }).fail(function() {
            console.log("At least one request failed!");
        });
    }
}


function cancelApproval(postId, button) {
    console.log(postId);
    
    $.ajax({
        url: "/greating/api/admin/approveDiyCancel",
        type: "POST",
        data: { 'postId': postId },
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
