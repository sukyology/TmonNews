package kr.co.tmon.appreview.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import kr.co.tmon.appreview.model.MonthlyAppRatingModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class MonthlyAppRatingDAOTest {
	@Autowired
	private MonthlyAppRatingDAO monthlyAppRatingDAO;

	@Transactional
	@Test
	public void 월간_각_앱별_평균평점_데이터를_정상적으로_삽입하는지_테스트() {
		MonthlyAppRatingModel monthlyAppRating = generateDummyData();
		monthlyAppRatingDAO.insertMonthlyAppRating(monthlyAppRating);
	}

	@Test
	public void 월간_각_앱별_평균평점_데이터를_정상적으로_불러오는지_테스트() {
		List<MonthlyAppRatingModel> result = monthlyAppRatingDAO.selectMonthlyAppRating();
		assertNotNull(result);
		
		System.out.println(result.get(0).getReviewedMonth());
		System.out.println(result.get(0).getCoupangRating());
		
	}

	private MonthlyAppRatingModel generateDummyData() {
		MonthlyAppRatingModel monthlyAppRating = new MonthlyAppRatingModel();

		monthlyAppRating.setCoupangRating((float) 2.47);
		monthlyAppRating.setTmonRating((float) 4.41);
		monthlyAppRating.setWemapRating((float) 3.14);
		monthlyAppRating.setReviewedMonth("2014-07");

		return monthlyAppRating;
	}

}