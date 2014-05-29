package kr.co.tmon.socialnews.controller;
/*
 * @author 고영경
 * */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.tmon.socialnews.bo.SocialCategoryBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class SocialCategoryController {
	@Autowired
	private SocialCategoryBO socialCategoryBO;

	@RequestMapping("/socials")
	public ModelAndView controlAllSocialNews(HttpServletRequest request, int page, String date) {
		final String socialCorpName = "socials";

		makeCorpToSessionAttribute(request, socialCorpName);

		makeTotalPageToAttribute(request);

		return settingModelAndView(socialCorpName, page, date);
	}

	@RequestMapping("/coupang")
	public ModelAndView controlCoupangNews(HttpServletRequest request, int page, String date) {
		final String socialCorpName = "coupang";

		makeCorpToSessionAttribute(request, socialCorpName);

		makeTotalPageToAttribute(request);

		return settingModelAndView(socialCorpName, page, date);
	}

	@RequestMapping("/tmon")
	public ModelAndView controlTmonNews(HttpServletRequest request, int page, String date) {
		final String socialCorpName = "tmon";

		makeCorpToSessionAttribute(request, socialCorpName);

		makeTotalPageToAttribute(request);
		return settingModelAndView(socialCorpName, page, date);
	}

	@RequestMapping("/wemap")
	public ModelAndView controlWemapNews(HttpServletRequest request, int page, String date) {
		final String socialCorpName = "wemap";

		makeCorpToSessionAttribute(request, socialCorpName);

		makeTotalPageToAttribute(request);

		return settingModelAndView(socialCorpName, page, date);
	}

	private void makeCorpToSessionAttribute(HttpServletRequest request, final String socialCorpName) {
		HttpSession session = request.getSession();
		session.setAttribute("corp", socialCorpName);
	}

	private void makeTotalPageToAttribute(HttpServletRequest request) {
		request.setAttribute("totalPage", socialCategoryBO.getNumberOfNews());
	}

	private ModelAndView settingModelAndView(String socialCorpName, int page, String date) {
		ModelAndView socialCorpModelAndView = new ModelAndView();

		socialCorpModelAndView.addObject("newsList", socialCategoryBO.getNewsList(date, socialCorpName, page));

		socialCorpModelAndView.setViewName("Main");

		return socialCorpModelAndView;
	}

}
