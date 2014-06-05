package kr.co.tmon.appreview.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.tmon.appreview.bo.ReviewDataBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/getReviewData")
public class ReviewDataController {
	@Autowired
	ReviewDataBO reviewDataBO;
	
	@RequestMapping("TmonAvgGrade")
	public float tmonAvgGradeController() {
		float tmonAvgGrade = reviewDataBO.selectTmonAvgGrade();
		return tmonAvgGrade;
	}
	
	@RequestMapping("CoupangAvgGrade")
	public float CoupangAvgGradeController() {
		float CoupangAvgGrade = reviewDataBO.selectCoupangAvgGrade();
		return CoupangAvgGrade;
	}
	
	@RequestMapping("WemapAvgGrade")
	public float WemapAvgGradeController() {
		float WemapAvgGrade = reviewDataBO.selectWemapAvgGrade();
		return WemapAvgGrade;
	}
}
