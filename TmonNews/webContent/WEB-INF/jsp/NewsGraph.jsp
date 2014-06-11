<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="demo" class="collapse in">
<div class="row">
		<center>
			<div id="linechartdiv"></div>
		</center>
	</div>
</div>
<center>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#demo">
  펼치기/닫기
</button>
</center>
	<script type="text/javascript">
	var chartData = new Array();
	 <c:forEach var="news" items="${countSocialNews}">
		chartData.push({
			date : '${news.date}',
  	   	tmon: ${news.tmonNewsCount},
  	   	coupang : ${news.coupangNewsCount},
  	   	wemap : ${news.wemapNewsCount} 
		});
	              
	</c:forEach> 

	
	var chart = AmCharts.makeChart("linechartdiv", {
	    "type": "serial",
	    "theme": "chalk",
	    "pathToImages": "http://www.amcharts.com/lib/3/images/",
	    "dataProvider": chartData,
	    "colors":["#FFBB00", "#6799FF", "#FF0000"],
	    "valueAxes": [{
	        "axisAlpha": 0.2,
	        "dashLength": 1,
	        "position": "left"
	    }],
	    "graphs": [{
	        "id":"tmonGragh",
	        "balloonText": "<b><span style='font-size:14px;'>Tmon: [[value]]</span></b>",
	        "bullet": "round",
	        "bulletBorderAlpha": 1,
			"bulletColor":"#FFBB00",
	        "hideBulletsCount": 50,
	        "title": "tmon",
	        "valueField": "tmon",
			"useLineColorForBulletBorder":true,
			"lineThickness":3
	    },
	    {
	        "id":"coupangGragh",
	        "balloonText": "<b><span style='font-size:14px;'>Coupang: [[value]]</span></b>",
	        "bullet": "round",
	        "bulletBorderAlpha": 1,
			"bulletColor":"#6799FF",
	        "hideBulletsCount": 50,
	        "title": "coupang",
	        "valueField": "coupang",
			"useLineColorForBulletBorder":true,
			"lineThickness":1
	    },
	    {
	        "id":"wemapGragh",
	        "balloonText": "<b><span style='font-size:14px;'>Wemap: [[value]]</span></b>",
	        "bullet": "round",
	        "bulletBorderAlpha": 1,
			"bulletColor":"#FF0000",
	        "hideBulletsCount": 50,
	        "title": "wemap",
	        "valueField": "wemap",
			"useLineColorForBulletBorder":true,
			"lineThickness":1
	    }],
	    "chartScrollbar": {
	        "autoGridCount": true,
	        "graph": "g1",
	        "scrollbarHeight": 40
	    },
	    "chartCursor": {
	        "cursorPosition": "mouse"
	    },
	    "categoryField": "date",
	    "categoryAxis": {
	        "parseDates": true,
	        "axisColor": "#DADADA",
	        "dashLength": 1,
	        "minorGridEnabled": true
	    },
		"exportConfig":{
		  menuRight: '20px',
	      menuBottom: '30px',
	      menuItems: [{
	      icon: 'http://www.amcharts.com/lib/3/images/export.png',
	      format: 'png'	  
	      }]  
		}
	});

	chart.addListener("rendered", zoomChart);
	zoomChart();

	function zoomChart() {
	    chart.zoomToIndexes(chartData.length - 40, chartData.length - 1);
	}

	</script>
