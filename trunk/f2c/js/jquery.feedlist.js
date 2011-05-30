;(function($){
	var feedListCache = {},currentList = null;
	$.extend({
		feedlist:function(userid,box){
			var container =feedListCache[userid];
			if(!box) box = document.body;
			if(!currentList){
				currentList = $(box).find('div.txt_box:visible');
			}
			if(!container){
				var $c = $('<div class="txt_box" style="display:none" rel="'+userid+'"></div>').appendTo(box);
				container = feedListCache[userid] = $c;
			};
			currentList.hide();
			currentList = container;	
			return container;
		}
	});
	$.fn.extend({
		feedlist:function(userid){
			return $.feedlist(userid ,this);
		}

	});
})(jQuery);
