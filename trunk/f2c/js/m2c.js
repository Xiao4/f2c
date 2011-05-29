$(function(){
	var $editor=$('#editor'),
	$limit=$('#editor_limit'),
	$btnSubmit=$('#editor_submit');

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
});
