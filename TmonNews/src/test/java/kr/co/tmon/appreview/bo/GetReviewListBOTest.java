package kr.co.tmon.appreview.bo;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import kr.co.tmon.appreview.model.AppReviewModel;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class GetReviewListBOTest {
	@Autowired
	private GetReviewListBO getReviewListBO;

	@Test
	public void appReview_리스트를_정상적으로_리턴하는지_테스트() throws IOException, ParseException, java.text.ParseException {
		List<AppReviewModel> reviewList = getReviewListBO.getAppReviewList();
		assertNotNull(reviewList);
	}

	@Test
	public void appReview리스트에_담긴_값을_확인하는_테스트() throws IOException, ParseException, java.text.ParseException {
		List<AppReviewModel> reviewList = getReviewListBO.getAppReviewList();

		AppReviewModel reviewOne = reviewList.get(0);

		System.out.println(reviewOne.getAppVersion());
		System.out.println(reviewOne.getCorpCode());
		System.out.println(reviewOne.getRating());
		System.out.println(reviewOne.getReviewContext());
		System.out.println(reviewOne.getReviewerID());
		System.out.println(reviewOne.getReviewerLink());
		System.out.println(reviewOne.getReviewLink());
		System.out.println(reviewOne.getReviewTitle());
		System.out.println(reviewOne.getWrittenDate());
	}

	@Test
	public void app리뷰의_content의_길이검증() throws IOException, ParseException, java.text.ParseException {
		List<AppReviewModel> reviewList = getReviewListBO.getAppReviewList();

		for (AppReviewModel appReview : reviewList) {
			System.out.println(appReview.getReviewContext() + ", 길이 : " + appReview.getReviewContext().length());
		}
	}
}
