$(document).ready(function() {
	calendarInit();
	
});



function formatDate(date) {
	var year = date.getFullYear();
	var month = (date.getMonth() + 1).toString().padStart(2, '0');
	var day = date.getDate().toString().padStart(2, '0');
	return year + '-' + month + '-' + day;
}

function calendarInit() {

	var date = new Date();
	var utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000);
	var kstGap = 9 * 60 * 60 * 1000;
	var today = new Date(utc + kstGap);

	var thisMonth = new Date(today.getFullYear(), today.getMonth(), today
			.getDate());

	var currentYear = thisMonth.getFullYear();
	var currentMonth = thisMonth.getMonth();
	var currentDate = thisMonth.getDate();

	renderCalender(thisMonth);

	function renderCalender(thisMonth) {

		// 렌더링을 위한 데이터 정리
		currentYear = thisMonth.getFullYear();
		currentMonth = thisMonth.getMonth();
		currentDate = thisMonth.getDate();

		// 이전 달의 마지막 날 날짜와 요일 구하기
		var startDay = new Date(currentYear, currentMonth, 0);
		var prevDate = startDay.getDate();
		var prevDay = startDay.getDay();

		// 이번 달의 마지막날 날짜와 요일 구하기
		var endDay = new Date(currentYear, currentMonth + 1, 0);
		var nextDate = endDay.getDate();
		var nextDay = endDay.getDay();

		$('.year-month').text(currentYear + '.' + (currentMonth + 1));

		calendar = document.querySelector('.dates')
		calendar.innerHTML = '';

		for (var i = prevDate - prevDay + 1; i <= prevDate; i++) {

			var date = new Date(currentYear, currentMonth - 1, i);
			var dateString = formatDate(date);
			calendar.innerHTML += '<button class="day prev" onclick="getDailyDiets(\''
					+ dateString + '\')">' + i + '</button>';
		}

		for (var i = 1; i <= nextDate; i++) {
			var date = new Date(currentYear, currentMonth, i);
			var dateString = formatDate(date);
			calendar.innerHTML += '<button class="day current" onclick="getDailyDiets(\''
					+ dateString + '\')">' + i + '</button>';
		}
		for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
			var date = new Date(currentYear, currentMonth + 1, i);
			var dateString = formatDate(date);
			calendar.innerHTML += '<button class="day next" onclick="getDailyDiets(\''
					+ dateString + '\')">' + i + '</button>';
		}

		if (today.getMonth() == currentMonth) {
			todayDate = today.getDate();
			var currentMonthDate = document.querySelectorAll('.dates .current');
			currentMonthDate[todayDate - 1].classList.add('today');
		}
	}

	$('.go-prev').on('click', function() {
		thisMonth = new Date(currentYear, currentMonth - 1, 1);
		renderCalender(thisMonth);
	});

	$('.go-next').on('click', function() {
		thisMonth = new Date(currentYear, currentMonth + 1, 1);
		renderCalender(thisMonth);
	});
	
	// 오늘 날짜의 식단을 옆에 띄우기 
	var todayDate = formatDate(new Date(today));
	console.log("today" , todayDate);
	getDailyDiets(todayDate);
	
}

$(document).ready(function() {
	$('.update-diets-cate input[type="radio"]').change(function() {
		var selectedCategory = $(this).val();
		var cardContainer = document.querySelector('.slide-wrapper');
		cardContainer.innerHTML = '';

		$.ajax({
			url : '/greating/api/admin/register?category=' + selectedCategory,
			method : 'GET',
			success : function(response) {
				console.log(response);
				updateDiets(response);

			},
			error : function() {
				console.log('컨트롤러 호출 실패');
			}
		});
	});
});

function updateDiets(response) {
	var cardContainer = document.querySelector('.slide-wrapper');
	var choosenResult = document.querySelector('.choosen-result');
	var choosenDietIdDiv = document.querySelector('.choosen-diet-id');
	var choosenDietIds = choosenDietIdDiv.getElementsByTagName('span');

	function clearCardContainer() {
		cardContainer.innerHTML = '';
	}

	function createCard(data) {
		var card = document.createElement('label');
		card.classList.add('card');

		var checkbox = document.createElement('input');
		checkbox.type = 'checkbox';
		checkbox.value = data.id;
		card.appendChild(checkbox);

		var img = document.createElement('img');
		img.src = data.thumbnailImgUrl;
		card.appendChild(img);

		var cardInfo = document.createElement('div');
		cardInfo.classList.add('card-info');
		cardInfo.textContent = data.name;
		card.appendChild(cardInfo);

		for (var i = 0; i < choosenDietIds.length; i++) {
			var idValue = parseInt(choosenDietIds[i].textContent);
			if (idValue === data.id) {
				checkbox.checked = true;
				break;
			}
		}

		checkbox.addEventListener('change', function() {
			if (this.checked) {
				handleCheckboxChange(data.id, data.name, true);
			} else {
				handleCheckboxChange(data.id, data.name, false);
			}
		});

		return card;
	}

	clearCardContainer();

	response.forEach(function(data) {
		var card = createCard(data);
		cardContainer.appendChild(card);
	});

	function handleCheckboxChange(id, name, isChecked) {
		if (isChecked) {
			addSpanToChoosenResult(id, name);

		} else {

			removeSpanFromChoosenResult(id, name);
		}

	}

	function addSpanToChoosenResult(id, name) {
		var span = document.createElement('span');
		span.textContent = name;
		choosenResult.appendChild(span);

		var idSpan = document.createElement('span');
		idSpan.textContent = id;
		choosenDietIdDiv.appendChild(idSpan);

	}

	function removeSpanFromChoosenResult(id, name) {
		var spans = choosenResult.getElementsByTagName('span');
		for (var i = 0; i < spans.length; i++) {
			if (spans[i].textContent === name) {
				choosenResult.removeChild(spans[i]);
				break;
			}
		}

		for (var i = 0; i < choosenDietIds.length; i++) {
			if (choosenDietIds[i].textContent === id) {
				choosenDietIdDiv.removeChild(choosenDietIds[i]);
				break;
			}
		}
	}

}

function registerDailyDiet() {

	var selectedDate = $('#date').val();

	if (selectedDate === '') {
		  Swal.fire({
			  icon: "error",
        	  title: ' 날짜를 선택해주세요!',
        	  confirmButtonText: '닫기'
          });
		return;
	}

	var choosenDietIdDiv = document.querySelector('.choosen-diet-id');
	var dietIds = document.querySelectorAll('.choosen-diet-id span');

	var dietIdsList = []
	for (var i = 0; i < dietIds.length; i++) {
		var idValue = parseInt(dietIds[i].textContent);
		dietIdsList.push(idValue);
	}

	if(dietIdsList.length===0){
		 Swal.fire({
			  icon: "error",
       	  title: ' 도시락을 선택해주세요!',
       	  confirmButtonText: '닫기'
         });
		return;
	}
	const data = {
		dietIds : dietIdsList,
		startDate : selectedDate
	};

	$.ajax({
		url : '/greating/api/admin/register',
		method : 'POST',
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(data),

		success : function(response) {
			$('#date').val('');
			$('input[name="category"]').prop('checked', false);

			$('.choosen-diet-id').empty();

			$('.choosen-result').empty();

			$('.slide-wrapper').empty();

			 Swal.fire({
				  icon: "success",
	        	  title: ' 등록이 완료되었습니다.!',
	        	  confirmButtonText: '닫기'
	          });
		},
		error : function() {
			console.log('컨트롤러 호출 실패');
		}
	});

}

function getDailyDiets(date){
	$.ajax({
		url : '/greating/api/admin/daily-diets?date='+date,
		method : 'get',
		success : function(response) {
			console.log(response);
		      renderDailyDiets(date,response);

		},
		error : function() {
			console.log('컨트롤러 호출 실패');
		}
	});

}



function renderDailyDiets(date,dailyDiets) {
	  var tableBody = $('.registered-diets table tbody');
	  tableBody.empty();

	 
	  for (var i = 0; i < dailyDiets.length; i++) {
	    var diet = dailyDiets[i];
	    var row =
	      '<tr>' +
	      '<td>' + diet.dietId + '</td>' +
	      '<td>' + diet.dietName + '</td>' +
	      '<td>' + diet.mainCategoryName + '</td>' +
	      '<td>' + diet.subCategoryName + '</td>' +
	      '</tr>';
	    tableBody.append(row);
	  }
	  
	  var title = $('.registered-diets .title');
	  title.text(date + ' 등록된 식단');
	}




