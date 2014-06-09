<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>- 메인 페이지</title>
</head>
<body>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 data-toggle="tooltip" title="click calendar to change the date" class="page-header" style="margin-top: 0px;"><%=request.getParameter("date")%><input id="datepicker" type="hidden"></input>
		</h1>
		<c:choose>
		<c:when test="${empty newsList}">
		오늘 날짜의 뉴스가 존재하지 않습니다. 
		</c:when>
		<c:otherwise>
			<!--기사 내용시작-->
			<div class="col-lg-1"></div>
			<div class="col-lg-10">



				<c:forEach var="news" items="${newsList}">
					<div class="row">
						<div class="col-lg-9">
							<div class="media">
								<a href="../NewsOpen.tmon?newsLink=${news.newsLink}&newsID=${news.newsID}" target="_blank"> <%-- <img class="media-object pull-left" src="${news.newsImage}" onError='javascript:this.src="/image/"+location.pathname.split("/")["2"].split(".")["0"]+"_logo.png";' style='width: 100px; height: 100px; margin-right: 20px' /> --%>
									<canvas id="${news.newsID}" class="media-object pull-left canvas" width="100px" height="100px" style="margin-right: 20px;"></canvas> <script type="text/javascript">
										function draw() {

											var canvas = document
													.getElementById(
															'<c:out value="${news.newsID}"/>')
													.getContext('2d');
											var image = new Image();
											image.onload = function() {

												var width = image.naturalWidth;
												var height = image.naturalHeight;
												if (width > height) {
													canvas
															.drawImage(
																	image,
																	(width - height) / 2,
																	0,
																	(width + height) / 2,
																	height, 0,
																	0, 100, 100);
												} else {
													canvas
															.drawImage(
																	image,
																	0,
																	(height - width) / 2,
																	width,
																	(width + height) / 2,
																	0, 0, 100,
																	100);
												}
											};
											image.src = '<c:out value="${news.newsImage}"/>';

											image.onerror = function() {
												image.src = "/image/"
														+ location.pathname
																.split("/")["2"]
																.split(".")["0"]
														+ "_logo_mini.png";
												canvas.drawImage(image, 0, 0,
														100, 100);
											};
										}

										$(document).ready(draw());
									</script>
									<div class="media-body">
										<h4 class="media-heading">
											${news.newsTitle}<sub>&nbsp;&nbsp;|&nbsp;&nbsp; ${news.newsProvider}</sub>
										</h4>
										${news.newsPreview}
									</div>
								</a>
							</div>
						</div>

						<div class="col-lg-1">
							<center>
								<font size="2">조회수</font><br> <font size="4">${news.newsCount}</font>
							</center>
						</div>

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


	</div>

	<script>
		$.datepicker.setDefaults({
			showOn : "button",
			buttonImageOnly : true,
			buttonImage : "/image/calendarglyphicon.png",
		});
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});
		$("input").on(
				"change",
				function() {
					location.assign(location.pathname + "?date="
							+ $("#datepicker").val() + "&page=1");
				});
	</script>
</body>
</html>