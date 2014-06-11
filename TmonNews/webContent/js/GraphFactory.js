/**
 * 타입에 따른 그래프 생성 클래스 @ 신예슬
 */

var GraphFactory = function(chartdata , themeName , selectorName) {
	this.chartData = chartdata;
	this.themeName = themeName;
	this.selectorName = selectorName;
}

GraphFactory.prototype.createLineTypeGraph = function(chart) {
	var chart = AmCharts
			.makeChart(
					this.selectorName,
					{
						"type" : "serial",
						"theme" : this.themeName,
						"pathToImages" : "http://www.amcharts.com/lib/3/images/",
						"dataProvider" : this.chartData,
						"colors" : [ "#FFBB00", "#6799FF", "#FF0000" ],
						"valueAxes" : [ {
							"axisAlpha" : 0.2,
							"dashLength" : 1,
							"position" : "left"
						} ],
						"graphs" : [
								{
									"id" : "tmonGragh",
									"balloonText" : "<b><span style='font-size:14px;'>Tmon: [[value]]</span></b>",
									"bullet" : "round",
									"bulletBorderAlpha" : 1,
									"bulletColor" : "#FFBB00",
									"hideBulletsCount" : 50,
									"title" : "tmon",
									"valueField" : "tmon",
									"useLineColorForBulletBorder" : true,
									"lineThickness" : 3
								},
								{
									"id" : "coupangGragh",
									"balloonText" : "<b><span style='font-size:14px;'>Coupang: [[value]]</span></b>",
									"bullet" : "round",
									"bulletBorderAlpha" : 1,
									"bulletColor" : "#6799FF",
									"hideBulletsCount" : 50,
									"title" : "coupang",
									"valueField" : "coupang",
									"useLineColorForBulletBorder" : true,
									"lineThickness" : 1
								},
								{
									"id" : "wemapGragh",
									"balloonText" : "<b><span style='font-size:14px;'>Wemap: [[value]]</span></b>",
									"bullet" : "round",
									"bulletBorderAlpha" : 1,
									"bulletColor" : "#FF0000",
									"hideBulletsCount" : 50,
									"title" : "wemap",
									"valueField" : "wemap",
									"useLineColorForBulletBorder" : true,
									"lineThickness" : 1
								} ],
						"chartScrollbar" : {
							"autoGridCount" : true,
							"graph" : "g1",
							"scrollbarHeight" : 40
						},
						"chartCursor" : {
							"cursorPosition" : "mouse"
						},
						"categoryField" : "date",
						"categoryAxis" : {
							"parseDates" : false,
							"axisColor" : "#DADADA",
							"dashLength" : 1,
							"minorGridEnabled" : true
						},
						"exportConfig" : {
							menuRight : '20px',
							menuBottom : '30px',
							menuItems : [ {
								icon : 'http://www.amcharts.com/lib/3/images/export.png',
								format : 'png'
							} ]
						}
					});
	
	return chart;
}



GraphFactory.prototype.createStackTypeGraph = function(chart) {
	var chart = AmCharts.makeChart(this.selectorName, {
	    "type": "serial",
	    "theme": this.themeName,
	    "dataProvider": this.chartData,
	    "valueAxes": [{
	        "gridColor":"#FFFFFF",
			"gridAlpha": 0.2,
			"dashLength": 0
	    }],
	    "gridAboveGraphs": true,
	    "startDuration": 1,
	    "graphs": [{
	        "balloonText": "[[category]]: <b>[[value]]</b>",
	        "fillAlphas": 0.8,
	        "lineAlpha": 0.2,
	        "type": "column",
	        "valueField": "appAverage",
	        "colorField": "color"
	      
	    }],
	    "chartCursor": {
	        "categoryBalloonEnabled": false,
	        "cursorAlpha": 0,
	        "zoomable": false
	    },
	    "categoryField": "corp",
	    "categoryAxis": {
	        "gridPosition": "start",
	        "gridAlpha": 0
	    },
		"exportConfig":{
		  "menuTop": 0,
		  "menuItems": [{
	      "icon": '/lib/3/images/export.png',
	      "format": 'png'	  
	      }]  
		}
	});
	
	return chart;
}
