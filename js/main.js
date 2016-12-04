$(document).ready(function() {
	listVerify.list();
	$('.mod-login').click(function() {
		loginVerify.login();
	});

	$('.mod-register').click(function() {
		registerVerify.register();
	});

	$('.mod-est').click(function() {
		estVerify.est();
	})

	$('.carousel').carousel({
		interval: 3000
	});
	$('.login').on("click", function(e) {
		e.preventDefault();
		var ads_box = $('.log');
		if (!ads_box.hasClass('h')) {
			ads_box.stop().fadeIn(200).addClass('h');
		} else {
			$('.reg').addClass('h');
			$('.est').addClass('h');
			ads_box.stop().fadeOut(200).removeClass('h');
		}
	});
	// http://localhost:8080/esms/user/login.do

	$('.register').on("click", function(e) {
		e.preventDefault();
		var ads_box = $('.reg');
		if (!ads_box.hasClass('h')) {
			ads_box.stop().fadeIn(200).addClass('h');
		} else {
			$('.log').addClass('h');
			$('.est').addClass('h');
			ads_box.stop().fadeOut(200).removeClass('h');
		}
	});

	$('.establish').on("click", function(e) {
		e.preventDefault();
		var ads_box = $('.est');
		if (!ads_box.hasClass('h')) {
			ads_box.stop().fadeIn(200).addClass('h');
		} else {
			$('.log').addClass('h');
			$('.reg').addClass('h');
			ads_box.stop().fadeOut(200).removeClass('h');
		}
	});
});

var loginVerify = {
	login: function() {
		if (this.check()) {
			this.LoginSuccess();
		}
	},
	check: function() {
		//TODO：正则检验
		if ($("#user-mobile").val() == "") {
			alert("手机号不能为空");
			$("#user-mobile").focus();
			return false;
		}
		if ($("#user-pwd").val() == "") {
			alert("密码不能为空")
			$("#user-pwd").focus();
			return false;
		}
		return true;
	},
	LoginSuccess: function() {
		$.ajax({
			type: "GET",
			// url: "http://localhost:8080/esms/user/login.do?user.mobile=" + $("#user-mobile").val() + "&user.pwd=" + $("#user-pwd").val(),
			url: "http://localhost:8080/esms/user/login.do?",
			data: 'user.mobile=' + $("#user-mobile").val() + '&user.pwd=' + $("#user-pwd").val() + '',
			success: function(data) {
				console.log(data.msg);
				var mobile = $("#user-mobile").val();
				$('.log').addClass('h');
				$('nav').find('a.login_btn').remove().end();
				$('nav ul').append('<li><a href="javascript:;"><i class="icon-user"></i>' + mobile + '</a></li>');
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

var registerVerify = {
	register: function() {
		if (this.check()) {
			this.RegisterSuccess();
		}
	},
	check: function() {
		//TODO：正则检验
		if ($("#user-mobile").val() == "") {
			alert("手机号不能为空");
			$("#user-mobile").focus();
			return false;
		}
		if ($("#user-pwd").val() == "") {
			alert("密码不能为空")
			$("#user-pwd").focus();
			return false;
		}
		return true;
	},
	RegisterSuccess: function() {
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/esms/user/register.do?",
			// localhost:8080/esms/user/register.do?user.mobile=111&user.name=aaa&user.pwd=3 &user.dorm=aaa&user.user_no=111
			data: 'user.mobile=' + $("#reg-mobile").val() + '&user.pwd=' + $("#reg-pwd").val() +
			'&user.userNo=' + $("#reg-userNo").val() + '&user.name=' + $("#reg-name").val() +
			'&user.dorm=' + $("#reg-dorm").val() + '',
			success: function(data) {
				console.log(data.msg);
				if(!parseInt(data.code)) {
					var ads_box = $('.log');
					if (!ads_box.hasClass('h')) {
						ads_box.stop().fadeIn(200).addClass('h');
					} else {
						$('.reg').addClass('h');
						$('.est').addClass('h');
						ads_box.stop().fadeOut(200).removeClass('h');
					}
				}
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

var estVerify = {
	est: function() {
		if (this.check()) {
			this.EstSuccess();
		}
	},
	check: function() {
		// TODO：正则检验
		// if ($("#user-mobile").val() == "") {
		// 	alert("手机号不能为空");
		// 	$("#user-mobile").focus();
		// 	return false;
		// }
		// if ($("#user-pwd").val() == "") {
		// 	alert("密码不能为空")
		// 	$("#user-pwd").focus();
		// 	return false;
		// }
		return true;
	},
	EstSuccess: function() {
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/esms/orderBase/establish.do?",
			//localhost:8080/esms/orderBase/establish.do?orderBase.customerId=1& ...
			data: 'orderBase.customerId=' + parseFloat($("#orderBase-Cid").val()) + '&orderBase.inc=' + $("#orderBase-inc").val() +
			'&orderBase.typ=' + $("#orderBase-typ").val() + '&orderBase.price=' + $("#orderBase-price").val() +
			'&orderBase.notes=' + $("#orderBase-notes").val() +
			'&orderBase.tTime=' + $("#orderBase-tTime").val() + '&orderBase.sTime=' + $("#orderBase-sTime").val() +
			'',
			success: function(data) {
				console.log(data.msg);
				// var ads_box = $('.log');
				// if (!ads_box.hasClass('h')) {
				// 	ads_box.stop().fadeIn(200).addClass('h');
				// } else {
				// 	$('.reg').addClass('h');
				// 	$('.est').addClass('h');
				// 	ads_box.stop().fadeOut(200).removeClass('h');
				// }
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

var listVerify = {
	list: function() {
		this.ListSuccess();
	},
	ListSuccess: function() {
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/esms/orderBase/findByEstablish.do",
			success: function(data) {
				console.log(data);
				console.log(data.data);
				console.log(data.code);
				if(!parseInt(data.code)) {
					var orderBase = data.data;
					if(orderBase.length) {
						var list_box = $('.properties_list');
						for(var i = 0; i < orderBase.length; i++) {
							var oLi = $('<li></li>').appendTo(list_box);
							var oA = $('<a href="javascript:;"></a>').appendTo(oLi);
							var oImg = $('<img/>').appendTo(oA);
							var oPrice = $('<span class="price"></span>').appendTo(oLi);
							var oDetail = $('<div class="property_details"></div>').appendTo(oLi);
							var oInc = $('<h1 class="list-inc"></h1>').appendTo(oDetail);
							var oIncA = $('<a></a>').appendTo(oInc);
							var otTime = $('<h2 class="list-tTime">代领时间：</h2>').appendTo(oDetail);
							var oSt = $('<span class="property_size"></span>').appendTo(otTime);
							var osTime = $('<h2 class="list-sTime">取货时间：</h2>').appendTo(oDetail);
							var oSs = $('<span class="property_size"></span>').appendTo(osTime);

							switch(i % 3) {
								case 0:
									oImg.attr('src', 'img/property_1.jpg'); break;
								case 1:
									oImg.attr('src', 'img/property_2.jpg'); break;
								case 2:
									oImg.attr('src', 'img/property_3.jpg'); break;
							}

							oPrice.html('RMB ' + orderBase[i].price);
							switch(orderBase[i].inc) {
								case 0: inc = '韵达快递'; break;
								case 1: inc = '圆通快递'; break;
								case 2: inc = '申通快递'; break;
								case 3: inc = '中通快递'; break;
								case 4: inc = '顺丰快递'; break;
								case 5: inc = '优速快递'; break;
								default: inc = '其他快递'; break;
							}
							oIncA.html(inc);
							oSt.html(orderBase[i].tTime + ':00');
							oSs.html(orderBase[i].sTime + ':00');
						}
					}
				}
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}
