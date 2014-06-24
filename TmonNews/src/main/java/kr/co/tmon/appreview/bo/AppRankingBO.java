package kr.co.tmon.appreview.bo;

import java.util.List;

import kr.co.tmon.appreview.dao.AppRankingDAO;
import kr.co.tmon.appreview.model.AppRankingModel;
import kr.co.tmon.appreview.util.ReorderMonthlyRatingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class AppRankingBO {
	@Autowired
	private AppRankingDAO appRankingDAO;

	public List<AppRankingModel> getAppRankingFlow() {
		List<AppRankingModel> lastestList = appRankingDAO.selectAppRanking();
		ReorderMonthlyRatingList reorderMonthlyRatingList = new ReorderMonthlyRatingList();

		lastestList = reorderMonthlyRatingList.reorderListOfAppRanking(lastestList);

		return lastestList;
	}

}
