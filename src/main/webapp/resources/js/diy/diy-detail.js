
function updateComment(postId, userId){
	
	var content = $('#update-comment-content').val();
	console.log("content");
	
	 $.ajax({
	      url: "/greating/api/mealdiy/comment-new",
	      data: {
	    	userId : userId ,
	    	postId : postId,
	    	content: content
	      },
	      type: "POST",
	      success: function(response) {
	    	  Swal.fire({
	        	  title: '댓글 입력이 완료되었습니다!',
	        	  confirmButtonText: '닫기'
	          });
	    	  createCommentBox(response);
	      },
	      error: function(xhr, status, error) {
	      }
	    });
	
}
function createCommentBox(response){
	  var updateCommentCollapse = document.getElementById('updateComment');
	  var updateCommentBtn = document.getElementById('updateCommentOpenBtn');
	  updateCommentCollapse.classList.remove('show');
	  updateCommentBtn.setAttribute('aria-expanded', 'false');
	  
	  var commentElement = createCommentElement(response);

	  $('.tab2-comments').prepend(commentElement);
	
}


function createCommentElement(comment) {
  var currentDate = new Date();
  var createdDate = getCommentUpdateTime(currentDate);

  var commentElement = document.createElement('div');
  commentElement.classList.add('tab2-comment');

  var commentHeader = document.createElement('div');
  commentHeader.classList.add('tab2-comment-header');
  
  var commentHeaderText = document.createElement('div');
  commentHeaderText.classList.add('tab2-comment-text');

  var authorSpan = document.createElement('span');
  authorSpan.textContent = '작성자: ' + comment.username + ' | ';
  commentHeaderText.appendChild(authorSpan);

  var createdAtSpan = document.createElement('span');
  createdAtSpan.classList.add('comment-createdAt');
  createdAtSpan.textContent = createdDate;
  commentHeaderText.appendChild(createdAtSpan);
  
  commentHeader.appendChild(commentHeaderText);

  var btnsDiv = document.createElement('div');
  btnsDiv.classList.add('btns');

  var editButton = document.createElement('button');
  editButton.classList.add('tab2-comment-reupload');
  editButton.textContent = '수정';
  editButton.setAttribute('onclick', 'enableCommentEdit(this, ' + comment.id + ')');
  btnsDiv.appendChild(editButton);

  var deleteButton = document.createElement('button');
  deleteButton.classList.add('tab2-comment-delete');
  deleteButton.textContent = '삭제';
  deleteButton.setAttribute('onclick', 'checkDeleteComment('+ comment.id + ')');
  btnsDiv.appendChild(deleteButton);

  commentHeader.appendChild(btnsDiv);

  var commentContent = document.createElement('div');
  commentContent.classList.add('tab2-comment-content');

  var textarea = document.createElement('textarea');
  textarea.id = 'comment-' + comment.id;
  textarea.setAttribute('readonly', 'readonly');
  textarea.textContent = comment.content;
  commentContent.appendChild(textarea);

  commentElement.appendChild(commentHeader);
  commentElement.appendChild(commentContent);

  return commentElement;
}
function enableCommentEdit(button,commentId) {
	  var textarea = document.getElementById('comment-' + commentId);

	  if (textarea.hasAttribute('readonly')) {
	    textarea.removeAttribute('readonly');
	    button.innerHTML = '수정완료';
	    button.onclick = function() {
	    	editComment(button,commentId);
	    };
	  } 
}



function editComment(button,commentId) {
		  
	  var content = document.getElementById('comment-' + commentId).value;
  
	  var currentDate = new Date();
	  var commentId = parseInt(commentId);
	  
	    $.ajax({
	      url: "/greating/api/mealdiy/comment-update",
	      data: {
	    	id : commentId ,
	    	content: content,
	      },
	      type: "POST",
	      success: function(response) {
	    	  Swal.fire({
	        	  title: '댓글 수정이 완료되었습니다!',
	        	  confirmButtonText: '닫기'
	          });
	    	  updateCommentBox(button, commentId);
	      },
	      error: function(xhr, status, error) {
	      }
	    });
	}

function updateCommentBox(button,commentId){
	var textarea = document.getElementById('comment-' + commentId);
    var createdAtElement = document.querySelector('.comment-createdAt');
    
    var currentDate = new Date();
    
    createdAtElement.innerHTML = getCommentUpdateTime(currentDate);
	textarea.setAttribute('readonly', 'readonly');
    button.innerHTML = '수정';
    button.onclick = function() {
    	enableCommentEdit(button, commentId);
    };
}
function getCommentUpdateTime(currentDate){
	var options = {
			  year: 'numeric',
			  month: '2-digit',
			  day: '2-digit',
			  hour: '2-digit',
			  minute: '2-digit',
			  second: '2-digit',
			  hour12: false
			};

			var formattedDate = currentDate.toLocaleString('en-US', options).replace(/\//g, '-').replace(/[,]/g, '');

			console.log(formattedDate);
			return formattedDate;
}
function fetchChartData(){

	var postId = $('.postId').text();
	console.log(postId)

	fetch('/greating/api/mealdiy/statics?postId='+postId, {
		  method: 'GET',
		 
		})
		.then(function(response) {
		  if (response.ok) {
			  console.log(response);
		    return response.json();
		  } else {
		    throw new Error('Error: ' + response.status);
		  }
		})
		.then(function(data) {
		  
		  // 남/ 녀 투표 비율
		  new Chart(document.getElementById("vote-gender-chart"), {
			    type: 'doughnut',
			    data: {
			      labels: ["남성","여성"],
			      datasets: [
			        {
			          label: "투표 현황",
			          backgroundColor: ["#918C01", "#D7AC87"],
			          data: [data.maleTotalVoteCount,data.femaleTotalVoteCount]
			        }
			      ]
			    },
			    options: {
			      title: {
			        display: false,
			        text: ''
			      },
			      legend: {
						labels: {
							fontColor: "#000",
							fontSize: 30
						}
					},
			    }
			});
		  
		  // 연령대별 투표 차트
		  new Chart(document.getElementById("vote-ages-chart"), {
			  type: 'bar',
			  data: {
			    labels: ["10대", "20대", "30대", "40대", "50대이상"],
			    datasets: [
			      {
			        label: "남성",
			        backgroundColor: "#918c01",
			        data: [data.male10sVoteCount, data.male20sVoteCount, data.male30sVoteCount, data.male40sVoteCount, data.male50sVoteCount]
			      },
			      {
			        label: "여성",
			        backgroundColor: "#D7AC87",
			        data: [data.female10sVoteCount, data.female20sVoteCount, data.female30sVoteCount, data.female40VoteCount, data.female50sVoteCount]
			      }
			    ]
			  },
			  options: {
			    scales: {
			    	xAxes: [{
						ticks:{
							fontColor : 'rgba(12, 13, 13, 1)',
							fontSize :  40
						},
						gridLines:{
							color: "#918c01",
							lineWidth: 2
						}
					}],
			     yAxes: [{
			        ticks: {
			          stepSize: 1
			        }
			      }]
			    },
			    legend: {
					labels: {
						fontColor: "#000",
						fontSize: 30
					}
				},
			    title: {
			      display: false,
			      text: '투표 현황'
			    }
			  }
			});

		  
		})
		.catch(function(error) {
		  console.error('Error:', error);
		});
}



document.addEventListener("DOMContentLoaded", function() {
	var tabMenuList = document.querySelectorAll(".tab-menu__list");

	
	console.log('tabMenuList', tabMenuList);
	// 각 탭 메뉴 요소에 클릭 이벤트 리스너 추가
	tabMenuList.forEach(function(tab,index) {

		tab.addEventListener("click", function() {
			document.querySelector(".tab-menu__list--on").classList
					.remove("tab-menu__list--on");

			// 클릭한 탭에 활성 탭 스타일 추가
			this.classList.add("tab-menu__list--on");
			
			if(index==1){
				fetchChartData();
			}
			
			
		});
	});
});


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



// 스크랩 js
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
function checkScrap(postId){
	 Swal.fire({
		    title: '해당 DIY 식단을 스크랩하시겠습니까?',
		    showCancelButton: true,
		    confirmButtonText: '스크랩하기',
		  }).then(function(result) {
		    if (result.isConfirmed) {
		      submitScrap(postId)
		        .then(function(response) {
		          Swal.fire({
		        	  title: '스크랩이 완료되었습니다!',
		        	  text: '스크랩된 식단은 마이페이지를 참고하세요',
		        	  confirmButtonText: '돌아가기'
		          });
		        		  
		          updateScrapButton(postId, '스크랩','scrap');
		        })
		        .catch(function(error) {
		          Swal.fire('스크랩 실패하였습니다!', 'error');
		        });
		    }
		  });
}

function submitScrap(postId) {
	  return new Promise(function(resolve, reject) {
	    $.ajax({
    	  url: "/greating/api/mealdiy/scrap",
          type: "POST",
          data: {
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

function checkScrapCancel(postId) {
	  Swal.fire({
	    title: '스크랩을 취소하시겠습니까?',
	    showCancelButton: true,
	    confirmButtonText: '스크랩 취소하기',
	  }).then(function(result) {
	    if (result.isConfirmed) {
	      cancelScrap(postId)
	        .then(function(response) {
	    	 Swal.fire({
	        	  title: '스크랩이 취소되었습니다!',
	        	  confirmButtonText: '돌아가기'
	          });
	          updateScrapButton(postId, '스크랩','cancel');
	        })
	        .catch(function(error) {
	          Swal.fire('취소 실패하였습니다!', 'error');
	        });
	    }
	  });
}
function cancelScrap(postId) {
	  return new Promise(function(resolve, reject) {
	    $.ajax({
	      url: "/greating/api/mealdiy/" + postId + "/scrap",
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


function updateScrapButton(postId, buttonText, status) {
	if(status==='cancel'){
		var voteButton = $('.scrap-button');
		voteButton.find('i').removeClass('fas fa-bookmark').addClass('far fa-bookmark');
		voteButton.find('span').text(buttonText);
		voteButton.attr('onclick', 'checkScrap(' + postId + ')');
	}else{
	    var voteButton = $('.scrap-button');
	    voteButton.find('i').removeClass('far fa-bookmark').addClass('fas fa-bookmark');
	    voteButton.find('span').text(buttonText);
	    voteButton.attr('onclick', 'checkScrapCancel(' + postId + ')');
	}
}

document.addEventListener("DOMContentLoaded", function() {
	  function openUpdateCommentBox() {
	    var checkbox = document.querySelector('input[type="checkbox"]');
	    var commentsContainer = document.getElementById('comments-container');

	    if (checkbox.checked) {
	      commentsContainer.style.display = 'block';
	    } else {
	      commentsContainer.style.display = 'none';
	    }
	  }
	});



























