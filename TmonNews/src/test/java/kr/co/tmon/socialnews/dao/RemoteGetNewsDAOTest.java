package kr.co.tmon.socialnews.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class RemoteGetNewsDAOTest {
	@Autowired
	private RemoteGetNewsDAO remoteGetNewsDAO;

	@Test
	public void 오늘날짜에_맞게_정상적으로_get메소드의_패러미터를_생성하는지_테스트() {
		System.out.println(remoteGetNewsDAO.generateTodayUrl());
	}


}
