package kr.co.tmon.socialnews.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class LocalDailyNewsCountDAOTest {
	@Autowired
	private LocalDailyNewsCountDAO getDailyNewsCountDAO;

	@Test
	public void 정확한_뉴스리스트의_카운트를_리턴하는지_테스트() {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = typeChangeBetweenDateAndString.exchangeToStringType(new Date(System.currentTimeMillis()));
		int result = getDailyNewsCountDAO.getNewsCount(dateString, "socials");
		assertEquals(27, result);
	}
}
