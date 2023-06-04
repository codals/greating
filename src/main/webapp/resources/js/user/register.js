$(document).ready(function() {
	// right-button 클릭 이벤트 처리
	$('.right-button').click(function(e) {
		var allChecked = true;

		// 모든 input 체크박스 검사
		$('input[type="checkbox"]').each(function() {
			if (!$(this).is(':checked')) {
				allChecked = false;
				return false; // 반복문 종료
			}
		});

		// 모든 체크박스가 체크되지 않은 경우
		if (!allChecked) {
			e.preventDefault(); // 기본 동작(링크 이동) 막기
			alert('약관에 동의해야 회원가입이 가능합니다.');
		} else {
			location.href = '/greating/register-form';
		}

	});
});

// username input에 6자리 이상의 영문 혹은 영문자 + 숫자 조합인지 확인
$(document).ready(
		function() {
			var usernameInput = $('#username');

			// 입력 필드의 값이 변경될 때마다 validateUsername 함수 호출
			usernameInput.on('input', validateUsername);

			// validateUsername 함수
			function validateUsername() {
				var username = usernameInput.val();

				// 정규식을 사용하여 조건을 확인
				var pattern = /^(?=.*[a-zA-Z])[a-zA-Z\d]{6,}$/;
				var isValid = pattern.test(username);

				// 결과를 출력
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
				// 중복 체크 다시 하도록!
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
	    	  alert('회원가입에 성공하였습니다. ');
	    	  window.location.href='/greating/login';
	      },
	      error: function(response) {
	    	  alert('회원가입에 실패하였습니다.');
	      }
	    });
	
}


