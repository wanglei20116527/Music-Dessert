function createLoginDivOrLogoutDiv(){
	var userLoginState = {};
	userLoginState = isUserLogin();
	if(userLoginState[0]){//��ʾ�û��Ƿ��Ѿ���¼
		removeLogInDiv();
		createLogoutDiv(userLoginState[1]);//userLoginState[1]��ʾ�û���
	}else{
		removeLogoutDiv();
		createLoginDiv();
	}
}