package kr.co.tmon.socialnews.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class LocalGetNewsDAOTest {
	@Autowired
	private LocalGetNewsDAO getNewsDAO;

	@Test
	public void 당일_날짜의_전체_뉴스리스트를_정상적으로_불러오는지_확인하는_테스트() {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = typeChangeBetweenDateAndString.exchangeToStringType(new Date(2014 - 1900, 4, 30));
		assertNotNull(getNewsDAO.getNewsList(dateString, "socials", 1));
	}

	@Test
	public void 뉴스데이터가_정상적으로_담기는지_확인하는_테스트() {
		String dateString = "2014-06-02";

		List<News> newsList = getNewsDAO.getNewsList(dateString, "cp", 1);
		News news = newsList.get(0);

		System.out.println(news.getNewsCount());
		System.out.println(news.getNewsID());
		System.out.println(news.getNewsImage());
		System.out.println(news.getNewsLink());
		System.out.println(news.getNewsPreview());
		System.out.println(news.getNewsProvider());
		System.out.println(news.getNewsSocialCorpCode());
		System.out.println(news.getNewsTitle());
		System.out.println(news.getNewsDate());

	}
}
