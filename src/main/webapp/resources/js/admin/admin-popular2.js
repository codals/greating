function approve(postId, button) {
    console.log(postId);
    
    Swal.fire({
	    title: '해당 인기 DIY 도시락을 반영하시겠습니까?',
	    text: '승인하기 시 해당 DIY 도시락은 출시 예정 식단으로 고려됩니다',
	    showCancelButton: true,
	    confirmButtonText: '승인하기',
	  }).then(function(result) {
	    if (result.isConfirmed) {
	      approvePost(postId)
	        .then(function(response) {
	          Swal.fire({
	        	  title: ' 승인 완료되었습니다!',
	        	  confirmButtonText: '닫기'
	          });
	          $(button).text('승인 취소');
              $(button).attr('id', 'cancelApprovalBtn');
              $(button).removeClass('approve-'+postId);
              $(button).addClass('cancel-approval'+postId);
              $(button).attr('onclick', 'cancelApproval(' + postId + ', this)');
              $(button).closest('tr').find('td span').text('승인 완료');
	        })
	        .catch(function(error) {
	          Swal.fire('승인 실패하였습니다!', 'error');
	        });
	    }
	  });
    
}

function approvePost(postId){
	  return new Promise(function(resolve, reject) {
		  $.ajax({
			    url: "/greating/api/admin/approve",
			    type: "POST",
			    data: { postId: postId },
			    success: function(response) {
			        resolve(response);

			        
			     },
			    error: function() {
			        reject(error);
			    }
			});
		  });

}

function cancelApproval(postId, button) {
    console.log(postId);
    
    Swal.fire({
	    title: '해당 인기 DIY 도시락을 반영(승인)을 취소하시겠습니까?',
	    text: '취소 시 해당 DIY 도시락은 출시 예정 식단에서 삭제됩니다.',
	    showCancelButton: true,
	    confirmButtonText: ' 승인취소하기',
	  }).then(function(result) {
	    if (result.isConfirmed) {
	      cancelApprovePost(postId)
	        .then(function(response) {
	          Swal.fire({
	        	  title: ' 취소 완료 되었습니다!',
	        	  confirmButtonText: '닫기'
	          });
	          
	            $(button).text('승인 하기');
	            $(button).attr('id', 'approveBtn');
	            $(button).removeClass('approve-'+postId);
	            $(button).addClass('approve-'+postId);
	            $(button).attr('onclick', 'approve(' + postId + ', this)');
	            $(button).closest('tr').find('td span').text('승인 대기중');
	        })
	        .catch(function(error) {
	          Swal.fire('승인 취소 실패하였습니다!', 'error');
	        });
	    }
	  });
    
}

function cancelApprovePost(postId){
	  return new Promise(function(resolve, reject) {
		  $.ajax({
		        url: "/greating/api/admin/approveCancel",
		        type: "POST",
		        data: { postId: postId },
		        success: function(response) {
			        resolve(response);
		        },
		        error: function() {
			        reject(error);
		        }
		    });
		  });

}



function deletePost(postId, button) {
    console.log(postId);
    
    Swal.fire({
	    title: '해당 인기 DIY 도시락을 삭제하시겠습니까?',
	    text: '삭제 시 도시락 정보는 모두 삭제됩니다.',
	    showCancelButton: true,
	    confirmButtonText: ' 삭제하기',
	  }).then(function(result) {
	    if (result.isConfirmed) {
	      approveDeletePost(postId)
	        .then(function(response) {
	          Swal.fire({
	        	  title: ' 삭제 완료 되었습니다!',
	        	  confirmButtonText: '닫기'
	          });
	          $(button).closest("tr").remove();
	          })
	        .catch(function(error) {
	          Swal.fire('승인 취소 실패하였습니다!', 'error');
	        });
	    }
	  });
    
}


function approveDeletePost(postId) {
	  return new Promise(function(resolve, reject) {
		  $.ajax({
		        url: "/greating/api/admin/"+postId,
		        type: "DELETE",
		        success: function(response) {
			        resolve(response);
		        },
		        error: function() {
			        reject(error);
		        }
		    });
		  });

}
