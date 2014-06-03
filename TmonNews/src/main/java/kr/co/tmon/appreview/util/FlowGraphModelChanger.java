package kr.co.tmon.appreview.util;

import java.util.List;

import kr.co.tmon.appreview.model.MonthlyRatingFlowModel;
import kr.co.tmon.appreview.model.RatingFlowGraphModel;

/**
 * 
 * @author 김종환
 *
 * metadata인 MonthlyRatingFlowModel을 만들기 위해 List를 받아서 메타데이터를 생성하는 클래스
 *
 */

public class FlowGraphModelChanger {
	public MonthlyRatingFlowModel generateMetadataForSaveItToDb(List<RatingFlowGraphModel> reviewList) {
		MonthlyRatingFlowModel metadataOfRatingFlow = new MonthlyRatingFlowModel();
		int sumOfRating = 0;
		int numberOfReview = reviewList.size();

		sumOfRating = examRatingAsAReview(reviewList, metadataOfRatingFlow, sumOfRating);

		metadataOfRatingFlow.setCorpCode(reviewList.get(0).getCorpCode());
		metadataOfRatingFlow.setAverageRating(calculateAverageRating(sumOfRating, numberOfReview));
		metadataOfRatingFlow.setReviewList(reviewList);
		metadataOfRatingFlow.setAppName(reviewList.get(0).getAppName());
		setReviewMonthForMetadata(reviewList, metadataOfRatingFlow);

		return metadataOfRatingFlow;
	}

	private float calculateAverageRating(int sumOfRating, int numberOfReview) {
		return (float) sumOfRating / (float) numberOfReview;
	}

	private void setReviewMonthForMetadata(List<RatingFlowGraphModel> reviewList, MonthlyRatingFlowModel metadataOfRatingFlow) {
		SubstringForYearPlusMonth substringForYearPlusMonth = new SubstringForYearPlusMonth();
		metadataOfRatingFlow.setReviewedMonth(substringForYearPlusMonth.substringOfDate(reviewList.get(0).getWrittenDate()));
	}

	private int examRatingAsAReview(List<RatingFlowGraphModel> reviewList, MonthlyRatingFlowModel metadataOfRatingFlow, int sumOfRating) {
		for (RatingFlowGraphModel review : reviewList) {
			if (review.getRating() == 1)
				metadataOfRatingFlow.setRatingOne(metadataOfRatingFlow.getRatingOne() + 1);

			else if (review.getRating() == 2)
				metadataOfRatingFlow.setRatingTwo(metadataOfRatingFlow.getRatingTwo() + 1);

			else if (review.getRating() == 3)
				metadataOfRatingFlow.setRatingThree(metadataOfRatingFlow.getRatingThree() + 1);

			else if (review.getRating() == 4)
				metadataOfRatingFlow.setRatingFour(metadataOfRatingFlow.getRatingFour() + 1);

			else
				metadataOfRatingFlow.setRatingFive(metadataOfRatingFlow.getRatingFive() + 1);

			sumOfRating += review.getRating();
		}
		return sumOfRating;
	}

}
