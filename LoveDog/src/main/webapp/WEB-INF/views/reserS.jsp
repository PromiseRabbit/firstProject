<%@page import="com.min.edu.dto.AllObj_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="./js/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script src="./jquery-ui-1.12.1/datepicker-ko.js"></script> -->


<html>
<%
	List<AllObj_Dto> lists = (List<AllObj_Dto>)request.getAttribute("lists");
%>
<head>
<script type="text/javascript">

$(function(){
	$(".calenderBtn").datepicker({
		altField: ".calender",
		showOn: "button",
		buttonImage: "./image/calender1.png", // 버튼 이미지
		buttonImageOnly: true, // 버튼에 있는 이미지만 표시한다.
		minDate: 0,
		maxDate: "+1M +20D",
		selectOtherMonths: true,
		dateFormat: "yy년 mm월 dd일",
		firstDay: 0,
		showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], // 요일의 한글 형식.
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] // 월의 한글 형식.
	});
	
});

function objChk() {
	var objcc = document.getElementById("obj");
	var val;
	
	for(i=0; i<objcc.options.length; i++) {
		if(objcc.options[i].selected == true) {
	        val = objcc.options[i].value;
	        break;
	    }
	}
// 	alert(val);
	jQuery.ajax({
		type : "post",
		url:"./objAjax.do",
		data:"main_obj="+val,
		success: function(data){
			var appendhtml;
			for (var i = 0; i < data.DLists.length; i++) {
				appendhtml += "<option value="+data.DLists[i].obj_detail_code+">";
				appendhtml += data.DLists[i].obj_content;
				appendhtml += "</option>";
			}
			
			
			
			$("#obj_detail").empty();
			$("#obj_detail").append(appendhtml);
		}

			
	});
// 	alert(val);
	var objd = document.getElementById("obj_detail");
	var vald;
	
	for(i=0; i<objd.options.length; i++) {
		if(objd.options[i].selected == true) {
	        vald = objd.options[i].value;
	        break;
	    }
	}
// 	alert(vald);
}

</script>
<script type="text/javascript"></script>
<title>사랑하개</title>
<style type="text/css">

</style>
</head>
<jsp:include page="./header.jsp"/>
<body>

${hdto }
	<div>
		<div>
			<a>예약 신청</a>
			<a>예약 조회 : 사용자</a>
			<a>예약 수정</a>
		</div>
	</div>
	
	<div>
		<div>
			예약 검색
			<form action="./serchReser.do">
				<input type="text" class="calenderBtn" name="r_date"><br>
			<select name="time">
				<option>--예약 시간--</option>                                               
				<option value="090000">9시</option>                                             
				<option value="100000">10시</option>                                            
				<option value="110000">11시</option>                                            
				<option value="120000">12시</option>                                            
				<option value="130000">13시</option>                                            
				<option value="140000">14시</option>                                            
				<option value="150000">15시</option>                                            
				<option value="160000">16시</option>                                            
				<option value="170000">17시</option>                                            
				<option value="180000">18시</option>                                            
				<option value="190000">19시</option>                                            
				<option value="200000">20시</option>
			</select>
			<select id="obj" onchange="objChk()" name="main_obj">
			<c:forEach items="${lists}" var="code">
				<option value="${code.main_obj}">${code.obj_code}</option>
			</c:forEach>
			</select>
			<select id="obj_detail" name="obj_detail_code">
				<option>진료과를 입력하세요</option>
			</select>
			
			<input type="submit" value="검색">
			</form>
		</div>
	</div>

</body>

</html>
