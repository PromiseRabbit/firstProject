<%@page import="com.min.edu.dto.Hospi_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원 목록</title>
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
<title>병원목록 페이지</title>
<%
		Object obj = request.getAttribute("lists");
		List<Hospi_Dto> lists = (List<Hospi_Dto>) obj;
%>

</head>
<body>
	<jsp:include page="./header.jsp"/>
	
	<div class="HListDiv">
	<h2>병원목록입니다.</h2>
	
		<table id="HList">
			<thead>
				<tr>
					<th>회원아이디</th>
					<th>병원이름</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>진료과</th>
					<th>진료동물</th>
					<th>사업자등록증</th>
					<th>권한</th>
				</tr>
			</thead>
			
			<tbody>
			
				<% 
					for(Hospi_Dto dto : lists){
				%>
			
		<tr>
			<td><a href="./HospiDnM.do?u_id=<%=dto.getU_id() %>"><%=dto.getU_id() %></a></td>
			<td><a><%=dto.getH_name() %></a></td>
			<td><a><%=dto.getH_phone() %></a></td>
			<td><a><%=dto.getH_mail() %></a></td>
			<td><a><%=dto.getObj_code() %></a></td>
			<td><a><%=dto.getAni_code() %></a></td>
			<td><a><%=dto.getH_regi() %></a></td>
			<td><a><%=dto.getH_enable() %></a></td>
		</tr>
		
			</tbody>
			
				<%
					}
				%>
			
		</table>
		
	<input type="button" name="btn" value="신청대기자" onclick="awaitHospital()">
	<input type="button" value="뒤로가기" onclick="history.back(-1)">
	
	</div>
	
	<script type="text/javascript">
		function awaitHospital() {
// 			regi = $("#hregi").val;
// 			alert(regi);
			location.href="./regist.do?";
		}
		
		
	
		
	</script>

	
	
</body>
</html>