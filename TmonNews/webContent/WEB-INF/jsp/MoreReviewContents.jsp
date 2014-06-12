<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


			<c:forEach var="appReview" items="${reviewList}">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class='panel-heading'>
								<h4 class="panel-title"><c:if test='${empty appReview.reviewTitle}'><font color="darkgray">[제목없음]</font></c:if>${appReview.reviewTitle}
									<c:forEach var="star" begin="1" end="${appReview.rating }">
											<img src="../image/star.png" width=18 height=18>
									</c:forEach>	
								</h4>
								<sub style='float: right;'> ${appReview.writtenDate}</sub>
							</div>
							<div class='panel-body' style='padding: 10px;'>
								<p style="margin-left: 15px">${appReview.reviewContext}<sub><font color='#666'>&nbsp;&nbsp;|&nbsp;&nbsp; ${appReview.reviewerID}</font></sub>
								<p>
							</div>
						</div>
					</div>
				</c:forEach>
	