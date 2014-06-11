package kr.co.tmon.appreview.bo;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.appreview.dao.AppReviewDAO;
import kr.co.tmon.appreview.dao.RatingOfAppByVersionDAO;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

import org.junit.Before;
import org.junit.Test;

public class RatingOfAppVersionBOTest {
	private RatingOfAppVersionBO ratingOfAppVersionBO;

	@Before
	public void setup() {
		ratingOfAppVersionBO = new RatingOfAppVersionBO();
	}

	@Test
	public void 최근_12개의_월간_리뷰_평점을_받아오는지_테스트() {
		RatingOfAppByVersionDAO ratingOfAppByVersionDAO = mock(RatingOfAppByVersionDAO.class);
		List<RatingOfAppByVersionModel> ratingOfAppByVersionModels = new ArrayList<>();
		when(ratingOfAppByVersionDAO.selectLastestFiveRatingOfApp("티몬")).thenReturn(ratingOfAppByVersionModels);
		ratingOfAppVersionBO.setRatingOfAppByVersionDAO(ratingOfAppByVersionDAO);

		assertNotNull(ratingOfAppVersionBO.selectLastestFiveVersionRating("티몬"));
	}

}
