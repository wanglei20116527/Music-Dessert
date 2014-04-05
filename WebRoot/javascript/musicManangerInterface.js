function displayOrHiddenPlaylistInterface(){
	if($("#musicManagerInterface").css("left") == "0px"){
		$("#musicManagerInterface").animate({left:"-650px"});
	}else{
		$("#musicManagerInterface").animate({left:"0%"});
	}
	
}