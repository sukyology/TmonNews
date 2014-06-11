package kr.co.tmon.appreview.bo;

import java.io.IOException;

import kr.co.tmon.appreview.dao.RatingOfAppDAO;
import kr.co.tmon.appreview.model.RatingOfAppModel;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 *
 */

@Service
public class RatingOfAppBO {
	@Autowired
	private RatingOfAppDAO ratingOfAppDAO;
	
	public RatingOfAppModel getRatingOfApp() throws IOException, ParseException {
		return ratingOfAppDAO.selectRatingOfApp();
	}
}
