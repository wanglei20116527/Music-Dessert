function getUserName(){
	return $("#register_userName").val();
}

function checkUserName(){
	var userName = getUserName();
	if(!isUserNameValid(userName)){
		$("#register_userName").val("");
		$("#register_userName").attr("placeholder","Your user name is not valid");
		return false;
	}
	return true;
}

function getPassword(){
	return $("#register_password").val();
}

function checkPassword(){
	var password = getPassword();
	if(!isPasswordValid(password)){
		$("#register_password").val("");
		$("#register_password").attr("placeholder","Your password is not valid");
		return false;
	}
	return true;
}


function getPhoneNumber(){
	return $("#register_phoneNumber").val();
}

//the follow function is used to check weather the phoneNumber is valid if vaild return true,otherwise the return false
function checkPhoneNumber(){
	var phoneNumber = getPhoneNumber();
	if(!isPhoneNumberValid(phoneNumber)){
		$("#register_phoneNumber").val("");
		$("#register_phoneNumber").attr("placeholder","Your phonenumber is not valid");
		return false;
	}
	return true;	
}

function getRegisterIdentifyingCode(){
	return $("#identifyingCode").val();
}

function checkRegisterIdentifyingCode(){
	var identifyingCode = getRegisterIdentifyingCode();
	if(!isIdentifyingCodeValid(identifyingCode)){
		$("#identifyingCode").val("");
		$("#identifyingCode").attr("placeholder","Invalid");
		return false;
	}
	return true;
}

function registerResultHandler(result){
	if(result == "userName_valid"){
		$("#register_userName").val("");
		$("#register_userName").attr("placeholder","Your user name is not valid");
	}else if(result == "userName_registered"){
		$("#register_userName").val("");
		$("#register_userName").attr("placeholder","User name has been registered");
	}else if(result == "password_valid"){
		$("#register_password").val("");
		$("#register_password").attr("placeholder","Your password is not valid");
	}else if(result == "phoneNumber_valid"){
		$("#register_phoneNumber").val("");
		$("#register_phoneNumber").attr("placeholder","Your phoneNumber is not valid");
	}else if(result == "phoneNumber_registered"){
		$("#register_phoneNumber").val("");
		$("#register_phoneNumber").attr("placeholder","phonenumber registered");
	}else if(result == "identifyingCode_Lose_Efficacy"){
		$("#identifyingCode").val("");
		alert("Identifying Code has lost Efficacy");
	}else if(result == "identifyingCode_wrong"){
		$("#identifyingCode").val("");
		$("#identifyingCode").attr("placeholder","Wrong");
	}else{
		closeRegisterBox();
		openLogInBox();
	}
}


//下面的函数是用来向后台中提交用户的注册信息
function register(){
	if(checkUserName() && checkPassword() && checkPhoneNumber() && checkRegisterIdentifyingCode()){
		var userName = getUserName();
		var password = getPassword();
		var phoneNumber = getPhoneNumber();
		var identifyingCode = getRegisterIdentifyingCode();
		$.ajax({
		 	url: getRootPath() + "/registerAction" ,
			type: "POST",
			data: {userName:userName,password:password, phoneNumber:phoneNumber,identifyingCode:identifyingCode},
			dateType: "json",
			success: function(result){
				result = $.trim(result);
				registerResultHandler(result);
			},
			error: function(state){
				alert("error");
            }
		});
	}
	return false;
}

function sendRegisterIdentifyingCodeToPhone(){
	if(checkPhoneNumber()){
		var phoneNumber = getPhoneNumber();
		$.ajax({
		 	url: getRootPath() + "/sendRegisterIdentifyingCodeAction" ,
			type: "POST",
			data: {phoneNumber:phoneNumber},
			dateType: "json",
			success: function(result){
				result = $.trim(result);
				if(result == "success"){
					alert("register identifying code has been send to your phone");
				}else if(result == "phoneNumber_registered"){
					alert("sorry, your phoneNumber has been registered");
				}else{
					alert("the interval between the time of last identifying code and now is less than 1 minute");
				}
			},
			error: function(state){
				alert("发生未知错误");
            }
		});
	}
}
