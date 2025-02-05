<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>To-Do List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script>
	document
			.addEventListener(
					"DOMContentLoaded",
					function() {
						const taskInput = document.getElementById("taskInput");
						const addButton = document.getElementById("addButton");
						const taskList = document.getElementById("taskList");
						const titleInput = document
								.getElementById("titleInput");
						const authorInput = document
								.getElementById("authorInput");
						const saveButton = document
								.getElementById("saveButton");

						addButton
								.addEventListener(
										"click",
										function() {
											const task = taskInput.value.trim();
											if (task === "")
												return;

											const listItem = document
													.createElement("li");
											listItem.className = "list-group-item d-flex justify-content-between align-items-center";
											listItem.innerHTML = `${task} <button class="btn btn-danger btn-sm" onclick="removeTask(this)">삭제</button>`;
											taskList.appendChild(listItem);

											taskInput.value = "";
										});

						saveButton.addEventListener("click", function() {
							const title = titleInput.value.trim();
							const author = authorInput.value.trim();
							if (title === "" || author === "") {
								alert("제목과 작성자를 입력하세요.");
								return;
							}
							alert(`제목: ${title}\n작성자: ${author}\n저장되었습니다.`);
						});
					});

	function removeTask(button) {
		button.parentElement.remove();
	}
</script>
</head>
<body>
	<div class="container mt-4">
		<h1 class="mb-4">To-Do List</h1>
		<form action="/todo/add" method="post" >
			<div class="mb-3">
				<label for="titleInput" class="form-label">제목</label>
				<input type="text" name="title" class="form-control"
					placeholder="제목을 입력하세요">
			</div>
			<div class="mb-3">
				<label for="authorInput" class="form-label">작성자</label>
				<input type="text" name="writer" class="form-control"
					placeholder="작성자를 입력하세요">
			</div>
			<button class="btn btn-success mb-4">추가</button>
		</form>
	</div>
</body>
</html>
