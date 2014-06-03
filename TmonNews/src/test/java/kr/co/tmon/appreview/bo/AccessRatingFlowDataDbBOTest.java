package kr.co.tmon.appreview.bo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;

import kr.co.tmon.appreview.model.MonthlyRatingFlowModel;

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
public class AccessRatingFlowDataDbBOTest {
	@Autowired
	private AccessRatingFlowDataDbBO accessRatingFlowDataDbBO;

	@Test
	public void 월간_데이터를_정상적으로_DB에_insert하는지_확인하는_테스트() throws ParseException {
		MonthlyRatingFlowModel monthlyReview = accessRatingFlowDataDbBO.insertMonthlyRatingAsCorp("2014-05-01", "2014-05-31", "cp");
		assertNotNull(monthlyReview);
	}

}
