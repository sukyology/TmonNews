package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;

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
		socialCategoryBO.setNewsDate(new Date(System.currentTimeMillis()));
		socialCategoryBO.setSocialCorpCode("tm");

		assertNotNull(socialCategoryBO.getNewsList(1));
	}
}
