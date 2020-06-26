package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class CombSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new CombSort().apply(list));
	}
}
