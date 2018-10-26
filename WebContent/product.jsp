<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="result" scope="request" class=""></jsp:useBean>
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
<td><jsp:getProperty name="" property=""></td>
</tr>
<tr>
<td>カテゴリ</td>
<td><jsp:getProperty name="" property=""></td>
</tr>
<tr>
<td>価格</td>
<td><jsp:getProperty name="" property=""></td>
</tr>
<tr>
<td>在庫</td>
<td><jsp:getProperty name="" property=""></td>
</tr>
<tr>
<td>商品紹介</td>
<td><jsp:getProperty name="" property=""></td>
</tr>
</table>

<p>個数</p>
<select name="kosuu"></select>

<input type="button" value="カートへ">
<input type="button" value="戻る">

</body>
</html>