package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class MageSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new MageSort().apply(list));
	}
}
