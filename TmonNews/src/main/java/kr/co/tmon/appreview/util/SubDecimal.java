package kr.co.tmon.appreview.util;

/**
 * 
 * @author 김종환
 *
 */

public class SubDecimal {
	public float subDecimalFromOriginalFloat(float originalFloat) {
		float changedFloat = (float) (Math.round(originalFloat * 100d) / 100d);
		return changedFloat;
	}

}
