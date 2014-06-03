package kr.co.tmon.appreview.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.appreview.bo.GetReviewListBO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

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
public class InsertAppReviewDAOTest {
	@Autowired
	private InsertAppReviewDAO insertAppReviewDAO;

	@Transactional
	@Test
	public void 제대로_뉴스를_인서트하는지_테스트() throws ParseException {
		List<AppReviewModel> appReviewList = new ArrayList<>();
		AppReviewModel appReview = new AppReviewModel();

		makeTestData(appReview);

		appReviewList.add(appReview);
		appReviewList.add(appReview);

		insertAppReviewDAO.insertAppReviewList(appReviewList);

	}


	private void makeTestData(AppReviewModel appReview) throws ParseException {
		appReview.setAppVersion("blah");
		appReview.setCorpCode("tm");
		appReview.setRating(50);
		appReview.setReviewContext("blahblahblahblahblahblahblahblahblahblahblahblahblah");
		appReview.setReviewerID("nal_ra");
		appReview.setReviewerLink("aksdjghkadsfg");
		appReview.setReviewLink("asdlgyhasdougyhuahewfhu");
		appReview.setReviewTitle("어쩌구");

		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = "2014-06-02";

		appReview.setWrittenDate(typeChangeBetweenDateAndString.exchangeToDateType(dateString));
	}
}
