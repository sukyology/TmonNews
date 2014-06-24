package kr.co.tmon.appreview.dao;

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
public class AppRankingDAOTest {
	@Autowired
	private AppRankingDAO appRankingDAO;

	@Test
	public void 정상적으로_리스트를_받아오는지_테스트() {
		assertNotNull(appRankingDAO.selectAppRanking());
	}
}
