package kr.co.tmon.socialnews.dao;

import static org.junit.Assert.assertFalse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class LocalInsertNewsDAOTest {
	@Autowired
	private LocalInsertNewsDAO insertDailyNewsDAO;
	@Autowired
	private LocalGetNewsDAO getNewsDAO;
	
	private News news;
	private List<News> newsList;

	@Transactional
	@Test
	public void 여러개의_뉴스데이터가_주어졌을때_전체적인_insert프로세스가_정상적으로_작동하는지_확인하는_테스트() {
		makeSampleDate(100);
		insertDailyNewsDAO.insertNews(newsList);
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String newsDateString = typeChangeBetweenDateAndString.exchangeToStringType(new Date(System.currentTimeMillis()));
		List<News> result = getNewsDAO.getNewsList(newsDateString, "socials", 1);
		assertFalse(result.isEmpty());
	}

	private void makeSampleDate(int numberOfItem) {
		int dailyIndex = 0;
		newsList = new ArrayList<>();

		while (dailyIndex < numberOfItem) {
			Date date = new Date(System.currentTimeMillis());

			news = new News();
			news.setNewsCount(0);
			news.setNewsDate(date);
			news.setNewsID(dailyIndex);
			news.setNewsImage(Integer.toString(dailyIndex));
			news.setNewsLink(Integer.toString(dailyIndex));
			news.setNewsPreview(Integer.toString(dailyIndex));
			news.setNewsProvider(Integer.toString(dailyIndex));
			news.setNewsTitle("가나다라마바사");

			if ((dailyIndex % 2) == 0)
				news.setNewsSocialCorpCode("티켓몬스터");

			else if ((dailyIndex % 3) == 0)
				news.setNewsSocialCorpCode("쿠팡");

			else if ((dailyIndex % 5) == 0)
				news.setNewsSocialCorpCode("위메프");

			else if ((dailyIndex % 7) == 0)
				news.setNewsSocialCorpCode("티켓몬스터,쿠팡");

			else
				news.setNewsSocialCorpCode("기타");

			newsList.add(news);
			dailyIndex++;
		}
	}

}
