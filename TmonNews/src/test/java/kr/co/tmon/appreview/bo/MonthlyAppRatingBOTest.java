package kr.co.tmon.appreview.bo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.text.ParseException;

import kr.co.tmon.appreview.dao.AppReviewDAO;
import kr.co.tmon.appreview.dao.MonthlyAppRatingDAO;
import kr.co.tmon.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.appreview.util.MonthStringToSpecificDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class MonthlyAppRatingBOTest {
	private MonthlyAppRatingBO monthlyAppRatingBO;

	@Before
	public void setup() {
		monthlyAppRatingBO = new MonthlyAppRatingBO();
	}

	@Test
	public void review테이블에서_셀렉트한_값을_monthlyRating테이블에_인서트하는_작업을_확인하는_테스트() throws ParseException {
		String monthString = "2014-06";
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();

		Date startDate = monthStringToSpecificDate.getFirstDayOfMonthForDateType("2014-06");
		Date endDate = monthStringToSpecificDate.getLastDayOfMonthForDateType("2014-06");

		MonthlyAppRatingModel sampleModel = generateSampleData();
		AppReviewDAO mockedAppReviewDAO = mock(AppReviewDAO.class);
		MonthlyAppRatingDAO mockedMonthlyAppRatingDAO = mock(MonthlyAppRatingDAO.class);
		when(mockedAppReviewDAO.selectMonthlyAppRating(monthString, startDate, endDate)).thenReturn(sampleModel);

		monthlyAppRatingBO.setAppReviewDAO(mockedAppReviewDAO);
		monthlyAppRatingBO.setMonthlyAppRatingDAO(mockedMonthlyAppRatingDAO);

		monthlyAppRatingBO.insertMonthlyAppRating(monthString);
		verify(mockedMonthlyAppRatingDAO, times(1));
	}

	private MonthlyAppRatingModel generateSampleData() {
		MonthlyAppRatingModel sample = new MonthlyAppRatingModel();

		sample.setCoupangRating(0);
		sample.setTmonRating(0);
		sample.setWemapRating(0);
		sample.setReviewedMonth("2014-06");

		return sample;
	}

}
