<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 가입 결과</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous">
</script>
<style>
*{
	padding: 0; margin: 0; border: none;
}
body{
    font-size: 14px; font-family: 'Roboto', sans-serif;
}
.div1 {
	border: 0px solid black; width: 100%; height: 950px;
}
.div-header {
	border: 0px solid red; width: 100%; height: 100px;
	display: flex; justify-content: center;
}
.head {
	border: 0px solid black; width: 700px; height: 100px;
	display: flex; justify-content: center; position: relative;
}
.head-textbox {
	border: 0px solid blue; width: 300px; height: 50px;
	text-align: center; line-height: 50px; font-size: 2rem;
	position: absolute; top: 50%; transform: translate(0, -50%);
}
.bigdiv {
	display: flex; justify-content: center;
}
.div-body {
	border: 1px solid #ccc; width: 70%; height: 750px;
	display: flex; justify-content: center;
}
table {
	width: 80%; height: 100px;
}
.thead {
	width: 100%; height: 50px; border: 0px solid black;
}
.tr-head {
	border: 0px solid black; text-align: center; height: 40px;
	line-height: 40px;
}
.head-name {
	border: 0px solid black; width: 100px;
}
.head-id {
	border: 0px solid black; width: 150px;
}
.head-pw {
	border: 0px solid black; width: 200px;
}
.head-gen {
	border: 0px solid black; width: 50px;
}
.head-tel {
	border: 0px solid black; width: 180px;
}
.head-major {
	border: 0px solid black; width: 100px;
}
.head-agree {
	border: 0px solid black; width: 80px;
}
.tbody {
	border: 0px solid black; text-align: center;
}
</style>
</head>
<body>
<div class="div1">
	<div class="div-header">
		<header class="head">
			<div class="head-textbox">
				<span class="head-text">
					회원 가입 결과
				</span>
			</div>
		</header>
	</div>
	<div class="bigdiv">
		<div class="div-body">
			<table class="table table-striped">
				<thead class="thead">
					<tr class="tr-head">
						<th class="head-name">이름</th>
						<th class="head-id">아이디</th>
						<th class="head-pw">패스워드</th>
						<th class="head-gen">성별</th>
						<th class="head-tel">핸드폰번호</th>
						<th class="head-major">전공</th>
						<th class="head-agree">동의여부</th>					
						<th class="head-memo">메모</th>					
					</tr>
				</thead>
				<tbody class="tbody">
					<tr class="tr-body">
						<td><%=session.getAttribute("name") %></td>
						<td><%=session.getAttribute("id") %></td>
						<td><%=session.getAttribute("pw") %></td>
						<td><%=session.getAttribute("gen") %></td>
						<td>
							<%=session.getAttribute("tel1") %> -
							<%=session.getAttribute("tel2") %> -
							<%=session.getAttribute("tel3") %>
						</td>
						<td><%=session.getAttribute("major") %></td>
						<td><%=session.getAttribute("agree") %></td>
						<td><%=session.getAttribute("memo") %></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>