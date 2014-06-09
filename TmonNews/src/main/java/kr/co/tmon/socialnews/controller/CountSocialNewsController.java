package kr.co.tmon.socialnews.controller;

/**
 * 
 * @author 고영경
 * 
 */

import java.text.ParseException;

import kr.co.tmon.socialnews.bo.CountSocialNewsBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/show/chart")
public class CountSocialNewsController {
	@Autowired
	private CountSocialNewsBO countSocialNewsBO;
	
	@RequestMapping("/newsCount")
	public Model makeTodayNewsCount() throws ParseException {
		Model newsCountModel = new ExtendedModelMap();
		newsCountModel.addAttribute("countSocialNews", countSocialNewsBO.getNewsCount());
		return newsCountModel;
	}

}
