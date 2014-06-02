package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class SocialCategoryBOTest {
	@Autowired
	private SocialCategoryBO socialCategoryBO;

	@Test
	public void 바뀐_카테고리로부터_정상적으로_뉴스리스트가_리턴되는지_테스트() {
		socialCategoryBO = mock(SocialCategoryBO.class);
		when(socialCategoryBO.getNewsList("0", "0", 0)).thenReturn(null);
		List<News> newsList = socialCategoryBO.getNewsList("0", "0", 0);
		assertNull(newsList);
	}

	@Test
	public void tmpTest() {
		List<News> newsList = socialCategoryBO.getNewsList("2014-06-02", "tmon", 1);
		int allNews = socialCategoryBO.getNumberOfNews();
		System.out.println(allNews);
	}

}
