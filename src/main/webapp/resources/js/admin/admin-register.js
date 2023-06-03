$(document).ready(function() {
	calendarInit();
});

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
			calendar.innerHTML = calendar.innerHTML
					+ '<button class="day prev">' + i + '</button>'
		}

		for (var i = 1; i <= nextDate; i++) {
			calendar.innerHTML = calendar.innerHTML
					+ '<button class="day current">' + i + '</button>'
		}
		for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
			calendar.innerHTML = calendar.innerHTML
					+ '<a class="day next disable">' + i + '</a>'
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
}

$(document).ready(function() {
	$('.update-diets-cate input[type="radio"]').change(function() {
		var selectedCategory = $(this).val();
		var cardContainer = document.querySelector('.slide-wrapper');
		cardContainer.innerHTML = '';

		$.ajax({
			url : '/greating/api/admin/register?category='+selectedCategory,
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

	function handleCheckboxChange(id,name, isChecked) {
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


function registerDailyDiet(){
	
	var selectedDate = $('#date').val();
	
	if (selectedDate === '') {
		  alert('날짜를 선택해주세요.');
		  return;
	}
//	}
//	var parsedDate = new LocalDate(selectedDate);
//	var formattedDate = parsedDate.toISOString().split('T')[0];

	var choosenDietIdDiv = document.querySelector('.choosen-diet-id');
	var dietIds = document.querySelectorAll('.choosen-diet-id span');


	var dietIdsList = []
	for (var i = 0; i < dietIds.length; i++) {
		var idValue = parseInt(dietIds[i].textContent);
		dietIdsList.push(idValue);
	}
	console.log(dietIdsList);
	console.log("date "+ selectedDate)
	
	const data = {
		dietIds: dietIdsList,
		startDate:selectedDate
	};

	$.ajax({
		url : '/greating/api/admin/register',
		method : 'POST',
		dataType: 'json',
		contentType: 'application/json',
		data: JSON.stringify(data),

		success : function(response) {
			$('#date').val('');
			$('input[name="category"]').prop('checked', false);

			$('.choosen-diet-id').empty();
			
			$('.choosen-result').empty();
			
			$('.slide-wrapper').empty();
			
			alert('등록이 완료되었습니다. ');
		
		},
		error : function() {
			console.log('컨트롤러 호출 실패');
		}
	});
	
	
	
}










