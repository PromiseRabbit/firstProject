<%@page import="java.util.Arrays"%>
<%@page import="com.min.edu.dto.Obj_Dto"%>
<%@page import="com.min.edu.dto.Reserv_Dto"%>
<%@page import="com.min.edu.dto.Hospi_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
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
<title>병원 상세보기 페이지</title>
<%
		Hospi_Dto hdto = (Hospi_Dto)request.getAttribute("dto");
%>

</head>
<body>
	<jsp:include page="./header.jsp"/>
	<h2>병원 상세페이지입니다.</h2>
	<table>
		<thead>
				<tr>
					<th>사업자등록증</th>
					<td><%=hdto.getH_regi()%></td>
				</tr>
		</thead>
		<tbody>
				<tr>
					<th>회원아이디</th>
					<td><%=hdto.getU_id()%></td>
				</tr>
				
				<tr>
					<th>병원이름</th>
					<td><%=hdto.getH_name()%></td>
				</tr>
				
				<tr>
					<th>주소</th>
					<td><%=hdto.getH_address()%></td>
				</tr>
				
				<tr>
					<th>전화번호</th>
					<td><%=hdto.getH_phone()%></td>
				</tr>
				
				<tr>
					<th>이메일</th>
					<td><%=hdto.getH_mail()%></td>
				</tr>
				
				<tr>
					<th>진료과</th>
						<c:forEach var="dt"  items="${Ldto}">
														<td>${dt.obj_code}</td> 						
						</c:forEach>
<!-- 					<select name='fruits' size='7'> -->
<!-- 						  <option value='' selected>-- 선택 --</option> -->
<!-- 						  <option value='apple'>사과</option> -->
<!-- 						  <option value='banana'>바나나</option> -->
<!-- 						  <option value='lemon'>레몬</option> -->
<!-- 					</select> -->
				</tr>
				
				<tr>
					<th>진료동물</th>
						<c:forEach var="dt2"  items="${Hdto}">
						<td>${dt2.ani_code}</td> 						
						</c:forEach>
				</tr>
				
				<tr>
					<th>권한</th>
					<td><%=hdto.getH_enable()%></td>
					<td>(신청완료자 : N / 신청자 : Y / 회원 정지 : D)</td>
				</tr>

			</tbody>
			
	</table>
	
			<input type="button" id="HospitalModify" value="수정하기" onclick="HospitalModify('<%=hdto.getU_id()%>')">
			<input type="button" name="btn" value="뒤로가기" onclick="back()">
	
	<script type="text/javascript">
	
	function back() {
		location.href="./HospiList.do";
	}
	
	
	function HospitalModify(u_id) {
		alert("병원 수정화면으로 이동합니다.");
// 		var u_id = document.getElementById("u_id").innerHTML;
// 		location.href="./HospitalModify.do?u_id="+u_id;
		location.href="./HospitalModify.do?u_id="+u_id;
	}
	</script>
	
	
</body>
</html>