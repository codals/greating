

var floatingButton = document.getElementById("floating-button");

var initialOffset = floatingButton.offsetTop;

window.addEventListener("scroll", function() {
  var scrollPosition = window.scrollY;

  if (scrollPosition > initialOffset) {
    floatingButton.style.transform = "translateY(-50px)";
  } else {
    floatingButton.style.transform = "translateY(0)";
  }
});

function share(postId, kakaoShareKey) {
	var postTitle = $('.title-text').text();
	var imgUrl = $('.main-img img').attr('src');	
	var voteCnt = parseInt($('.vote-count').text());
	

	if (!Kakao.isInitialized()) {
		  Kakao.init(kakaoShareKey);
	}
	Kakao.Link
			.sendDefault({
				objectType : 'feed',
				content : {
					title : postTitle,
					description : '#현대 그린푸드 #코달이 # DIY 식단',
					imageUrl : imgUrl,
					link : {
						mobileWebUrl : 'http://localhost:8080/greating/mealdiy/'+postId,
						webUrl : 'http://localhost:8080/greating/mealdiy/'+postId,
					},
				},
				social : {
					likeCount : voteCnt,
					commentCount : 45,
					sharedCount : 845,
				},
				buttons : [ {
					title : '게시물 보기',
					link : {
						mobileWebUrl : 'http://localhost:8080/greating/mealdiy/'+postId,
						webUrl : 'http://localhost:8080/greating/mealdiy/'+postId,
					},
				} ],
			});
}