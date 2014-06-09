package kr.co.tmon.appreview.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.annotation.PostConstruct;

import kr.co.tmon.appreview.bo.InsertAppReviewBO;
import kr.co.tmon.appreview.bo.InsertAverageRatingOfAppBO;
import kr.co.tmon.appreview.bo.InsertRatingOfAppByVersionBO;
import kr.co.tmon.appreview.bo.UpdateNumberOfAppReviewBO;

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
	private InsertAppReviewBO insertAppReviewBO;
	
	@PostConstruct
	@Scheduled(fixedDelay = 43200000)
	public void runAppReviewDbUpdateBatch() throws IOException, org.json.simple.parser.ParseException, ParseException {
		insertAppReviewBO.insertReviewList();
		
	}

}
