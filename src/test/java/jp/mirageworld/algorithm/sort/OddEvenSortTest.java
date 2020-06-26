package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class OddEvenSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new OddEvenSort().apply(list));
	}
}
