package kr.co.tmon.appreview.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.tmon.appreview.bo.ReviewDataBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author YoungKyo Lee
 * 리뷰 데이터 클래스
 * -티몬, 쿠팡, 위메프 평균 평점
 */
@Controller
@RequestMapping("/getReviewData")
public class ReviewDataController {
	@Autowired
	ReviewDataBO reviewDataBO;
	
	@RequestMapping("TmonAvgGrade")
	public ModelAndView tmonAvgGradeController() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("tmonAvgGrade", reviewDataBO.selectTmonAvgGrade());
		return modelAndView;
	}
	
	@RequestMapping("CoupangAvgGrade")
	public ModelAndView coupangAvgGradeController() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("CoupangAvgGrade", reviewDataBO.selectCoupangAvgGrade());
		return modelAndView;
	}
	
	@RequestMapping("WemapAvgGrade")
	public ModelAndView wemapAvgGradeController() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("WemapAvgGrade", reviewDataBO.selectWemapAvgGrade());
		return modelAndView;
	}
	
	@RequestMapping("TmonPlusAvgGrade")
	public ModelAndView tmonPlusAvgGradeController() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("TmonPlusAvgGrade", reviewDataBO.selectTmonPlusAvgGrade());
		return modelAndView;
	}
}
