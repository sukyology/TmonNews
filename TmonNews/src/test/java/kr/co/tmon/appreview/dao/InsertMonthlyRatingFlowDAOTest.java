package kr.co.tmon.appreview.dao;

import static org.junit.Assert.assertNotNull;
import kr.co.tmon.appreview.model.MonthlyRatingFlowModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class InsertMonthlyRatingFlowDAOTest {
	@Autowired
	private InsertMonthlyRatingFlowDAO insertMonthlyRatingFlowDAO;

	@Transactional
	@Test
	public void 월간_평점_데이터가_정상적으로_삽입되는지_알아보는_테스트() {
		MonthlyRatingFlowModel testData = generateSampleDate();

		insertMonthlyRatingFlowDAO.insertMonthlyRatingToDb(testData);
	}

	@Test
	public void 월간_평점_데이터를_정상적으로_select하는지_알아보는_테스트() {
		MonthlyRatingFlowModel monthlyRatingOfCorp = insertMonthlyRatingFlowDAO.selectMonthlyRatingFromDb("2014-05", "cp");
		assertNotNull(monthlyRatingOfCorp);
	}

	private MonthlyRatingFlowModel generateSampleDate() {
		MonthlyRatingFlowModel testData = new MonthlyRatingFlowModel();
		testData.setAppName("1.1.1");
		testData.setAverageRating((float) 3.26);
		testData.setCorpCode("tm");
		testData.setRatingFive(4);
		testData.setRatingFour(3);
		testData.setRatingOne(3);
		testData.setRatingThree(35);
		testData.setRatingTwo(76);
		testData.setReviewedMonth("2014-05");

		return testData;
	}
}
