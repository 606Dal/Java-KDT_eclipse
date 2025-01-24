<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>뱀주사위 놀이</title>
	<script type="text/javascript">
        // JSP 변수 (currentTile.num)을 자바스크립트로 전달
        var currentTileNum = <c:out value="${currentTile.num}" />;
        
        	// 주사위 던지기 버튼 클릭 시 처리
            function rollDice(event) {
                // currentTile.num 값이 100이면 게임 완료 처리
                if (currentTileNum === 100) {
                    alert("게임이 완료되었습니다!");
                    // 주사위 던지기 버튼 비활성화
                    document.getElementById("rollDiceBtn").disabled = true;
                    // form 제출 방지
                    event.preventDefault();
                } else {
                    // 주사위 던지기 로직 (예: 주사위 값 변경 및 UI 갱신 등)
                    alert("주사위 던지기!");
                    // 주사위 던진 후 currentTileNum을 업데이트하거나 다른 처리를 할 수 있음
                }
            } //end rollDice()
    </script>
</head>
<body>
	<div class="container">
		<h1>뱀주사위 놀이 게임</h1>

		<p>
			<strong>주사위 값: <%= request.getParameter("diceValue") %></strong>
			<c:out value="${diceValue}"></c:out></p>

		<h3>
			현재 위치:<c:out value="${currentTile.num}"></c:out> 번 타일
		</h3>
		<p>
			<strong>타일 설명:</strong>
			<c:out value="${currentTile.desc}"></c:out></p>
		<p>
			<strong>타일 유형:</strong>
			<c:out value="${currentTile.type}"></c:out></p>

		<!-- 주사위 굴리기 버튼 -->
		<form method="post" action="game" >
			<input type="submit" id="rollDiceBtn" class="btn" name="roll" value="주사위 굴리기">
		</form>

		<br> <br>
		<p>
			<strong>게임을 계속 진행하려면 '주사위 굴리기' 버튼을 눌러주세요!</strong>
		</p>
	</div>
</body>
</html>
