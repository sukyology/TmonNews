package kr.co.tmon.socialnews.controller;

/**
 * @author 고영경
 * */
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.tmon.socialnews.bo.CountSocialNewsBO;
import kr.co.tmon.socialnews.bo.SocialCategoryBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class SocialCategoryController {
	@Autowired
	private SocialCategoryBO socialCategoryBO;
	@Autowired
	private CountSocialNewsBO countSocialNewsBO;

	@RequestMapping("/socials")
	public ModelAndView controlAllSocialNews(HttpServletRequest request, int page, String date) throws ParseException {
		final String socialCorpName = "socials";

		makeCorpToSessionAttribute(request, socialCorpName);

		return settingModelAndView(socialCorpName, page, date, request);
	}

	@RequestMapping("/coupang")
	public ModelAndView controlCoupangNews(HttpServletRequest request, int page, String date) throws ParseException {
		final String socialCorpName = "coupang";

		makeCorpToSessionAttribute(request, socialCorpName);

		return settingModelAndView(socialCorpName, page, date, request);
	}

	@RequestMapping("/tmon")
	public ModelAndView controlTmonNews(HttpServletRequest request, int page, String date) throws ParseException {
		final String socialCorpName = "tmon";

		makeCorpToSessionAttribute(request, socialCorpName);

		return settingModelAndView(socialCorpName, page, date, request);
	}

	@RequestMapping("/wemap")
	public ModelAndView controlWemapNews(HttpServletRequest request, int page, String date) throws ParseException {
		final String socialCorpName = "wemap";

		makeCorpToSessionAttribute(request, socialCorpName);

		return settingModelAndView(socialCorpName, page, date, request);
	}

	@RequestMapping("/etc")
	public ModelAndView controlEtcNews(HttpServletRequest request, int page, String date) throws ParseException {
		final String socialCorpName = "etc";

		makeCorpToSessionAttribute(request, socialCorpName);

		return settingModelAndView(socialCorpName, page, date, request);
	}

	private void makeCorpToSessionAttribute(HttpServletRequest request, final String socialCorpName) {
		HttpSession session = request.getSession();
		session.setAttribute("corp", socialCorpName);
	}

	private void makeTotalPageToAttribute(HttpServletRequest request) {
		request.setAttribute("totalPage", socialCategoryBO.getNumberOfNews());
	}

	private ModelAndView settingModelAndView(String socialCorpName, int page, String date, HttpServletRequest request) throws ParseException {
		ModelAndView socialCorpModelAndView = new ModelAndView();

		socialCorpModelAndView.addObject("newsList", socialCategoryBO.getNewsList(date, socialCorpName, page));
		socialCorpModelAndView.addObject("countSocialNews", countSocialNewsBO.getNewsCount());

		socialCorpModelAndView.setViewName("NewsContents");
		makeTotalPageToAttribute(request);
		return socialCorpModelAndView;
	}

}
