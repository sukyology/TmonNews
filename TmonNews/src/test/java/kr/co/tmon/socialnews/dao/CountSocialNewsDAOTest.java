package kr.co.tmon.socialnews.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.CountSocialNews;
import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext*.xml"})
public class CountSocialNewsDAOTest {
	@Autowired
	private CountSocialNewsDAO countSocialNewsDAO;
	private CountSocialNews countSocialNews = new CountSocialNews();
	@Before
	public void setTest() {
		countSocialNews = new CountSocialNews();
		countSocialNews.setDate("2014-05-01");
		countSocialNews.setNewsCount(8521);
		countSocialNews.setSocialCorpCode("cp");
	}
	
	@Test
	public void selectTest() {
		List<CountSocialNews> countList = countSocialNewsDAO.selectNewsCount();
		int countTmonNews = countSocialNewsDAO.selectTodayNewsCountForInsert("tm", "2014-06-01");
		System.out.println("count_news table의 갯수 구하기 : "+countList.size());
		System.out.println("TMon news의 갯수 구하기 : "+countTmonNews);
	}

	@Rollback(false)
	@Test
	public void insertTest() {
		List<CountSocialNews> berforeNews = countSocialNewsDAO.selectNewsCount();
		countSocialNewsDAO.insertNews(countSocialNews);
		List<CountSocialNews> afterCount = countSocialNewsDAO.selectNewsCount();
		
		assertEquals(berforeNews.size()+1, afterCount.size());
	}
}