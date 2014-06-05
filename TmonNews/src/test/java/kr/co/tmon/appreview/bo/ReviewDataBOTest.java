package kr.co.tmon.appreview.bo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class ReviewDataBOTest {

	@Test
	public void testSelectTmonAvgGrade() throws Exception {
		ReviewDataBO reviewDataBO = mock(ReviewDataBO.class);
		String TmonAvgGrade = String.valueOf(reviewDataBO.selectTmonAvgGrade());
		assertNotNull(TmonAvgGrade);
	}

	@Test
	public void testSelectCoupangAvgGrade() throws Exception {
		ReviewDataBO reviewDataBO = mock(ReviewDataBO.class);
		String CoupangAvgGrade = String.valueOf(reviewDataBO.selectCoupangAvgGrade());
		assertNotNull(CoupangAvgGrade);
	}

	@Test
	public void testSelectWemapAvgGrade() throws Exception {
		ReviewDataBO reviewDataBO = mock(ReviewDataBO.class);
		String WemapAvgGrade = String.valueOf(reviewDataBO.selectWemapAvgGrade());
		assertNotNull(WemapAvgGrade);
	}

	@Test
	public void testSelectTmonPlusAvgGrade() throws Exception {
		ReviewDataBO reviewDataBO = mock(ReviewDataBO.class);
		String TmonPlusAvgGrade = String.valueOf(reviewDataBO.selectTmonPlusAvgGrade());
		assertNotNull(TmonPlusAvgGrade);
	}

}
