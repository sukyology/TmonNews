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

public class GetJsonIteratorTest {
	private GetJsonIterator getJsonIterator;

	@Before
	public void setup() {
		getJsonIterator = new GetJsonIterator();
	}

	@Test
	public void 이터레이터를_정상적으로_반환하는지_확인하는_테스트() throws IOException, ParseException {
		assertNotNull(getJsonIterator.getReviewArrayIterator("http://10.5.208.52:8080/social/appReview.tmon", "reviewList"));
	}
}
