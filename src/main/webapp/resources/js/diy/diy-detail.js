document.addEventListener("DOMContentLoaded", function() {
	var tabMenuList = document.querySelectorAll(".tab-menu__list");

	// 각 탭 메뉴 요소에 클릭 이벤트 리스너 추가
	tabMenuList.forEach(function(tab) {
		tab.addEventListener("click", function() {
			// 현재 활성 탭 스타일 제거
			document.querySelector(".tab-menu__list--on").classList
					.remove("tab-menu__list--on");

			// 클릭한 탭에 활성 탭 스타일 추가
			this.classList.add("tab-menu__list--on");
		});
	});
});


function vote(postId){
	 $.ajax({
	        url: "/greating/api/mealdiy/vote",
	        type: "POST",
	        data: {
	            postId: postId,
	            userId: userId
	        },
	        success: function(response) {
	            alert('투표 완료되었습니다. 마이페이지를 확인해주세요.');
	        },
	        error: function(xhr, status, error) {
	            alert('투표에 실패하였습니다! 관리자에게 문의해주세요');
	        }
	    });
}

function cancelVote(postId){
	 $.ajax({
	        url: "/greating/api/mealdiy/"+postId+"/vote" ,
	        type: "DELETE",
	        success: function(response) {
	            alert('투표취소 되었습니다.');
	        },
	        error: function(xhr, status, error) {
	            alert('투표 취소에 실패하였습니다! 관리자에게 문의해주세요');
	        }
	    });
}






