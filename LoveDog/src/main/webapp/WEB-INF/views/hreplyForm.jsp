<%@page import="com.min.edu.dto.HongBoard_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글</title>
</head>
<body>
<script type="text/javascript">
<%
	List<HongBoard_Dto> lists = (List<HongBoard_Dto>)request.getAttribute("lists") ;
	HongBoard_Dto dto = lists.get(0);
%>
</script>
<form action="./hreply.do?u_id=<%=dto.getU_id()%>" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
	<input type="hidden" name="h_regi" value="<%=dto.getH_regi()%>">
	<table>
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
				<textarea id="txtArea" rows="5" cols="30" name="content" required="required"></textarea>
			</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=dto.getRegdate()%></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="답글입력">
				<input type="reset" value="초기화">
			</td>
		</tr>
	</table>
</form>

</body>
</html>