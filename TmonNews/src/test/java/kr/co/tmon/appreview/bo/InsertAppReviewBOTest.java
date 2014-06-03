package kr.co.tmon.appreview.bo;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class InsertAppReviewBOTest {
	@Autowired
	private InsertAppReviewBO insertAppReviewBO;

	@Transactional
	@Test
	public void 실제로_데이터가_들어가는지_테스트() throws IOException, ParseException, java.text.ParseException {
		insertAppReviewBO.insertReviewList();
	}
}
