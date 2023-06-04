function toggleBox() {
  var overlay = document.querySelector('.overlay');
  overlay.classList.toggle('show-overlay');
}

function copyLink() {
  var currentUrl = window.location.href;
  navigator.clipboard.writeText(currentUrl).then(function() {
    alert("링크가 복사되었습니다!");
  }, function() {
    alert("링크 복사 실패");
  });
}