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

<!--jquery 라이브러리 들여오기  -->
<script src="/js/jquery-1.10.2.js"></script>
<!-- jquery ui 라이브러리 들여오기  -->
<script src="/js/jquery-ui-1.10.4.js"></script>
<!-- bootstrap js 라이브러리 들여오기 -->
<script src="/js/bootstrap.js"></script>

<decorator:head />
<!-- jquery ui css -->
<link href="/css/jquery-ui-1.10.4.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.css" rel="stylesheet">

<style>
.dropdown:hover .dropdown-menu {
	display: block;
}

a:visited {
	background-color: yellow;
	color: #609;
}

body {
	font-family: "맑은 고딕", "Helvetica Neue", Helvetica, Arial, sans-serif;
}

h1,h2,h3,h4,h5,h6,.h1,.h2,.h3,.h4,.h5,.h6 {
	font-weight: 700;
}

h4 {
	font-size: 15px;
}

.ui-datepicker-trigger {
	padding-bottom: 8px;
	padding-left: 7px;
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
<!-- navbar 생성 -->
	<nav class="navbar navbar-static-top navbar-default" role="navigation" style='border-bottom-style: solid; border-bottom-color: #666; padding-top: 10px; padding-bottom: 10px;'>
		<div class="container" style="padding-left: 0px; padding-right: 0px; text-align: center;">
			<h1 style='display: inline-block; margin-top: 0px;'>
				<img src="/image/TMON-BI.png" height="20" align="middle">
			</h1>
			<div class="navbar-header">
				<a style="display: inline; color: #666;" class="navbar-brand" href="/">&nbsp;&nbsp;Tmon News</a>
						<!-- Collect the nav links, forms, and other content for toggling -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
			</div>


	

			<ul class="nav navbar-nav navbar-right">
			
				<div id='dateAndCalendar' style='float: left; margin-top: 9px; margin-right: 15px;'>
					<text style='color:#666; vertical-align:0px;'>${newsList['0'].newsDate}</text>
					<input id="datepicker" type="hidden" />
				</div>
				
				<li class="dropdown" id='news' style='margin-right: 15px;'><a class="dropdown-toggle" data-toggle="dropdown"> News <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li class='socials'><a>소셜3사</a></li>
						<li class="divider"></li>
						<li class='tmon'><a>티몬</a></li>
						<li class='coupang'><a>쿠팡</a></li>
						<li class='wemap'><a>위메프</a></li>
						<li class="divider"></li>
						<li class='etc disabled'><a>ETC.</a></li>
					</ul></li>
					
				<li class="dropdown" id="appreview"><a class="dropdown-toggle" data-toggle="dropdown"> App <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/appreview/socials.tmon">소셜3사</a></li>
						<li class="divider"></li>
						<li><a href="/appreview/tmon.tmon">티몬</a></li>
						<li><a href="/appreview/coupang.tmon">쿠팡</a></li>
						<li><a href="/appreview/wemap.tmon">위메프</a></li>
						<li class="divider"></li>
						<li class='disabled'><a href="#">ETC.</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
	<!-- navbar 끝 -->
	
	<decorator:body />
	
	<!-- 클릭한 링크에 대한 주소를 동적으로 바인딩하는 자바스크립트 -->
	<script type="text/javascript">
		$("#news .socials").on("click", function() {
			location.assign("/news/socials.tmon?" + location.href.substr(location.href.search("date="), 15) + "&page=1");
		});
		$("#news .tmon").on("click", function() {
			location.assign("/news/tmon.tmon?" + location.href.substr(location.href.search("date="), 15) + "&page=1");
		});
		$("#news .coupang").on("click", function() {
			location.assign("/news/coupang.tmon?" + location.href.substr(location.href.search("date="), 15) + "&page=1");
		});
		$("#news .wemap").on("click", function() {
			location.assign("/news/wemap.tmon?" + location.href.substr(location.href.search("date="), 15) + "&page=1");
		});
	</script>

<!-- 현재 주소에 따라서 css 변화를 주는 자바스크립트 -->
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




