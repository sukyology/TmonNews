package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class CalendarBOTest {
	@Test
	public void 바뀐_날짜로부터_정상적으로_뉴스리스트가_리턴되는지_테스트() {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = typeChangeBetweenDateAndString.exchangeToStringType(new Date(System.currentTimeMillis()));
		
		CalendarBO calendarBO = mock(CalendarBO.class);
		when(calendarBO.getNewsList(dateString, "tm", 0)).thenReturn(null);
		
		List<News> newsList = calendarBO.getNewsList(dateString, "tm", 0);
		assertNull(newsList);
	}

}
