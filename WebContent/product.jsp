<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ProductBean pb=(ProductBean)req.getAttribute("productbean");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>商品紹介</h1>

<table>
<tr>
<td>商品名</td>
<td><%= pb.getproName() %></td>
</tr>
<tr>
<td>カテゴリ</td>
<td><%= pb.getcatName() %></td>
</tr>
<tr>
<td>価格</td>
<td><%= pb.proPrice() %></td>
</tr>
<tr>
<td>在庫</td>
<td><%= pb.stockNo() %></td>
</tr>
<tr>
<td>商品紹介</td>
<td><%= pb.proMsg() %></td>
</tr>
</table>

<p>個数</p>
<select name="kosuu" >
<option value="stock">

<% for(int i=1;i<pb.stockNo();i++){ %>
<%= i %>
<% } %>

</option>
</select>

<input type="button"  onclick="location.href'/cart'" value="カートへ">

<input type="button"  onclick="location.href'/serch'" value="戻る">

</body>
</html>