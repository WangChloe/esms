'use strict';

$(document).ready(function() {
	// 跳转页面通过地址栏获取信息  "?userId=36&userTel=18&way=est"
	var arr = window.location.search.substring(1).split(/=|&/g);
	var userId = arr[1];
	var userTel = arr[3];
	var way = arr[5];

	$('.userId').attr('id', 'user' + userId).find('a').eq(0).html('<a href="javascript:;"><i class="icon-user"></i>' + userTel + '</a>');

	$('nav').on('mouseover', '.userId', function(event) {
		event.preventDefault();
		$(this).addClass('over');
		$(this).find('ul').show();
	}).on('mouseover', '.userId ul', function(event) {
		event.preventDefault();
		if (!$(this).parent().hasClass('over')) {
			$(this).parent().addClass('over');
		}
	}).on('mouseout', '.userId ul', function(event) {
		event.preventDefault();
		$(this).parent().removeClass('over');
		$(this).hide();
	});


	// 功能
	userEstVerify.userEst();

	$('.establish').on("click", function(e) {
		e.preventDefault();
		window.open('index.html');
		$('#mask').show();
		$('.est').show(100);
		$('.log, .reg').hide();
	});

	// 查看个人发布/接受 选项卡
	$('.search ul li').on('click', function(event) {
		event.preventDefault();
		var aList = $('.properties_list');
		for (var i = 0; i < $('.search ul li').length; i++) {
			$('.search ul li').removeClass('active');
			aList.hide();
		}
		$(this).addClass('active');
		if ($(this).attr('class').indexOf('est') != -1) {
			userEstVerify.userEst();
		} else {
			userAccVerify.userAcc();
		}
		aList.eq($(this).index()).show();
	});

	// stat 1:发布 2:接受 3:取消 4:完成 5:评价 6:过期

	// 查看我发布的订单 -> 取消、确认收货
	$('.est_list').on('click', '.status-btn', function(event) {
		event.preventDefault();
		// deleteVerify.delete(this);
		if($('.status-btn .status').html() == '完成') {
			finishVerify.finish(this);
		}
	})

	// 查看我接受的订单 -> 取消
	$('.acc_list').on('click', '.status-btn', function(event) {
		event.preventDefault();
		deleteVerify.delete(this);
	})


});


// 功能：查看我发布的申请单
var userEstVerify = {
	userEst: function() {
		this.UserEstSuccess();
	},
	UserEstSuccess: function() {
		$.ajax({
			type: "GET",
			// http://www.wangchloe.cn:8080/esms/orderBase/findByCustomerId.do?customerId=1
			url: "http://www.wangchloe.cn:8080/esms/orderBase/findByCustomerId.do?",
			data: 'customerId=' + $('.userId').attr('id').substring(4),
			success: function(data) {
				console.log(data.msg);
				if (!parseInt(data.code)) {
					var orderBase = data.data;
					var list_box = $('.est_list');
					list_box.html('');
					if (orderBase.length) {
						for (var i = 0; i < orderBase.length; i++) {
							var oLi = $('<li></li>').attr('id', 'ob' + orderBase[i].id).appendTo(list_box);
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
					} else {
						$('<p></p>').html('您还未发布过订单').appendTo(list_box);
					}
				}
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

// 功能：查看我接受的申请单
var userAccVerify = {
	userAcc: function() {
		this.UserAccSuccess();
	},
	UserAccSuccess: function() {
		$.ajax({
			type: "GET",
			// http://www.wangchloe.cn:8080/esms/orderBase/findByAgentId.do?agentId=1
			url: "http://www.wangchloe.cn:8080/esms/orderBase/findByAgentId.do?",
			data: 'agentId=' + $('.userId').attr('id').substring(4),
			success: function(data) {
				console.log(data.msg);
				if (!parseInt(data.code)) {
					var orderBase = data.data;
					var list_box = $('.acc_list');
					list_box.html('');
					if (orderBase.length) {
						for (var i = 0; i < orderBase.length; i++) {
							var oLi = $('<li></li>').attr('id', 'ob' + orderBase[i].id).appendTo(list_box);
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
							statVerify.stat(orderBase[i].id, orderBase[i].customerId, 'acc');

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
					} else {
						$('<p></p>').html('您还未接受过订单').appendTo(list_box);
					}
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
	stat: function(id, cId, method) {
		if (this.check()) {
			this.StatSuccess(id, cId, method);
		}
	},
	check: function() {
		// TODO：正则检验
		return true;
	},
	StatSuccess: function(id, cId, method) {
		$.ajax({
			type: "GET",
			url: "http://www.wangchloe.cn:8080/esms/orderProcess/findByOrderId.do?",
			//http://www.wangchloe.cn:8080/esms/orderProcess/findByOrderId.do?orderId=1
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
					switch (stat) {
						case 1:
							btnIn = '接受';
							break;
						case 2:
							if(method) {
								btnIn = '取消';
							} else {
								btnIn = '完成';
							}
							break;
						case 3:
							btnIn = '已完成';
							break;
						case 4:
							btnIn = '已完成';
							break;
						case 5:
							btnIn = '已完成';
							break;
						case 6:
							btnIn = '已完成';
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

// 功能：取消订单
var deleteVerify = {
	delete: function(oBtn) {
		if (this.check(oBtn)) {
			this.DeleteSuccess(oBtn);
		}
	},
	check: function(oBtn) {
		//TODO：正则检验
		var com = confirm('确认取消订单？');
		return com;
	},
	DeleteSuccess: function(oBtn) {
		$.ajax({
			type: "GET",
			// http://www.wangchloe.cn:8080/esms/orderProcess/remove.do?orderId=1
			url: "http://www.wangchloe.cn:8080/esms/orderProcess/remove.do?",
			data: 'orderId=' + $(oBtn).attr('id').substring(3),
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

// 功能：完成订单
var finishVerify = {
	finish: function(oBtn) {
		if (this.check(oBtn)) {
			this.FinishSuccess(oBtn);
		}
	},
	check: function(oBtn) {
		//TODO：正则检验
		var com = confirm('确认完成订单？');
		return com;
	},
	FinishSuccess: function(oBtn) {
		$.ajax({
			type: "GET",
			// http://www.wangchloe.cn:8080/esms/orderProcess/finish.do?orderId=1
			url: "http://www.wangchloe.cn:8080/esms/orderProcess/finish.do?",
			data: 'orderId=' + $(oBtn).attr('id').substring(3),
			success: function(data) {
				console.log(data.msg);
				//$(oBtn).parents('li').remove();
				// statVerify.stat(orderBase[i].id, orderBase[i].customerId);
			},
			error: function() {
				console.log('错误');
			}
		});
	}
}

// 懒加载
window.onscroll = function() {
	var aImg = document.querySelectorAll('.properties_list img');
	var scrollT = document.documentElement.scrollTop || document.body.scrollTop;
	var clientH = document.documentElement.clientHeight;
	var time = 0;

	for (var i = 0; i < aImg.length; i++) {
		var oImgT = getPos(aImg[i]).top;
		if(scrollT + clientH >= oImgT) {
			(function(index) {
				setTimeout(function(){
					aImg[index].setAttribute('src', aImg[index].getAttribute('_src'));
				}, time);
			})(i);
			time += 50;
		}
	}

}

function getPos(obj) {
	var l = 0;
	var t = 0;
	while(obj) {
		l += obj.offsetLeft;
		t += obj.offsetTop;
		obj = obj.offsetParent;
	}
	return {left:l, top:t};
}