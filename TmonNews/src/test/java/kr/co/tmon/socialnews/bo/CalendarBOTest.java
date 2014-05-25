package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.junit.Before;
import org.junit.Test;

public class CalendarBOTest {
	private CalendarBO calendarBO;

	@Before
	public void setup() {
		calendarBO = new CalendarBO();
		calendarBO.setSocialCorpCode("all");
		calendarBO.setNewsDate(new Date(System.currentTimeMillis()));
	}

	@Test
	public void 첫페이지인_오늘날짜의_전체기사의_리스트가_정상적으로_반환되는지_테스트() {
		List<News> newsList = calendarBO.getNewsList();
		assertNotNull(newsList);
	}
	
	@Test
	public void 날짜를_전환했을떄_정상적으로_반환하는지_테스트() {
		calendarBO.setNewsDate(new Date(2014 - 1900, 4, 21));

		List<News> newsList = calendarBO.getNewsList();
		assertNotNull(newsList);
	}
}

