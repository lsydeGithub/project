<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
</head>
<body>
<table border="1px">
	<tr>
		<td colspan="5">
			<a href="toAdd.action">添加商品</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<select id="getProductType" name="status">
					<option value="-1">请选择</option>
					<option value="0">已上架</option>
					<option value="1">已下架</option>
				</select>
		</td>
	</tr>
	<tr>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>录入时间</td>
		<td>状态</td>
		<td>操作</td>
	</tr>
	<s:iterator value="products" var="p">
	<tr>
		<td><s:property value="#p.Item_name"/></td>
		<td><s:property value="#p.Item_price"/></td>
		<td><s:property value="#p.create_time"/></td>
		<td> <s:property value="%{status == 0 ? '已上架' : '已下架'}"/></td>
		<td>
			<s:if test="status == 0">
				<a href="updateStatus?pd.Item_id=<s:property value='#p.Item_id' />&pd.status=1">下架</a>
			</s:if>
			<s:else>
				<a href="updateStatus?pd.Item_id=<s:property value="#p.Item_id" />&pd.status=0">上架</a>
			</s:else>
		</td>
	</tr>
	</s:iterator>
</table>
<script type="text/javascript">
	var updateStatus = document.getElementById("getProductType");
	updateStatus.onchange = function (){
	location.href = "getAll?status=" + this.value;
	}
	window.onload=load("${status}");
	function load(status){
		for(var i in updateStatus){
			if(updateStatus[i].value==status)
				updateStatus[i].selected=true;
		}
	}
</script>
</body>
</html>