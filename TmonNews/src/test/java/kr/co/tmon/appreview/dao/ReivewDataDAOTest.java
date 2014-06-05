package kr.co.tmon.appreview.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class ReivewDataDAOTest {
	@Autowired
	private ReviewDataDAO reviewDataDAO;
	
	@Test
	public void 티몬_전체평균평점_데이터_확인_테스트() {
		float tmonAvgGrade = reviewDataDAO.SelectTmonAvgGrade();
		String convertedTmonAvgGrade = String.valueOf(tmonAvgGrade);
		
		assertEquals("4.0", convertedTmonAvgGrade);
	}
	
	@Test
	public void 쿠팡_전체평균평점_데이터_확인_테스트() {
		float coupangAvgGrade = reviewDataDAO.SelectCoupangAvgGrade();
		String convertedCoupangAvgGrade = String.valueOf(coupangAvgGrade);
		
		assertEquals("3.9", convertedCoupangAvgGrade);
	}
	
	@Test
	public void 위메프_전체평균평점_데이터_확인_테스트() {
		float wemapAvgGrade = reviewDataDAO.SelectCoupangAvgGrade();
		String convertedwemapAvgGrade = String.valueOf(wemapAvgGrade);
		
		assertEquals("3.9", convertedwemapAvgGrade);
	}
	
	@Test
	public void 티몬플러스_전체평균평점_데이터_확인_테스트() {
		float tmonPlusgAvgGrade = reviewDataDAO.SelectTmonPlusAvgGrade();
		String convertedtmonPlusAvgGrade = String.valueOf(tmonPlusgAvgGrade);
		
		assertEquals("4.1", convertedtmonPlusAvgGrade);
	}

}
