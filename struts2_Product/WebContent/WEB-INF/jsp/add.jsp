<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addProductSubmit.action" method="post">
	<table>
		<tr>
			<td>商品名称</td>
			<td><input type="text" name="pd.Item_name"></td>
		</tr>
		<tr>
			<td>商品名称</td>
			<td><input type="text" name="pd.Item_price"></td>
		</tr>
		<tr>
			<td>创建时间</td>
			<td><input type="text" name="pd.create_time"></td>
		</tr>
		<tr>
			<td>商品名称</td>
			<td>
				<input type="radio" name="pd.status" value="0" checked>上架
				<input type="radio" name="pd.status" value="1" >下架
			</td>
		</tr>
		<tr>
			<td colspan="2">
			
			<input type="submit" value="提交">
			
			<a href='getAll'><input type="button" value="返回" /></a>
			</td>
			
		</tr>
		
	</table>
	
</form>

	<s:if test="msg != null">
		<script type="text/javascript">
			alert('${msg}');
		</script>
	</s:if>
</body>
</html>