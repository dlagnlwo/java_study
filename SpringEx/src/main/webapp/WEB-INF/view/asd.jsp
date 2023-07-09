<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
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
input{
    font-family: 'Noto Sans KR','Noto Sans Korean', "Nanum Gothic", sans-serif !important;
    -webkit-appearance: none; -webkit-border-radius: 0; border: 0;
    outline: none; font-size: 10px;
}
input::placeholder{
  	color: #d9d9d9
}
.dust-class{
  	width: 40%; box-sizeing: border-box; margin: 20px auto; position: relative;
}
.dust-class label{
	display: inline-block; position: absolute; top: -12px; left: 14px;
	padding: 10px; background: white; font-size: 14px; color: #888;
	font-weight: bold; border: 0px solid black; height: 30px;
}
.dust-class.ver2 label{
  	top: initial; bottom: -15px; border: 0px solid black;
  	line-height: 10px;
}
.dust-class label span{
  	color: #da4841; vertical-align: -1px;
}
.dust-class input{
    width: 100%; border: 1px solid #dddddd !important;
    font-size: 1rem; line-height: 1.45; letter-spacing: -0.04rem;
    border-radius: 8px; padding: 16px; margin-top: 12px;
}
.div1 {
	border: 1px solid black; width: 100%; height: 900px;
}
</style>
</head>
<body>
<div class="div1">
	<form>
		<div class="dust-class">
			<label for="itemname"><span>* </span>아이디</label>
			<input type="text" class="id_text" placeholder="아이디를 입력해주세요." />
		</div>
		<div class="dust-class">
			<label for="itempw"><span>* </span>비밀번호</label>
			<input type="password" class="pw_text" placeholder="비밀번호를 입력해주세요." value="">
		</div>
		<div class="dust-class ver2">
			<label for="itemnew"><span>* </span>밑에서 입력</label>
			<input type="text" class="txt-input" placeholder="label 위치를 확인해보세요." value="">
		</div>
	</form>	
</div>
</body>
</html>