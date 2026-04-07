<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Pretendard', sans-serif;
    background: #f8fbff;
    color: #333;
    line-height: 1.6;
}

.container {
    max-width: 1240px;
    margin: 0 auto;
    padding: 0 20px;
}

.top-auth {
    display: flex;
    justify-content: flex-end;
    align-items: center;
    gap: 15px;
    padding: 10px 0;
}

.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px 0 22px;
    border-bottom: 1px solid #e8eef7;
}

.logo {
    color: #2563eb;
    font-weight: 800;
    font-size: 22px;
    text-decoration: none;
}

.nav-menu {
    display: flex;
    gap: 34px;
    align-items: center;
}

.nav-menu a {
    text-decoration: none;
    color: #64748b;
    font-size: 14px;
    font-weight: 600;
    transition: .2s;
}

.nav-menu a:hover,
.nav-menu a.active {
    color: #2563eb;
}

.logout-btn {
    width: 72px;
    height: 34px;
    background: #fff;
    color: #64748b;
    border: 1px solid #d9e2ec;
    border-radius: 8px;
    font-size: 13px;
    transition: .2s;
}

.logout-btn:hover {
    background: #f8fafc;
    color: #334155;
}

.now-admin {
    min-width: 68px;
    height: 34px;
    background: #2563eb;
    color: white;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    border-radius: 8px;
    border: none;
    font-size: 13px;
    font-weight: 700;
}

.admin-page {
    padding: 36px 0 0;
    min-height: 800px;
}

.admin-header {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
    margin-bottom: 20px;
    gap: 20px;
}

.admin-title-wrap h2 {
    font-size: 32px;
    font-weight: 800;
    color: #0f172a;
    margin-bottom: 6px;
}

.admin-title-wrap p {
    font-size: 14px;
    color: #64748b;
}

.admin-date-box {
    background: #fff;
    border: 1px solid #e7eef8;
    border-radius: 14px;
    padding: 12px 16px;
    font-size: 14px;
    color: #475569;
    box-shadow: 0 8px 20px rgba(37, 99, 235, 0.04);
}

.admin-toolbar {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 16px;
    margin-bottom: 22px;
}

.admin-tool-btn {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
    height: 72px;
    padding: 0 18px;
    border: 1px solid #dce8f7;
    border-radius: 18px;
    background: #fff;
    color: #2563eb;
    text-decoration: none;
    font-size: 15px;
    font-weight: 800;
    box-shadow: 0 10px 24px rgba(37, 99, 235, 0.04);
    transition: .2s;
}

.admin-tool-btn:hover {
    background: #f6faff;
    transform: translateY(-2px);
}

.admin-tool-btn.active {
    background: linear-gradient(135deg, #2563eb, #3b82f6);
    color: #fff;
    border-color: #2563eb;
}

.stats-grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 18px;
    margin-bottom: 22px;
}

.stat-card {
    background: #fff;
    border: 1px solid #e7eef8;
    border-radius: 20px;
    padding: 22px;
    position: relative;
    overflow: hidden;
    box-shadow: 0 12px 28px rgba(15, 23, 42, 0.04);
}

.stat-top {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 14px;
}

.stat-label {
    font-size: 14px;
    color: #64748b;
    font-weight: 700;
}

.stat-icon {
    width: 58px;
    height: 58px;
    border-radius: 16px;
    background: #eff6ff;
    color: #2563eb;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 24px;
}

.stat-value {
    font-size: 32px;
    font-weight: 800;
    color: #0f172a;
    margin-bottom: 6px;
}

.stat-desc {
    font-size: 13px;
    color: #2563eb;
    font-weight: 600;
}

.dashboard-grid,
.bottom-grid {
    display: grid;
    grid-template-columns: 1.45fr 1.1fr;
    gap: 20px;
    margin-bottom: 22px;
}

.dashboard-card {
    background: #fff;
    border: 1px solid #e7eef8;
    border-radius: 20px;
    padding: 22px;
    box-shadow: 0 12px 28px rgba(15, 23, 42, 0.04);
}

.card-head {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 18px;
}

.card-head h3 {
    font-size: 18px;
    font-weight: 800;
    color: #1e293b;
    margin: 0;
}

.card-head .sub-text {
    font-size: 13px;
    color: #64748b;
}

.chart-box {
    height: 300px;
}

.admin-table {
    width: 100%;
    border-collapse: collapse;
}

.admin-table th,
.admin-table td {
    padding: 14px 10px;
    border-bottom: 1px solid #eef2f7;
    text-align: left;
    font-size: 14px;
    vertical-align: middle;
}

.admin-table th {
    color: #64748b;
    font-weight: 700;
    background-color: #fafcff;
}

.admin-table tbody tr:hover {
    background-color: #f8fbff;
}

.empty-row td {
    text-align: center;
    color: #94a3b8;
    padding: 28px 10px;
}

.status-badge {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    min-width: 64px;
    padding: 6px 10px;
    border-radius: 999px;
    font-size: 12px;
    font-weight: 700;
}

.status-normal {
    background: #eaf4ff;
    color: #2563eb;
}

.status-wait {
    background: #fff4db;
    color: #d97706;
}

.status-stop {
    background: #ffe9e9;
    color: #dc2626;
}

.member-ratio-wrap {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.ratio-chart-box {
    width: 240px;
    height: 240px;
    margin: 10px auto 20px;
}

.ratio-legend {
    width: 100%;
    display: flex;
    flex-direction: column;
    gap: 12px;
}

.ratio-item {
    display: flex;
    align-items: center;
    justify-content: space-between;
    border: 1px solid #edf2f7;
    border-radius: 12px;
    padding: 12px 14px;
    background: #fbfdff;
}

.ratio-left {
    display: flex;
    align-items: center;
    gap: 10px;
}

.ratio-dot {
    width: 12px;
    height: 12px;
    border-radius: 50%;
}

.ratio-dot.personal { background: #1677ff; }
.ratio-dot.business { background: #93c5fd; }

.ratio-name {
    font-size: 14px;
    color: #334155;
    font-weight: 600;
}

.ratio-value {
    font-size: 14px;
    color: #0f172a;
    font-weight: 700;
}

.alert-list {
    display: flex;
    flex-direction: column;
    gap: 12px;
}

.alert-item {
    display: flex;
    align-items: flex-start;
    justify-content: space-between;
    gap: 14px;
    padding: 14px 16px;
    border: 1px solid #edf2f7;
    border-radius: 14px;
    background: #fbfdff;
}

.alert-title {
    font-size: 14px;
    font-weight: 700;
    color: #1e293b;
    margin-bottom: 4px;
}

.alert-desc {
    font-size: 13px;
    color: #64748b;
}

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

@media (max-width: 1100px) {
    .stats-grid,
    .admin-toolbar,
    .dashboard-grid,
    .bottom-grid {
        grid-template-columns: 1fr;
    }

    .admin-header {
        flex-direction: column;
        align-items: flex-start;
    }

    .nav-menu {
        gap: 18px;
        flex-wrap: wrap;
    }
}
</style>
</head>
<body>

<div class="container">
    <div class="top-auth">
        <span style="font-size: 13px; color: #666;">
            <i class="fa-regular fa-user fa-lg" style="color:#cbd5e1; margin-right:5px;"></i>
            ${nickName}님 환영합니다.
            <a href="/members/logout" style="text-decoration:none; color:black;">
                <button class="logout-btn" type="button" style="margin-left:10px;">로그아웃</button>
            </a>
        </span>

        <c:if test="${type == '관리자'}">
            <a href="/admin/admin_main" style="text-decoration:none;">
                <div class="now-admin">관리자</div>
            </a>
        </c:if>
    </div>

    <nav class="navbar">
        <div style="display:flex; align-items:center; gap:40px;">
            <a href="/" class="logo">돈워리</a>

            <div class="nav-menu">
                <a href="/admin/admin_main" class="active">
                    <i class="fa-solid fa-wrench fa-lg" style="margin-right:6px;"></i> 관리자 대시보드
                </a>
                <a href="/admin/admin_boards?page=1">
                    <i class="fa-solid fa-file-pen fa-lg" style="color:#c5c5c5; margin-right:6px;"></i> 게시물 관리
                </a>
                <a href="/admin/admin_members">
                    <i class="fa-solid fa-user-shield fa-lg" style="color:#c5c5c5; margin-right:6px;"></i> 회원 관리
                </a>
                <a href="/admin/admin_inquiry">
                    <i class="fa-regular fa-circle-question fa-lg" style="color:#c5c5c5; margin-right:6px;"></i> Q&A 관리
                </a>
            </div>
        </div>
    </nav>

    <main class="admin-page">
        <div class="admin-header">
            <div class="admin-title-wrap">
                <h2>관리자 대시보드</h2>
                <p>회원, 게시글, 문의, 신고, 가입 현황을 한눈에 확인할 수 있습니다.</p>
            </div>

            <div class="admin-date-box">
                <i class="fa-regular fa-calendar-check" style="margin-right:6px;"></i>
                ${today} 기준 운영 현황
            </div>
        </div>

        <div class="admin-toolbar">
            <a href="/admin/admin_main" class="admin-tool-btn active">
                <i class="fa-solid fa-chart-line"></i> 대시보드
            </a>
            <a href="/admin/admin_members" class="admin-tool-btn">
                <i class="fa-solid fa-user-shield"></i> 회원 관리
            </a>
            <a href="/admin/admin_boards?page=1" class="admin-tool-btn">
                <i class="fa-solid fa-file-pen"></i> 게시물 관리
            </a>
            <a href="/admin/admin_inquiry" class="admin-tool-btn">
                <i class="fa-regular fa-circle-question"></i> 고객 문의 관리
            </a>
        </div>

        <section class="stats-grid">
            <div class="stat-card">
                <div class="stat-top">
                    <div class="stat-label">전체 사용자</div>
                    <div class="stat-icon"><i class="fa-solid fa-users"></i></div>
                </div>
                <div class="stat-value">${totalMembers}</div>
                <div class="stat-desc">오늘 신규 가입 ${todayJoinCount}명</div>
            </div>

            <div class="stat-card">
                <div class="stat-top">
                    <div class="stat-label">전체 게시글</div>
                    <div class="stat-icon"><i class="fa-regular fa-pen-to-square"></i></div>
                </div>
                <div class="stat-value">${totalBoards}</div>
                <div class="stat-desc">오늘 신규 게시글 ${todayBoardCount}건</div>
            </div>

            <div class="stat-card">
                <div class="stat-top">
                    <div class="stat-label">미답변 문의</div>
                    <div class="stat-icon"><i class="fa-regular fa-envelope"></i></div>
                </div>
                <div class="stat-value">${unansweredInquiryCount}</div>
                <div class="stat-desc">24시간 이상 ${overdueInquiryCount}건</div>
            </div>

            <div class="stat-card">
                <div class="stat-top">
                    <div class="stat-label">기업 회원</div>
                    <div class="stat-icon"><i class="fa-solid fa-building"></i></div>
                </div>
                <div class="stat-value">${businessMemberCount}</div>
                <div class="stat-desc">전체 회원 중 ${businessMemberPercent}%</div>
            </div>

            <div class="stat-card">
                <div class="stat-top">
                    <div class="stat-label">구인 공고 수</div>
                    <div class="stat-icon"><i class="fa-solid fa-briefcase"></i></div>
                </div>
                <div class="stat-value">${jobPostCount}</div>
                <div class="stat-desc">현재 모집중 ${recruitingJobCount}건</div>
            </div>

            <div class="stat-card">
                <div class="stat-top">
                    <div class="stat-label">신고 접수</div>
                    <div class="stat-icon"><i class="fa-regular fa-bell"></i></div>
                </div>
                <div class="stat-value">${reportCount}</div>
                <div class="stat-desc">즉시 확인 필요 ${urgentReportCount}건</div>
            </div>
        </section>

        <section class="dashboard-grid">
            <div class="dashboard-card">
                <div class="card-head">
                    <h3>일주일 방문자 추이</h3>
                    <span class="sub-text">최근 7일 기준</span>
                </div>
                <div class="chart-box">
                    <canvas id="visitorChart"></canvas>
                </div>
            </div>

            <div class="dashboard-card">
                <div class="card-head">
                    <h3>게시글 / 문의 현황</h3>
                    <span class="sub-text">최근 6개월</span>
                </div>
                <div class="chart-box">
                    <canvas id="postChart"></canvas>
                </div>
            </div>
        </section>

        <section class="bottom-grid">
            <div class="dashboard-card">
                <div class="card-head">
                    <h3>최근 가입 회원</h3>
                    <span class="sub-text">가장 최근 가입 순</span>
                </div>

                <table class="admin-table">
                    <thead>
                        <tr>
                            <th>이름</th>
                            <th>이메일</th>
                            <th>유형</th>
                            <th>상태</th>
                            <th>가입일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>

                            <c:when test="${not empty recentMembers}">
                                <c:forEach var="m" items="${recentMembersList }">
                                    <tr>
                                        <td>${m.name}</td>
                                        <td>${m.email}</td>
                                        <td>${m.type}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${m.state == '정상'}">
                                                    <span class="status-badge status-normal">정상</span>
                                                </c:when>
                                                <c:when test="${m.state == '대기'}">
                                                    <span class="status-badge status-wait">대기</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="status-badge status-stop">정지</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>${m.joinDate}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr class="empty-row">
                                    <td colspan="5">최근 가입 회원 데이터가 없습니다.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>

            <div class="dashboard-card">
                <div class="card-head">
                    <h3>회원 유형 비율</h3>
                    <span class="sub-text">개인 / 기업 회원 구성</span>
                </div>

                <div class="member-ratio-wrap">
                    <div class="ratio-chart-box">
                        <canvas id="memberRatioChart"></canvas>
                    </div>

                    <div class="ratio-legend">
                        <div class="ratio-item">
                            <div class="ratio-left">
                                <span class="ratio-dot personal"></span>
                                <span class="ratio-name">개인 회원</span>
                            </div>
                            <span class="ratio-value">${personalMemberCount}명 (${personalMemberPercent}%)</span>
                        </div>

                        <div class="ratio-item">
                            <div class="ratio-left">
                                <span class="ratio-dot business"></span>
                                <span class="ratio-name">기업 회원</span>
                            </div>
                            <span class="ratio-value">${businessMemberCount}명 (${businessMemberPercent}%)</span>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="bottom-grid">
            <div class="dashboard-card">
                <div class="card-head">
                    <h3>관리 알림</h3>
                    <span class="sub-text">관리자가 바로 확인해야 할 항목</span>
                </div>

                <div class="alert-list">
                    <div class="alert-item">
                        <div>
                            <div class="alert-title">미답변 문의</div>
                            <div class="alert-desc">현재 ${unansweredInquiryCount}건이 답변 대기 중입니다.</div>
                        </div>
                        <a href="/admin/admin_inquiry" class="admin-tool-btn" style="height:40px; padding:0 14px; border-radius:10px; font-size:13px;">바로가기</a>
                    </div>

                    <div class="alert-item">
                        <div>
                            <div class="alert-title">신고 접수</div>
                            <div class="alert-desc">긴급 처리 대상 신고 ${urgentReportCount}건이 있습니다.</div>
                        </div>
                        <a href="/admin/admin_boards?page=1" class="admin-tool-btn" style="height:40px; padding:0 14px; border-radius:10px; font-size:13px;">확인하기</a>
                    </div>

                    <div class="alert-item">
                        <div>
                            <div class="alert-title">오늘 가입 현황</div>
                            <div class="alert-desc">오늘 신규 회원 ${todayJoinCount}명이 가입했습니다.</div>
                        </div>
                        <a href="/admin/admin_members" class="admin-tool-btn" style="height:40px; padding:0 14px; border-radius:10px; font-size:13px;">회원 보기</a>
                    </div>
                </div>
            </div>

            <div class="dashboard-card">
                <div class="card-head">
                    <h3>운영 요약</h3>
                    <span class="sub-text">당일 핵심 수치</span>
                </div>

                <table class="admin-table">
                    <tbody>
                        <tr>
                            <th>오늘 가입</th>
                            <td>${todayJoinCount}명</td>
                        </tr>
                        <tr>
                            <th>오늘 게시글</th>
                            <td>${todayBoardCount}건</td>
                        </tr>
                        <tr>
                            <th>오늘 문의</th>
                            <td>${todayInquiryCount}건</td>
                        </tr>
                        <tr>
                            <th>미처리 신고</th>
                            <td>${reportCount}건</td>
                        </tr>
                        <tr>
                            <th>모집중 공고</th>
                            <td>${recruitingJobCount}건</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </section>
    </main>

    <div class="container-footer">
        <p>© 2026 돈워리. All rights reserved.</p>
        <p style="margin-top: 10px; font-size: 11px;">개인정보처리방침 | 이용약관 | 고객센터</p>
    </div>
</div>

<script>
const visitorLabels = [
    <c:forEach var="item" items="${visitorChartLabels}" varStatus="s">
        '${item}'<c:if test="${not s.last}">,</c:if>
    </c:forEach>
];

const visitorData = [
    <c:forEach var="item" items="${visitorChartData}" varStatus="s">
        ${item}<c:if test="${not s.last}">,</c:if>
    </c:forEach>
];

const postLabels = [
    <c:forEach var="item" items="${postChartLabels}" varStatus="s">
        '${item}'<c:if test="${not s.last}">,</c:if>
    </c:forEach>
];

const boardData = [
    <c:forEach var="item" items="${boardChartData}" varStatus="s">
        ${item}<c:if test="${not s.last}">,</c:if>
    </c:forEach>
];

const inquiryData = [
    <c:forEach var="item" items="${inquiryChartData}" varStatus="s">
        ${item}<c:if test="${not s.last}">,</c:if>
    </c:forEach>
];

new Chart(document.getElementById('visitorChart'), {
    type: 'line',
    data: {
        labels: visitorLabels,
        datasets: [{
            label: '방문자 수',
            data: visitorData,
            borderColor: '#1677ff',
            backgroundColor: 'rgba(22,119,255,0.08)',
            fill: true,
            tension: 0.35,
            pointRadius: 4,
            pointBackgroundColor: '#1677ff'
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: { position: 'bottom' }
        },
        scales: {
            y: {
                beginAtZero: true,
                grid: { color: '#eef3f8' }
            },
            x: {
                grid: { display: false }
            }
        }
    }
});

new Chart(document.getElementById('postChart'), {
    type: 'bar',
    data: {
        labels: postLabels,
        datasets: [
            {
                label: '게시글',
                data: boardData,
                backgroundColor: '#1677ff',
                borderRadius: 8
            },
            {
                label: '문의',
                data: inquiryData,
                backgroundColor: '#d6dee8',
                borderRadius: 8
            }
        ]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: { position: 'bottom' }
        },
        scales: {
            y: {
                beginAtZero: true,
                grid: { color: '#eef3f8' }
            },
            x: {
                grid: { display: false }
            }
        }
    }
});

new Chart(document.getElementById('memberRatioChart'), {
    type: 'doughnut',
    data: {
        labels: ['개인 회원', '기업 회원'],
        datasets: [{
            data: [${personalMemberCount}, ${businessMemberCount}],
            backgroundColor: ['#1677ff', '#93c5fd'],
            borderWidth: 0,
            hoverOffset: 6
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        cutout: '68%',
        plugins: {
            legend: { display: false }
        }
    }
});
</script>

</body>
</html>