<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="date" value='<%=request.getParameter("date") %>'/>
<c:set var="currentPage" value='<%=request.getParameter("page") %>' />





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
		<li><a
			href="./${corp}.tmon?page=${(numPageGroup-2)*pageGroupSize+1 }&date=${date}">[pre]</a></li>
	</c:if>

	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<li><a href="/category/${corp}.tmon?page=${i}&date=${date}">  <c:if test="${currentPage == i}">
				<span style="color:navy; font-weight:700;">
			</c:if> ${i}  </span>
		</a></li>
	</c:forEach>

	<c:if test="${numPageGroup < pageGroupCount}">
		<li><a
			href="./${corp}.tmon?page=${numPageGroup*pageGroupSize+1}&date=${date}">[next]</a></li>
	</c:if>
</c:if>