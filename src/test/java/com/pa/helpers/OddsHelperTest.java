package com.pa.helpers;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class OddsHelperTest {

	OddsHelper oddsHelper = new OddsHelper();
	
	@Test
	public void shouldConvertToDecimalOdds() {
		String odds = "5/2";
		String decimalOdds = oddsHelper.convertFractionToDecimalOdds(odds);
		
		assertThat(decimalOdds, equalTo("3.5"));
		
		odds = "100/30";
		decimalOdds = oddsHelper.convertFractionToDecimalOdds(odds);
		
		assertThat(decimalOdds, equalTo("4.3"));
	}
	
	@Test
	public void shouldConvertToFractionOdds() {
		String odds = "3.5";
		String decimalOdds = oddsHelper.convertDecimalToFranctionOdds(odds);
		
		assertThat(decimalOdds, equalTo("25/10"));
		
		odds = "4.3";
		decimalOdds = oddsHelper.convertDecimalToFranctionOdds(odds);
		
		assertThat(decimalOdds, equalTo("33/10"));
	}

}
