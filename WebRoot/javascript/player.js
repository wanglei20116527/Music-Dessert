function getMusicPlayer(){
	return flowplayer($("#flowplayer"));
}

function switchPlayedMusicState(){
	var previousState = $("#loopCurrentAlbum").attr("value");
	if(previousState == "true"){
		$("#loopCurrentAlbum").attr("value","false");
		alert(false);
	}else{
		$("#loopCurrentAlbum").attr("value","true");
		alert(true);
	}
}

function isLoopCurrentPlayedMusic(){
	var previousState = $("#loopCurrentAlbum").attr("value");
	if(previousState == "true"){
		return true;
	}else{
		return false;
	}
}


//这个函数是用来自动播放歌曲
function autoPlayMusic(){
	var musicPlayer = getMusicPlayer();
	if(isLoopCurrentPlayedMusic()){
		musicPlayer.resume();
	}else{
		musicPlayer.next();
	}
}

function initFlowPlayer(musicPlaylistJSONArray){
	$("#flowplayer").empty();
	$("#flowplayer").flowplayer({
      live: false,
      ratio: 5/12,
      loop: false,
      rtmp: "rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st",
      playlist: musicPlaylistJSONArray        
    });
	var musicPlayer = getMusicPlayer();
	musicPlayer.bind("finish",autoPlayMusic);
}



function playMusic(indexMusicInplaylist){
	var musicPlayer = getMusicPlayer();
	var currentMusic = musicPlayer.video;
	if(indexMusicInplaylist == "0" && currentMusic.index == 0){
		musicPlayer.play();
	}else{
		musicPlayer.play(indexMusicInplaylist);
	}
}

function playNext(){
	var musicPlayer = getMusicPlayer();
	musicPlayer.next();
}

function playPrevious(){
	var musicPlayer = getMusicPlayer();
	musicPlayer.prev();
}

function playOrPausePlayedMusic(){
	var musicPlayer = getMusicPlayer();
	if(musicPlayer.playing){
		musicPlayer.pause();
	}else{
		musicPlayer.play();
	}
}


function initFlowPlayerWithRecommandedMusics(){
	var musics = null;
	$.ajax({
	 	url: getRootPath() + "/recommandedMusicAction" ,
		type: "POST",
		async: false,
		dateType: "json",
		success: function(recommandedMusics){
			recommandedMusics = $.parseJSON(recommandedMusics);
			var recommandedMusicsPlaylistJSONArray = getRecommandedMusicsPlaylistJSONArray(recommandedMusics);
			initFlowPlayer(recommandedMusicsPlaylistJSONArray);
			addMusicsToPlaylist(recommandedMusics);
		},
		error: function(state){
			alert("service error");
        }
	});
}

//下面的函数是将音乐给加载到
function addMusicsToPlaylist(musics){//music是一个对象数组，每个元素是一个对象，该对象中含有musicID, musicName和musicPath属性
	for(var i = 0; i < musics.length; ++i){
		var musicName = musics[i].musicName;
		var musicPlaylistItemDOMString = "<li>" +
											"<a id = '" + i + "' href = 'javascript:;' onclick = 'playMusic(" + i + ")'" + ">" +
												musicName + 
											"</a>" +
											"<span></span>" +
										 "</li>";
		var musicPlaylistItemDOM = $(musicPlaylistItemDOMString);
		$("#playlistContainer").append(musicPlaylistItemDOM);
		
	}
}

function getRecommandedMusicsPlaylistJSONArray(musics){
	var musicsJSONArray = [];
	for(var i = 0; i < musics.length; ++i){
		var musicJSON = [{mp4:musics[i].musicPath}];
		musicsJSONArray[i] = musicJSON;
	}
	return musicsJSONArray;
}


function addMusicToMusicManager(music){//music是一个对象数组，每个元素是一个对象，该对象中含有musicID, musicName和musicPath属性
	
}
