<%@page import="com.min.edu.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>[로그인 후 화면에서 추가되는 부분]</h2>
<br>
<h3>예약[류은지]</h3>

<%
Object obj = session.getAttribute("user");
User_Dto Udto = (User_Dto)obj;
%>

<%=Udto.getU_name()%>! Welcome!!(등급:<%=Udto.getU_auth().equals("A")?"Administor":"User"%>)

<br>

<a href="./reser.do">예약</a>
<h3>게시판[권준형]</h3>
<a href="./freeboard.do?selEtc=F">자유</a>
<br>
<a href="./reviewboard.do?selEtc=R">후기</a>
<br>
<a href="./noticeboard.do?selEtc=A">공지</a>
<br>
<a href="./hongboard.do">병원정보게시판</a>
<h2>회원정보[김도윤]</h2>
<a href="./Mypage.do">마이페이지</a>
</body>
</html>