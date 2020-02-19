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
<title>병원 대기 상세보기 페이지</title>
<%
		Hospi_Dto hdto = (Hospi_Dto)request.getAttribute("dto");
// 		List<Hospi_Dto> Ldto = (List<Hospi_Dto>) request.getAttribute("Ldto");
		String[] adto = (String[])request.getAttribute("adto");
// 		String[] bdto = (String[])request.getAttribute("bdto");
%>

</head>
<body>
	<jsp:include page="./header.jsp"/>

<%-- &h_name=<%=hdto.getH_name() %> --%>
	<form action="./addHospital.do?u_id=<%=hdto.getU_id()%> &h_name=<%=hdto.getH_name() %>" method="post" onsubmit="return changeAuth()">
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
					<td id="u_id"><%=hdto.getU_id()%></td>
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
					<th>권한수정</th>
					<td id="chkAuth"><%=hdto.getH_enable()%></td>
					<td>
					<select id='chageAuth'>
						  <option value=''>-- 권한수정 --</option>
						  <option value='N' >신청완료자 : N</option>
						  <option value='Y' >신청자 : Y</option>
					</select>
					<input type="button" value="권한변경" onclick="changeAuth()">
					</td>
				</tr>


			</tbody>
			
			
	</table>
			<input type="button" onclick="javascript:location.href='./HospiList.do'" value="병원추가" >
			<input type="button" name="btn" value="뒤로가기" onclick="back()">
	</form>
	
	<script type="text/javascript">
	
	function changeAuth() {
		var chageAuth = $("#chageAuth");
		var auth;
		
		var idx = document.getElementById("chageAuth").selectedIndex;
		var val = document.getElementById("chageAuth").options[idx].value;
		var u_id = document.getElementById("u_id").innerHTML;
		
		document.getElementById("chkAuth").innerHTML = val;
		alert("사업자등록증 번호를 반드시 확인해주세요.");
		location.href="./authChange.do?role="+val+"&u_id="+u_id;
	}
	
	
	function back() {
		location.href="./regist.do";
	}
	</script>
	
	
</body>
</html>