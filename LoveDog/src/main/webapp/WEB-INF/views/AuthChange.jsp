<%@page import="com.min.edu.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	User_Dto dto = (User_Dto) request.getAttribute("dto");
%>
<body>
	<div>
		<table>
			<tr>
				<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>권한</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getU_id()%>"></td>
				<td><%=dto.getU_id()%></td>
				<td><%=dto.getU_name()%></td>
				<td><%=dto.getU_phone()%></td>
				<td><%=dto.getU_email()%></td>
				<td><%=dto.getU_auth()%></td>
			</tr>
		</table>
		<tr>
			<td>
				<input type="button" value="추가">
				<input type="button" value="수정">
				<input type="button" value="삭제">
			</td>
		</tr>
	</div>
	<script type="text/javascript">
	function checkAll(bool){
		var chk = document.getElementsByName("chk");
		for (var i = 0; i < chk.length; i++) {
			chk[i].checked = bool;
		}
	}
	</script>
</body>
</html>