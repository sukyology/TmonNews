package kr.co.tmon.appreview.bo;

import java.util.List;

import kr.co.tmon.appreview.dao.RatingOfAppByVersionDAO;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;
import kr.co.tmon.appreview.util.ReorderMonthlyRatingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class RatingOfAppVersionBO {
	@Autowired
	private RatingOfAppByVersionDAO ratingOfAppByVersionDAO;

	public List<RatingOfAppByVersionModel> selectLastestFiveVersionRating(String appName) {
		ReorderMonthlyRatingList reorderMonthlyRatingList = new ReorderMonthlyRatingList();
		List<RatingOfAppByVersionModel> result = ratingOfAppByVersionDAO.selectLastestFiveRatingOfApp(appName);
		return reorderMonthlyRatingList.reorderListOfRatingOfAppVersionModel(result);
	}

	public void setRatingOfAppByVersionDAO(RatingOfAppByVersionDAO ratingOfAppByVersionDAO) {
		this.ratingOfAppByVersionDAO = ratingOfAppByVersionDAO;
	}
}
