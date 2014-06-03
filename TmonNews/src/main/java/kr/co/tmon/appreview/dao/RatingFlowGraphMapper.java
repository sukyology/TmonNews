package kr.co.tmon.appreview.dao;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.appreview.model.RatingFlowGraphModel;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author 김종환
 *
 *	Rating flow그래프를 위해 데이터베이스에서 review데이터를 불러오는 매퍼클래스 
 *
 */

public interface RatingFlowGraphMapper {
	List<RatingFlowGraphModel> selectRatingFlowData(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("corpCode") String corpCode);
	List<RatingFlowGraphModel> selectAllCorpRatingFlowDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
