"use strict"

$("#bigName").change(function(){
	$("#smallName option:nth-child(n+1)").remove();
	let defaultSmall = document.createElement("option");
	defaultSmall.value = "0";
	defaultSmall.text = "-- grandChild --";
	document.getElementById("smallName").append(defaultSmall);
	
	$("#middleName option:nth-child(n+1)").remove();
	let defaultMiddle = document.createElement("option");
	defaultMiddle.value="0";
	defaultMiddle.text="-- childCategory --"
	document.getElementById("middleName").append(defaultMiddle);
	
	//入力値をセット
	let largeCategoryId =  $("#bigName").val();
	//big情報送信url
	let send_url = "/mercari/selectCategory/getChildList";
	
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
				document.getElementById("middleName").append(op);
			}
		},
	});
})