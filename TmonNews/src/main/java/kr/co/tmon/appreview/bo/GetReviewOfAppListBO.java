package kr.co.tmon.appreview.bo;

import java.util.List;

import kr.co.tmon.appreview.dao.SelectAllReviewByAppNameDAO;
import kr.co.tmon.appreview.dao.SelectAppReviewDAO;
import kr.co.tmon.appreview.model.AppReviewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class GetReviewOfAppListBO {
	@Autowired
	private SelectAllReviewByAppNameDAO selectAllReviewByAppNameDAO;

	public List<AppReviewModel> getReviewOfApp(String appName) {
		return selectAllReviewByAppNameDAO.selectAllReviewByAppName(appName);
	}

	public void setSelectAllReviewByAppNameDAO(SelectAllReviewByAppNameDAO selectAllReviewByAppNameDAO) {
		this.selectAllReviewByAppNameDAO = selectAllReviewByAppNameDAO;
	}

}
