package kr.co.tmon.socialnews.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.*;

import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class NewsCountDAOTest {
	@Autowired
	private NewsCountDAO newsCountDAO;
	@Autowired
	private LocalGetNewsDAO getNewsDAO;

	@Transactional
	@Test
	public void countTest() {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = typeChangeBetweenDateAndString.exchangeToStringType(new Date(System.currentTimeMillis()));
		List<News> newsList = getNewsDAO.getNewsList(dateString, "socials", 1);
		News news = newsList.get(0);
		int newsId = news.getNewsID();
		int currentCount = news.getNewsCount();

		newsCountDAO.updateNewsCount(newsId);

		newsList = getNewsDAO.getNewsList(dateString, "socials", 1);
		news = newsList.get(0);
		int afterExcuteQueryCount = news.getNewsCount();

		assertEquals(currentCount + 1, afterExcuteQueryCount);

	}

}
