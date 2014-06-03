package kr.co.tmon.appreview.util;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;

import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class SubstringForYearPlusMonthTest {
	private SubstringForYearPlusMonth substringForYearPlusMonth;
	
	@Before
	public void setup()
	{
		substringForYearPlusMonth = new SubstringForYearPlusMonth();
	}
	
	@Test
	public void 제대로된_날짜가_잘려_나오는지_테스트() throws ParseException
	{
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = "2014-06-02";
		
		String subedString = substringForYearPlusMonth.substringOfDate(typeChangeBetweenDateAndString.exchangeToDateType(dateString));
		System.out.println(subedString);
	}

}
