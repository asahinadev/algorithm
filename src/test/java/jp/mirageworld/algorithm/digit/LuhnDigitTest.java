package jp.mirageworld.algorithm.digit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LuhnDigitTest {

	@ParameterizedTest
	@ValueSource(strings = {
			"4000000000000010",
			"4000000000000028",
			"4000000000000036",
			"5100000000000016",
			"4000000000000010011",
			"4000000000000028011",
			"4000000000000036011",
			"5100000000000016011",
	})
	public void okT(String cardNumber) {
		assertTrue(new LuhnDigit().apply(cardNumber));
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"5100000000000017",
			"5100000000000017011"
	})
	public void ngT(String cardNumber) {
		assertFalse(new LuhnDigit().apply(cardNumber));
	}
}
