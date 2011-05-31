$(function(){
	var $editor=$('#editor'),
	$limit=$('#editor_limit'),
	$btnSubmit=$('#editor_submit'),
	$sendTo=$('#editor_sendto'),
	$friendList=$('#friendList')
	$feedContainer = $('#feedListContainer');
	
	var $searchList = $('#friendList').searchList();
	$searchList.create(friendListData);

	$btnSubmit.click(function(){
		var o = {};
		for(var i in this.form.elements)
			o[this.form.elements[i].name] = this.form.elements[i].value;
console.log($searchList.user(o.friend_id));
		var myMsg=new Msg({
			type:'out',
			sending:true,
			creatTime:undefined,
			userId:o.friend_id,
			nickName:$searchList.user(o.friend_id).nickname,
			text:o.text
		});	
		myMsg.render();

		$.post(this.form.action,o,function(r){
			console.log(r);
			myMsg.ele.removeClass('sending').addClass('out');
		});
		return false;
	});


	$editor.textbox({
		maxLength: 140,
	        overWrite:true,
        	onInput: function(event, status) {
            		str =  (status.leftLength>=0)?status.leftLength:"<font color='red'>超出"+ (-status.leftLength) + '字</font>';
            		$limit.html(str);
        	}       
	})      
	.keypress(function(e){
       		if(e.ctrlKey && (e.keyCode == 13 || e.keyCode == 10)) {
        	    	e.preventDefault();
            		$btnSubmit.click();
        	}       
   	}).keyup();
	
	$friendList.click(function(e){
		var target = e.target || e.srcElement || e.originalTarget;
		if(target.parentNode.tagName.toLowerCase()=='li'){target=target.parentNode;}
		else if(target.tagName.toLowerCase()=='a'){ //修改联系人
			__editFriend($(target).closest('li').attr('id'));
			return;
		}
		if(target.tagName.toLowerCase()=='li'){
			__showMsgList($(target).attr('id'));
		}
	});
	function __editFriend(fid){
		console.log('e'+fid);
	}
	function __showMsgList(fid){
		$feedContainer.feedlist(fid).swich();
		$sendTo.val(fid);
	}
function __formatDate(date){
	var tmpDate=new Date(date);
	return tmpDate.toLocaleTimeString();
}
var __msgTemplate='<div class="txt {type}"><b></b><p><strong>{nickName}:</strong>{text}</p><p><span class="gray">{creatTime}</span></p></div>';
var __msgFormater=new Formater(__msgTemplate);
function Msg(o){
	var setting={
		type:'out',
		sending:false,
		creatTime:__formatDate(new Date()),
		userId:'',
		nickName:'',
		text:''
	}
	this.ele=undefined;
	if(o.creatTime)o.creatTime = __formatDate(o.creatTime)
	return $.extend(this,$.extend(setting,o));
}
$.extend(Msg.prototype,{
	render:function(){
		this.ele=$(__msgFormater.exec(this));
		if(this.sending)this.ele.removeClass(this.type).addClass('sending');
		$feedContainer.feedlist(this.userId).append(this.ele).scrollTop(999999);
	}
});
});
