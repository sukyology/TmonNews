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
	@Test
	public void setTest() {
		countSocialNews = new CountSocialNews();
		countSocialNews.setDate("2014-06-11");
		countSocialNews.setNewsCount(8521);
		countSocialNews.setSocialCorpCode("cp");
	}

}