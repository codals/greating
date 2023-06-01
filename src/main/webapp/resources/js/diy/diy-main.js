
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
	        	if(data.length ==0 ){
	        		alert('검색 결과가 없습니다. ');
	        		return;
	        	}
	        	data.forEach(function(item){
	        		console.log(item.id);
	        	});
	        	alert('검색이 완료되었습니다. ');
	        },
	        error: function(xhr, status, error) {
	            alert('검색 실패하였습니다. ');

	        }
	    });
}