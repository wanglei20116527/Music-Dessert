function createLoginDivOrLogoutDiv(){
	var userLoginState = {};
	userLoginState = isUserLogin();
	if(userLoginState[0]){//表示用户是否已经登录
		removeLogInDiv();
		createLogoutDiv(userLoginState[1]);//userLoginState[1]表示用户名
	}else{
		removeLogoutDiv();
		createLoginDiv();
	}
}