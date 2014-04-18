function logout(){
	$.ajax({
		url: getRootPath() + "/logoutAction" ,
		type: "POST",
		dateType: "json",
		error: function(state){
			alert("service error");
		}
	});
	removeLogoutDiv();
	createLoginDiv();
}

function removeLogoutDiv(){
	$("#logout").remove();
}

function createLogoutDiv(userName){
	var logoutDivDOMString = "<div id = 'logout'>" +
								"<a href = 'javascript:;'>"+ userName +"</a>" +
								"<span>|</span>" +
								"<a href = 'javascript:;'>Music Dessert</a>" +
								"<span>|</span>" +
								"<a href = '/MusicDessert_Software/logoutAction'>Layout</a>" +
							"</div>";
	$("#head_playerInterface").append(logoutDivDOMString);
}