<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bootstrap文件上传插件</title>
<link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
<link rel="stylesheet" href="http://blueimp.github.io/jQuery-File-Upload/css/jquery.fileupload-ui.css">
<script src="http://www.see-source.com/js/jquery-1.8.1.js"></script>
<script src="http://blueimp.github.io/jQuery-File-Upload/js/vendor/jquery.ui.widget.js"></script>
<script src="http://blueimp.github.io/jQuery-File-Upload/js/jquery.iframe-transport.js"></script>
<script src="http://blueimp.github.io/jQuery-File-Upload/js/jquery.fileupload.js"></script>
</head>
<body>
<div class="container">
    <span class="btn btn-success fileinput-button">
        <i class="icon-plus icon-white"></i>
        <span>选择上传文件</span>
        <input id="fileupload" type="file" name="files[]" multiple>
    </span>
    <br>
    <br>
    <!-- 进度条 -->
    <div id="progress" class="progress progress-success progress-striped">
        <div class="bar"></div>
    </div>
    <!-- 已经上传的文件列表 -->
    <div id="files"></div>    
</div>
</body>
</html>
<script type="text/javascript">
$(function () {
	//文件上传地址
    var url = 'http://localhost:8080/myfileupload/upload';
    //初始化，主要是设置上传参数，以及事件处理方法(回调函数)
    $('#fileupload').fileupload({
        autoUpload: true,//是否自动上传
        url: url,//上传地址
        dataType: 'json',
        done: function (e, data) {//设置文件上传完毕事件的回调函数
            $.each(data.result.files, function (index, file) {//
                $('<p/>').text(file.name).appendTo('#files');
            });
        },
        progressall: function (e, data) {//设置上传进度事件的回调函数
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        }
    });
});
</script>