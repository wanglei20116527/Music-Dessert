function setHeightForRightPartOfLogInBox(){
	var heightOfLogInBox = $("#logInBox").height() - 40;
	$("div.right_box").css("height",heightOfLogInBox);
}

function setPositionOfRegisterButtonForLogInBox(){
	var heightOfLogInBox = $("#logInBox").height() - 128;
	$("div.registerButton").css("top", heightOfLogInBox);
	$("div.registerButton").css("left", 20);
}

function openLogInBox(){
	$("#logIn_Box").css("display","block");
	setHeightForRightPartOfLogInBox();
	setPositionOfRegisterButtonForLogInBox();
}

function closeLogInBox(){
	$("#logIn_Box").css("display","none");
}

function openRegisterBoxForLogInPage(){
	closeLogInBox();
	openRegisterBox();
}

function removeLogInBox(){
	$("#logIn_Box").remove();
}
