<%@page import="com.min.edu.dto.FreeBoard_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js" ></script>
<script type="text/javascript" src="./js/bootstrap.min.js" ></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="./css/modify.css">
</head>
<body>
<%
	FreeBoard_Dto dto = (FreeBoard_Dto)request.getAttribute("dto");
%>
<form action="./modify.do?selEtc=<%=dto.getB_type()%>" method="post">
	<input type="hidden" value="<%=dto.getSeq()%>" name="seq">
<table class="board_view">
	<%-- <%for(FreeBoard_Dto dto : lists){%> --%>
<tr>
	
	<th>아이디</th>	
		<td>
			<%=dto.getU_id()%>
		</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="title" value="<%=dto.getTitle()%>">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="5" cols="30" name="content"><%=dto.getContent()%></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center;">
				<input type="submit" class="btn btn-success" value="수정" style="position: relative; right: 10px;">
				<input type="reset" class="btn btn-primary" value="초기화">
				<input type="button" class="btn btn-secondary" value="뒤로가기" onclick="history.back(-1)"
				  style="position: relative; left: 10px;">
			</td>
		</tr>

		</table>
		</form>
</body>
</html>