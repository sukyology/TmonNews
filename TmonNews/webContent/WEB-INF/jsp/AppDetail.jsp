<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>- 메인 페이지</title>
<link href="/css/chart.css" rel="stylesheet">
<script type="text/javascript"
	src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript"
	src="http://www.amcharts.com/lib/3/pie.js"></script>
<script type="text/javascript"
	src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript"
	src="http://www.amcharts.com/lib/3/themes/light.js"></script>
<script type="text/javascript" src="/js/GraphFactory.js"></script>

</head>
<body>

	<div class="col-lg-2"></div>
	<div class="col-lg-8">
		<div class="row">
			<div class="col-lg-6">
				<div id="appPiechartReview"></div>
			</div>
			<div class="col-lg-6">
				<div id="appLinechartVersion"></div>
			</div>
		</div>

		<div style='margin-top: 20px;' class='well well-sm'>
			<center>최근 앱 리뷰</center>
		</div>

		<div class="row">

			<div id="content-wrapper">
				<c:forEach var="appReview" items="${reviewList}">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class='panel-heading'>
								<h4 class="panel-title">
									<c:if test='${empty appReview.reviewTitle}'>
										<font color="darkgray">[제목없음]</font>
									</c:if>${appReview.reviewTitle}
									<c:forEach var="star" begin="1" end="${appReview.rating }">
										<img src="../image/star.png" width=18 height=18>
									</c:forEach>
								</h4>
								<sub style='float: right;'> ${appReview.writtenDate}</sub>
							</div>
							<div class='panel-body' style='padding: 10px;'>
								<p style="margin-left: 15px">${appReview.reviewContext}<sub><font
										color='#666'>&nbsp;&nbsp;|&nbsp;&nbsp;
											${appReview.reviewerID}</font></sub>
								<p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<div class="col-lg-2"></div>
	<button style='margin-bottom: 20px; margin-top: 20px;'
		class='btn btn-primary btn-block center-block' id='loadMoreAppReview'>
		<b>더보기</b>
	</button>



	<script type="text/javascript">
function addLastestFiveVersionData(rating){
	sumOfReviewRating = 0;
	if(rating == 1)
		sumOfReviewRating = ${ratingFlowByVersion.get(0).ratingOne} + ${ratingFlowByVersion.get(1).ratingOne} + ${ratingFlowByVersion.get(2).ratingOne} + ${ratingFlowByVersion.get(3).ratingOne} + ${ratingFlowByVersion.get(4).ratingOne};
	else if (rating == 2)
		sumOfReviewRating = ${ratingFlowByVersion.get(0).ratingTwo} + ${ratingFlowByVersion.get(1).ratingTwo} + ${ratingFlowByVersion.get(2).ratingTwo} + ${ratingFlowByVersion.get(3).ratingTwo} + ${ratingFlowByVersion.get(4).ratingTwo};
	else if(rating==3)
		sumOfReviewRating = ${ratingFlowByVersion.get(0).ratingThree} + ${ratingFlowByVersion.get(1).ratingThree} + ${ratingFlowByVersion.get(2).ratingThree} + ${ratingFlowByVersion.get(3).ratingThree} + ${ratingFlowByVersion.get(4).ratingThree};
	else if(rating == 4)
		sumOfReviewRating = ${ratingFlowByVersion.get(0).ratingFour} + ${ratingFlowByVersion.get(1).ratingFour} + ${ratingFlowByVersion.get(2).ratingFour} + ${ratingFlowByVersion.get(3).ratingFour} + ${ratingFlowByVersion.get(4).ratingFour};
	else if(rating == 5)
		sumOfReviewRating = ${ratingFlowByVersion.get(0).ratingFive} + ${ratingFlowByVersion.get(1).ratingFive} + ${ratingFlowByVersion.get(2).ratingFive} + ${ratingFlowByVersion.get(3).ratingFive} + ${ratingFlowByVersion.get(4).ratingFive};
	
	return sumOfReviewRating;
}
var corpAverageGradechartData = [
                 { grade: "5점", value:addLastestFiveVersionData(5)},
                 { grade:"4점",  value:addLastestFiveVersionData(4)},
                 { grade:"3점",  value:addLastestFiveVersionData(3)},
                 { grade:"2점",  value:addLastestFiveVersionData(2)},
                 { grade:"1점",  value:addLastestFiveVersionData(1)}
                ];

new GraphFactory(corpAverageGradechartData , "light", "appPiechartReview").createPieTypeGraph();
</script>


	<script>
var chartData = new Array();
<c:forEach var="appVersionGrade" items="${ratingFlowByVersion}">
	
	chartData.push({
		version :'${appVersionGrade.appVersion}',
	   	grade: ${appVersionGrade.averageRating}
	   	
	});           
</c:forEach> 


var color;
<c:choose>
	<c:when test='${ratingFlowByVersion.get(0).appName=="티몬"}'>
		color="#FFBB00";
	</c:when>
	<c:when test='${ratingFlowByVersion.get(0).appName=="쿠팡"}'>
		color="#6799FF";
	</c:when>
	<c:when test="${ratingFlowByVersion.get(0).appName=='위메프'}">
		color="#FF0000";
</c:when>
</c:choose>

new GraphFactoryForVersion(chartData , color).createLineTypeGraphForVersion();
</script>




	<script>
		$(document).ready(function() {
			$pagenumber = 0;

			$('#loadMoreAppReview').on("click", function() {
				$pagenumber++;
				$.get('/moreappreview/'+location.href.split('/')['4'], {
					"pageNumber" : $pagenumber
				}, function(response) {
					$("#content-wrapper").append(response);
					
				});
			});
		});
	</script>

</body>
</html>
