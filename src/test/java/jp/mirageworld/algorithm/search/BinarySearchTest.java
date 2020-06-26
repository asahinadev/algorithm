package jp.mirageworld.algorithm.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BinarySearchTest
		extends AbstractSearchTest {

	@ParameterizedTest
	@ValueSource(ints = {
			1, 2, 3, 4, 5, 6, 7, 8, 9, 0
	})
	public void test(Integer test) {
		searchTest(list, test, new BinarySearch().apply(list, test));
	}

	public void test() {
		searchTest(list, -1, new BinarySearch().apply(list, 11));
	}

	@ParameterizedTest
	@ValueSource(ints = {
			1, 2, 3, 4, 5, 6, 7, 8, 9, 0
	})
	public void container(Integer test) {
		searchTest(list, true, new BinarySearch().check(list, test));
	}

	public void container() {
		searchTest(list, false, new BinarySearch().check(list, 11));
	}

}
