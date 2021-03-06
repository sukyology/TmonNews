package kr.co.tmon.appreview.bo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.text.ParseException;

import kr.co.tmon.appreview.dao.AppReviewDAO;
import kr.co.tmon.appreview.model.NumberOfAppReviewModel;
import kr.co.tmon.appreview.util.AccurateOneMonthPeriod;
import kr.co.tmon.appreview.util.SubstringForYearPlusMonth;

import org.junit.Before;
import org.junit.Test;

public class AppReviewBOTest {
	private AppReviewBO appReviewBO;

	@Before
	public void setup() {
		appReviewBO = new AppReviewBO();
	}

	@Test
	public void 앱리뷰숫자를_가져오는_명령이_제대로_동작하는지_테스트() throws ParseException {
		AppReviewDAO appReviewDAO = mock(AppReviewDAO.class);
		AccurateOneMonthPeriod accurateOneMonthPeriod = new AccurateOneMonthPeriod();
		Date startDate = accurateOneMonthPeriod.returnOneMonthAgoDate();
		Date endDate = accurateOneMonthPeriod.returnCurrentDate();

		NumberOfAppReviewModel numberOfAppReviewModel = new NumberOfAppReviewModel();
		numberOfAppReviewModel.setMonthString("11");
		numberOfAppReviewModel.setNumberOfCoupangAppReview(1);
		numberOfAppReviewModel.setNumberOfTmonAppReview(4);
		numberOfAppReviewModel.setNumberOfTmonplusAppReview(5);
		numberOfAppReviewModel.setNumberOfWemapAppReview(3);

		when(appReviewDAO.selectNumberOfAppReview(getCurrentMonthString(), startDate, endDate)).thenReturn(numberOfAppReviewModel);
		appReviewBO.setAppReviewDAO(appReviewDAO);
		assertEquals(appReviewBO.getNumberOfAppReview(), null);
	}

	private String getCurrentMonthString() {
		Date currentDate = new Date(System.currentTimeMillis());
		SubstringForYearPlusMonth substringForYearPlusMonth = new SubstringForYearPlusMonth();

		return substringForYearPlusMonth.substringOfDate(currentDate);
	}
}
