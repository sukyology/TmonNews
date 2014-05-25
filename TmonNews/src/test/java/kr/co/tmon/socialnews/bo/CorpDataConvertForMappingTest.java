package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class CorpDataConvertForMappingTest {
	private CorpDataConvertForMapping corpDateConvertForMapping;
	private List<News> newsList;

	@Before
	public void setup() {
		corpDateConvertForMapping = new CorpDataConvertForMapping();
	}

	@Test
	public void 정상적으로_중복된_corp가_추가되는지_테스트() {
		makeSampleDate(5);
		newsList.get(0).setNewsSocialCorpCode("tm");
		newsList.get(1).setNewsSocialCorpCode("tm,cp,wmp");
		newsList.get(2).setNewsSocialCorpCode("wmp");
		newsList.get(3).setNewsSocialCorpCode("etc");
		newsList.get(4).setNewsSocialCorpCode("cp");
		
		newsList= corpDateConvertForMapping.divideByCorps(newsList);
		
		assertEquals(7, newsList.size());
		
		for(News news : newsList)
			System.out.println(news.getNewsSocialCorpCode());
	}

	private void makeSampleDate(int numberOfItem) {
		int dailyIndex = 0;
		newsList = new ArrayList<>();
		News news;

		while (dailyIndex < numberOfItem) {
			news = new News();
			news.setNewsCount(0);
			news.setNewsDate(new Date(System.currentTimeMillis()));
			news.setNewsID(100 + dailyIndex);
			news.setNewsImage(Integer.toString(dailyIndex));
			news.setNewsLink(Integer.toString(dailyIndex));
			news.setNewsPreview(Integer.toString(dailyIndex));
			news.setNewsProvider(Integer.toString(dailyIndex));
			news.setNewsTitle(Integer.toString(dailyIndex));

			List<String> corpList = new ArrayList<>();

			if ((dailyIndex % 4) == 0)
				news.setNewsSocialCorpCode("tm");

			else if ((dailyIndex % 4) == 1)
				news.setNewsSocialCorpCode("cp");

			else if ((dailyIndex % 4) == 2)
				news.setNewsSocialCorpCode("wmp");

			else
				news.setNewsSocialCorpCode("etc");

			newsList.add(news);
			dailyIndex++;
		}
	}
}
