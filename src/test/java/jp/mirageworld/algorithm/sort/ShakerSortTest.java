package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class ShakerSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new ShakerSort().apply(list));
	}
}
