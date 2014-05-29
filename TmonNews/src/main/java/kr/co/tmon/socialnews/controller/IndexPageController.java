package kr.co.tmon.socialnews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexPageController {

	@RequestMapping("index")
	public String ControlCalendar() {
		return "Index";
	}
}
