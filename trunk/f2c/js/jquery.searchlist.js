;(function($){
	$.extend({
		searchList:function(input,box){
			var template = null;
			var cache = {}; 
			var cacheList = [];
			var contacts = {};
			function __create (item){
				var html="";
				$(item).each(function(index,item){
					html+=template.exec(item);
					var tmp = item.id + '\t'+ item.mobile+ '\t'+ item.nickname;
					cacheList.push(tmp);
					cache[item.id] = cacheList.length-1;
					contacts[item.id] = item;
				});
				return $(html).prependTo(this);
			}
			function __update(item){
				var html='' ,collection = [];
				$(item).each(function(index,item){
					html=template.exec(item);
					var tmp = item.id + '\t'+ item.mobile+ '\t'+ item.nickname;
					var index = cache[item.id];
					contacts[item.id] = item;
					if(isNaN(index)) __create.call(this,null,item);
					else{
						cacheList[index] = tmp;
					}
					collection.push($('#'+item.id,this).replaceWith(html));
				});
				return $(collection);
			}
			function __delete(item){
				$(item).each(function(index,item){
					$('#'+item.id,this).remove();
					delete cache[item.id];
				});
			}
			function __search(e,key){
				
			}
			function __user(key){
				return contacts[key];
			}
			$.extend(this.prototype,{
					'create':__create,
					'update':__update,
					'delete':__delete,
					'search':__search,
					'user':__user
					});
			return $(box).eq(0).each(function(index,item){
				var $self = $(this);
				if($self.data('searchInit')) return $self;
				$self.data('searchInit',true);
				template = new Formater(unescape($self.html()));
				$self.empty();
			
			});
		}
	});
	$.fn.extend({
		searchList:function(str){
			return $.searchList(str,this);
		}
	});
})(jQuery);
