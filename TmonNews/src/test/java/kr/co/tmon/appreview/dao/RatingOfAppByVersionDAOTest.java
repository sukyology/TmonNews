package kr.co.tmon.appreview.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

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
public class RatingOfAppByVersionDAOTest {
	@Autowired
	private RatingOfAppByVersionDAO ratingOfAppByVersionDAO;

	@Transactional
	@Test
	public void 데이터가_정상적으로_들어가는지_테스트() {
		RatingOfAppByVersionModel ratingOfAppByVersion = generateSampleData();
		ratingOfAppByVersionDAO.insertRatingOfAppByVersion(ratingOfAppByVersion);
	}

	@Test
	public void 최신_5개버전의_평점_데이터를_반환하는지_테스트() {
		List<RatingOfAppByVersionModel> result = ratingOfAppByVersionDAO.selectLastestFiveRatingOfApp("쿠팡");
		assertEquals(12, result.size());

		for (RatingOfAppByVersionModel ratingOfApp : result)
			System.out.println(ratingOfApp.getAppVersion());
	}

	private RatingOfAppByVersionModel generateSampleData() {
		RatingOfAppByVersionModel ratingOfAppByVersionModel = new RatingOfAppByVersionModel();

		ratingOfAppByVersionModel.setAppName("티몬");
		ratingOfAppByVersionModel.setAppVersion("1.1.1");
		ratingOfAppByVersionModel.setAverageRating((float) 4.3);
		ratingOfAppByVersionModel.setRatingFive(1);
		ratingOfAppByVersionModel.setRatingTwo(2);
		ratingOfAppByVersionModel.setRatingOne(5);
		ratingOfAppByVersionModel.setRatingFour(11);
		ratingOfAppByVersionModel.setRatingThree(3);

		return ratingOfAppByVersionModel;
	}
}
