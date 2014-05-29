package kr.co.tmon.socialnews.controller;

import javax.servlet.http.HttpSession;

import kr.co.tmon.socialnews.bo.NewsCountBO;
import kr.co.tmon.socialnews.model.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author 김종환
 *
 */

@Controller
public class NewsViewController {
	@Autowired
	private NewsCountBO newsCountBO;
		
	@RequestMapping("/newsview")
	public ModelAndView ControlNewsView(HttpSession httpSession, News news) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(news);
		newsCountBO.updateNewsCount(news.getNewsID());
		
		return modelAndView;
	}
}
