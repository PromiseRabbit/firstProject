<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function submitCheck(){
		var password = document.getElementById("password");
		var phone = document.getElementById("phone");
		var email = document.getElementById("email");
		var regExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		
		if (add.value == "") {
			alert("비밀번호를 입력해주세요");	
			add.focus();
			return false;
		}else if(phone.value == ""){
			alert("전화번호를 입력해주세요");	
			phone.focus();
			return false;
		}else if(email.value == "" || email.value.match(regExp) == null){
			alert("이메일 값 및 형식을 확인 해주세요");	
			email.value ="";
			email.focus();
			return false;
		}
		return true;
	}
	</script>
<body>
${dto}
	<div>
		<img alt="돌아가기" src="">
		<h2 align="right">병원 정보 게시판</h2>
	</div>
	<h1>수정 화면</h1>
	<div>
		<form action="./modifyUser.do" method="post" onsubmit="return submitCheck()">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="u_id" value="${dto.u_id}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" id="u_password" value="${dto.u_password}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" id="u_email" value="${dto.u_email}"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" id="u_phone" value="${dto.u_phone}"></td>
				</tr>
			</table>
			
			<tr>
				<td>
					<input type="submit" value="작성 완료">
				</td>
			</tr>
		</form>
	</div>
</body>
</html>