<%@page import="com.min.edu.dto.User_Dto"%>
<%@page import="com.min.edu.dto.FreeBoard_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js" ></script>
<script type="text/javascript" src="./js/bootstrap.min.js" ></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="./css/detail.css">
</head>
<%
	FreeBoard_Dto dto = (FreeBoard_Dto)request.getAttribute("lists");
	User_Dto ddto = (User_Dto)request.getAttribute("tdto");
%>
<body>
<script type="text/javascript">
function modifyjs(){
//	alert("a");
	location.href="./modifyForm.do?seq="+<%=dto.getSeq()%> + "&selEtc=" + '<%=dto.getB_type()%>';
}

function replyjs(){
//	alert("a");
	location.href="./replyForm.do?seq="+<%=dto.getSeq()%>;
}

function deletejs(){
//	alert("a");
	location.href="./del.do?seq="+<%=dto.getSeq()%> + "&selEtc=" + '<%=dto.getB_type()%>';

}



</script>
<table class="board_view">
	<tbody>
		<tr>
			<th style="width: 111px;">글 번호</th>
			<td><%=dto.getSeq()%></td>
			<th>조회수</th>
			<td><%=dto.getReadcount()%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=dto.getU_id()%></td>
			<th>등록일</th>
			<td><%=dto.getRegdate()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle()%></td>
			<th>첨부파일</th>
			<c:set var="fnn" value="<%=dto.getF_name()%>"/>
			<c:choose>
			<c:when test="${null == fnn}">
				<td>첨부파일 없음</td>
			</c:when>
			<c:otherwise>
			<td><%=dto.getF_name()%></td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<!-- <th>내용</th> -->
			<td colspan="4"><%=dto.getContent()%></td>
		</tr>
	</tbody>
</table>
	<form class="btnn">
	<c:set var="idd" value="<%=dto.getU_id()%>"/>
	<c:if test="${sessionScope.user.u_id == idd}">
		<input type="button" id="modifyForm" class="btn btn-success" value="수정" onclick="modifyjs()">
		<input type="button" id="delBoard" class="btn btn-danger" value="삭제" onclick="deletejs()">
	</c:if>
		<input type="button" id="replyForm" class="btn btn-primary" value="답글" onclick="replyjs()">
		<input type="button" class="btn btn-info" value="뒤로가기" onclick="history.back(-1)">
	</form>
	


</body>
</html>












