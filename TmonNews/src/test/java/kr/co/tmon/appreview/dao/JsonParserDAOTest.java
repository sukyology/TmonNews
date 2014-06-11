package kr.co.tmon.appreview.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class JsonParserDAOTest {
	private JsonParserDAO jsonParserDAO;

	@Before
	public void setup() {
		jsonParserDAO = new JsonParserDAO();
	}

	@Test
	public void 정해진_url에서_json_객체를_뽑아내는지_테스트() throws IOException, ParseException {
		JSONObject result = jsonParserDAO.getJson("http://10.5.208.52:8080/social/appReview.tmon");
		assertNotNull(result);
	}

}
