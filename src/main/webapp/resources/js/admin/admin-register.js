$(document).ready(function() {
    calendarInit();
});

function calendarInit() {

    var date = new Date(); 
    var utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); 
    var kstGap = 9 * 60 * 60 * 1000; 
    var today = new Date(utc + kstGap); 
  
    var thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());
   
  
    
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
            calendar.innerHTML = calendar.innerHTML + '<button class="day prev">' + i + '</button>'
        }

        for (var i = 1; i <= nextDate; i++) {
            calendar.innerHTML = calendar.innerHTML + '<button class="day current">' + i + '</button>'
        }
        for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
            calendar.innerHTML = calendar.innerHTML + '<a class="day next disable">' + i + '</a>'
        }

        if (today.getMonth() == currentMonth) {
            todayDate = today.getDate();
            var currentMonthDate = document.querySelectorAll('.dates .current');
            currentMonthDate[todayDate -1].classList.add('today');
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