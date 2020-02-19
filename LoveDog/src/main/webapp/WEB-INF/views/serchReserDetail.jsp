<%@page import="com.min.edu.dto.Obj_Dto" %>
<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
    function insertReser(d) {
        location.href = "./insertReserForm.do?h_regi=" + d;
    }
</script>
<head>
    <%
        List<Obj_Dto> dto = (List<Obj_Dto>) request.getAttribute("HObj");
    %>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<table id="HList">

    <thead>

    <tr>
        <th>병원이름</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>주소</th>
        <th>사업자등록증</th>
        <!-- 					<th>권한변경</th> -->
    </tr>
    </thead>

    <tbody>
    <tr>
        <td>${hDetail.h_name}</td>
        <td>${hDetail.h_phone}</td>
        <td>${hDetail.h_mail}</td>
        <td>${hDetail.h_address}</td>
        <td>${hDetail.h_regi}</td>
    </tr>
    <tr>
        <th>진료과</th>
        <th>진료동물</th>
    </tr>
    <c:forEach items="${HObj}" var="ODto">
        <tr>
            <td>${ODto.obj_code}</td>
        </tr>
    </c:forEach>
    <c:forEach items="${HAni}" var="ADto">
        <tr>
            <td>${ADto.ani_code}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button onclick="insertReser('${hDetail.h_regi}')">예약 신청</button>
<%-- 			${HObj} --%>
</body>
</html>