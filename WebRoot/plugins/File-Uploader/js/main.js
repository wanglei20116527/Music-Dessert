/*
 * jQuery File Upload Plugin JS Example 8.9.1
 * https://github.com/blueimp/jQuery-File-Upload
 *
 * Copyright 2010, Sebastian Tschan
 * https://blueimp.net
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 */

/* global $, window */

$(function () {
	var jqXHR = null;
    //下面的部分是用来初始化fileupload插件的
	$('#fileupload').fileupload({
    	type:"POST",
    	dataType:"json",
    	multipart:true,
    	maxFileSize: 102400000,
        acceptFileTypes: /(\.|\/)(mp4|mp3|wav)$/i,
        url:getRootPath() + "/uploadMusicAction",
        start:function(e, data){
        	//这里我们将来会获得jqXHR,用于停止上传
        },
        done:function(e,data){//这里表示的是一首单首音乐上传完毕的处理
        	 data.context.text("");
        },
        fail:function(e, data){
        	alert("error");
        },
    });
	
	/*var jqXHR = $('#fileupload').fileupload('send', {files: filesList}).error(function (jqXHR, textStatus, errorThrown) {
        if (errorThrown === 'abort') {
            alert('File Upload has been canceled');
        }
    });
	$('button.cancel').click(function (e) {
		jqXHR.abort();
	});*/
	
});
