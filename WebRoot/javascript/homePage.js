function ajustSizeHomePage(){
	if(document.body.clientHeight < 500 || document.body.clientWidth < 800 ){
		var heightOfPlaylistBox = $("#playlist_box").height();
		var topOfPlayerInterface = parseInt(heightOfPlaylistBox) - 681 * 0.75 + 476;
		topOfPlayerInterface += "px";
		$("#head_playerInterface").css({ position:"absolute", top:"0px" });
		$("#foot_playerInterface").css({ position:"absolute", top:topOfPlayerInterface});
		$("#player_box").css({position:"absolute", top:"80px", right:"150px"});
	}else{
		$("#head_playerInterface").css({ position:"fixed", top:"0px" });
		$("#foot_playerInterface").css({ position:"fixed", top:"476px"});				
		$("#player_box").css({position:"fixed", top:"80px", right:"150px"});
	}
}