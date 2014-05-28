package kr.co.tmon.socialnews.controller;

/**
 * 
 * @author YoungKyo Lee
 * 
 */
import kr.co.tmon.socialnews.bo.NewsCountBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsCountController {
	@Autowired
	private NewsCountBO newsCountBO;
	
	@RequestMapping("/newscount")
	public void ControllerNewsCount(int newsId){
		newsCountBO.updateNewsCount(newsId);
	}
}
