var nowDbcode = "fsyd";
var nowNodeid;
var nowAddress = "110000";

function loadview() {
	$.ajax({
		type : "post",
		url : "readtree.do?dbcode=" + nowDbcode,
		ifModified : true,
		dataType : "json",
		cache : false,
		async : true,
		error : function(source) {

		},
		success : function(source) {
			$('#tree1').tree({
				data : source,
			});
			$('#tree1').tree('loadData', source);
		}
	});
}
function getdetail() {

	$.ajax({
		type : "post",
		url : "readInformations.do?address=" + nowAddress + "&pid=" + nowNodeid
				+ "&dbcode=" + nowDbcode,
		ifModified : true,
		dataType : "json",
		cache : false,
		error : function(source) {

		},
		success : function(source) {
			$("#tableInfo").html(source);
			$("#Button1").show();
		}
	});
}

$(function() {
	loadview();
	$('#tree1').bind(
			'tree.select',
			function(event) {
				if (event.node) {
					var node = event.node;
					var nodeId = node.id;
					var isParent = node.isParent;
					nowNodeid = nodeId;
					if (isParent == 1) {
						$.ajax({
							type : "post",
							url : "readtree.do?dbcode=" + nowDbcode + "&pid="
									+ nowNodeid,
							ifModified : true,
							dataType : "json",
							cache : false,
							error : function(source) {

							},
							success : function(source) {
								if (source.length == 0) {

								} else {
									$('#tree1').tree('loadData', source, node);
									$('#tree1').tree('openNode', node);
									$("#Button1").hide();
								}
							}
						});

					} else {
						getdetail();
					}
					// 是点击下一级别

				} else {
					// event.node is null
					// a node was deselected
					// e.previous_node contains the deselected node

				}
			});

	/* 地区 */
	$.ajax({
		type : "post",
		url : "readArea.do",
		ifModified : true,
		dataType : "json",
		cache : false,
		error : function(source) {
		},
		success : function(source) {
			var list = source;
			var optionstring = "";
			for ( var i = 0; i < list.length; i++) {
				var name = list[i].areaname;
				var areacode = list[i].areacode;
				optionstring += "<option value=\"" + areacode + "\" >" + name
						+ "</option>";
			}
			$("#dropArea").html(optionstring);
		}
	});
	$('#dropArea').change(function() {
		var p1 = $(this).children('option:selected').val();
		nowAddress = p1;
		getdetail();

	});
	$("#nav > ul > li > a").click(function() {
		nowDbcode = $(this).attr("id");
		if (nowDbcode.indexOf("fs") >-1) {
			$("#dropArea").show();
		} else {
			$("#dropArea").hide();
		}
		$(".current").removeClass("current");
		$(this).addClass("current");
		loadview();
	});

});
