$(document).ready(function() {
	$('.mod-login').click(function() {
		loginVerify.login();
	});

	$('.mod-register').click(function() {
		registerVerify.register();
	});

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
				var ads_box = $('.log');
					if (!ads_box.hasClass('h')) {
						ads_box.stop().fadeIn(200).addClass('h');
					} else {
						$('.reg').addClass('h');
						$('.est').addClass('h');
						ads_box.stop().fadeOut(200).removeClass('h');
					}
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}
