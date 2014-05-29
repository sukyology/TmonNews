<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:set var="count" value="${request.getAttribute('totalPage') }" />
	<c:if test="${count > 0}">
		<!-- 한 화면에 들어갈 뉴스 개수 -->
		<c:set var="pageSize" value="4" />
		<!-- pagination 보여지는 개수 -->
		<c:set var="pageGroupSize" value="3" />

		<f:parseNumber var="pageGroupCount" integerOnly="true"
			value="${count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1)}" />
		<f:parseNumber var="numPageGroup" integerOnly="true"
			value="${(currentPage / 3) + ((currentPage % 3) == 0 ? 0 : 1)}" />

		<c:set var="pageCount"
			value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
		<c:set var="endPage" value="${startPage + pageGroupSize-1}" />

		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<c:if test="${numPageGroup > 1}">
			<a href="./Page?pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[pre]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="Page?pageNum=${i}">[ <font color="#000000" /> <c:if
					test="${currentPage == i}">
					<font color="#bbbbbb" />
				</c:if> ${i} </font>]
			</a>
		</c:forEach>

		<c:if test="${numPageGroup < pageGroupCount}">
			<a href="./Page?pageNum=${numPageGroup*pageGroupSize+1}">[next]</a>
		</c:if>
	</c:if>
</body>
</html>