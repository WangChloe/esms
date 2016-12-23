/*
 * @Author: a
 * @Date:   2016-06-25 18:07:10
 * @Last Modified by:   a
 * @Last Modified time: 2016-11-20 18:40:53
 */

'use strict';
var showingArray = ["订单编号", "快递公司", "快递类型", "代领时间", "送货时间", "期望价格"];
var index = [0, 3, 4, 5, 6, 7];
var trc = ["success", "error", "warning", "info", "success", "error"];
var headArray = [];
var ad = document.getElementById("json");
window.onload = getJsonData;

function getJsonData() {

	$.ajax({
		url: "../orderBase/findByEstablish.do",
		type: "get",
		dataType: "json",
		data: {

		},
		success: function(data) {
			console.log("success...");

			//调用创建表和填充动态填充数据的方法.  
			// createShowingTable(data)
		},
		error: function() {
			console.log("error...");
		}
	});
}

//动态的创建一个table，同时将后台获取的数据动态的填充到相应的单元格  
function createShowingTable(data) {
	//获取后台传过来的jsonData,并进行解析  
	console.log("------->解析json数据");

	var orderBase = data.data;


	for (var n in orderBase[0]) {
		headArray[headArray.length] = n;
	}

	for (var i in orderBase) {
		var row = document.createElement("div");
		var span = document.createElement("div");
		var table = document.createElement("table");
		// row.setAttribute("className", "row-fluid");
		// span.setAttribute("className", "span4");
		// table.setAttribute("className", "table");
		row.className = "row-fluid";
		span.className = "span4";
		table.className = "table";

		row.appendChild(span);
		span.appendChild(table);

		for (var j in showingArray) {
			var tr = document.createElement("tr");
			var th = document.createElement("th");
			var td = document.createElement("td");
			// tr.setAttribute("className", trc[j]);
			tr.className = trc[j];
			th.innerHTML = showingArray[j];
			td.innerHTML = orderBase[i][headArray[index[j]]];
			tr.appendChild(th);
			tr.appendChild(td);
			table.appendChild(tr);
			ad.appendChild(table);
		}
	}
}