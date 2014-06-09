package kr.co.tmon.appreview.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.tmon.appreview.bo.GetRatingOfAppByVersionBO;
import kr.co.tmon.appreview.bo.GetReviewOfAppListBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author 김종환
 * 
 */

@RequestMapping("/appreview")
@Controller
public class DetailedAppRatingController {
	private static final String APP_NAME_OF_COUPANG = "쿠팡";
	private static final String APP_NAME_OF_WEMAP = "위메프";
	private static final String APP_NAME_OF_TMON = "티몬";
	private static final String APP_NAME_OF_TMONPLUS = "티몬플러스";

	@Autowired
	private GetRatingOfAppByVersionBO getRatingOfAppByVersionBO;

	@Autowired
	private GetReviewOfAppListBO getReviewOfAppListBO;

	@RequestMapping("/coupang")
	public ModelAndView coupangAppRating(HttpServletRequest request) {
		ModelAndView coupangRating = getModelAndViewByAppName(APP_NAME_OF_COUPANG);

		return coupangRating;
	}

	@RequestMapping("/wemap")
	public ModelAndView wemapAppRating(HttpServletRequest request) {
		ModelAndView wemapRating = getModelAndViewByAppName(APP_NAME_OF_WEMAP);

		return wemapRating;
	}

	@RequestMapping("/tmon")
	public ModelAndView tmonAppRating(HttpServletRequest request) {
		ModelAndView tmonRating = getModelAndViewByAppName(APP_NAME_OF_TMON);

		return tmonRating;
	}

	@RequestMapping("/tmonplus")
	public ModelAndView tmonplusAppRating(HttpServletRequest request) {
		ModelAndView tmonplusRating = getModelAndViewByAppName(APP_NAME_OF_TMONPLUS);

		return tmonplusRating;
	}

	private ModelAndView getModelAndViewByAppName(String appName) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("reviewList", getReviewOfAppListBO.getReviewOfApp(appName));
		modelAndView.addObject("ratingFlowByVersion", getRatingOfAppByVersionBO.getRatingOfAppByVersion(appName));

		return modelAndView;
	}
}
