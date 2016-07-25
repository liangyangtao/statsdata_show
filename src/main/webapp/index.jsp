<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>国统局信息显示</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script
	src="js/jqtree/static/bower_components/jquery/dist/jquery.min.js"></script>
<script src="js/jqtree/tree.jquery.js"></script>
<link rel="stylesheet" href="js/jqtree/jqtree.css">
<script
	src="js/jqtree/static/bower_components/jquery-cookie/jquery.cookie.js"></script>
<link rel="stylesheet" href="css/app.css">

</head>

<body>
	<div class="header">
		<h1>国家数据</h1>
	</div>
	<div id="nav">
		<ul>
			<li><a id="fsyd" href="javascript:void(0);" class ="current">分省月度</a>
			</li>
			<li><a id="fsjd" href="javascript:void(0);">分省季度</a>
			</li>
			<li><a id="fsnd" href="javascript:void(0);">分省年度</a>
			</li>
			<li><a id="qgyd" href="javascript:void(0);">全国月度</a>
			</li>
			<li><a id="qgjd" href="javascript:void(0);">全国季度</a>
			</li>
			<li><a id="qgnd" href="javascript:void(0);">全国年度</a>
			</li>
			<li><a id="hgyd" href="javascript:void(0);">月度数据</a>
			</li>
			<li><a id="hgjd" href="javascript:void(0);">季度数据</a>
			</li>
			<li><a id="hgnd" href="javascript:void(0);">年度数据</a>
			</li>
		</ul>
	</div>
	<jsp:include page="main.jsp" />

</body>
<script type="text/javascript" src="js/index.js"></script>
</html>
