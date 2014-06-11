package kr.co.tmon.appreview.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.appreview.model.NumberOfAppReviewModel;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;
import kr.co.tmon.appreview.util.MonthStringToSpecificDate;

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
public class AppReviewDAOTest {
	@Autowired
	private AppReviewDAO appReviewDAO;

	@Test
	public void 정상적으로_review리스트를_선택하는지_테스트() {
		List<AppReviewModel> result = appReviewDAO.selectAppReview("티몬", 0);
		assertNotNull(result);
	}

	@Test
	public void 월별_뉴스의_개수를_올바르게_반환하는지_테스트() throws ParseException {
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();

		Date startDate = monthStringToSpecificDate.getFirstDayOfMonthForDateType("2014-06");
		Date endDate = monthStringToSpecificDate.getLastDayOfMonthForDateType("2014-06");
		NumberOfAppReviewModel numberOfAppReview = appReviewDAO.selectNumberOfAppReview("2014-06", startDate, endDate);
		assertNotNull(numberOfAppReview);
	}

	@Test
	public void 월별_평점을_반환하는지_테스트() throws ParseException {
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();

		Date startDate = monthStringToSpecificDate.getFirstDayOfMonthForDateType("2014-06");
		Date endDate = monthStringToSpecificDate.getLastDayOfMonthForDateType("2014-06");
		MonthlyAppRatingModel monthlyAppRatingModel = appReviewDAO.selectMonthlyAppRating("2014-06", startDate, endDate);
		assertNotNull(monthlyAppRatingModel);

		System.out.println(monthlyAppRatingModel.getReviewedMonth());
	}

	private AppReviewModel generateSampleData() {
		AppReviewModel appReviewModel = new AppReviewModel();
		appReviewModel.setAppName("티몬");
		appReviewModel.setAppVersion("5.5.5");
		appReviewModel.setCorpCode("tm");
		appReviewModel.setRating(3);
		appReviewModel.setReviewContext("어쩌고");
		appReviewModel.setReviewerID("nal_ra");
		appReviewModel.setReviewerLink("asd,lfjhasdk");
		appReviewModel.setReviewTitle("blah");
		appReviewModel.setReviewLink("asdkljghfuasdgf");
		appReviewModel.setWrittenDate(new Date(System.currentTimeMillis()));

		return appReviewModel;
	}
}
