$(document).ready(function() {

	// 轮播图
	$('.carousel').carousel({
		interval: 3000
	});

	// 导航栏
	// $('.userId').hover(function() {
	// 	$(this).addClass('over');
	// 	$(this).find('ul').show();
	// }, function() {
	// 	$(this).removeClass('over');
	// 	$(this).find('ul').hide();
	// });
	$('nav').on('mouseover', '.userId', function(event) {
		event.preventDefault();
		$(this).addClass('over');
		$(this).find('ul').show();
	}).on('mouseover', '.userId ul', function(event) {
		event.preventDefault();
		if(!$(this).parent().hasClass('over')) {
			$(this).parent().addClass('over');
		}
	}).on('mouseout', '.userId ul', function(event) {
		event.preventDefault();
		$(this).parent().removeClass('over');
		$(this).hide();
	});

	// 功能
	listVerify.list();

	$('.login').on("click", function(e) {
		e.preventDefault();
		$('#mask').show();
		$('.log').show(100);
		$('.reg, .est').hide();
	});
	$('.register').on("click", function(e) {
		e.preventDefault();
		$('#mask').show();
		$('.reg').show(100);
		$('.log, .est').hide();
	});
	$('.establish').on("click", function(e) {
		e.preventDefault();
		$('#mask').show();
		$('.est').show(100);
		$('.log, .reg').hide();
	});

	$('.mod-login').click(function() {
		loginVerify.login();
	});

	$('.mod-register').click(function() {
		registerVerify.register();
	});

	$('.mod-est').click(function() {
		estVerify.est();
	})

	$('.listings').on('click', '.status-btn', function(event) {
		event.preventDefault();
		console.log(this);
		accVerify.accept(this);
	})

	// 跳转至个个人中心
	$('.userId ul li a').on('click', function(event) {
		event.preventDefault();
		var way = $(this).attr('way');
		// 跳转页面通过地址栏获取信息  "?userId=36&userTel=18&way=est"
		window.open('user.html?userId=' + $('.userId').attr('id').substring(4) + '&userTel=' + $('.userId').find('a').eq(0).text()  + '&way=' + way, '_blank');
	});

	// 遮罩
	$('#mask').css('height', $(document.body).height() + 'px');
	$('#mask').click(function() {
		$('#mask .modall').hide();
	});
});

// 功能：登录
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
				var userId = data.data.id;
				var mobile = $("#user-mobile").val();
				$('.log, #mask').hide();
				$('nav').find('a.login_btn').remove().end();
				$('.userId').css('display', 'block').attr('id', 'user' + userId).find('a').eq(0).html('<a href="javascript:;"><i class="icon-user"></i>' + mobile + '</a>');
				// $('<li></li>').addClass('userId').attr('id', 'user' + userId).append('<a href="javascript:;"><i class="icon-user"></i>' + mobile + '</a><ul><li>查看我发布的订单</li><li>查看我接受的订单</li></ul>').appendTo($('nav ul'));
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

// 功能：注册
var registerVerify = {
	register: function() {
		if (this.check()) {
			this.RegisterSuccess();
		}
	},
	check: function() {
		//TODO：正则检验
		if ($("#reg-mobile").val() == "") {
			alert("手机号不能为空");
			$("#reg-mobile").focus();
			return false;
		}
		if ($("#reg-pwd").val() == "") {
			alert("密码不能为空")
			$("#reg-pwd").focus();
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
				$('#mask').addClass('h');
				if (!parseInt(data.code)) {
					$('.log').show(100);
					$('.est, .reg').hide();
				}
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

// 功能：创建订单
var estVerify = {
	est: function() {
		if (this.check()) {
			this.EstSuccess();
		}
	},
	check: function() {
		// TODO：正则检验
		return true;
	},
	EstSuccess: function() {
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/esms/orderBase/establish.do?",
			//localhost:8080/esms/orderBase/establish.do?orderBase.customerId=1& ...
			//这个地方ajax提交数据，你这样拼接是不行的， 你的拼接只适合直接加在url后面,
			//post请求格式需要{customerId:1}形式，另外form表单提交方式如下：orderBaseForm为表单id
			data:$('#orderBaseForm').serialize(),
//			data: 'orderBase.customerId=' + parseFloat($("#orderBase-Cid").val()) + '&orderBase.inc=' + $("#orderBase-inc").val() +
//				'&orderBase.typ=' + $("#orderBase-typ").val() + '&orderBase.price=' + $("#orderBase-price").val() +
//				'&orderBase.notes=' + $("#orderBase-notes").val() +
//				'&orderBase.tTime=' + $("#orderBase-tTime").val() + '&orderBase.sTime=' + $("#orderBase-sTime").val() +
//				'',
			success: function(data) {
				console.log(data.msg);
				if (!parseInt(data.code)) {
					$('.est, #mask').hide();
					// window.location.reload();
					listVerify.list();
				}
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

// 功能：显示所有已发布未接受的订单
var listVerify = {
	list: function() {
		this.ListSuccess();
	},
	ListSuccess: function() {
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/esms/orderBase/findByEstablish.do",
			success: function(data) {
				console.log(data.msg);
				if (!parseInt(data.code)) {
					var orderBase = data.data;
					if (orderBase.length) {
						var list_box = $('.properties_list');
						list_box.html('');
						for (var i = 0; i < orderBase.length; i++) {
							var oLi = $('<li></li>').attr('id', 'ob'+ orderBase[i].id).appendTo(list_box);
							var oA = $('<a></a>').attr('href', 'javascript:;').appendTo(oLi);
							var oImg = $('<img/>').attr('src', 'img/property_' + (i % 3 + 1) + '.jpg').appendTo(oA);
							var oPrice = $('<span></span>').addClass('price').html('RMB ' + orderBase[i].price).appendTo(oLi);

							var oDetail = $('<div></div>').addClass('property_details').appendTo(oLi);
							var oInfo = $('<div></div>').addClass('list-info').appendTo(oDetail);
							var oLs = $('<div></div>').addClass('list-status').appendTo(oDetail);
							var oInc = $('<h1></h1>').addClass('list-inc').appendTo(oInfo);
							var otTime = $('<h2></h2>').addClass('list-tTime').html('代领时间：').appendTo(oInfo);
							var osTime = $('<h2></h2>').addClass('list-sTime').html('取货时间：').appendTo(oInfo);
							var oIncA = $('<a></a>').attr('href', 'javascript:;').appendTo(oInc);
							var oSt = $('<span></span>').addClass('property_size').html(orderBase[i].daiTime + ':00').appendTo(otTime);
							var oSs = $('<span></span>').addClass('property_size').html(orderBase[i].sendTime + ':00').appendTo(osTime);
							var oBtn = $('<a class="status-btn"><span class="line line-top"></span><span class="line line-right"></span><span class="line line-bottom"></span><span class="line line-left"></span></a>').appendTo(oLs);
							var oStatus = $('<span></span>').addClass('status').appendTo(oBtn);
							statVerify.stat(orderBase[i].id, orderBase[i].customerId);

							var inc = '';
							switch (orderBase[i].inc) {
								case 0:
									inc = '韵达快递';
									break;
								case 1:
									inc = '圆通快递';
									break;
								case 2:
									inc = '申通快递';
									break;
								case 3:
									inc = '中通快递';
									break;
								case 4:
									inc = '顺丰快递';
									break;
								case 5:
									inc = '优速快递';
									break;
								default:
									inc = '其他快递';
									break;
							}
							oIncA.html(inc);
						}
					}
					$('#mask').css('height', $(document.body).height() + 'px');
				}
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

// 功能：显示当前订单状态
var statVerify = {
	stat: function(id, cId) {
		if (this.check()) {
			this.StatSuccess(id, cId);
		}
	},
	check: function() {
		// TODO：正则检验
		return true;
	},
	StatSuccess: function(id, cId) {
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/esms/orderProcess/findByOrderId.do?",
			//http://localhost:8080/esms/orderProcess/findByOrderId.do?orderId=1
			data: 'orderId=' + id,
			success: function(data) {
				console.log(data.msg);
				console.log(data.data);
				if (!parseInt(data.code)) {
					console.log('stat success');
					// stat 1:发布 2:接受 3:取消 4:完成 5:评价 6:过期
					var stat = data.data.stat;
					console.log(stat);
					var btnIn = '';
					switch(stat) {
						case 1:
							btnIn = '接受';
							break;
						case 2:
							btnIn = '取消';
							break;
						case 3:
							btnIn = '完成';
							break;
						case 4:
							btnIn = '评价';
							break;
						case 5:
							btnIn = '已评价';
							break;
						case 6:
							btnIn = '已过期';
							break;
					}
					$('#ob' + id).find('.status-btn').attr('id', 'acc' + id).addClass('cId' + cId).find('.status').html(btnIn);
				}
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

// 功能：接受订单
var accVerify = {
	accept: function(oBtn) {
		if (this.check(oBtn)) {
			this.AcceptSuccess(oBtn);
		}
	},
	check: function(oBtn) {
		//TODO：正则检验
		// user36    status-btn cId36
		if(!$('.userId').find('a').eq(0).text()){
			console.log('用户还未登录');
			$('#mask').show();
			$('.log').show(100);
			$('.reg, .est').hide();
			return false;
		} else {
			var uId = $('.userId').attr('id').substring(4);
		}
		var cId = $(oBtn).attr('class').substring($(oBtn).attr('class').indexOf('cId') + 3);
		if( uId== cId) {
			alert('不能接受自己发布的订单');
			return false;
		}
		return true;
	},
	AcceptSuccess: function(oBtn) {
		$.ajax({
			type: "GET",
			//  http://localhost:8080/esms/orderBase/updateAgentId.do?id=1&agentId=2
			url: "http://localhost:8080/esms/orderBase/updateAgentId.do?",
			data: 'id=' + $(oBtn).attr('id').substring(3) + '&agentId=' + $('.userId').attr('id').substring(4),
			success: function(data) {
				console.log(data.msg);
				$(oBtn).parents('li').remove();
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}