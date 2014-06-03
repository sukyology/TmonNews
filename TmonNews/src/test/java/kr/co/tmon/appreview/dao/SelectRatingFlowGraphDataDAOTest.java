package kr.co.tmon.appreview.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.text.ParseException;

import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class SelectRatingFlowGraphDataDAOTest {
	@Autowired
	private SelectRatingFlowGraphDataDAO selectRatingFlowGraphData;

	@Test
	public void 단일_회사에_대한_실제로_데이터를_받아오는지_테스트() throws ParseException {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		Date startDate = typeChangeBetweenDateAndString.exchangeToDateType("2014-06-01");
		Date endDate = typeChangeBetweenDateAndString.exchangeToDateType("2014-06-30");

		assertNotNull(selectRatingFlowGraphData.selectSpecifyCorpReviews(startDate, endDate, "tm"));
	}

	@Test
	public void 전체회사에_대한_데이터를_실제로_받아오는지_테스트() throws ParseException {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		Date startDate = typeChangeBetweenDateAndString.exchangeToDateType("2014-06-01");
		Date endDate = typeChangeBetweenDateAndString.exchangeToDateType("2014-06-30");

		assertNotNull(selectRatingFlowGraphData.selectAllCorpsReview(startDate, endDate));
	}
}
