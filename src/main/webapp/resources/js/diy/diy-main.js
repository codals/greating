
function openSearchBox() {
  var searchContainer = $('.search-container');
  
  if (searchContainer.css('display') === 'none') {
    searchContainer.css('display', 'block');
  } else {
    searchContainer.css('display', 'none');
  }
}

function search(){
	
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
	 
	 $.ajax({
	        url: "/greating/api/mealdiy/search?"+queryParams,
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
	$('.search-container').css('display','none');
	
	var dietCardList = $('.diet-card-list');
	dietCardList.empty(); 
	
	data.forEach(function(item){
		   var dietCard = $('<div class="col-4 diet-card"></div>');
		    
		    var dietCardImg = $('<div class="diet-card-img"></div>');
		    var imgSrc = item.imgUrl;
		    var img = $('<img>').attr('src', imgSrc);
		    dietCardImg.append(img);
		    
		    var dietCardInfo = $('<div class="diet-card-info"></div>');
		    var title = $('<span>').text(item.title);
		    var subInfo = $('<div class="diet-card-sub-info"></div>');
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
	
	dietCardList.append(dietCardList);

}

function resetSelection(){
	  $('input[type="checkbox"]').prop('checked', false);
	  $('input[type="radio"]').prop('checked', false);
	
}