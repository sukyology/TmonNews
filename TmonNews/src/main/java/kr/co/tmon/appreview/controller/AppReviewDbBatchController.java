package kr.co.tmon.appreview.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.annotation.PostConstruct;

import kr.co.tmon.appreview.bo.AppReviewBO;
import kr.co.tmon.appreview.bo.MonthlyAppRatingBO;
import kr.co.tmon.appreview.bo.RatingOfAppVersionBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 김종환
 * 
 */
@Component
public class AppReviewDbBatchController {
	@Autowired
	private AppReviewBO appReviewBO;

	@Autowired
	private RatingOfAppVersionBO ratingOfAppVersionBO;

	@Autowired
	private MonthlyAppRatingBO monthlyAppRatingBO;

	@PostConstruct
	@Scheduled(fixedDelay = 43200000)
	public void runAppReviewDbUpdateBatch() throws IOException, org.json.simple.parser.ParseException, ParseException {
		appReviewBO.insertLastestReview();
		ratingOfAppVersionBO.insertAppRatingData();
		monthlyAppRatingBO.insertCurrentMonthAppRating();
	}

}
