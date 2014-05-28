package kr.co.tmon.socialnews.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import kr.co.tmon.socialnews.bo.CalendarBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {
	@Autowired
	private CalendarBO calendarBO;

	@RequestMapping("/calendar")
	public ModelAndView ControlCalendar(HttpSession session, int page) {
		ModelAndView calendarModelAndView = new ModelAndView();

		calendarBO.setNewsDate((String)session.getAttribute("selectedDate"));
		calendarBO.setSocialCorpCode((String) session.getAttribute("selectedSocialCorp"));

		calendarModelAndView.addObject("newsList", calendarBO.getNewsList(page));

		return null;
	}
}
