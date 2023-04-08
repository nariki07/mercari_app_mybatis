"use strict"

$("#bigName").change(function(){
	$("#smallId option:nth-child(n+1)").remove();
	let defaultSmall = document.createElement("option");
	defaultSmall.value = "0";
	defaultSmall.text = "-- grandChild --";
	document.getElementById("smallId").append(defaultSmall);
	
	$("#mediumName option:nth-child(n+1)").remove();
	let defaultMiddle = document.createElement("option");
	defaultMiddle.value="0";
	defaultMiddle.text="-- childCategory --"
	document.getElementById("mediumName").append(defaultMiddle);
	
	//入力値をセット
	let largeCategoryId =  $("#bigName").val();
	
	//big情報送信url
	let send_url = "/mercari/selectCategory/getMiddleList";
	
	$.ajax({
		url: send_url,
		type: "POST",
		contentType: "application/json",
		cache: false,
		data: largeCategoryId, 
		dataType: "json",
		success: function(mediumCategoryList) {//mediumCategoryListにControllerの戻り値が入る
			console.log(mediumCategoryList);
			for (let i = 0; i < mediumCategoryList.length; i++) {
				let op = document.createElement("option");
				op.value = mediumCategoryList[i].id;
				op.text = mediumCategoryList[i].name;
				document.getElementById("mediumName").append(op);
			}
		},
	});
})

$("#mediumName").change(function(){
	$("#smallId option:nth-child(n+1)").remove();
	let defaultSmall = document.createElement("option");
	defaultSmall.value = "0";
	defaultSmall.text = "-- grandChild --";
	document.getElementById("smallId").append(defaultSmall);
	
	//入力値をセット
	let middleCategoryId =  $("#mediumName").val();
	
	//big情報送信url
	let send_url = "/mercari/selectCategory/getSmallList";
	
	$.ajax({
		url: send_url,
		type: "POST",
		contentType: "application/json",
		cache: false,
		data: middleCategoryId, 
		dataType: "json",
		success: function(smallCategoryList) {//mediumCategoryListにControllerの戻り値が入る
			console.log(smallCategoryList);
			for (let i = 0; i < smallCategoryList.length; i++) {
				let op = document.createElement("option");
				op.value = smallCategoryList[i].id;
				op.text = smallCategoryList[i].name;
				document.getElementById("smallId").append(op);
			}
		},
	});
})