<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.json.js"></script>
</head>
<body>

<div id="aa" ></div>

<script type="text/javascript">
$(function(){
	var reg = {
			province:200,
			city:202,
			gender:1,
			agreement:true
			};
	$.ajax({
		url:'/rest/status',
		data:$.toJSON(reg),
		type:'POST',
		success:function(r){
			$('#aa').html(r);
			},
			contentType:"application/json; charset=utf-8"
		});
});
</script>

</body>
</html>