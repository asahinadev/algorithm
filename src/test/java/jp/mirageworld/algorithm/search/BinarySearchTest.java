package jp.mirageworld.algorithm.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BinarySearchTest
		extends AbstractSearchTest {

	@ParameterizedTest
	@ValueSource(ints = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19
	})
	public void test(Integer test) {
		searchTest(list, test > 15 ? test - 1 : test, new BinarySearch().apply(list, test));
	}

	@ParameterizedTest
	@ValueSource(ints = {
			20, 15, -1
	})
	public void testNg(Integer test) {
		searchTest(list, -1, new BinarySearch().apply(list, test));
	}

	@ParameterizedTest
	@ValueSource(ints = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19
	})
	public void container(Integer test) {
		searchTest(list, true, new BinarySearch().check(list, test));
	}

	@ParameterizedTest
	@ValueSource(ints = {
			20, 15, -1
	})
	public void containerNg(Integer test) {
		searchTest(list, false, new BinarySearch().check(list, test));
	}

}
