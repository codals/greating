// 페이징 버튼 클릭 시 페이지 이동
function goToPage(page) {
    location.href = "?page=" + page;
}

// 페이징 버튼 생성
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
        pageLink.href = "?page=" + pageNum;
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

// dto 객체는 다음과 같이 전달됩니다.
var dto = {
    page: 2,
    totalPage: 10
};

// 페이징 버튼 생성 및 추가
var paginationContainer = document.getElementById("paginationContainer");
var pagination = generatePagination(dto);
paginationContainer.appendChild(pagination);
