package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.junit.Before;
import org.junit.Test;

public class SocialCategoryBOTest {
	private SocialCategoryBO socialCategoryBO;

	@Before
	public void setup() {
		socialCategoryBO = new SocialCategoryBO();
		socialCategoryBO.setSocialCorpCode("");
		socialCategoryBO.setNewsDate(new Date(2014 - 1900, 4, 21));
	}

	@Test
	public void 첫페이지인_오늘날짜의_전체기사의_리스트가_정상적으로_반환되는지_테스트() {
		List<News> newsList = socialCategoryBO.getNewsList();
		assertNotNull(newsList);
		System.out.println(newsList.get(0).getSocialCorpKoreanName());
	}

	@Test
	public void 카데고리를_전환했을때_정상적으로_반환하는지_테스트() {
		socialCategoryBO.setSocialCorpCode("cp");

		List<News> newsList = socialCategoryBO.getNewsList();
		assertNotNull(newsList);
	}

	@Test
	public void 날짜를_전환했을떄_정상적으로_반환하는지_테스트() {
		socialCategoryBO.setNewsDate(new Date(2014 - 1900, 4, 20));

		List<News> newsList = socialCategoryBO.getNewsList();
		assertNotNull(newsList);
	}
}
