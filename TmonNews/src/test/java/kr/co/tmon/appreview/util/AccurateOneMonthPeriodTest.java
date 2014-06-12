package kr.co.tmon.appreview.util;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import kr.co.tmon.socialnews.util.DateCalculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class AccurateOneMonthPeriodTest {
	private AccurateOneMonthPeriod accurateOneMonthPeriod;

	@Before
	public void setup() {
		accurateOneMonthPeriod = new AccurateOneMonthPeriod();
	}

	@Test
	public void 한달전_날짜를_반환하는지_테스트() {
		System.out.println(accurateOneMonthPeriod.returnOneMonthAgoDate());
	}
}
