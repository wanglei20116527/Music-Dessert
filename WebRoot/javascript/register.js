function getUserName(){
	return $("#register_userName").val();
}

function isUserNameValid(userName){
	var regExp = new RegExp("^[a-zA-Z][0-9a-zA-Z]{1,}$");
	return regExp.test(userName);
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

function isPasswordValid(password){
	var regExp = new RegExp("");//对于这里我们的正则表达是还没有写，请有时间的时候给加上
	return true;
	//return regExp.test(password);
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

//下面的函数是用来检测用户输入的手机密码是否合法
function isPhoneNumberValid(phoneNumber){
	var regExp = new RegExp("^1[3|5|8][0-9]{9}");
	return regExp.test(phoneNumber);
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

function isRegisterIdentifyingCodeValid(identifyingCode){
	var regExp = new RegExp("^[0-9]{6}$");
	return regExp.test(identifyingCode);
}

function checkRegisterIdentifyingCode(){
	var identifyingCode = getRegisterIdentifyingCode();
	if(!isRegisterIdentifyingCodeValid(identifyingCode)){
		$("#identifyingCode").val("");
		$("#identifyingCode").attr("placeholder","Invalid");
		return false;
	}
	return true;
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
				alert(result);
			},
			error: function(state){
				alert("error");
            }
		});
	}
	return false;
}

function sendRegisterIdentifyingCode(){
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
