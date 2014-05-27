package kr.co.tmon.socialnews.util;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class TypeChangeBetweenDateAndStringTest {
	private TypeChangeBetweenDateAndString typeChangeBetweenDateAndString;

	@Before
	public void setup() {
		typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
	}

	@Test
	public void date타입을_올바르게_SQL문에서_사용하는_String스타일로_리턴하는지_테스트() {
		Date date = new Date(2014 - 1900, 4, 26);
		String dateExpressedSqlStyle = typeChangeBetweenDateAndString.exchangeToStringType(date);
		assertTrue(dateExpressedSqlStyle.compareTo("2014-05-26") == 0);
	}
}
