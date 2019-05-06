<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細画面</title>
<!-- <link href="detail.css" rel="stylesheet" type="text/css">
 -->
</head>
<body>
<div class="inline-block_test1">

<h1>商品詳細</h1>
<form action="/Book/CartServlet?action=add" method="post">
<input type="hidden" name="item_code" value="${item.code}">

                  商品番号：<b>${item.code}</b><br>
                  <h2>${item.name}</h2><br>
                  <img style="width: 300px; height: 350px" src="${item.image}">
                  
                  
                  	<h2　style="display:inline;">難易度</h2>
<c:forEach begin="1" end="${item.level}" step="1">
		<img src="tougarashi.png" >
</c:forEach>

		<h2　style="display:inline;">人気</h2>
<c:forEach begin="1" end="${item.popularity}" step="1">
		<img src="star.png" >
</c:forEach><br>
                  価格(税込)：<b>${item.price}</b>円<br>
                  商品説明：<b>${item.information}</b><br>

                  個数：
                  <select name="quantity">
                  <option value="1">1
                  <option value="2">2
                  <option value="3">3
                  <option value="4">4
                  <option value="5">5
                  </select>
                  個<br>
                  <input type="submit" value="カートに追加"><br>
                  <p><a href="cart.jsp">カートを見る</a>

<form action="/Book/ShowItemServlet" method="post">
<input type="hidden" name="paging" value="${item.code}">
<a href="/Book/ShowItemServlet?paging=1">一覧へ</a>
</form>
                  </form>
                  </div>
</body>
</html>