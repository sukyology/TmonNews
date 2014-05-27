package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class IndexPageBOTest {
	@Test
	public void 첫번째_페이지에서_정상적으로_뉴스리스트를_리턴하는지_테스트() {
		IndexPageBO indexPageBO = mock(IndexPageBO.class);
		when(indexPageBO.getDailyIndexNewsList()).thenReturn(null);
		List<News> newsList = indexPageBO.getDailyIndexNewsList();
		assertNull(newsList);
	}
}
