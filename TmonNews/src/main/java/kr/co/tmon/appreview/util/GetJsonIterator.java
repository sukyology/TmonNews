package kr.co.tmon.appreview.util;

import java.io.IOException;
import java.util.Iterator;

import kr.co.tmon.appreview.dao.JsonParserDAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author 김종환
 * 
 */

public class GetJsonIterator {
	public Iterator<JSONObject> getReviewArrayIterator(String url, String objectKeyName) throws IOException, org.json.simple.parser.ParseException {
		JsonParserDAO jsonParserDAO = new JsonParserDAO();
		JSONObject jsonObject = jsonParserDAO.getJson(url);
		JSONArray jsonParsedArray = (JSONArray) jsonObject.get(objectKeyName);

		Iterator<JSONObject> arrayIterator = jsonParsedArray.iterator();
		return arrayIterator;
	}
}
