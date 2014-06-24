package kr.co.tmon.socialnews.controller;
/**
 * 
 * @author 고영경
 * 
 */
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.tmon.socialnews.bo.NewsCountBO;

@Controller
public class NewsOpenController {
	@Autowired
	private NewsCountBO newsCountBO;
	
	@RequestMapping("/NewsOpen")
	public String controllerNewsCount(HttpServletRequest request, int newsID){
		newsCountBO.updateNewsCount(newsID);
		
		return "redirect:"+request.getQueryString().substring(9);
	}
}
