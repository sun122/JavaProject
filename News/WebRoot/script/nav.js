/**
 * Created by Administrator on 2017/11/2.
 */
$('body').ready(function() {
	var templatehtml = $('template').html();
	var html = '';
	$.getJSON('indexCatelog',function(data){/* 获取新闻类别名称 */	
	    for(var i = 0;i<data.length;i++) {
	        html += templatehtml.replace('{name}',data[i].newStyleName).replace('{id}',data[i].newStyleId);/* 取得新闻类别名称 */
	    };
	    $('#navindex').html(html);
	});
});