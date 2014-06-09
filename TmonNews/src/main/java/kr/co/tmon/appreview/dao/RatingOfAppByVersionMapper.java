package kr.co.tmon.appreview.dao;

import java.util.List;

import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author 김종환
 *
 */

public interface RatingOfAppByVersionMapper {
	void insertRatingOfAppByVersion(RatingOfAppByVersionModel ratingOfAppByVersion);

	List<RatingOfAppByVersionModel> selectRatingOfAppByVersion(@Param("appName") String appName);
}
