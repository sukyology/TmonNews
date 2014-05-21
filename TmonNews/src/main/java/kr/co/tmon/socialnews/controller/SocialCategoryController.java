package kr.co.tmon.socialnews.controller;

/**
 * 
 * @author 고영경
 * 
 */
import java.util.Date;

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
	public ModelAndView ControlAllSocialNews(HttpSession session) {
		return settingModelAndView("socials", session);
	}

	@RequestMapping("/coupang")
	public ModelAndView ControlCoupangNews(HttpSession session) {
		return settingModelAndView("coupang", session);
	}

	@RequestMapping("/tmon")
	public ModelAndView ControlTmonNews(HttpSession session) {
		return settingModelAndView("tmon", session);
	}

	@RequestMapping("/wemap")
	public ModelAndView ControlWemapNews(HttpSession session) {
		return settingModelAndView("wemap", session);
	}

	private ModelAndView settingModelAndView(String socialCorpName, HttpSession session) {
		ModelAndView socialCorpModelAndView = new ModelAndView();

		session.setAttribute("selectedSocialCorp", socialCorpName);

		socialCategoryBO.setNewsDate((Date) session.getAttribute("selectedDate"));
		socialCategoryBO.setSocialCorpCode(socialCorpName);

		socialCorpModelAndView.addObject("newsList", socialCategoryBO.getNewsList());

		if (socialCorpName.equals("socialCorpName") == false)
			socialCorpModelAndView.setViewName("newspage");

		return socialCorpModelAndView;
	}

}
