<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu List</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card {
            background-color: #fff9e6; /* 카드 배경을 살짝 밝은 베이지로 */
        }
        .card-body {
            background-color: #D2691E;
        }
        .list-group-item {
            background-color: #fff9e6; /* 메뉴 항목 배경도 동일한 색상 */
        }
        /* 이미지와 텍스트를 수평으로 정렬 */
        .menu-item {
            display: flex;
            align-items: center;
        }
        .menu-item img {
            width: 100px; /* 이미지 크기 */
            height: 100px;
            margin-right: 20px; /* 이미지와 텍스트 사이에 여백 */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Menu List</h1>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <ul class="list-group">
                            <c:forEach items="${menuList}" var="menu">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <!-- 이미지와 글자를 flexbox로 정렬 -->
                                    <div class="menu-item">
	                                    <img src="imgs/menus/<c:out value="${menu}"></c:out>" alt="Menu Image">
	                                    <c:out value="${menu}"></c:out>
	                                </div>
	                                <button class="btn btn-sm btn-primary">Select</button>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
