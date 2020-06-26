package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class QuickSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new QuickSort().apply(list));
	}
}
