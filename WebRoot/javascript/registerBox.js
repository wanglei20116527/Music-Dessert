function setHeightForRightPartOfRegisterBox(){
	var heightOfLogInBox = $("#registerBox").height() - 40;
	$("div.right_box").css("height",heightOfLogInBox);
}

function setPositionOfRegisterButtonForRegisterBox(){
	var heightOfRegisterBox = $("#registerBox").height() - 128;
	$("div.registerButton").css("top", heightOfRegisterBox);
	$("div.registerButton").css("left", 20);
}

function openRegisterBox(){
	$("#register_Box").css("display","block");
	setHeightForRightPartOfRegisterBox();
	setPositionOfRegisterButtonForRegisterBox();
}

function closeRegisterBox(){
	$("#register_Box").css("display","none");
}

function removeRegisterBox(){
	$("#register_Box").remove();
}