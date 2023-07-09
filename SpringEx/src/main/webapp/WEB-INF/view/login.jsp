<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원로그인</title>
<script>
	function submitPage(){
		let frm = document.loginForm
		frm.submit();
	}
	<!-- gen 체크박스 하나만 선택하기 -->
	function gensOne(element) {
		const gens = document.getElementsByName("gen")
		gens.forEach((cb) => {
			cb.checked = false;
		})
		element.checked = true;
	}
	
	<!-- agree 체크박스 하나만 선택하기 -->
	function agreesOne(element){
		const agrees = document.getElementsByName("agree")
		agrees.forEach((cb) => {
			cb.checked = false;
		})
		element.checked = true;
	}
	
	
</script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style>
*{
	padding: 0; margin: 0; border: none;
}
body{
    font-size: 14px; font-family: 'Roboto', sans-serif;
}
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
input {
	outline: none;
}
input::placeholder {
	color: #8e8e8e; font-weight: 400;
}
.container {
	border: 0px solid black; width: 100%; height: 900px;
	display: flex; justify-content: center; position: relative;
}
.logo {
	position: absolute; top: 30px; font-size: 2rem; font-family: bold;
}
form {
	border: 0px solid black; width: 600px; height: 700px;
	position: absolute; top: 50%; transform: translate(0, -50%); 
	display: flex; justify-content: center;
}
.top {
	border: 1px solid #ccc; width: 80%; height: 700px;
	display: flex; justify-content: center; position: relative;
}
.name-box {
	border: 0px solid red; width: 350px; height: 50px;
	position: absolute; top: 40px; border-bottom: 3px solid #cccccc; 
}
.name-input {
	width: 350px; height: 48px; font-size: 16px;
}
.id-box {
	border: 0px solid red; width: 350px; height: 50px;
	position: absolute; top: 95px; border-bottom: 3px solid #cccccc; 
}
.id-input {
	width: 350px; height: 48px; font-size: 16px;
}
.pw-box {
	border: 0px solid red; width: 350px; height: 50px;
	position: absolute; top: 150px; border-bottom: 3px solid #cccccc; 
}
.pw-input {
	width: 350px; height: 48px; font-size: 16px;
}
.gen-box {
	border: 0px solid black; width: 130px; height: 50px;
	position: absolute; top: 215px; text-align: center; line-height: 50px;
	font-size: 16px; letter-spacing: 0px;
}
.tel1-box {
	border: 0px solid black; width: 270px; height: 50px;
	position: absolute; top: 265px; line-height: 50px;
}
.tel-select {
	width: 70px; height: 35px; border: 1px solid black; outline: none;
	border:none; border-bottom: 1px solid #cccccc; text-align: center;
}
.tel-input {
	width: 70px; height: 35px; border: 1px solid black; text-align: center;
	border:none; border-bottom: 1px solid #cccccc;
}
.major-box{
	width: 150px; height: 35px; border: 0px solid black;
	position: absolute; top: 325px;
}
.major-select {
	width: 100%; height: 34px; border: none; border-bottom: 1px solid #cccccc;
	outline: none; font-size: 15px; text-align: center;
}
.agree-box {
	width: 319px; height: 24px; border: 0px solid #ccc;
	position: absolute; top: 385px; line-height: 24px;
	text-align: center; border-bottom: 1px solid #cccccc;
}
.agree-input {
	
}
.memo-box {
	border: 0px solid black; width: 350px; height: 100px;
	position: absolute; top: 445px;
}
.memo-input {
    resize: none; word-break: break-all; border: 1px solid #ccc;
    width: 100%; height: 100px; outline: none;
}
.btn-box {
	border: 0px solid black; width: 350px; height: 50px;
	position: absolute; top: 590px; display: flex;
	justify-content: space-between;
}
.btn-input {
	border: 0px solid black; width: 90px; height: 40px;
	line-height: 35px; background: #FEE500; color: #191919;
	border-radius: 3px; text-align: center;
}
.btn {
	cursor: pointer; font-size: 14px;
}
.btn:hover {
	opacity: 0.7; transition: all 0.2s; color: #black;
}
</style>
</head>
<body>
<div class="container">
	<div class="logo"><span>회원가입</span></div>
	<form action="/login" method="post" id="loginForm" name="loginForm">
		<div class="top">
			<div class="name-box">
				<input type="text" class="name-input" name="name" placeholder="이름"/>
			</div>
			<div class="id-box">
				<input type="text" class="id-input" name="id" placeholder="아이디"/>
			</div>
			<div class="pw-box">
				<input type="password" class="pw-input" name="pw" placeholder="비밀번호"/>
			</div>
			<div class="gen-box">
				<input type="checkbox" class="gen-input" name="gen" onclick="gensOne(this)"/> 남자
				<input type="checkbox" class="gen-input" name="gen" onclick="gensOne(this)"/> 여자
			</div>
			<div class="tel1-box">
				<select name=tel1 class="tel-select">
					<option value="">선택</option>
					<option value="010">010</option>
					<option value="010">011</option>
					<option value="010">016</option>
					<option value="010">017</option>
					<option value="010">018</option>
					<option value="010">019</option>
				</select>
				<span> - </span>
				<input type="number" class="tel-input" name="tel2" placeholder="1234"/>
				<span> - </span>
				<input type="number" class="tel-input" name="tel3" placeholder="5678"/>
			</div>
			<div class="major-box">
				<select name="major" class="major-select">
					<option value="">전공 선택</option>
					<option value="컴퓨터공학과">컴퓨터공학과</option>
					<option value="수학과">수학과</option>
					<option value="국어국문학과">국어국문학과</option>
					<option value="경영학과">경영학과</option>
					<option value="식품영양학과">식품영양학과</option>
				</select>
			</div>
			<div class="agree-box">
				<span class="agreetext">개인정보 수집 ‧ 이용 ‧ 제공 동의 - </span>
				<input type="checkbox" class="agree-input" name="agree" checked="checked" onclick="agreesOne(this)"/> 동의
				<input type="checkbox" class="agree-input" name="agree" onclick="agreesOne(this)"/> 거부
			</div>
			<div class="memo-box">
				<textarea class="memo-input" name="memo" placeholder="메모를 입력하세요."></textarea>
			</div>
			<div class="btn-box">
				<div class="btn-input">
					<input type="button" class="btn" value="회원가입" onclick="submitPage()"/>
				</div>
				<div class="btn-input">
					<input type="reset" class="btn" value="새로작성" />
				</div>
			</div>
		</div>
	</form>
</div>
</body>
</html>