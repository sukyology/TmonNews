package kr.co.tmon.appreview.bo;

import java.util.List;

import kr.co.tmon.appreview.dao.SelectRatingByVersionDAO;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class GetRatingOfAppByVersionBO {
	@Autowired
	private SelectRatingByVersionDAO selectRatingByVersionDAO;

	@Autowired
	private InsertRatingOfAppByVersionBO insertRatingOfAppByVersionBO;

	public List<RatingOfAppByVersionModel> getRatingOfAppByVersion(String appName) {
		insertRatingOfAppByVersionBO.renewAppRatingDataByVersion();
		return selectRatingByVersionDAO.selectRatingListByAppName(appName);
	}

	public void setSelectRatingByVersionDAO(SelectRatingByVersionDAO selectRatingByVersionDAO) {
		this.selectRatingByVersionDAO = selectRatingByVersionDAO;
	}

	public void setInsertRatingOfAppByVersionBO(InsertRatingOfAppByVersionBO insertRatingOfAppByVersionBO) {
		this.insertRatingOfAppByVersionBO = insertRatingOfAppByVersionBO;
	}

}
