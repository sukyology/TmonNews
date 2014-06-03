package kr.co.tmon.appreview.bo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;

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
public class SelectRatingFlowGraphReviewListBOTest {
	@Autowired
	private SelectRatingFlowGraphReviewListBO selectRatingFlowGraphDataBO;

	@Test
	public void 리뷰리스트를_반환하는것을_확인하는_테스트() throws ParseException {
		assertNotNull(selectRatingFlowGraphDataBO.getSpecificCorpReviewList("2014-06-01", "2014-06-30", "cp"));
	}

}
