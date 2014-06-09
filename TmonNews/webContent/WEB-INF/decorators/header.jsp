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

<script src="/js/jquery-1.10.2.js"></script>
<script src="/js/jquery-ui-1.10.4.js"></script>
<script src="/js/bootstrap.js"></script>

<decorator:head />

<link href="/css/jquery-ui-1.10.4.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.css" rel="stylesheet">
<style>
.dropdown:hover .dropdown-menu {
	display: block;
}

body {
	font-family: "맑은 고딕", "Helvetica Neue", Helvetica, Arial, sans-serif;
}

h1,h2,h3,h4,h5,h6,.h1,.h2,.h3,.h4,.h5,.h6 {
	font-weight: 700;
}

.ui-datepicker-trigger {
	padding-bottom: 8px;
	padding-left: 7px;
}

.dropdown:hover .dropdown-menu {
	display: block;
}

.navbar-brand {
	float: left;
	height: 50px;
	padding: 12px 15px;
	font-size: 32px;
	line-height: 20px;
	font-weight: 900;
}
</style>
</head>

<body>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid" style="padding-left: 0px;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a style="display: inline; float: left;" href="/"><img src="/image/tmon_logo.png" height="50" style="margin-left: 50px;"></a> <a style="display: inline" class="navbar-brand" href="#">&nbsp;&nbsp;Tmon News</a>
			</div>


			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown" id='news'><a class="dropdown-toggle" data-toggle="dropdown"> News <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class='socials'><a>소셜3사</a></li>
							<li class="divider"></li>
							<li class='tmon'><a>티몬</a></li>
							<li class='coupang'><a>쿠팡</a></li>
							<li class='wemap'><a>위메프</a></li>
							<li class="divider"></li>
							<li class='etc'><a>ETC.</a></li>
						</ul></li>
					<li class="dropdown" id="dev"><a href="/D:/dev/CalendarTest/WebContent/NewFile.html" class="dropdown-toggle" data-toggle="dropdown"> App <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">소셜3사</a></li>
							<li class="divider"></li>
							<li><a href="#">티몬</a></li>
							<li><a href="#">쿠팡</a></li>
							<li><a href="#">위메프</a></li>
							<li class="divider"></li>
							<li><a href="#">ETC.</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> SNS <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">소셜3사</a></li>
							<li class="divider"></li>
							<li><a href="#">티몬</a></li>
							<li><a href="#">쿠팡</a></li>
							<li><a href="#">위메프</a></li>
							<li class="divider"></li>
							<li><a href="#">ETC.</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
		<decorator:body />
		<script>
			
			$("#news .socials").on(
					"click",
					function() {
						location.assign("/news/socials.tmon?"
								+ location.href.substr(location.href
										.search("date="), 15) + "&page=1");
					});
			$("#news .tmon").on(
					"click",
					function() {
						location.assign("/news/tmon.tmon?"
								+ location.href.substr(location.href
										.search("date="), 15) + "&page=1");
					});
			$("#news .coupang").on(
					"click",
					function() {
						location.assign("/news/coupang.tmon?"
								+ location.href.substr(location.href
										.search("date="), 15) + "&page=1");
					});
			$("#news .wemap").on(
					"click",
					function() {
						location.assign("/news/wemap.tmon?"
								+ location.href.substr(location.href
										.search("date="), 15) + "&page=1");
					});
			$("#news .etc").on(
					"click",
					function() {
						location.assign("/news/etc.tmon?"
								+ location.href.substr(location.href
										.search("date="), 15) + "&page=1");
					});
		</script>
		<script>
			function searchInCurrentLocation(string) {
				if (location.href.search(string) > 0) {
					$('.navbar li.active').removeClass('active');
					if (!$("#" + string).hasClass('active')) {
						$("#" + string).addClass('active');
					}
				}
			}
			$(document).ready(searchInCurrentLocation('news'));
			$(document).ready(searchInCurrentLocation('appreview'));
		</script>
		
</body>
</html>




