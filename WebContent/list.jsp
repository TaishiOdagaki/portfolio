<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧画面</title>
<!-- <link href="list.css" rel="stylesheet" type="text/css">
 -->
</head>
<body>
    <div class="bg">

<jsp:include page="/menu.jsp" />


<form action="/Book/ItemServlet2" method="post">
難易度の検索：<input type="text" name="level" size="5">ポイント以下の商品を
<input type="submit" value="検索">
<input type="hidden" name="action" value="search2">
</form>


<form action="/Book/ItemServlet2" method="post">
人気の検索：<input type="text" name="popularity" size="5">ポイント以上の商品を
<input type="submit" value="検索">
<input type="hidden" name="action" value="search">
</form>


<a href="/Book/ItemServlet3?action=sort&level=level_asc">並べ替え（初心者向け順）</a>
<a href="/Book/ItemServlet3?action=sort&level=level_desc">並べ替え（上級者向け順）</a><br>


<div class=special>

<h1>本日のレコメンド・ブック</h1>


<form action="/Book/DetailServlet" method="post">
<div class="inline-block_test1">

		<input type="hidden" name="item_code" value="${luckyitem.code}">
		<h1>${luckyitem.name}</h1><br>
		価格（税込）<b>${luckyitem.price}円</b><br>
		
		<img style="width: 200px; height: 300px" src="${luckyitem.image}">

		<input type="submit" value="詳細を見る">
</form>
</div>

</div>

<h1>商品一覧</h1>
<div class="inline-block_test1">

<c:forEach items="${items}" var="item">
	<form action="/Book/DetailServlet" method="post">
		<input type="hidden" name="item_code" value="${item.code}">



        <h1>
		商品番号<b>${item.code}</b><br>
		<b>${item.name}</b><br>
		</h1>
		<h2>
		価格（税込）<b>${item.price}円</b><br>
		</h2>


		<img style="width: 200px; height: 300px" src="${item.image}" class="block1">
		<input type="submit" value="詳細を見る">
<br><br><br><br>	</form>

</c:forEach>

<form action="/Book/ShowItemServlet" method="post">
		<input type="hidden" name="paging" value="${item.code}">

<a href="/Book/ShowItemServlet?paging=1">1</a>
<a href="/Book/ShowItemServlet?paging=2">2</a>
<a href="/Book/ShowItemServlet?paging=3">3</a>
<a href="/Book/ShowItemServlet?paging=4">4</a>
<a href="/Book/ShowItemServlet?paging=5">5</a>


</form>

</div>
</div>

</body>
</html>