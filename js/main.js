$(document).ready(function(){
	/*  Hamburger Menu & Icon  */
	// $('.hamburger').on('click', function(e){		
	// 	e.preventDefault();
	// 	$(this).toggleClass('opned');
	// 	$('header nav').toggleClass('active');		
	// });
	/*  Advanced search form & Icon  */
	// $('#advanced_search_btn').on("click", function(e){
	// 	e.preventDefault();
	// 	var ads_box =$('.advanced_search');		
	// 	if(!ads_box.hasClass('advanced_displayed')){
	// 		$(this).addClass('active');
	// 		ads_box.stop().fadeIn(200).addClass('advanced_displayed');
	// 	}else{
	// 		$(this).removeClass('active');
	// 		ads_box.stop().fadeOut(200).removeClass('advanced_displayed');
	// 	}

	// });
	$('.carousel').carousel({
	 interval: 3000
	});
	$('.login').on("click", function(e){
		e.preventDefault();
		var ads_box =$('.log');		
		if(!ads_box.hasClass('h')){
			ads_box.stop().fadeIn(200).addClass('h');
		}else{
			$('.reg').addClass('h');
			$('.est').addClass('h');
			ads_box.stop().fadeOut(200).removeClass('h');
		}
	});
	// http://localhost:8080/esms/user/login.do

	// $('.mod-login').on("click", function(){
	// 	$.ajax({
	// 		url: "user/login.do",
	// 		type: "get",
	// 		dataType: "json",
	// 		data: {

	// 		},
	// 		success: function(data) {
	// 			console.log("success...");

	// 			//调用创建表和填充动态填充数据的方法.  
	// 			// createShowingTable(data)
	// 		},
	// 		error: function() {
	// 			console.log("error...");
	// 		}
	// 	});
	// });

	$('.register').on("click", function(e){
		e.preventDefault();
		var ads_box =$('.reg');		
		if(!ads_box.hasClass('h')){
			ads_box.stop().fadeIn(200).addClass('h');
		}else{
			$('.log').addClass('h');
			$('.est').addClass('h');
			ads_box.stop().fadeOut(200).removeClass('h');
		}
	});

	$('.establish').on("click", function(e){
		e.preventDefault();
		var ads_box =$('.est');		
		if(!ads_box.hasClass('h')){
			ads_box.stop().fadeIn(200).addClass('h');
		}else{
			$('.log').addClass('h');
			$('.reg').addClass('h');
			ads_box.stop().fadeOut(200).removeClass('h');
		}
	});
});

function getData() {
		$.ajax({
			url: "./user/login.do",
			type: "get",
			dataType: "json",
			data: {

			},
			success: function(data) {
				alert("success...");

				//调用创建表和填充动态填充数据的方法.  
				// createShowingTable(data)
			},
			error: function() {
				alert("error...");
			}
		});
	}