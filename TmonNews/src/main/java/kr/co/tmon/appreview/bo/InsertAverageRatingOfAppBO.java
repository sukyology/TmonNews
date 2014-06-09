package kr.co.tmon.appreview.bo;

import java.io.IOException;
import java.util.List;

import kr.co.tmon.appreview.dao.AverageRatingOfAppDAO;
import kr.co.tmon.appreview.model.AverageRatingOfAppModel;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class InsertAverageRatingOfAppBO {
	@Autowired
	private AverageRatingOfAppDAO averageRatingOfAppDAO;

	@Autowired
	private GetAverageRatingBO getAverageRatingBO;

	public void insertAverageRatingOfApp() throws IOException, ParseException {
		List<AverageRatingOfAppModel> averageRatingOfAppList = getAverageRatingBO.ParsingAverageRatingOfApps();

		for (AverageRatingOfAppModel averageRatingOfApp : averageRatingOfAppList)
			averageRatingOfAppDAO.insertAverageRating(averageRatingOfApp);
	}

	public void setAverageRatingOfAppDAO(AverageRatingOfAppDAO averageRatingOfAppDAO) {
		this.averageRatingOfAppDAO = averageRatingOfAppDAO;
	}

	public void setGetAverageRatingBO(GetAverageRatingBO getAverageRatingBO) {
		this.getAverageRatingBO = getAverageRatingBO;
	}
}
