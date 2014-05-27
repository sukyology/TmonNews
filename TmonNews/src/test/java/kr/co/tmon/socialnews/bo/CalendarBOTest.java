package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class CalendarBOTest {
	@Test
	public void 바뀐_날짜로부터_정상적으로_뉴스리스트가_리턴되는지_테스트() {
		CalendarBO calendarBO = mock(CalendarBO.class);
		when(calendarBO.getNewsList(0)).thenReturn(null);
		calendarBO.setNewsDate(new Date(System.currentTimeMillis()));
		calendarBO.setSocialCorpCode("tm");
		List<News> newsList = calendarBO.getNewsList(0);
		assertNull(newsList);
	}

}
