
function openSearchBox() {
  var searchContainer = $('.search-container');
  
  if (searchContainer.css('display') === 'none') {
    searchContainer.css('display', 'block');
  } else {
    searchContainer.css('display', 'none');
  }
}

function search(page){
		
	// 이전 pagination 제거
    var paginationContainer = document.getElementById("paginationContainer");
    paginationContainer.innerHTML = "";
	
	// 이전 pagination 제거
    var paginationContainer = document.getElementById("paginationContainer");
    paginationContainer.innerHTML = "";
	
	let mainCategories = [];
	let foodCountries = [];
	let hasRice;
	let hasSoup;
	
	 $("input[name='category']:checked").each(function() {
		 mainCategories.push($(this).val());
	    });
	 
	 $("input[name='country']:checked").each(function() {
		 foodCountries.push($(this).val());
	  });
	 
	  let riceRadioValue = $("input[name='rice-tf']:checked").val();
	  if (riceRadioValue === "y") {
	    hasRice = 1;
	  } else if (riceRadioValue === "n") {
	    hasRice = 0;
	  }
	  
	  let soupRadioValue = $("input[name='soup-tf']:checked").val();
	  if (soupRadioValue === "y") {
	    hasSoup = 1;
	  } else if (soupRadioValue === "n") {
	    hasSoup = 0;
	  }
	 
	 queryParams ='';
	 if (mainCategories.length !== 0) {
		
		    queryParams += "mainCategories=" + encodeURIComponent(mainCategories.join(",")) + "&";
	 }

	 if (foodCountries.length !== 0) {
		    queryParams += "foodCountries=" + encodeURIComponent(foodCountries.join(",")) + "&";
	 }

	 if (typeof hasRice !== "undefined") {
		    queryParams += "hasRice=" + encodeURIComponent(hasRice) + "&";
	 } 
	 if (typeof hasSoup !== "undefined") {
		    queryParams += "hasSoup=" + encodeURIComponent(hasSoup) + "&";
	 }

	 queryParams = queryParams.slice(0, -1);
	 
	 var url = "/greating/api/mealdiy/search?" + queryParams;
	 if (page) {
		 if (queryParams == "") {
			 url += "?page=" + page;
		 } else {
			 url += "&page=" + page;
		 }
	 }
	 
	 $.ajax({
	        url: url,
	        type: "get",
	        success: function(response) {
	        	var data = response;
	        	console.log(data);
	        	if(data.length ===0 ){
	        		$('.search-container').css('display','none');

	        		Swal.fire({
			        	  title: '검색 결과가 없습니다! ',
			        	  confirmButtonText: '닫기'
			        });
	        		return;
	        	}
	        	updateSearchResultBox(data);
	        	Swal.fire({
		        	  title: '검색이 완료되었습니다.!',
		        	  confirmButtonText: '닫기'
		        });
	        
	        },
	        error: function(xhr, status, error) {
	            alert('검색 실패하였습니다. ');

	        }
	    });
}

function updateSearchResultBox(data){
	
	console.log(data)
	$('.search-container').css('display','none');
	
	var defaultTitle = $("#default-title");
	defaultTitle.empty();
	defaultTitle.append('<h3 style="font-weight: bold;">검색 결과</h3>');
	
	var dietCardList = $('.diet-card-list');
	dietCardList.empty(); 
	
	var posts = data.posts.slice(0, 9); // 처음 12개만 선택
	console.log("posts=", posts)
	
	posts.forEach(function(item){
		   var dietCard = $('<div class="col-4 diet-card"></div>');
		    
		    var dietCardImg = $('<div class="diet-card-img"></div>');
		    var imgSrc = item.imgUrl;
		    var img = $('<img>').attr('src', imgSrc);
		    dietCardImg.append(img);
		    
		    var dietCardInfo = $('<div class="diet-card-info"></div>');
		    var subInfo = $('<div class="diet-card-sub-info"></div>');
		    var title = $('<span>').append($('<a>').attr('href', '/greating/mealdiy/' + item.id).css('color', 'black').text(item.title));
		    var postHeart = $('<div class="post-heart"></div>').text(item.voteCnt);
		    var postWriter = $('<div class="post-writer"></div>').text(item.username);
		    subInfo.append(postHeart, postWriter);
		    
		    var hr = $('<div class="hr"></div>');
		    
		    var subInfo2 = $('<div class="diet-card-sub-info2"></div>');
		    
		    let dietKcal = item.minCalorie+ ' - ' + item.maxCalorie + 'kcal';
		    var postKcal = $('<div class="post-kcal"></div>').text(dietKcal);
		    
		    dietPrice = item.minPrice +' - ' + item.maxPrice + '원';
		    var postPrice = $('<div class="post-price"></div>').text(dietPrice);
		    subInfo2.append(postKcal, postPrice);
		    
		    dietCardInfo.append(title, subInfo, hr, subInfo2);
		    
		    dietCard.append(dietCardImg, dietCardInfo);
		    dietCardList.append(dietCard);
		
	});
	
	// pagination 추가
    // 페이징 버튼 생성 및 추가
	var paginationContainer = document.getElementById("paginationContainer");
	paginationContainer.innerHTML = "";
	
	// pagination 추가
	var pagination = generatePagination(data);
	paginationContainer.appendChild(pagination);
	
	dietCardList.append(dietCardList);

}

//페이징 버튼 생성
function generatePagination(dto) {
    var pagination = document.createElement("div");
    pagination.classList.add("pagination");

    if (dto.page > 1) {
        if (dto.totalPage > 5) {
            var firstPageLink = document.createElement("a");
            firstPageLink.href = "?page=1";
            firstPageLink.innerText = "처음";
            pagination.appendChild(firstPageLink);
        }

        var prevPageLink = document.createElement("a");
        prevPageLink.href = "?page=" + (dto.page - 1);
        prevPageLink.innerText = "이전";
        pagination.appendChild(prevPageLink);
    }

    var startPage = dto.page - 2;
    var endPage = dto.page + 2;

    if (startPage < 1) {
        startPage = 1;
        endPage = 5;
    }

    if (endPage > dto.totalPage) {
        startPage = dto.totalPage - 4;
        endPage = dto.totalPage;
    }

    if (startPage < 1) {
        startPage = 1;
    }
    if (endPage > dto.totalPage) {
        endPage = dto.totalPage;
    }

    for (var pageNum = startPage; pageNum <= endPage; pageNum++) {
        var pageLink = document.createElement("a");
        pageLink.setAttribute("data-page", pageNum); // 데이터 속성에 페이지 번호 저장
        pageLink.addEventListener("click", function(event) {
            goToPage(Number(this.getAttribute("data-page"))); // 데이터 속성에서 페이지 번호 가져와서 goToPage() 함수 호출
        });
        if (pageNum === dto.page) {
            var strong = document.createElement("strong");
            strong.innerText = pageNum;
            pageLink.appendChild(strong);
        } else {
            pageLink.innerText = pageNum;
        }
        pagination.appendChild(pageLink);
    }

    if (dto.page < dto.totalPage) {
        var nextPageLink = document.createElement("a");
        nextPageLink.href = "?page=" + (dto.page + 1);
        nextPageLink.innerText = "다음";
        pagination.appendChild(nextPageLink);

        if (dto.totalPage > 5) {
            var lastPageLink = document.createElement("a");
            lastPageLink.href = "?page=" + dto.totalPage;
            lastPageLink.innerText = "끝";
            pagination.appendChild(lastPageLink);
        }
    }

    return pagination;
}

//페이징 버튼 클릭 시 페이지 이동
function goToPage(page) {
    search(page);
}

function resetSelection(){
	  $('input[type="checkbox"]').prop('checked', false);
	  $('input[type="radio"]').prop('checked', false);
	
}