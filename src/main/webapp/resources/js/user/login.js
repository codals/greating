$(document).ready(function () {
  $('.login-btn').click(function () {
    const username = $('#username').val();
    const password = $('#password').val();

    const data = {
      username: username,
      password: password,
    };

    $.ajax({
      url: '/greating/api/login',
      type: 'POST',
      dataType: 'json',
      contentType: 'application/json',
      async: false,
      data: JSON.stringify(data),
      success: function (response) {
        if (response) {
          location.href = 'http://localhost:8080/greating';
        } else {
          alert("로그인 실패");
        }
      },
      error: function () {
        alert("통신 실패");
      }
    });
  });
});
