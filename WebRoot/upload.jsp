<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<script type="text/javascript" src="javascript/jquery.js"></script>
	<script type="text/javascript" src="javascript/common.js"></script>
	<script type="text/javascript" src="javascript/login.js"></script>
	<script type="text/javascript">
		var isLogin = isUserLogin();
		if(!isLogin[0]){
			//window.location.href = getRootPath();
		}
	</script>
	
	<link rel="stylesheet" type="text/css" href="CSS/uploadPage.css"/>
	
	<link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="plugins/File-Uploader/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="plugins/File-Uploader/css/jquery.fileupload.css"/>
	<link rel="stylesheet" type="text/css" href="plugins/File-Uploader/css/jquery.fileupload-ui.css"/>
	
	<link rel="stylesheet" href="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css"/>
	
	<script type="text/javascript" src="javascript/jquery.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/vendor/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/tmpl.min.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/load-image.min.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/canvas-to-blob.min.js"></script>
	
	<script type="text/javascript" src="plugins/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.blueimp-gallery.min.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.iframe-transport.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.fileupload.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.fileupload-process.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.fileupload-image.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.fileupload-audio.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.fileupload-video.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.fileupload-validate.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/jquery.fileupload-ui.js"></script>
	<script type="text/javascript" src="plugins/File-Uploader/js/main.js"></script>
	
</head>
<body>

<div id = "uploadPage_logoutBox">
	<div id = "logout">
		<a href = "javascript:;">wanglei</a>
		<span>|</span>
		<a href = "/MusicDessert_Software/index.jsp">Music Dessert</a>
		<span>|</span>
		<a href = '/MusicDessert_Software/logoutAction'>Layout</a>
	</div>
</div>
<!--  <div id = "uploadPageLogoBox">
	<div>
		<div>
			<span>音乐上传</span>
		</div>
	</div>
</div>

-->



<div class="container" id= "fileuploadContainer">
    <!-- The file upload form used as target for the file upload widget -->
    <form id="fileupload" action="javascript:;" method="POST" enctype="multipart/form-data">
        <div class="row fileupload-buttonbar">
            <div class="col-lg-7">
                <span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>Add files...</span>
                    <input type="file" name="files" multiple="">
                </span>
                
                <button type="submit" class="btn btn-primary start">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start upload</span>
                </button>
                
                <!--  
                <button type="reset" class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel upload</span>
                </button>
                
                <button type="button" class="btn btn-danger delete">
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                
                <input type="checkbox" class="toggle"/>
                <span class="fileupload-process"></span>
                -->
            </div>
            
            <!-- The global progress state -->
            <div class="col-lg-5 fileupload-progress fade">
                <!-- The global progress bar -->
                <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                    <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                </div>
                
                <!-- The extended global progress state -->
                <div class="progress-extended">&nbsp;</div>
            </div>
        </div>
        
        <!-- The table listing the files available for upload/download -->
        <table role="presentation" class="table table-striped">
        	<tbody class="files"></tbody>
        </table>
    </form>
</div>

<!--  
<div id = "uploadNote">
	<div id = "uploadNoteHeader">
		<span>上传提示</span>
	</div>
    <div id="uploadNoteBody">
    	<ul>
    		<li>您能够上传的单个最大的文件为 <strong>5 MB</strong></li>
            <li>您能够上传的文件格式为 <strong>MP3,WAV,MP4</strong> </li>
            <li>上传成功的文件将会从上传列表中自动删除</li>
            <li>您可以通过点击添加文件按钮或从您的桌面上通过将文件拖拉到浏览器的方式来选择文件进行上传</li>
            <li>本上传工具是Jquery上传插件Jquery File Upload,其官方网址为<a href="http://blueimp.github.io/jQuery-File-Upload/">Jquery File Upload</a></li>
        </ul>
    </div>
</div>
-->

<!-- 下面是文件预览模块   -->
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger"></strong>
        </td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start" disabled>
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>

<!-- The template to display files available for download -->
<script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade">
        <td>
            <span class="preview">
                {% if (file.thumbnailUrl) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                {% } %}
            </span>
        </td>
        <td>
            <p class="name">
                {% if (file.url) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
                {% } else { %}
                    <span>{%=file.name%}</span>
                {% } %}
            </p>
            {% if (file.error) { %}
                <div><span class="label label-danger">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
            {% if (file.deleteUrl) { %}
                <button class="btn btn-danger delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" name="delete" value="1" class="toggle">
            {% } else { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
	 
</body>
</html>