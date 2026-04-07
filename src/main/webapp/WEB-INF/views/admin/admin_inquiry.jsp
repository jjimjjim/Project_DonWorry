<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Pretendard', sans-serif;
    background-color: #ffffff;
    color: #333;
    line-height: 1.6;
}

.container {
    max-width: 1100px;
    margin: 0 auto;
    padding: 0 20px;
}

/* 상단 */
.top-auth {
    display: flex;
    justify-content: flex-end;
    align-items: center;
    gap: 15px;
    padding: 8px 0;
}

.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px 0;
    border-bottom: 1px solid #f0f0f0;
}

.logo {
    color: #2563eb;
    font-weight: 800;
    font-size: 20px;
    text-decoration: none;
}

.nav-menu {
    display: flex;
    gap: 40px;
}

.nav-menu a {
    text-decoration: none;
    color: #666;
    font-size: 14px;
    font-weight: 500;
}

.nav-menu a.active {
    color: #2563eb;
}

.my-page {
    display: flex;
    align-items: center;
    gap: 8px;
    text-decoration: none;
    color: #666;
    font-size: 14px;
    font-weight: 500;
    padding: 5px 10px;
    cursor: pointer;
}

 .logout-btn { 
    width:60px;
    height:30px;
    background-color: #ffffff; 
    color: #868e96;
    border: 1px solid #dee2e6; 
    border-radius: 6px; 
    font-size: 13px;
    transition: all 0.2s ease; /* 부드러운 변화를 위해 추가 */
}

.logout-btn:hover { 
    width:60px;
    height:30px;
   	background-color: #f8f9fa;
    color: #495057;
    border-color: #ced4da;
    border: 1px solid #dee2e6; 
    border-radius: 6px; 
    font-size: 13px;
    transition: all 0.2s ease; /* 부드러운 변화를 위해 추가 */
}		

.now-admin{
    width: 60px;
    height: 30px;
    background-color: #2563eb;
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 6px;
    border: none;
    font-size: 13px;
    cursor: pointer;
}

/* 페이지 공통 */
.admin-page {
    padding: 36px 0 0;
    min-height: 800px;
}

.page-header {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
    margin-bottom: 28px;
    gap: 20px;
}

.page-title-wrap h2 {
    font-size: 30px;
    font-weight: 800;
    color: #1e293b;
    margin-bottom: 6px;
    padding-left: 10px;
}

.page-title-wrap p {
    font-size: 14px;
    color: #64748b;
    padding-left: 10px;
}

.page-date-box {
    background: #fff;
    padding: 12px 16px;
    font-size: 15px;
    color: #475569;
}

/* 요약 카드 */
.summary-grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 18px;
    margin-bottom: 22px;
}

.summary-card {
    background: #fff;
    border: 1px solid #e7eef8;
    border-radius: 18px;
    padding: 22px;
}

.summary-label {
    font-size: 14px;
    color: #64748b;
    margin-bottom: 8px;
    font-weight: 600;
}

.summary-value {
    font-size: 30px;
    font-weight: 800;
    color: #0f172a;
}

.summary-desc {
    font-size: 13px;
    color: #2563eb;
    margin-top: 6px;
}

/* 패널 */
.panel {
    background: #fff;
    border: 1px solid #e7eef8;
    border-radius: 18px;
    padding: 22px;
    margin-bottom: 40px;
}

.panel-head {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 18px;
}

.panel-head h3 {
    margin: 0;
    font-size: 18px;
    font-weight: 800;
    color: #1e293b;
}

/* 검색 */
.filter-row {
    display: flex;
    gap: 12px;
    flex-wrap: wrap;
    align-items: center;
    margin-bottom: 18px;
}

.filter-row select,
.filter-row input {
    height: 42px;
    border: 1px solid #dbe3ef;
    border-radius: 10px;
    padding: 0 12px;
    font-size: 14px;
    outline: none;
}

.filter-row input {
    min-width: 260px;
    flex: 1;
}

.btn-search {
    height: 42px;
    border: none;
    border-radius: 10px;
    padding: 0 16px;
    background: #2563eb;
    color: #fff;
    font-size: 14px;
    font-weight: 700;
}

.btn-blue-light {
    height: 34px;
    border: 1px solid #cfe0ff;
    border-radius: 8px;
    padding: 0 12px;
    background: #f8fbff;
    color: #2563eb;
    font-size: 13px;
    font-weight: 700;
    cursor: pointer;
}

.btn-red {
    height: 34px;
    border: none;
    border-radius: 8px;
    padding: 0 12px;
    background: #ef4444;
    color: #fff;
    font-size: 13px;
    font-weight: 700;
    cursor: pointer;
}

/* 테이블 */
.admin-table {
    width: 100%;
    border-collapse: collapse;
}

.admin-table th,
.admin-table td {
    padding: 14px 10px;
    border-bottom: 1px solid #eef2f7;
    font-size: 14px;
    vertical-align: middle;
}

.admin-table th {
    text-align: center;
    background-color: #fafcff;
    color: #64748b;
    font-weight: 700;
}

.admin-table td {
    text-align: center;
}

.admin-table tbody tr:hover {
    background-color: #f8fbff;
}

/* 상태 뱃지 */
.status-badge {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    min-width: 72px;
    padding: 6px 10px;
    border-radius: 999px;
    font-size: 12px;
    font-weight: 700;
}

.status-wait {
    background: #fff4db;
    color: #d97706;
}

.status-done {
    background: #eaf4ff;
    color: #2563eb;
}

/* 페이지네이션 */
.pagination-wrap {
    display: flex;
    justify-content: center;
    gap: 8px;
    margin-top: 22px;
}

.page-btn {
    min-width: 34px;
    height: 34px;
    border: 1px solid #dbe3ef;
    border-radius: 8px;
    background: #fff;
    color: #475569;
    font-size: 13px;
    cursor: pointer;
}

.page-btn.active {
    background: #2563eb;
    color: #fff;
    border-color: #2563eb;
}

/* footer */
.container-footer {
    border-top: 1px solid #e5e7eb;
    background-color: #f9fafb;
    padding: 40px 0;
    margin-top: 80px;
    text-align: center;
    color: #999;
    font-size: 13px;
    width: 100vw;
    margin-left: calc(-50vw + 50%);
}

/* 반응형 */
@media (max-width: 1024px) {
    .summary-grid {
        grid-template-columns: 1fr;
    }
}

@media (max-width: 768px) {
    .page-header {
        flex-direction: column;
        align-items: flex-start;
    }

    .nav-menu {
        gap: 16px;
        flex-wrap: wrap;
    }

    .filter-row {
        flex-direction: column;
        align-items: stretch;
    }

    .filter-row select,
    .filter-row input,
    .btn-search {
        width: 100%;
    }
}
</style>
</head>
<body>

<div class="container">
	<div class="top-auth">  
        <span style="font-size: 13px; color: #666; cursor: pointer;">
        	<i class="fa-regular fa-user fa-lg" style="color: rgb(203, 203, 203); margin-right:5px;"></i>
            	${nickName}님 환영합니다.
            <a href="/members/logout" style="text-decoration: none; color:black">
            <button class="logout-btn" style="margin-left:10px;">로그아웃</button>              
            </a>
        </span>
		<c:if test="${type=='관리자'}">
            <a href="/admin/admin_main" style="text-decoration:none;"><div class="now-admin">관리자</div></a>
		</c:if>
    </div>
    <nav class="navbar">
        <div style="display: flex; align-items: center; gap: 40px;">
            <a href="/" class="logo">돈워리</a>

            <div class="nav-menu">
                <a href="/admin/admin_main" >
                   <i class="fa-solid fa-wrench fa-lg" style="color:  rgb(197, 197, 197); margin-right:6px;"></i>
                    관리자 대시보드
                </a> 
                <a href="/admin/admin_boards">
                   <i class="fa-solid fa-file-pen fa-lg" style="color: rgb(197, 197, 197); margin-right:6px;"></i>
                    게시물 관리
                </a>  
                <a href="/admin/admin_members">
                   <i class="fa-solid fa-user-shield fa-lg" style="color: rgb(197, 197, 197);  margin-right:6px;"></i>
                    회원 관리
                </a> 
                <a href="/admin/admin_inquiry"  class="active">
                   <i class="fa-regular fa-circle-question fa-lg" style="color: rgb(36, 99, 235); margin-right:6px;"></i>
                    Q&A 관리
                </a>               
            </div>
        </div>
    </nav>

    <main class="admin-page">

        <div class="page-header">
            <div class="page-title-wrap">
                <h2>고객 문의 관리</h2>
                <p>문의 내역을 조회하고 답변 상태를 관리할 수 있습니다.</p>
            </div>

            <div class="page-date-box">
                <i class="fa-regular fa-envelope-open" style="margin-right:6px;"></i>
                미처리 문의 ${waitCount }건
            </div>
        </div>

        <section class="summary-grid">
            <div class="summary-card">
                <div class="summary-label">전체 문의</div>
                <div class="summary-value">${allCount }</div>
                <div class="summary-desc">이번 주 신규 ${weekNewCount }건</div>
            </div>

            <div class="summary-card">
                <div class="summary-label">답변 대기</div>
                <div class="summary-value">${waitCount }</div>
                <div class="summary-desc">24시간 이상 경과 ${overwaitCount }건</div>
            </div>

            <div class="summary-card">
                <div class="summary-label">답변 완료</div>
                <div class="summary-value">${completeCount }</div>
                <div class="summary-desc">평균 처리 시간 <fmt:formatNumber value="${replyTime}" pattern="0.0"/>일</div>
            </div>
        </section>

        <section class="panel">
            <div class="panel-head">
                <h3>문의 목록</h3>
            </div>

            <div class="filter-row">
                    <select id="statusFilter">
                        <option value="all">전체 상태</option>
                        <option value="status-waiting">답변 대기</option>
                        <option value="status-complete">답변 완료</option>
                    </select>

                    <input type="text" id="searchInput" placeholder="문의 제목, 작성자 검색">

                    <button type="button" class="btn-search" id="searchBtn">검색</button>
                </div>

                <table class="admin-table">
                    <thead>
                        <tr>
                            <th>문의번호</th>
                            <th colspan='2'>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th colspan='2'>상태</th>
                        </tr>
                    </thead>
                    <tbody id="inquiryTableBody"></tbody>
                </table>

                <div class="pagination-wrap" id="paginationBox"></div>
        </section>

    </main>

    <div class="container-footer">
        <p>© 2026 돈워리. All rights reserved.</p>
        <p style="margin-top: 10px; font-size: 11px;">개인정보처리방침 | 이용약관 | 고객센터</p>
    </div>

</div>
<script>
$(document).ready(function() {
    // 1. 처음 페이지 로드 시 1페이지 목록 불러오기
    loadInquiryList(1);

    // 2. 검색 버튼 클릭 이벤트
    $("#searchBtn").on("click", function() {
        loadInquiryList(1);
    });

    // 3. 상태 필터 변경 시 즉시 검색
    $("#statusFilter").on("change", function() {
        loadInquiryList(1);
    });

    // 4. 엔터키 검색 지원
    $("#searchInput").on("keyup", function(e) {
        if (e.key === "Enter") loadInquiryList(1);
    });

    // 5. 페이지 번호 클릭 이벤트 (동적 생성이므로 document 위임)
    $(document).on("click", ".page-btn", function() {
        const targetPage = $(this).data("page");
        if(targetPage) loadInquiryList(targetPage);
    });
});

/**
 * 서버로부터 데이터를 받아와 화면을 그리는 핵심 함수
 */
function loadInquiryList(page) {
    const status = $("#statusFilter").val();
    const keyword = $("#searchInput").val();

    $.ajax({
        url: "/admin/api/inquiry_list", // 아까 만든 컨트롤러 주소
        type: "GET",
        data: {
            page: page,
            status: status,
            keyword: keyword
        },
        dataType: "json",
        success: function(res) {
            // 테이블 그리기
            renderTable(res.mainList);
            // 페이징 그리기
            renderPagination(res.currentPage, res.recordTotalCount, res.recordCountPerPage, res.naviCountPerPage);
        },
        error: function(err) {
            console.error("데이터 로드 실패:", err);
            alert("목록을 불러오는 중 오류가 발생했습니다.");
        }
    });
}

/**
 * 테이블 렌더링
 */
function renderTable(list) {
    let html = "";
    if (!list || list.length === 0) {
        html = '<tr><td colspan="6" style="padding:50px 0; color:#94a3b8;">검색 결과가 없습니다.</td></tr>';
    } else {
        list.forEach(item => {
            // 상태에 따른 클래스와 텍스트 분기
            const isWait = item.status === 'status-waiting';
            const badgeClass = isWait ? 'status-wait' : 'status-done';
            const statusText = isWait ? '답변 대기' : '답변 완료';

            html += `
            	<tr onclick="location.href='/admin/qnaDetail?seq=`+item.seq+`'" style="cursor:pointer;">
                    <td>`+item.seq+`</td>
                    <td colspan="2">`+item.title+`</td>
                    <td>`+item.member_id+`</td>
                    <td>`+item.write_date_str+`</td>
                    <td colspan="2">`;
                    html += "<span class='status-badge " + badgeClass + "'>" + statusText + "</span>";
                        //<span class="status-badge ${badgeClass}">`+statusText+`</span>
                      html +=`  
                    </td>
                </tr>
            `;
        });
    }
    $("#inquiryTableBody").html(html);
}

/**
 * 페이징 버튼 렌더링
 */
function renderPagination(currentPage, totalCount, recordPerPage, naviPerPage) {
    if (totalCount === 0) {
        $("#paginationBox").empty();
        return;
    }

    const totalPage = Math.ceil(totalCount / recordPerPage);
    const startNavi = Math.floor((currentPage - 1) / naviPerPage) * naviPerPage + 1;
    let endNavi = startNavi + naviPerPage - 1;
    if (endNavi > totalPage) endNavi = totalPage;

    let html = "";

    // 이전 버튼 (<)
    if (startNavi > 1) {
    html += "<button class='page-btn' data-page='" + (startNavi - 1) + "'>&lt;</button>";
}

    // 숫자 버튼
    for (let i = startNavi; i <= endNavi; i++) {
        const activeClass = (i === currentPage) ? "active" : "";
        html += "<button class='page-btn " +activeClass+"' data-page='"+i+"'>"+i+"</button>";
    }

    // 다음 버튼 (>)
    if (endNavi < totalPage) {
        html += "<button class='page-btn' data-page='"+(endNavi + 1)+"'>&gt;</button>";
    }

    $("#paginationBox").html(html);
}


</script>
</body>
</html>