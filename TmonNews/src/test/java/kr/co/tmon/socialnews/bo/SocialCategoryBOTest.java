package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class SocialCategoryBOTest {
	@Test
	public void 바뀐_카테고리로부터_정상적으로_뉴스리스트가_리턴되는지_테스트() {
		SocialCategoryBO socialCategoryBO = mock(SocialCategoryBO.class);
		when(socialCategoryBO.getNewsList(0)).thenReturn(null);
		socialCategoryBO.setNewsDate(new Date(System.currentTimeMillis()));
		socialCategoryBO.setSocialCorpCode("tm");
		List<News> newsList = socialCategoryBO.getNewsList(0);
		assertNull(newsList);
	}
}
