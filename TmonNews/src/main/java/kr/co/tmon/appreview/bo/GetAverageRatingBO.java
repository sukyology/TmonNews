package kr.co.tmon.appreview.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.co.tmon.appreview.dao.JsonParserDAO;
import kr.co.tmon.appreview.model.AverageRatingOfAppModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 *
 */

@Service
public class GetAverageRatingBO {
	private static String appReviewsUrl = "http://10.5.220.81:8080/social/appReview.tmon";

	@Autowired
	private JsonParserDAO jsonParserDAO;

	public List<AverageRatingOfAppModel> ParsingAverageRatingOfApps() throws IOException, ParseException {
		Iterator<JSONObject> arrayIterator = getArrayIterator();
		List<AverageRatingOfAppModel> ratingList = new ArrayList<>();
		
		while (arrayIterator.hasNext()) {
			AverageRatingOfAppModel averageRatingOfApp = bindIteratorToModel(arrayIterator.next());
			ratingList.add(averageRatingOfApp);
		}

		return ratingList;
	}

	private AverageRatingOfAppModel bindIteratorToModel(JSONObject next) {
		AverageRatingOfAppModel averageRatingOfApp = new AverageRatingOfAppModel();

		String appName = (String) next.get("appName");
		averageRatingOfApp.setAppName(appName);

		String corpCode = notifyCorpCode(appName);
		averageRatingOfApp.setCorpCode(corpCode);
		
		float rating = castingFloatForInsertData(next);
		averageRatingOfApp.setRating(rating);

		return averageRatingOfApp;
	}

	private float castingFloatForInsertData(JSONObject next) {
		String ratingString = (String) next.get("averageScore");
		float rating = Float.valueOf(ratingString);
		return rating;
	}

	private String notifyCorpCode(String appName) {
		String corpCode = "";

		if (appName.compareTo("티몬") == 0 || appName.compareTo("티몬플러스") == 0)
			corpCode = "tm";

		else if (appName.compareTo("쿠팡") == 0)
			corpCode = "cp";

		else if (appName.compareTo("위메프") == 0)
			corpCode = "wmp";
		
		return corpCode;
	}

	private Iterator<JSONObject> getArrayIterator() throws IOException, ParseException {
		JSONObject jsonObject = jsonParserDAO.getJson(appReviewsUrl);
		JSONArray jsonParsedArray = (JSONArray) jsonObject.get("scoreList");

		Iterator<JSONObject> arrayIterator = jsonParsedArray.iterator();
		return arrayIterator;
	}

	public void setJsonParserDAO(JsonParserDAO jsonParserDAO) {
		this.jsonParserDAO = jsonParserDAO;
	}

}
