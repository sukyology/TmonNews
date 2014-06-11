package kr.co.tmon.appreview.util;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class ExtractFromJsonTest {
	private ExtractFromJson extractAppReviewListFromJson;

	@Before
	public void setup() {
		extractAppReviewListFromJson = new ExtractFromJson();
	}

	@Test
	public void 최신_일주일_데이터를_받아오는지_확인하는_테스트() throws IOException, ParseException, java.text.ParseException {
		assertNotNull(extractAppReviewListFromJson.getAppReviewListAmongLastestWeek());
	}

	@Test
	public void 특정_날짜를_지정했을때_데이터를_받아오는지_확인하는_테스트() throws IOException, ParseException, java.text.ParseException {
		assertNotNull(extractAppReviewListFromJson.getAppReviewListSpecificDate("2013-03-01", "2013-03-01"));
	}
}
