
function approveToDiet(postId, button){
    
	Swal.fire({
		  title: '해당 도시락을 판매 상품으로 등록하시겠습니까? ',
		  text: '등록시 판매 상품으로 반영됩니다. ',
		  html:  `<p>판매하고자 하는 금액을 입력해주세요</p>
			    <input type="text" id="price" class="swal2-input">
			  `,
		  showCloseButton: true,
		  showCancelButton: true,
		  showConfirmButton: true,
		  cancelButtonText: '닫기',
		  confirmButtonText: 'OK',
		  preConfirm: () => {
			    return document.getElementById('price').value;
		   }
		}).then((result) => {
		  if (result.isConfirmed) {
			    const price = result.value
			    console.log(price);
			    approvePostToDiet(postId,price)
		        .then(function(response) {
		          Swal.fire({
		        	  title: ' 상품 등록이 완료되었습니다!',
		        	  confirmButtonText: '닫기'
		          });
		          $(button).text('등록 취소');
	              $(button).attr('id', 'cancelDiet');
	              $(button).removeClass('approve-to-diet-'+postId);
	              $(button).addClass('cancel-diet-'+postId);
	              $(button).attr('onclick', 'cancelDiet(' + postId + ', this)');
	              $(button).closest('tr').find('td span').text('상품 등록됨');
		        })
		        .catch(function(error) {
		          Swal.fire('승인 실패하였습니다!', 'error');
		        });
			    
		    // OK 버튼이 클릭된 경우 처리할 로직 작성
		  } else if (result.isDismissed) {
		    // 닫기 버튼이 클릭된 경우 처리할 로직 작성
		  }
		});
}
function approvePostToDiet(postId, price){
	  return new Promise(function(resolve, reject) {
			$.ajax({
			    url: '/greating/api/admin/diytodiet',
			    method: 'POST',
			    data: {
			        postId: postId,
			        price: price
			    },
			    success: function (response) {
			        resolve(response);
			        // 출시됨으로 바꾸고 취소 버튼으로 바꾸기
			    },
			    error: function (error) {
			        // Handle error case
			        reject(error);
			    }
			});
	  });

}




function cancelDiet(postId, button){
    console.log(postId);
	Swal.fire({
		  title: '등록된 상품을 삭제하시겠습니까? ',
		  text: '등록 삭제 시 DIY 출시 고려 상품으로 변경됩니다. ',

		  showCloseButton: true,
		  showCancelButton: true,
		  showConfirmButton: true,
		  cancelButtonText: '닫기',
		  confirmButtonText: 'OK',
		}).then((result) => {
			  if (result.isConfirmed) {
				  cancelApproval(postId)
			        .then(function(response) {
			          Swal.fire({
			        	  title: ' 상품 등록 취소가 완료되었습니다!',
			        	  confirmButtonText: '닫기'
			          });
			          $(button).text('상품등록');
		              $(button).attr('id', 'diyToDietBtn');
		              $(button).removeClass('cancel-diet-'+postId);
		              $(button).addClass('apprrove-to-diet-'+postId);
		              $(button).attr('onclick', 'approveToDiet(' + postId + ', this)');
		              $(button).closest('tr').find('td span').text('출시 고려중');
			        })
			        .catch(function(error) {
			          Swal.fire('승인 실패하였습니다!', 'error');
			        });
				    
			    // OK 버튼이 클릭된 경우 처리할 로직 작성
			  } else if (result.isDismissed) {
			    // 닫기 버튼이 클릭된 경우 처리할 로직 작성
			  }
			});
			
		
}




function cancelApproval(postId) {
	return new Promise(function(resolve, reject) {
		$.ajax({
		    url: '/greating/api/admin/cancel-diet',
		    method: 'POST',
		    data: {
		        postId: postId,
		    },
		    success: function (response) {
		        resolve(response);
		    },
		    error: function (error) {
		        // Handle error case
		        reject(error);
		    }
		});
  });
}
