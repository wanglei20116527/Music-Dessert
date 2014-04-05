function getMusicPlayer(){
  return $("#flowplayer").flowplayer();
}

function loopPlayedMusic(){
  var musicPlayer = getMusicPlayer();
  if($("#loopCurrentAlbum").attr("value") == "true"){
    var indexPlayedMusicInplaylist = musicPlayer.video.index;
    musicPlayer.play();
  }
}

function initFlowPlayer(){
	$("#flowplayer").flowplayer({
      live: true,
    	ratio: 5/12,
      loop: true,
      rtmp: "rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st",
    	playlist: [
              [ 
                { webm:   "file:///home/wanglei/4.mp3"},
                { mp4:   "file:///home/wanglei/4.mp3"},
                { ogg:   "file:///home/wanglei/4.mp3"}
              ],
              [ 
                { webm:  "file:///home/wanglei/testmusic.wav"},
                { mp4:   "file:///home/wanglei/testmusic.wav"},
                { ogg:   "file:///home/wanglei/testmusic.wav"}
              ],
              [
                { webm:   "file:///home/wanglei/music1.mp3"},
                { mp4:   "file:///home/wanglei/music1.mp3"},
                { ogg:   "file:///home/wanglei/music1.mp3"}
              ],
              [ 
                { mp4:   "file:///home/wanglei/2.mp3"}
              ],
              [ 
                { mp4:   "file:///home/wanglei/3.mp3"}
              ],
    			]
  });
  var musicPlayer = getMusicPlayer();
  musicPlayer.bind("finish", function(e, api){
    loopPlayedMusic();
  });
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

//musics is array, and the 
function initPlaylist(musics){

}

function addMusicToPlaylist(music){

}
