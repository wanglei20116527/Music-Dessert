<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link type = "text/css" rel="stylesheet" href="CSS/loginPage.css"/>
	
	<script type = "text/javascript" src = "javascript/jquery.js"></script>
	<script type = "text/javascript" src = "javascript/registerBox.js"></script>
	<script type = "text/javascript" src = "javascript/logInBox.js"></script>
  </head>
  
  <body>
    <div id = "logIn_Box">
			<div id = "logInBox" class = "box">
				<div class = "left_box">
					<div class = "title">
						<span>登录</span>
					</div>
					<form method = "post">
						<div class = "userName">
							<div>
								<span>用户名</span>
							</div>
							<div>
								<input type = "text" name = "userName"/>
							</div>
						</div>
						<div class = "password">
							<div>
								<span>密码</span>
							</div>
							<div>
								<input type = "password" name = "password"/>
							</div>
						</div>
						<div class = "identifyingCode">
							<div>
								<span>手机验证码</span>
							</div>
							<div>
								<input type = "text" name = "">
							</div>
						</div>
						<div class = "createIndentifyingCode">
							<a href = "javascript:;">create</a>
						</div>
						<div class = "otherInfor">
							<div>
								<input type = "checkbox" name= ""/>
								<span>下次自动登录</span>
							</div>
							<div>
								<a href = "javascript:;">忘记密码?</a>
							</div>
						</div>
						<div class = "submitButton">
							<input type = "submit" value = "登录"/>
						</div>
					</form>
				</div>
				<div class = "right_box">
					<div>
						<a href="javascript:;" onclick = "closeLogInBox()">X</a>
					</div>
					<div class = "registerButton">
						<span>没有账户?</span>
						<a href="javascript:;" onclick = "openRegisterBoxForLogInPage()">立即注册</a>	
					</div>
				</div>
			</div>
		</div>
  </body>
</html>
