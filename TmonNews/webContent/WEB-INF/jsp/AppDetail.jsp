<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>- 메인 페이지</title>
<link href="/css/chart.css" rel="stylesheet">
<script type="text/javascript" src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/pie.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/themes/light.js"></script>
<script type="text/javascript" src="/js/GraphFactory.js"></script>

</head>
<body>

	<div class="col-lg-2"></div>
	<div class="col-lg-8">
		<div class="row">
			<div id="appPiechartReview"></div>
			<div id="appLinechartVersion"></div>
		</div>
		<div class="row">
			<div id="content-box">
				<div id="content-wrapper">
					<c:forEach var="appReview" items="${reviewList}">
						<div class="media-body">
							<h4 class="media-heading">
								${appReview.reviewTitle}<sub>&nbsp;&nbsp;|&nbsp;&nbsp; ${appReview.writtenDate}</sub>
							</h4>
							<p style="margin-top: 10px; margin-left: 15px">${appReview.reviewContext}<sub>&nbsp;&nbsp;|&nbsp;&nbsp; ${appReview.reviewerID}</sub>
							<p>
						</div>
						<br>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-2"></div>


	<script type="text/javascript">
var chartData = [
                 { grade: "5점", value:${ratingFlowByVersion.get(0).ratingFive}},
                 { grade:"4점", value:${ratingFlowByVersion.get(0).ratingFour}},
                 { grade:"3점", value:${ratingFlowByVersion.get(0).ratingThree}},
                 { grade:"2점", value:${ratingFlowByVersion.get(0).ratingTwo}},
                 { grade:"1점", value:${ratingFlowByVersion.get(0).ratingOne}}
                
                ];

var chart = new GraphFactory(chartData , "light", "appPiechartReview").createPieTypeGraph();
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

var chart = new GraphFactoryForVersion(chartData , color).createLineTypeGraphForVersion();
</script>



	<script>
      $(document).ready(function() {
            $contentLoadTriggered = false;
            $pagenumber = 1;
            $("#content-box").scroll(function() {
                  if ($("#content-box").scrollTop() >= ($("#content-wrapper").height() - $("#content-box").height()) && $contentLoadTriggered == false) {
                        $contentLoadTriggered = true;
                        $.get(location.href, {
                             "pagenumber" : pagenumber
                        }, function(data) {
                             $("#content-wrapper").append(data);
                             $contentLoadTriggered = false;
                             pagenumber++;
                        });
                  }
            });
      });
</script>


</body>
</html>
