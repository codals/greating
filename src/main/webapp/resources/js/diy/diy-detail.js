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

// 투표 관련 js
function checkVote(postId){
	 Swal.fire({
		    title: '투표 하시겠습니까?',
		    showCancelButton: true,
		    confirmButtonText: '투표하기',
		  }).then(function(result) {
		    if (result.isConfirmed) {
		      submitVote(postId)
		        .then(function(response) {
		          Swal.fire({
		        	  title: '투표완료되었습니다!',
		        	  confirmButtonText: '돌아가기'
		          });
		        		  
		          updateVoteButton(postId, '투표완료','vote');
		        })
		        .catch(function(error) {
		          Swal.fire('투표 실패하였습니다!', 'error');
		        });
		    }
		  });
}

function submitVote(postId) {
	  return new Promise(function(resolve, reject) {
	    $.ajax({
	      url: "/greating/api/mealdiy/vote",
	      data:{
	    	  postId: postId
	      },
	      type: "POST",
	      success: function(response) {
	        resolve(response);
	      },
	      error: function(xhr, status, error) {
	        reject(error);
	      }
	    });
	  });
	}



function checkVoteCancel(postId) {
  Swal.fire({
    title: '투표 취소하시겠습니까?',
    showCancelButton: true,
    confirmButtonText: '투표 취소하기',
  }).then(function(result) {
    if (result.isConfirmed) {
      cancelVote(postId)
        .then(function(response) {
    	 Swal.fire({
        	  title: '투표가 취소되었습니다!',
        	  confirmButtonText: '돌아가기'
          });
          updateVoteButton(postId, '투표하기','cancel');
        })
        .catch(function(error) {
          Swal.fire('취소 실패하였습니다!', 'error');
        });
    }
  });
}

function cancelVote(postId) {
  return new Promise(function(resolve, reject) {
    $.ajax({
      url: "/greating/api/mealdiy/" + postId + "/vote",
      type: "DELETE",
      success: function(response) {
        resolve(response);
      },
      error: function(xhr, status, error) {
        reject(error);
      }
    });
  });
}

function updateVoteButton(postId, buttonText, status) {
	if(status==='cancel'){
		var voteCountElement = $('.vote-count');
		var voteCount = parseInt(voteCountElement.text());
		if (!isNaN(voteCount)) {
		  voteCountElement.text(voteCount - 1);
		}
		var voteButton = $('.vote-button');
		voteButton.find('i').removeClass('fas fa-thumbs-up').addClass('far fa-thumbs-up');
		voteButton.find('span').text(buttonText);
		voteButton.attr('onclick', 'checkVote(' + postId + ')');
	}else{
		var voteCountElement = $('.vote-count');
		var voteCount = parseInt(voteCountElement.text());
		if (!isNaN(voteCount)) {
		  voteCountElement.text(voteCount + 1);
		}
	    var voteButton = $('.vote-button');
	    voteButton.find('i').removeClass('far fa-thumbs-up').addClass('fas fa-thumbs-up');
	    voteButton.find('span').text(buttonText);
	    voteButton.attr('onclick', 'checkVoteCancel(' + postId + ')');
	}
}
