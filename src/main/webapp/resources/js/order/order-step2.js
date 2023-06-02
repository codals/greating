var currentDate = new Date();
var selectableDays = 7;
let selectedDates = [];

// 달력 생성 및 초기화
function createCalendar() {
  var calendarContainer = document.querySelector('.calendar');
  var calendarHTML = '';

  // 달력 헤더 생성
  calendarHTML += '<table>';
  calendarHTML += '<thead><tr class="year">';
//	calendarHTML += '<th colspan="7">'
//			+ currentDate.toLocaleString('default', {
//				month : 'long',
//				year : 'numeric'
//			}) + '</th>';
  calendarHTML += '<h2>'
  calendarHTML += '<th colspan="7">'
      + currentDate.getFullYear() + '.' + (currentDate.getMonth() + 1)
      + '</th>';
  calendarHTML += '</h2>'

  calendarHTML += '</tr></thead>';

  // 달력 본문 생성
  calendarHTML += '<tbody><tr>';
  calendarHTML += '<th>일</th>';
  calendarHTML += '<th>월</th>';
  calendarHTML += '<th>화</th>';
  calendarHTML += '<th>수</th>';
  calendarHTML += '<th>목</th>';
  calendarHTML += '<th>금</th>';
  calendarHTML += '<th>토</th>';
  calendarHTML += '</tr>';

  // 달력 날짜 채우기
  var currentMonth = currentDate.getMonth();
  var nextMonth = new Date(currentDate.getFullYear(), currentMonth + 1, 1);
  var firstDay = new Date(currentDate.getFullYear(), currentMonth, 1)
  .getDay();
  var daysInMonth = new Date(currentDate.getFullYear(), currentMonth + 1, 0)
  .getDate(); // 해당 월의 일수 가져오기

  for (var i = 0; i < firstDay; i++) {
    calendarHTML += '<td class="disabled"></td>';
  }

  for (var day = 1; day <= daysInMonth; day++) {
    const date = new Date(currentDate.getFullYear(), currentMonth, day);

    if (date >= currentDate
        && date <= new Date(currentDate.getFullYear(), currentMonth,
            currentDate.getDate() + selectableDays - 1)
        && selectedDates.length < selectableDays) { // 수정된 부분:
      // selectableDays에서
      // 1을 빼고 선택 가능한 날짜
      // 수를 체크함
      calendarHTML += '<td onclick="selectDate(this)">' + day + '</td>';
    } else {
      calendarHTML += '<td class="disabled">' + day + '</td>';
    }

    if ((day + firstDay) % 7 === 0) {
      calendarHTML += '</tr><tr class="table-row">';
    }
  }

  calendarHTML += '</tr></tbody>';
  calendarHTML += '</table>';

  calendarContainer.innerHTML = calendarHTML;

  var tds = calendarContainer.querySelectorAll('tbody td');
  tds.forEach(function (td) {
    var day = parseInt(td.innerText);
    var date = new Date(currentDate.getFullYear(), currentMonth, day);
    if (date.getDay() === 0) {
      td.classList.add('disabled');
    }
  });
}

// 날짜 선택 시 호출되는 함수
function selectDate(element) {
  // 선택된 날짜 스타일 변경
  const selectedElements = document.querySelectorAll('.calendar td.selected');
  selectedElements.forEach(function (el) {
    // el.classList.remove('selected');
    // 세 개의 날짜가 선택되면 선택 취소
    if (selectedElements.length > 2) {
      selectedElements.forEach(function (el) {
        el.classList.remove('selected');
      });

    }

  });
  element.classList.add('selected');

  if (selectedDates.length >= selectableDays) {
    selectedDates = [];
  }
  // 선택된 날짜 가져오기
  const selectedDate = new Date(currentDate.getFullYear(), currentDate
  .getMonth(), parseInt(element.innerHTML));
  selectedDates.push(selectedDate);

  // 선택된 날짜 확인
  console.log('selectedDates = ' + selectedDates);
}

// 달력 생성 및 초기화 함수 호출
createCalendar();

$(document).ready(function () {
  $('.next').click(function () {
    console.log(selectedDates);
    if (selectedDates.length === 0) {
      alert('선택을 완료해주세요');
      return;
    }
    const data = {
      dates: selectedDates
    };
    $.ajax({
      url: '/greating/api/diets/mygreating/orders/delivery',
      type: 'POST',
      dataType: 'json',
      contentType: 'application/json',
      async: false,
      data: JSON.stringify(data),
      success: function (response) {
        if (response) {
          location.href = 'http://localhost:8080/greating/diets/mygreating/orders/choice';
        } else {
          alert("날짜별 식단 조회 실패");
        }
      },
      error: function () {
        alert("통신 실패");
      }
    });
  });
});
