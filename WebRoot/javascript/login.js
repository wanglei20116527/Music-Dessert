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
				switch(result){
				case "User_Not_Exist":
					alert("the user does not exist");
					break;
				case "IdentifyingCode_Created":
					alert("the interval between the time of last identifying code and now is less than 3 minute");
					break;
				case "Success":
					alert("register identifying code has been send to your phone");
					break;
				default:
					alert("unknow Error");
				}
			},
			error: function(state){
				alert("service Error");
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
				logInResult = $.trim(logInResult);
				loginResultHandler(logInResult);
			},
			error: function(state){
				alert("Service Error");
            }
		});
	}
	return false;
}

function loginResultHandler(result){
	switch(result){
	case "UserName_Invalid":
		$("#register_userName").val("");
		$("#register_userName").attr("placeholder","Your user name is not valid");
		break;
	case "Password_Invalid":
		$("#register_password").val("");
		$("#register_password").attr("placeholder","Your password is not valid");
		break;
	case "IdentifyingCode_UnCreated":
		$("#identifyingCode").val("");
		alert("Identifying Code had not been created");
		break;
	case "IdentifyingCode_LoseEfficacy":
		$("#identifyingCode").val("");
		alert("Identifying Code had lost Efficacy");
		break;
	case "IdentifyingCode_Wrong":
		$("#identifyingCode").val("");
		alert("Identifying Code wrong");
		break;
	case "User_Or_Password_Wrong":
		alert("User or Password Wrong");
		break;
	case "Success":
		window.location.reload(true);
		break;
	default:
		alert("Unknow Error");
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




