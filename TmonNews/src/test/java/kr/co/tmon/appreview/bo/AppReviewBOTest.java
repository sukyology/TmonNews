package kr.co.tmon.appreview.bo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.appreview.dao.AppReviewDAO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.util.ExtractFromJson;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class AppReviewBOTest {
	private AppReviewBO appReviewBO;

	@Before
	public void setup() {
		appReviewBO = new AppReviewBO();
	}

	@Test
	public void 데이터의_주어진_리스트의_개수만큼_인서트가_정확히_일어나는지_확인하는_테스트() throws IOException, ParseException, java.text.ParseException {
		ExtractFromJson extractFromJson = mock(ExtractFromJson.class);
		List<AppReviewModel> mockedList = generateSampleData();
		AppReviewDAO mockedAppReviewDAO = mock(AppReviewDAO.class);
		appReviewBO.setAppReviewDAO(mockedAppReviewDAO);
		when(extractFromJson.getAppReviewListAmongLastestWeek()).thenReturn(mockedList);
		List<AppReviewModel> lastestReviewData = extractFromJson.getAppReviewListAmongLastestWeek();

		appReviewBO.insertLastestReview();
		verify(mockedAppReviewDAO, times(3));
	}

	private List<AppReviewModel> generateSampleData() {
		List<AppReviewModel> mockedList = new ArrayList<>();
		AppReviewModel appReviewModel = new AppReviewModel();

		mockedList.add(appReviewModel);
		mockedList.add(appReviewModel);
		mockedList.add(appReviewModel);

		return mockedList;
	}
}
