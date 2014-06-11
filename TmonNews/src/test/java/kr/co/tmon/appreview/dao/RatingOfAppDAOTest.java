package kr.co.tmon.appreview.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import kr.co.tmon.appreview.model.RatingOfAppModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class RatingOfAppDAOTest {
	@Autowired
	private RatingOfAppDAO ratingOfAppDAO;

	@Test
	public void 제대로_평점데이터를_가져오는지_테스트() {
		RatingOfAppModel ratingOfApp = ratingOfAppDAO.selectRatingOfApp();
		assertNotNull(ratingOfApp);

		System.out.println(ratingOfApp.getTmonplusRating());
	}

}
