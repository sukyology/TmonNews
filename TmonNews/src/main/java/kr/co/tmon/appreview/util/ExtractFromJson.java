package kr.co.tmon.appreview.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.co.tmon.appreview.dao.JsonParserDAO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.model.RatingOfAppModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author 김종환
 * 
 */

public class ExtractFromJson {
	private static String APP_REVIEW_URL = "http://10.5.208.52:8080/social/appReview.tmon";
	private static final String APP_NAME_OF_TMON = "티몬";
	private static final String APP_NAME_OF_TMONPLUS = "티몬플러스";
	private static final String APP_NAME_OF_WEMAP = "위메프";
	private static final String APP_NAME_OF_COUPANG = "쿠팡";
	private static final String KEY_NAME_OF_SCORE_LIST = "scoreList";
	private static final String KEY_NAME_OF_REVIEW_LIST = "reviewList";

	private GetJsonIterator getJsonIterator;

	public List<AppReviewModel> getAppReviewListAmongLastestWeek() throws IOException, org.json.simple.parser.ParseException, ParseException, java.text.ParseException {
		getJsonIterator = new GetJsonIterator();
		Iterator<JSONObject> arrayIterator = getJsonIterator.getReviewArrayIterator(APP_REVIEW_URL, KEY_NAME_OF_REVIEW_LIST);
		JsonParsedObjectToAppReview jsonParsedObjectToAppReview = new JsonParsedObjectToAppReview();
		List<AppReviewModel> appReviewList = new ArrayList<>();

		while (arrayIterator.hasNext()) {
			AppReviewModel appReview = jsonParsedObjectToAppReview.bindIteratorToModel(arrayIterator.next());
			appReviewList.add(appReview);
		}

		return appReviewList;
	}

	public List<AppReviewModel> getAppReviewListSpecificDate(String startDate, String endDate) throws IOException, ParseException, java.text.ParseException, org.json.simple.parser.ParseException {
		getJsonIterator = new GetJsonIterator();
		String url = APP_REVIEW_URL + "?startDate=" + startDate + "&endDate=" + endDate;
		JsonParsedObjectToAppReview jsonParsedObjectToAppReview = new JsonParsedObjectToAppReview();
		Iterator<JSONObject> arrayIterator = getJsonIterator.getReviewArrayIterator(url, KEY_NAME_OF_REVIEW_LIST);

		List<AppReviewModel> appReviewList = new ArrayList<>();

		while (arrayIterator.hasNext()) {
			AppReviewModel appReview = jsonParsedObjectToAppReview.bindIteratorToModel(arrayIterator.next());
			appReviewList.add(appReview);
		}

		return appReviewList;
	}

	public RatingOfAppModel getRatingOfApp() throws IOException, org.json.simple.parser.ParseException {
		getJsonIterator = new GetJsonIterator();
		Iterator<JSONObject> scoreArrayIterator = getJsonIterator.getReviewArrayIterator(APP_REVIEW_URL, KEY_NAME_OF_SCORE_LIST);

		RatingOfAppModel ratingOfApp = new RatingOfAppModel();

		while (scoreArrayIterator.hasNext()) {
			JSONObject jsonObject = scoreArrayIterator.next();
			getAverageRating(ratingOfApp, jsonObject);
		}

		return ratingOfApp;
	}

	private void getAverageRating(RatingOfAppModel ratingOfApp, JSONObject jsonObject) {
		if (APP_NAME_OF_COUPANG.compareTo((String) jsonObject.get("appName")) == 0)
			ratingOfApp.setCoupangRating(Float.valueOf((String) jsonObject.get("averageScore")));
		else if (APP_NAME_OF_WEMAP.compareTo((String) jsonObject.get("appName")) == 0)
			ratingOfApp.setWemapRating(Float.valueOf((String) jsonObject.get("averageScore")));
		else if (APP_NAME_OF_TMON.compareTo((String) jsonObject.get("appName")) == 0)
			ratingOfApp.setTmonRating(Float.valueOf((String) jsonObject.get("averageScore")));
		else if (APP_NAME_OF_TMONPLUS.compareTo((String) jsonObject.get("appName")) == 0)
			ratingOfApp.setTmonplusRating(Float.valueOf((String) jsonObject.get("averageScore")));
	}

}
