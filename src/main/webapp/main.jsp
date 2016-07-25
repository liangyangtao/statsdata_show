<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style>
#nav ul li  a:hover,.m_wrap_tab a.current {
	color: #33FFDD;
}
</style>
<div class="main">
	<div class="m-wrap mt10">
		<div class="main-container" style="position: relative;">
			<div style="height: 987px;" class="main-left left split-containe">
				<div class="ztree-container" id="tree1"></div>
			</div>
			<div class="main-right right split-containe">
				<div class="mr-header">
					<div class="ul-view left createtype"
						style="margin: 7px 10px 0 20px; float: left">详细信息</div>
					<div class="ul-view left createtype"
						style="margin: 7px 10px 0 0; float: right">
						<input id="Button1" type="button" value="导出EXCEL"
							onclick="javascript:tableToExcel()" hidden/>
					</div>
					<div class="right" style="margin: 7px 10px 0 0; ">
						<select id="dropArea">
						</select>

					</div>
				</div>
				<div class="mr-content">
					<div class="table_container_head" id="tableInfo"
						style="width:1024px; height:500px; overflow:scroll;"></div>
				</div>

			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="js/tableToExcel.js"></script>