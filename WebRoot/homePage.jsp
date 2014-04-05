<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="CSS/homePage.css"/>
	<link rel="stylesheet" type="text/css" href="CSS/playerInterface.css"/>
	<link rel="stylesheet" type="text/css" href="CSS/musicManangerInterface.css"/>
	<link rel="stylesheet" type="text/css" href="CSS/musicPlayer.css"/>
	<link rel="stylesheet" type="text/css" href="plugins/flowplayer/skin/all-skins.css"/>
	<link rel="stylesheet" type="text/css" href="plugins/perfect-scrollbar/src/perfect-scrollbar.css"/>

	<script type="text/javascript" src="javascript/jquery.js"></script>
	<script type="text/javascript" src="plugins/flowplayer/flowplayer.min.js"></script>
	<script type="text/javascript" src="plugins/perfect-scrollbar/src/jquery.mousewheel.js"></script>
	<script type="text/javascript" src="plugins/perfect-scrollbar/src/perfect-scrollbar.js"></script>
	
	<script type="text/javascript" src = "javascript/logInBox.js"></script>
	<script type="text/javascript" src = "javascript/registerBox.js"></script>
	<script type="text/javascript" src="javascript/musicManangerInterface.js"></script>
	<script type="text/javascript" src="javascript/playlist.js"></script>
	<script type="text/javascript" src="javascript/homePage.js"></script>
	<script type="text/javascript" src="javascript/player.js"></script>
		
	<script>
		$(window).resize(function(){
			ajustSizeHomePage();
		});	
	</script>

  </head>
  
  <body onload = "ajustSizeHomePage()">
		<div id = "playerInterface">
			<div id = "head_playerInterface">
				<div>
					<span>Music</span>
					<span>Dessert</span>
				</div>
				<div>
					<a href = "javascript:;" onclick = "openLogInBox()">登录</a>
					<i></i>
					<a href = "javascript:;" onclick = "openRegisterBox()">注册</a>
					<i></i>
					<a href = "javascript:;">Music Dessert</a>
				</div>
			</div>
			
			<div id = "foot_playerInterface">
				<div>
					<span>网站设计与开发技术</span>
				</div>
				<div>
					<span>王磊</span>
					<span>屈家彬</span>
					<span>张迪</span>
					<span>姚启发</span>
					<span>王雷</span>
				</div>
				<div>
					<div>
						<span>© 2014 Music Dessert 本网站的设计界面是参考豆瓣FM和百度音乐盒的界面设计，并且本网站是非商业网站</span>
					</div>
				</div>
				
			</div>
			
			<div id = "playlist_box">
				<div id = "playlist">
					<ul>
						<li>
							<a href = "javascript:;">王磊</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">王磊</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">王磊</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						<li>
							<a href = "javascript:;">呼吸</a>
							<span></span>
						</li>
						

					</ul>
				</div>
			</div>
			
			<div id = "player_box">	
				<div id = "music_image">
					<img src="CSS/images/test2.jpg"/>
				</div>
				<div id = "player">
					<div id = "playKey">
						<a href = "javascript:;" onclick = "playOrPausePlayedMusic()"></a>
					</div>
					<div>
						<span id = "musicianName">孙燕姿</span>
						<span>
							<<span class = "albumName">wanglei</span> >&nbsp;
							<span id = "albumYear">2008</span>
						</span>
					</div>
					<div>
						<span class = "albumName">孙燕姿</span>
						<span>------------------------</span>
					</div>
					<div>
						<span id = "time">2:13</span>
						<a href = "javascript:;">V</a>
					</div>
					<div>
						<a id = "previousAlbum" href = "javascript:;" onclick = "playPrevious()"></a>
						<a id = "loopCurrentAlbum" href = "javascript:;" value = "true" onclick="startOrStopLoop()"></a>
						<a id = "nextAlbum" href = "javascript:;" onclick = "playNext()"></a>
					</div>
				</div>
				
			</div>

		</div>
		
		<div id = "musicManagerInterface">
			<div id = "musicManager_head">
				<div>
					<span>Music</span>
					<span>Dessert</span>
				</div>
				<div id = "search_box">
					<input id = "search_condition" type = "text" placeholder = "音乐搜索"/>
					<a href = "javascript:;" onclick = "alert('wanglei is cool')"></a>
				</div>
			</div>
			<div id = "musicManager_body">
				<div id = "music_category">
					<ul>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
						<li>
							<a href = "javascript:;">摇滚</a>
						</li>
					</ul>
				</div>
				<div id = "music">
					<div class = "music_category_default">
						<div class = "music_category_name">
							<span>摇滚</span>
						</div>
						<div>
							<ul>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div class = "music_category_default">
						<div class = "music_category_name">
							<span>摇滚</span>
						</div>
						<div>
							<ul>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div class = "music_category_default">
						<div class = "music_category_name">
							<span>摇滚</span>
						</div>
						<div>
							<ul>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div class = "music_category_default">
						<div class = "music_category_name">
							<span>摇滚</span>
						</div>
						<div>
							<ul>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
								<li>
									<div>
										<img src = "images/test.jpg"/>
										<span>
											<a href = "javascript:;">wanglei</a>
											<span>wanglei 4:00</span>
										</span>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>

			</div>
			<div id = "switch_button">
				<a href = "javascript:;" onclick="displayOrHiddenPlaylistInterface()"></a>
			</div>
			
		</div>
		<div id = "scrollbar_background"></div>

		<script type="text/javascript">
			$("div#musicManagerInterface").perfectScrollbar({suppressScrollX: true});
		</script>
		<!-- 下面的代码 是用来处理 当用户没有登录的时候，我们将会将logIn.jsp和register.jsp文件给加载进来-->
 		<s:if test="true">
  			<s:include value="logIn.jsp"/>
  			<s:include value="register.jsp"/>
  		</s:if>
	</body>
</html>
