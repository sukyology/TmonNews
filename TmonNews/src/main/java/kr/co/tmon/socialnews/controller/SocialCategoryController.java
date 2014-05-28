package kr.co.tmon.socialnews.controller;

/**
 * 
 * @author 고영경
 * 
 */

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import kr.co.tmon.socialnews.bo.SocialCategoryBO;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

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
	public ModelAndView ControlAllSocialNews(HttpSession session, int page, String date) throws ParseException {
		final String socialCorpName = "socials";
		makeSelectedSocialCorp(session, socialCorpName);
		return settingModelAndView(socialCorpName, page, date);
	}

	@RequestMapping("/coupang")
	public ModelAndView ControlCoupangNews(HttpSession session, int page, String date) throws ParseException {
		final String socialCorpName = "coupang";
		makeSelectedSocialCorp(session, socialCorpName);
		return settingModelAndView(socialCorpName, page, date);
	}

	@RequestMapping("/tmon")
	public ModelAndView ControlTmonNews(HttpSession session, int page, String date) throws ParseException {
		final String socialCorpName = "tmon";
		makeSelectedSocialCorp(session, socialCorpName);
		return settingModelAndView(socialCorpName, page, date);
	}

	@RequestMapping("/wemap")
	public ModelAndView ControlWemapNews(HttpSession session, int page, String date) throws ParseException {
		final String socialCorpName = "wemap";
		makeSelectedSocialCorp(session, socialCorpName);
		return settingModelAndView(socialCorpName, page, date);
	}

	private void makeSelectedSocialCorp(HttpSession session, String socialCorpName) {
		session.setAttribute("selectedSocialCorp", socialCorpName);
	}

	private ModelAndView settingModelAndView(String socialCorpName, int page, String date) throws ParseException {
		ModelAndView socialCorpModelAndView = new ModelAndView();
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		socialCategoryBO.setNewsDate(typeChangeBetweenDateAndString.exchangeToDateType(date));
		socialCategoryBO.setSocialCorpCode(socialCorpName);

		socialCorpModelAndView.addObject("newsList", socialCategoryBO.getNewsList(page));

		socialCorpModelAndView.setViewName("newspage");

		return socialCorpModelAndView;
	}

}
