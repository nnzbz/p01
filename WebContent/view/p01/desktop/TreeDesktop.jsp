<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>企业人事业务管理系统</title>
<style type="text/css">
div {
	border: 0;
	padding: 0;
}

#divLeft {
	height: 100%;
	background: #FFF;
}
</style>
<jsp:include page="${ctx}/view/fw/comm/IncludeCommCss.jsp"></jsp:include>
</head>
<body>
	<div id="divCenter" class="ui-layout-center">
		Center
		<p>
			<a href="http://layout.jquery-dev.net/demos.html">Go to the Demos page</a>
		</p>
		<p>* Pane-resizing is disabled because ui.draggable.js is not linked</p>
		<p>* Pane-animation is disabled because ui.effects.js is not linked</p>
	</div>
	<div class="ui-layout-north" style="background-color: #ddd;">
		<table width='100%' height='100%'>
			<tr>
				<td style="vertical-align: middle;" width='60px'><img src="${ctx}/img/p01/flag.png" style="width: 55px; height: 40px;" /></td>
				<td style="vertical-align: middle;">
					<h1>
						企业人事业务管理系统
						<p style="font-family: arial;">&nbsp;&nbsp;&nbsp;&nbsp;Personnel Management System</p>
					</h1>
				</td>
				<td style="vertical-align: middle;" width='50px'>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td style="vertical-align: middle;" width='45px'><img id="imgQuit" src="${ctx}/img/p01/quit.png" style="width: 40px; height: 40px; cursor: pointer;" onMouseOver="imgQuit_onMouseOver()" onMouseOut="imgQuit_onMouseOut()" title="退出" onclick="quit()" /></td>
			</tr>
		</table>
	</div>
	<div class="ui-layout-west">
		<div id="divLeft">
			<div id="divMenu" class="ztree"></div>
		</div>
	</div>
	<jsp:include page="${ctx}/view/fw/comm/IncludeCommJs.jsp"></jsp:include>
</body>
</html>
<script type="text/javascript">
	$(function() {
		$('body').layout({
			north__closable : false,//不可以被关闭  
			north__resizable : false,//不可以改变大小
			north__spacing_open : 0,
			north__size : 52,//pane的大小
			//stateManagement__enabled : true,// automatic cookie load & save enabled by default
			showDebugMessages : true
		// log and/or display messages from debugging & testing code
		});

		$.ajax({
			url : "${ctx}/authc/menus",
			async : true,
			error : function(request) {
				alert("服务器无响应，请检查是否网络问题");
			},
			success : function(data) {
				var nodes = new Array();
				for ( var i in data) {
					var node = new Object;
					node.id = data[i].id;
					var index = node.id.lastIndexOf("-");
					if (index === -1)
						node.pId = null;
					else {
						node.pId = data[i].id.substring(0, index);
						if ((i > 0) && (nodes[i - 1].id === node.pId))
							nodes[i - 1].nocheck = true;
					}
					node.name = data[i].name;
					if (data[i].fwAuthcPerm)
						node.file = data[i].fwAuthcPerm.uri;
					if (i === '0')
						node.open = true;
					nodes.push(node);
				}
				var zTree;

				var setting = {
					view : {
						dblClickExpand : false,
						showLine : false,
						showIcon : false,
						selectedMulti : false
					},
					check : {
						enable : true,
						chkStyle : "radio",
						radioType : "all"
					},
					data : {
						simpleData : {
							enable : true,
							idKey : "id",
							pIdKey : "pId",
							rootPId : ""
						}
					},
					callback : {
						beforeClick : function(treeId, treeNode) {
							var zTree = $.fn.zTree.getZTreeObj("divMenu");
							if (treeNode.isParent) {
								zTree.expandNode(treeNode);
								return false;
							} else {
								zTree.checkNode(treeNode, true);
								if (treeNode.file) {
									$.ajax({
										url : "${ctx}" + treeNode.file,
										async : true,
										error : function(request) {
											alert("服务器无响应，请检查是否网络问题");
										},
										success : function(data) {
											$("#divCenter").html(data);
										}
									});
								}
								return true;
							}
						}
					}
				};
				var t = $("#divMenu");
				t = $.fn.zTree.init(t, setting, nodes);

			}
		});

	});

	function imgQuit_onMouseOver() {
		$("#imgQuit")[0].src = '${ctx}/img/p01/quit2.png';
	}

	function imgQuit_onMouseOut() {
		$("#imgQuit")[0].src = '${ctx}/img/p01/quit.png';
	}

	function quit() {
		location.href = "${ctx}/authc/logout";
	}
</script>
