package kr.co.tmon.appreview.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.co.tmon.appreview.dao.JsonParserDAO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.socialnews.util.ConvertCorpNameToCode;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 *
 * 1팀의 url에서 가져온 JSONObject를 리뷰 리스트로 치환하는 BO
 *
 */

@Service
public class GetReviewListBO {
	private static String appReviewsUrl = "http://10.5.220.81:8080/social/appReview.tmon";

	private JsonParserDAO jsonParser;

	public List<AppReviewModel> getAppReviewList() throws IOException, ParseException, java.text.ParseException {
		Iterator<JSONObject> arrayIterator = getArrayIterator();

		List<AppReviewModel> appReviewList = new ArrayList<>();

		while (arrayIterator.hasNext()) {
			AppReviewModel appReview = bindIteratorToModel(arrayIterator.next());
			appReviewList.add(appReview);
		}

		return appReviewList;
	}

	private Iterator<JSONObject> getArrayIterator() throws IOException, ParseException {
		jsonParser = new JsonParserDAO();
		JSONObject jsonObject = jsonParser.getJson(appReviewsUrl);
		JSONArray jsonParsedArray = (JSONArray) jsonObject.get("reviewList");

		Iterator<JSONObject> arrayIterator = jsonParsedArray.iterator();
		return arrayIterator;
	}
	
	private AppReviewModel bindIteratorToModel(JSONObject parsedObject) throws java.text.ParseException {
		AppReviewModel appModel = new AppReviewModel();

		appModel.setAppVersion((String) parsedObject.get("androidAppVersion"));
		appModel.setReviewContext((String) parsedObject.get("reviewContent"));
		appModel.setReviewerID((String) parsedObject.get("userName"));
		appModel.setReviewerLink((String) parsedObject.get("userLink"));
		appModel.setReviewLink((String) parsedObject.get("reviewLink"));
		appModel.setReviewTitle((String) parsedObject.get("reviewTitle"));
		appModel.setAppName((String) parsedObject.get("androidAppName"));

		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = (String) parsedObject.get("reviewDate");
		appModel.setWrittenDate(typeChangeBetweenDateAndString.exchangeToDateType(dateString));

		String ratingString = (String) parsedObject.get("starScore");
		appModel.setRating(Integer.parseInt(ratingString));
		
		ConvertCorpNameToCode convertCorpNameToCode = new ConvertCorpNameToCode();
		appModel.setCorpCode(convertCorpNameToCode.corpNameToCode((String) parsedObject.get("companyName")));

		return appModel;
	}
}
