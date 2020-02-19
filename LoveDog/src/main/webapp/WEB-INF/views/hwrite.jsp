<%@page import="com.min.edu.dto.HongBoard_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js" ></script>
<script type="text/javascript" src="./js/bootstrap.min.js" ></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<%-- <%
	HongBoard_Dto dto = (HongBoard_Dto)request.getAttribute("dto");
%>  --%>

<body>
<form action="./hwritef.do" method="post">
<table>
		<tr>
			<td>작성자&nbsp;${sessionScope.user.u_id}</td>
		</tr>	
		<tr>
			<td>제목&nbsp;<input type="text" name="title"></td>
		</tr>
		<tr>
			<td>내용<br><textarea rows="5" cols="50" name="content"></textarea></td>
		</tr>
		<tr>
			<td>사업자등록번호&nbsp;<input type="text" name="h_regi"></td>
		</tr>
		<tr>
			<td>파일 업로드<input type="file" id="file" name="f_name"></td>
		</tr>
</table>
		<input type="submit" id="insert" class="btn btn-primary" value="글등록">
		<%-- <input type="hidden" name="seq" value="<%=dto.getSeq()%>"> --%>

</form>
</body>
</html>

