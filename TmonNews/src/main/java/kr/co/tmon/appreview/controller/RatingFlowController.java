package kr.co.tmon.appreview.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import kr.co.tmon.appreview.bo.AccessRatingFlowDataDbBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author 김종환
 * 
 *         별점추이변화에 대한 데이터를 넘겨주는 Controller
 * 
 */

@Controller
@RequestMapping("/appreview/graphs/flowofrating")
public class RatingFlowController {
	private static final String CODE_OF_WEMAP = "wmp";
	private static final String CODE_OF_TMON = "tm";
	private static final String CODE_OF_COUPANG = "cp";
	@Autowired
	private AccessRatingFlowDataDbBO accessRatingFlowDataDbBO;

	@RequestMapping("/coupang")
	public ModelAndView coupangAppData(HttpServletRequest request, String startDate, String endDate) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(accessRatingFlowDataDbBO.getMonthlyRatingAsCorp(startDate, endDate, CODE_OF_COUPANG));
		return modelAndView;
	}
	
	@RequestMapping("/tmon")
	public ModelAndView tmonAppData(HttpServletRequest request, String startDate, String endDate) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(accessRatingFlowDataDbBO.getMonthlyRatingAsCorp(startDate, endDate, CODE_OF_TMON));
		return modelAndView;
	}
	
	@RequestMapping("/wemap")
	public ModelAndView wemapAppData(HttpServletRequest request, String startDate, String endDate) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(accessRatingFlowDataDbBO.getMonthlyRatingAsCorp(startDate, endDate, CODE_OF_WEMAP));
		return modelAndView;
	}
	
}
