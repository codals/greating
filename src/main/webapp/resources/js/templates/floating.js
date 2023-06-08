function toggleBox() {
  var overlay = document.querySelector('.overlay');
  overlay.classList.toggle('show-overlay');
}

function copyLink() {
  var currentUrl = window.location.href;
  navigator.clipboard.writeText(currentUrl).then(function() {
	  Swal.fire({
    	  title: '링크가 복사되었습니다.',
    	  confirmButtonText: '닫기',
    	  icon:'success'
      });
  }, function() {
    alert("링크 복사 실패");
  });
}

function linkYoutube(){
	window.location.href="https://www.youtube.com/@greating";
}