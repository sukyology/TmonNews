<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>- 앱리뷰 페이지</title>
<link href="/css/chart.css" rel="stylesheet">
<script type="text/javascript" src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/themes/light.js"></script>
<script type="text/javascript" src="/js/GraphFactory.js"></script>
</head>
<body>
	<div class="col-lg-1"></div>
	<div class="col-lg-10">
		<div class="row center-block">
			<p style='text-align: center;'>
				<b>소셜3사의 최근 24시간 App순위 </b>
			</p>
			<div id="appDailyLinechart"></div>
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
		<br><br><br>
		<div class="row center-block">
			<p style='text-align: center;'>
				<b>소셜3사의 최근1년간 App평점</b>
			</p>
			<div id="appLinechart"></div>
			<br><br><br>
		</div>
	</div>
	
	<div class="col-lg-1"></div>



	<!-- 월별 App리뷰 평점그래프 -->
	<script type="text/javascript">
var monthAppReviewChartData = new Array();
<c:forEach var="appCount" items="${ratingFlow}">
	
	monthAppReviewChartData.push({
		date :'${appCount.reviewedMonth}',
	   	tmon: ${appCount.tmonRating},
	   	coupang : ${appCount.coupangRating},
	   	wemap : ${appCount.wemapRating} 
	});           
</c:forEach>  

	var monthAppChart = new GraphFactory(monthAppReviewChartData , "light", "appLinechart").createLineTypeGraph();
		monthAppChart.addListener("rendered", zoomChart);


	function zoomChart() {
		monthAppChart.zoomToIndexes(monthAppReviewChartData.length - 40, monthAppReviewChartData.length - 1);
	}
	<!-- 일별 App리뷰 평점그래프 -->
var DailyAppChartData = new Array();
	<c:forEach var="appRanking" items="${appRankingFlow}">
		
	DailyAppChartData.push({
			date :'${appRanking.dateString}',
		   	tmon: ${appRanking.tmonRank},
		   	coupang : ${appRanking.coupangRank},
		   	wemap : ${appRanking.wemapRank} 
		});           
	</c:forEach>  

		var monthAppChart = new GraphFactory(DailyAppChartData , "light", "appDailyLinechart").createLineTypeGraphForDaily();
	
		<!-- App전체평점그래프 -->
var averageGradeChartData =[{
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

new GraphFactory(averageGradeChartData , "light", "appStackchartAverage").createStackTypeGraphForAverage();

<!-- App리뷰개수 그래프 -->
var reviewCountChartData =[{
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

new GraphFactory(reviewCountChartData , "light", "appStackchartCount").createStackTypeGraph();
</script>

</body>