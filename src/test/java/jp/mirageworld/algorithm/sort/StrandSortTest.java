package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class StrandSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new BubbleSort().apply(list));
	}
}
