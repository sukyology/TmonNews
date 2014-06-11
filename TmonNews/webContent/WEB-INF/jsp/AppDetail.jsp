<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>- 메인 페이지</title>
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
</head>
<body>
      <div id="content-box">
            <div id="content-wrapper">
                  <c:forEach var="appReview" items="${reviewList}">
                        <div class="media-body">
                             <h4 class="media-heading">
                                   ${appReview.reviewTitle}<sub>&nbsp;&nbsp;|&nbsp;&nbsp; ${appReview.writtenDate}</sub>
                             </h4>
                             <p style="margin-top: 10px;">${appReview.reviewContext}
                             <p>
                        </div>
                  </c:forEach>
            </div>
      </div>

</body>
</html>
