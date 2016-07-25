var idTmr;
function tableToExcel(tableid) {// 整个表格拷贝到EXCEL中
	var curTbl = $('#tableInfo').html();
	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("target", "");
	form.attr("method", "post");
	form.attr("action", "downExcel.do");
	var input1 = $("<input>");
	input1.attr("type", "hidden");
	input1.attr("name", "table");
	input1.attr("value", curTbl);
	$("body").append(form);// 将表单放置在web中
	form.append(input1);
	form.submit();// 表单提交
	
}