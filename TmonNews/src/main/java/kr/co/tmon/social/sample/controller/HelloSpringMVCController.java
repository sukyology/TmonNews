package kr.co.tmon.social.sample.controller;

import kr.co.tmon.social.sample.bo.HelloSpringBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sample")
public class HelloSpringMVCController {
	@Autowired
	private HelloSpringBO helloSpringBO;
	
	@RequestMapping("/hello")
	public ModelAndView helloSpringMVC(String userName , String userId) {
		ModelAndView helloModelAndView = new ModelAndView();
		helloModelAndView.addObject("hellowComment", helloSpringBO.getHelloComment());
		helloModelAndView.setViewName("/hello/hello");
		
		return helloModelAndView;
	}
}
