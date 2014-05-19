package kr.co.tmon.socialnews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsViewController {
	
	@RequestMapping("/newsview")
	public ModelAndView ControlNewsView() {
		return null;
	}
}
