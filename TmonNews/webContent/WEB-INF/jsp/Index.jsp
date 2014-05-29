<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Tmon News</title>
</head>
<body>
<script src="/js/jquery-1.10.2.js"></script>
<script>
var today = new Date();
function addingZeroToMonth(){
    return ((today.getMonth()<9) ? ("0"+(today.getMonth()+1)):(today.getMonth()+1));
}
function addingZeroToDate(){
	return ((today.getDate()<10) ? "0"+(today.getDate()):today.getDate());
}
var todayInString = today.getFullYear()+"-"+addingZeroToMonth()+"-"+today.getDate();
$(document).ready(function(){
	location.assign(location.hostname+"/category/socials.tmon?date="+todayInString+"&page=1");
});
</script>
</body>
</html>