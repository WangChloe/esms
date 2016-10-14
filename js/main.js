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
	$('#carousel').carousel({
	 interval: 3000
	});
	$('.login').on("click", function(e){
		e.preventDefault();
		var ads_box =$('.log');		
		if(!ads_box.hasClass('hide')){
			ads_box.stop().fadeIn(200).addClass('hide');
		}else{
			$('.reg').addClass('hide');
			$('.est').addClass('hide');
			ads_box.stop().fadeOut(200).removeClass('hide');
		}
	});

	$('.register').on("click", function(e){
		e.preventDefault();
		var ads_box =$('.reg');		
		if(!ads_box.hasClass('hide')){
			ads_box.stop().fadeIn(200).addClass('hide');
		}else{
			$('.log').addClass('hide');
			$('.est').addClass('hide');
			ads_box.stop().fadeOut(200).removeClass('hide');
		}
	});

	$('.establish').on("click", function(e){
		e.preventDefault();
		var ads_box =$('.est');		
		if(!ads_box.hasClass('hide')){
			ads_box.stop().fadeIn(200).addClass('hide');
		}else{
			$('.log').addClass('hide');
			$('.reg').addClass('hide');
			ads_box.stop().fadeOut(200).removeClass('hide');
		}
	});
});
