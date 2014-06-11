package kr.co.tmon.appreview.bo;

import java.io.IOException;

import kr.co.tmon.appreview.model.RatingOfAppModel;
import kr.co.tmon.appreview.util.ExtractFromJson;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 *
 */

@Service
public class RatingOfAppBO {
	public RatingOfAppModel getRatingOfApp() throws IOException, ParseException {
		ExtractFromJson extractFromJson = new ExtractFromJson();
		return extractFromJson.getRatingOfApp();
	}
}
