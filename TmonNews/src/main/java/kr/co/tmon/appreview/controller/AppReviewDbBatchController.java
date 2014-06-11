package kr.co.tmon.appreview.controller;

import java.io.IOException;
import java.text.ParseException;

import kr.co.tmon.appreview.bo.AppReviewBO;
import kr.co.tmon.appreview.bo.MonthlyAppRatingBO;
import kr.co.tmon.appreview.bo.RatingOfAppVersionBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * 
 * @author 김종환
 * 
 */
@Controller
public class AppReviewDbBatchController {
	@Autowired
	private AppReviewBO appReviewBO;

	@Autowired
	private RatingOfAppVersionBO ratingOfAppVersionBO;

	@Autowired
	private MonthlyAppRatingBO monthlyAppRatingBO;

	public void runAppReviewDbUpdateBatch() throws IOException, org.json.simple.parser.ParseException, ParseException {
		monthlyAppRatingBO.insertMonthlyAppRating("2014-06");
	}

}
