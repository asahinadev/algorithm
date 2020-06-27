package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class SmoothSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new SmoothSort().apply(list));
	}
}
