package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

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
public class IndexPageBOTest {
	@Autowired
	private IndexPageBO indexPageBO;

	@Test
	public void 첫번째_페이지에서_정상적으로_뉴스리스트를_리턴하는지_테스트() {
		assertNotNull(indexPageBO.getDailyIndexNewsList());
	}
}
