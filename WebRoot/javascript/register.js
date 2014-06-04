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
	alert(result);
	/*switch(result){
	case "UserName_Invalid":
		$("#register_userName").val("");
		$("#register_userName").attr("placeholder","Your user name is not valid");
		break;
	case "UserName_Registered":
		$("#register_userName").val("");
		$("#register_userName").attr("placeholder","User name has been registered");
		break;
	case "Password_Invalid":
		$("#register_password").val("");
		$("#register_password").attr("placeholder","Your password is not valid");
		break;
	case "PhoneNumber_Invalid":
		$("#register_phoneNumber").val("");
		$("#register_phoneNumber").attr("placeholder","Your phoneNumber is not valid");
		break;
	case "PhoneNumber_Registered":
		$("#register_phoneNumber").val("");
		$("#register_phoneNumber").attr("placeholder","phonenumber registered");
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
	case "Success":
		alert("Success");
		//closeRegisterBox();
		//openLogInBox();
		break;
	default:
		alert("unknow Error");
	}	*/
}


//下面的函数是用来向后台中提交用户的注册信息
function register(){
	if(checkUserName() && checkPassword() && checkPhoneNumber() && checkRegisterIdentifyingCode()){
		var userName = getUserName();
		var password = getPassword();
		var phoneNumber = getPhoneNumber();
		var identifyingCode = getRegisterIdentifyingCode();
		alert("success to register");
		$.ajax({
		 	url: getRootPath() + "/registerAction" ,
			type: "POST",
			data: {userName:userName,password:password, phoneNumber:phoneNumber,identifyingCode:identifyingCode},
			dateType: "json",
			success: function(result){
				result = $.trim(result);
				registerResultHandler(result);
			}
		});
	}else{
		alert("Information invalid, refuse to submit");
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
				switch(result){
				case "IdentifyingCode_Created":
					alert("the interval between the time of last identifying code and now is less than 3 minute");
					break;
				case "PhoneNumber_Registered":
					alert("sorry, your phoneNumber has been registered");
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
