package kr.co.tmon.socialnews.controller;

/**
 * @author 고영경
 * */
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import kr.co.tmon.socialnews.bo.CountSocialNewsBO;
import kr.co.tmon.socialnews.bo.SocialCategoryBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class SocialCategoryController {
	@Autowired
	private SocialCategoryBO socialCategoryBO;
	@Autowired
	private CountSocialNewsBO countSocialNewsBO;
	@Autowired
	private SettingRequestController settingRequest;

	@RequestMapping("/socials")
	public ModelAndView controlAllSocialNews(HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "--") String date) throws ParseException {
		return settingModelAndView("socials", page, date, request);
	}

	@RequestMapping("/coupang")
	public ModelAndView controlCoupangNews(HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "--") String date) throws ParseException {
		return settingModelAndView("coupang", page, date, request);
	}

	@RequestMapping("/tmon")
	public ModelAndView controlTmonNews(HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "--") String date) throws ParseException {
		return settingModelAndView("tmon", page, date, request);
	}

	@RequestMapping("/wemap")
	public ModelAndView controlWemapNews(HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "--") String date) throws ParseException {
		return settingModelAndView("wemap", page, date, request);
	}

	@RequestMapping("/etc")
	public ModelAndView controlEtcNews(HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "--") String date) throws ParseException {
		return settingModelAndView("etc", page, date, request);
	}

	private ModelAndView settingModelAndView(String socialCorpName, int page, String date, HttpServletRequest request) throws ParseException {
		ModelAndView socialCorpModelAndView = new ModelAndView();

		if (date.equals("--"))
			date = socialCategoryBO.getToday();

		socialCorpModelAndView.addObject("newsList", socialCategoryBO.getNewsList(date, socialCorpName, page));
		socialCorpModelAndView.addObject("countSocialNews", countSocialNewsBO.getNewsCount());

		socialCorpModelAndView.setViewName("NewsContents");

		request = settingRequest.setRequestSessionAndAttribute(request, socialCorpName);

		return socialCorpModelAndView;
	}
}