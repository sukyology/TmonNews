package kr.co.tmon.socialnews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocialCategoryController {
	@RequestMapping("/social")
	public ModelAndView ControlAllSocialNews(int page) {
		return null;
	}
	
	@RequestMapping("/coupang")
	public ModelAndView ControlCoupangNews(int page) {
		return null;
	}
	
	@RequestMapping("/tmon")
	public ModelAndView ControlTmonNews(int page) {
		return null;
	}
	
	@RequestMapping("/wemap")
	public ModelAndView ControlWemapNews(int page) {
		return null;
	}
}
