<%@page import="com.min.edu.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
   <title>로그인 화면</title>
<style type="text/css">

body{
	position: absolute;
	left : 350px;
	top: 300px;
}

table{
	position: relative;
	left : 90px;
	top : 30px;
}

h3{
	position: relative;
	left : -70px;
	top : 15px;
}

.tab {
  width: 250px;
  height :50px;
}

.tab1{
  border: 1px solid black;
  background-color: #f1f1f1;
  position: relative;
  top: 20px;
}

.tab2{
  border: 1px solid black;
  border-left : none;
  background-color: #f1f1f1;
  position: relative;
  left: 250px;
  top: -30px;
}


.tab button {
  float: left;
  cursor: pointer;
  transition: 0.3s;
  font-size: 17px;
  width: 250px;
  height: 50px;
}

.tab button:hover {
  background-color: #ddd;
}

.tab button.active {
  background-color: #ccc;
}
.tabcontent {
  display: none;
  padding: 0px;
  border: 1px solid #ccc;
  border-top: none;
  width: 500px;
  height: 175px;
}

</style>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
<body>
   <input type="hidden" id="user_tab" name="user_tab" >
   <div class="tab">
     <button class="tab1" onclick="loginuser(event, 'user')">개인회원</button>
     <button class="tab2" onclick="loginuser(event, 'hospi')">병원기업</button>
   </div>

   <form action="./loginU.do" method="post" id="frmU">
      <div id="user" class="tabcontent" style="display: block;" >
            <h3>User Login</h3>
            <input type="hidden"  name="u_auth" value="U">
            <table>
               <tr>
                  <th>아이디&nbsp;</th>
                  <td>
                     <input id="Uid" type="text" name="u_id" placeholder="아이디">
                  </td>
               </tr>
               <tr>
                  <th>비밀번호&nbsp;</th>
                  <td>
                     <input id="Upassword" type="password" name="u_password" placeholder="비밀번호">
                  </td>
               </tr>
               <tr>
                  <th colspan="2"><br>
                     <input id="box" type="button" class="btn btn-primary" value="로그인" onclick="loginCheck()">
                     <input id="box" type="button" class="btn btn-info" value="회원가입" onclick="regiForm()">
                  </th>
               </tr>
         </table>
   </div>
     </form>

      <form action="./loginH.do" method="post" id="frmH">
      <div id="hospi" class="tabcontent">
            <h3>병원 로그인</h3>
            <input type="hidden"  name="u_auth" value="H">
            <table>
               <tr>
                  <th>아이디</th>
                  <td>
                     <input id="Hid" type="text" name="u_id" placeholder="아이디">
                  </td>
               </tr>
               <tr>
                  <th>비밀번호</th>
                  <td>
                     <input id="Hpassword" type="password" name="u_password" placeholder="비밀번호">
                  </td>
               </tr>
               <tr>
                  <th colspan="2">
                     <input id="box" type="button" class="btn btn-primary" value="로그인" onclick="loginCheck()">
                     <input id="box" type="button" class="btn btn-info" value="회원가입" onclick="regiForm()">
                  </th>
               </tr>
         </table>
      </div> 
      </form>
      
<script type="text/javascript">
 function loginuser(evt, username) {
   var i, tabcontent, tablinks;
   tabcontent = document.getElementsByClassName("tabcontent");
   
   for (i = 0; i < tabcontent.length; i++) {
     tabcontent[i].style.display = "none";
   }
   tablinks = document.getElementsByClassName("tablinks");
   for (i = 0; i < tablinks.length; i++) {
     tablinks[i].className = tablinks[i].className.replace(" active", "");
   }
  document.getElementById(username).style.display = "block";
   evt.currentTarget.className += " active";
 }
 
 function regiForm(){
	location.href="./usechk.do";
 }

 
 
function loginCheck(){
   
   
   var div =  document.getElementsByTagName("div");
   
    for (var i = 0; i < div.length; i++) {
      if(div[i].style.display == "block"){
         var   auth =    div[i].childNodes[3].value;
      //   alert(div[i].children.value);
      }
      }

      var id = document.getElementById(auth+"id").value;
      var pw = document.getElementById(auth+"password").value;

   
      if(id==null||id.trim()==""){
      document.getElementById(auth+"id").focus();
      $(auth+"id").val("");
      alert("아이디를 확인해주세요.");
   }else if(pw==null||pw=="".trim()){
      document.getElementById(auth+"password").focus();
      $(auth+"password").val("");
      alert("비밀번호를 확인해주세요.");
   }else{
       jQuery.ajax({
               type : "post",
               url : "./loginAjax.do",
               data : "u_id=" +id+ "&u_password=" +pw+"&u_auth=" +auth,
               success : function(data) {
                  if (data.msg == "성공") {
                    //    alert(data.u_id);
                    //    alert(data.u_password);
                    //   alert(data.u_auth);
                        if (data.u_auth == "U") {
                           alert("회원으로 입력하셨습니다! 회원님의 auth는 ?"+"["+data.u_auth+"]");
                           document.getElementById("frm" + data.u_auth).submit();
                        }else if(data.u_auth == "H"){
                           alert("병원으로 입력하셨습니다! 회원님의 auth는 ?"+"["+data.u_auth+"]")
                           document.getElementById("frm" + data.u_auth).submit();
                        }else if(data.u_id == "admin" && data.u_auth =="A"){
                        //   alert("관리자님 반갑습니다!")
                           frmU.submit();s
                        }
                     } else {
                        alert("아이디와 비밀번호를 확인해 주세요");
                     }
                  },
                  error : function() {
                     alert("로그인에 문제가 생겼습니다");
                  }
               });
      }
   }
  

</script>
 
</body>
</html> 