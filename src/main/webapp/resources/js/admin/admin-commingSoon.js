function approve(postId, button) {
	console.log(postId);

	var confirmation = confirm("DIY식단을 정식 식단으로 등록하시겠습니까?");
	if (confirmation) {
		$.when(
				$.ajax({
					url : "/greating/api/admin/approveDiy",
					type : "POST",
					data : {
						'postId' : postId
					},
					success : function(response) {
						console.log("Post status approved!");

						// 성공 메시지로 텍스트 업데이트
						$(button).text("식단 등록 성공");

						// 취소 버튼 생성
						if ($(button).next('.cancel-button').length === 0) {
							console.log("test");
							var cancelButton = $('<button>').addClass(
									'cancel-button').text("취소").click(
									function() {
										cancelApproval(postId, button);
									});
							$(button).after(cancelButton);
						}
					},
					error : function() {
						console.log("Failed to approve post!");
					}
				}),

				$.ajax({
					url : "/greating/api/admin/registerDiy",
					type : "POST",
					data : {
						'postId' : postId
					},
					success : function(response) {
						console.log("DIY식단 등록 성공!");

						// 가격 입력 요소 생성
						var priceInputText = $('<span>').text("가격을 입력하세요:");
						var priceInput = $('<input>').attr('type', 'text')
								.attr('id', 'priceInput');
						var submitButton = $('<button>').text("전송").click(
								function() {
									var price = $('#priceInput').val();
									submitPrice(postId, price);
								});

						// 가격 입력 요소 추가
						$(button).after(priceInputText, priceInput,
								submitButton);
					},
					error : function() {
						console.log("DIY식단 등록 실패!");
					}
				})).done(function() {
			console.log("Both requests completed successfully!");
		}).fail(function() {
			console.log("At least one request failed!");
		});
	}
}

function submitPrice(postId, price) {
	$.ajax({
		url : "/greating/api/admin/submitPrice",
		type : "POST",
		data : {
			'postId' : postId,
			'price' : price
		},
		success : function(response) {
			console.log("Price submitted successfully!");
			// 동작 완료 메시지로 텍스트 업데이트
			$('#priceInput').next('span').text("가격이 전송되었습니다.");

			// priceInputText와 priceInput 제거
			$('#priceInput').nextAll('span, input').remove();

			// submitButton 제거
			$('#priceInput').next('button').remove();

			$(submitButton).remove();
			// 예를 들어, 화면 갱신이나 다른 동작을 수행할 수 있습니다.
		},
		error : function() {
			console.log("Failed to submit price!");
		}
	});
}

function cancelApproval(postId, button) {
	var confirmation = confirm("등록한 식단을 취소하시겠습니까?");
	if (confirmation) {
		$.ajax({
			url : "/greating/api/admin/approveDiyCancel",
			type : "POST",
			data : {
				'postId' : postId
			},
			success : function(response) {
				console.log("Post approval canceled!");

				// 성공 메시지로 텍스트 업데이트
				$(button).text("승인");

				// 취소 버튼 삭제
				$(button).next().remove();

				// 상태를 업데이트하거나 화면을 갱신하는 등의 동작을 수행할 수 있습니다.
			},
			error : function() {
				console.log("Failed to cancel post approval!");
			}
		});
	}
}
