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

</head>
<body>

		<c:choose>
			<c:when test="${empty newsList}">
			
				<script>
					location.assign("/requestError.html");
				</script>
				
			</c:when>
			<c:otherwise>
			
			<%@ include file="./NewsGraph.jsp"%>
			
				<!--기사 내용시작-->
				<div class="col-lg-2 col-md-1"></div>
			<div class="col-lg-8 col-md-9">
					<c:forEach var="news" items="${newsList}">
						<div class="row">
							<div class="col-lg-10 col-md-10 col-sm-9 col-xs-11">
								<div class="media">

									<canvas id="${news.newsID}" class="media-object pull-left canvas hidden-xs" width="100px" height="100px" style="margin-right: 20px;"></canvas>
									<script type="text/javascript">
										function draw() {

											var canvas = document.getElementById('<c:out value="${news.newsID}"/>').getContext('2d');
											var image = new Image();
											image.onload = function() {

												var width = image.naturalWidth;
												var height = image.naturalHeight;
												if (width > height) {
													canvas.drawImage(image, (width - height) / 2, 0, (width + height) / 2, height, 0, 0, 100, 100);
												} else {
													canvas.drawImage(image, 0, (height - width) / 2, width, (width + height) / 2, 0, 0, 100, 100);
												}
											};
											image.src = '<c:out value="${news.newsImage}"/>';

											image.onerror = function() {
												image.src = "/image/" + location.pathname.split("/")["2"].split(".")["0"] + "_logo_mini.png";
												canvas.drawImage(image, 0, 0, 100, 100);
											};
										}

										$(document).ready(draw());
									</script>
									<div class="media-body">
										<h4 class="media-heading">
											<a href="../NewsOpen.tmon?newsLink=${news.newsLink}&newsID=${news.newsID}" target="_blank"> ${news.newsTitle}<sub>&nbsp;&nbsp;|&nbsp;&nbsp; ${news.newsProvider}</sub>
											</a>
										</h4>
										<p style="font-size:13px; margin-top:10px; line-height:1.8em;">${news.newsPreview}<p>
									</div>
								</div>
							</div>

							
								<center>
								<span class="hidden-xs"><font size="2">조회수</font><br> <font size="2">${news.newsCount}</font></span>
								</center>
							

						</div>
						<br>
					</c:forEach>

					<center>
						<ul class="pagination">
							<%@ include file="./Pagination.jsp"%>
						</ul>
					</center>

				</div>
			</c:otherwise>
		</c:choose>
	

	<script>
		$.datepicker.setDefaults({
			showOn : "button",
			buttonImageOnly : true,
			buttonImage : "/image/calendarglyphicon.png",
		});
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});
		$("input").on("change", function() {
			location.assign(location.pathname + "?date=" + $("#datepicker").val() + "&page=1");
		});
	</script>
</body>
</html>