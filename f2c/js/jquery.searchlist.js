;(function($){
	var $userList = null;
	$.extend({
		searchList:function(input,box){
			if(str == $("#searchKey").attr("title")){
		        str = "";
	        }
	        if(str){
	            var regex = eval("/\\d+\\t\\d+\\t.*"+str+".*/gi");
	            var i= 0;
	            var temp = [];
	            $(searchIndex).each(function(index,item){
	                temp.push("\n"+index+"\t");
	                temp.push(item);
	            });
	            var matchlist = temp.join("").match(regex);
	            $userList.hide();
	            if(matchlist){
	                showNoResult(false);
		            $(matchlist).each(function(){
						var inx = this.split("\t")[0];
	                    if(!$userList.eq(inx).hasClass("delete")){
	                        $userList.eq(inx).show();
	                    }
	                });
	            }else{
	                showNoResult(true);
	            }
	        }else{
	            //showNoResult(false);
	            $userList.not(".delete").show();
	        }
	
	        if(str == "" || str == $(input).attr("title")){
	            showSearchBtn("search");
	        }else{
	            showSearchBtn("close");
	        }
		return $(box).each({

		});
		}
	});
	$.fn.extend({
		searchList:function(str){
			return $.searchList(str,this);
		}
	});
})(jQuery);
