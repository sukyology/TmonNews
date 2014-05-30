<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Tmon News에 오신 것을 환영합니다.<decorator:title /></title>

<decorator:head />
<link href="/css/jquery-ui-1.10.4.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">

<style type="text/css"></style>
<style id="holderjs-style" type="text/css"></style>
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a style="display: inline; float: left;" href="#"><img
					src="/image/tmon_logo.png" height="50" /></a> <a
					style="display: inline" class="navbar-brand" href="#">&nbsp;&nbsp;Tmon
					News</a>

			</div>

		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a class="socials" href="">소셜3사</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a class="tmon">티몬</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a class="coupang">쿠팡</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a class="wemap">위메프</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">기타둥둥</a></li>
				</ul>
			</div>
<decorator:body />
<script src="/js/jquery-1.10.2.js"></script>
<script src="/js/jquery-ui-1.10.4.js"></script>
<script src="/js/bootstrap.js"></script>

<script>
$.datepicker.setDefaults({
    showOn:"button",
    buttonImageOnly: true,
    buttonImage:"/image/calendarglyphicon.png",
});
$( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" });
$("input").on("change", function(){
   location.assign(location.pathname+"?date="+$("#datepicker").val()+"&page=1"); 
});
$(".socials").on("click", function(){
	location.assign("/category/socials.tmon?"+location.href.substr(location.href.search("date="),15)+"&page=1");
});
$(".tmon").on("click", function(){
	location.assign("/category/tmon.tmon?"+location.href.substr(location.href.search("date="),15)+"&page=1");
});
$(".coupang").on("click", function(){
	location.assign("/category/coupang.tmon?"+location.href.substr(location.href.search("date="),15)+"&page=1");
});
$(".wemap").on("click", function(){
	location.assign("/category/wemap.tmon?"+location.href.substr(location.href.search("date="),15)+"&page=1");
}); 
</script>
</body>
</html>




