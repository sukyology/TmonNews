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
	public void 네개의_앱에_대하여_중복이나_루프없이_insert를_수행하는지_테스트() {
		AppReviewDAO mockedAppReviewDAO = mock(AppReviewDAO.class);
		RatingOfAppByVersionDAO mockedRatingOfAppByVersionDAO = mock(RatingOfAppByVersionDAO.class);

		List<RatingOfAppByVersionModel> mockedList = new ArrayList<>();

		when(mockedAppReviewDAO.selectAppRatingByVersion("티몬")).thenReturn(mockedList);
		when(mockedAppReviewDAO.selectAppRatingByVersion("쿠팡")).thenReturn(mockedList);
		when(mockedAppReviewDAO.selectAppRatingByVersion("위메프")).thenReturn(mockedList);
		when(mockedAppReviewDAO.selectAppRatingByVersion("티몬플러스")).thenReturn(mockedList);
		
		ratingOfAppVersionBO.setAppReviewDAO(mockedAppReviewDAO);
		ratingOfAppVersionBO.setRatingOfAppByVersionDAO(mockedRatingOfAppByVersionDAO);

		ratingOfAppVersionBO.insertAppRatingData();
		verify(mockedRatingOfAppByVersionDAO, times(4));
	}

}
