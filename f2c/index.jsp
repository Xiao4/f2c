<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">
var friendList =${friendListJson}; 


</script>
</head>
<body>
<div style="display:none">我的信息：
        <span>ID:${loginUser.id}</span>
        <span>昵称:${loginUser.nickname}</span>
        <span>facebookUID:${loginUser.facebookUID}</span>
        <span>说客ID:${loginUser.mobileUID}</span>
  <br/>
  <c:forEach items="${friendList}" var="friend" varStatus="status">
        <div>好友${status.index + 1}:
          <span>ID:${friend.id}</span>
          <span>备注名:${friend.nickname}</span>
          <span>手机号:${friend.mobile}</span>
          <span>说客ID:${friend.mobileUID}</span>
        </div>
  </c:forEach>
</div>
<div id="maincolumn">
  
  <div class="user_box">
     <div class="namebox clearfix">
	   <img src="images/photo.jpg" />
	   <div class="txt">
	   <p><a href="#">${loginUser.nickname}</a></p>
	   <p title="xxx">1065810397${loginUser.mobileUID}</p>
	   </div>
	 </div>
     <div class="sevs">
	   <p><a href="#"><img src="images/test_icon.png" />m2you&nbsp;home</a></p>
	   <p><a href="#"><img src="images/test_icon.png" />Add&nbsp;contact</a></p>
	   <p><a href="#"><img src="images/test_icon.png" />signature</a></p>
	 </div>
     <div class="invite">
	   <a href="#"></a>
	 </div>
	 <div class="embed_box"></div>
  </div>

  <div class="contacts clearfix">
    <div class="hd clearfix">
	  <h2>Contacts</h2>
	  <a href="#" class="add"></a>
	</div>
	<div class="list">
	  <div class="search">
	    <input name="" type="text" class="i-n" value="search" />
		<input type="submit" class="search_btn" value="" />
	  </div>
	  <ul class="clearfix">
  <c:forEach items="${friendList}" var="friend" varStatus="status">
	    <li franid="${friend.id}" mobile="${friend.mobile}" mid="${friend.mobileUID}"><span class="name">${friend.nickname}</span><span class="phone">${friend.mobile}</span></li>
  </c:forEach>
	  </ul>
	</div>

	
  </div>
  

  <div class="mail_box">
    <div class="txt_box">
	  <div class="txt in"><b></b>
		<p><span class="gray">10:41 PM</span> You just added  <span class="orange">"Xu Feng"</span>to啊 your contact list. Please inform him to accept your invitation and then send him text messages, or he can not receive text messages you send.啊</p>
	  </div>

	  <div class="txt out"><b></b>
	    <p><span class="gray">10:41 PM</span> You just added  <span class="orange">"Xu Feng"</span>to啊 your contact list. Please inform him to accept your invitation and then send him text messages, or he can not receive text messages you send.啊</p>
	  </div>

	  <div class="txt sending"><b></b>
	    <p><span class="gray">10:41 PM</span> You just added  <span class="orange">"Xu Feng"</span>to啊 your contact list. Please inform him to accept your invitation and then send him text messages, or he can not receive text messages you send.啊</p>
	  </div>
	  <div class="txt sending"><b></b>
	    <p><span class="gray">10:41 PM</span> You just added  <span class="orange">"Xu Feng"</span>to啊 your contact list. Please inform him to accept your invitation and then send him text messages, or he can not receive text messages you send.啊</p>
	  </div>
	  <div class="txt sending"><b></b>
	    <p><span class="gray">10:41 PM</span> You just added  <span class="orange">"Xu Feng"</span>to啊 your contact list. Please inform him to accept your invitation and then send him text messages, or he can not receive text messages you send.啊</p>
	  </div>
	</div>

	<div class="editor_box clearfix">
	  <textarea rows="" cols="" id="" class="" name="text"></textarea>
	  <div class="op">
	    <input type="submit" class="btn_send" value="" id="button" name="button">
	    <p>140<p>
	  </div>
	</div>
  </div>


</div>
</body>
</html>
