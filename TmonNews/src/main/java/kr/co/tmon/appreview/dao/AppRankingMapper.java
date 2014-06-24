package kr.co.tmon.appreview.dao;

import java.util.List;

import kr.co.tmon.appreview.model.AppRankingModel;

/**
 * 
 * @author 김종환
 * 
 */

public interface AppRankingMapper {
	List<AppRankingModel> selectAppRanking();

}
