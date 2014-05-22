package kr.co.tmon.socialnews.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.junit.Before;
import org.junit.Test;

public class InsertNewsBOTest {
	private InsertNewsBO insertNewsBO;

	@Before
	public void setup() {
		insertNewsBO = new InsertNewsBO();
	}

	@Test
	public void 파싱한_xml이_정상적으로_java_List로_전환되었는지를_확인하는_테스트() {
		
	}

	@Test
	public void DB로_insert명령을_내린_데이터의_숫자가_파싱한_xml의_news_item_숫자와_동일한지_확인하는_테스트() {
		
	}

	@Test
	public void DB에_정상적으로_데이터가_들어갔는지_확인하는_테스트() {
		News news = new News();
		news.setNewsImage("adg");
		news.setNewsLink("asdgasdgaew");
		news.setNewsPreview("asdhuasdhvusa");
		news.setNewsProvider("ausdhg");
		news.setNewsTitle("aodsuhweau");
		news.setNewsDate(new Date(System.currentTimeMillis()));
		
		List<News> parsedNewsList = new ArrayList<>();
		parsedNewsList.add(news);
		insertNewsBO.setParsedNewsList(parsedNewsList);
		insertNewsBO.insertNews();
	}
}
