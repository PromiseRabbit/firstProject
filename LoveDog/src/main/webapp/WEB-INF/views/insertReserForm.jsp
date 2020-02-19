<%@page import="com.min.edu.dto.User_Dto" %>
<%@page import="javax.swing.event.ListSelectionEvent" %>
<%@page import="com.min.edu.dto.Reserv_Dto" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="./js/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<head>
    <%
        List<Reserv_Dto> rDto = (List<Reserv_Dto>) request.getAttribute("rDto");
    %>
    <%
        Object obj = session.getAttribute("user");
        User_Dto Udto = (User_Dto) obj;
    %>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        // 	$(function () {
        // 		var newR_Date = document.getElementById("newR_Date");

        // 		var r_date;
        // 		for (var i = 0; i  < newR_Date.options.length; i ++) {
        // 			if(newR_Date.options[i].selected==true){
        // 				var r_date = newR_Date.options[i].value;
        // 				alert(r_date);

        // 			}
        // 		}
        // 	})

        window.onload = function () {
            var r_date = document.getElementsByTagName("span");
// 		alert(r_date[0].innser);
            var newR_Date = document.getElementById("newR_Date");
            for (var i = 0; i < r_date.length; i++) {
// 				alert(r_date[i].innerHTML);
                var r_datev = r_date[i].innerHTML
                for (var j = 0; j < newR_Date.options.length; j++) {
// 				alert(newR_Date.options[j].value);
                    var newR_Datev = newR_Date.options[j].value;
                    if (r_datev == newR_Datev) {
                        newR_Date.options[j].setAttribute("disabled", "disabled");
                    }

                }
            }


        }

        $(function () {
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
                showMonthAfterYear: true, // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다.
                dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], // 요일의 한글 형식.
                monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'] // 월의 한글 형식.
            });

        });

    </script>
</head>
<body>
<jsp:include page="./header.jsp"/>
<div>
    <div>
        예약 검색
        <form action="./insertReser.do" method="post">
            <input type="text" class="calenderBtn" name="r_date"><br>
            <%-- 			<input type="hidden" value="<%=Udto.getU_name()%>" name="u_id"> --%>
            <input type="hidden" value="${hDetail.h_regi }" name="h_regi">
            <select name="time" id="newR_Date">
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
            </select> <select id="obj" onchange="objChk()" name="main_obj">
            <c:forEach items="${HObj}" var="ODto">
                <option value="${ODto.main_obj}">${ODto.obj_code}</option>
            </c:forEach>
        </select> <select id="obj_detail" name="obj_detail_code">
            <option>진료과를 입력하세요</option>
            <c:forEach items="${HAni}" var="ADto">
                <option value="${ADto.main_ani}">${ADto.ani_code}</option>
            </c:forEach>
        </select>
            <!-- 				<textarea rows="10" cols="100" name="r_content"></textarea> -->
            <input type="submit" value="예약 추가">
        </form>
        <c:forEach items="${rDto}" var="rDto">
            <c:set var="r_date" value="${rDto.r_date}"/>
            <%-- 					<input type="hidden" value="${fn:substring(r_date,8,14) }" id="r_date"> --%>
            <span class="r_date">${fn:substring(r_date,8,14) }</span>
        </c:forEach>
    </div>
</div>
</body>
</html>