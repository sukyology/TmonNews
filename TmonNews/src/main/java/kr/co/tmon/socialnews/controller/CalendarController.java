package kr.co.tmon.socialnews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {
	@RequestMapping("/calendar")
	public ModelAndView ControlCalendar(String date, String page) {
		return null;
	}
}
