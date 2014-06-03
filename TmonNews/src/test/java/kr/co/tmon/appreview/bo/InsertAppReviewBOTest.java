package kr.co.tmon.appreview.bo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.appreview.dao.InsertAppReviewDAO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class InsertAppReviewBOTest {
	@Autowired
	private InsertAppReviewBO insertAppReviewBO;

	@Transactional
	@Test
	public void 데이터가_정상적으로_들어가는지_테스트() throws IOException, ParseException, java.text.ParseException {
		List<AppReviewModel> appReviewList = new ArrayList<>();
		AppReviewModel appReview = new AppReviewModel();
		makeTestData(appReview);
		appReviewList.add(appReview);
		appReviewList.add(appReview);
		GetReviewListBO getReviewListBO = mock(GetReviewListBO.class);
		when(getReviewListBO.getAppReviewList()).thenReturn(appReviewList);
		InsertAppReviewDAO insertAppReviewDAO = mock(InsertAppReviewDAO.class);

		insertAppReviewBO.setGetReviewListBO(getReviewListBO);
		insertAppReviewBO.setInsertAppReviewDAO(insertAppReviewDAO);

		verify(insertAppReviewDAO, times(2));
	}
	
	private void makeTestData(AppReviewModel appReview) throws ParseException, java.text.ParseException {
		appReview.setAppVersion("blah");
		appReview.setCorpCode("tm");
		appReview.setRating(50);
		appReview.setReviewContext("blahblahblahblahblahblahblahblahblahblahblahblahblah");
		appReview.setReviewerID("nal_ra");
		appReview.setReviewerLink("aksdjghkadsfg");
		appReview.setReviewLink("asdlgyhasdougyhuahewfhu");
		appReview.setReviewTitle("어쩌구");
		appReview.setAppName("블라블라");

		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = "2014-06-02";

		appReview.setWrittenDate(typeChangeBetweenDateAndString.exchangeToDateType(dateString));
	}
}
