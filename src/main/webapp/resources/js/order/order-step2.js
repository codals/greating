// 현재 날짜 정보 가져오기
var currentDate = new Date();

// 선택 가능한 날짜 수
var selectableDays = 7;

// 달력 생성 및 초기화
function createCalendar() {
	var calendarContainer = document.querySelector('.calendar');
	var calendarHTML = '';

	// 달력 헤더 생성
	calendarHTML += '<table>';
	calendarHTML += '<thead><tr class="year">';
	calendarHTML += '<th colspan="7">'
			+ currentDate.toLocaleString('default', {
				month : 'long',
				year : 'numeric'
			}) + '</th>';
	calendarHTML += '</tr></thead>';

//	 달력 본문 생성
	calendarHTML += '<tbody><tr>';
//	calendarHTML += '<th>Sun</th>';
//	calendarHTML += '<th>Mon</th>';
//	calendarHTML += '<th>Tue</th>';
//	calendarHTML += '<th>Wed</th>';
//	calendarHTML += '<th>Thu</th>';
//	calendarHTML += '<th>Fri</th>';
//	calendarHTML += '<th>Sat</th>';
	calendarHTML += '</tr>';

	// 달력 날짜 채우기
	var currentMonth = currentDate.getMonth();
	var nextMonth = new Date(currentDate.getFullYear(), currentMonth + 1, 1);
	var firstDay = new Date(currentDate.getFullYear(), currentMonth, 1)
			.getDay();
	var daysInMonth = new Date(currentDate.getFullYear(), currentMonth + 1, 0)
			.getDate(); // 해당 월의 일수 가져오기

	var selectedDates = [];

	for (var i = 0; i < firstDay; i++) {
		calendarHTML += '<td class="disabled"></td>';
	}

	for (var day = 1; day <= daysInMonth; day++) {
		var date = new Date(currentDate.getFullYear(), currentMonth, day);

		if (date >= currentDate
				&& date <= new Date(currentDate.getFullYear(), currentMonth,
						currentDate.getDate() + selectableDays - 1)
				&& selectedDates.length < selectableDays) { // 수정된 부분: selectableDays에서 1을 빼고 선택 가능한 날짜 수를 체크함
			calendarHTML += '<td onclick="selectDate(this)">' + day + '</td>';
		} else {
			calendarHTML += '<td class="disabled">' + day + '</td>';
		}

		if ((day + firstDay) % 7 === 0) {
			calendarHTML += '</tr><tr>';
		}
	}

	calendarHTML += '</tr></tbody>';
	calendarHTML += '</table>';

	calendarContainer.innerHTML = calendarHTML;
}

// 날짜 선택 시 호출되는 함수
function selectDate(element) {
	// 선택된 날짜 스타일 변경
	var selectedElements = document.querySelectorAll('.calendar td.selected');
	selectedElements.forEach(function(el) {
		//	     el.classList.remove('selected');
		// 세 개의 날짜가 선택되면 선택 취소
		if (selectedElements.length > 2) {
			selectedElements.forEach(function(el) {
				el.classList.remove('selected');
			});
			selectedDates = [];
		}

	});
	element.classList.add('selected');

	// 선택된 날짜 가져오기
	var selectedDate = new Date(currentDate.getFullYear(), currentDate
			.getMonth(), parseInt(element.innerHTML));
	selectedDates.push(selectedDate);

	// 선택 가능한 날짜 수 초과 시 가장 오래된 날짜 제거
	if (selectedDates.length > selectableDays) {
		selectedDates.shift();
	}

	// 선택된 날짜 확인
	console.log(selectedDates);

}
// 달력 생성 및 초기화 함수 호출
createCalendar();
