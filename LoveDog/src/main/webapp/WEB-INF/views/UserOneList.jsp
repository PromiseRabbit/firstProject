<%@page import="com.min.edu.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 상세보기</title>
<style type="text/css">
body {
	width: 550px;
	height: 700px;
}

table, th, td {
	background-color: white;
	border: 1px solid black;
 	border-collapse: collapse; 
	font-size: 0.95em;
	text-align: center;
	padding: 4px;
}

th {
	background-color: skyblue;
}

</style>
</head>
<%
	User_Dto dto = (User_Dto)request.getAttribute("dto");
%>
<body>
	<div>
	<img alt="프로필 사진" src="">
	
		<table>
			<tr>
				<th>아이디</th>
				<td><%=dto.getU_id() %> </td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%=dto.getU_name() %> </td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><%=dto.getU_phone() %> </td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=dto.getU_email() %> </td>
			</tr>
		</table>
		<div>
			<tr>
				<td>
					<input type="button" value="병원 신청" onclick="H_sin()">
					<input type="button" value="회원 수정" onclick="UserModify()">
					<input type="button" value="회원 탈퇴" onclick="deleteForm()">
				</td>
			</tr>
		</div>
	</div>

	<script type="text/javascript">
		function deleteForm() {
// 			alert("작동");
			location.href="./delete.do";
		}
		
		function UserModify() {
// 			alert("ok");
			location.href = "./modifyUserForm.do";
		}
	</script>
</body>
</html>