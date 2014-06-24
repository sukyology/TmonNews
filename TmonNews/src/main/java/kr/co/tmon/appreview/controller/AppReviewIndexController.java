package kr.co.tmon.appreview.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import kr.co.tmon.appreview.bo.AppRankingBO;
import kr.co.tmon.appreview.bo.AppReviewBO;
import kr.co.tmon.appreview.bo.MonthlyAppRatingBO;
import kr.co.tmon.appreview.bo.RatingOfAppBO;

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
	private MonthlyAppRatingBO monthlyAppRatingBO;

	@Autowired
	private AppReviewBO appReviewBO;
	
	@Autowired
	private RatingOfAppBO ratingOfAppBO;
	
	@Autowired
	private AppRankingBO appRankingBO;

	@RequestMapping("/appreview/socials")
	public ModelAndView indexPageView(HttpServletRequest request) throws ParseException, IOException, org.json.simple.parser.ParseException {
		ModelAndView indexPageModel = new ModelAndView();
		indexPageModel.addObject("ratingFlow", monthlyAppRatingBO.selectMonthlyAppRating());
		indexPageModel.addObject("numberOfNews", appReviewBO.getNumberOfAppReview());
		indexPageModel.addObject("averageRatingOfApp", ratingOfAppBO.getRatingOfApp());
		indexPageModel.addObject("appRankingFlow", appRankingBO.getAppRankingFlow());
		indexPageModel.setViewName("AppContents");
		return indexPageModel;
	}
}
