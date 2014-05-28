package kr.co.tmon.socialnews.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.model.ParsedNews;

import org.junit.Before;
import org.junit.Test;

public class NewsModelConvertAdapterTest {
	private NewsModelConvertAdapter newsModelConvertAdapter;
	private List<ParsedNews> xmlParsedNews;

	@Before
	public void setup() {
		newsModelConvertAdapter = new NewsModelConvertAdapter();
		xmlParsedNews = createTestXmlParsedData();
	}

	@Test
	public void 파싱데이터를_DB뉴스리스트로_정상적으로_변환하는지_테스트() throws ParseException {
		List<News> convertedNewsList = newsModelConvertAdapter.convertToNewsListForDB(xmlParsedNews);
		assertNotNull(convertedNewsList);
		
		for(News news : convertedNewsList)
			System.out.println(news.getNewsID());
	}

	@Test
	public void newsID를_설정하는_메소드_테스트() {
		int expected = 140528003;
		int result = newsModelConvertAdapter.setNewsId(new Date(System.currentTimeMillis()), 3);

		assertEquals(expected, result);
	}

	private List<ParsedNews> createTestXmlParsedData() {
		ArrayList<ParsedNews> parsedNewsData = new ArrayList<>();
		ParsedNews parsedNews = new ParsedNews();

		parsedNews.setDate("2014-05-28");
		parsedNews.setImage("blah");
		parsedNews.setLink("blahblah");
		parsedNews.setPreview("blahblahblah");
		parsedNews.setProvider("blahblahblahblah");
		parsedNews.setSocialName("티켓몬스터");
		parsedNews.setTitle("어쩌구저쩌구어쨌든");

		for (int index = 0; index < 5; index++)
			parsedNewsData.add(parsedNews);
		
		return parsedNewsData;
	}

}
