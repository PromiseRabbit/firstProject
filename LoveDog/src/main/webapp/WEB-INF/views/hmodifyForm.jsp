<%@page import="com.min.edu.dto.HongBoard_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<style type="text/css">

	table, th, td{
			background-color : white;
			border: 1px solid black;
			border-collapse: collapse;
			font-size:0.95em;
			text-align:center;
			padding:4px;
		}
</style>
</head>
<body>
<%
	List<HongBoard_Dto> lists = (List<HongBoard_Dto>)request.getAttribute("lists") ;
	HongBoard_Dto dto = lists.get(0);
%>
<form action="./hmodify.do" method="post">
	<input type="hidden" value="<%=dto.getSeq()%>" name="seq">
<table>
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
				<input type="submit" value="수정">
				<input type="reset" value="초기화">
			</td>
		</tr>
		</table>
		</form>
</body>
</html>