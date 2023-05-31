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

function scrap(postId, userId){

	 $.ajax({
	        url: "/greating/api/mealdiy/scrap",
	        type: "POST",
	        data: {
	            postId: postId,
	            userId: userId
	        },
	        success: function(response) {
	            alert('스크랩 완료되었습니다. 마이페이지를 확인해주세요.');
	        },
	        error: function(xhr, status, error) {
	            console.log("Vote failed:", error);
	            alert('스크에 실패하였습니다! 관리자에게 문의해주세요');

	        }
	    });
	 
}