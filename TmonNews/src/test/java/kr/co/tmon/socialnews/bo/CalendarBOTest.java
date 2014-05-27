package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class CalendarBOTest {
	@Autowired
	private CalendarBO calendarBO;

	@Test
	public void 바뀐_날짜로부터_정상적으로_뉴스리스트가_리턴되는지_테스트() {
		calendarBO.setNewsDate(new Date(System.currentTimeMillis()));
		calendarBO.setSocialCorpCode("tm");

		assertNotNull(calendarBO.getNewsList(1));
	}

}
