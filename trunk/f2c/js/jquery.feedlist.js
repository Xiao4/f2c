;(function($){
	var feedListCache = {};
	$.extend({
		getFeedContainer:function(userid,box){
			var container =feedListCache[userid];
			if(!container){
				if(!box) box = document.body;
				var $c = $box.append('<div class="txt_box" style="display:none" rel="'+userid+'"></div>');
				container = feedListCache[userid] = $c;
			};
			return container;
		}
	});
	$.fn.extend({
		getFeedContainer:function(userid){
			return $.getFeedContainer(userid ,this);
		}

	});
})(jQuery);
