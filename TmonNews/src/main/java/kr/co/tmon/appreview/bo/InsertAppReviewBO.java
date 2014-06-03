package kr.co.tmon.appreview.bo;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tmon.appreview.dao.InsertAppReviewDAO;
import kr.co.tmon.appreview.model.AppReviewModel;

/**
 * 
 * @author 김종환
 *
 * JSON으로 파싱된 데이터를 DB에 집어넣는 역할을 수행하는 BO
 *
 */

@Service
public class InsertAppReviewBO {
	@Autowired
	private InsertAppReviewDAO insertAppReviewDAO;
	
	@Autowired
	private GetReviewListBO getReviewListBO;

	public void insertReviewList() throws IOException, ParseException, java.text.ParseException {
		List<AppReviewModel> appReviewList = getReviewListBO.getAppReviewList();
		insertAppReviewDAO.insertAppReviewList(appReviewList);
	}

	public void setInsertAppReviewDAO(InsertAppReviewDAO insertAppReviewDAO) {
		this.insertAppReviewDAO = insertAppReviewDAO;
	}

	public void setGetReviewListBO(GetReviewListBO getReviewListBO) {
		this.getReviewListBO = getReviewListBO;
	}
}
