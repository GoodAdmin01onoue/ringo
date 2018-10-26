<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索ページ</title>
</head>
<body>

<h1>検索</h1><br>

<form action="http://localhost:8080/controllers/search" method = "post">

<input type = "search" name = "key">
<p>カテゴリ<select name = "category">
<option value = "家電">家電</option>
<option value = "キッチン用品">キッチン用品</option>
</select></p>

<input type = "submit" value = "検索">
</form>

<%-- <%if(request.getAttribute("pro_cd") != null)){ %> --%>
<form action="http://localhost:8080/controllers/search" method = "post">
<table><tr>
<th>商品名</th><th>価格</th><th>詳細</th>
<td><%= request.getAttribute("pro_name") %></td>
<td><%= request.getAttribute("cat_name") %></td>
<td><input type = "button" name = "<%= request.getAttribute("pro_cd") %>" value = "詳細へ"></td>
</tr></table>
</form>
<%--<%} --%>

</body>
</html>