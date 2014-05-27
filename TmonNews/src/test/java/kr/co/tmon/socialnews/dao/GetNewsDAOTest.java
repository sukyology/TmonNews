package kr.co.tmon.socialnews.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Date;

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
public class GetNewsDAOTest {
	@Autowired
	private GetNewsDAO getNewsDAO;

	@Test
	public void 당일_날짜의_전체_뉴스리스트를_정상적으로_불러오는지_확인하는_테스트() {
		assertNotNull(getNewsDAO.getNewsList(new Date(System.currentTimeMillis()), "socials", 1));
	}
}
