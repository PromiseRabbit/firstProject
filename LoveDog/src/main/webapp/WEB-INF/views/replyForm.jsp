<%@page import="com.min.edu.dto.FreeBoard_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js" ></script>
<script type="text/javascript" src="./js/bootstrap.min.js" ></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="./css/reply.css">
</head>
<body>
<%
	FreeBoard_Dto dto = (FreeBoard_Dto)request.getAttribute("dto");
%>
<script type="text/javascript">

/* function contentCheck(){
	var obj1 = document.getElementById("hiddenContent").value;
	var obj2 = document.getElementById("txtArea").value;
	var obj3 = obj2.replace("원본글>","");
	
	if(obj1==obj3){
		document.getElementById("txtArea").value ="";
		document.getElementById("context").innerHTML = "내용";
	}
} */

</script>
<form action="./reply.do?u_id=<%=dto.getU_id()%>&selEtc=<%=dto.getB_type()%>" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
	<input type="hidden" name="b_type" value="<%=dto.getB_type()%>">
	<table class="board_view">
		<tr>
			<td>아이디</td>
			<td>
				<%=dto.getU_id()%>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="title" required="required">
			</td>
		</tr>
		<tr>
			<td id="context">답글 내용</td>
			<td>
				<input type="hidden" id="hiddenContent" value="<%=dto.getContent()%>">
				<textarea id="txtArea" rows="5" cols="30" name="content" required="required" onclick="contentCheck()"></textarea>
			</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=dto.getRegdate()%></td>
		</tr>
	</table>
		<input type="submit" class="btn btn-success" value="답글입력" style="position: relative; top: 15px; left: 240px;">
		<input type="reset" class="btn btn-primary" value="초기화" style="position: relative; top: 15px; left: 250px;">
		<input type="button" class="btn btn-secondary" value="뒤로가기" onclick="history.back(-1)" style="position: relative; top: 15px; left: 260px;">
</form>

</body>
</html>