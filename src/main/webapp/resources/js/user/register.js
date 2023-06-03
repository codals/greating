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
    }else{
    	location.href='/greating/register-form';
    }
 
  });
});



function submitRegisterForm(e){
	e.preventDefault(); // 기본 동작(폼 전송) 막기
	  console.log("testing")
	    // 여기에 추가적인 검사 로직을 작성하세요
	    // 필요한 검사를 수행하고 문제가 있으면 폼 전송을 막고 에러 메시지를 표시할 수 있습니다.
 // 여기에 추가적인 검사 로직을 작성하세요
    // 필요한 검사를 수행하고 문제가 있으면 폼 전송을 막고 에러 메시지를 표시할 수 있습니다.
    
    // 폼 전송
    var form = $('form')[0];
    if (form.checkValidity()) {
      form.submit(); // 폼 전송
    } else {
     
    	alert('회원정보 입력을 해주세요 ');
    }
	
}



