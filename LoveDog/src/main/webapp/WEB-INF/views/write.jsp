<%@page import="com.min.edu.dto.FreeBoard_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
<style type="text/css">
body {

  padding-top: 260px;
  padding-left :510px;
  padding-bottom: 30px;

}



</style>

<script type="text/javascript" src="./js/jquery-3.4.1.js" ></script>
<script type="text/javascript" src="./js/bootstrap.min.js" ></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<%
	FreeBoard_Dto mdto = (FreeBoard_Dto)request.getAttribute("mdto");
%> 

<body>
<div class="container" role="main">

<form action="./Nwrite.do?selEtc=<%=mdto.getB_type()%>" method="post">
<table>
		<tr>
			<td style="padding-bottom: 15px;">작성자 : &nbsp;${sessionScope.user.u_id}</td>
		</tr>
		<tr>
			<td style="padding-bottom: 15px;">제목&nbsp;<input type="text" class="form-control" name="title"></td>
		</tr>
		<tr>
			<td style="padding-bottom: 15px;">내용<br><textarea rows="5" cols="50" name="content" class="form-control"></textarea></td>
		</tr>
		<tr>
			<td style="padding-bottom: 15px;">File : <input type="file" name="f_name"></td>
		</tr>
</table>
		<input type="submit" id="insert" class="btn btn-primary" value="글등록">
		<input type="button" class="btn btn-secondary" value="뒤로가기" onclick="history.back(-1)">
		<input type="hidden" name="b_type" value="<%=mdto.getB_type()%>">
		<input type="hidden" name="seq" value="<%=mdto.getSeq()%>">
</form>
</div>
</body>
</html>

