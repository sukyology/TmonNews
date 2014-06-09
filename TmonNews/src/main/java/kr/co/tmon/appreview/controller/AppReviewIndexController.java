package kr.co.tmon.appreview.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import kr.co.tmon.appreview.bo.GetNumberOfAppReviewBO;
import kr.co.tmon.appreview.bo.ReviewDataBO;
import kr.co.tmon.appreview.bo.SelectMonthlyRatingBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author 김종환
 * 
 */

@Controller
public class AppReviewIndexController {
	@Autowired
	private SelectMonthlyRatingBO selectMonthlyRatingBO;

	@Autowired
	private GetNumberOfAppReviewBO getNumberOfAppReviewBO;

	@Autowired
	private ReviewDataBO reviewDataBO;

	@RequestMapping("/appreview")
	public ModelAndView indexPageView(HttpServletRequest request) throws ParseException {
		ModelAndView indexPageModel = new ModelAndView();
		indexPageModel.addObject("ratingFlow", selectMonthlyRatingBO.getYearlyReviewRating());
		indexPageModel.addObject("numberOfNews", getNumberOfAppReviewBO.getNumberOfAppReview());
		indexPageModel.addObject("averageRatingOfApp", reviewDataBO.getAppsRating());

		indexPageModel.setViewName("AppReview");
		return indexPageModel;
	}
}
