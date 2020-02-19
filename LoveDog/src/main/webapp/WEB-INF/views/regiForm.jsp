<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join us</title>
<style type="text/css">
table {
	width: 700px;
	position: absolute;
	left: 300px;
	top: 220px;
}
	
#btt{
	position: relative;
	top: 12px;
	right: 125px;
}	


</style>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
<script type="text/javascript">

/* function check() {
	var name = document.getElementById("name").value;
	var id = document.getElementById("id").value;
	var pw = document.getElementById("password").value;
	var passOk = document.getElementById("passOk").value;
	var chkId = document.getElementById("chkval").value;
	
	alert(name+":"+id+":"+password+":"+passOk+":");
	
	if(pw != passOk){
		alert("Sign in Error occured. ","Check Your Password again");
		return false;
	}else if(chkId=="0"){
		alert("Sign in Error occured. ","Check Your ID again");
		return false;
	}else if(i_agree2 == false){
		alert("Sign in Error occured. ","Please Accept policy about take Your information (needed)");
		return false;
	}else{
		return true;
	}
} */


function regiCheck(){
	var name = document.getElementById("name").value;
	var id = document.getElementById("id").value;
	var pw = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	var f_name = document.getElementById("f_name").value;
	
	jQuery.ajax({
        type : "post",
        url : "./regist.do",
        data : "u_id="+id+"&u_password="+pw+"&u_name="+name+"&u_phone="+phone+"&u_email="+email+"&f_name"+f_name,
		success : function (data) {
			alert(data.u_id);
			alert(data.u_password);
			alert(data.u_name);
			alert(data.u_phone);
			alert(data.u_email);
		}
});
};
</script>

<body>
	<form action="./regist.do" method="post" enctype="multipart/form-data" >
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" title ="n" name="id" id="id" placeholder="아이디">
					
				</td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td>
					<input type="password" name="pw" id="password" placeholder="비밀번호">
				</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td>
					<input type="text" name="name" id="name" required="required" placeholder="성함">
				</td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td>
					<input type="text" name="phone" id="phone" required="required" placeholder="연락처">
				</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td>
					<input type="text" name="email" id="email" placeholder="이메일">
					<!-- <input type="button" value="Checking Email" onclick="emailCheck()">  -->
				</td>
			</tr>
			
			<tr>
				<th>File</th>
				<td>
					<input type="file" name="file" id= "f_name" placeholder="회원사진" onchange="readURL(this)">
				</td>
			</tr>
			
			<tr>
				<th colspan="2" id="btt">
					<input type="button" class="btn btn-primary" value="회원가입완료" onclick="regiCheck()">
					<input type="button" class="btn btn-info" value="뒤로가기" onclick="history.back(-1)">	
				</th>
			</tr>
		</table>	
	</form>
</body>
</html>
