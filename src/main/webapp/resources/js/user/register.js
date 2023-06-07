$(document).ready(function() {
	
	// 전체 약관동의 버튼 
	const allCheck = document.querySelector('.all-check');
	
	// 하위 약관동의 버튼 
	const checkboxes = document.querySelectorAll('.checkbox-container input[type="checkbox"]');

	function handleAllCheck() {

	  checkboxes.forEach(checkbox => {
	    checkbox.checked = allCheck.checked;
	  });
	}
	// 전체 약관동의 버튼과 하위 약관동의 버튼 같게 설정
	allCheck.addEventListener('change', handleAllCheck);
	
		const aggrementCheckBoxes = document.querySelectorAll('.agreement-check');

	// 하위 약관 동의 체크박스의 변경 이벤트를 처리 ( 전체 약관 동의 해제 ) 
	function handleAggrementCheckBoxes() {
	  const isAnyUnchecked = Array.from(aggrementCheckBoxes).some(checkbox => !checkbox.checked);

	  allCheck.checked = !isAnyUnchecked;
	}

	allCheck.addEventListener('change', handleAllCheck);

	aggrementCheckBoxes.forEach(checkbox => {
	  checkbox.addEventListener('change', handleAggrementCheckBoxes);
	});
	

	// 약관동의 다음페이지로 넘어가기 전 약관동의 여부 검사
	$('.right-button').click(function(e) {
		var allChecked = true;

		$('.must-check').each(function() {
			if (!$(this).is(':checked')) {
				allChecked = false;
				return false; // 반복문 종료
			}
		});

		if (!allChecked) {
			e.preventDefault(); 
			 Swal.fire({
	        	  title: '약관동의를 다시 확인해주세요!',
	        	  confirmButtonText: '닫기'
	          });
		} else {
			location.href = '/greating/register-form';
		}

	});
});

// username input에 6자리 이상의 영문 혹은 영문자 + 숫자 조합인지 확인
$(document).ready(
		function() {
			var usernameInput = $('#username');

			usernameInput.on('input', validateUsername);

			function validateUsername() {
				var username = usernameInput.val();

				var pattern = /^(?=.*[a-zA-Z])[a-zA-Z\d]{6,}$/;
				var isValid = pattern.test(username);

				var validationSpan = $('#username-validation');
				validationSpan.text(isValid ? '올바른 형식입니다.'
						: '6자리 이상 영문 혹은 영문 숫자 조합이어야 합니다.');

				if (isValid) {
					var userNameValidation = $('.userNameValidation');
					userNameValidation.prop('checked', true);

				} else {
					var userNameValidation = $('.userNameValidation');
					userNameValidation.prop('checked', false);
				}
				var userDuplicateCheck = $('.userNameCheckResult');
				userDuplicateCheck.prop('checked', false);

			}
		});

// 아이디 중복 확인
function checkValidateUserName() {
	var usernameInput = $('#username');
	var resultSpan = $('#overlapCheckResult');
	var userNameValidation = $('.userNameValidation');
	var userNameCheckResult = $('.userNameCheckResult');

	var username = usernameInput.val();

	if (!userNameValidation.is(":checked")) {
		alert('아이디는 영문자 또는 영문자/ 숫자 조합으로 6자리 이상 입력해주세요. ');
		return;

	}
	$.ajax({
				url : '/greating/api/check-username?username=' + username,
				method : 'GET',
				success : function(response) {
					// 결과값을 저장
					var isValid = response;
					var validationSpan = $('#username-validation');

				
					if (isValid) {
						validationSpan.text('사용가능한 아이디입니다.');
						userNameCheckResult.prop('checked', true);
					} else {
						// 실패한 경우 체크박스 체크 해제
						validationSpan.text('이미 존재하는 아이디입니다.');
						userNameCheckResult.prop('checked', false);
					}

				},
				error : function() {
					console.log('중복확인 요청 실패');
				}
			});
}

// 비밀번호 유효성 확인 
$(document).ready(function() {
	  var passwordInput = $('#password');

	  // 입력 필드의 값이 변경될 때마다 validatePassword 함수 호출
	  passwordInput.on('input', validatePassword);

	  // validatePassword 함수
	  function validatePassword() {
	    var password = passwordInput.val();

	    var pattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()])[a-zA-Z\d!@#$%^&*()]{8,}$/;
	    var isValid = pattern.test(password);

	    var validationSpan = $('#password-validation');
	    validationSpan.text(isValid ? '올바른 형식입니다.' : '8자리 이상, 영문, 숫자, 특수문자 중 3개 이상 조합이어야 합니다.');

	    var userPasswordValidation = $('.userPasswordValidation');
	    if (isValid) {
	    	userPasswordValidation.prop('checked', true);
		} else {
			userPasswordValidation.prop('checked', false);
		}

	  }
	});

// 비밀번호 확인란 확인! 
$(document).ready(function(){
	
	var passwordDoubleCheck = $('#confirm-password');
	
	passwordDoubleCheck.on('input', doubleCheckPassword);

	function doubleCheckPassword(){
		var passwordInput =  $('#password').val();
		console.log("password" , passwordInput);

		var passwordDoubleCheckInput  = passwordDoubleCheck.val();
	    var userPasswordSame = $('.userPasswordSame');

	    var validationSpan = $('#password-same-result');

		if(passwordDoubleCheckInput=== passwordInput){
			userPasswordSame.prop('checked', true);
			validationSpan.text('비밀번호가 일치합니다.');

		}else{
			userPasswordSame.prop('checked', false);
			validationSpan.text('비밀번호가 일치하지 않습니다.');

		}
	}
	
});


// 이메일 중복 확인!! 
function checkValidateUserEmail() {
	var userEmailInput = $('#email');
	var resultSpan = $('#email-check-result');
	var userEmailCheckResult = $('.userEmailCheckResult');

	var useremail = userEmailInput.val();
	var pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	var isValid = pattern.test(useremail);

	if(!isValid){
		alert('유효하지 않은 이메일 형식 입니다. !');
		return;
	}
	$.ajax({
				url : '/greating/api/check-email?email=' + useremail,
				method : 'GET',
				success : function(response) {
					
					var isValid = response;
					var validationSpan = $('#email-check-result');

				
					if (isValid) {
						validationSpan.text('사용가능한 이메일입니다.');
						userEmailCheckResult.prop('checked', true);
					} else {
						// 실패한 경우 체크박스 체크 해제
						validationSpan.text('이미 존재하는 이메일입니다.');
						userEmailCheckResult.prop('checked', false);
					}

				},
				error : function() {
					console.log('중복확인 요청 실패');
				}
			});
}





function submitRegisterForm(e) {
	e.preventDefault();

	var form = $('form')[0];

	// username 유효한 문자인지 확인
	var userNameValidation = $('.userNameValidation');

	// username 중복확인이 되었는 지 확인
	var userNameCheckResult = $('.userNameCheckResult');
	
	// 비밀번호 확인란 맞는지 확인 
	var userPasswordSame = $('.userPasswordSame');
	// 비밀번호 유효성 확인
	var userPasswordValidation = $('.userPasswordValidation');
	
	// 이메일 확인 
	var userEmailCheckResult = $('.userEmailCheckResult');

	if (!userNameValidation.is(":checked")) {
		alert('아이디는 6자리 이상 영문 혹은 영문자와 숫자 조합으로 이루어져야 합니다. ');
		return;
	}
	if (!userNameCheckResult.is(':checked')) {
		alert('아이디 중복 확인을 해주세요.');
		return;
	}
	if(!userPasswordValidation.is(':checked')){
		alert('비밀번호형식이 유효하지 않습니다. ');
		return;
	}
	if(!userPasswordSame.is(':checked')){
		alert('비밀번호가 동일하지 않습니다. ');
		return;
	}
	if(!userEmailCheckResult.is(':checked')){
		alert('이메일이 유효하지 않습니다. ');
		return;
	}
	
	var formData = new FormData(form);

	$.ajax({
	      url: '/greating/api/register', // 서버 엔드포인트 설정
	      method: 'POST', // HTTP 메소드 설정
	      data: formData, // 폼 데,이터 전달
	      processData : false,
	      contentType : false,
	      success: function(response) {
	    	  Swal.fire({
	        	  title: '회원가입이 완료되었습니다!',
	        	  text: '🌱 Greating과 함께해주셔서 감사합니다.🌱',
	        	  confirmButtonText: '로그인 페이지로'
	          }).then((result) => {
	        	  if (result.isConfirmed) {
	        		    window.location.href = '/greating/login';
	        		  }
	        		}); 	  
	      },
	      error: function(response) {
	    	  alert('회원가입에 실패하였습니다.');
	      }
	    });
	
}


