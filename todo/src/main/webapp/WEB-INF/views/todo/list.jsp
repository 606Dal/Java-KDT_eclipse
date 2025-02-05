<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>To-Do List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script>
	/* ; 세미콜론 없어도 됨 */
	const result = '${param.result}';
	// 리다이렉트 했을 때 + 경고창 나온 이후 ?뒤에 삭제
	if(result === 'add'){
		window.alert("새로운 Todo가 등록되었습니다.");
		window.history.pushState(null, "", "?");
	}
</script>
</head>
<body>
${dtoList}
	<div class="container mt-4">
		<h1 class="mb-4">To-Do List</h1>
		<div class="mb-3 d-flex justify-content-end">
			<a href="/todo/add"><button id="addButton" class="btn btn-primary">새로운 Todo 추가</button></a>
		</div>
		<ul id="taskList" class="list-group">
			<li
				class="list-group-item d-flex justify-content-between align-items-center">
				예제 할 일 1
				<button class="btn btn-danger btn-sm" onclick="removeTodo(this)">삭제</button>
			</li>
			<li
				class="list-group-item d-flex justify-content-between align-items-center">
				예제 할 일 2
				<button class="btn btn-danger btn-sm" onclick="removeTodo(this)">삭제</button>
			</li>
			<li
				class="list-group-item d-flex justify-content-between align-items-center">
				예제 할 일 3
				<button class="btn btn-danger btn-sm" onclick="removeTodo(this)">삭제</button>
			</li>
		</ul>
	</div>
</body>
</html>
