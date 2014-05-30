<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 
<h1><%=request.getParameter("date") %></h1>
--%>

<c:set var="date" value='<%=request.getParameter("date") %>' scope="request" />
<c:set var="currentPage" value='<%=request.getParameter("page") %>' scope="request" />





<c:if test="${totalPage > 0}">
	<!-- 한 화면에 들어갈 뉴스 개수 -->
	<c:set var="pageSize" value="5" />
	<!-- pagination 보여지는 개수 -->
	<c:set var="pageGroupSize" value="5" />

	<f:parseNumber var="pageGroupCount" integerOnly="true"
		value="${totalPage / (pageSize * pageGroupSize) + (totalPage % (pageSize * pageGroupSize) == 0 ? 0 : 1)}" />
	<f:parseNumber var="numPageGroup" integerOnly="true"
		value="${(currentPage / pageGroupSize) + ((currentPage % pageGroupSize) == 0 ? 0 : 1)}" />

	<c:set var="pageCount"
		value="${totalPage / pageSize + ( totalPage % pageSize == 0 ? 0 : 1)}" />
	<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
	<c:set var="endPage" value="${startPage + pageGroupSize-1}" />

	<c:if test="${endPage > pageCount}">
		<c:set var="endPage" value="${pageCount}" />
	</c:if>

	<c:if test="${numPageGroup > 1}">
		<a
			href="./${corp}.tmon?page=${(numPageGroup-2)*pageGroupSize+1 }&date=${date}">[pre]</a>
	</c:if>

	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="/category/${corp}.tmon?page=${i}&date=${date}">[ <font
			color="#000000" /> <c:if test="${currentPage == i}">
				<font color="#bbbbbb" />
			</c:if> ${i} </font>]
		</a>
	</c:forEach>

	<c:if test="${numPageGroup < pageGroupCount}">
		<a
			href="./${corp}.tmon?page=${numPageGroup*pageGroupSize+1}&date=${date}">[next]</a>
	</c:if>
</c:if>
