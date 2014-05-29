<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> - 메인 페이지</title>
</head>
<body>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<center>
					<h1 class="page-header">날짜표시공간</h1>
				</center>

				<h2 class="sub-header">오늘의 뉴스</h2>


				<!--기사 내용시작-->
				<div class="col-lg-1"></div>
				<div class="col-lg-10">



				<c:forEach var="news" items="${newsList}">
					<div class="row">
						<div class="col-lg-9">
							<div class="media">
								<a href="http://getbootstrap.com"> <img
									class="media-object pull-left" src="${news.newsImage}"
									style="width: 100px; height: 100px; margin-right: 20px" />

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
								<br> <font size="2">조회수</font><br>
								<font size="4">${news.newsCount}</font>
							</center>
						</div>
						
					</div>
					<br>
				</c:forEach>



					<center>
						<ul class="pagination">
							<jsp:include page="./Pagination.jsp">
						</ul>
					</center>

				</div>



			</div>
		</div>
	</div>
</body>
</html>