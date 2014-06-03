package kr.co.tmon.appreview.util;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class MonthStringToSpecificDateTest {
	private MonthStringToSpecificDate monthStringToSpecificDate;

	@Before
	public void setup() {
		monthStringToSpecificDate = new MonthStringToSpecificDate();
	}

	@Test
	public void 월의_첫_날짜를_정확히_반환하는지_테스트() {
		String expected = "2014-02-01";
		String testMonthString = "2014-02";

		assertTrue(expected.compareTo(monthStringToSpecificDate.getFirstDayOfMonth(testMonthString)) == 0);
	}

	@Test
	public void 월의_말일을_반환하는지_테스트() {
		String expected = "2014-02-31";
		String testMontString = "2014-02";

		assertTrue(expected.compareTo(monthStringToSpecificDate.getLastDayOfMonth(testMontString)) == 0);

	}
}
