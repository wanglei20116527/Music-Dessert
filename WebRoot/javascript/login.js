function getLoginUserName(){
	var userName = $("#login_userName").val();
	userName = $.trim(userName);
	return userName;
}

function checkLoginUserName(){
	var userName = getLoginUserName();
	if(!isUserNameValid(userName)){
		$("#login_userName").val("");
		$("#login_userName").attr("placeholder","Your user name is not valid");
		return false;
	}
	return true;
}

function getLoginPassword(){
	var password = $("#login_password").val();
	password = $.trim(password);
	return password;
}

function checkLoginPassord(){
	var password = getLoginPassword();
	if(!isPasswordValid(password)){
		$("#login_password").val("");
		$("#login_password").attr("placeholder","Your password is not valid");
		return false;
	}
	return true;
}

function getLoginIdentifyingCode(){
	var loginIdentifyingCode = $("#login_IdentifyingCode").val();
	loginIdentifyingCode = $.trim(loginIdentifyingCode);
	return loginIdentifyingCode;
}

function checkLoginIdentifyingCode(){
	var loginIdentifyingCode = getLoginIdentifyingCode();
	if(!isIdentifyingCodeValid(loginIdentifyingCode)){
		$("#login_IdentifyingCode").val("");
		$("#login_IdentifyingCode").attr("placeholder","Invalid");
		return false;
	}
	return true;
}

function sendLoginIdentifyingCodeToPhone(){
	if(checkLoginUserName()){
		var userName = getLoginUserName();
		$.ajax({
		 	url: getRootPath() + "/sendLoginIdentifyingCodeAction" ,
			type: "POST",
			data: {userName:userName},
			dateType: "json",
			success: function(result){
				result = $.trim(result);
				if(result == "success"){
					alert("register identifying code has been send to your phone");
				}else if(result = "user_not_exist"){
					alert("the user does not exist");
				}else{
					alert("the interval between the time of last identifying code and now is less than 1 minute");
				}
			},
			error: function(state){
				alert("service error");
            }
		});
	}
}

function login(){
	if(checkLoginUserName() &&
			checkLoginPassord() &&
				checkLoginIdentifyingCode()){
		var userName = getLoginUserName();
		var password = getLoginPassword();
		var identifyingCode = getLoginIdentifyingCode();
		$.ajax({
		 	url: getRootPath() + "/loginAction" ,
			type: "POST",
			data: {userName:userName,password:password,identifyingCode:identifyingCode},
			dateType: "json",
			success: function(logInResult){
				logInResult = $.parseJSON(logInResult);
				loginResultHandler(logInResult);
			},
			error: function(state){
				alert("service error");
            }
		});
	}
	return false;
}

function loginResultHandler(logInResult){
	if(logInResult.isLoginSuccess){
		closeLogInBox();
		closeRegisterBox();
		removeLogInDiv();
		createLogoutDiv(logInResult.userName);
	}else{
		alert("userName or password error");
		
	}
}

function isUserLogin(){
	var userLoginState = {};
	$.ajax({
	 	url: getRootPath() + "/isUserloginAction" ,
		type: "POST",
		dateType: "json",
		async: false,
		success: function(result){
			result = $.parseJSON(result);
			if(result.loginState){
				userLoginState[0] = true;
				userLoginState[1] = result.userName;
			}else{
				userLoginState[0] = false;
			}
		},
		error: function(state){
			alert("service error");
        }
	});
	return userLoginState;
}

function removeLogInDiv(){
	$("#login").remove();
}

function createLoginDiv(){
	var logInDivDOMString = "<div id = 'login'>" +
								"<a href = 'javascript:;' onclick = 'openLogInBox()'>Login</a>" +
								"<i></i>" +
								"<a href = 'javascript:;' onclick = 'openRegisterBox()'>Register</a>" +
								"<i></i>" +
								"<a href = 'javascript:;'>Music Dessert</a>" +
							"</div>";
	$("#head_playerInterface").append(logInDivDOMString);
}




