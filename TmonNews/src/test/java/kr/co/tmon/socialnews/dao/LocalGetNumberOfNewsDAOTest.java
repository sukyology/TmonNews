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
public class LocalGetNumberOfNewsDAOTest {
	@Autowired
	private LocalGetNumberOfNewsDAO getDailyNewsCountDAO;

	@Test
	public void 정확한_뉴스리스트의_카운트를_리턴하는지_테스트() {
		String dateString = "2014-05-28";
		int result = getDailyNewsCountDAO.getNumberOfNews(dateString, "socials");
		assertEquals(36, result);
	}

	@Test
	public void 각각의_조건이_들어갔을때_그에_맞는_뉴스갯수를_리턴하는지_테스트() {
		Date date = new Date(System.currentTimeMillis());
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String currentDate = typeChangeBetweenDateAndString.exchangeToStringType(date);
		String socialCorp = "cp";
		String dateString = "2014-05-28";

		int resultOfChangeDate = getDailyNewsCountDAO.getNumberOfNews(dateString, "socials");
		int resultOfCorpChange = getDailyNewsCountDAO.getNumberOfNews(currentDate, socialCorp);
		int resultOfDualParameterChange = getDailyNewsCountDAO.getNumberOfNews(dateString, socialCorp);

		System.out.println(resultOfChangeDate);
		System.out.println(resultOfCorpChange);
		System.out.println(resultOfDualParameterChange);
	}
}
