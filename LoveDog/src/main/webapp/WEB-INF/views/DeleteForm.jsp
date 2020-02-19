<%@page import="com.min.edu.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table,tr{
		border : 1px solid black;
	}
	
	th,td{
		border : 1px solid black;
	}
	
</style>
</head>
<%
	User_Dto dto = (User_Dto) request.getAttribute("Dto");
%>
<body>
	<form action="./delete.do" method="post">
		<div>
		<h2><%=dto.getU_id()%>님 정말 탈퇴하시겠습니까?</h2>
			<table>
				<tr>
					<th>비밀번호 입력</th>
					<td>
						<input type="password" id="password" value="<%=dto.getU_password()%>">
					</td>
				</tr>
			</table>
				<tr>
					<td >
						<input type="button" value="취소" onclick="Cancel()">
						<input type="submit" value="탈퇴">
					</td>
				</tr>
		</div>
	</form>
</body>
</html>