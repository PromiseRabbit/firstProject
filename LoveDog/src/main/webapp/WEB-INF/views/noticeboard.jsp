<%@page import="com.min.edu.dto.User_Dto"%>
<%@page import="com.min.edu.dto.FreeBoard_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지게시판</title>
<style type="text/css">
body {
	width: 1000px;
	height: 700px;
}

table{
	position: relative;
	top: 230px;
	left: 420px;
}

table, th, td {
	background-color: white;
	border: 1px solid black;
 	border-collapse: collapse; 
	font-size: 0.95em;
	text-align: center;
	padding: 4px;
	z-index: 1;
}

th {
	background-color: skyblue;
}
</style>
</head>
<script type="text/javascript" src="./js/boardList.js"></script>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
<script type="text/javascript">
	function selView(){
		var objidx = document.getElementById('selEtc');
// 		alert(objidx.selectedIndex);
// 		alert(objidx.options[objidx.selectedIndex].value);
		location.href="./noticeboard.do?selEtc=A";
		
	}

	function writeForm(){
		location.href = "./write.do?selEtc=A";
	}

	function main(){
		location.href="./init.do";
	}
	
//	function delflag() {
//		location.href = "./delflag.do?selEtc=A";
//	}
	
	function goPage(pageNo){
		document.listForm.pageNo.value = pageNo;
		document.listForm.selEtc.value = "A";
		document.listForm.submit();
		console.log("pageNo : " + pageNo);
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
			document.getElementById("frm").action="./delflag.do";
			
		}else{
			alert("삭제할 게시글을 선택해주세요");
			return false;
		}
	}
	
	// 전체 체크
	function checkAll(bool){
		var obj = document.getElementsByName("chkVal");
//		alert(obj.length);
		for (var i = 0; i < obj.length; i++) {
			obj[i].checked = bool;
		}
	}
	
</script>
<body>

<%
   List<FreeBoard_Dto> lists = (List<FreeBoard_Dto>)request.getAttribute("lists");
   User_Dto udto =  (User_Dto) session.getAttribute("user");
%>
<form action="./delflag.do" method="post" id="frm" name="frm" onsubmit="return chkbox()">
<div class="panel-group" id="accordion">
   	  	<input type="hidden" name="selEtc" id="selEtc" value="A" onload="selViewA()">
		<table class="table table-bordered">
   <thead>
      <tr>
        <c:if test="${user.u_auth eq 'A'}">
			<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
		</c:if>	
		 <th>글 번호</th>
         <th>아이디</th>
         <th>제목</th>
         <th>등록일</th>
         <th>조회수</th>
         <c:if test="${user.u_auth eq 'A'}">
								<th>
									삭제여부								
								</th>
							</c:if>
         <!-- <th>b_type</th> -->
      </tr>
   </thead>

   <%for(FreeBoard_Dto dto : lists){%>
   <tbody>
      <tr>
   				<%
					if (dto.getDelflag().trim().compareToIgnoreCase("N") == 0) {
					%>
				<c:if test="${user.u_auth eq 'A'}">
					<td><input type="checkbox" name="chkVal" value="<%=dto.getSeq()%>"></td>
				</c:if>
					<td><%=dto.getSeq()%></td>
					<td><%=dto.getU_id()%></td>
					<td>
					<c:set var="dep" value="<%=dto.getDepth()%>"/>
					<c:if test="${dep > 0}">
					<c:forEach begin="1" end="${dep}">
                            &nbsp;&nbsp; <!-- 답변글일경우 글 제목 앞에 공백을 준다. -->
                        </c:forEach>
                       <!--  RE : -->
                       <img alt='답글' src='./image/reply.png'>
                    </c:if>
					<a href="detail.do?seq=<%=dto.getSeq()%>&b_type=<%=dto.getB_type()%>"><%=dto.getTitle()%></a>
					</td>
					<td><%=dto.getRegdate()%></td>
					<td><%=dto.getReadcount()%></td>
					<c:if test="${user.u_auth eq 'A'}">
					<td><%=dto.getDelflag()%></td>
					</c:if>
					<%-- <td><%=dto.getB_type()%></td> --%>
					<%
						}
					%>
					<!--  -->
					<%
					if (dto.getDelflag().trim().compareToIgnoreCase("Y") == 0) {
					%>
				<c:if test="${user.u_auth eq 'A'}">
					<td><input type="checkbox" name="chkVal" value="<%=dto.getSeq()%>"></td>
					<td><%=dto.getSeq()%></td>
					<td><%=dto.getU_id()%></td>
					<td>
					<c:set var="dep" value="<%=dto.getDepth()%>"/>
					<c:if test="${dep > 0}">
					<c:forEach begin="1" end="${dep}">
                            &nbsp;&nbsp; <!-- 답변글일경우 글 제목 앞에 공백을 준다. -->
                        </c:forEach>
                       <!--  RE : -->
                       <img alt='답글' src='./image/reply.png'>
                    </c:if>
					<a href="detail.do?seq=<%=dto.getSeq()%>&b_type=<%=dto.getB_type()%>"><%=dto.getTitle()%></a>
					</td>
					<td><%=dto.getRegdate()%></td>
					<td><%=dto.getReadcount()%></td>
					<td><%=dto.getDelflag()%></td>
					<%-- <td><%=dto.getB_type()%></td> --%>
					</c:if>
					<%
						}
					%>
					
					<%
						}
					%>
      </tr>
   </tbody>
</table>
<c:if test="${user.u_auth eq 'A'}">
		<input type="submit" id="delflag" class="btn btn-info" value="다중 삭제" style="position: absolute; top: 490px; left:1330px;">
</c:if>
</div>
</form>
		<!-- 페이징 -->
		<form name="listForm" action="./noticeboard.do" method="get" style="position: relative; left: 785px; top: 180px;">
			<input type="hidden" name="pageNo" value="" />
			<input type="hidden" name="selEtc" value="A" /> <br/><br/>
			<jsp:include page="paging.jsp" flush="true">
				<jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
				<jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
				<jsp:param name="startPageNo" value="${paging.startPageNo}" />
				<jsp:param name="pageNo" value="${paging.pageNo}" />
				<jsp:param name="endPageNo" value="${paging.endPageNo}" />
				<jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
				<jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
			</jsp:include>
		</form>
</div>

<form name="form1" action="./noticeboard.do" method="get" style="position: relative; left: 750px; top :180px;">
 	<input type="hidden" name="selEtc" value="A" />
    <select name="search_option" style="width: 70px;height: 22px;">
        <option value="u_id"> 작성자 </option>
        <option value="title"> 제목 </option>
        <option value="content"> 내용 </option>
    </select>
    <input type="text"  name="keyword" value="${map.keyword}">
    <input type="submit" value="조회">
</form>


<c:if test="${user.u_auth eq 'A'}">
	<input type="button" id="Nwrite" class="btn btn-primary" value="새글작성"
		onclick="writeForm()" style="position: absolute; left: 1100px; top :490px;">
</c:if>
	<input type="button" id="main" class="btn btn-info" value="메인으로 가기"
		onclick="main()" style="position: absolute; left: 1200px; top :490px;">
</body>
</html>


