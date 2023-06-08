function getHmCtgryList(){

	fnAjax({
        url : '/biz/market/getHmCtgryList'
        ,params : {IL_CTGRY_ID : 2139}
        ,success : function (data){

			if( data.CTGRY_INFO == null ){
                return;
            }

			// 2뎁스 카테고리 바인드
			var html = [];
			var subHtml = [];
			$.each(data.TitleCtgryList, function(i, item){
				html.push('<li class="submenu__list" id="cate_slide_id_' + item.IL_CTGRY_ID + '">');
				html.push('	<a href="/market/marketList?ctgryId=' + item.IL_CTGRY_ID + '" class="submenu__list-name">' + item.CTGRY_NAME + '</a>');
				html.push('</li>');

				subHtml.push('<li class="box__list"><a href="/market/marketList?ctgryId=' + item.IL_CTGRY_ID + '">' + item.CTGRY_NAME + '</a></li>');
			});

			$('#dvMainHmCtgryList').html(html.join(' '));
			//$('#dvMainHmSubCtgryList').html(subHtml.join(' '));
        }
	});
}

document.addEventListener('DOMContentLoaded', function() {
	  // 스크립트 코드 작성
	});

document.addEventListener('DOMContentLoaded', function() {
    var categoryLink = document.querySelector("#careHeadCategory .L-Affiliate-Tagged");
    var categoryMenu = document.querySelector("#careHeadCategory .all-menu");

    if (categoryLink && categoryMenu) {
        categoryLink.addEventListener("click", function(event) {
            event.preventDefault();
            categoryMenu.style.display = categoryMenu.style.display === "none" ? "block" : "none";
        });
    }
});

$(document).ready(function () {
  $(".admin-page").click(function () {
    location.href = '/greating/admin/popular';
  });
});

function logout() {
    Swal.fire({
        title: '로그아웃하시겠습니까?',
        showCancelButton: true,
        confirmButtonText: '로그아웃',
        cancelButtonText: '취소'
    }).then(function(result) {
        if (result.isConfirmed) {
            Swal.fire({
                title: '로그아웃되었습니다.',
                confirmButtonText: '닫기'
            }).then(function() {
                window.location.href = "/greating/logout";
            });
        }
    });
}