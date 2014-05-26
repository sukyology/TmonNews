package kr.co.tmon.socialnews.controller;

/**
 * 
 * @author 고영경
 * 
 */
import java.sql.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import kr.co.tmon.socialnews.bo.SocialCategoryBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class SocialCategoryController extends HttpServlet {
	@Autowired
	private SocialCategoryBO socialCategoryBO;

	@RequestMapping("/socials")
	public ModelAndView ControlAllSocialNews(HttpSession session, int page) {
		return settingModelAndView("socials", session, page);
	}

	@RequestMapping("/coupang")
	public ModelAndView ControlCoupangNews(HttpSession session, int page) {
		return settingModelAndView("coupang", session, page);
	}

	@RequestMapping("/tmon")
	public ModelAndView ControlTmonNews(HttpSession session, int page) {
		return settingModelAndView("tmon", session, page);
	}

	@RequestMapping("/wemap")
	public ModelAndView ControlWemapNews(HttpSession session, int page) {
		return settingModelAndView("wemap", session, page);
	}

	private ModelAndView settingModelAndView(String socialCorpName, HttpSession session, int page) {
		ModelAndView socialCorpModelAndView = new ModelAndView();

		session.setAttribute("selectedSocialCorp", socialCorpName);

		socialCategoryBO.setNewsDate((Date) session.getAttribute("selectedDate"));
		socialCategoryBO.setSocialCorpCode(socialCorpName);

		socialCorpModelAndView.addObject("newsList", socialCategoryBO.getNewsList(page));

		if (socialCorpName.equals("socialCorpName") == false)
			socialCorpModelAndView.setViewName("newspage");

		return socialCorpModelAndView;
	}

}
