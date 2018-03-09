<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出用户数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sys/user/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			$("#btnImport").click(function(){
				$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true}, 
					bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});
			});

			$("#dataGrid").jqGrid({
				url:"${ctx}/sys/user/list.do",
				datatype: "json", //数据来源，本地数据（local，json,jsonp,xml等）
				height: "300",//高度，表格高度。可为数值、百分比或'auto'
				mtype:"GET",//提交方式
				colModel: [
					{label:'登录名',name:'loginName',index: 'loginName',fixed:true, key: true, width: 100},
					{label:'组织机构',name: 'loginName',index: 'displayName', width: 100},
					{label:"登录名",name: 'loginName',index: 'loginName',width: 200},
					{label:"姓名",name: 'name',index: 'name',width: 200},
					{label:'电话',name: 'phone',index: 'phone', width: 60},
					{header:'手机',name: 'mobile',index: 'mobile', width: 60},
					{header:'手机',name: 'mobile',index: 'mobile',  fixed:true, sortable:false, fixed:true, formatter: function(val, obj, row, act){
						var actions = [];

						actions.push('<a href="${ctx}/sys/user/form?id='+row.id+'" class="btnList" title="编辑用户">编辑</a>&nbsp;');

						return actions.join('');
			       }}
				],
				viewrecords: false,//是否在浏览导航栏显示记录总数
				recordpos: 'right',
				rowNum: 10,//每页显示记录数
				rowList: [10, 20, 30],//用于改变显示行数的下拉列表框的元素数组。
				pager:"#dataGridPager",//分页、按钮所在的浏览导航栏
				pagerpos: 'left',//分页按钮位置
				//altRows: true,//设置为交替行表格,默认为false
				//toppager: true,//是否在上面显示浏览导航栏
				//multiselect: true,//是否多选
				//multikey: "ctrlKey",//是否只能用Ctrl按键多选
				//multiboxonly: true,//是否只能点击复选框多选
				// subGrid : true,
				//sortname:'id',//默认的排序列名
				//sortorder:'asc',//默认的排序方式（asc升序，desc降序）
				//caption: "采购退货单列表",//表名
				autowidth: false,//自动宽,
				prmNames: {
					rows: 'rows',
					page: 'page'
				},
				jsonReader: {
					root:"list", page:"pageNum", total:"pages",          //   很重要 定义了 后台分页参数的名字。
					records:"total", repeatitems:false, id : "id"
				},
			});
		});
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/sys/user/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/sys/user/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/sys/user/import/template">下载模板</a>
		</form>
	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/user/list">用户列表</a></li>
	    <li><a href="${ctx}/sys/user/form">用户添加</a></li>
	</ul>
	<form id="searchForm" modelAttribute="user" action="${ctx}/sys/user/list" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="1"/>
		<input id="pageSize" name="pageSize" type="hidden" value="10"/>
		<ul class="ul-form">
			<li><label>归属公司：</label></li>
			<li><label>登录名：</label></li>
			<li class="clearfix"></li>
			<li><label>归属部门：</label></li>
			<li><label>姓&nbsp;&nbsp;&nbsp;名：</label></li>
			<li class="clearfix"></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
				<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
				<input id="btnImport" class="btn btn-primary" type="button" value="导入"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<sys:message content="${message}"/>
	<table id="dataGrid" class="table table-striped table-bordered table-condensed">

	</table>
	<div id="dataGridPager" class="pagination"></div>
</body>
</html>