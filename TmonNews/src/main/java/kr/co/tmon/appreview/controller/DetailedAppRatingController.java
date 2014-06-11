package kr.co.tmon.appreview.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.tmon.appreview.bo.AppReviewBO;
import kr.co.tmon.appreview.bo.RatingOfAppVersionBO;

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
@RequestMapping("/appreview")
public class DetailedAppRatingController {
	private static final int DEFAULT_LOAD_NUMBER = 0;
	private static final String APP_NAME_OF_COUPANG = "쿠팡";
	private static final String APP_NAME_OF_WEMAP = "위메프";
	private static final String APP_NAME_OF_TMON = "티몬";
	private static final String APP_NAME_OF_TMONPLUS = "티몬플러스";

	@Autowired
	private AppReviewBO appReviewBO;

	@Autowired
	private RatingOfAppVersionBO ratingOfAppVersionBO;

	@RequestMapping("/coupang")
	public ModelAndView coupangAppRating(HttpServletRequest request) {
		int pageNumber = extractPageNumber(request);

		ModelAndView coupangRating = getModelAndViewByAppName(APP_NAME_OF_COUPANG, pageNumber);

		return coupangRating;
	}

	@RequestMapping("/wemap")
	public ModelAndView wemapAppRating(HttpServletRequest request) {
		int pageNumber = extractPageNumber(request);

		ModelAndView wemapRating = getModelAndViewByAppName(APP_NAME_OF_WEMAP, pageNumber);

		return wemapRating;
	}

	@RequestMapping("/tmon")
	public ModelAndView tmonAppRating(HttpServletRequest request) {
		int pageNumber = extractPageNumber(request);

		ModelAndView tmonRating = getModelAndViewByAppName(APP_NAME_OF_TMON, pageNumber);

		return tmonRating;
	}

	private int extractPageNumber(HttpServletRequest request) {
		int pageNumber;

		if (request.getParameter("pageNumber") == null)
			pageNumber = DEFAULT_LOAD_NUMBER;
		else
			pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
		return pageNumber;
	}

	private ModelAndView getModelAndViewByAppName(String appName, int pageNumber) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("reviewList", appReviewBO.selectReviewList(appName, pageNumber));
		modelAndView.addObject("ratingFlowByVersion", ratingOfAppVersionBO.selectLastestFiveVersionRating(appName));

		modelAndView.setViewName("AppDetail");

		return modelAndView;
	}
}
