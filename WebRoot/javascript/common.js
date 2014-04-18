 //下面的函数是用来获得当前project的rootPath
function getRootPath() {	 
     var curWwwPath = window.document.location.href;
     var pathName = window.document.location.pathname;
     var pos = curWwwPath.indexOf(pathName);
     var localhostPath = curWwwPath.substring(0, pos);
     var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
     return(localhostPath + projectName);
}

function isUserNameValid(userName){
	var regExp = new RegExp("^[a-zA-Z][0-9a-zA-Z]{1,}$");
	return regExp.test(userName);
}

function isPasswordValid(password){
	var regExp = new RegExp("");//对于这里我们的正则表达是还没有写，请有时间的时候给加上
	return true;
	//return regExp.test(password);
}

//下面的函数是用来检测用户输入的手机密码是否合法
function isPhoneNumberValid(phoneNumber){
	var regExp = new RegExp("^1[3|5|8][0-9]{9}");
	return regExp.test(phoneNumber);
}

function isIdentifyingCodeValid(identifyingCode){
	var regExp = new RegExp("^[0-9]{6}$");
	return regExp.test(identifyingCode);
}
