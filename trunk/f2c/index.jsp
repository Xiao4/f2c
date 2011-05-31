<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" />

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
	   <p><a href="#"><span class="icon_m2you"></span>m2you&nbsp;home</a></p>
	   <p><a href="#"><span class="add"></span>Add&nbsp;contact</a></p>
	   <p><a href="#"><span class="sign"></span>signature</a></p>
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
<form id="search">
	    <input id="search_keyword" name="keyword" type="text" class="i-n" value="search" />
	    <input type="submit" class="search_btn" value="" />
</form>
	  </div>
<% /*

 <c:forEach items="${friendList}" var="friend" varStatus="status">
	    <li id="${friend.id}" mobile="${friend.mobile}" mid="${friend.mobileUID}"><span class="name">${friend.nickname}</span><span class="phone">${friend.mobile}</span><span class="editorname"><a href="javascript:void(0);" title="修改姓名"></a></span></li>
  </c:forEach>
*/ %>
	  <ul id="friendList" class="clearfix">
     <li id="{id}" mobile="{mobile}" mid="{mobileUID}"><span class="name">{nickname}</span><span class="phone">{mobile}</span><span class="editorname"><a href="javascript:void(0);" title="修改姓名"></a></span></li>
	  </ul>
	</div>

	
  </div>
  

  <div class="mail_box">
	<div id="feedListContainer">
    <div class="txt_box">
	  <div class="txt in"><b></b>
		<p><strong>M2you:</strong>You just added  <span class="orange">"Xu Feng"</span>to啊 your contact list. Please inform him to accept your invitation and then send him text messages, or he can not receive text messages you send.啊</p>
		<p><span class="gray">10:41 PM</span></p>
	  </div>

	  <div class="txt out"><b></b>
	    <p><strong>Me:</strong>You just added  <span class="orange">"Xu Feng"</span>to啊 your contact list. Please inform him to accept your invitation and then send him text messages, or he can not receive text messages you send.啊</p>
		<p><span class="gray">10:41 PM</span></p>
	  </div>

	  <div class="txt in"><b></b>
	    <p><strong>M2you:</strong>You just added  <span class="orange">"Xu Feng"</span>to啊 your contact list. Please inform him to accept your invitation and then send him text messages, or he can not receive text messages you send.啊</p>
		<p><span class="gray">10:41 PM</span></p>
	  </div>
	</div>
	</div>
	<form action="msg/send.json" method="post">
	<div class="editor_box clearfix">
	  <input id="editor_sendto" name="friend_id" type="text" autocomplete="off"/>
	  <textarea rows="" cols="" id="editor" class="" name="text"></textarea>
	  <div class="op">
	    <input type="submit" class="btn_send" value="" id="editor_submit" name="button">
	    <p id="editor_limit">140<p>
	  </div>
	</div>
	</form>
  </div>
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.iprompt.js"></script>
<script type="text/javascript" src="js/jquery.textbox.js"></script>
<script type="text/javascript" src="js/jquery.pubsub.js"></script>
<script type="text/javascript" src="js/formater.js"></script>
<script type="text/javascript" src="js/jquery.searchlist.js"></script>
<script type="text/javascript" src="js/jquery.feedlist.js"></script>
<script type="text/javascript" src="js/m2c.js"></script>
<script type="text/javascript">
var friendListData =${friendListJson}; 
</script>
</body>
</html>
