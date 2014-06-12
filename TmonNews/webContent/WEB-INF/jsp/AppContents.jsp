<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>- 메인 페이지</title>
<link href="/css/chart.css" rel="stylesheet">
<script type="text/javascript" src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/themes/light.js"></script>
<script type="text/javascript" src="/js/GraphFactory.js"></script>
</head>
<a id="top"></a>
<body>
	<div class="col-lg-1"></div>
	<div class="col-lg-10">
		<div class="row center-block">
				<p style='text-align:center;'>
					<b>소셜3사의 최근1년간 App평점</b>
				</p>
			<div id="appLinechart"></div>
		</div>
		<div class='well'></div>
		<div class="row">
			<div class="col-lg-4 col-lg-offset-1">
				<div id="appStackchartAverage"></div>
			</div>
			<div class="col-lg-4 col-lg-offset-2">
				<div id="appStackchartCount"></div>
			</div>
		</div>
	</div>
	<div class="col-lg-1"></div>



	<!-- 월별 App리뷰 평점그래프 -->
	<script type="text/javascript">
var chartData = new Array();
<c:forEach var="appCount" items="${ratingFlow}">
	
	chartData.push({
		date :'${appCount.reviewedMonth}',
	   	tmon: ${appCount.tmonRating},
	   	coupang : ${appCount.coupangRating},
	   	wemap : ${appCount.wemapRating} 
	});           
</c:forEach>  

	var chart = new GraphFactory(chartData , "light", "appLinechart").createLineTypeGraph();
	chart.addListener("rendered", zoomChart);


	function zoomChart() {
		chart.zoomToIndexes(chartData.length - 40, chartData.length - 1);
	}
</script>


	<!-- 3사 마켓평균점수 -->
	<script type="text/javascript">
var chartData =[{
	corp :"Tmon",
	appAverage: ${averageRatingOfApp.tmonRating},
	color:"#FFBB00"
	
},{
	corp :"Coupang",
	appAverage: ${averageRatingOfApp.coupangRating},
	color:"#6799FF"
},{
	corp :"Wemap",
	appAverage: ${averageRatingOfApp.wemapRating},
	color:"#FF0000"
}]

var chart = new GraphFactory(chartData , "light", "appStackchartAverage").createStackTypeGraphForAverage();
</script>


	<!-- 최근한달 3사의 리뷰 개수 -->
	<script type="text/javascript">
var chartData =[{
	corp :"Tmon",
	appAverage: ${numberOfNews.numberOfTmonAppReview},
	color:"#FFBB00"
	
},{
	corp :"Coupang",
	appAverage: ${numberOfNews.numberOfCoupangAppReview},
	color:"#6799FF"
},{
	corp :"Wemap",
	appAverage: ${numberOfNews.numberOfWemapAppReview},
	color:"#FF0000"
}]

var chart = new GraphFactory(chartData , "light", "appStackchartCount").createStackTypeGraph();
</script>

</body>