<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%
        // 	List<Hospi_Dto>
    %>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%-- ${lists} --%>
<table>
    <tr>
        <th>병원 이름</th>
        <th>주소</th>
        <th>변호</th>
    </tr>
    <c:forEach items="${lists}" var="h_list">
        <tr>
            <td><a href="./sReserList_detail.do?h_regi=${h_list.h_regi}">${h_list.h_name}</a></td>
            <td>${h_list.h_address}</td>
            <td>${h_list.h_phone}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>