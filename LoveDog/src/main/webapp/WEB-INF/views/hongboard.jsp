<%@page import="com.min.edu.dto.HongBoard_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원 정보 게시판</title>
<style type="text/css">
body {
	width: 700px;
	height: 700px;
}

   table, th, td{
         background-color : white;
         border: 1px solid black;
         border-collapse: collapse;
         font-size:0.95em;
         text-align:center;
         padding:4px;
      }
      
   th{background-color:skyblue;}
</style>
</head>
<script type="text/javascript" src="./js/boardList.js"></script>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
<script type="text/javascript">
	function writeForm(){
		location.href="./hwrite.do";

	}

	function main(){
		location.href="./init.do";
	}
	
	function chkbox(){
		var obj = document.getElementsByName("chkVal");
		var n= 0;
		for (var i = 0; i < obj.length; i++) {
			if(obj[i].checked){
				n++;
			}
		}
		if(n>0){
			document.getElementById("frm").action="./hdelflag.do";
			
		}else{
			swal("게시글 삭제오류",'삭제 값이 없습니다.');
			return false;
		}
	}
	
</script>
<body>
<%
	List<HongBoard_Dto> lists = (List<HongBoard_Dto>)request.getAttribute("lists");
%>
<form action="./hdelflag.do" method="post" id="frm" name="frm" onsubmit="return chkbox()">
	<div class="panel-group" id="accordion">
<table class="table table-bordered">
	<thead>
      <tr>
      	 <th>선택</th>
         <th>seq</th>
         <th>u_id</th>
         <th>title</th>
         <th>regdate</th>
         <th>readcount</th>
         <th>regi</th>
      </tr>
   </thead>

   <%for(HongBoard_Dto dto : lists){%>
   <tbody>
      <tr>
      	<td><input type="checkbox" name="chkVal" value="<%=dto.getSeq()%>"></td>
         <td><%=dto.getSeq()%></td>
         <td><%=dto.getU_id()%></td>
         <td><a href="hdetail.do?seq=<%=dto.getSeq()%>&h_regi=<%=dto.getH_regi()%>"><%=dto.getTitle()%></a></td>
         <td><%=dto.getRegdate()%></td>
         <td><%=dto.getReadcount()%></td>
         <td><%=dto.getH_regi()%></td>
      <%
   }
      %>
      </tr>
   </tbody>
</table>
<c:if test="${user.u_auth eq 'A'}">
<input type="submit" id="hdelflag" class="btn btn-info" value="다중 삭제">
</c:if>
</div>
</form>
<c:if test="${user.u_auth eq 'A'}">
<input type="button" id="hwrite" class="btn btn-primary" value="새글작성" onclick="writeForm()">
</c:if>
<input type="button" id="main" class="btn btn-info" value="메인으로 가기" onclick="main()">
</body>
</html>









