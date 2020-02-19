<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>메인 화면</title>
<style type="text/css">
h1{
	position: relative;
	left: 350px;
	font-size: 30px;
}

h2{
	position: relative;
	left: 460px;
}

h3{
	position: relative;
	left: 580px;
	top: -110px;
	font-size: 30px !important;
	font-weight: 800 !important;
	font-family: Georgia, "맑은 고딕", serif !important;
}

.dog{
	position: relative;
	left: 585px;
	top : -57px;
}

.sessio{
	position: relative;
	left: 25px;
	top : 85px;
}

img{
	position: relative;
	left: 290px;
	top : 0px;
}

#outt{
	position: relative;
	left: -76px;
	top : 130px;
}
</style>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="./css/main.css">
<script type="text/javascript">
        function logoutPro(){
            location.href="./login.do";
        }
    </script>
<body>

<h1>동물병원 예약관리 시스템</h1>
<h2>사랑하개</h2><img alt="개" src="./image/iconfinder_dog_4591896.png" class="dog">
<!-- <h2><a href="./reserS.do">예약</a></h2> -->

<a class="sessio">${sessionScope.user.u_id} 님 환영합니다</a>
<input type="button" value="로그아웃" class="btn btn-primary" id="outt" onclick="logoutPro()">
<!-- <a href="./freeboard.do?selEtc=F">자유게시판</a> -->
<!-- <a href="./reviewboard.do?selEtc=R">후기게시판</a> -->
<!-- <a href="./noticeboard.do?selEtc=A">공지게시판</a> -->
<!-- <a href="./hongboard.do">병원정보게시판</a> -->
<!-- <a href="./mainH.do">관리자로그인</a> -->

<!-- <a href="./login.do">로그인하기</a> -->

	<nav id="topMenu">
		<ul>
			<li><a class="menuLink" href="./freeboard.do?selEtc=F">자유게시판</a></li>
			<li><a class="menuLink" href="./reviewboard.do?selEtc=R">후기게시판</a></li>
			<li><a class="menuLink" href="./noticeboard.do?selEtc=A">공지게시판</a></li>
			<li><a class="menuLink" href="main.do">유저 목록</a></li>
			<li><a class="menuLink" href="./HospiList.do?u_id=ADMIN">병원 목록</a></li>
		</ul>
	</nav>

<a href="./reserS.do">
<img alt="일정" src="./image/calicon.PNG"></a>
<h3><a href="./reserS.do" style="color:orange; text-decoration:none;">병원 일정 및 예약하기</a></h3>

</body>
</html>