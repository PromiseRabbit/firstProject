<%@page import="com.min.edu.dto.AllObj_Dto" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="./js/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script src="./jquery-ui-1.12.1/datepicker-ko.js"></script> -->


<html>
<%
    List<AllObj_Dto> lists = (List<AllObj_Dto>) request.getAttribute("lists");
%>
<head>
    <script type="text/javascript">

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

        function objChk() {
            var objcc = document.getElementById("obj");
            var val;

            for (i = 0; i < objcc.options.length; i++) {
                if (objcc.options[i].selected == true) {
                    val = objcc.options[i].value;
                    break;
                }
            }
// 	alert(val);
            jQuery.ajax({
                type: "post",
                url: "./objAjax.do",
                data: "main_obj=" + val,
                success: function (data) {
                    var appendhtml;
                    for (var i = 0; i < data.DLists.length; i++) {
                        appendhtml += "<option value=" + data.DLists[i].obj_detail_code + ">";
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

            for (i = 0; i < objd.options.length; i++) {
                if (objd.options[i].selected == true) {
                    vald = objd.options[i].value;
                    break;
                }
            }
// 	alert(vald);
        }

        function modify(d, s, f) {
            alert("예약을 삭제하고 다시 신청 하시겠습니까?");
            document.getElementById("r_date");
            location.href = "./Rmodify.do?r_status=" + d + "&r_date=" + s+"&seq="+f;
        }

    </script>
    <script type="text/javascript"></script>
    <title>사랑하개</title>
    <style type="text/css">

    </style>
</head>
<jsp:include page="./header.jsp"/>
<body>
<table>

    <tr>
        <c:choose>
            <c:when test="${u_auth.u_auth eq 'H'}">
                <th>예약한 사람 아이디</th>
            </c:when>

            <c:otherwise>
                <th>예약한 병원</th>
            </c:otherwise>

        </c:choose>
        <th>예약 날짜</th>
        <th></th>
        <th><input type="checkbox">전체 선택</th>
    </tr>
    <c:choose>
        <c:when test="${u_auth.u_auth eq 'H'}">
            <c:forEach items="${lists }" var="hospi">
                <tr>
                    <td>${hospi.u_id}</td>
                    <td>${hospi.r_date}</td>
                    <td><input type="checkbox"></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <c:forEach items="${Ulists}" var="user">
                <tr>
                    <td>${user.h_name}</td>
                    <td id="r_date">${user.r_date}</td>
                    <td>
                        <button onclick="modify('${user.r_status}','${user.r_date}','${user.seq}')">수정</button>
                    </td>
                    <td>
                    	<input type="checkbox">
                    </td>
                </tr>
            </c:forEach>
                    <td>
                    	<input type="button" value="삭제">
                    </td>
        </c:otherwise>
    </c:choose>
</table>

</body>

</html>
