<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import = "java.util.List" %>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "models.ProductBean" %>
    <%@ page import = "controllers.SearchServlet" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索ページ</title>
</head>
<body>

<h1>検索</h1><br>

<form action="search" method = "post">

<%
List<String> list = (List<String>) request.getAttribute("cat_names");
List<ProductBean> products = (List<ProductBean>) request.getAttribute("products");
%>

<input type = "text" name = "key">

<select name = "category">
<%for(String cat_name: list){ %>
<option value = "<%= cat_name%>"> <%=cat_name%> </option>
<%} %>
</select><br>

<input type = "submit" value = "検索">
<%if(products != null){ %>

<table><tr>
<th>商品名</th><th>価格</th><th>詳細</th>
</tr>
<% for(ProductBean product: products){ %>
<tr>
<td> <%= product.getProName() %> </td>
<td> <%= product.getProPrice() %> </td>
<td> <a href = "http://localhost:8080/EC_Ringo/product?proId=<%=product.getProCd()%>" ><button>詳細</button></a></td>
</tr>
<%}%>
</table>

<%}else{ %>
<p>検索結果がありません。</p>
<%} %>

</form>


</body>
</html>