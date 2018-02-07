package com.pa.helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class OddsHelper {

	/**
	 * Method to convert odds represented as a decimal to
	 * odds represented as a fraction.  This method needs
	 * more work to reduce the fraction to the normal mode
	 * e.g. 25/10 -> 5/2
	 * 
	 * @param decimalOdds odds in decimal mode 3.5
	 * @return the odds in fraction mode 25/10
	 */
	public String convertDecimalToFranctionOdds(String decimalOdds) {
		int numerator = (new BigDecimal(decimalOdds).subtract(new BigDecimal(1))).
				multiply(new BigDecimal(10)).intValue();
		int denominator = (new BigDecimal(1)).multiply(new BigDecimal(10)).intValue();
		
		return numerator + "/" + denominator;
	}
	
	/**
	 * Method to convert odds represented as a fraction to
	 * odds represented as a decimal
	 * 
	 * @param fractionOdds odds in fraction mode 5/2
	 * @return the odds in decimal mode 3.5
	 */
	public String convertFractionToDecimalOdds(String fractionOdds) {
		String[] fractions = StringUtils.split(fractionOdds, "/");
		int numerator = Integer.parseInt(fractions[0]);
		int denominator = Integer.parseInt(fractions[1]);
		BigDecimal fraction = new BigDecimal(numerator).
				divide(new BigDecimal(denominator), 1, RoundingMode.DOWN);
		
		BigDecimal decimalOdd = fraction.add(new BigDecimal(1));
		return decimalOdd.toString();
	}
	
}
