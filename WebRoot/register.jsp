<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html id = "registerPage">
  <head>
	<link type = "text/css" rel="stylesheet" href="CSS/registerPage.css"/>
	
	<script type = "text/javascript" src = "javascript/jquery.js"></script>
	<script type = "text/javascript" src = "javascript/common.js"></script>
	<script type = "text/javascript" src = "javascript/logInBox.js"></script>
	<script type = "text/javascript" src = "javascript/registerBox.js"></script>
	<script type = "text/javascript" src = "javascript/register.js"></script>

  </head>
  
  <body>
   	<div id = "register_Box">
			<div id = "registerBox" class = "box">
				<div class = "left_box">
					<div class = "title">
						<span>注册</span>
					</div>
					<form method = "post" onsubmit = "return register()">
						<div class = "userName">
							<div>
								<span>用户名</span>
							</div>
							<div>
								<input id = "register_userName" type = "text" placeholder = "英文数字组成,且英文开头" onblur = "checkUserName()"/>
							</div>
						</div>
						<div class = "password">
							<div>
								<span>密码</span>
							</div>
							<div>
								<input id = "register_password" type = "password" placeholder = "包括数字和英文，最少8位"/>
							</div>
						</div>
						<div class = "phoneNumber">
							<div>
								<span>手机号</span>
							</div>
							<div>
								<input id = "register_phoneNumber" onblur = "checkPhoneNumber()" type = "tel" maxlength = "11"/>
							</div>
						</div>
						<div class = "identifyingCode">
							<div>
								<span>手机验证码</span>
							</div>
							<div>
								<input id = "identifyingCode" type = "text" onblur = "checkRegisterIdentifyingCode()" maxlength = "6"/>
							</div>
						</div>
						<div class = "createIndentifyingCode">
							<a href = "javascript:;" onclick = "sendRegisterIdentifyingCodeToPhone()">create</a>
						</div>
						<div class = "submitButton">
							<input id = "registerSubmitButton" type = "submit" value = "注册"/>
						</div>
					</form>
				</div>
				<div class = "right_box">
					<div>
						<a href="javascript:;" onclick = "closeRegisterBox()">X</a>
					</div>
					<div class = "registerButton">
						<span>没有账户?</span>
						<a href="javascript:;" onclick = "javascript:;">立即注册</a>	
					</div>
				</div>
			</div>
		</div>
  </body>
  <script type="text/javascript">
  	setHeightForRightPartOfRegisterBox();
  	setPositionOfRegisterButtonForRegisterBox();
  </script>
</html>
