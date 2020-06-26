package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class SelectSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new SelectSort().apply(list));
	}
}
